/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.controller;

import backend.css.model.AlfabetoEnum;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorAlfabeto {
    
    public boolean isEspacioBlanco(char charAt) {
        return Character.isWhitespace(charAt);
    }
    
    public boolean isNuevaLinea(char charAt) {
        return (charAt == '\n');
    }
    
    public AlfabetoEnum getAlfabeto(char charAt) {
        int valor = charAt;
        if (((valor >= 65) && (valor <= 90)) || ((valor >= 97) && (valor <= 122))) {
            return AlfabetoEnum.LETRA;
        } else if ((valor >= 48) && (valor <= 57)) {
            return AlfabetoEnum.NUMERO;        
        } else if (charAt == '-') {
            return AlfabetoEnum.GUION_MEDIO;
        } else if (valor == '>' || valor == '~' || valor == '+') {
            return AlfabetoEnum.CONBINADORES;
        } else if (charAt == '*') {
            return AlfabetoEnum.ASTERISCO;
        } else if (charAt == ':') {
            return AlfabetoEnum.DOS_PUNTOS;
        } else if (charAt == ';') {
            return AlfabetoEnum.PUNTO_COMA;
        } else if (charAt == '%') {
            return AlfabetoEnum.PORCENTAJE;
        } else if (charAt == '.') {
            return AlfabetoEnum.PUNTO;
        } else if (charAt == ',') {
            return AlfabetoEnum.COMA;
        } else if (charAt == '\'') {
            return AlfabetoEnum.COMILLA_SIMPLE;
        } else if (charAt == '(' || charAt == ')') {
            return AlfabetoEnum.PARENTESIS;
        } else if (charAt == '[' || charAt == ']') {
            return AlfabetoEnum.CORCHETES;
        } else if (charAt == '#') {
            return AlfabetoEnum.NUMERAL;
        } else if ((valor >= 33) && (valor <= 126)) {
            return AlfabetoEnum.SIMBOLO_VARIO;
        } else if ((charAt == '\n')) {
            return AlfabetoEnum.NUEVA_LINEA;
        } else if ((valor == 32) || (charAt == ' ')) {
            return AlfabetoEnum.ESPACIO;
        } else {
            return AlfabetoEnum.ERROR;            
        }
    }
    
}
