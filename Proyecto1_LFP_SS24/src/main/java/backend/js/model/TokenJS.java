/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.js.model;

/**
 *
 * @author Carlos Cotom
 */
public class TokenJS {
    
    private TipoTokenEnumJS tipoToken;
    private int linea;
    private int columna;
    private String lexema;
    private final String LENGUAJE = "JavaScript";
    private String expresionRegular;

    public TokenJS(TipoTokenEnumJS tipoToken, int linea, int columna, String lexema) {
        this.tipoToken = tipoToken;
        this.linea = linea;
        this.columna = columna;
        this.lexema = lexema;
        this.expresionRegular = this.tipoToken.getExpresionRegular();
        this.verificarExpresionRegular();
    }

    public TipoTokenEnumJS getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenEnumJS tipoToken) {
        this.tipoToken = tipoToken;
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

    public String getLENGUAJE() {
        return LENGUAJE;
    }
    
    private void verificarExpresionRegular() {
        if (this.expresionRegular.equals("")) {
            this.expresionRegular = lexema;
        }
    }

    @Override
    public String toString() {
        return "TokenJS{" + "tipoToken = " + tipoToken + ", linea = " + linea +
                ", columna = " + columna + ", lexema = " + lexema +
                ", lenguaje = " + LENGUAJE +
                ", expresionRegular = " + expresionRegular + '}';
    }
    
}
