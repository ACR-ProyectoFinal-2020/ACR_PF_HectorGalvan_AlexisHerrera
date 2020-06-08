/*
Nombres: Hector Abraham Galvan Garcia y Alexis Herrera Saucedo
Tema del programa: Proyecto Final
Descripcion: Crear una aplicacion que simule un cajero de banco con archivos, hilos y RMI
Fecha: 13/06/2020
*/
package Servidor;

import java.io.Serializable;

public class Usuario implements Serializable{
    private static final long serialVersionUID = 12351313553L;
    private String nombre;
    private int noTarjeta;
    private int nip;
    private float saldo;

    public Usuario(String nombre, int noTarjeta, int nip, float saldo) {
        this.nombre = nombre;
        this.noTarjeta = noTarjeta;
        this.nip = nip;
        this.saldo = saldo;
    }

    public Usuario() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNoTarjeta() {
        return noTarjeta;
    }

    public void setNoTarjeta(int noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public Usuario getUsuario(){
        Usuario us=new Usuario();
        return us;
    }
    
    @Override
    public String toString() {
        return noTarjeta+","+nip+","+saldo+","+nombre;
    }
    
    
    
}
