/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltergaldamez.vistas;

import com.waltergaldamez.dao.DAOProveedor;
import com.waltergaldamez.modelo.Proveedor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter Gdmz
 */
public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    public Form() {
        initComponents();
        tablaProveedor();
        setTitle("PROVEEDOR");
        setLocationRelativeTo(null);
        
    }
    
    Proveedor proveedor = new Proveedor();
    DAOProveedor daoProveedor = new DAOProveedor();
    
    public void tablaProveedor(){
        String [] columnas = {"Código Proveedor","Nombre","Dirección","Telefono"};
        Object [] obj = new Object[4];
        DefaultTableModel tabla = new DefaultTableModel(null,columnas);
        List lista;
        
        try{
            lista = daoProveedor.mostrarProveedor();
            for (int i = 0; i < lista.size(); i++) {
                proveedor = (Proveedor)lista.get(i);
                obj[0] = proveedor.getCodigoProveedor();
                obj[1] = proveedor.getNombre();
                obj[2] = proveedor.getDireccion();
                obj[3] = proveedor.getTelefono();
                tabla.addRow(obj);
            }
            
            lista = daoProveedor.mostrarProveedor();
            this.jTable1.setModel(tabla);            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error al mostrar datos del proveedor"+e.toString());
        }       
    }
    
    public void limpiar(){
        this.jTextNombre.setText("");
        this.jTextDireccion.setText("");
        this.jTextTelefono.setText("");
        this.jTextCodigoProveedor.setText("");
    }        
    
    public void insertar()throws Exception{
        
        proveedor.setCodigoProveedor(Integer.parseInt(this.jTextCodigoProveedor.getText()));
        proveedor.setNombre(this.jTextNombre.getText());
        proveedor.setDireccion(this.jTextDireccion.getText());
        proveedor.setTelefono(this.jTextTelefono.getText());
        daoProveedor.insertarProveedor(proveedor);
        int alerta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Agregar los Datos","Modificar Datos Proveedor",JOptionPane.YES_NO_OPTION);
        
        if (alerta==0) {
            daoProveedor.modificarProveedor(proveedor);
            JOptionPane.showMessageDialog(this, "Proveedor Agregado Correctamente");
            tablaProveedor();
            limpiar();
        }else{
            limpiar();
        }
        
    }
    
    public void modificar()throws Exception{
        try{
        proveedor.setNombre(this.jTextNombre.getText());
        proveedor.setDireccion(this.jTextDireccion.getText());
        proveedor.setTelefono(this.jTextTelefono.getText());
        proveedor.setCodigoProveedor(Integer.parseInt(this.jTextCodigoProveedor.getText()));
        int alerta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Modificar los Datos","Modificar Datos Proveedor",JOptionPane.YES_NO_OPTION);
        
        if (alerta==0) {
            daoProveedor.modificarProveedor(proveedor);
            JOptionPane.showMessageDialog(this, "Proveedor Modificado Correctamente");
            tablaProveedor();
            limpiar();
        }else{
            limpiar();
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.toString(),"Error al Modificar datos del proveedor", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(){
        try{
            proveedor.setCodigoProveedor(Integer.parseInt(this.jTextCodigoProveedor.getText()));
            int alerta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Eliminar los Datos","Eliminar Datos Proveedor",JOptionPane.YES_NO_OPTION);
        
            if (alerta==0) {
                daoProveedor.eliminarProveedor(proveedor);
                JOptionPane.showMessageDialog(this, "Proveedor Eliminado Correctamente");
                tablaProveedor();
                limpiar();
            }else{
                limpiar();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.toString(),"Error al Eliminar datos del proveedor", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenar(){
        int fila = this.jTable1.getSelectedRow();
        int columna=0;
        this.jTextCodigoProveedor.setText(String.valueOf(this.jTable1.getValueAt(fila, columna++)));
        this.jTextNombre.setText(String.valueOf(this.jTable1.getValueAt(fila, columna++)));
        this.jTextDireccion.setText(String.valueOf(this.jTable1.getValueAt(fila, columna++)));
        this.jTextTelefono.setText(String.valueOf(this.jTable1.getValueAt(fila, columna)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCodigoProveedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("PROVEEDOR");

        jLabel2.setText("Código");

        jTextCodigoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodigoProveedorActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Dirección");

        jLabel5.setText("Telefono");

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jTextCodigoProveedor)
                        .addComponent(jTextNombre)
                        .addComponent(jTextDireccion)
                        .addComponent(jTextTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpiar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonModificar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEliminar)
                            .addComponent(jButtonLimpiar))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodigoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodigoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodigoProveedorActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        try {
            // TODO add your handling code here:
            insertar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        llenar();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        try {
            // TODO add your handling code here:
            modificar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCodigoProveedor;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables
}
