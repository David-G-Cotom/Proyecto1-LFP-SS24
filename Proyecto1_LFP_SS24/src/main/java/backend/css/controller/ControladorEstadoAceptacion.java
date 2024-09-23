/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.controller;

import backend.css.model.EstadoEnum;
import backend.css.model.TipoTokenEnum;
import java.util.HashMap;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorEstadoAceptacion {
    
    private final HashMap<EstadoEnum, TipoTokenEnum> mapaEstadoAceptacion;

    public ControladorEstadoAceptacion() {
        this.mapaEstadoAceptacion = new HashMap<>();
        
        
    }
    
    public TipoTokenEnum getTipoToken(EstadoEnum estadoActual) {
        TipoTokenEnum resultado = this.mapaEstadoAceptacion.get(estadoActual);
        if (resultado != null) {
            return this.mapaEstadoAceptacion.get(estadoActual);
        }
        return TipoTokenEnum.ERROR;
    }
    
}
