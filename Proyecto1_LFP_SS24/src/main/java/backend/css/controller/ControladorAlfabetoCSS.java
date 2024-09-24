/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.css.controller;

import backend.css.model.AlfabetoEnumCSS;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorAlfabetoCSS {
    
    public boolean isEspacioBlanco(char charAt) {
        return Character.isWhitespace(charAt);
    }
    
    public boolean isNuevaLinea(char charAt) {
        return (charAt == '\n');
    }
    
    public AlfabetoEnumCSS getAlfabeto(char charAt) {
        int valor = charAt;
        if ((valor >= 65) && (valor <= 90)) {
            return AlfabetoEnumCSS.LETRA_MAYUSCULA;
        } else if ((valor >= 97) && (valor <= 122)) {
            return AlfabetoEnumCSS.LETRA_MINUSCULA;        
        } else if ((valor >= 48) && (valor <= 57)) {
            return AlfabetoEnumCSS.NUMERO;        
        } else if (charAt == '-') {
            return AlfabetoEnumCSS.GUION_MEDIO;
        } else if (valor == '>' || valor == '~' || valor == '+') {
            return AlfabetoEnumCSS.CONBINADORES;
        } else if (charAt == '*') {
            return AlfabetoEnumCSS.ASTERISCO;
        } else if (charAt == ':') {
            return AlfabetoEnumCSS.DOS_PUNTOS;
        } else if (charAt == ';') {
            return AlfabetoEnumCSS.PUNTO_COMA;
        } else if (charAt == '%') {
            return AlfabetoEnumCSS.PORCENTAJE;
        } else if (charAt == '.') {
            return AlfabetoEnumCSS.PUNTO;
        } else if (charAt == ',') {
            return AlfabetoEnumCSS.COMA;
        } else if (charAt == '\'') {
            return AlfabetoEnumCSS.COMILLA_SIMPLE;
        } else if (charAt == '(' || charAt == ')') {
            return AlfabetoEnumCSS.PARENTESIS;
        } else if (charAt == '{' || charAt == '}') {
            return AlfabetoEnumCSS.LLAVE;
        } else if (charAt == '[' || charAt == ']') {
            return AlfabetoEnumCSS.CORCHETES;
        } else if (charAt == '#') {
            return AlfabetoEnumCSS.NUMERAL;
        } else if (valor == '/') {
            return AlfabetoEnumCSS.DIAGONAL;
        } else if ((valor >= 33) && (valor <= 126)) {
            return AlfabetoEnumCSS.SIMBOLO_VARIO;
        } else if ((charAt == '\n')) {
            return AlfabetoEnumCSS.NUEVA_LINEA;
        } else if ((valor == 32) || (charAt == ' ')) {
            return AlfabetoEnumCSS.ESPACIO;
        } else {
            return AlfabetoEnumCSS.ERROR;            
        }
    }
    
}
