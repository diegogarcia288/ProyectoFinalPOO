/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.ArrayList;
import modelo.Clientes;
/**
 *
 * @author User
 */
public class GestorClientes {
    private ArrayList<Clientes> cliente;
    
    public GestorClientes(ArrayList<Clientes> cliente){
        this.cliente = (cliente != null) ? cliente : new ArrayList<>();
    }
    
    public ArrayList<Clientes> getCliente(){
        return cliente;
    }
    
    public void registrarCliente( Clientes nuevoCliente ){
        if(nuevoCliente != null){
            cliente.add(nuevoCliente);
        }else{
            System.out.println("No se puede añadir éste cliente (nulo)");
        }
    }
    
    public Clientes buscarPorDocumento(String cedula){
        
        if(cedula == null){
            return null;
        }
        
        for(Clientes c : cliente){
            if(c != null && cedula.equals(c.getCedula())){
                return c;
            }
        }
        return null;
    }
    
}
