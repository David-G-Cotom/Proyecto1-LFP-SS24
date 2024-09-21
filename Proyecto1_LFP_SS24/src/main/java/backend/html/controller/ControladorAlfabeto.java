/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.html.controller;

import backend.html.model.AlfabetoEnum;

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
        } else if (valor == '/') {
            return AlfabetoEnum.DIAGONAL;
        } else if (charAt == '=') {
            return AlfabetoEnum.IGUAL;
        } else if (charAt == '<') {
            return AlfabetoEnum.MENOR_QUE;
        } else if (charAt == '>') {
            return AlfabetoEnum.MAYOR_QUE;
        } else if (charAt == '"') {
            return AlfabetoEnum.COMILLA_DOBLE;
        } else if ((valor >= 32) && (valor <= 126)) {
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
