/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrames;

import daos.ProductDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.modProduct;

/**
 *
 * @author jovan
 */
public class jfrmProductInventory extends javax.swing.JFrame {

    /**
     * Creates new form jfrmProductInventory2
     */
    Conexion cx; 
    ProductDAO productsDAO = new ProductDAO(); 
    ArrayList<modProduct> list; 
    private jfrmMenu menuFrame; 
    DefaultTableModel model = new DefaultTableModel(); 
    modProduct product;
    int i = -1;
    public jfrmProductInventory(jfrmMenu menuFrame) {
        this.menuFrame = menuFrame;
        setUndecorated(true);
        initComponents();
        
        this.setLocationRelativeTo(null);
        model.addColumn("Product Code");
        model.addColumn("Product Name");
        model.addColumn("Price");
        model.addColumn("Quantity Available");
        cx = new Conexion();
        this.menuFrame = menuFrame;
        refreshTable();
    }
    public jfrmProductInventory(){}
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        tfProductCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNam = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfQuantityAvailable = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        btnModifyProduct = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jPanel2.add(btnExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 40, 30));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad"
            }
        ));
        tblProducts.setSelectionBackground(new java.awt.Color(102, 51, 0));
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducts);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 700, 230));

        tfProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProductCodeActionPerformed(evt);
            }
        });
        jPanel2.add(tfProductCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 270, 30));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jLabel3.setText("Código");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 90, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Nombre del producto");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));
        jPanel2.add(tfNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 280, 30));
        jPanel2.add(tfPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 150, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Precio");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Cantidad");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        tfQuantityAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantityAvailableActionPerformed(evt);
            }
        });
        jPanel2.add(tfQuantityAvailable, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 150, 30));

        jLabel13.setFont(new java.awt.Font("Palatino Linotype", 0, 24)); // NOI18N
        jLabel13.setText("Inventario de Productos");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 270, -1));

        btnAddProduct.setBackground(new java.awt.Color(102, 51, 0));
        btnAddProduct.setText("Agregar");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 110, 30));

        btnModifyProduct.setBackground(new java.awt.Color(102, 51, 0));
        btnModifyProduct.setText("Modificar");
        btnModifyProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyProductActionPerformed(evt);
            }
        });
        jPanel2.add(btnModifyProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 120, 30));

        btnCancel.setBackground(new java.awt.Color(102, 51, 0));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, 100, 30));

        btnDeleteProduct.setBackground(new java.awt.Color(102, 51, 0));
        btnDeleteProduct.setText("Eliminar");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, 130, 30));

        btnBackToMenu.setBackground(new java.awt.Color(102, 51, 0));
        btnBackToMenu.setText("Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnBackToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 120, 30));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setText("No dejes espacios en blanco");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, -1));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebidas", "Comida", "Frutas y verduras", "Cereales", "Lacteos", "Limpieza", "Higiene personal" }));
        jPanel2.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, -1, -1));

        jLabel1.setText("Categoria");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed

        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void tfProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProductCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProductCodeActionPerformed

    private void tfQuantityAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantityAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuantityAvailableActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        if (this.product == null) {
            this.product = new modProduct();
        }
        product.setProductCode(tfProductCode.getText());
        product.setNam(tfNam.getText());
        product.setCategoria(cbCategoria.getSelectedIndex()+1);
        try {
            product.setPrice(Double.parseDouble(tfPrice.getText()));
            product.setQuantityAvailable(Integer.parseInt(tfQuantityAvailable.getText()));
            String verify = productsDAO.create(product);
            if (verify.equals("true")) {
                refreshTable();
                JOptionPane.showMessageDialog(this, "Product registered successfully!");
                clean();
            } else {
                JOptionPane.showMessageDialog(this, verify);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Price and Quantity must be valid numbers.");
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnModifyProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyProductActionPerformed
        product.setProductCode(tfProductCode.getText());
        product.setNam(tfNam.getText());
        product.setCategoria(cbCategoria.getSelectedIndex()+1);
        try {
            product.setPrice(Double.parseDouble(tfPrice.getText()));
            product.setQuantityAvailable(Integer.parseInt(tfQuantityAvailable.getText()));
            String update = productsDAO.update(product);
            if (update.equals("true")) {
                refreshTable();
                JOptionPane.showMessageDialog(this, "Product details updated successfully.");
                clean();
            } else {
                JOptionPane.showMessageDialog(this, update);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Price and Quantity must be valid numbers.");
        }
    }//GEN-LAST:event_btnModifyProductActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clean();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        if (i > -1) {
            int res = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?", "DELETE", JOptionPane.YES_NO_OPTION);
            if (res == 0) {
                if (productsDAO.delete(list.get(i).getProductCode())) {
                    JOptionPane.showMessageDialog(this, "Product deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "An error occurred while deleting the product.");
                }
                refreshTable();
                clean();
            }
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        menuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackToMenuActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        i = tblProducts.getSelectedRow();
        product = productsDAO.read(list.get(i).getProductCode());
        tfProductCode.setText(product.getProductCode());
        tfNam.setText(product.getNam()); 
        tfPrice.setText(String.valueOf(product.getPrice()) );
        tfQuantityAvailable.setText(String.valueOf(product.getQuantityAvailable()) );
    }//GEN-LAST:event_tblProductsMouseClicked

    public void refreshTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        list = productsDAO.read(); 
        for (modProduct product : list) {
            Object fila[] = new Object[4];
            fila[0] = product.getProductCode();
            fila[1] = product.getNam();        
            fila[2] = product.getPrice();    
            fila[3] = product.getQuantityAvailable();
            model.addRow(fila);
        }
        tblProducts.setModel(model); 
    }
    
    public void clean() {
        tfProductCode.setText("");      
        tfNam.setText("");              
        tfPrice.setText("");            
        tfQuantityAvailable.setText(""); 
    }
    
    
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
            java.util.logging.Logger.getLogger(jfrmProductInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmProductInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmProductInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmProductInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmProductInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton btnModifyProduct;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField tfNam;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfProductCode;
    private javax.swing.JTextField tfQuantityAvailable;
    // End of variables declaration//GEN-END:variables
}