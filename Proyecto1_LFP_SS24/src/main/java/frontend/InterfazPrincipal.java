/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AnalizadorCodigo;
import backend.DocumentoHTML;
import backend.DocumentoReporteOptimizacion;
import backend.DocumentoReporteTokens;
import backend.Token;
import backend.TokenEstado;
import backend.css.model.TokenCSS;
import backend.html.model.TokenHTML;
import backend.js.model.TokenJS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Cotom
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    private ArrayList<Token> tokensAnalizados;
    private ArrayList<Token> tokensOptimizados;
    private ArrayList<Token> tokensError;
    private AnalizadorCodigo compilador;
    private final DefaultTableModel modeloTablaTokens;
    private final DefaultTableModel modeloTablaOptimizacion;
    private final DefaultTableModel modeloTablaErrores;

    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        this.modeloTablaTokens = new DefaultTableModel();
        this.modeloTablaOptimizacion = new DefaultTableModel();
        this.modeloTablaErrores = new DefaultTableModel();
        initComponents();
        this.tokensAnalizados = new ArrayList<>();
        this.tokensOptimizados = new ArrayList<>();
        this.tokensError = new ArrayList<>();
        this.btnExportar.setEnabled(false);
        this.btnReporteTokens.setEnabled(false);
        this.btnReporteOptimizacion.setEnabled(false);
        this.btnReporteErrores.setEnabled(false);
        this.iniciarTableros();
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
        dlgReporteTokens = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReporteTokens = new javax.swing.JTable();
        btnExportarTokens = new javax.swing.JButton();
        dlgReporteOptimizacion = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblReporteOptimizacion = new javax.swing.JTable();
        btnExportarOptimizacion = new javax.swing.JButton();
        dlgReporteErrores = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblReporteErrores = new javax.swing.JTable();
        btnCarga = new javax.swing.JButton();
        btnTraducir = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnReporteTokens = new javax.swing.JButton();
        btnReporteOptimizacion = new javax.swing.JButton();
        btnReporteErrores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaCodigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaCompilado = new javax.swing.JTextArea();

        dlgReporteTokens.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlgReporteTokens.setTitle("Reporte Tokens");
        dlgReporteTokens.setMinimumSize(new java.awt.Dimension(900, 400));

        tblReporteTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Token", "Expresion Regular", "Lenguaje", "Tipo", "Fila", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblReporteTokens);
        if (tblReporteTokens.getColumnModel().getColumnCount() > 0) {
            tblReporteTokens.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblReporteTokens.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        btnExportarTokens.setText("Exportar a HTML");
        btnExportarTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarTokensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgReporteTokensLayout = new javax.swing.GroupLayout(dlgReporteTokens.getContentPane());
        dlgReporteTokens.getContentPane().setLayout(dlgReporteTokensLayout);
        dlgReporteTokensLayout.setHorizontalGroup(
            dlgReporteTokensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteTokensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgReporteTokensLayout.createSequentialGroup()
                .addContainerGap(396, Short.MAX_VALUE)
                .addComponent(btnExportarTokens)
                .addGap(386, 386, 386))
        );
        dlgReporteTokensLayout.setVerticalGroup(
            dlgReporteTokensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteTokensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportarTokens)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        dlgReporteOptimizacion.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlgReporteOptimizacion.setTitle("Reporte de Optimizacion");
        dlgReporteOptimizacion.setMinimumSize(new java.awt.Dimension(900, 400));

        tblReporteOptimizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Token", "Expresion Regular", "Lenguaje", "Tipo", "Fila", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblReporteOptimizacion);
        if (tblReporteOptimizacion.getColumnModel().getColumnCount() > 0) {
            tblReporteOptimizacion.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblReporteOptimizacion.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        btnExportarOptimizacion.setText("Exportar a HTML");
        btnExportarOptimizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarOptimizacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgReporteOptimizacionLayout = new javax.swing.GroupLayout(dlgReporteOptimizacion.getContentPane());
        dlgReporteOptimizacion.getContentPane().setLayout(dlgReporteOptimizacionLayout);
        dlgReporteOptimizacionLayout.setHorizontalGroup(
            dlgReporteOptimizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteOptimizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgReporteOptimizacionLayout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(btnExportarOptimizacion)
                .addGap(382, 382, 382))
        );
        dlgReporteOptimizacionLayout.setVerticalGroup(
            dlgReporteOptimizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteOptimizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportarOptimizacion)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        dlgReporteErrores.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlgReporteErrores.setTitle("Reporte de Errores");
        dlgReporteErrores.setMinimumSize(new java.awt.Dimension(900, 300));

        tblReporteErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Token", "Lenguaje donde se Encontro", "Lenguaje Sugerido", "Fila", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblReporteErrores);
        if (tblReporteErrores.getColumnModel().getColumnCount() > 0) {
            tblReporteErrores.getColumnModel().getColumn(3).setPreferredWidth(20);
            tblReporteErrores.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        javax.swing.GroupLayout dlgReporteErroresLayout = new javax.swing.GroupLayout(dlgReporteErrores.getContentPane());
        dlgReporteErrores.getContentPane().setLayout(dlgReporteErroresLayout);
        dlgReporteErroresLayout.setHorizontalGroup(
            dlgReporteErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteErroresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgReporteErroresLayout.setVerticalGroup(
            dlgReporteErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgReporteErroresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCarga.setText("Cargar Archivo");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });

        btnTraducir.setText("Compilar");
        btnTraducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraducirActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar HTML");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnReporteTokens.setText("Reporte de Tokens");
        btnReporteTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTokensActionPerformed(evt);
            }
        });

        btnReporteOptimizacion.setText("Reporte de Optimizacion");
        btnReporteOptimizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteOptimizacionActionPerformed(evt);
            }
        });

        btnReporteErrores.setText("Reporte de Errores");
        btnReporteErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteErroresActionPerformed(evt);
            }
        });

        txaCodigo.setColumns(20);
        txaCodigo.setRows(5);
        jScrollPane1.setViewportView(txaCodigo);

        txaCompilado.setEditable(false);
        txaCompilado.setColumns(20);
        txaCompilado.setRows(5);
        jScrollPane2.setViewportView(txaCompilado);

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
        this.compilador = new AnalizadorCodigo();
        if (this.txaCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe de Ingresar Codigo Fuente");
            return;
        }
        String codigoOptimizado = compilador.optimizarCodigo(this.txaCodigo.getText());
        compilador.analizarCodigoFuente(codigoOptimizado);
        this.tokensAnalizados = this.compilador.getTokensAnalizados();
        this.tokensOptimizados = this.compilador.getTokensOptimizados();
        this.tokensError = this.compilador.getTokensError();
        this.txaCompilado.setText(compilador.getCodigoCompilado());
        this.btnExportar.setEnabled(true);
        this.btnReporteTokens.setEnabled(true);
        this.btnReporteOptimizacion.setEnabled(true);
        this.btnReporteErrores.setEnabled(true);
    }//GEN-LAST:event_btnTraducirActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        DocumentoHTML documentoHTML = new DocumentoHTML();
        documentoHTML.setCodigoHTML(this.compilador.getBloquesCodigoHTML());
        documentoHTML.setCodigoCSS(this.compilador.getBloquesCodigoCSS());
        documentoHTML.setCodigoJS(this.compilador.getBloquesCodigoJS());
        documentoHTML.generarDocumento();
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnReporteTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTokensActionPerformed
        vaciarTablaTokens();
        llenarTablaTokens();
        this.dlgReporteTokens.setVisible(true);
        this.dlgReporteTokens.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnReporteTokensActionPerformed

    private void btnReporteOptimizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteOptimizacionActionPerformed
        vaciarTablaOptimizacion();
        llenarTablaOptimizacion();
        this.dlgReporteOptimizacion.setVisible(true);
        this.dlgReporteOptimizacion.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnReporteOptimizacionActionPerformed

    private void btnExportarTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarTokensActionPerformed
        DocumentoReporteTokens reporteTokens = new DocumentoReporteTokens();
        reporteTokens.setTokensAnalizados(tokensAnalizados);
        reporteTokens.exportarReporteTokens();
    }//GEN-LAST:event_btnExportarTokensActionPerformed

    private void btnExportarOptimizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarOptimizacionActionPerformed
        DocumentoReporteOptimizacion reporteOptimizacion = new DocumentoReporteOptimizacion();
        reporteOptimizacion.setTokensOptimizados(tokensOptimizados);
        reporteOptimizacion.exportarReporteTokens();
    }//GEN-LAST:event_btnExportarOptimizacionActionPerformed

    private void btnReporteErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteErroresActionPerformed
        vaciarTablaErrores();
        llenarTablaErrores();
        this.dlgReporteErrores.setVisible(true);
        this.dlgReporteErrores.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnReporteErroresActionPerformed

    /**
     * Metodo que le da a la Tabla de Reporte en la interfaz el modelo adecuado
     * para su visualizacion
     */
    private void iniciarTableros() {
        this.tblReporteTokens.setModel(modeloTablaTokens);
        this.modeloTablaTokens.addColumn("Token");
        this.modeloTablaTokens.addColumn("Expresion Regular");
        this.modeloTablaTokens.addColumn("Lenguaje");
        this.modeloTablaTokens.addColumn("Tipo");
        this.modeloTablaTokens.addColumn("Fila");
        this.modeloTablaTokens.addColumn("Columna");

        this.tblReporteOptimizacion.setModel(modeloTablaOptimizacion);
        this.modeloTablaOptimizacion.addColumn("Token");
        this.modeloTablaOptimizacion.addColumn("Expresion Regular");
        this.modeloTablaOptimizacion.addColumn("Lenguaje");
        this.modeloTablaOptimizacion.addColumn("Tipo");
        this.modeloTablaOptimizacion.addColumn("Fila");
        this.modeloTablaOptimizacion.addColumn("Columna");
        
        this.tblReporteErrores.setModel(modeloTablaErrores);
        this.modeloTablaErrores.addColumn("Token");
        this.modeloTablaErrores.addColumn("Lenguaje donde se Encontro");
        this.modeloTablaErrores.addColumn("Lenguaje Sugerido");
        this.modeloTablaErrores.addColumn("Fila");
        this.modeloTablaErrores.addColumn("Columna");
    }

    /**
     * Metodo que muestra en la Tabla de Reporte en la interfaz los datos de
     * cada Token que esta se encontro en el analisis
     *
     * @param datos son los datos de cada token registrados
     */
    private void llenarTablaTokens() {
        this.tblReporteTokens.setModel(modeloTablaTokens);
        Object[] fila;
        for (int i = 0; i < this.tokensAnalizados.size(); i++) {
            fila = new Object[6];
            fila[0] = this.tokensAnalizados.get(i).getLexema();
            switch (this.tokensAnalizados.get(i)) {
                case TokenEstado token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTIPO_TOKEN();
                }
                case TokenHTML token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTipoToken();
                }
                case TokenCSS token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTipoToken();
                }
                case TokenJS token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTipoToken();
                }
                default -> {
                }
            }
            fila[4] = this.tokensAnalizados.get(i).getLinea();
            fila[5] = this.tokensAnalizados.get(i).getColumna();
            this.modeloTablaTokens.addRow(fila);
        }
    }

    /**
     * Metodo que muestra en la Tabla de Reporte en la interfaz los datos de
     * cada Token que esta se encontro en el analisis
     *
     * @param datos son los datos de cada token registrados
     */
    private void llenarTablaOptimizacion() {
        this.tblReporteOptimizacion.setModel(modeloTablaOptimizacion);
        Object[] fila;
        for (int i = 0; i < this.tokensOptimizados.size(); i++) {
            fila = new Object[6];
            fila[0] = this.tokensOptimizados.get(i).getLexema();
            switch (this.tokensOptimizados.get(i)) {
                case TokenEstado token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTIPO_TOKEN();
                }
                case TokenHTML token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTipoToken();
                }
                case TokenCSS token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTipoToken();
                }
                case TokenJS token -> {
                    fila[1] = token.getExpresionRegular();
                    fila[2] = token.getLENGUAJE();
                    fila[3] = token.getTipoToken();
                }
                default -> {
                }
            }
            fila[4] = this.tokensOptimizados.get(i).getLinea();
            fila[5] = this.tokensOptimizados.get(i).getColumna();
            this.modeloTablaOptimizacion.addRow(fila);
        }
    }
    
    /**
     * Metodo que muestra en la Tabla de Reporte en la interfaz los datos de
     * cada Token que esta se encontro en el analisis
     *
     * @param datos son los datos de cada token registrados
     */
    private void llenarTablaErrores() {
        this.tblReporteErrores.setModel(modeloTablaErrores);
        Object[] fila;
        for (int i = 0; i < this.tokensError.size(); i++) {
            fila = new Object[5];
            fila[0] = this.tokensError.get(i).getLexema();
            switch (this.tokensError.get(i)) {
                case TokenEstado token -> {
                    fila[1] = token.getLENGUAJE();
                }
                case TokenHTML token -> {
                    fila[1] = token.getLENGUAJE();
                }
                case TokenCSS token -> {
                    fila[1] = token.getLENGUAJE();
                }
                case TokenJS token -> {
                    fila[1] = token.getLENGUAJE();
                }
                default -> {
                }
            }
            fila[3] = this.tokensError.get(i).getLinea();
            fila[4] = this.tokensError.get(i).getColumna();
            this.modeloTablaErrores.addRow(fila);
        }
    }

    /**
     * Metodo que limpia la Tabla de Reporte en la Interfaz para no tener
     * problemas de colapsos
     */
    private void vaciarTablaTokens() {
        this.tblReporteTokens.removeAll();
        int filasTabla = this.modeloTablaTokens.getRowCount();
        if (filasTabla != 0) {
            for (int i = 0; i < filasTabla; i++) {
                this.modeloTablaTokens.removeRow(0);
            }
        }
    }

    /**
     * Metodo que limpia la Tabla de Reporte en la Interfaz para no tener
     * problemas de colapsos
     */
    private void vaciarTablaOptimizacion() {
        this.tblReporteOptimizacion.removeAll();
        int filasTabla = this.modeloTablaOptimizacion.getRowCount();
        if (filasTabla != 0) {
            for (int i = 0; i < filasTabla; i++) {
                this.modeloTablaOptimizacion.removeRow(0);
            }
        }
    }
    
    /**
     * Metodo que limpia la Tabla de Reporte en la Interfaz para no tener
     * problemas de colapsos
     */
    private void vaciarTablaErrores() {
        this.tblReporteErrores.removeAll();
        int filasTabla = this.modeloTablaErrores.getRowCount();
        if (filasTabla != 0) {
            for (int i = 0; i < filasTabla; i++) {
                this.modeloTablaErrores.removeRow(0);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarga;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnExportarOptimizacion;
    private javax.swing.JButton btnExportarTokens;
    private javax.swing.JButton btnReporteErrores;
    private javax.swing.JButton btnReporteOptimizacion;
    private javax.swing.JButton btnReporteTokens;
    private javax.swing.JButton btnTraducir;
    private javax.swing.JDialog dlgReporteErrores;
    private javax.swing.JDialog dlgReporteOptimizacion;
    private javax.swing.JDialog dlgReporteTokens;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblReporteErrores;
    private javax.swing.JTable tblReporteOptimizacion;
    private javax.swing.JTable tblReporteTokens;
    private javax.swing.JTextArea txaCodigo;
    private javax.swing.JTextArea txaCompilado;
    // End of variables declaration//GEN-END:variables
}
