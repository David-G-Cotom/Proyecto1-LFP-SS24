/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.model;

/**
 *
 * @author Carlos Cotom
 */
public class TokenHTML {
    
    private TipoTokenEnumHTML tipoToken;
    private int linea;
    private int columna;
    private String lexema;
    private final String LENGUAJE = "HTML";
    private String expresionRegular;

    public TokenHTML(TipoTokenEnumHTML tipoToke, int linea, int columna, String lexema) {
        this.tipoToken = tipoToke;
        this.linea = linea;
        this.columna = columna;
        this.lexema = lexema;
        this.expresionRegular = this.tipoToken.getExpresionRegular();
        this.verificarExpresionRegular();
    }

    public TipoTokenEnumHTML getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenEnumHTML tipoToken) {
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
        return "TokenHTML{" + "tipoToke = " + tipoToken + ", linea = " + linea +
                ", columna = " + columna + ", lexema = " + lexema +
                ", traduccion = " + tipoToken.getTraduccion() +
                ", lenguaje = " + LENGUAJE +
                ", expresionRegular = " + expresionRegular + '}';
    }
    
}
