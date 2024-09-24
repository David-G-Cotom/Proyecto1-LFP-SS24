/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.controller;

import backend.css.model.EstadoEnumCSS;
import backend.css.model.TipoTokenEnumCSS;
import java.util.HashMap;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorEstadoAceptacionCSS {
    
    private final HashMap<EstadoEnumCSS, TipoTokenEnumCSS> mapaEstadoAceptacion;

    public ControladorEstadoAceptacionCSS() {
        this.mapaEstadoAceptacion = new HashMap<>();
        
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S14, TipoTokenEnumCSS.COLOR);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S19, TipoTokenEnumCSS.IDENTIFICADOR);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S21, TipoTokenEnumCSS.IDENTIFICADOR);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S22, TipoTokenEnumCSS.UNIVERSAL);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S29, TipoTokenEnumCSS.CONBINADOR);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S30, TipoTokenEnumCSS.OTROS);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S31, TipoTokenEnumCSS.OTROS);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S38, TipoTokenEnumCSS.ENTERO);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S39, TipoTokenEnumCSS.DECIMAL);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S42, TipoTokenEnumCSS.COMENTARIO);
        this.mapaEstadoAceptacion.put(EstadoEnumCSS.S44, TipoTokenEnumCSS.CADENA);
    }
    
    public TipoTokenEnumCSS getTipoToken(EstadoEnumCSS estadoActual) {
        TipoTokenEnumCSS resultado = this.mapaEstadoAceptacion.get(estadoActual);
        if (resultado != null) {
            return this.mapaEstadoAceptacion.get(estadoActual);
        }
        return TipoTokenEnumCSS.ERROR;
    }
    
}
