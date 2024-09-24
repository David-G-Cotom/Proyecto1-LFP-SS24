/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.model;

import backend.css.controller.ControladorAlfabetoCSS;
import backend.css.controller.ControladorEstadoAceptacionCSS;
import backend.css.controller.ControladorFunsionTransicionCSS;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class AnalizadorLexicoCSS {

    private final ControladorFunsionTransicionCSS funsionTransicion;
    private int linea;
    private int columna;
    private int posicionContenido;
    private String contenido;
    private boolean isArchivoLeido;
    private final ControladorAlfabetoCSS alfabetoController;
    private StringBuilder palabraTemporal;
    private final ControladorEstadoAceptacionCSS estadoAceptacion;
    private ArrayList<TokenCSS> tokensAnalizados;

    public AnalizadorLexicoCSS() {
        this.funsionTransicion = new ControladorFunsionTransicionCSS();
        this.isArchivoLeido = false;
        this.alfabetoController = new ControladorAlfabetoCSS();
        this.palabraTemporal = new StringBuilder();
        this.estadoAceptacion = new ControladorEstadoAceptacionCSS();
    }

    public void leerContenido(String contenido) {
        this.contenido = new String(contenido.getBytes());
        this.isArchivoLeido = true;
        this.linea = 0;
        this.columna = 0;
        this.posicionContenido = 0;
    }

    public boolean isFinArchivo() throws IOException {
        if (!isArchivoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();
        return this.posicionContenido >= this.contenido.length();
    }

    private void ignorarEspaciosBlanco() {
        while (this.posicionContenido < this.contenido.length()) {
            if (this.alfabetoController.isNuevaLinea(this.contenido.charAt(this.posicionContenido))) {
                this.posicionContenido++;
                this.linea++;
                this.columna = 0;
                continue;
            }
            if (this.alfabetoController.isEspacioBlanco(this.contenido.charAt(this.posicionContenido))) {
                this.posicionContenido++;
                this.columna++;
                continue;
            }
            break;
        }
    }

    public TokenCSS getToken() throws IOException {
        if (!isArchivoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();
        this.palabraTemporal = new StringBuilder();
        EstadoEnumCSS estadoActual = this.funsionTransicion.getESTADO_INICIAL();
        char charActual;
        EstadoEnumCSS estadoTemporal = estadoActual;
        AlfabetoEnumCSS alfabetoSimbolo;
        int lineaInicial = this.linea;
        int columnaInicial = this.columna;
        do {
            estadoActual = estadoTemporal;
            //System.out.println("Estado Actual: " + estadoActual);
            charActual = contenido.charAt(this.posicionContenido);
            //System.out.println("Caracter Actual: " + charActual);
            if (charActual == '\r') {
                break;
            }
            alfabetoSimbolo = this.alfabetoController.getAlfabeto(charActual);
            //System.out.println("Alfabeto Simbolo: " + alfabetoSimbolo);
            estadoTemporal = this.funsionTransicion.produccion(estadoActual, alfabetoSimbolo);
            //System.out.println("Estado Temporal: " + estadoTemporal);
            if (estadoTemporal.equals(EstadoEnumCSS.SF)) {
                break;
            }
            this.columna++;
            this.posicionContenido++;
            this.palabraTemporal.append(charActual);
            if (alfabetoSimbolo == AlfabetoEnumCSS.NUEVA_LINEA) {
                this.linea++;
            }
            if (estadoTemporal.equals(EstadoEnumCSS.SE)) {
                break;
            }
        } while (this.posicionContenido < this.contenido.length());
        if (estadoTemporal.equals(EstadoEnumCSS.SE)) {
            estadoActual = estadoTemporal;
        }
        if (estadoActual == EstadoEnumCSS.S1) {
            if (this.revisarEtiquetaTipo(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.ETIQUETA_TIPO, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else if (this.revisarRegla(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.REGLA, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else if (this.revisarOtros(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.OTROS, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.IDENTIFICADOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoActual == EstadoEnumCSS.S2) {
            if (this.revisarEtiquetaTipo(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.ETIQUETA_TIPO, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.IDENTIFICADOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoActual == EstadoEnumCSS.S4) {
            if (this.revisarRegla(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.REGLA, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.IDENTIFICADOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoActual == EstadoEnumCSS.S24 || estadoActual == EstadoEnumCSS.S25) {
            if (this.revisarClase(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.CLASE, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else if (this.revisarColor(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.COLOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.ID, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoActual == EstadoEnumCSS.S27) {
            if (this.revisarClase(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.CLASE, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.ID, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoActual == EstadoEnumCSS.S37) {
            if (this.revisarColor(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.COLOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.ERROR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoActual == EstadoEnumCSS.S31 || estadoActual == EstadoEnumCSS.S32) {
            if (this.revisarOtros(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.OTROS, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.ERROR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoActual == EstadoEnumCSS.S36) {
            if (this.revisarCadena(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.CADENA, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.OTROS, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if ((this.palabraTemporal.length() == 1) && (this.posicionContenido == this.contenido.length()) && (estadoTemporal == EstadoEnumCSS.S1)) {
            if (this.revisarEtiquetaTipo(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.ETIQUETA_TIPO, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.IDENTIFICADOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (((this.palabraTemporal.length() == 1) && (this.posicionContenido == this.contenido.length()))
                || (estadoTemporal == EstadoEnumCSS.S22) || (estadoTemporal == EstadoEnumCSS.S29)
                || (estadoTemporal == EstadoEnumCSS.S30) || (estadoTemporal == EstadoEnumCSS.S31)
                || (estadoTemporal == EstadoEnumCSS.S39) || (estadoTemporal == EstadoEnumCSS.S45)) {
            return new TokenCSS(this.estadoAceptacion.getTipoToken(estadoTemporal), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if ((estadoTemporal == EstadoEnumCSS.S36) && (charActual == '\'')) {
            if (this.palabraTemporal.toString().endsWith("]'")) {
                return new TokenCSS(TipoTokenEnumCSS.OTROS, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.CADENA, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if ((estadoTemporal == EstadoEnumCSS.S14) && (charActual == ')')) {
            return new TokenCSS(TipoTokenEnumCSS.COLOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if (estadoTemporal == EstadoEnumCSS.S24) {
            if (this.revisarClase(this.palabraTemporal.toString()) != null) {
                return new TokenCSS(TipoTokenEnumCSS.CLASE, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                return new TokenCSS(TipoTokenEnumCSS.ID, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            }
        }
        if (estadoTemporal == EstadoEnumCSS.S44) {
            return new TokenCSS(this.estadoAceptacion.getTipoToken(estadoTemporal), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        return new TokenCSS(this.estadoAceptacion.getTipoToken(estadoActual), lineaInicial, columnaInicial, this.palabraTemporal.toString());
    }

    private TipoTokenEnumCSS revisarEtiquetaTipo(String palabra) {
        switch (palabra.toLowerCase()) {
            case "body":
            case "header":
            case "main":
            case "nav":
            case "aside":
            case "div":
            case "ul":
            case "ol":
            case "li":
            case "a":
            case "h1":
            case "h2":
            case "h3":
            case "h4":
            case "h5":
            case "h6":
            case "p":
            case "span":
            case "label":
            case "textarea":
            case "button":
            case "section":
            case "article":
            case "footer":
                return TipoTokenEnumCSS.ETIQUETA_TIPO;
            default:
                return null;
        }
    }

    private TipoTokenEnumCSS revisarRegla(String palabra) {
        switch (palabra.toLowerCase()) {
            case "color":
            case "background-color":
            case "background":
            case "font-size":
            case "font-weight":
            case "font-family":
            case "font-align":
            case "width":
            case "height":
            case "min-width":
            case "min-height":
            case "max-width":
            case "max-height":
            case "display":
            case "inline":
            case "block":
            case "inline-block":
            case "flex":
            case "grid":
            case "none":
            case "margin":
            case "border":
            case "padding":
            case "content":
            case "border-color":
            case "border-style":
            case "border-width":
            case "border-top":
            case "border-bottom":
            case "border-left":
            case "border-right":
            case "box-sizing":
            case "border-box":
            case "position":
            case "static":
            case "relative":
            case "absolute":
            case "sticky":
            case "fixed":
            case "top":
            case "bottom":
            case "left":
            case "right":
            case "z-index":
            case "justify-content":
            case "align-items":
            case "border-radius":
            case "auto":
            case "float":
            case "list-style":
            case "text-align":
            case "box-shadow":
                return TipoTokenEnumCSS.REGLA;
            default:
                return null;
        }
    }

    private TipoTokenEnumCSS revisarOtros(String palabra) {
        switch (palabra.toLowerCase()) {
            case "px":
            case "%":
            case "rem":
            case "em":
            case "vw":
            case "vh":
            case ":hover":
            case ":active":
            case ":not()":
            case ":nth-child()":
            case "odd":
            case "even":
            case "::before":
            case "::after":
            case ":":
            case ";":
            case ",":
            case "(":
            case ")":
                return TipoTokenEnumCSS.OTROS;
            default:
                return null;
        }
    }

    private TipoTokenEnumCSS revisarColor(String palabra) {
        if (palabra.length() == 4 || palabra.length() == 7) {
            try {
                Color.decode(palabra);
                return TipoTokenEnumCSS.COLOR;
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    private TipoTokenEnumCSS revisarClase(String palabra) {
        if (palabra.startsWith(".")) {
            return TipoTokenEnumCSS.CLASE;
        } else {
            return null;
        }
    }

    private TipoTokenEnumCSS revisarID(String palabra) {
        if (palabra.startsWith("#")) {
            return TipoTokenEnumCSS.CLASE;
        } else {
            return null;
        }
    }

    private TipoTokenEnumCSS revisarCadena(String palabra) {
        if (!palabra.startsWith("'[")) {
            return TipoTokenEnumCSS.CADENA;
        } else {
            return null;
        }
    }

    public ArrayList<TokenCSS> getTokens(String contenido) {
        this.tokensAnalizados = new ArrayList<>();
        this.leerContenido(contenido);
        try {
            while (!this.isFinArchivo()) {
                TokenCSS token = this.getToken();
                tokensAnalizados.add(token);
                System.out.println(token);
            }
        } catch (IOException e) {
            System.out.println("----------------ERROR---------------------");
        }
        System.out.println();
        return tokensAnalizados;
    }

}
