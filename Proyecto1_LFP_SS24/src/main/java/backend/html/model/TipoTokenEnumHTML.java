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
    
    APERTURA(""),
    DIAGONAL(""),
    CIERRE(""),
    ETIQUETA_RESERVADA(""),
    ETIQUETA_PRINCIPAL("main"),
    ETIQUETA_ENCABEZADO("header"),
    ETIQUETA_NAVEGACION("nav"),
    ETIQUETA_APARTADO("aside"),
    ETIQUETA_LIST_ORDERED("ul"),
    ETIQUETA_LIST_UNORDERED("ol"),
    ETIQUETA_LIST_ITEM("li"),
    ETIQUETA_ANCLAJE("a"),
    ETIQUETA_CONTENEDOR("div"),
    ETIQUETA_SECCION("section"),
    ETIQUETA_ARTICULO("article"),
    ETIQUETA_TITULO(""),            // h#
    ETIQUETA_PARRAFO("p"),
    ETIQUETA_SPAN("span"),
    ETIQUETA_ENTRADA("input"),
    ETIQUETA_FORMULARIO("form"),
    ETIQUETA_LABEL("label"),
    ETIQUETA_AREA("textarea"),
    ETIQUETA_BOTON("button"),
    ETIQUETA_PIE_PAGINA("footer"),
    PALABRA_RESERVADA(""),
    PALABRA_RESERVADA_IGUAL(""),
    CADENA(""),                     // "fghj"
    TEXTO(""),
    COMENTARIO(""),
    ERROR("");
    
    private String traduccion;

    private TipoTokenEnumHTML(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }
    
}
