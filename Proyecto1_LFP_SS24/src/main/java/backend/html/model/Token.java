/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.model;

/**
 *
 * @author Carlos Cotom
 */
public class Token {
    
    private TipoTokenEnum tipoToken;
    private int linea;
    private int columna;
    private String lexema;

    public Token(TipoTokenEnum tipoToke, int linea, int columna, String lexema) {
        this.tipoToken = tipoToke;
        this.linea = linea;
        this.columna = columna;
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

    @Override
    public String toString() {
        return "Token{" + "tipoToke = " + tipoToken + ", linea = " + linea + ", columna = " + columna + ", lexema = " + lexema + ", traduccion = " + tipoToken.getTraduccion() + '}';
    }
    
}
