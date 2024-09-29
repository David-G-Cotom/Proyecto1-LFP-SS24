/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package backend.css.model;

/**
 *
 * @author Carlos Cotom
 */
public enum TipoTokenEnumCSS {
    
    UNIVERSAL("*"),
    ETIQUETA_TIPO(""),
    CLASE(".[a-z]+[0-9]*(-([a-z]|[0-9])+)*"),
    ID("#[a-z]+[0-9]*(-([a-z]|[0-9])+)*"),
    CONBINADOR(""),
    REGLA(""),
    OTROS(""),
    CADENA("'([a-zA-Z]|[0-9]|[.])*'"),
    COLOR(""),
    IDENTIFICADOR("[a-z]+[0-9]*(-([a-z]|[0-9])+)*"),
    COMENTARIO("//([a-zA-Z]|[0-9]|[.])*"),
    ENTERO("[0-9]+"),
    DECIMAL("[0-9]+.[0-9]+"),
    ERROR("");
    
    private String expresionRegular;

    private TipoTokenEnumCSS(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }
    
}
