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
    
    private TipoTokenEnum tipoToke;
    private int linea;
    private int columna;
    private String lexema;

    public Token(TipoTokenEnum tipoToke, int linea, int columna, String lexema) {
        this.tipoToke = tipoToke;
        this.linea = linea;
        this.columna = columna;
        this.lexema = lexema;
    }

    public TipoTokenEnum getTipoToke() {
        return tipoToke;
    }

    public void setTipoToke(TipoTokenEnum tipoToke) {
        this.tipoToke = tipoToke;
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
        return "Token{" + "tipoToke=" + tipoToke + ", linea=" + linea + ", columna=" + columna + ", lexema=" + lexema + '}';
    }
    
}
