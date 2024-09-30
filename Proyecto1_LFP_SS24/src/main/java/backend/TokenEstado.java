/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Carlos Cotom
 */
public class TokenEstado extends Token{
    
    private final String TIPO_TOKEN = "Estado";
    private final String LENGUAJE = "";
    private String expresionRegular;

    public TokenEstado(int linea, int columna, String lexema) {
        super(linea, columna, lexema);
        this.expresionRegular = lexema;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public String getTIPO_TOKEN() {
        return TIPO_TOKEN;
    }

    public String getLENGUAJE() {
        return LENGUAJE;
    }

    @Override
    public String toString() {
        return "TokenEstado{" + "tipoToken = " + TIPO_TOKEN + ", linea = " + super.getLinea()
                + ", columna = " + super.getColumna() + ", lexema = " + super.getLexema()
                + ", lenguaje = " + LENGUAJE + ", expresionRegular = " + expresionRegular + '}';
    }
    
}
