/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.model;

/**
 *
 * @author Carlos Cotom
 */
public class Token {
    
    private TipoTokenEnum tipoToken;
    private int linea;
    private int columan;
    private String lexema;

    public Token(TipoTokenEnum tipoToken, int linea, int columan, String lexema) {
        this.tipoToken = tipoToken;
        this.linea = linea;
        this.columan = columan;
        this.lexema = lexema;
    }

    public TipoTokenEnum getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenEnum tipoToken) {
        this.tipoToken = tipoToken;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColuman() {
        return columan;
    }

    public void setColuman(int columan) {
        this.columan = columan;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    @Override
    public String toString() {
        return "Token{" + "tipoToken = " + tipoToken + ", linea = " + linea + ", columan = " + columan + ", lexema = " + lexema + '}';
    }
    
}
