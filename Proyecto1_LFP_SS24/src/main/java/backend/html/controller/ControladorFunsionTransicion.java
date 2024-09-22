/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.controller;

import backend.html.model.AlfabetoEnum;
import backend.html.model.EstadoEnum;
import java.util.Arrays;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorFunsionTransicion {
    
    private final EstadoEnum[][] matrizEstados;
    private final EstadoEnum ESTADO_INICIAL = EstadoEnum.S0;
    
    public ControladorFunsionTransicion() {
        this.matrizEstados = new EstadoEnum[EstadoEnum.values().length - 2][AlfabetoEnum.values().length];
        
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.LETRA.ordinal()] = EstadoEnum.S5;
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.DIAGONAL.ordinal()] = EstadoEnum.S3;
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.IGUAL.ordinal()] = EstadoEnum.S7;
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.MAYOR_QUE.ordinal()] = EstadoEnum.S2;
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.MENOR_QUE.ordinal()] = EstadoEnum.S1;
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.COMILLA_DOBLE.ordinal()] = EstadoEnum.S8;
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.NUEVA_LINEA.ordinal()] = EstadoEnum.S0;
        this.matrizEstados[EstadoEnum.S0.ordinal()][AlfabetoEnum.ESPACIO.ordinal()] = EstadoEnum.S0;
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S1.ordinal()].length; i++) {
            if (i == AlfabetoEnum.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnum.S1.ordinal()][i] = EstadoEnum.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S2.ordinal()].length; i++) {
            if (i == AlfabetoEnum.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnum.S2.ordinal()][i] = EstadoEnum.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S3.ordinal()].length; i++) {
            if (i == AlfabetoEnum.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnum.DIAGONAL.ordinal()) {
                this.matrizEstados[EstadoEnum.S3.ordinal()][i] = EstadoEnum.S4;
                continue;
            }
            this.matrizEstados[EstadoEnum.S3.ordinal()][i] = EstadoEnum.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S4.ordinal()].length; i++) {
            if (i == AlfabetoEnum.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnum.NUEVA_LINEA.ordinal()) {
                this.matrizEstados[EstadoEnum.S4.ordinal()][i] = EstadoEnum.SF;
                continue;
            }
            this.matrizEstados[EstadoEnum.S4.ordinal()][i] = EstadoEnum.S4;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S5.ordinal()].length; i++) {
            if (i == AlfabetoEnum.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnum.NUMERO.ordinal()) {
                this.matrizEstados[EstadoEnum.S5.ordinal()][i] = EstadoEnum.S6;
                continue;
            } else if (i == AlfabetoEnum.LETRA.ordinal()) {
                this.matrizEstados[EstadoEnum.S5.ordinal()][i] = EstadoEnum.S5;
                continue;
            }
            this.matrizEstados[EstadoEnum.S5.ordinal()][i] = EstadoEnum.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S6.ordinal()].length; i++) {
            if ((i == AlfabetoEnum.ERROR.ordinal()) || (i == AlfabetoEnum.NUMERO.ordinal())
                    || (i == AlfabetoEnum.LETRA.ordinal())) {
                continue;
            }
            this.matrizEstados[EstadoEnum.S6.ordinal()][i] = EstadoEnum.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S7.ordinal()].length; i++) {
            if (i == AlfabetoEnum.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnum.S7.ordinal()][i] = EstadoEnum.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S8.ordinal()].length; i++) {
            if ((i == AlfabetoEnum.ERROR.ordinal()) || (i == AlfabetoEnum.NUEVA_LINEA.ordinal())) {
                continue;
            } else if (i == AlfabetoEnum.COMILLA_DOBLE.ordinal()) {
                this.matrizEstados[EstadoEnum.S8.ordinal()][i] = EstadoEnum.S9;
                continue;
            }
            this.matrizEstados[EstadoEnum.S8.ordinal()][i] = EstadoEnum.S8;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnum.S9.ordinal()].length; i++) {
            if (i == AlfabetoEnum.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnum.S9.ordinal()][i] = EstadoEnum.SF;
        }
        
        for (EstadoEnum[] arregloEstado : this.matrizEstados) {
            for (int j = 0; j < this.matrizEstados[0].length; j++) {
                if (arregloEstado[j] == null) {
                    arregloEstado[j] = EstadoEnum.SE;
                }
            }
        }
        /*for (int i = 0; i < this.matrizEstados.length; i++) {
            for (int j = 0; j < this.matrizEstados[0].length; j++) {
                System.out.print(this.matrizEstados[i][j].toString() + " ");
            }
            System.out.println("");
        }*/
        
    }
    
    public EstadoEnum getEstadoInicial() {
        return this.ESTADO_INICIAL;
    }
    
    public EstadoEnum produccion(EstadoEnum estadoActual, AlfabetoEnum alfabeto) {
        if ((estadoActual != EstadoEnum.SF) && (estadoActual != EstadoEnum.SE)) {
            return this.matrizEstados[estadoActual.ordinal()][alfabeto.ordinal()];
        }
        return estadoActual;
    }
    
}
