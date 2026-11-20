/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class PagoTargeta extends Pagos {

    public PagoTargeta(int idPago, double monto, boolean estadoPago) {
        super(idPago, monto, estadoPago);
    }

    @Override
    public String obtenerMetodoPago() {
        return "Tarjeta";
    }
}