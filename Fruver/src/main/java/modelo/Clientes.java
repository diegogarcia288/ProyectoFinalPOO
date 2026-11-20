/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author User
 */
public class Clientes extends Personas{
    private String telefono;
    
    public Clientes(String nombre, String cedula, String telefono){
        super(nombre , cedula);
        this.telefono = telefono;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        if(telefono != null && !telefono.trim().isEmpty()){
           this.telefono = telefono;
        } else {
           System.out.println("El campo de teléfono no puede estar vacío"); 
        }    
    }
}
