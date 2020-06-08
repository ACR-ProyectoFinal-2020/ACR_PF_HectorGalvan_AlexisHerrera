/*
Nombres: Hector Abraham Galvan Garcia y Alexis Herrera Saucedo
Tema del programa: Proyecto Final
Descripcion: Crear una aplicacion que simule un cajero de banco con archivos, hilos y RMI
Fecha: 13/06/2020
*/
package Servidor;

import Interface.Cajero;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CajeroServidor extends UnicastRemoteObject implements Cajero, Runnable{
    
    private final int puerto=1234;
    private ArrayList<Usuario> database;
    private static final String PATH = "Estados_de_cuenta/";
    private Usuario user;
    
    public CajeroServidor() throws RemoteException{
        database=new ArrayList<>();
        cargarDatos();
    }
    
    @Override
    public void modificarDatabase(Usuario u) throws RemoteException {
        for(Usuario usuario:database){
             if(u.getNoTarjeta()==usuario.getNoTarjeta()){
                 usuario.setSaldo(u.getSaldo());
                 guardarDatos();
                 break;
             }   
        }
    }
    
    @Override
    public void cargarDatos(){
        try {
            BufferedReader entrada = new BufferedReader(new FileReader("Database.txt"));
            String s, s2 = new String();
            String name;
            int card;
            int pass;
            float balance;
            
            while ((s = entrada.readLine()) != null) {
                s2 += s + "\n";
                String[] datos = s.split(",");
                card = Integer.parseInt(datos[0]);
                pass = Integer.parseInt(datos[1]);
                balance =  Float.parseFloat(datos[2]); 
                name = datos[3];
                Usuario u = new Usuario(name,card,pass,balance);             
                database.add(u);
            }
            entrada.close();
        } catch (java.io.IOException e) {System.out.println(e.getMessage());}      
    }
    
    @Override
    public void guardarDatos(){
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter("Database.txt")));
            for (int i = 0; i < database.size(); i++) {
                salida.println(database.get(i).getNoTarjeta() + "," + database.get(i).getNip() + "," +database.get(i).getSaldo() +"," +database.get(i).getNombre());
            }
            salida.close();
        } catch (IOException e){System.out.println(e.getMessage());
        }finally {
            salida.close();
        }
    }
  
     @Override
    public boolean ingresar(int cuenta, int nip) throws RemoteException {
        boolean iniciar=false;
        for (Usuario u : database) {
            if(u.getNoTarjeta()==cuenta){
                if(u.getNip()==nip){
                    iniciar=true;
                    user=new Usuario(u.getNombre(),u.getNoTarjeta(),u.getNip(),u.getSaldo());
                    break;
                }
            }else{
                iniciar=false;
            }  
        }
        return iniciar;
    }
    
     @Override
    public boolean registrar(Usuario user) throws RemoteException {
        boolean correcto=false;
        for (Usuario u : database) {
            if(u.getNoTarjeta()==user.getNoTarjeta()){
                correcto=false;//Ya hay un usuario con esa cuenta
                break;
            }else{
              correcto=true;
            }  
        }
        if(correcto){
            database.add(user);
        }    
        return correcto;
    }

    @Override
    public void depositar(float cantidad) throws RemoteException {
        user.setSaldo(user.getSaldo()+cantidad);
    }

    @Override
    public void retirar(float cantidad) throws RemoteException {
        user.setSaldo(user.getSaldo()-cantidad);         
    }

    @Override
    public float consultar() throws RemoteException {
        return user.getSaldo();
    }

    @Override
    public boolean edoCuenta(Usuario usr) throws RemoteException {
        File file = new File(PATH+"Estado de cuenta de_"+usr.getNombre()+".txt");
        PrintWriter salida = null;
        
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(PATH+"Estado de cuenta de_"+usr.getNombre()+".txt")));
            salida.println("El saldo de "+usr.getNombre()+" es: "+ usr.getSaldo());
            salida.close();
        } catch (IOException e) {System.out.println(e.getMessage());} finally {
            salida.close();
        }
        return true;                                             
    }
    
    @Override
    public Usuario devolverUsuario() throws RemoteException {
       return this.user;
    }
    
    @Override
    public void run() {
        try{
            String dirIP=(InetAddress.getLocalHost()).toString();
            System.out.println("Escuchando en.."+dirIP+":"+puerto);
            Registry registry = LocateRegistry.createRegistry(puerto);
            registry.bind("servidor", (Cajero) this);
        }catch(UnknownHostException | AlreadyBoundException | RemoteException e){
            e.printStackTrace();
        } 
    }
}