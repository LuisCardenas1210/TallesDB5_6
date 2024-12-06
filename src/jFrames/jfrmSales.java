package jFrames;

import daos.ProductDAO;
import daos.SalesDao;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelos.modSales;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import modelos.modOrders;
import modelos.modProduct;
import modelos.modProductDetails;
import modelos.modUser;

/**
 *
 * @author jovan
 */
public class jfrmSales extends javax.swing.JFrame {

    private jfrmMenu menuFrame;

    ProductDAO productsDAO = new ProductDAO();
    SalesDao salesDAO = new SalesDao();
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<modProductDetails> list;
    ArrayList<modProduct> productsList;
    modProduct product = new modProduct();
    Conexion cx;
    int j = 2;
    double totalFinal = 0;

    public jfrmSales(jfrmMenu menuFrame) {
        this.menuFrame = menuFrame;
        setTitle("Ventas");
        setUndecorated(true);
        initComponents();
        tfProductCode.requestFocusInWindow();
        ((AbstractDocument) tfProductCode.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) tfQuantity.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) tfPaymentAmount.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        lblUser.setText(modUser.getInstance().getUsername() + " " + modUser.getInstance().getLastName());

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentDateTime = getCurrentDateTime();
                lblTime.setText(currentDateTime);
            }
        });
        timer.start();

        jfrmLogin empleado = new jfrmLogin();
        //txtCliente.setEnabled(false);
        this.setLocationRelativeTo(null);
        model.addColumn("Code");
        model.addColumn("Product");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Total");
        tblCompras.setModel(model);
        productsList = productsDAO.read();
        cx = new Conexion();
    }

    public jfrmSales() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        lblTime = new javax.swing.JLabel();
        tfProductCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfPaymentAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));
        setPreferredSize(new java.awt.Dimension(660, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setText("X");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 40, 30));

        btnBackToMenu.setBackground(new java.awt.Color(153, 102, 0));
        btnBackToMenu.setText("Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 120, 30));

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUser.setText("Vendedor:");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 190, -1));

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblCompras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 620, 250));

        lblTime.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        lblTime.setText("Fecha y Hora");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        tfProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProductCodeActionPerformed(evt);
            }
        });
        tfProductCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfProductCodeKeyPressed(evt);
            }
        });
        getContentPane().add(tfProductCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 190, 30));

        jLabel1.setText("Código del producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, 10));

        tfQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfQuantityKeyPressed(evt);
            }
        });
        getContentPane().add(tfQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 190, 30));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText(" 00.00");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));

        jLabel3.setText("Monto a pagar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        tfPaymentAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPaymentAmountKeyPressed(evt);
            }
        });
        getContentPane().add(tfPaymentAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 230, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Total:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jLabel5.setText("Cliente");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, -1, -1));

        txtCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 190, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        jfrmMenu menuFrame = new jfrmMenu();
        menuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackToMenuActionPerformed

    private void tfProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProductCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProductCodeActionPerformed

    private void tfProductCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProductCodeKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            tfQuantity.requestFocusInWindow();
        }
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
            tfPaymentAmount.requestFocus();
        }
    }//GEN-LAST:event_tfProductCodeKeyPressed

    private void tfQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantityKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String productCode = tfProductCode.getText().trim();
            String quantityText = tfQuantity.getText().trim();
            String customer = txtCustomer.getText();
            if (productCode.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the product code", "Error", JOptionPane.ERROR_MESSAGE);
                tfProductCode.requestFocusInWindow();
                return;
            }
            int quantity = 1;
            if (!quantityText.isEmpty()) {
                try {
                    quantity = Integer.parseInt(quantityText);
                    if (quantity <= 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity. It must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    tfQuantity.requestFocusInWindow();
                    return;
                }
            }

            product = productsDAO.read(tfProductCode.getText());

            if (product.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Product not found or invalid data.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            modProductDetails productDetails = new modProductDetails();
            productDetails.setProductCode(product.getProductCode());
            productDetails.setNam(product.getNam());
            productDetails.setPrice(product.getPrice());
            productDetails.setQuantity(quantity);

            if (tblCompras.getRowCount() < 1) {
                if (customer.equals("")) {
                    salesDAO.createOrder(String.valueOf(lblTime.getText()), modUser.getInstance().getUserId(), null);
                } else {
                    salesDAO.createOrder(String.valueOf(lblTime.getText()), modUser.getInstance().getUserId(), customer);
                }
            }
            salesDAO.read();
            for (int i = 0; i < productsList.size(); i++) {
                if (productDetails.getProductCode().equals(productsList.get(i).getProductCode())) {
                    modProduct p = productsList.get(i);
                    if (productDetails.getQuantity() > p.getQuantityAvailable()) {
                        JOptionPane.showMessageDialog(this,
                                "Insufficient stock. The quantity exceeds the available stock. Available stock: "
                                + p.getQuantityAvailable(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        tfQuantity.requestFocusInWindow();
                        return;
                    } else {
                        //metodo para crear order detail
                        if (salesDAO.createOrderDetails(modOrders.getInstance().getOrderid(), product, quantity)) {
                            JOptionPane.showMessageDialog(this, "bien");
                        } else {
                            JOptionPane.showMessageDialog(this, "mal");
                        }

                        p.setQuantityAvailable(p.getQuantityAvailable() - productDetails.getQuantity());
                        productsList.set(i, p);
                        break;
                    }
                }
            }
            /*
            if( product.getQuantityAvailable() < productDetails.getQuantity() ){
                    //System.out.println(product.getQuantityAvailable());
                                   
            } 
             */

            tfProductCode.requestFocusInWindow();
            addProductToTable(productDetails);
            totalFinal += quantity * productDetails.getPrice();
            lblTotal.setText(String.format("%.2f", totalFinal));
        }


    }//GEN-LAST:event_tfQuantityKeyPressed

    private void tfPaymentAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPaymentAmountKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            try {
                double total = Double.parseDouble(lblTotal.getText().replace("Total: ", "").trim());
                double paymentAmount = Double.parseDouble(tfPaymentAmount.getText().trim());

                if (paymentAmount < total) {
                    JOptionPane.showMessageDialog(this, "The payment amount is insufficient. Please enter a valid amount.",
                            "Insufficient Payment", JOptionPane.ERROR_MESSAGE);
                    tfPaymentAmount.requestFocusInWindow();
                    return;
                }
                int confirmation = JOptionPane.showConfirmDialog(this,
                        "Do you want to proceed with the payment?",
                        "Confirm Payment",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (confirmation == JOptionPane.YES_OPTION) {
                    String result;
                    for (int i = 0; i < productsList.size(); i++) {
                        modProduct p = productsList.get(i);
                        modProduct pO = productsDAO.read(p.getProductCode());
                        if (p.getQuantityAvailable() != pO.getQuantityAvailable()) {
                            result = productsDAO.decreaseProductQuantityWithTransaction(
                                    p.getProductCode(),
                                    pO.getQuantityAvailable() - p.getQuantityAvailable()
                            );
                            if (!result.equals("Quantity successfully updated.")) {
                                JOptionPane.showMessageDialog(this, result, "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                    }
                    double change = paymentAmount - total;
                    JOptionPane.showMessageDialog(this,
                            "Payment successful!\nChange: $" + String.format("%.2f", change),
                            "Payment Confirmed", JOptionPane.INFORMATION_MESSAGE);
                    tfPaymentAmount.setText("");
                    lblTotal.setText("Total: 0.00");
                    resetSale();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid payment amount.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                tfPaymentAmount.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_tfPaymentAmountKeyPressed

    private void txtCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerActionPerformed

    private void addProductToTable(modProductDetails pd) {
        try {
            String productCode = pd.getProductCode();
            String productName = pd.getNam();
            double price = pd.getPrice();
            int quantity = pd.getQuantity();
            double total = price * quantity;

            boolean exists = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String existingCode = (String) model.getValueAt(i, 0);
                if (existingCode.equals(productCode)) {
                    Object existingValue = model.getValueAt(i, 3);
                    int existingQuantity;
                    if (existingValue instanceof Integer) {
                        existingQuantity = (Integer) existingValue;
                    } else if (existingValue instanceof String) {
                        existingQuantity = Integer.parseInt((String) existingValue);
                    } else if (existingValue instanceof Double) {
                        existingQuantity = ((Double) existingValue).intValue();
                    } else {
                        throw new IllegalArgumentException("Unexpected type in quantity column: " + existingValue.getClass().getName());
                    }
                    int newQuantity = existingQuantity + quantity;
                    model.setValueAt(newQuantity, i, 3);
                    model.setValueAt(price * newQuantity, i, 4);
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                model.addRow(new Object[]{productCode, productName, String.format("%.2f", price), quantity, String.format("%.2f", total)});
            }

            model.fireTableDataChanged();
            tfProductCode.setText("");
            tfQuantity.setText("");
            tfProductCode.requestFocusInWindow();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding the product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetSale() {
        totalFinal = 0;
        j = 2;
        model.setRowCount(0);
        lblTotal.setText("00.00");
        tfProductCode.setText("");
        tfQuantity.setText("");
        tfPaymentAmount.setText("");
        productsList = productsDAO.read();
        tfProductCode.requestFocusInWindow();
    }

    class NumericDocumentFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("\\d*")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("\\d*")) {
                super.replace(fb, offset, length, string, attr);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

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
            java.util.logging.Logger.getLogger(jfrmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmSales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTextField tfPaymentAmount;
    private javax.swing.JTextField tfProductCode;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField txtCustomer;
    // End of variables declaration//GEN-END:variables
}
