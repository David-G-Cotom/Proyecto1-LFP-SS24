/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.js.model;

import backend.Token;

/**
 *
 * @author Carlos Cotom
 */
public class TokenJS extends Token{
    
    private TipoTokenEnumJS tipoToken;
    private final String LENGUAJE = "JavaScript";
    private String expresionRegular;

    public TokenJS(TipoTokenEnumJS tipoToken, int linea, int columna, String lexema) {
        super(linea, columna, lexema);
        this.tipoToken = tipoToken;
        this.expresionRegular = this.tipoToken.getExpresionRegular();
        this.verificarExpresionRegular();
    }

    public TipoTokenEnumJS getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenEnumJS tipoToken) {
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
        return "TokenJS{" + "tipoToken = " + tipoToken + ", linea = " + super.getLinea() +
                ", columna = " + super.getColumna() + ", lexema = " + super.getLexema() +
                ", lenguaje = " + LENGUAJE +
                ", expresionRegular = " + expresionRegular + '}';
    }
    
}
