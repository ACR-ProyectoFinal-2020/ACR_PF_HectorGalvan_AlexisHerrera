/*
Nombres: Hector Abraham Galvan Garcia y Alexis Herrera Saucedo
Tema del programa: Proyecto Final
Descripcion: Crear una aplicacion que simule un cajero de banco con archivos, hilos y RMI
Fecha: 13/06/2020
*/
package Cliente;

import Interface.Cajero;
import Servidor.Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IniciarSesion extends javax.swing.JFrame {
    Cajero caj;
    Usuario usr;
    static final String serverAddress="localhost"; 
    static final int serverPort=1234; 
    Registry registry = LocateRegistry.getRegistry(serverAddress,serverPort);
        
    public IniciarSesion() throws RemoteException, NotBoundException {
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Cajero");
        setDefaultCloseOperation(0);
        caj=(Cajero)(registry.lookup("servidor"));  
    }
    
    public IniciarSesion(Usuario u) throws RemoteException, NotBoundException{
        //guardar los datos en el archivo del anterior usuario
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Cajero");
        caj=(Cajero)(registry.lookup("servidor"));  
        usr=new Usuario(u.getNombre(),u.getNoTarjeta(),u.getNip(),u.getSaldo());
        setDefaultCloseOperation(0);       
        caj.modificarDatabase(u);
    }
    
    public IniciarSesion(boolean b) throws RemoteException, NotBoundException{
        //registrar usuario
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Cajero");
        caj=(Cajero)(registry.lookup("servidor"));  
        setDefaultCloseOperation(0);       
        caj.guardarDatos();      
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ncuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nip = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        iniciar = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 45, 62));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Banco1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido");
        jLabel2.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(88, 59, 94));
        jPanel2.setToolTipText("");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CUENTA");

        ncuenta.setBackground(new java.awt.Color(33, 45, 62));
        ncuenta.setForeground(new java.awt.Color(255, 255, 255));
        ncuenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ncuenta.setCaretColor(new java.awt.Color(255, 255, 255));
        ncuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ncuentaKeyTyped(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(222, 222, 222));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tarjeta.png"))); // NOI18N

        nip.setBackground(new java.awt.Color(33, 45, 62));
        nip.setForeground(new java.awt.Color(255, 255, 255));
        nip.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nip.setCaretColor(new java.awt.Color(255, 255, 255));
        nip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nipKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIP");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingresar");

        iniciar.setBackground(new java.awt.Color(0, 220, 255));
        iniciar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        iniciar.setText("Ingresar");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        registrar.setBackground(new java.awt.Color(0, 220, 255));
        registrar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        registrar.setText("Registrarse");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(33, 45, 62));

        jSeparator2.setBackground(new java.awt.Color(33, 45, 62));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/candado.png"))); // NOI18N

        salir.setBackground(new java.awt.Color(242, 38, 19));
        salir.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(ncuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(66, 66, 66))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(registrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(iniciar)
                            .addGap(28, 28, 28)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(salir)
                        .addGap(108, 108, 108))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ncuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar)
                    .addComponent(iniciar))
                .addGap(32, 32, 32)
                .addComponent(salir)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
       if("".equals(ncuenta.getText())||"".equals(nip.getText())){
         JOptionPane.showMessageDialog(null, "Introduce datos para ingresar","Alerta",JOptionPane.WARNING_MESSAGE); 
       }else if(ncuenta.getText().length()!=8 || nip.getText().length()!=4){
           JOptionPane.showMessageDialog(null, "Números insuficientes","Alerta",JOptionPane.WARNING_MESSAGE);    
       } else {          
           try {
               int cuenta = Integer.parseInt(ncuenta.getText());
               int pass = Integer.parseInt(nip.getText());
               boolean correcto =caj.ingresar(cuenta,pass);
               
               if(correcto){
                VentanaPrincipal obj = new VentanaPrincipal(caj.devolverUsuario());
                obj.setVisible(true);
                dispose();
               }else{
                 JOptionPane.showMessageDialog(null, "Cuenta o NIP erróneos","Alerta",JOptionPane.WARNING_MESSAGE);   
               }              
           } catch (RemoteException | NotBoundException ex) {
               Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
           }
       }    
    }//GEN-LAST:event_iniciarActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
       Registro obj = null;
        try {
            obj = new Registro();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
       obj.setVisible(true);
       dispose();
    }//GEN-LAST:event_registrarActionPerformed

    private void nipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nipKeyTyped
        char caracter = evt.getKeyChar();
        if(Character.isDigit(caracter) ||caracter == '\b'){
             if (nip.getText().length()== 4){
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puedes introducir \n mas de 4 digitos","Alerta",JOptionPane.WARNING_MESSAGE);
            nip.setText("");
            } 
        }else{
          evt.consume();
          JOptionPane.showMessageDialog(null, "Solo números","Alerta",JOptionPane.WARNING_MESSAGE);
          nip.setText("");
        }      
    }//GEN-LAST:event_nipKeyTyped

    private void ncuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ncuentaKeyTyped
        char caracter = evt.getKeyChar();

        if(Character.isDigit(caracter) || caracter == '\b'){
            if (ncuenta.getText().length()== 8){
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puedes introducir \n mas de 8 digitos","Alerta",JOptionPane.WARNING_MESSAGE);
            ncuenta.setText("");
            } 
        }else{
          evt.consume();
          JOptionPane.showMessageDialog(null, "Solo números","Alerta",JOptionPane.WARNING_MESSAGE);
          ncuenta.setText("");
        }     
    }//GEN-LAST:event_ncuentaKeyTyped

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
         this.dispose();
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new IniciarSesion().setVisible(true);
                } catch (RemoteException | NotBoundException ex) {
                    Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField ncuenta;
    private javax.swing.JPasswordField nip;
    private javax.swing.JButton registrar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
