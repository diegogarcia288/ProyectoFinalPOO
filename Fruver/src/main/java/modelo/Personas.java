/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Personas {
    private String nombre;
    private String cedula;
    
    public Personas(String nombre, String cedula){
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            this.nombre = nombre;
        }else {
            System.out.println("El nombre no puede estar vacío");
        } 
    }
    
    public String getCedula(){
        return cedula;
    } 
    
}
