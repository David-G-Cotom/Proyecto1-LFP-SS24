/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package backend.html.model;

/**
 *
 * @author Carlos Cotom
 */
public enum TipoTokenEnumHTML {
    
    APERTURA("", "<"),
    DIAGONAL("", "/"),
    CIERRE("", ">"),
    ETIQUETA_PRINCIPAL("main", "principal"),
    ETIQUETA_ENCABEZADO("header", "encabezado"),
    ETIQUETA_NAVEGACION("nav", "navegacion"),
    ETIQUETA_APARTADO("aside", "apartado"),
    ETIQUETA_LIST_ORDERED("ul", "listaordenada"),
    ETIQUETA_LIST_UNORDERED("ol", "listadesordenada"),
    ETIQUETA_LIST_ITEM("li", "itemlista"),
    ETIQUETA_ANCLAJE("a", "anclaje"),
    ETIQUETA_CONTENEDOR("div", "contenedor"),
    ETIQUETA_SECCION("section", "seccion"),
    ETIQUETA_ARTICULO("article", "articulo"),
    ETIQUETA_TITULO("", "titulo"),                      // h#
    ETIQUETA_PARRAFO("p", "parrafo"),
    ETIQUETA_SPAN("span", "span"),
    ETIQUETA_ENTRADA("input", "entrada"),
    ETIQUETA_FORMULARIO("form", "formulario"),
    ETIQUETA_LABEL("label", "label"),
    ETIQUETA_AREA("textarea", "area"),
    ETIQUETA_BOTON("button", "boton"),
    ETIQUETA_PIE_PAGINA("footer", "piepagina"),
    PALABRA_RESERVADA("", ""),
    PALABRA_RESERVADA_IGUAL("", "="),
    CADENA("", "\"([a-zA-Z]|[0-9]|[.])*\""),
    TEXTO("", "([a-zA-Z]|[0-9]|[.])+"),
    COMENTARIO("", "//([a-zA-Z]|[0-9]|[.])*"),
    ERROR("", "");
    
    private String traduccion;
    private String expresionRegular;

    private TipoTokenEnumHTML(String traduccion, String expresionRegular) {
        this.traduccion = traduccion;
        this.expresionRegular = expresionRegular;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }
    
}
