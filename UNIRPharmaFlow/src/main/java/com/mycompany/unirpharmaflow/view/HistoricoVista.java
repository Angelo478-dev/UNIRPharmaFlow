/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.unirpharmaflow.view;

import com.mycompany.unirpharmaflow.model.Pedido;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angelo
 */
public class HistoricoVista extends javax.swing.JFrame {

    /**
     * Constructor de la clase HistoricoVista.
     */
    public HistoricoVista() {
        setTitle("Historico de Pedidos de Medicamentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        InitComponents();
    }

    /**
     * Inicializa los componentes principales de la ventana.
     */
    private void InitComponents() {
        // Configuración de la tabla
        tblHistorico = new JTable();
        String[] columnas = {"N° Pedido", "Distribuidor", "Tipo", "Nombre", "Cantidad", "Sucursal", "Confirmado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        tblHistorico.setModel(modelo);
        tblHistorico.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        // ScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(tblHistorico);

        // Etiqueta para el contador de pedidos
        jCantidadPedidos = new JLabel("Número de pedidos: 0");

        // Configuración del layout y agregación de componentes
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(jCantidadPedidos, BorderLayout.SOUTH);

        // Ajustar el tamaño de la ventana automáticamente
        pack();
    }

    /**
     * Agrega un nuevo pedido al historial.
     *
     * @param pedido El pedido a agregar.
     * @param numeroPedido El número del pedido.
     */
    public void AgregarPedidoATabla(Pedido pedido, int numeroPedido) {
        DefaultTableModel modelo = (DefaultTableModel) tblHistorico.getModel();

        // Agregar los datos del pedido como una nueva fila
        modelo.addRow(new Object[]{
            numeroPedido,
            pedido.getDistribuidor(),
            pedido.getTipoMedicamento(),
            pedido.getNombreMedicamento(),
            pedido.getCantidad(),
            pedido.getSucursal(),
            "Si"
        });

        // Actualizar el contador de pedidos
        jCantidadPedidos.setText("Número de pedidos: " + modelo.getRowCount());

        // Ajustar el tamaño de la ventana después de agregar un pedido
        ajustarTamañoVentana();
    }

    /**
     * Ajusta el tamaño de la ventana en función del contenido de la tabla.
     */
    private void ajustarTamañoVentana() {
        tblHistorico.setPreferredScrollableViewportSize(tblHistorico.getPreferredSize());
        tblHistorico.revalidate();
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        jCantidadPedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Distribuidor", "Tipo", "Medicamento", "Cantidad", "Sucursal"
            }
        ));
        jScrollPane2.setViewportView(tblHistorico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCantidadPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCantidadPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jCantidadPedidos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHistorico;
    // End of variables declaration//GEN-END:variables
}