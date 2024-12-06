/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrames;

import com.mysql.cj.Session;
import daos.UserAuthDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.modUser;
import java.util.Properties;

/**
 *
 * @author jovan
 */


public class jfrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form jfrmLogin
     */
    private jfrmMenu menuFrame;
     
    Conexion cx;
    UserAuthDAO userdao  = new UserAuthDAO();
    ArrayList<modUser> users;
    
    
    
    public jfrmLogin() {
        setUndecorated(true);
        initComponents();
        loadRememberedUser();
    }
    
    private void saveUserCredentials(String username, String password) {
        Properties props = new Properties();

        try {
            File userFile = new File("user.properties");
            if (!userFile.exists()) {
                userFile.createNewFile();  
            }

            props.load(new FileInputStream(userFile));

            props.setProperty("username", username);
            props.setProperty("password", password);

            // Guardar las propiedades en el archivo
            props.store(new FileOutputStream(userFile), null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void loadRememberedUser() {
        Properties props = new Properties();

        try {
            // Verificar si el archivo user.properties existe, y crearlo si no es así
            File userFile = new File("user.properties");
            if (!userFile.exists()) {
                userFile.createNewFile();  // Crear el archivo si no existe
            }

            // Cargar las propiedades desde el archivo
            props.load(new FileInputStream("user.properties"));

            // Verificar si se han guardado datos
            String savedUser = props.getProperty("username");
            String savedPass = props.getProperty("password");

            // Si hay datos guardados, completar los campos
            if (savedUser != null && savedPass != null) {
                tfUser.setText(savedUser);
                pfPassword.setText(savedPass);
                // Marcar el checkbox como seleccionado
                cbRememberMe.setSelected(true);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
        jPanel2 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        tfUser = new javax.swing.JTextField();
        pfPassword = new javax.swing.JPasswordField();
        cbRememberMe = new javax.swing.JCheckBox();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 22, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setBackground(new java.awt.Color(153, 102, 0));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(153, 102, 0));
        btnLogin.setText("Entrar");
        btnLogin.setSelected(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 110, 30));

        tfUser.setToolTipText("user");
        tfUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserActionPerformed(evt);
            }
        });
        jPanel2.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 410, -1));

        pfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(pfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 410, -1));

        cbRememberMe.setText("Remember me");
        cbRememberMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRememberMeActionPerformed(evt);
            }
        });
        jPanel2.add(cbRememberMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setText("X");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 40, 30));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 3, 48)); // NOI18N
        jLabel1.setText("Mercado Flash");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 440, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Usuario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));
        jLabel2.getAccessibleContext().setAccessibleName("JLUsuariao");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));
        jLabel3.getAccessibleContext().setAccessibleName("jLContraseña");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/login-icon.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 260, 270));
        jLabel4.getAccessibleContext().setAccessibleName("Imagen");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = tfUser.getText();
        String pass = String.valueOf(pfPassword.getPassword());
       
        if (userdao.verify(user, pass)){
            if(cbRememberMe.isSelected()){
                saveUserCredentials(user, pass);
            }            
            //Session.getInstance().setRole("UserRole");
            JOptionPane.showMessageDialog(this, "Welcome back, " + user + "! You've succesfully logged in.");
            jfrmMenu menuFrame = new jfrmMenu();
            menuFrame.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Incorrect username or password.");
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void tfUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserActionPerformed

    private void pfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfPasswordActionPerformed

    private void cbRememberMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRememberMeActionPerformed
        Properties props = new Properties();

        if (cbRememberMe.isSelected()) {
            props.setProperty("username", tfUser.getText());
            props.setProperty("password", String.valueOf(pfPassword.getPassword()));

            try {
                // Escribir las propiedades en un archivo
                props.store(new FileOutputStream("user.properties"), null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // Si el checkbox no esta seleccionado, eliminamos los datos guardados
            try {
                props.remove("username");
                props.remove("password");
                props.store(new FileOutputStream("user.properties"), null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_cbRememberMeActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        System.exit(0);

    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cbRememberMe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
