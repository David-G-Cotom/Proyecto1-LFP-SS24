/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.controller;

import backend.html.model.EstadoEnumHTML;
import backend.html.model.TipoTokenEnumHTML;
import java.util.HashMap;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorEstadoAceptacionHTML {
    
    private final HashMap<EstadoEnumHTML, TipoTokenEnumHTML> mapaEstadoAceptacion;
    
    public ControladorEstadoAceptacionHTML() {
        this.mapaEstadoAceptacion = new HashMap<>();
        
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S1, TipoTokenEnumHTML.APERTURA);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S2, TipoTokenEnumHTML.CIERRE);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S3, TipoTokenEnumHTML.DIAGONAL);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S4, TipoTokenEnumHTML.COMENTARIO);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S7, TipoTokenEnumHTML.PALABRA_RESERVADA_IGUAL);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S9, TipoTokenEnumHTML.CADENA);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S10, TipoTokenEnumHTML.TEXTO);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S11, TipoTokenEnumHTML.TEXTO);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.S12, TipoTokenEnumHTML.TEXTO);
        this.mapaEstadoAceptacion.put(EstadoEnumHTML.SE, TipoTokenEnumHTML.ERROR);
    }
    
    public TipoTokenEnumHTML getTipoToken(EstadoEnumHTML estadoActual) {
        TipoTokenEnumHTML resultado = this.mapaEstadoAceptacion.get(estadoActual);
        if (resultado != null) {
            return this.mapaEstadoAceptacion.get(estadoActual);
        }
        return TipoTokenEnumHTML.ERROR;
    }
    
}
