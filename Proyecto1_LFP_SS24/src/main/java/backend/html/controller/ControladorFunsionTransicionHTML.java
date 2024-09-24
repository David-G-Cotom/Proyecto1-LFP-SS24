/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.controller;

import backend.html.model.AlfabetoEnumHTML;
import backend.html.model.EstadoEnumHTML;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorFunsionTransicionHTML {
    
    private final EstadoEnumHTML[][] matrizEstados;
    private final EstadoEnumHTML ESTADO_INICIAL = EstadoEnumHTML.S0;
    
    public ControladorFunsionTransicionHTML() {
        this.matrizEstados = new EstadoEnumHTML[EstadoEnumHTML.values().length - 2][AlfabetoEnumHTML.values().length];
        
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.LETRA.ordinal()] = EstadoEnumHTML.S5;
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.DIAGONAL.ordinal()] = EstadoEnumHTML.S3;
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.IGUAL.ordinal()] = EstadoEnumHTML.S7;
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.MAYOR_QUE.ordinal()] = EstadoEnumHTML.S2;
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.MENOR_QUE.ordinal()] = EstadoEnumHTML.S1;
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.COMILLA_DOBLE.ordinal()] = EstadoEnumHTML.S8;
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.NUEVA_LINEA.ordinal()] = EstadoEnumHTML.S0;
        this.matrizEstados[EstadoEnumHTML.S0.ordinal()][AlfabetoEnumHTML.ESPACIO.ordinal()] = EstadoEnumHTML.S0;
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S1.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S1.ordinal()][i] = EstadoEnumHTML.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S2.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S2.ordinal()][i] = EstadoEnumHTML.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S3.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnumHTML.DIAGONAL.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S3.ordinal()][i] = EstadoEnumHTML.S4;
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S3.ordinal()][i] = EstadoEnumHTML.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S4.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnumHTML.NUEVA_LINEA.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S4.ordinal()][i] = EstadoEnumHTML.SF;
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S4.ordinal()][i] = EstadoEnumHTML.S4;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S5.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnumHTML.NUMERO.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S5.ordinal()][i] = EstadoEnumHTML.S6;
                continue;
            } else if (i == AlfabetoEnumHTML.LETRA.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S5.ordinal()][i] = EstadoEnumHTML.S5;
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S5.ordinal()][i] = EstadoEnumHTML.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S6.ordinal()].length; i++) {
            if ((i == AlfabetoEnumHTML.ERROR.ordinal()) || (i == AlfabetoEnumHTML.NUMERO.ordinal())
                    || (i == AlfabetoEnumHTML.LETRA.ordinal())) {
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S6.ordinal()][i] = EstadoEnumHTML.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S7.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S7.ordinal()][i] = EstadoEnumHTML.SF;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S8.ordinal()].length; i++) {
            if ((i == AlfabetoEnumHTML.ERROR.ordinal()) || (i == AlfabetoEnumHTML.NUEVA_LINEA.ordinal())) {
                continue;
            } else if (i == AlfabetoEnumHTML.COMILLA_DOBLE.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S8.ordinal()][i] = EstadoEnumHTML.S9;
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S8.ordinal()][i] = EstadoEnumHTML.S8;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S9.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S9.ordinal()][i] = EstadoEnumHTML.SF;
        }
        
        this.matrizEstados[EstadoEnumHTML.S10.ordinal()][AlfabetoEnumHTML.DIAGONAL.ordinal()] = EstadoEnumHTML.S11;
        this.matrizEstados[EstadoEnumHTML.S10.ordinal()][AlfabetoEnumHTML.MENOR_QUE.ordinal()] = EstadoEnumHTML.SF;
        this.matrizEstados[EstadoEnumHTML.S10.ordinal()][AlfabetoEnumHTML.NUEVA_LINEA.ordinal()] = EstadoEnumHTML.S10;
        this.matrizEstados[EstadoEnumHTML.S10.ordinal()][AlfabetoEnumHTML.ESPACIO.ordinal()] = EstadoEnumHTML.S10;
        this.matrizEstados[EstadoEnumHTML.S10.ordinal()][AlfabetoEnumHTML.ERROR.ordinal()] = EstadoEnumHTML.SE;
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S10.ordinal()].length; i++) {
            if (this.matrizEstados[EstadoEnumHTML.S10.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumHTML.S10.ordinal()][i] = EstadoEnumHTML.S12;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S11.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnumHTML.DIAGONAL.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S11.ordinal()][i] = EstadoEnumHTML.SF;
                continue;
            } else if (i == AlfabetoEnumHTML.MENOR_QUE.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S11.ordinal()][i] = EstadoEnumHTML.SF;
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S11.ordinal()][i] = EstadoEnumHTML.S12;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumHTML.S12.ordinal()].length; i++) {
            if (i == AlfabetoEnumHTML.ERROR.ordinal()) {
                continue;
            } else if (i == AlfabetoEnumHTML.DIAGONAL.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S12.ordinal()][i] = EstadoEnumHTML.S11;
                continue;
            } else if (i == AlfabetoEnumHTML.MENOR_QUE.ordinal()) {
                this.matrizEstados[EstadoEnumHTML.S12.ordinal()][i] = EstadoEnumHTML.SF;
                continue;
            }
            this.matrizEstados[EstadoEnumHTML.S12.ordinal()][i] = EstadoEnumHTML.S12;
        }
        
        for (EstadoEnumHTML[] arregloEstado : this.matrizEstados) {
            for (int j = 0; j < this.matrizEstados[0].length; j++) {
                if (arregloEstado[j] == null) {
                    arregloEstado[j] = EstadoEnumHTML.SE;
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
    
    public EstadoEnumHTML getEstadoInicial() {
        return this.ESTADO_INICIAL;
    }
    
    public EstadoEnumHTML produccion(EstadoEnumHTML estadoActual, AlfabetoEnumHTML alfabeto) {
        if ((estadoActual != EstadoEnumHTML.SF) && (estadoActual != EstadoEnumHTML.SE)) {
            return this.matrizEstados[estadoActual.ordinal()][alfabeto.ordinal()];
        }
        return estadoActual;
    }
    
}
