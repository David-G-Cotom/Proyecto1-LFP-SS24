/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class DocumentoHTML {

    private ArrayList<String> codigoHTML = new ArrayList<>();
    private ArrayList<String> codigoCSS = new ArrayList<>();
    private ArrayList<String> codigoJS = new ArrayList<>();

    public ArrayList<String> getCodigoHTML() {
        return codigoHTML;
    }

    public void setCodigoHTML(ArrayList<String> codigoHTML) {
        this.codigoHTML = codigoHTML;
    }

    public ArrayList<String> getCodigoCSS() {
        return codigoCSS;
    }

    public void setCodigoCSS(ArrayList<String> codigoCSS) {
        this.codigoCSS = codigoCSS;
    }

    public ArrayList<String> getCodigoJS() {
        return codigoJS;
    }

    public void setCodigoJS(ArrayList<String> codigoJS) {
        this.codigoJS = codigoJS;
    }

    public void generarDocumento() {
        String data = obtenerCabeceraHTML();
        data += leerCodigoCSS();
        data += leerCodigoJS();
        data += """
                </head>
                <body>
                """;
        data += leerCodigoHTML();
        escribirDocumento(data);
    }

    private String leerCodigoHTML() {
        String codigo = "";
        if (this.codigoHTML.isEmpty()) {
            return codigo;
        }
        for (String string : codigoHTML) {
            codigo += string;
        }
        return codigo;
    }

    private String leerCodigoCSS() {
        String codigo = "";
        if (this.codigoCSS.isEmpty()) {
            return codigo;
        }
        codigo += "\n<style>";
        for (String string : codigoCSS) {
            codigo += string;
        }
        codigo += "\n</style>";
        return codigo;
    }

    private String leerCodigoJS() {
        String codigo = "";
        if (this.codigoJS.isEmpty()) {
            return codigo;
        }
        codigo += "\n<script>";
        for (String string : codigoJS) {
            codigo += string;
        }
        codigo += "\n</script>";
        return codigo;
    }

    private String obtenerCabeceraHTML() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
               """;
    }

    private void escribirDocumento(String contenido) {
        String nombreBase = "documento";
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
            System.out.println("DOCUMENTO CREADO!!!");
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el Documento HTML de la aplicacion");
        }
    }

}
