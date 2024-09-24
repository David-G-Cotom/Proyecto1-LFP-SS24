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
        
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S1, TipoTokenEnumJS.IDENTIFICADOR);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S2, TipoTokenEnumJS.MULTIPLICACION);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S3, TipoTokenEnumJS.ASIGNACION);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S4, TipoTokenEnumJS.IGUAL);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S5, TipoTokenEnumJS.MENOR_QUE);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S6, TipoTokenEnumJS.MENOR_IGUAL);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S7, TipoTokenEnumJS.MAYOR_QUE);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S8, TipoTokenEnumJS.MAYOR_IGUAL);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S9, TipoTokenEnumJS.NOT);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S10, TipoTokenEnumJS.DIFERENTE);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S12, TipoTokenEnumJS.OR);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S14, TipoTokenEnumJS.AND);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S15, TipoTokenEnumJS.SUMA);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S16, TipoTokenEnumJS.INCREMENTO);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S17, TipoTokenEnumJS.RESTA);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S18, TipoTokenEnumJS.DECREMENTO);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S19, TipoTokenEnumJS.ENTERO);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S36, TipoTokenEnumJS.DECIMAL);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S22, TipoTokenEnumJS.CADENA);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S24, TipoTokenEnumJS.CADENA);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S26, TipoTokenEnumJS.CADENA);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S27, TipoTokenEnumJS.PARENTESIS);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S28, TipoTokenEnumJS.CORCHETE);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S29, TipoTokenEnumJS.LLAVE);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S30, TipoTokenEnumJS.PUNTO_COMA);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S31, TipoTokenEnumJS.COMA);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S32, TipoTokenEnumJS.PUNTO);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S33, TipoTokenEnumJS.DOS_PUNTOS);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S34, TipoTokenEnumJS.DIVISION);
        this.mapaEstadoAceptacion.put(EstadoEnumJS.S35, TipoTokenEnumJS.COMENTARIO);
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
