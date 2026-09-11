/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;

/**
 *
 * @author User
 */
public class Pedido {
    
    // Atributos
    private int idPedido; 
    private Date fecha; 
    private double total; 
    private Cliente cliente;
    private EstadoPedido estado;

    public Pedido () {
    }

    public Pedido (int idPedido, Date fecha, double total, 
            Cliente cliente, EstadoPedido estado) {
        
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.estado = estado;
    }
    
    public int getIdPedido() {
        return idPedido;
    }
    
    public void setIdpedido (int idPedido) {
        this.idPedido = idPedido;
    }
    
    public Date getFecha () {
        return fecha;
    }
    
    public void setFecha (Date fecha) {
        this.fecha = fecha;
    }
    
    public double getTotal () {
        return total;
    }
    
    public void setTotal (double total) {
        if (total >= 0) {
            this. total = total;
        } else{
            System.out.println ("El total no puede ser negativo.");
        }
    }
        
    public Cliente getCliente () {
        return cliente;
    }
    
    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }
    
    public EstadoPedido getEstado () {
        return estado;
    }
    
    public void setEstado (EstadoPedido estado) {
        this.estado = estado;
    }
    
}
