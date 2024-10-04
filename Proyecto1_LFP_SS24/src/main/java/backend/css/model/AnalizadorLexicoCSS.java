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
    private String codigoTraducido = "";

    public AnalizadorLexicoCSS() {
        this.funsionTransicion = new ControladorFunsionTransicionCSS();
        this.isArchivoLeido = false;
        this.alfabetoController = new ControladorAlfabetoCSS();
        this.palabraTemporal = new StringBuilder();
        this.estadoAceptacion = new ControladorEstadoAceptacionCSS();
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getCodigoTraducido() {
        return codigoTraducido;
    }

    public void setCodigoTraducido(String codigoTraducido) {
        this.codigoTraducido = codigoTraducido;
    }

    public void leerContenido(String contenido) {
        this.contenido = new String(contenido.getBytes());
        this.isArchivoLeido = true;
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
                this.codigoTraducido += "\n";
                continue;
            }
            if (this.alfabetoController.isEspacioBlanco(this.contenido.charAt(this.posicionContenido))) {
                this.posicionContenido++;
                this.columna++;
                this.codigoTraducido += " ";
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
                this.codigoTraducido += "\r";
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
                this.codigoTraducido += "\n";
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
        return switch (palabra.toLowerCase()) {
            case "body", "header", "main", "nav", "aside", "div", "ul", "ol", "li", "a", "h1", "h2", "h3", "h4", "h5", "h6", "p", "span", "label", "textarea", "button", "section", "article", "footer" -> TipoTokenEnumCSS.ETIQUETA_TIPO;
            default -> null;
        };
    }

    private TipoTokenEnumCSS revisarRegla(String palabra) {
        return switch (palabra.toLowerCase()) {
            case "color", "background-color", "background", "font-size", "font-weight", "font-family", "font-align", "width", "height", "min-width", "min-height", "max-width", "max-height", "display", "inline", "block", "inline-block", "flex", "grid", "none", "margin", "border", "padding", "content", "border-color", "border-style", "border-width", "border-top", "border-bottom", "border-left", "border-right", "box-sizing", "border-box", "position", "static", "relative", "absolute", "sticky", "fixed", "top", "bottom", "left", "right", "z-index", "justify-content", "align-items", "border-radius", "auto", "float", "list-style", "text-align", "box-shadow" -> TipoTokenEnumCSS.REGLA;
            default -> null;
        };
    }

    private TipoTokenEnumCSS revisarOtros(String palabra) {
        return switch (palabra.toLowerCase()) {
            case "px", "%", "rem", "em", "vw", "vh", ":hover", ":active", ":not()", ":nth-child()", "odd", "even", "::before", "::after", ":", ";", ",", "(", ")", "=", "[", "]", "\"" -> TipoTokenEnumCSS.OTROS;
            default -> null;
        };
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
                if (token.getTipoToken() != TipoTokenEnumCSS.ERROR) {
                    this.codigoTraducido += token.getLexema();
                }
            }
        } catch (IOException e) {
            System.out.println("----------------ERROR---------------------");
        }
        System.out.println();
        return tokensAnalizados;
    }

}
