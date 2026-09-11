/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author User
 */
public class DetallePedido {
    
    private int idDetalle;
    private int cantidad;    
    private double subtotal;
    private Producto producto;
    private Pedido pedido;
    
    public DetallePedido(){
    }
    
    public DetallePedido(int idDetalle, int cantidad, Producto producto, Pedido pedido){
        
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.producto = producto;
        this.pedido = pedido;
        
        calcularSubtotal();
    }
    
    public void calcularSubtotal(){
        
    if(producto != null){
       subtotal = cantidad * producto.getPrecio();
       
    }
}
    public int getIdDetalle(){
        return idDetalle;
    }
    
    public void setIdDetalle(int idDetalle){
        this.idDetalle = idDetalle;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        if(cantidad > 0){
           this.cantidad = cantidad;
         }else{
            System.out.println("La cantidad debe ser mayor a 0.");
        }
    }
    
    public double getSubtotal(){
        return subtotal;
    }
    
    public void setSubtotal(double subtotal){
        this.subtotal = subtotal;
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public void setProducto(Producto producto){
        this.producto = producto;
    }
    
    public Pedido getPedido (){
        return pedido;
    }
    
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }
}
