/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.html.model.AnalizadorLexico;
import backend.html.model.Token;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Carlos Cotom
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    private ArrayList<Token> tokensHTML;
    private final AnalizadorLexico analizadorHTML;
    
    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
        this.analizadorHTML = new AnalizadorLexico();
        this.tokensHTML = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        btnCarga = new javax.swing.JButton();
        btnTraducir = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnReporteTokens = new javax.swing.JButton();
        btnReporteOptimizacion = new javax.swing.JButton();
        btnReporteErrores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaCodigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCarga.setText("Cargar Archivo");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });

        btnTraducir.setText("Traducir");
        btnTraducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraducirActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar HTML");

        btnReporteTokens.setText("Reporte de Tokens");

        btnReporteOptimizacion.setText("Reporte de Optimizacion");

        btnReporteErrores.setText("Reporte de Errores");

        txaCodigo.setColumns(20);
        txaCodigo.setRows(5);
        jScrollPane1.setViewportView(txaCodigo);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCarga)
                        .addGap(18, 18, 18)
                        .addComponent(btnTraducir)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportar)
                        .addGap(18, 18, 18)
                        .addComponent(btnReporteTokens)
                        .addGap(18, 18, 18)
                        .addComponent(btnReporteOptimizacion)
                        .addGap(18, 18, 18)
                        .addComponent(btnReporteErrores))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCarga)
                    .addComponent(btnTraducir)
                    .addComponent(btnExportar)
                    .addComponent(btnReporteTokens)
                    .addComponent(btnReporteOptimizacion)
                    .addComponent(btnReporteErrores))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "txt");
        jFileChooser1.setFileFilter(filtro);
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser1.setVisible(true);
        int resultado = jFileChooser1.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(jFileChooser1.getSelectedFile()))) {
                this.txaCodigo.read(reader, null);
            } catch (IOException e) {
                System.out.println("Error al imprimir el codigo fuente");
            }
        }
    }//GEN-LAST:event_btnCargaActionPerformed

    private void btnTraducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraducirActionPerformed
        if (!this.tokensHTML.isEmpty()) {
            this.tokensHTML.clear();
        }
        this.tokensHTML = this.analizadorHTML.getTokens(this.txaCodigo.getText());
    }//GEN-LAST:event_btnTraducirActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarga;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnReporteErrores;
    private javax.swing.JButton btnReporteOptimizacion;
    private javax.swing.JButton btnReporteTokens;
    private javax.swing.JButton btnTraducir;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea txaCodigo;
    // End of variables declaration//GEN-END:variables
}
