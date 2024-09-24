/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.controller;

import backend.html.model.AlfabetoEnumHTML;

/**
 *
 * @author Carlos Cotom
 */
public class ControladorAlfabetoHTML {
    
    public boolean isEspacioBlanco(char charAt) {
        return Character.isWhitespace(charAt);
    }
    
    public boolean isNuevaLinea(char charAt) {
        return (charAt == '\n');
    }
    
    public AlfabetoEnumHTML getAlfabeto(char charAt) {
        int valor = charAt;
        if (((valor >= 65) && (valor <= 90)) || ((valor >= 97) && (valor <= 122))) {
            return AlfabetoEnumHTML.LETRA;
        } else if ((valor >= 48) && (valor <= 57)) {
            return AlfabetoEnumHTML.NUMERO;
        } else if (valor == '/') {
            return AlfabetoEnumHTML.DIAGONAL;
        } else if (charAt == '=') {
            return AlfabetoEnumHTML.IGUAL;
        } else if (charAt == '<') {
            return AlfabetoEnumHTML.MENOR_QUE;
        } else if (charAt == '>') {
            return AlfabetoEnumHTML.MAYOR_QUE;
        } else if (charAt == '"') {
            return AlfabetoEnumHTML.COMILLA_DOBLE;
        } else if (((valor >= 32) && (valor <= 126)) || ((valor >= 128) && (valor <= 255))) {
            return AlfabetoEnumHTML.SIMBOLO_VARIO;
        } else if ((charAt == '\n')) {
            return AlfabetoEnumHTML.NUEVA_LINEA;
        } else if ((valor == 32) || (charAt == ' ')) {
            return AlfabetoEnumHTML.ESPACIO;
        } else {
            return AlfabetoEnumHTML.ERROR;            
        }
    }
    
}
