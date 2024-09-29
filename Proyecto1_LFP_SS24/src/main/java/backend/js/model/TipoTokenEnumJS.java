/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package backend.js.model;

/**
 *
 * @author Carlos Cotom
 */
public enum TipoTokenEnumJS {
    
    IDENTIFICADOR("[a-zA-Z]([a-zA-Z]|[0-9]|[_])*"),
    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    DIVISION("/"),
    IGUAL("=="),
    MENOR_QUE("<"),
    MAYOR_QUE(">"),
    MENOR_IGUAL("<="),
    MAYOR_IGUAL(">="),
    DIFERENTE("!="),
    OR("||"),
    AND("&&"),
    NOT("!"),
    INCREMENTO("++"),
    DECREMENTO("--"),
    ENTERO("[0-9]+"),
    DECIMAL("[0-9]+.[0-9]+"),
    CADENA("'([a-zA-Z]|[0-9]|[.])*'"),
    BOOLEANO(""),
    PALABRA_RESERVADA(""),
    PARENTESIS("[(]|[)]"),
    CORCHETE("[[]|[]]"),
    LLAVE("[{]|[}]"),
    ASIGNACION("="),
    PUNTO_COMA(";"),
    COMA(","),
    PUNTO("."),
    DOS_PUNTOS(":"),
    COMENTARIO("//([a-zA-Z]|[0-9]|[.])*"),
    ESPECIAL(""),
    ERROR("");
    
    private String expresionRegular;

    private TipoTokenEnumJS(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }
    
}
