/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.js.controller;

import backend.js.model.AlfabetoEnumJS;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorAlfabetoJS {
    
    public boolean isEspacioBlanco(char charAt) {
        return Character.isWhitespace(charAt);
    }
    
    public boolean isNuevaLinea(char charAt) {
        return (charAt == '\n');
    }
    
    public AlfabetoEnumJS getAlfabeto(char charAt) {
        int valor = charAt;
        if (((valor >= 65) && (valor <= 90)) || ((valor >= 97) && (valor <= 122))) {
            return AlfabetoEnumJS.LETRA;
        } else if ((valor >= 48) && (valor <= 57)) {
            return AlfabetoEnumJS.NUMERO;        
        } else if (charAt == '_') {
            return AlfabetoEnumJS.GUION_BAJO;
        } else if (valor == '+') {
            return AlfabetoEnumJS.SUMA;
        } else if (valor == '-') {
            return AlfabetoEnumJS.RESTA;
        } else if (valor == '*') {
            return AlfabetoEnumJS.MULTIPLICACION;
        } else if (valor == '/') {
            return AlfabetoEnumJS.DIAGONAL;
        } else if (charAt == '=') {
            return AlfabetoEnumJS.IGUAL;
        } else if (charAt == '<') {
            return AlfabetoEnumJS.MENOR_QUE;
        } else if (charAt == '>') {
            return AlfabetoEnumJS.MAYOR_QUE;
        } else if (charAt == '!') {
            return AlfabetoEnumJS.EXCLAMACION;
        } else if (charAt == '|') {
            return AlfabetoEnumJS.RAYA;
        } else if (charAt == '&') {
            return AlfabetoEnumJS.AMPER;
        } else if (charAt == '.') {
            return AlfabetoEnumJS.PUNTO;
        } else if (charAt == ',') {
            return AlfabetoEnumJS.COMA;
        } else if (charAt == ':') {
            return AlfabetoEnumJS.DOS_PUNTOS;
        } else if (charAt == ';') {
            return AlfabetoEnumJS.PUNTO_COMA;
        } else if (charAt == '"') {
            return AlfabetoEnumJS.COMILLA_DOBLE;
        } else if (charAt == '\'') {
            return AlfabetoEnumJS.COMILLA_SIMPLE;
        } else if (charAt == '`') {
            return AlfabetoEnumJS.ACENTO;
        } else if (charAt == '(' || charAt == ')') {
            return AlfabetoEnumJS.PARENTESIS;
        } else if (charAt == '{' || charAt == '}') {
            return AlfabetoEnumJS.LLAVE;
        } else if (charAt == '[' || charAt == ']') {
            return AlfabetoEnumJS.CORCHETE;
        } else if ((valor >= 33) && (valor <= 126)) {
            return AlfabetoEnumJS.SIMBOLO_VARIO;
        } else if ((charAt == '\n')) {
            return AlfabetoEnumJS.NUEVA_LINEA;
        } else if ((valor == 32) || (charAt == ' ')) {
            return AlfabetoEnumJS.ESPACIO;
        } else {
            return AlfabetoEnumJS.ERROR;            
        }
    }
    
}
