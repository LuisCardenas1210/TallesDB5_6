/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrames;

import daos.CustomerDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.modCustomer;
import modelos.modEmployee;

/**
 *
 * @author jovan
 */
public class jfrmCustomerCRUD extends javax.swing.JFrame {

    /**
     * Creates new form jfrmCustomerCRUD
     */
    Conexion cx;
    CustomerDAO customerdao = new CustomerDAO();
    ArrayList<modCustomer> list;
    private jfrmMenu menuFrame;
    DefaultTableModel model = new DefaultTableModel();
    private CustomerDAO customerDAO = new CustomerDAO();
    modCustomer customer;
    int i = -1;
    public jfrmCustomerCRUD(jfrmMenu menuFrame) {
        this.menuFrame = menuFrame;
        setUndecorated(true);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        model.addColumn("Customer ID");
        model.addColumn("Name");
        model.addColumn("Last Name");
        model.addColumn("Address");
        model.addColumn("Postal Code");
        model.addColumn("City");
        model.addColumn("Phone Number");
        model.addColumn("E mail");
        cx = new Conexion();
        this.menuFrame = menuFrame;
        refreshTable();
    }
    public jfrmCustomerCRUD(){}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        tfCustomerID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSurname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfPostalCode = new javax.swing.JTextField();
        City = new javax.swing.JLabel();
        tfCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        btnAddCustomer = new javax.swing.JButton();
        btnModifyCustomer = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setText("X");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 40, 30));

        btnBackToMenu.setBackground(new java.awt.Color(153, 102, 0));
        btnBackToMenu.setText("Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 100, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Apellido", "Direccion", "cod.Postal", "Ciudad", "Telefono", "Email"
            }
        ));
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 670, 240));

        tfCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCustomerIDActionPerformed(evt);
            }
        });
        jPanel1.add(tfCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 60, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel2.setText("Código");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        tfNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamActionPerformed(evt);
            }
        });
        jPanel1.add(tfNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 150, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        tfSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSurnameActionPerformed(evt);
            }
        });
        jPanel1.add(tfSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 130, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel5.setText("Dirección");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        tfAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAddressActionPerformed(evt);
            }
        });
        jPanel1.add(tfAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 140, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel6.setText("Cod.Postal");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        tfPostalCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPostalCodeActionPerformed(evt);
            }
        });
        jPanel1.add(tfPostalCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 90, 30));

        City.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        City.setText("Ciudad");
        jPanel1.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        tfCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCityActionPerformed(evt);
            }
        });
        jPanel1.add(tfCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 150, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel7.setText("Telefono");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        tfPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPhoneActionPerformed(evt);
            }
        });
        jPanel1.add(tfPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 150, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel8.setText("Email");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });
        jPanel1.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 190, 30));

        btnAddCustomer.setBackground(new java.awt.Color(153, 102, 0));
        btnAddCustomer.setText("Agregar");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 130, 30));

        btnModifyCustomer.setBackground(new java.awt.Color(153, 102, 0));
        btnModifyCustomer.setText("Modificar");
        btnModifyCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(btnModifyCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 110, 30));

        btnCancel.setBackground(new java.awt.Color(153, 102, 0));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 120, 30));

        btnDeleteCustomer.setBackground(new java.awt.Color(153, 102, 0));
        btnDeleteCustomer.setText("Eliminar");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 110, 30));

        jLabel9.setText("No dejes espacios en blanco");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        System.exit(0);

    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        menuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackToMenuActionPerformed

    private void tfCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCustomerIDActionPerformed

    private void tfNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamActionPerformed

    private void tfSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSurnameActionPerformed

    private void tfAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAddressActionPerformed

    private void tfPostalCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPostalCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPostalCodeActionPerformed

    private void tfCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCityActionPerformed

    private void tfPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPhoneActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        modCustomer customer = new modCustomer();
        customer.setCustomerID(tfCustomerID.getText());
        customer.setNam(tfNam.getText());
        customer.setSurname(tfSurname.getText());
        customer.setAddress(tfAddress.getText());
        customer.setPostalCode(tfPostalCode.getText());
        customer.setCity(tfCity.getText());
        customer.setPhone(tfPhone.getText());
        customer.setEmail(tfEmail.getText());
        String verify = customerDAO.create(customer);
        if(verify.equals("true")){
            JOptionPane.showMessageDialog(this, "Customer registred succesfully");
            clean();
            refreshTable();
        }else{
            JOptionPane.showMessageDialog(this, verify);
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnModifyCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyCustomerActionPerformed

        customer.setCustomerID(tfCustomerID.getText());
        customer.setNam(tfNam.getText());
        customer.setSurname(tfSurname.getText());
        customer.setAddress(tfAddress.getText());
        customer.setPostalCode(tfPostalCode.getText());
        customer.setCity(tfCity.getText());
        customer.setPhone(tfPhone.getText());
        customer.setEmail(tfEmail.getText());

        String update = customerdao.update(customer);

        if (update.equals("Update successful")) {
            refreshTable();
            JOptionPane.showMessageDialog(this, "Customer details updated successfully.");
            clean();
        } else {
            JOptionPane.showMessageDialog(this, update);
        }
    }//GEN-LAST:event_btnModifyCustomerActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        tfCustomerID.setText("");
        tfNam.setText("");
        tfSurname.setText("");
        tfAddress.setText("");
        tfPostalCode.setText("");
        tfCity.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    
    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        if (i > -1) {
            int res = JOptionPane.showConfirmDialog(this, "are you sure that you wanna delete this customer?", "DELETE", JOptionPane.YES_NO_OPTION);
            if (res == 0) {
                if (customerdao.delete(list.get(i).getCustomerID())) {
                    JOptionPane.showMessageDialog(this, "Employee deleted succesfull!");
                } else {
                    JOptionPane.showMessageDialog(this, "An error was ocurred while deleting this customer");
                }
                refreshTable();
                clean();
            }
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
        i = tblCustomers.getSelectedRow();
        customer = customerdao.read(list.get(i).getCustomerID());
        tfCustomerID.setText(customer.getCustomerID());
        tfNam.setText(customer.getNam()); 
        tfSurname.setText(customer.getSurname());
        tfAddress.setText(customer.getAddress());
        tfPostalCode.setText(customer.getPostalCode());
        tfCity.setText(customer.getCity());
        tfPhone.setText(customer.getPhone());
        tfEmail.setText(customer.getEmail());
    }//GEN-LAST:event_tblCustomersMouseClicked

    
    public void refreshTable(){
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        list = customerdao.read();
        for (modCustomer customer : list){
            Object fila[] = new Object [8];
            fila[0] = customer.getCustomerID();
            fila[1] = customer.getNam();
            fila[2] = customer.getSurname();
            fila[3] = customer.getAddress();
            fila[4] = customer.getPostalCode();
            fila[5] = customer.getCity();
            fila[6] = customer.getPhone();
            fila[7] = customer.getEmail();
            model.addRow(fila);
        }
        tblCustomers.setModel(model);
    }
    
    public void clean(){
        tfCustomerID.setText("");
        tfNam.setText("");
        tfSurname.setText("");
        tfAddress.setText("");
        tfPostalCode.setText("");
        tfCity.setText("");
        tfPhone.setText("");               
        tfEmail.setText("");
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
            java.util.logging.Logger.getLogger(jfrmCustomerCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmCustomerCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmCustomerCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmCustomerCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmCustomerCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel City;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnModifyCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfCustomerID;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNam;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfPostalCode;
    private javax.swing.JTextField tfSurname;
    // End of variables declaration//GEN-END:variables
}