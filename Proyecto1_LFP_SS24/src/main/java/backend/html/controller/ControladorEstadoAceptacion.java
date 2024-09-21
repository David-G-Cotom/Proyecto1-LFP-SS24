/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.controller;

import backend.html.model.EstadoEnum;
import backend.html.model.TipoTokenEnum;
import java.util.HashMap;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorEstadoAceptacion {
    
    private final HashMap<EstadoEnum, TipoTokenEnum> mapaEstadoAceptacion;
    
    public ControladorEstadoAceptacion() {
        this.mapaEstadoAceptacion = new HashMap<>();
        
        this.mapaEstadoAceptacion.put(EstadoEnum.S1, TipoTokenEnum.APERTURA);
        this.mapaEstadoAceptacion.put(EstadoEnum.S2, TipoTokenEnum.CIERRE);
        this.mapaEstadoAceptacion.put(EstadoEnum.S3, TipoTokenEnum.DIAGONAL);
        this.mapaEstadoAceptacion.put(EstadoEnum.S4, TipoTokenEnum.COMENTARIO);
        this.mapaEstadoAceptacion.put(EstadoEnum.S5, TipoTokenEnum.ETIQUETA_RESERVADA);
        this.mapaEstadoAceptacion.put(EstadoEnum.S6, TipoTokenEnum.ETIQUETA_TITULO);
        this.mapaEstadoAceptacion.put(EstadoEnum.S7, TipoTokenEnum.PALABRA_RESERVADA_IGUAL);
        this.mapaEstadoAceptacion.put(EstadoEnum.S8, TipoTokenEnum.CADENA);
    }
    
    public TipoTokenEnum getTipoToken(EstadoEnum estadoActual) {
        TipoTokenEnum resultado = this.mapaEstadoAceptacion.get(estadoActual);
        if (resultado != null) {
            return this.mapaEstadoAceptacion.get(estadoActual);
        }
        return TipoTokenEnum.ERROR;
    }
    
}
