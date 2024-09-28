/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.css.model.AnalizadorLexicoCSS;
import backend.css.model.TokenCSS;
import backend.html.model.AnalizadorLexicoHTML;
import backend.html.model.TokenHTML;
import backend.js.model.AnalizadorLexicoJS;
import backend.js.model.TokenJS;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class AnalizadorCodigo {

    private int posicionContenido;
    private String codigoFuente;
    StringBuilder palabraTemporal;
    private ArrayList<String> bloquesCodigoHTML;
    private ArrayList<String> bloquesCodigoCSS;
    private ArrayList<String> bloquesCodigoJS;

    private String codigoCompilado;

    public AnalizadorCodigo() {
        this.bloquesCodigoHTML = new ArrayList<>();
        this.bloquesCodigoCSS = new ArrayList<>();
        this.bloquesCodigoJS = new ArrayList<>();
    }

    public String getCodigoFuente() {
        return codigoFuente;
    }

    public void setCodigoFuente(String codigoFuente) {
        this.codigoFuente = codigoFuente;
    }

    public String getCodigoCompilado() {
        return codigoCompilado;
    }

    public void setCodigoCompilado(String codigoCompilado) {
        this.codigoCompilado = codigoCompilado;
    }

    private void leerCodigo(String contenido) {
        this.codigoFuente = new String(contenido.getBytes());
        this.posicionContenido = 0;
    }

    private void dividirCodigoFuente() {
        this.palabraTemporal = new StringBuilder();
        char charActual;
        do {
            charActual = this.codigoFuente.charAt(posicionContenido);
            this.posicionContenido++;
            if (charActual == '\r' || charActual == '\n' || charActual == ' ') {
                this.palabraTemporal = new StringBuilder();
                continue;
            }
            this.palabraTemporal.append(charActual);
            switch (this.palabraTemporal.toString().toLowerCase()) {
                case ">>[html]" -> {
                    System.out.println("CAMBIO A HTML");
                    this.agregarCodigoHTML();
                }
                case ">>[css]" -> {
                    System.out.println("CAMBIO A CSS");
                    this.agregarCodigoCSS();
                }
                case ">>[js]" -> {
                    System.out.println("CAMBIO A JS");
                    this.agregarCodigoJS();
                }
            }
        } while (this.posicionContenido < this.codigoFuente.length());
    }

    private void agregarCodigoHTML() {
        StringBuilder contenido = new StringBuilder();
        StringBuilder contenidoTemporal = new StringBuilder();
        char charActual;
        while (this.posicionContenido < this.codigoFuente.length()) {
            charActual = this.codigoFuente.charAt(posicionContenido);
            this.posicionContenido++;
            if (charActual == '\r' || charActual == '\n' || charActual == ' ') {
                contenido.append(contenidoTemporal);
                contenido.append(charActual);
                contenidoTemporal = new StringBuilder();
                continue;
            }
            contenidoTemporal.append(charActual);
            if (contenidoTemporal.toString().equalsIgnoreCase(">>[css]")) {
                this.posicionContenido -= 8;
                break;
            } else if (contenidoTemporal.toString().equalsIgnoreCase(">>[js]")) {
                this.posicionContenido -= 7;
                break;
            } else if (contenidoTemporal.toString().equalsIgnoreCase(">>[html]")) {
                this.posicionContenido -= 9;
                break;
            }
        }
        System.out.println(contenido.toString());
        this.bloquesCodigoHTML.add(contenido.toString());
    }

    private void agregarCodigoCSS() {
        StringBuilder contenido = new StringBuilder();
        StringBuilder contenidoTemporal = new StringBuilder();
        char charActual;
        while (this.posicionContenido < this.codigoFuente.length()) {
            charActual = this.codigoFuente.charAt(posicionContenido);
            this.posicionContenido++;
            if (charActual == '\r' || charActual == '\n' || charActual == ' ') {
                contenido.append(contenidoTemporal);
                contenido.append(charActual);
                contenidoTemporal = new StringBuilder();
                continue;
            }
            contenidoTemporal.append(charActual);
            if (contenidoTemporal.toString().equalsIgnoreCase(">>[html]")) {
                this.posicionContenido -= 9;
                break;
            } else if (contenidoTemporal.toString().equalsIgnoreCase(">>[js]")) {
                this.posicionContenido -= 7;
                break;
            } else if (contenidoTemporal.toString().equalsIgnoreCase(">>[css]")) {
                this.posicionContenido -= 8;
                break;
            }
        }
        System.out.println(contenido.toString());
        this.bloquesCodigoCSS.add(contenido.toString());
    }

    private void agregarCodigoJS() {
        StringBuilder contenido = new StringBuilder();
        StringBuilder contenidoTemporal = new StringBuilder();
        char charActual;
        while (this.posicionContenido < this.codigoFuente.length()) {
            charActual = this.codigoFuente.charAt(posicionContenido);
            this.posicionContenido++;
            if (charActual == '\r' || charActual == '\n' || charActual == ' ') {
                contenido.append(contenidoTemporal);
                contenido.append(charActual);
                contenidoTemporal = new StringBuilder();
                continue;
            }
            contenidoTemporal.append(charActual);
            if (contenidoTemporal.toString().equalsIgnoreCase(">>[css]")) {
                this.posicionContenido -= 8;
                break;
            } else if (contenidoTemporal.toString().equalsIgnoreCase(">>[html]")) {
                this.posicionContenido -= 9;
                break;
            } else if (contenidoTemporal.toString().equalsIgnoreCase(">>[js]")) {
                this.posicionContenido -= 7;
                break;
            }
        }
        System.out.println(contenido.toString());
        this.bloquesCodigoJS.add(contenido.toString());
    }

    public void analizarCodigoFuente(String codigoFuente) {
        this.leerCodigo(codigoFuente);
        this.dividirCodigoFuente();
        ArrayList<TokenHTML> tokensHTML = new ArrayList<>();
        AnalizadorLexicoHTML analizadorHTML = new AnalizadorLexicoHTML();
        for (String string : bloquesCodigoHTML) {
            analizadorHTML.getTokens(string);
        }
        ArrayList<TokenCSS> tokensCSS = new ArrayList<>();
        AnalizadorLexicoCSS analizadorCSS = new AnalizadorLexicoCSS();
        for (String string : bloquesCodigoCSS) {
            analizadorCSS.getTokens(string);
        }
        ArrayList<TokenJS> tokensJS = new ArrayList<>();
        AnalizadorLexicoJS analizadorJS = new AnalizadorLexicoJS();
        for (String string : bloquesCodigoJS) {
            analizadorJS.getTokens(string);
        }
    }

}
