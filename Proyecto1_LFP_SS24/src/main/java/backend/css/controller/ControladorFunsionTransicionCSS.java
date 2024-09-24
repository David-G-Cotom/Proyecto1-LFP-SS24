/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.controller;

import backend.css.model.AlfabetoEnumCSS;
import backend.css.model.EstadoEnumCSS;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorFunsionTransicionCSS {
    
    private final EstadoEnumCSS[][] matrizEstados;
    private final EstadoEnumCSS ESTADO_INICIAL = EstadoEnumCSS.S0;

    public ControladorFunsionTransicionCSS() {
        this.matrizEstados = new EstadoEnumCSS[EstadoEnumCSS.values().length - 2][AlfabetoEnumCSS.values().length];
        
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S38;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S1;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.ASTERISCO.ordinal()] = EstadoEnumCSS.S22;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.PUNTO.ordinal()] = EstadoEnumCSS.S23;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.NUMERAL.ordinal()] = EstadoEnumCSS.S28;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.CONBINADORES.ordinal()] = EstadoEnumCSS.S29;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.PORCENTAJE.ordinal()] = EstadoEnumCSS.S30;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.DOS_PUNTOS.ordinal()] = EstadoEnumCSS.S31;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.PUNTO_COMA.ordinal()] = EstadoEnumCSS.S30;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.COMA.ordinal()] = EstadoEnumCSS.S30;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.COMILLA_SIMPLE.ordinal()] = EstadoEnumCSS.S33;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.ACENTO.ordinal()] = EstadoEnumCSS.S43;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.PARENTESIS.ordinal()] = EstadoEnumCSS.S30;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.LLAVE.ordinal()] = EstadoEnumCSS.S30;
        this.matrizEstados[EstadoEnumCSS.S0.ordinal()][AlfabetoEnumCSS.DIAGONAL.ordinal()] = EstadoEnumCSS.S41;
        
        this.matrizEstados[EstadoEnumCSS.S1.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S2;
        this.matrizEstados[EstadoEnumCSS.S1.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S1;
        this.matrizEstados[EstadoEnumCSS.S1.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S3;
        this.matrizEstados[EstadoEnumCSS.S1.ordinal()][AlfabetoEnumCSS.PARENTESIS.ordinal()] = EstadoEnumCSS.S5;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S1.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S1.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S1.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S2.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S19;
        this.matrizEstados[EstadoEnumCSS.S2.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S20;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S2.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S2.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S2.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S3.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S4;
        this.matrizEstados[EstadoEnumCSS.S3.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S4;
        
        this.matrizEstados[EstadoEnumCSS.S4.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S4;
        this.matrizEstados[EstadoEnumCSS.S4.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S4;
        this.matrizEstados[EstadoEnumCSS.S4.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S3;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S4.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S4.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S4.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S5.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S6;
        this.matrizEstados[EstadoEnumCSS.S5.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S5;
        
        this.matrizEstados[EstadoEnumCSS.S6.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S6;
        this.matrizEstados[EstadoEnumCSS.S6.ordinal()][AlfabetoEnumCSS.COMA.ordinal()] = EstadoEnumCSS.S8;
        this.matrizEstados[EstadoEnumCSS.S6.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S7;
        
        this.matrizEstados[EstadoEnumCSS.S7.ordinal()][AlfabetoEnumCSS.COMA.ordinal()] = EstadoEnumCSS.S8;
        this.matrizEstados[EstadoEnumCSS.S7.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S7;
        
        this.matrizEstados[EstadoEnumCSS.S8.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S9;
        this.matrizEstados[EstadoEnumCSS.S8.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S8;
        
        this.matrizEstados[EstadoEnumCSS.S9.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S9;
        this.matrizEstados[EstadoEnumCSS.S9.ordinal()][AlfabetoEnumCSS.COMA.ordinal()] = EstadoEnumCSS.S11;
        this.matrizEstados[EstadoEnumCSS.S9.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S10;
        
        this.matrizEstados[EstadoEnumCSS.S10.ordinal()][AlfabetoEnumCSS.COMA.ordinal()] = EstadoEnumCSS.S11;
        this.matrizEstados[EstadoEnumCSS.S10.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S10;
        
        this.matrizEstados[EstadoEnumCSS.S11.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S12;
        this.matrizEstados[EstadoEnumCSS.S11.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S11;
        
        this.matrizEstados[EstadoEnumCSS.S12.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S12;
        this.matrizEstados[EstadoEnumCSS.S12.ordinal()][AlfabetoEnumCSS.COMA.ordinal()] = EstadoEnumCSS.S15;
        this.matrizEstados[EstadoEnumCSS.S12.ordinal()][AlfabetoEnumCSS.PARENTESIS.ordinal()] = EstadoEnumCSS.S14;
        this.matrizEstados[EstadoEnumCSS.S12.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S13;
        
        this.matrizEstados[EstadoEnumCSS.S13.ordinal()][AlfabetoEnumCSS.COMA.ordinal()] = EstadoEnumCSS.S15;
        this.matrizEstados[EstadoEnumCSS.S13.ordinal()][AlfabetoEnumCSS.PARENTESIS.ordinal()] = EstadoEnumCSS.S14;
        this.matrizEstados[EstadoEnumCSS.S13.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S13;
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S14.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S14.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S14.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S15.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S16;
        this.matrizEstados[EstadoEnumCSS.S15.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S15;
        
        this.matrizEstados[EstadoEnumCSS.S16.ordinal()][AlfabetoEnumCSS.PUNTO.ordinal()] = EstadoEnumCSS.S17;
        this.matrizEstados[EstadoEnumCSS.S16.ordinal()][AlfabetoEnumCSS.PARENTESIS.ordinal()] = EstadoEnumCSS.S14;
        this.matrizEstados[EstadoEnumCSS.S16.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S13;
        
        this.matrizEstados[EstadoEnumCSS.S17.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S18;
        
        this.matrizEstados[EstadoEnumCSS.S18.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S18;
        this.matrizEstados[EstadoEnumCSS.S18.ordinal()][AlfabetoEnumCSS.PARENTESIS.ordinal()] = EstadoEnumCSS.S14;
        this.matrizEstados[EstadoEnumCSS.S18.ordinal()][AlfabetoEnumCSS.ESPACIO.ordinal()] = EstadoEnumCSS.S13;
        
        this.matrizEstados[EstadoEnumCSS.S19.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S19;
        this.matrizEstados[EstadoEnumCSS.S19.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S20;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S19.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S19.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S19.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S20.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S21;
        this.matrizEstados[EstadoEnumCSS.S20.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S21;
        
        this.matrizEstados[EstadoEnumCSS.S21.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S21;
        this.matrizEstados[EstadoEnumCSS.S21.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S21;
        this.matrizEstados[EstadoEnumCSS.S21.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S20;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S21.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S21.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S21.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S22.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S22.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S22.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S23.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S24;
        
        this.matrizEstados[EstadoEnumCSS.S24.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S25;
        this.matrizEstados[EstadoEnumCSS.S24.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S24;
        this.matrizEstados[EstadoEnumCSS.S24.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S26;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S24.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S24.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S24.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S25.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S25;
        this.matrizEstados[EstadoEnumCSS.S25.ordinal()][AlfabetoEnumCSS.LETRA_MAYUSCULA.ordinal()] = EstadoEnumCSS.S37;
        this.matrizEstados[EstadoEnumCSS.S25.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S37;
        this.matrizEstados[EstadoEnumCSS.S25.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S26;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S25.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S25.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S25.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S26.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S27;
        this.matrizEstados[EstadoEnumCSS.S26.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S27;
        
        this.matrizEstados[EstadoEnumCSS.S27.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S27;
        this.matrizEstados[EstadoEnumCSS.S27.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S27;
        this.matrizEstados[EstadoEnumCSS.S27.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S26;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S27.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S27.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S27.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S28.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S37;
        this.matrizEstados[EstadoEnumCSS.S28.ordinal()][AlfabetoEnumCSS.LETRA_MAYUSCULA.ordinal()] = EstadoEnumCSS.S37;
        this.matrizEstados[EstadoEnumCSS.S28.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S24;
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S29.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S29.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S29.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S30.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S30.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S30.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S31.ordinal()][AlfabetoEnumCSS.LETRA_MAYUSCULA.ordinal()] = EstadoEnumCSS.S31;
        this.matrizEstados[EstadoEnumCSS.S31.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S31;
        this.matrizEstados[EstadoEnumCSS.S31.ordinal()][AlfabetoEnumCSS.GUION_MEDIO.ordinal()] = EstadoEnumCSS.S31;
        this.matrizEstados[EstadoEnumCSS.S31.ordinal()][AlfabetoEnumCSS.DOS_PUNTOS.ordinal()] = EstadoEnumCSS.S32;
        this.matrizEstados[EstadoEnumCSS.S31.ordinal()][AlfabetoEnumCSS.PARENTESIS.ordinal()] = EstadoEnumCSS.S31;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S31.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S31.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S31.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S32.ordinal()][AlfabetoEnumCSS.LETRA_MAYUSCULA.ordinal()] = EstadoEnumCSS.S32;
        this.matrizEstados[EstadoEnumCSS.S32.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S32;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S32.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S32.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S32.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S33.ordinal()][AlfabetoEnumCSS.CORCHETES.ordinal()] = EstadoEnumCSS.S34;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S33.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S33.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S33.ordinal()][i] = EstadoEnumCSS.S40;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S34.ordinal()][AlfabetoEnumCSS.LETRA_MAYUSCULA.ordinal()] = EstadoEnumCSS.S34;
        this.matrizEstados[EstadoEnumCSS.S34.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S34;
        this.matrizEstados[EstadoEnumCSS.S34.ordinal()][AlfabetoEnumCSS.CORCHETES.ordinal()] = EstadoEnumCSS.S35;
        
        this.matrizEstados[EstadoEnumCSS.S35.ordinal()][AlfabetoEnumCSS.COMILLA_SIMPLE.ordinal()] = EstadoEnumCSS.S36;
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S36.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S36.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S36.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S37.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S37;
        this.matrizEstados[EstadoEnumCSS.S37.ordinal()][AlfabetoEnumCSS.LETRA_MAYUSCULA.ordinal()] = EstadoEnumCSS.S37;
        this.matrizEstados[EstadoEnumCSS.S37.ordinal()][AlfabetoEnumCSS.LETRA_MINUSCULA.ordinal()] = EstadoEnumCSS.S37;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S37.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S37.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S37.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S38.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S38;
        this.matrizEstados[EstadoEnumCSS.S38.ordinal()][AlfabetoEnumCSS.PUNTO.ordinal()] = EstadoEnumCSS.S39;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S38.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S38.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S38.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S39.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S45;
        
        this.matrizEstados[EstadoEnumCSS.S40.ordinal()][AlfabetoEnumCSS.COMILLA_SIMPLE.ordinal()] = EstadoEnumCSS.S36;
        this.matrizEstados[EstadoEnumCSS.S40.ordinal()][AlfabetoEnumCSS.ACENTO.ordinal()] = EstadoEnumCSS.S44;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S40.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S40.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S40.ordinal()][i] = EstadoEnumCSS.S40;
            }
        }
        
        this.matrizEstados[EstadoEnumCSS.S41.ordinal()][AlfabetoEnumCSS.DIAGONAL.ordinal()] = EstadoEnumCSS.S42;
        
        this.matrizEstados[EstadoEnumCSS.S42.ordinal()][AlfabetoEnumCSS.NUEVA_LINEA.ordinal()] = EstadoEnumCSS.SF;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S42.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S42.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S42.ordinal()][i] = EstadoEnumCSS.S42;
            }
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S43.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnumCSS.S43.ordinal()][i] = EstadoEnumCSS.S40;
        }
        
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S44.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            this.matrizEstados[EstadoEnumCSS.S44.ordinal()][i] = EstadoEnumCSS.SF;
        }
        
        this.matrizEstados[EstadoEnumCSS.S45.ordinal()][AlfabetoEnumCSS.NUMERO.ordinal()] = EstadoEnumCSS.S45;
        for (int i = 0; i < this.matrizEstados[EstadoEnumCSS.S45.ordinal()].length; i++) {
            if (i == AlfabetoEnumCSS.ERROR.ordinal()) {
                continue;
            }
            if (this.matrizEstados[EstadoEnumCSS.S45.ordinal()][i] == null) {
                this.matrizEstados[EstadoEnumCSS.S45.ordinal()][i] = EstadoEnumCSS.SF;
            }
        }
        
        for (EstadoEnumCSS[] arregloEstado : matrizEstados) {
            for (int i = 0; i < this.matrizEstados[0].length; i++) {
                if (arregloEstado[i] == null) {
                    arregloEstado[i] = EstadoEnumCSS.SE;
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

    public EstadoEnumCSS getESTADO_INICIAL() {
        return ESTADO_INICIAL;
    }
    
    public EstadoEnumCSS produccion(EstadoEnumCSS estadoActual, AlfabetoEnumCSS alfabeto) {
        if ((estadoActual != EstadoEnumCSS.SF) && (estadoActual != EstadoEnumCSS.SE)) {
            return this.matrizEstados[estadoActual.ordinal()][alfabeto.ordinal()];
        }
        return estadoActual;
    }
    
}
