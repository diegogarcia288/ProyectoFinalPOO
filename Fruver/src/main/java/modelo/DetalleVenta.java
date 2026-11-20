/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class DetalleVenta {
private Productos producto;
private int cantidad;
private double total;
private double iva = 0.19;


public DetalleVenta(Productos producto, int cantidad, double total, double iva){
this.cantidad = cantidad;
this.iva = iva;
this.producto = producto;
this.total = total;
}


public Productos getProducto(){
return producto;
}


public int getCantidad(){
return cantidad;
}

public double getTotal(){
return total;
}


public double getIva(){
return iva;
}


public double calcularSubTotal(){
return total * cantidad;
}


public double calcularTotalConIva(){
return calcularSubTotal() * (1 + iva);
}

}