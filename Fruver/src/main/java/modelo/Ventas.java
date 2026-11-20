/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Ventas {
private int idVenta;
private Clientes cliente;
private int numeroRecibo;
private static int contadorVentas;
private ArrayList<DetalleVenta> items;
private Pagos pago;


public Ventas(int idVenta, Clientes cliente, ArrayList<DetalleVenta> items, Pagos pago){
this.idVenta = (idVenta >= 0) ? idVenta : 0;
this.cliente = cliente;
contadorVentas++;
this.numeroRecibo = contadorVentas;
this.items = (items != null) ? items : new ArrayList<>();
this.pago = pago;
}


public int getIdVenta(){
return idVenta;
}


public Clientes getCliente(){
return cliente;
}


public ArrayList<DetalleVenta> getItems(){
return items;
}


public Pagos getPago(){
return pago;
}


public int getNumeroRecibo(){
return numeroRecibo;
}
}
