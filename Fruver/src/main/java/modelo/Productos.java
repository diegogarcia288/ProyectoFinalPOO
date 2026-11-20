/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Productos {
    private String tipo;
    private String nombre;
    private int stock;
    private int idProducto;
    private double precio;
    
    public Productos(String tipo, String nombre, int stock, int idProducto, double precio){
        this.tipo = tipo;
        this.nombre = nombre;
        this.stock = (stock >= 0) ? stock : 0;
        this.idProducto = (idProducto >= 0) ? idProducto : 0;
        this.precio = (precio >= 0) ? precio : 0.0;
    }
    
    public double actualizarPrecio (double nuevoPrecio) {
        if(nuevoPrecio < 0){
            System.out.println("No pueden haber precios Negativos");
        } else{
            this.precio = nuevoPrecio;
        }
        return this.precio;
    }
    
    public double calcularPrecioVenta(int cantidad){
        if(cantidad < 0){
            System.out.print("No puede especificar una cantidad negativa");
            return 0;
        }
        return cantidad * precio;
    }
    
    public int actualizarStock(int nuevoStock){
        if (nuevoStock < 0){
            System.out.print("No pueden haber Stocks menores a 0");
        } else{
            this.stock = nuevoStock;
        }
        return this.stock;
    }
    
    public String getTipo(){
    return tipo;
    }
    
    public String getNombre(){
    return nombre;
    }
    
    public int getStock(){
    return stock;
    }
    
    public int getId(){
    return idProducto;    
    }
    
    public double getPrecio(){
    return precio;
    }
    
}
