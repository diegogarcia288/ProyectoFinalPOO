/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.ArrayList;
import modelo.Ventas;
import modelo.DetalleVenta;
/**
 *
 * @author User
 */
public class GestorVentas {
    private ArrayList<Ventas> venta;
    
    public GestorVentas(ArrayList<Ventas> venta ){
    this.venta = (venta != null) ? venta : new ArrayList<>();
    }
    
    public ArrayList<Ventas> getVenta(){
    return venta;
    }
    
    public void registrarVentas( Ventas nuevaVenta ){
        if(nuevaVenta != null){
            venta.add(nuevaVenta);
        }else{
            System.out.println("No se puede añadir ésta venta (nula)");
        }
    }
    
    public String generarReportesVentas(){
        if (venta.isEmpty()){
            return "No hay ventas registradas";
        }
        
        double totalRecaudado = 0;
        
        for (Ventas v: venta){
         if(v.getPago() != null){
             totalRecaudado += v.getPago().getMonto();
        } else if (v.getItems() != null){
          for (DetalleVenta detalle : v.getItems()){
              totalRecaudado += detalle.calcularTotalConIva();
          }
         }
        }
        return "Total de ventas registradas: " + venta.size() + " | Monto Total recaudado: $" + totalRecaudado;
    }
    
}
