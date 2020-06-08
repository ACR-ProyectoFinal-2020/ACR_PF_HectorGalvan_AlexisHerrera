/*
Nombres: Hector Abraham Galvan Garcia y Alexis Herrera Saucedo
Tema del programa: Proyecto Final
Descripcion: Crear una aplicacion que simule un cajero de banco con archivos, hilos y RMI
Fecha: 13/06/2020
*/
package Interface;

import Servidor.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cajero extends Remote{
    
    public void depositar(float cantidad) throws RemoteException;
    
    public void retirar(float cantidad) throws RemoteException;
    
    public float consultar() throws RemoteException;

    public boolean registrar(Usuario u) throws RemoteException;
    
    public boolean edoCuenta(Usuario u) throws RemoteException; 
    
    public boolean ingresar(int cuenta, int nip) throws RemoteException; 
    
    public Usuario devolverUsuario() throws RemoteException; 
    
    public void cargarDatos() throws RemoteException;
    
    public void guardarDatos() throws RemoteException;
    
    public void modificarDatabase(Usuario u) throws RemoteException;
    
}
