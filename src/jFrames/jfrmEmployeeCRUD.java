/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrames;

import daos.EmployeesDAO;
import java.util.ArrayList;
import modelos.modEmployee;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jovan
 */
public class jfrmEmployeeCRUD extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeCRUD
     */
    Conexion cx;
    EmployeesDAO employeesdao = new EmployeesDAO();
    ArrayList<modEmployee> lista;
    DefaultTableModel model = new DefaultTableModel();
    private EmployeesDAO employeeDAO = new EmployeesDAO();
    modEmployee employee;
    private jfrmMenu menuFrame;
    int i = -1;
    public jfrmEmployeeCRUD(jfrmMenu menuFrame) {
        setUndecorated(true);
        initComponents();

        this.setLocationRelativeTo(null);
        
        model.addColumn("Employee ID");        
        model.addColumn("Name");
        model.addColumn("Last Name");
        model.addColumn("RFC");
        model.addColumn("Address");
        model.addColumn("Cp");
        model.addColumn("CITY");
        model.addColumn("Phone Number");
        model.addColumn("E mail");
        cx = new Conexion();
        this.menuFrame = menuFrame;
        refreshTable();
    }
    public jfrmEmployeeCRUD(){
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
        btnExit = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAddEmployee = new javax.swing.JButton();
        btnModifyEmployee = new javax.swing.JButton();
        btnDeleteEmployee = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        tfIdEmpleado = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pfPass1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pfPass2 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        tfRFC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        tfCp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfPhoneNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfCiudad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

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
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 40, 30));

        btnBackToMenu.setBackground(new java.awt.Color(153, 102, 0));
        btnBackToMenu.setText("Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 110, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 36)); // NOI18N
        jLabel1.setText("Empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        btnAddEmployee.setBackground(new java.awt.Color(153, 102, 0));
        btnAddEmployee.setText("Agregar");
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 120, 30));

        btnModifyEmployee.setBackground(new java.awt.Color(153, 102, 0));
        btnModifyEmployee.setText("Modifcar");
        btnModifyEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(btnModifyEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 140, 30));

        btnDeleteEmployee.setBackground(new java.awt.Color(153, 102, 0));
        btnDeleteEmployee.setText("Eliminar");
        btnDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 130, 30));

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Title 2", "Nombre", "Apellido", "RFC", "Direccion", "Cod. Postal", "Ciudad", "Telefono", "Email"
            }
        ));
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployees);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 720, 180));

        tfIdEmpleado.setToolTipText("idEmpleado");
        tfIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(tfIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 80, -1));

        tfNombre.setToolTipText("nombre");
        jPanel1.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 160, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        tfApellido.setToolTipText("Last Name");
        jPanel1.add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel4.setText("Apellido");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        pfPass1.setToolTipText("insert Password");
        jPanel1.add(pfPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel5.setText("Contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, 20));

        jLabel6.setText("Confirma contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        pfPass2.setToolTipText("insert Password again");
        jPanel1.add(pfPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 150, -1));

        jLabel7.setText("RFC");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));
        jPanel1.add(tfRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 110, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel8.setText("Direccion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));
        jPanel1.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 160, -1));
        jPanel1.add(tfCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 70, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel9.setText("Cod. Postal");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, -1, 20));
        jPanel1.add(tfPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 130, -1));

        jLabel10.setText("Telefono");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        tfCiudad.setToolTipText("city");
        jPanel1.add(tfCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 130, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel11.setText("Ciudad");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, -1));
        jPanel1.add(tfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 200, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel12.setText("Email");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        btnCancel.setBackground(new java.awt.Color(153, 102, 0));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 90, 30));

        jLabel13.setText("No dejes espacios en blanco");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void refreshTable() {
    model.setRowCount(0);  
    lista = employeesdao.read();

    for (modEmployee employee : lista) {
            Object[] fila = new Object[9];
            fila[0] = employee.getEmployeeID();
            fila[1] = employee.getNam();
            fila[2] = employee.getSurname();
            fila[3] = employee.getRfc();
            fila[4] = employee.getAddress();
            fila[5] = employee.getPostalCode();
            fila[6] = employee.getCity();
            fila[7] = employee.getPhone1();
            fila[8] = employee.getEmail();
            model.addRow(fila);
        }

        tblEmployees.setModel(model);
    }

    /*
    public void refreshTable(){
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        lista = employeesdao.read();
        for (modEmployee employee : lista){
            Object fila[] = new Object [9];
            fila[0] = employee.getEmployeeID();
            fila[1] = employee.getNam();
            fila[2] = employee.getSurname();
            fila[3] = employee.getRfc();
            fila[4] = employee.getAddress();
            fila[5] = employee.getPostalCode();
            fila[6] = employee.getCity();
            fila[7] = employee.getPhone1();
            fila[8] = employee.getEmail();
            model.addRow(fila);
        }
        tblEmployees.setModel(model);
    }
    */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        System.exit(0);

    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        menuFrame.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnBackToMenuActionPerformed

    private void btnModifyEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyEmployeeActionPerformed
        //modEmployee thisEmployee = new modEmployee();
        employee.setEmployeeID(tfIdEmpleado.getText());
        if(String.valueOf(pfPass1.getPassword()).length()>=4 &&
           String.valueOf(pfPass1.getPassword()).equals(String.valueOf(pfPass2.getPassword()))){
            employee.setPass(String.valueOf(pfPass1.getPassword()));
        }else{
            employee.setPass(null);
        }
        
        employee.setNam(tfNombre.getText());
        employee.setSurname(tfApellido.getText());
        employee.setRfc(tfRFC.getText());
        employee.setAddress(tfDireccion.getText());
        employee.setPostalCode(tfCp.getText());
        employee.setCity(tfCiudad.getText());
        employee.setPhone1(tfPhoneNumber.getText());
        employee.setEmail(tfCorreo.getText());
        String update = employeesdao.update(employee);
        if (update.equals("true")) {
            refreshTable();
            JOptionPane.showMessageDialog(this, "Employee details updated successfully.");
            clean();
        } else {
            JOptionPane.showMessageDialog(this, update);
        }
        
    }//GEN-LAST:event_btnModifyEmployeeActionPerformed

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
        if(
           String.valueOf(pfPass1.getPassword()).equals(String.valueOf(pfPass2.getPassword()))
           ){
           modEmployee employee = new modEmployee();
           employee.setEmployeeID(tfIdEmpleado.getText());
           employee.setPass(String.valueOf(pfPass1.getPassword()));
           employee.setNam(tfNombre.getText());
           employee.setSurname(tfApellido.getText());
           employee.setRfc(tfRFC.getText());
           employee.setAddress(tfDireccion.getText());
           employee.setPostalCode(tfCp.getText());
           employee.setCity(tfCiudad.getText());
           employee.setPhone1(tfPhoneNumber.getText());
           employee.setEmail(tfCorreo.getText());
           String verify = employeeDAO.create(employee);
           if(verify.equals("true")){
               refreshTable();
               JOptionPane.showMessageDialog(this, "Employee registred succesfully");
               clean();
           }else{
               JOptionPane.showMessageDialog(this, verify);
           }
       }else{
            JOptionPane.showMessageDialog(this, "Error: The passwords do not match. Please ensure both passwords are identical and try again.");
       }
       
    }//GEN-LAST:event_btnAddEmployeeActionPerformed

    public void clean(){
        tfIdEmpleado.setText("");
        pfPass1.setText("");
        pfPass2.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfRFC.setText("");
        tfDireccion.setText("");
        tfCp.setText("");
        tfCiudad.setText("");
        tfPhoneNumber.setText("");               
        tfCorreo.setText("");
    }
    
    private void tfIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdEmpleadoActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        i = tblEmployees.getSelectedRow();
        employee = employeesdao.read(lista.get(i).getEmployeeID());
        tfIdEmpleado.setText(employee.getEmployeeID());
        tfNombre.setText(employee.getNam()); 
        tfApellido.setText(employee.getSurname());
        tfRFC.setText(employee.getRfc());
        tfDireccion.setText(employee.getAddress());
        tfCp.setText(employee.getPostalCode());
        tfCiudad.setText(employee.getCity());
        tfPhoneNumber.setText(employee.getPhone1());
        tfCorreo.setText(employee.getEmail());
        pfPass1.setText("");
        pfPass2.setText("");
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void btnDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEmployeeActionPerformed
        if (i > -1) {
            int res = JOptionPane.showConfirmDialog(this, "are you sure that you wanna delete this employee?", "DELETE", JOptionPane.YES_NO_OPTION);
            if (res == 0) {
                if (employeesdao.delete(lista.get(i).getEmployeeID())) {
                    JOptionPane.showMessageDialog(this, "Employee deleted succesfull!");
                } else {
                    JOptionPane.showMessageDialog(this, "An error was ocurred while deleting this employee");
                }
                refreshTable();
                clean();
            }
        }
    }//GEN-LAST:event_btnDeleteEmployeeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        tfApellido.setText("");
        tfCiudad.setText("");
        tfCorreo.setText("");
        tfCp.setText("");
        tfDireccion.setText("");
        tfIdEmpleado.setText("");
        tfNombre.setText("");
        tfPhoneNumber.setText("");
        tfRFC.setText("");
        pfPass1.setText("");
        pfPass2.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(jfrmEmployeeCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmEmployeeCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmEmployeeCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmEmployeeCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmEmployeeCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmployee;
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteEmployee;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnModifyEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPasswordField pfPass1;
    private javax.swing.JPasswordField pfPass2;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfCp;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfIdEmpleado;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPhoneNumber;
    private javax.swing.JTextField tfRFC;
    // End of variables declaration//GEN-END:variables
}