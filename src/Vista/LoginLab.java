package Vista;

import Conexion.ConexionBD;
import Controlador.EquiposController;
import Controlador.PersonasController;
import Modelo.ErrorsAndSuccesses;
import Modelo.Logeo;
import Modelo.PersistenciaGetSet;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hitler
 */
public class LoginLab extends javax.swing.JFrame {

    public LoginLab() {
        initComponents();
        this.setLocationRelativeTo(this);
        User_error.setVisible(false);
        Password_error.setVisible(false);
        cargando.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        User_Line = new javax.swing.JSeparator();
        Password = new javax.swing.JPasswordField();
        Password_Line = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        User_error = new javax.swing.JLabel();
        Password_error = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cargando = new javax.swing.JLabel();
        ver_no = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 108, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Swift_logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 451, 88));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/user.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 162, 50, 50));

        User.setBackground(new java.awt.Color(255, 255, 255));
        User.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        User.setText(" Usuario");
        User.setBorder(null);
        User.setOpaque(false);
        User.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UserFocusLost(evt);
            }
        });
        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });
        User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UserKeyReleased(evt);
            }
        });
        jPanel1.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 300, 35));

        User_Line.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(User_Line, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 310, 10));

        Password.setBackground(new java.awt.Color(255, 255, 255));
        Password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Password");
        Password.setBorder(null);
        Password.setOpaque(false);
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordKeyReleased(evt);
            }
        });
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 300, 35));

        Password_Line.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(Password_Line, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 310, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Password.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 50, 50));

        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(ErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 480, 60));

        User_error.setBackground(new java.awt.Color(255, 255, 255));
        User_error.setForeground(new java.awt.Color(255, 0, 0));
        User_error.setText("Usuario vacio");
        User_error.setOpaque(true);
        jPanel1.add(User_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 310, 20));

        Password_error.setBackground(new java.awt.Color(255, 255, 255));
        Password_error.setForeground(new java.awt.Color(255, 0, 0));
        Password_error.setText("Contraseña vacia");
        Password_error.setOpaque(true);
        jPanel1.add(Password_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 310, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 120, -1));

        cargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cargando.gif"))); // NOI18N
        jPanel1.add(cargando, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, 50));

        ver_no.setBackground(new java.awt.Color(255, 108, 0));
        ver_no.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Visible.png"))); // NOI18N
        ver_no.setOpaque(true);
        ver_no.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ver_noMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ver_noMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ver_noMouseExited(evt);
            }
        });
        jPanel1.add(ver_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserFocusGained
        if (User.getText().equals(" Usuario")) {
            User.setText("");
        }
    }//GEN-LAST:event_UserFocusGained

    private void UserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserFocusLost
        if (User.getText().isEmpty()) {
            User.setText(" Usuario");
        }
    }//GEN-LAST:event_UserFocusLost

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserActionPerformed

    private void UserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserKeyReleased
        if (evt.getKeyCode() == 115) {
            ConfigurarBD cb = new ConfigurarBD(this);
            cb.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_UserKeyReleased

    private void PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusGained
        if (String.valueOf(Password.getPassword()).equals("Password")) {
            Password.setText("");
        }
    }//GEN-LAST:event_PasswordFocusGained

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost
        if (String.valueOf(Password.getPassword()).isEmpty()) {
            Password.setText("Password");
        }
    }//GEN-LAST:event_PasswordFocusLost

    private void PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyReleased
        if (evt.getKeyCode() == 10) {
            Validar();
        }
    }//GEN-LAST:event_PasswordKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Validar();
    }//GEN-LAST:event_jButton1ActionPerformed
    boolean status = false;
    private void ver_noMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver_noMouseClicked

        status = !status;

        if (status) {
            ver_no.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Invisible.png")));
            Password.setEchoChar((char) 0);
        } else {
            ver_no.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Visible.png")));
            Password.setEchoChar('*');
        }
    }//GEN-LAST:event_ver_noMouseClicked

    private void ver_noMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver_noMouseEntered
        jLabel3.setBackground(Color.gray);
    }//GEN-LAST:event_ver_noMouseEntered

    private void ver_noMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver_noMouseExited
        jLabel3.setBackground(Color.white);
    }//GEN-LAST:event_ver_noMouseExited

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void Autentificacion(String user, String password) {
        PersistenciaGetSet pgs = new PersistenciaGetSet();
        pgs.Leer();
        ConexionBD con = ConexionBD.getInstance();
        Logeo l = new Logeo(user, password);
        con.conectar();
        ErrorsAndSuccesses eas = new ErrorsAndSuccesses();
        if (eas.isConexion()) {
            cargando.setVisible(false);

            PersonasController p = new PersonasController();
            EquiposController e = new EquiposController();
            p.CargarAlumnos();
            p.CargarDocentes();
            e.CargarIpad();
            e.CargarMacs();
            Menu m = new Menu();
            m.setVisible(true);
            this.dispose();
        } else {
            try {
                cargando.setVisible(false);
                ErrorMessage.setText("<html>" + eas.getCadenaErrorBD() + "</html>");
                ErrorMessage.setForeground(Color.red);
                Thread.sleep(4000);
                ErrorMessage.setText("");
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginLab.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void Validar() {
        if (!User.getText().isEmpty() && !User.getText().equals(" Usuario")) {
            User_Line.setForeground(Color.BLACK);
            User_error.setVisible(false);
            if (!String.valueOf(Password.getPassword()).isEmpty() && !String.valueOf(Password.getPassword()).equals("Password")) {
                Password_Line.setForeground(Color.BLACK);
                Password_error.setVisible(false);
                char[] passwordChars = Password.getPassword();
                new Thread() {
                    public void run() {
                        cargando.setVisible(true);
                        Autentificacion(User.getText(), new String(passwordChars));
                    }
                }.start();
            } else {
                Password.requestFocus();
                Password_error.setVisible(true);
                Password_Line.setForeground(Color.red);
            }
        } else {
            User.requestFocus();
            User_error.setVisible(true);
            User_Line.setForeground(Color.red);
        }
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
                if ("Dark nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginLab().setVisible(true);
            }
        });
    }

    /*PersonasController p = new PersonasController();
        EquiposController e = new EquiposController();
        p.CargarAlumnos();
        p.CargarDocentes();
        e.CargarIpad();
        e.CargarMacs();
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorMessage;
    private javax.swing.JPasswordField Password;
    private javax.swing.JSeparator Password_Line;
    private javax.swing.JLabel Password_error;
    private javax.swing.JTextField User;
    private javax.swing.JSeparator User_Line;
    private javax.swing.JLabel User_error;
    private javax.swing.JLabel cargando;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ver_no;
    // End of variables declaration//GEN-END:variables
}
