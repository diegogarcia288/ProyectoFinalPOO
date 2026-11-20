/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Granos extends Productos {
    
    public Granos (String tipo, String nombre, int stock, int idProducto, double precio){
        super(tipo , nombre , stock , idProducto , precio);
    }
    
        @Override
    public double actualizarPrecio(double nuevoPrecio){
        return super.actualizarPrecio(nuevoPrecio);
    }
    
    @Override
    public double calcularPrecioVenta(int cantidad){
        return super.calcularPrecioVenta(cantidad);
    }
    
    @Override
    public int actualizarStock(int nuevoStock){
        return super.actualizarStock(nuevoStock);
    }
    
}
