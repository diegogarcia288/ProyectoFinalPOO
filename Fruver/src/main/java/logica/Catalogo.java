/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.ArrayList;
import modelo.Productos;
/**
 *
 * @author User
 */
public class Catalogo {
    private ArrayList<Productos> producto;
    
    public Catalogo(ArrayList<Productos> producto){
        this.producto = (producto != null) ? producto : new ArrayList<>();
    }
    
    public ArrayList<Productos> getProducto(){
        return producto;
    }
    
    public void añadirProducto(Productos nuevoProducto){
        if(nuevoProducto != null){
            producto.add(nuevoProducto);
        }else{
            System.out.println("No se puede añadir éste producto (nulo)");
        }
    }
    
    public Productos buscarPorId(int idProducto){
        for (Productos p : producto){
            if (p != null && p.getId() == idProducto){
                return p;
            }
        }
        
        return null;
    }
    
    public ArrayList<Productos> listarBajoStock(int stockBajo){
        ArrayList<Productos> productosBajos = new ArrayList<>();
        
        if (stockBajo < 0){
         return productosBajos;
        }
        
        for (Productos p : producto){
            if(p != null && p.getStock() < stockBajo) {
             productosBajos.add(p);
            }
        }
        return productosBajos;
    }
    
    public ArrayList<Productos> obtenerProductos() {
        return producto;
    }
    
}
