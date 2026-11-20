/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Verduras extends Productos {
    
    public Verduras (String tipo, String nombre, int stock, int idProducto, double precio){
        super(tipo , nombre , stock , idProducto , precio);
    }
    
    @Override
    public double actualizarPrecio(double nuevoPrecio){
        return super.actualizarPrecio(nuevoPrecio);
    }
    
    @Override
    public double calcularPrecioVenta(int cantidad){
        double subtotal = super.calcularPrecioVenta(cantidad);
        if (cantidad >= 5){
            return subtotal * 0.95;
        }
        return subtotal;
    }
    
    @Override
    public int actualizarStock(int nuevoStock){
        return super.actualizarStock(nuevoStock);
    }
    
}
