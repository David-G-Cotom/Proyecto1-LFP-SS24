/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.model;

import backend.html.controller.ControladorAlfabeto;
import backend.html.controller.ControladorEstadoAceptacion;
import backend.html.controller.ControladorFunsionTransicion;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class AnalizadorLexico {

    private final ControladorFunsionTransicion funsionTransicion;
    private int linea;
    private int columna;
    private int posicionContenido;
    private String contenido;
    private boolean isArchivoLeido;
    private final ControladorAlfabeto alfabetoController;
    private StringBuilder palabraTemporal;
    private final ControladorEstadoAceptacion estadoAceptacion;
    private ArrayList<Token> tokensAnalizados;

    public AnalizadorLexico() {
        this.funsionTransicion = new ControladorFunsionTransicion();
        this.isArchivoLeido = false;
        this.alfabetoController = new ControladorAlfabeto();
        this.palabraTemporal = new StringBuilder();
        this.estadoAceptacion = new ControladorEstadoAceptacion();
    }

    public void leerArchivo(String contenido) {
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

    public Token getToken() throws IOException {
        if (!isArchivoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();
        this.palabraTemporal = new StringBuilder();
        EstadoEnum estadoActual = this.funsionTransicion.getEstadoInicial();
        char charActual;
        EstadoEnum estadoTemporal = estadoActual;
        AlfabetoEnum alfabetoSimbolo;
        int lineaInicial = this.linea;
        int columnaInicial = this.columna;
        do {
            if (!this.tokensAnalizados.isEmpty()) {
                if (this.tokensAnalizados.get(this.tokensAnalizados.size() - 1).getTipoToken() == TipoTokenEnum.CIERRE) {
                    return this.getTokenTexto();
                }
            }
            estadoActual = estadoTemporal;
            //System.out.println("Estado Actual: " + estadoActual);
            charActual = this.contenido.charAt(this.posicionContenido);
            //System.out.println("Caracter Actual: " + charActual);
            if (charActual == '\r') {
                break;
            }
            alfabetoSimbolo = this.alfabetoController.getAlfabeto(charActual);
            //System.out.println("Alfabeto Simbolo: " + alfabetoSimbolo);
            estadoTemporal = this.funsionTransicion.produccion(estadoActual, alfabetoSimbolo);
            //System.out.println("Estado Temporal: " + estadoTemporal);
            if (estadoTemporal.equals(EstadoEnum.SF)) {
                break;
            }
            this.columna++;
            this.posicionContenido++;
            this.palabraTemporal.append(charActual);
            if (alfabetoSimbolo == AlfabetoEnum.NUEVA_LINEA) {
                this.linea++;
            }
            if (estadoTemporal.equals(EstadoEnum.SE)) {
                break;
            }
        } while (this.posicionContenido < this.contenido.length());
        if (estadoTemporal.equals(EstadoEnum.SE)) {
            estadoActual = estadoTemporal;
        }
        if (this.revisarPalabraReservada(this.palabraTemporal.toString()) != null) {
            return new Token(revisarPalabraReservada(this.palabraTemporal.toString()), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if (this.revisarEtiqueta(this.palabraTemporal.toString()) != null) {
            return new Token(revisarEtiqueta(this.palabraTemporal.toString()), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if (this.revisarEtiquetaTitulo(this.palabraTemporal.toString()) != null) {
            return new Token(revisarEtiquetaTitulo(this.palabraTemporal.toString()), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        if (((this.palabraTemporal.length() == 1) && (this.posicionContenido == this.contenido.length()))
                || (estadoTemporal == EstadoEnum.S1) || (estadoTemporal == EstadoEnum.S2)
                || (estadoTemporal == EstadoEnum.S3) || (estadoTemporal == EstadoEnum.S7)
                || (estadoTemporal == EstadoEnum.S9)) {
            return new Token(this.estadoAceptacion.getTipoToken(estadoTemporal), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        return new Token(this.estadoAceptacion.getTipoToken(estadoActual), lineaInicial, columnaInicial, this.palabraTemporal.toString());
    }

    private Token getTokenTexto() throws IOException {
        //System.out.println();
        //System.out.println("EN TOKEN TEXTO");
        if (!isArchivoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();
        this.palabraTemporal = new StringBuilder();
        EstadoEnum estadoActual = EstadoEnum.S10;
        char charActual;
        EstadoEnum estadoTemporal = estadoActual;
        AlfabetoEnum alfabetoSimbolo;
        int lineaInicial = this.linea;
        int columnaInicial = this.columna;
        do {
            estadoActual = estadoTemporal;
            //System.out.println("Estado Actual: " + estadoActual);
            charActual = this.contenido.charAt(this.posicionContenido);
            //System.out.println("Caracter Actual: " + charActual);
            if (charActual == '\r') {
                break;
            }
            alfabetoSimbolo = this.alfabetoController.getAlfabeto(charActual);
            //System.out.println("Alfabeto Simbolo: " + alfabetoSimbolo);
            estadoTemporal = this.funsionTransicion.produccion(estadoActual, alfabetoSimbolo);
            //System.out.println("Estado Temporal: " + estadoTemporal);
            if (alfabetoSimbolo == AlfabetoEnum.DIAGONAL && estadoTemporal.equals(EstadoEnum.SF)) {
                this.posicionContenido--;
                this.palabraTemporal.deleteCharAt(this.palabraTemporal.length() - 1);
                if (this.palabraTemporal.isEmpty()) {
                    estadoTemporal = EstadoEnum.S0;
                    continue;
                }
            }
            if (estadoTemporal.equals(EstadoEnum.SF)) {
                break;
            }
            this.columna++;
            this.posicionContenido++;
            this.palabraTemporal.append(charActual);
            if (alfabetoSimbolo == AlfabetoEnum.NUEVA_LINEA) {
                this.linea++;
            }
            if (estadoTemporal.equals(EstadoEnum.SE)) {
                break;
            }
        } while (this.posicionContenido < this.contenido.length());
        if (estadoTemporal.equals(EstadoEnum.SE)) {
            estadoActual = estadoTemporal;
        }
        if (((this.palabraTemporal.length() == 1) && (this.posicionContenido == this.contenido.length()))
                || (estadoTemporal == EstadoEnum.S1) || (estadoTemporal == EstadoEnum.S2)
                || (estadoTemporal == EstadoEnum.S3) || (estadoTemporal == EstadoEnum.S7)
                || (estadoTemporal == EstadoEnum.S9)) {
            return new Token(this.estadoAceptacion.getTipoToken(estadoTemporal), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        return new Token(this.estadoAceptacion.getTipoToken(estadoActual), lineaInicial, columnaInicial, this.palabraTemporal.toString());
    }

    private TipoTokenEnum revisarPalabraReservada(String palabra) {
        switch (palabra.toLowerCase()) {
            case "class":
            case "href":
            case "onclick":
            case "id":
            case "style":
            case "type":
            case "placeholder":
            case "required":
            case "name":
                return TipoTokenEnum.PALABRA_RESERVADA;
            case "=":
                return TipoTokenEnum.PALABRA_RESERVADA_IGUAL;
            default:
                return null;
        }
    }

    private TipoTokenEnum revisarEtiqueta(String palabra) {
        switch (palabra.toLowerCase()) {
            case "principal":
                return TipoTokenEnum.ETIQUETA_PRINCIPAL;
            case "encabezado":
                return TipoTokenEnum.ETIQUETA_ENCABEZADO;
            case "navegacion":
                return TipoTokenEnum.ETIQUETA_NAVEGACION;
            case "apartado":
                return TipoTokenEnum.ETIQUETA_APARTADO;
            case "listaordenada":
                return TipoTokenEnum.ETIQUETA_LIST_ORDERED;
            case "listadesordenada":
                return TipoTokenEnum.ETIQUETA_LIST_UNORDERED;
            case "itemlista":
                return TipoTokenEnum.ETIQUETA_LIST_ITEM;
            case "anclaje":
                return TipoTokenEnum.ETIQUETA_ANCLAJE;
            case "contenedor":
                return TipoTokenEnum.ETIQUETA_CONTENEDOR;
            case "seccion":
                return TipoTokenEnum.ETIQUETA_SECCION;
            case "articulo":
                return TipoTokenEnum.ETIQUETA_ARTICULO;
            case "parrafo":
                return TipoTokenEnum.ETIQUETA_PARRAFO;
            case "span":
                return TipoTokenEnum.ETIQUETA_SPAN;
            case "entrada":
                return TipoTokenEnum.ETIQUETA_ENTRADA;
            case "formulario":
                return TipoTokenEnum.ETIQUETA_FORMULARIO;
            case "label":
                return TipoTokenEnum.ETIQUETA_LABEL;
            case "area":
                return TipoTokenEnum.ETIQUETA_AREA;
            case "boton":
                return TipoTokenEnum.ETIQUETA_BOTON;
            case "piepagina":
                return TipoTokenEnum.ETIQUETA_PIE_PAGINA;
            default:
                return null;
        }
    }

    private TipoTokenEnum revisarEtiquetaTitulo(String palabra) {
        for (int i = 0; i < 6; i++) {
            if (palabra.equals("titulo" + (i + 1))) {
                TipoTokenEnum tokenTitulo = TipoTokenEnum.ETIQUETA_TITULO;
                tokenTitulo.setTraduccion("h" + (i + 1));
                return tokenTitulo;
            }
        }
        return null;
    }

    public ArrayList<Token> getTokens(String contenido) {
        this.tokensAnalizados = new ArrayList<>();
        this.leerArchivo(contenido);
        try {
            while (!this.isFinArchivo()) {
                Token token = this.getToken();
                if (token.getTipoToken() == TipoTokenEnum.PALABRA_RESERVADA) {
                    tokensAnalizados.add(isErrorSecuenciaPalabraReservada(tokensAnalizados, token));
                } else if (token.getTipoToken() != TipoTokenEnum.CIERRE && token.getTipoToken() != TipoTokenEnum.APERTURA) {
                    tokensAnalizados.add(isErrorSecuencia(tokensAnalizados, token));
                } else {
                    tokensAnalizados.add(token);
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
        for (Token tokensAnalizado : tokensAnalizados) {
            System.out.println(tokensAnalizado);
        }
        System.out.println();
        return tokensAnalizados;
    }

    private Token isErrorSecuenciaPalabraReservada(ArrayList<Token> tokensLeidos, Token tokenPlabraReservada) {
        Token tokenNuevo = tokenPlabraReservada;
        if (!tokensLeidos.isEmpty()) {
            if (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() == TipoTokenEnum.ERROR) {    // <a class
                tokenNuevo.setTipoToken(TipoTokenEnum.ERROR);
            } else if (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() == TipoTokenEnum.APERTURA) {  //<class
                tokenNuevo.setTipoToken(TipoTokenEnum.ERROR);
            } else if (tokensLeidos.get(tokensLeidos.size() - 2).getTipoToken() == TipoTokenEnum.DIAGONAL
                    && (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() != TipoTokenEnum.ETIQUETA_TITULO
                    && tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() != TipoTokenEnum.ETIQUETA_AREA
                    && tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() != TipoTokenEnum.ETIQUETA_ENTRADA)) {
                tokenNuevo.setTipoToken(TipoTokenEnum.ERROR);
            }
        }
        return tokenNuevo;
    }

    private Token isErrorSecuencia(ArrayList<Token> tokensLeidos, Token tokenSiguiente) {
        Token tokenNuevo = tokenSiguiente;
        if (!tokensLeidos.isEmpty()) {
            if (tokensLeidos.get(tokensLeidos.size() - 1).getTipoToken() == TipoTokenEnum.ERROR) {
                tokenNuevo.setTipoToken(TipoTokenEnum.ERROR);
            }
        }
        return tokenNuevo;
    }

}
