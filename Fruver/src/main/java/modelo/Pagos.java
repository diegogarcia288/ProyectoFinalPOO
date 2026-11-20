/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Pagos {
    private int idPago;
    private double monto;
    private boolean estadoPago;
    
    public Pagos(int idPago, double monto, boolean estadoPago){
        this.idPago = idPago;
        this.monto = monto >= 0 ? monto : 0;
        this.estadoPago = estadoPago;
    }
    
    public int getIdPago(){
        return idPago;
    }
    
    public double getMonto(){
        return monto;
    }
    
    public boolean getEstadoPago(){
        return estadoPago;
    }
    
    public boolean setEstadoPago(boolean estadoPago){
        return this.estadoPago = estadoPago;
    }
    
    public String obtenerMetodoPago() {
        return "Método de pago no especificado";
    }
    
}
