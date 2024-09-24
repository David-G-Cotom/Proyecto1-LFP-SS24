/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.js.controller;

import backend.js.model.AlfabetoEnumJS;
import backend.js.model.EstadoEnumJS;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorFunsionTransicionJS {
    
    private final EstadoEnumJS[][] matrizEstados;
    private final EstadoEnumJS ESTADO_INICIAL = EstadoEnumJS.S0;

    public ControladorFunsionTransicionJS() {
        this.matrizEstados = new EstadoEnumJS[EstadoEnumJS.values().length - 2][AlfabetoEnumJS.values().length];
        
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.LETRA.ordinal()] = EstadoEnumJS.S1;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.NUMERO.ordinal()] = EstadoEnumJS.S19;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.SUMA.ordinal()] = EstadoEnumJS.S15;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.RESTA.ordinal()] = EstadoEnumJS.S17;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.MULTIPLICACION.ordinal()] = EstadoEnumJS.S2;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.IGUAL.ordinal()] = EstadoEnumJS.S3;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.MENOR_QUE.ordinal()] = EstadoEnumJS.S5;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.MAYOR_QUE.ordinal()] = EstadoEnumJS.S7;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.EXCLAMACION.ordinal()] = EstadoEnumJS.S9;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.RAYA.ordinal()] = EstadoEnumJS.S11;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.AMPER.ordinal()] = EstadoEnumJS.S13;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.PUNTO.ordinal()] = EstadoEnumJS.S32;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.COMILLA_DOBLE.ordinal()] = EstadoEnumJS.S21;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.COMILLA_SIMPLE.ordinal()] = EstadoEnumJS.S23;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.ACENTO.ordinal()] = EstadoEnumJS.S25;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.PARENTESIS.ordinal()] = EstadoEnumJS.S27;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.CORCHETE.ordinal()] = EstadoEnumJS.S28;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.LLAVE.ordinal()] = EstadoEnumJS.S29;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.PUNTO_COMA.ordinal()] = EstadoEnumJS.S30;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.COMA.ordinal()] = EstadoEnumJS.S31;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.DOS_PUNTOS.ordinal()] = EstadoEnumJS.S33;
        this.matrizEstados[EstadoEnumJS.S0.ordinal()][AlfabetoEnumJS.DIAGONAL.ordinal()] = EstadoEnumJS.S34;
        
        this.matrizEstados[EstadoEnumJS.S1.ordinal()][AlfabetoEnumJS.LETRA.ordinal()] = EstadoEnumJS.S1;
        this.matrizEstados[EstadoEnumJS.S1.ordinal()][AlfabetoEnumJS.NUMERO.ordinal()] = EstadoEnumJS.S1;
        this.matrizEstados[EstadoEnumJS.S1.ordinal()][AlfabetoEnumJS.GUION_BAJO.ordinal()] = EstadoEnumJS.S1;
        this.matrizEstados[EstadoEnumJS.S1.ordinal()][AlfabetoEnumJS.PUNTO.ordinal()] = EstadoEnumJS.S1;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S1.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S1.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S1.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S2.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S2.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S2.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S3.ordinal()][AlfabetoEnumJS.IGUAL.ordinal()] = EstadoEnumJS.S4;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S3.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S3.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S3.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S4.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S4.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S4.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S5.ordinal()][AlfabetoEnumJS.IGUAL.ordinal()] = EstadoEnumJS.S6;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S5.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S5.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S5.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S6.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S6.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S6.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S7.ordinal()][AlfabetoEnumJS.IGUAL.ordinal()] = EstadoEnumJS.S8;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S7.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S7.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S7.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S8.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S8.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S8.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S9.ordinal()][AlfabetoEnumJS.IGUAL.ordinal()] = EstadoEnumJS.S10;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S9.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S9.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S9.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S10.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S10.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S10.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S11.ordinal()][AlfabetoEnumJS.RAYA.ordinal()] = EstadoEnumJS.S12;
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S12.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S12.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S12.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S13.ordinal()][AlfabetoEnumJS.AMPER.ordinal()] = EstadoEnumJS.S14;
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S14.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S14.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S14.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S15.ordinal()][AlfabetoEnumJS.SUMA.ordinal()] = EstadoEnumJS.S16;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S15.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S15.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S15.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S16.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S16.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S16.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S17.ordinal()][AlfabetoEnumJS.RESTA.ordinal()] = EstadoEnumJS.S18;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S17.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S17.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S17.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S18.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S18.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S18.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S19.ordinal()][AlfabetoEnumJS.NUMERO.ordinal()] = EstadoEnumJS.S19;
        this.matrizEstados[EstadoEnumJS.S19.ordinal()][AlfabetoEnumJS.PUNTO.ordinal()] = EstadoEnumJS.S20;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S19.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S19.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S19.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S20.ordinal()][AlfabetoEnumJS.NUMERO.ordinal()] = EstadoEnumJS.S20;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S20.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S20.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S20.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S21.ordinal()][AlfabetoEnumJS.COMILLA_DOBLE.ordinal()] = EstadoEnumJS.S22;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S21.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S21.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S21.ordinal()][i] = EstadoEnumJS.S21;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S22.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S22.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S22.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S23.ordinal()][AlfabetoEnumJS.COMILLA_SIMPLE.ordinal()] = EstadoEnumJS.S24;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S23.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S23.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S23.ordinal()][i] = EstadoEnumJS.S23;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S24.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S24.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S24.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S25.ordinal()][AlfabetoEnumJS.ACENTO.ordinal()] = EstadoEnumJS.S26;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S25.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S25.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S25.ordinal()][i] = EstadoEnumJS.S25;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S26.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S26.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S26.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S27.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S27.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S27.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S28.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S28.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S28.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S29.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S29.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S29.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S30.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S30.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S30.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S31.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S31.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S31.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S32.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S32.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S32.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S33.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S33.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S33.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S34.ordinal()][AlfabetoEnumJS.DIAGONAL.ordinal()] = EstadoEnumJS.S35;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S34.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S34.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S34.ordinal()][i] = EstadoEnumJS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumJS.S35.ordinal()][AlfabetoEnumJS.NUEVA_LINEA.ordinal()] = EstadoEnumJS.SF;
        for (int i = 0; i < this.matrizEstados[EstadoEnumJS.S35.ordinal()].length; i++) {
            if (i == AlfabetoEnumJS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumJS.S35.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumJS.S35.ordinal()][i] = EstadoEnumJS.S25;
            }
        }
        
        
        for (EstadoEnumJS[] arregloEstado : this.matrizEstados) {
            for (int j = 0; j < this.matrizEstados[0].length; j++) {
                if (arregloEstado[j] == null) {
                    arregloEstado[j] = EstadoEnumJS.SE;
                }
            }
        }
        for (int i = 0; i < this.matrizEstados.length; i++) {
            System.out.println(i+1);
            for (int j = 0; j < this.matrizEstados[0].length; j++) {
                System.out.print(this.matrizEstados[i][j].toString() + " ");
            }
            System.out.println("");
        }
    }

    public EstadoEnumJS getESTADO_INICIAL() {
        return ESTADO_INICIAL;
    }
    
    public EstadoEnumJS produccion(EstadoEnumJS estadoActual, AlfabetoEnumJS alfabeto) {
        if ((estadoActual != EstadoEnumJS.SF) && (estadoActual != EstadoEnumJS.SE)) {
            return this.matrizEstados[estadoActual.ordinal()][alfabeto.ordinal()];
        }
        return estadoActual;
    }
    
}
