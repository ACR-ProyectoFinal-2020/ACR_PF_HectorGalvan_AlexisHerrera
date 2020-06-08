/*
Nombres: Hector Abraham Galvan Garcia y Alexis Herrera Saucedo
Tema del programa: Proyecto Final
Descripcion: Crear una aplicacion que simule un cajero de banco con archivos, hilos y RMI
Fecha: 13/06/2020
*/
package Cliente;

import Interface.Cajero;
import Servidor.CajeroServidor;
import Servidor.Usuario;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {
    Cajero caj;
    Usuario us;
    static final String serverAddress="localhost"; 
    static final int serverPort=1234; 
    Registry registry ;
    private static final String PATH = "Estados_de_cuenta/";
    
    public VentanaPrincipal(Usuario u) throws RemoteException, NotBoundException {
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Bienvenido");
        setDefaultCloseOperation(0);
        CajeroServidor cs = new CajeroServidor();
        Thread t1 = new Thread(cs);
        t1.start();
        us=new Usuario();  
        us.setNombre(u.getNombre());
        us.setNoTarjeta(u.getNoTarjeta());
        us.setNip(u.getNip());
        us.setSaldo(u.getSaldo());
        cliente.setText(us.getNombre());
        registry = LocateRegistry.getRegistry(serverAddress,serverPort);
        caj=(Cajero)(registry.lookup("servidor"));  
    }

    private VentanaPrincipal() {}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        consultar = new javax.swing.JButton();
        retirar = new javax.swing.JButton();
        depositar = new javax.swing.JButton();
        estadoDeCuenta = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(73, 181, 172));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 45, 62));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bienvenido");

        cliente.setEditable(false);
        cliente.setBackground(new java.awt.Color(33, 45, 62));
        cliente.setFont(new java.awt.Font("Baskerville Old Face", 3, 26)); // NOI18N
        cliente.setForeground(new java.awt.Color(255, 255, 255));
        cliente.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(88, 59, 94));

        consultar.setBackground(new java.awt.Color(0, 220, 255));
        consultar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        retirar.setBackground(new java.awt.Color(0, 220, 255));
        retirar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        retirar.setText("Retirar");
        retirar.setMaximumSize(new java.awt.Dimension(95, 23));
        retirar.setMinimumSize(new java.awt.Dimension(95, 23));
        retirar.setPreferredSize(new java.awt.Dimension(95, 23));
        retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarActionPerformed(evt);
            }
        });

        depositar.setBackground(new java.awt.Color(0, 220, 255));
        depositar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        depositar.setText("Depositar");
        depositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarActionPerformed(evt);
            }
        });

        estadoDeCuenta.setBackground(new java.awt.Color(0, 220, 255));
        estadoDeCuenta.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        estadoDeCuenta.setText("Estado de cuenta");
        estadoDeCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoDeCuentaActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(242, 38, 19));
        salir.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultar.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/retirar.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositar.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuenta.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addComponent(retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addComponent(depositar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addComponent(estadoDeCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(depositar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(estadoDeCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        try{
        JOptionPane.showMessageDialog(null, "Saldo restante: "+us.getSaldo()+"\nQue tenga un buen día");
        IniciarSesion obj = new IniciarSesion(us);
        obj.setVisible(true);
        dispose();
        }catch(RemoteException | NotBoundException ex){
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void estadoDeCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoDeCuentaActionPerformed
        ImageIcon icon = new ImageIcon("src/Imagenes/cuenta.png");
        try {
          caj.edoCuenta(us);
          int n = JOptionPane.showConfirmDialog(null, "El estado de cuenta se guardó\nQuieres abrir el archivo? ","Abrir archivo?",JOptionPane.YES_NO_OPTION);

          File file = new File (PATH+"Estado de cuenta de_"+us.getNombre()+".txt");
           if(file.exists()){ 
           if (n==JOptionPane.YES_OPTION) {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.OPEN)) {
                        try {
                            desktop.open(file);
                        } catch (IOException ex) {
                            Logger.getLogger(CajeroServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
          }
        } catch (RemoteException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_estadoDeCuentaActionPerformed

    private void depositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarActionPerformed
        ImageIcon icon = new ImageIcon("src/Imagenes/depositar.png");
        String depositarMostrar = (String) JOptionPane.showInputDialog(null, "Introduce el monto a depositar",
            "Depositar Dinero", JOptionPane.INFORMATION_MESSAGE,icon,null,"");
        float saldoLocal;
        
        if(depositarMostrar==null){       
        }else if(depositarMostrar.contains(".")){     
            JOptionPane.showMessageDialog(null, "No puedes depositar centavos","Alerta",JOptionPane.WARNING_MESSAGE);
        }else{
        try{
        saldoLocal = Float.parseFloat(depositarMostrar);
            if(saldoLocal<=8000&&saldoLocal>=1){
                us.setSaldo(us.getSaldo()+saldoLocal);
                //caj.depositar(saldoLocal);
                JOptionPane.showMessageDialog(null, "Nuevo saldo: "+us.getSaldo(),"AVISO",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Deposita cantidades menores a $8000\n y mayores a cero","Alerta",JOptionPane.WARNING_MESSAGE);
            }
        }catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Ingresa solo numeros","Alerta",JOptionPane.WARNING_MESSAGE);
        }  
        }
    }//GEN-LAST:event_depositarActionPerformed

    private void retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarActionPerformed
        ImageIcon icon = new ImageIcon("src/Imagenes/retirar.png");
        String retirarMostrar = (String) JOptionPane.showInputDialog(null, "Introduce el monto a retirar",
            "Retirar Dinero", JOptionPane.INFORMATION_MESSAGE,icon,null,"");
        float saldoLocal;
        
        if(retirarMostrar==null){       
        }else if(retirarMostrar.contains(".")){
            JOptionPane.showMessageDialog(null, "No puedes retirar centavos","Alerta",JOptionPane.WARNING_MESSAGE);
        }else{
        try{
            saldoLocal = Float.parseFloat(retirarMostrar);
            if(saldoLocal<=8000&&saldoLocal>=1 && (us.getSaldo()-saldoLocal)>=0){
                us.setSaldo(us.getSaldo()-saldoLocal);
                //caj.retirar(saldoLocal);
                JOptionPane.showMessageDialog(null, "Nuevo saldo: "+us.getSaldo(),"AVISO",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "No cuentas con saldo suficiente","Alerta",JOptionPane.WARNING_MESSAGE);
            }
        }catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Ingresa solo numeros","Alerta",JOptionPane.WARNING_MESSAGE);
        }
        }
    }//GEN-LAST:event_retirarActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        ImageIcon icon = new ImageIcon("src/Imagenes/consultar.png");
        /*float saldo=0;
        try {
            saldo = caj.consultar();
        } catch (RemoteException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        JOptionPane.showMessageDialog(null, "Tu saldo es: "+us.getSaldo(),"Saldo disponible",JOptionPane.DEFAULT_OPTION, icon);
    }//GEN-LAST:event_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cliente;
    private javax.swing.JButton consultar;
    private javax.swing.JButton depositar;
    private javax.swing.JButton estadoDeCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton retirar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
