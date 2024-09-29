/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.css.model.AnalizadorLexicoCSS;
//import backend.css.model.TokenCSS;
import backend.html.model.AnalizadorLexicoHTML;
//import backend.html.model.TokenHTML;
import backend.js.model.AnalizadorLexicoJS;
//import backend.js.model.TokenJS;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Carlos Cotom
 */
public class AnalizadorCodigo {

    private int posicionContenido;
    private String codigoFuente;
    private StringBuilder palabraTemporal;
    private final ArrayList<String> bloquesCodigoHTML;
    private final AnalizadorLexicoHTML analizadorHTML = new AnalizadorLexicoHTML();
    //private ArrayList<TokenHTML> tokensHTML = new ArrayList<>();
    private final ArrayList<String> bloquesCodigoCSS;
    private final AnalizadorLexicoCSS analizadorCSS = new AnalizadorLexicoCSS();
    //private ArrayList<TokenCSS> tokensCSS = new ArrayList<>();
    private final ArrayList<String> bloquesCodigoJS;
    private final AnalizadorLexicoJS analizadorJS = new AnalizadorLexicoJS();
    //private ArrayList<TokenJS> tokensJS = new ArrayList<>();
    private int linea;
    private int columna;

    private String codigoCompilado;

    public AnalizadorCodigo() {
        this.bloquesCodigoHTML = new ArrayList<>();
        this.bloquesCodigoCSS = new ArrayList<>();
        this.bloquesCodigoJS = new ArrayList<>();
    }

    public String getCodigoCompilado() {
        return codigoCompilado;
    }

    public void setCodigoCompilado(String codigoCompilado) {
        this.codigoCompilado = codigoCompilado;
    }

    private void leerCodigo(String contenido) {
        this.codigoFuente = new String(contenido.getBytes());
        this.linea = 0;
        this.columna = 0;
        this.posicionContenido = 0;
    }

    private void dividirCodigoFuente() {
        this.palabraTemporal = new StringBuilder();
        char charActual;
        do {
            charActual = this.codigoFuente.charAt(posicionContenido);
            this.posicionContenido++;
            this.columna++;
            if (charActual == '\r' || charActual == ' ') {
                this.palabraTemporal = new StringBuilder();
                continue;
            }
            if (charActual == '\n') {
                this.linea++;
                this.columna = 0;
                this.palabraTemporal = new StringBuilder();
                continue;
            }
            this.palabraTemporal.append(charActual);
            int columnaInicial = (columna - palabraTemporal.length()) - 1;
            if (columnaInicial < 0) {
                columnaInicial = 0;
            }
            switch (this.palabraTemporal.toString().toLowerCase()) {
                case ">>[html]" -> {
                    System.out.println("CAMBIO A HTML");
                    if (this.posicionContenido - this.palabraTemporal.length() - 1 >= 0
                            && this.codigoFuente.charAt(this.posicionContenido - this.palabraTemporal.length() - 1) == '\n') {
                        this.linea--;
                    }
                    TokenEstado tokenEstado = new TokenEstado(linea, columnaInicial, ">>[html]");
                    System.out.println(tokenEstado);
                    this.agregarCodigoHTML();
                }
                case ">>[css]" -> {
                    System.out.println("CAMBIO A CSS");
                    if (this.posicionContenido - this.palabraTemporal.length() - 1 >= 0
                            && this.codigoFuente.charAt(this.posicionContenido - this.palabraTemporal.length() - 1) == '\n') {
                        this.linea--;
                    }
                    TokenEstado tokenEstado = new TokenEstado(linea, columnaInicial, ">>[css]");
                    System.out.println(tokenEstado);
                    this.agregarCodigoCSS();
                }
                case ">>[js]" -> {
                    System.out.println("CAMBIO A JS");
                    if (this.posicionContenido - this.palabraTemporal.length() - 1 >= 0
                            && this.codigoFuente.charAt(this.posicionContenido - this.palabraTemporal.length() - 1) == '\n') {
                        this.linea--;
                    }
                    TokenEstado tokenEstado = new TokenEstado(linea, columnaInicial, ">>[js]");
                    System.out.println(tokenEstado);
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
            if (this.posicionContenido == this.codigoFuente.length()) {
                contenido.append(contenidoTemporal);
                break;
            }
        }
        System.out.println(contenido.toString());
        this.bloquesCodigoHTML.add(contenido.toString());
        this.analizadorHTML.setLinea(linea);
        this.analizadorHTML.setColumna(columna);
        this.analizadorHTML.getTokens(contenido.toString());
        linea = this.analizadorHTML.getLinea();
        columna = this.analizadorHTML.getColumna();
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
            if (this.posicionContenido == this.codigoFuente.length()) {
                contenido.append(contenidoTemporal);
                break;
            }
        }
        System.out.println(contenido.toString());
        this.bloquesCodigoCSS.add(contenido.toString());
        this.analizadorCSS.setLinea(linea);
        this.analizadorCSS.setColumna(columna);
        this.analizadorCSS.getTokens(contenido.toString());
        linea = this.analizadorCSS.getLinea();
        columna = this.analizadorCSS.getColumna();
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
            if (this.posicionContenido == this.codigoFuente.length()) {
                contenido.append(contenidoTemporal);
                break;
            }
        }
        System.out.println(contenido.toString());
        this.bloquesCodigoJS.add(contenido.toString());
        this.analizadorJS.setLinea(linea);
        this.analizadorJS.setColumna(columna);
        this.analizadorJS.getTokens(contenido.toString());
        linea = this.analizadorJS.getLinea();
        columna = this.analizadorJS.getColumna();
    }

    public void analizarCodigoFuente(String codigoFuente) {
        this.leerCodigo(codigoFuente);
        this.dividirCodigoFuente();
    }

    public String optimizarCodigo(String codigo) {
        String[] lineasCodigo = codigo.split("\n");
        ArrayList<String> codigoOptimizado = new ArrayList<>();
        String[] lineasComentarios = new String[lineasCodigo.length];
        String[] lineasLenguaje = new String[lineasCodigo.length];
        for (int i = 0; i < lineasCodigo.length; i++) {
            if (lineasCodigo[i].toLowerCase().contains(">>[html]")) {
                lineasLenguaje[i] = "HTML";
            } else if (lineasCodigo[i].toLowerCase().contains(">>[css]")) {
                lineasLenguaje[i] = "CSS";
            } else if (lineasCodigo[i].toLowerCase().contains(">>[js]")) {
                lineasLenguaje[i] = "JS";
            }
            //Eliminar lineas vacias
            if (lineasCodigo[i].trim().isEmpty()) {
                continue;
            }
            //Eliminar lineas con comentarios
            if (lineasCodigo[i].contains("//")) {
                lineasComentarios[i] = lineasCodigo[i];
                codigoOptimizado.add("");
                continue;
            }
            //AgregarLinea al codigo optimizado
            codigoOptimizado.add(lineasCodigo[i]);
        }
        System.out.println(Arrays.toString(lineasComentarios));
        System.out.println(Arrays.toString(lineasLenguaje));
        return String.join("\n", codigoOptimizado);
    }
    
    private String traducirCodigo(String codigo) {
        
        return null;
        
    }

}
