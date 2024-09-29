/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Carlos Cotom
 */
public class TokenEstado {
    
    private final static String TIPO_TOKEN = "Estado";
    private int linea;
    private int columna;
    private String lexema;
    private final static String LENGUAJE = "";
    private String expresionRegular;

    public TokenEstado(int linea, int columna, String lexema) {
        this.linea = linea;
        this.columna = columna;
        this.lexema = lexema;
        this.expresionRegular = lexema;
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

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public static String getTIPO_TOKEN() {
        return TIPO_TOKEN;
    }

    public static String getLENGUAJE() {
        return LENGUAJE;
    }

    @Override
    public String toString() {
        return "TokenEstado{" + "tipoToken = " + TIPO_TOKEN + ", linea = " + linea
                + ", columna = " + columna + ", lexema = " + lexema
                + ", lenguaje = " + LENGUAJE + ", expresionRegular = " + expresionRegular + '}';
    }
    
}
