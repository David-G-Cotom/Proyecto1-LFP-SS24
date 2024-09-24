/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.js.controller;

import backend.js.model.EstadoEnumJS;
import backend.js.model.TipoTokenEnumJS;
import java.util.HashMap;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorEstadoAceptacionJS {
    
    private final HashMap<EstadoEnumJS, TipoTokenEnumJS> mapaEstadoAceptacion;

    public ControladorEstadoAceptacionJS() {
        this.mapaEstadoAceptacion = new HashMap<>();
        
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S2, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S3, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S4, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S5, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S6, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S7, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S8, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S9, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S10, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S12, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S14, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S15, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S16, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S17, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S18, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S19, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S20, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S22, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S24, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S26, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S27, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S28, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S29, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S30, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S31, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S32, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S33, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S34, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S35, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.SE, TipoTokenEnumJS.ERROR);
    }
    
    public TipoTokenEnumJS getTipoToken(EstadoEnumJS estadoActual) {
        TipoTokenEnumJS resultado = this.mapaEstadoAceptacion.get(estadoActual);
        if (resultado != null) {
            return this.mapaEstadoAceptacion.get(estadoActual);
        }
        return TipoTokenEnumJS.ERROR;
    }
    
}
