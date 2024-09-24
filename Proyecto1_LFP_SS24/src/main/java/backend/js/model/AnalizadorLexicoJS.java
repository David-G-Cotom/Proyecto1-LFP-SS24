/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.js.model;

import backend.js.controller.ControladorAlfabetoJS;
import backend.js.controller.ControladorEstadoAceptacionJS;
import backend.js.controller.ControladorFunsionTransicionJS;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class AnalizadorLexicoJS {
    
    private final ControladorFunsionTransicionJS funsionTransicion;
    private int linea;
    private int columna;
    private int posicionContenido;
    private String contenido;
    private boolean isContenidoLeido;
    private final ControladorAlfabetoJS alfabetoController;
    private StringBuilder palabraTemporal;
    private final ControladorEstadoAceptacionJS estadoAceptacion;
    private ArrayList<TokenJS> tokensAnalizados;    

    public AnalizadorLexicoJS() {
        this.funsionTransicion = new ControladorFunsionTransicionJS();
        this.isContenidoLeido = false;
        this.alfabetoController = new ControladorAlfabetoJS();
        this.palabraTemporal = new StringBuilder();
        this.estadoAceptacion = new ControladorEstadoAceptacionJS();
    }
    
    public void leerContenido(String contenido) {
        this.contenido = new String(contenido.getBytes());
        this.isContenidoLeido = true;
        this.linea = 0;
        this.columna = 0;
        this.posicionContenido = 0;
    }
    
    public boolean isFinLectura() throws IOException {
        if (!isContenidoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();;
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
    
    public TokenJS getToken() throws IOException {
        if (!isContenidoLeido) {
            throw new IOException();
        }
        this.ignorarEspaciosBlanco();
        this.palabraTemporal = new StringBuilder();
        EstadoEnumJS estadoActual = this.funsionTransicion.getESTADO_INICIAL();
        char charActual;
        EstadoEnumJS estadoTemporal = estadoActual;
        AlfabetoEnumJS alfabetoSimbolo;
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
            if (estadoTemporal.equals(EstadoEnumJS.SF)) {
                break;
            }
            this.columna++;
            this.posicionContenido++;
            this.palabraTemporal.append(charActual);
            if (alfabetoSimbolo == AlfabetoEnumJS.NUEVA_LINEA) {
                this.linea++;
            }
            if (estadoTemporal.equals(EstadoEnumJS.SE)) {
                break;
            }
        } while (this.posicionContenido < this.contenido.length());
        if (estadoTemporal.equals(EstadoEnumJS.SE)) {
            estadoActual = estadoTemporal;
        }
        if (estadoActual == EstadoEnumJS.S1) {
            if (this.revisarBooleano(this.palabraTemporal.toString()) != null) {
                return new TokenJS(TipoTokenEnumJS.BOOLEANO, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else if (this.revisarPalabraReservada(this.palabraTemporal.toString()) != null) {
                return new TokenJS(TipoTokenEnumJS.PALABRA_RESERVADA, lineaInicial, columnaInicial, this.palabraTemporal.toString());
            } else {
                if (this.palabraTemporal.toString().contains(".")) {
                    return new TokenJS(TipoTokenEnumJS.ESPECIAL, lineaInicial, columnaInicial, this.palabraTemporal.toString());
                } else {
                    return new TokenJS(TipoTokenEnumJS.IDENTIFICADOR, lineaInicial, columnaInicial, this.palabraTemporal.toString());
                }
            }
        }
        if (((this.palabraTemporal.length() >= 1) && (this.posicionContenido == this.contenido.length()))
                || (estadoTemporal == EstadoEnumJS.S1) || (estadoTemporal == EstadoEnumJS.S4)
                || (estadoTemporal == EstadoEnumJS.S6) || (estadoTemporal == EstadoEnumJS.S8)
                || (estadoTemporal == EstadoEnumJS.S10) || (estadoTemporal == EstadoEnumJS.S22)
                || (estadoTemporal == EstadoEnumJS.S24) || (estadoTemporal == EstadoEnumJS.S26)) {
            return new TokenJS(this.estadoAceptacion.getTipoToken(estadoTemporal), lineaInicial, columnaInicial, this.palabraTemporal.toString());
        }
        return new TokenJS(this.estadoAceptacion.getTipoToken(estadoActual), lineaInicial, columnaInicial, this.palabraTemporal.toString());
    }
    
    private TipoTokenEnumJS revisarBooleano(String palabra) {
        switch (palabra.toLowerCase()) {
            case "true":
            case "false":
                return TipoTokenEnumJS.BOOLEANO;
            default:
                return null;
        }
    }
    
    private TipoTokenEnumJS revisarPalabraReservada(String palabra) {
        switch (palabra.toLowerCase()) {
            case "function":
            case "const":
            case "let":
            case "document":
            case "event":
            case "alert":
            case "for":
            case "while":
            case "if":
            case "else":
            case "return":
            case "console.log":
            case "null":
                return TipoTokenEnumJS.PALABRA_RESERVADA;
            default:
                return null;
        }
    }
    
    public ArrayList<TokenJS> getTokens(String contenido) {
        this.tokensAnalizados = new ArrayList<>();
        this.leerContenido(contenido);
        try {
            while (!this.isFinLectura()) {
                TokenJS token = this.getToken();
                this.tokensAnalizados.add(token);
                System.out.println(token);
            }
        } catch (IOException e) {
            System.out.println("----------------ERROR---------------------");
        }
        System.out.println();
        return this.tokensAnalizados;
    }
    
}
