/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.model;

import backend.html.controller.ControladorAlfabetoHTML;
import backend.html.controller.ControladorEstadoAceptacionHTML;
import backend.html.controller.ControladorFunsionTransicionHTML;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class AnalizadorLexicoHTML {

    private final ControladorFunsionTransicionHTML funsionTransicion;
    private int linea;
    private int columna;
    private int posicionContenido;
    private String contenido;
    private boolean isArchivoLeido;
    private final ControladorAlfabetoHTML alfabetoController;
    private StringBuilder palabraTemporal;
    private final ControladorEstadoAceptacionHTML estadoAceptacion;
    private ArrayList<TokenHTML> tokensAnalizados;
    private String codigoTraducido = "";

    public AnalizadorLexicoHTML() {
        this.funsionTransicion = new ControladorFunsionTransicionHTML();
        this.isArchivoLeido = false;
        this.alfabetoController = new ControladorAlfabetoHTML();
        this.palabraTemporal = new StringBuilder();
        this.estadoAceptacion = new ControladorEstadoAceptacionHTML();
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

    public String getCodigoTraducido() {
        return codigoTraducido;
    }

    public void setCodigoTraducido(String codigoTraducido) {
        this.codigoTraducido = codigoTraducido;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void leerArchivo(String contenido) {
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

    public TokenHTML getToken() throws IOException {
        if (!isArchivoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();
        this.palabraTemporal = new StringBuilder();
        EstadoEnumHTML estadoActual = this.funsionTransicion.getEstadoInicial();
        char charActual;
        EstadoEnumHTML estadoTemporal = estadoActual;
        AlfabetoEnumHTML alfabetoSimbolo;
        int lineaInicial = this.linea;
        int columnaInicial = this.columna;
        do {
            if (!this.tokensAnalizados.isEmpty()) {
                if (this.tokensAnalizados.get(this.tokensAnalizados.size() - 1).getTipoToken() == TipoTokenEnumHTML.CIERRE) {
                    return this.getTokenTexto();
                }
            }
            estadoActual = estadoTemporal;
            //System.out.println("Estado Actual: " + estadoActual);
            charActual = this.contenido.charAt(this.posicionContenido);
            //System.out.println("Caracter Actual: " + charActual);
            if (charActual == '\r') {
                this.codigoTraducido += "\r";
                break;
            }
            alfabetoSimbolo = this.alfabetoController.getAlfabeto(charActual);
            //System.out.println("Alfabeto Simbolo: " + alfabetoSimbolo);
            estadoTemporal = this.funsionTransicion.produccion(estadoActual, alfabetoSimbolo);
            //System.out.println("Estado Temporal: " + estadoTemporal);
            if (estadoTemporal.equals(EstadoEnumHTML.SF)) {
                break;
            }
            this.columna++;
            this.posicionContenido++;
            this.palabraTemporal.append(charActual);
            if (alfabetoSimbolo == AlfabetoEnumHTML.NUEVA_LINEA) {
                this.codigoTraducido += "\n";
                this.linea++;
            }
            if (estadoTemporal.equals(EstadoEnumHTML.SE)) {
                break;
            }
        } while (this.posicionContenido < this.contenido.length());
        if (estadoTemporal.equals(EstadoEnumHTML.SE)) {
            estadoActual = estadoTemporal;
        }
        if (this.revisarPalabraReservada(this.palabraTemporal.toString()) != null) {
            return new TokenHTML(revisarPalabraReservada(this.palabraTemporal.toString()), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if (this.revisarEtiqueta(this.palabraTemporal.toString()) != null) {
            return new TokenHTML(revisarEtiqueta(this.palabraTemporal.toString()), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if (this.revisarEtiquetaTitulo(this.palabraTemporal.toString()) != null) {
            return new TokenHTML(revisarEtiquetaTitulo(this.palabraTemporal.toString()), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if (((this.palabraTemporal.length() == 1) && (this.posicionContenido == this.contenido.length()))
                || (estadoTemporal == EstadoEnumHTML.S1) || (estadoTemporal == EstadoEnumHTML.S2)
                || (estadoTemporal == EstadoEnumHTML.S3) || (estadoTemporal == EstadoEnumHTML.S7)
                || (estadoTemporal == EstadoEnumHTML.S9)) {
            return new TokenHTML(this.estadoAceptacion.getTipoToken(estadoTemporal), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        return new TokenHTML(this.estadoAceptacion.getTipoToken(estadoActual), lineaInicial, columnaInicial, this.palabraTemporal.toString());
    }

    private TokenHTML getTokenTexto() throws IOException {
        //System.out.println();
        //System.out.println("EN TOKEN TEXTO");
        if (!isArchivoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();
        this.palabraTemporal = new StringBuilder();
        EstadoEnumHTML estadoActual = EstadoEnumHTML.S10;
        char charActual;
        EstadoEnumHTML estadoTemporal = estadoActual;
        AlfabetoEnumHTML alfabetoSimbolo;
        int lineaInicial = this.linea;
        int columnaInicial = this.columna;
        do {
            estadoActual = estadoTemporal;
            //System.out.println("Estado Actual: " + estadoActual);
            charActual = this.contenido.charAt(this.posicionContenido);
            //System.out.println("Caracter Actual: " + charActual);
            if (charActual == '\r') {
                this.codigoTraducido += "\r";
                break;
            }
            alfabetoSimbolo = this.alfabetoController.getAlfabeto(charActual);
            //System.out.println("Alfabeto Simbolo: " + alfabetoSimbolo);
            estadoTemporal = this.funsionTransicion.produccion(estadoActual, alfabetoSimbolo);
            //System.out.println("Estado Temporal: " + estadoTemporal);
            if (alfabetoSimbolo == AlfabetoEnumHTML.DIAGONAL && estadoTemporal.equals(EstadoEnumHTML.SF)) {
                this.posicionContenido--;
                this.palabraTemporal.deleteCharAt(this.palabraTemporal.length() - 1);
                if (this.palabraTemporal.isEmpty()) {
                    estadoTemporal = EstadoEnumHTML.S0;
                    continue;
                }
            }
            if (estadoTemporal.equals(EstadoEnumHTML.SF)) {
                break;
            }
            this.columna++;
            this.posicionContenido++;
            this.palabraTemporal.append(charActual);
            if (alfabetoSimbolo == AlfabetoEnumHTML.NUEVA_LINEA) {
                this.linea++;
            }
            if (estadoTemporal.equals(EstadoEnumHTML.SE)) {
                break;
            }
        } while (this.posicionContenido < this.contenido.length());
        if (estadoTemporal.equals(EstadoEnumHTML.SE)) {
            estadoActual = estadoTemporal;
        }
        if (((this.palabraTemporal.length() == 1) && (this.posicionContenido == this.contenido.length()))
                || (estadoTemporal == EstadoEnumHTML.S1) || (estadoTemporal == EstadoEnumHTML.S2)
                || (estadoTemporal == EstadoEnumHTML.S3) || (estadoTemporal == EstadoEnumHTML.S7)
                || (estadoTemporal == EstadoEnumHTML.S9)) {
            return new TokenHTML(this.estadoAceptacion.getTipoToken(estadoTemporal), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        return new TokenHTML(this.estadoAceptacion.getTipoToken(estadoActual), lineaInicial, columnaInicial, this.palabraTemporal.toString());
    }

    private TipoTokenEnumHTML revisarPalabraReservada(String palabra) {
        return switch (palabra.toLowerCase()) {
            case "class", "href", "onclick", "id", "style", "type", "placeholder", "required", "name", "value" -> TipoTokenEnumHTML.PALABRA_RESERVADA;
            case "=" -> TipoTokenEnumHTML.PALABRA_RESERVADA_IGUAL;
            default -> null;
        };
    }

    private TipoTokenEnumHTML revisarEtiqueta(String palabra) {
        return switch (palabra.toLowerCase()) {
            case "principal" -> TipoTokenEnumHTML.ETIQUETA_PRINCIPAL;
            case "encabezado" -> TipoTokenEnumHTML.ETIQUETA_ENCABEZADO;
            case "navegacion" -> TipoTokenEnumHTML.ETIQUETA_NAVEGACION;
            case "apartado" -> TipoTokenEnumHTML.ETIQUETA_APARTADO;
            case "listaordenada" -> TipoTokenEnumHTML.ETIQUETA_LIST_ORDERED;
            case "listadesordenada" -> TipoTokenEnumHTML.ETIQUETA_LIST_UNORDERED;
            case "itemlista" -> TipoTokenEnumHTML.ETIQUETA_LIST_ITEM;
            case "anclaje" -> TipoTokenEnumHTML.ETIQUETA_ANCLAJE;
            case "contenedor" -> TipoTokenEnumHTML.ETIQUETA_CONTENEDOR;
            case "seccion" -> TipoTokenEnumHTML.ETIQUETA_SECCION;
            case "articulo" -> TipoTokenEnumHTML.ETIQUETA_ARTICULO;
            case "parrafo" -> TipoTokenEnumHTML.ETIQUETA_PARRAFO;
            case "span" -> TipoTokenEnumHTML.ETIQUETA_SPAN;
            case "entrada" -> TipoTokenEnumHTML.ETIQUETA_ENTRADA;
            case "formulario" -> TipoTokenEnumHTML.ETIQUETA_FORMULARIO;
            case "label" -> TipoTokenEnumHTML.ETIQUETA_LABEL;
            case "area" -> TipoTokenEnumHTML.ETIQUETA_AREA;
            case "boton" -> TipoTokenEnumHTML.ETIQUETA_BOTON;
            case "piepagina" -> TipoTokenEnumHTML.ETIQUETA_PIE_PAGINA;
            default -> null;
        };
    }

    private TipoTokenEnumHTML revisarEtiquetaTitulo(String palabra) {
        for (int i = 0; i < 6; i++) {
            if (palabra.equals("titulo" + (i + 1))) {
                TipoTokenEnumHTML tokenTitulo = TipoTokenEnumHTML.ETIQUETA_TITULO;
                tokenTitulo.setTraduccion("h" + (i + 1));
                return tokenTitulo;
            }
        }
        return null;
    }

    public ArrayList<TokenHTML> getTokens(String contenido) {
        this.tokensAnalizados = new ArrayList<>();
        this.leerArchivo(contenido);
        try {
            while (!this.isFinArchivo()) {
                TokenHTML token = this.getToken();
                if (token.getTipoToken() == TipoTokenEnumHTML.PALABRA_RESERVADA) {
                    tokensAnalizados.add(isErrorSecuenciaPalabraReservada(tokensAnalizados, token));
                } else if (token.getTipoToken() != TipoTokenEnumHTML.CIERRE && token.getTipoToken() != TipoTokenEnumHTML.APERTURA) {
                    tokensAnalizados.add(isErrorSecuencia(tokensAnalizados, token));
                } else {
                    tokensAnalizados.add(token);
                }
                if (token.getTipoToken() != TipoTokenEnumHTML.ERROR) {
                    if (!token.getTipoToken().getTraduccion().equals("")) {
                        this.codigoTraducido += token.getTipoToken().getTraduccion();
                    } else {
                        this.codigoTraducido += token.getLexema();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("----------------ERROR---------------------");
        }
        for (int i = 0; i < tokensAnalizados.size(); i++) {
            if (tokensAnalizados.get(i).getLexema().equals("")) {
                tokensAnalizados.remove(tokensAnalizados.get(i));
            }
        }
        for (TokenHTML tokensAnalizado : tokensAnalizados) {
            System.out.println(tokensAnalizado);
        }
        System.out.println();
        return tokensAnalizados;
    }

    private TokenHTML isErrorSecuenciaPalabraReservada(ArrayList<TokenHTML> tokensLeidos, TokenHTML tokenPlabraReservada) {
        TokenHTML tokenNuevo = tokenPlabraReservada;
        if (!tokensLeidos.isEmpty()) {
            if (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() == TipoTokenEnumHTML.ERROR) {    // <a class
                tokenNuevo.setTipoToken(TipoTokenEnumHTML.ERROR);
            } else if (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() == TipoTokenEnumHTML.APERTURA) {  //<class
                tokenNuevo.setTipoToken(TipoTokenEnumHTML.ERROR);
            } else if (tokensLeidos.size() >= 2
                    && tokensLeidos.get(tokensLeidos.size() - 2).getTipoToken() == TipoTokenEnumHTML.DIAGONAL
                    && (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() != TipoTokenEnumHTML.ETIQUETA_TITULO
                    && tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() != TipoTokenEnumHTML.ETIQUETA_AREA
                    && tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() != TipoTokenEnumHTML.ETIQUETA_ENTRADA)) {
                tokenNuevo.setTipoToken(TipoTokenEnumHTML.ERROR);
            }
        }
        return tokenNuevo;
    }

    private TokenHTML isErrorSecuencia(ArrayList<TokenHTML> tokensLeidos, TokenHTML tokenSiguiente) {
        TokenHTML tokenNuevo = tokenSiguiente;
        if (!tokensLeidos.isEmpty()) {
            if (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() == TipoTokenEnumHTML.ERROR) {
                tokenNuevo.setTipoToken(TipoTokenEnumHTML.ERROR);
            }
        }
        return tokenNuevo;
    }

}
