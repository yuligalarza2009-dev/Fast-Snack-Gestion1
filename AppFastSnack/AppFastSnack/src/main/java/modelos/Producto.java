/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author User
 */
public class Producto {
    
    private int idProducto; 
    private String nombre; 
    private double precio;
    
    public Producto () {
            }
        public Producto (int idProducto, String nombre, double precio) {
            this.idProducto = idProducto;
            this.nombre = nombre; 
            this.precio = precio;
        }
        
    public int getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto (int idProducto) {
        this. idProducto = idProducto;
    }
    
      public String getNombre () {
        return nombre;
    }
      
    public void setNombre (String nombre) {
        this. nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio (double precio) {
        if (precio > 0) {
            this.precio = precio;
    } else {
            System.out.println("El precio no puede ser negativo.");
        }
    }
}
