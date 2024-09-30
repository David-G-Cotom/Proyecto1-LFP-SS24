/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.css.model.TokenCSS;
import backend.html.model.TokenHTML;
import backend.js.model.TokenJS;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class DocumentoReporteTokens {

    private ArrayList<Token> tokensAnalizados = new ArrayList<>();

    public ArrayList<Token> getTokensAnalizados() {
        return tokensAnalizados;
    }

    public void setTokensAnalizados(ArrayList<Token> tokensAnalizados) {
        this.tokensAnalizados = tokensAnalizados;
    }

    public void exportarReporteTokens() {
        String data = obtenerCabeceraHTML();
        data += generarContenido(data);
        this.generarReporte(data);
    }

    private String obtenerCabeceraHTML() {
        return """
                <html>                   
                <head>
                      <title>Reporte de Tokens</title>
                </head>
                <style>
                     table, th, td {
                         border:1px solid black;
                         border-collapse: collapse;
                     }
                     th, td {
                         padding: 10px;
                     }
                </style>
                <body>
               """;
    }

    private String generarContenido(String data) {
        data += """
                <table>
                    <tr>
                        <th>Token</th>
                        <th>Expresion Regular</th>
                        <th>Lenguaje</th>
                        <th>Tipo</th>
                        <th>Fila</th>
                        <th>Columna</th>
                    </tr>
                """;
        for (Token tokenAnalizado : tokensAnalizados) {
            String expresionRegular = "";
            String lenguaje = "";
            String tipo = "";
            switch (tokenAnalizado) {
                case TokenEstado token -> {
                    expresionRegular = token.getExpresionRegular();
                    lenguaje = token.getLENGUAJE();
                    tipo = token.getTIPO_TOKEN();
                }
                case TokenHTML token -> {
                    expresionRegular = token.getExpresionRegular();
                    lenguaje = token.getLENGUAJE();
                    tipo = token.getTipoToken().toString();
                }
                case TokenCSS token -> {
                    expresionRegular = token.getExpresionRegular();
                    lenguaje = token.getLENGUAJE();
                    tipo = token.getTipoToken().toString();
                }
                case TokenJS token -> {
                    expresionRegular = token.getExpresionRegular();
                    lenguaje = token.getLENGUAJE();
                    tipo = token.getTipoToken().toString();
                }
                default -> {
                }
            }
            data += """
                    <tr>
                    <td>""" + tokenAnalizado.getLexema() + "</td>"
                    + "\n<td>" + expresionRegular + "</td>"
                    + "\n<td>" + lenguaje + "</td>"
                    + "\n<td>" + tipo + "</td>"
                    + "\n<td>" + tokenAnalizado.getLinea() + "</td>"
                    + "\n<td>" + tokenAnalizado.getColumna() + "</td>"
                    + "\n</tr>";
        }
        data += "\n</table>";
        return data;
    }
    
    private void generarReporte(String contenido) {
        String nombreBase = "reporteTokens";
        String extensionImagen = ".html";
        File file = new File(nombreBase + extensionImagen);
        int version = 1;
        while (file.exists()) {
            file = new File(nombreBase + " " + version+ extensionImagen);
            version++;
        }
        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter writer = new BufferedWriter(fileWriter);) {
            writer.append(contenido);
            writer.append("\n</body>");
            writer.append("\n</html>");
            System.out.println("REPORTE DE TOKENS CREADO!!!");
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el Documento HTML de la aplicacion");
        }
    }

}
