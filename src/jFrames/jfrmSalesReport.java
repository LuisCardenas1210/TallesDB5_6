/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrames;

import daos.salesReportDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.modReporteTrimestral;
import modelos.modReporteMensual;
import modelos.modReporteEmpleado;

/**
 *
 * @author jovan
 */
public class jfrmSalesReport extends javax.swing.JFrame {

    salesReportDAO dao = new salesReportDAO();
    
    
    /**
     * Creates new form jfrmSalesReport
     */
    public jfrmSalesReport() {
        setUndecorated(true);
        initComponents();       
        
        // Estos dos metodos oculatan la tabla
        jScrollPane1.setVisible(false);
        jtSales.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnExit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSales = new javax.swing.JTable();
        btnQuarterlySales = new javax.swing.JButton();
        btnVentaPorEmpleado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVentaPorMes = new javax.swing.JButton();
        cbMes = new javax.swing.JComboBox<>();
        btnBackToMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(660, 540));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit1.setBackground(new java.awt.Color(153, 0, 0));
        btnExit1.setText("X");
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 40, 30));

        jtSales.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtSales);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 670, 390));

        btnQuarterlySales.setBackground(new java.awt.Color(153, 102, 0));
        btnQuarterlySales.setText("Venta por trimestre");
        btnQuarterlySales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuarterlySalesActionPerformed(evt);
            }
        });
        jPanel2.add(btnQuarterlySales, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, 30));

        btnVentaPorEmpleado.setBackground(new java.awt.Color(153, 102, 0));
        btnVentaPorEmpleado.setText("Ventas por empleado");
        btnVentaPorEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaPorEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(btnVentaPorEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, 30));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        btnVentaPorMes.setBackground(new java.awt.Color(153, 102, 0));
        btnVentaPorMes.setText("Ventas por mes");
        btnVentaPorMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaPorMesActionPerformed(evt);
            }
        });
        jPanel2.add(btnVentaPorMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 140, 30));

        cbMes.setBackground(new java.awt.Color(153, 102, 0));
        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre" }));
        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerformed(evt);
            }
        });
        jPanel2.add(cbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 110, 30));

        btnBackToMenu.setBackground(new java.awt.Color(153, 102, 0));
        btnBackToMenu.setText("Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnBackToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 120, 30));

        jLabel2.setText("Ingresa el año (Ejemplo: 2016)");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));
        jPanel2.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 150, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void btnQuarterlySalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuarterlySalesActionPerformed
        // este evento es propiedad de jovanny
        ArrayList<modReporteTrimestral> reportes = dao.readA();
        // Crear los encabezados de la tabla
        String[] columnNames = {"Producto", "Trim 1", "Trim 2", "Trim 3", "Trim 4"};

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Llenar la tabla con los datos obtenidos
        for (modReporteTrimestral reporte : reportes) {
            model.addRow(new Object[] {
                reporte.getProducto(),
                reporte.getTrim1(),
                reporte.getTrim2(),
                reporte.getTrim3(),
                reporte.getTrim4()
            });
        }
        jtSales.setModel(model);
        jScrollPane1.setVisible(true);
        jtSales.setVisible(true);
       
    }//GEN-LAST:event_btnQuarterlySalesActionPerformed

    private void btnVentaPorEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaPorEmpleadoActionPerformed
        ArrayList<modReporteEmpleado> reportes = dao.readC(txtAnio.getText(), cbMes.getSelectedIndex()+1);
        // Crear los encabezados de la tabla
        String[] columnNames = {"Empleado", "Total", "Cant.Ventas"};

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Llenar la tabla con los datos obtenidos
        for (modReporteEmpleado reporte : reportes) {
            model.addRow(new Object[] {
                reporte.getEmpleado(),
                reporte.getTotal(),
                reporte.getCantVentas()
            });
        }
        jtSales.setModel(model);
        jScrollPane1.setVisible(true);
        jtSales.setVisible(true);
    }//GEN-LAST:event_btnVentaPorEmpleadoActionPerformed

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMesActionPerformed

    private void btnVentaPorMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaPorMesActionPerformed
        ArrayList<modReporteMensual> reportes = dao.readB(txtAnio.getText(), cbMes.getSelectedIndex()+1);
        // Crear los encabezados de la tabla
        String[] columnNames = {"Num.Orden", "Fecha", "Cliente", "Emleado", "Total", "Cant.Detalles"};

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Llenar la tabla con los datos obtenidos
        for (modReporteMensual reporte : reportes) {
            model.addRow(new Object[] {
                reporte.getNumOrden(),
                reporte.getFecha(),
                reporte.getCliente(),
                reporte.getEmpleado(),
                reporte.getTotal(),
                reporte.getCantDetalles()
            });
        }
        jtSales.setModel(model);
        jScrollPane1.setVisible(true);
        jtSales.setVisible(true);
    }//GEN-LAST:event_btnVentaPorMesActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        jfrmMenu menuFrame = new jfrmMenu();
        menuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackToMenuActionPerformed

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
            java.util.logging.Logger.getLogger(jfrmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmSalesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton btnQuarterlySales;
    private javax.swing.JButton btnVentaPorEmpleado;
    private javax.swing.JButton btnVentaPorMes;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtSales;
    private javax.swing.JTextField txtAnio;
    // End of variables declaration//GEN-END:variables
}