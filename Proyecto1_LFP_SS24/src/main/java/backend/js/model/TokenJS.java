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

    public TokenJS(TipoTokenEnumJS tipoToken, int linea, int columna, String lexema) {
        this.tipoToken = tipoToken;
        this.linea = linea;
        this.columna = columna;
        this.lexema = lexema;
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

    @Override
    public String toString() {
        return "TokenJS{" + "tipoToken = " + tipoToken + ", linea = " + linea + ", columna = " + columna + ", lexema = " + lexema + '}';
    }
    
}
