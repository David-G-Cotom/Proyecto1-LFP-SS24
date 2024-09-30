/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.model;

import backend.Token;

/**
 *
 * @author Carlos Cotom
 */
public class TokenCSS extends Token{
    
    private TipoTokenEnumCSS tipoToken;
    private final String LENGUAJE = "CSS";
    private String expresionRegular;

    public TokenCSS(TipoTokenEnumCSS tipoToken, int linea, int columan, String lexema) {
        super(linea, columan, lexema);
        this.tipoToken = tipoToken;
        this.expresionRegular = this.tipoToken.getExpresionRegular();
        this.verificarExpresionRegular();
    }

    public TipoTokenEnumCSS getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenEnumCSS tipoToken) {
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
        return "TokenCSS{" + "tipoToken = " + tipoToken + ", linea = " + super.getLinea() +
                ", columan = " + super.getColumna() + ", lexema = " + super.getLexema() +
                ", lenguaje = " + LENGUAJE +
                ", expresionRegular = " + expresionRegular + '}';
    }
    
}
