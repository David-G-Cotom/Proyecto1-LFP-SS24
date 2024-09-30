/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.model;

import backend.Token;

/**
 *
 * @author Carlos Cotom
 */
public class TokenHTML extends Token{
    
    private TipoTokenEnumHTML tipoToken;
    private final String LENGUAJE = "HTML";
    private String expresionRegular;

    public TokenHTML(TipoTokenEnumHTML tipoToke, int linea, int columna, String lexema) {
        super(linea, columna, lexema);
        this.tipoToken = tipoToke;
        this.expresionRegular = this.tipoToken.getExpresionRegular();
        this.verificarExpresionRegular();
    }

    public TipoTokenEnumHTML getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenEnumHTML tipoToken) {
        this.tipoToken = tipoToken;
    }

    public String getLENGUAJE() {
        return LENGUAJE;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }
    
    private void verificarExpresionRegular() {
        if (this.expresionRegular.equals("")) {
            this.expresionRegular = super.getLexema();
        }
    }

    @Override
    public String toString() {
        return "TokenHTML{" + "tipoToke = " + tipoToken + ", linea = " + super.getLinea() +
                ", columna = " + super.getColumna() + ", lexema = " + super.getLexema() +
                ", traduccion = " + tipoToken.getTraduccion() +
                ", lenguaje = " + LENGUAJE +
                ", expresionRegular = " + expresionRegular + '}';
    }
    
}
