/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.controller;

import backend.css.model.AlfabetoEnum;
import backend.css.model.EstadoEnum;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorFunsionTransicion {
    
    private final EstadoEnum[][] matrizEstados;
    private final EstadoEnum ESTADO_INICIAL = EstadoEnum.S0;

    public ControladorFunsionTransicion() {
        this.matrizEstados = new EstadoEnum[EstadoEnum.values().length - 2][AlfabetoEnum.values().length];
        
        
    }

    public EstadoEnum getESTADO_INICIAL() {
        return ESTADO_INICIAL;
    }
    
    public EstadoEnum produccion(EstadoEnum estadoActual, AlfabetoEnum alfabeto) {
        if ((estadoActual != EstadoEnum.SF) && (estadoActual != EstadoEnum.SE)) {
            return this.matrizEstados[estadoActual.ordinal()][alfabeto.ordinal()];
        }
        return estadoActual;
    }
    
}
