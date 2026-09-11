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
public class Factura {
    
    private int idFactura;
    private String numeroFactura;
    private Date fechaEmision;
    private double totalFactura;
    private Pedido pedido;
    
    public Factura() {
   }
    
    public Factura (int idFactura, String numeroFactura,
        Date fechaEmision, double totalFactura,
        Pedido pedido) {

        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.totalFactura = totalFactura;
        this.pedido = pedido;
    }
    
    public int getidFactura() {
        return idFactura;
    }
    
    public void setIdfactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        if (!numeroFactura.isEmpty()) {
            this.numeroFactura = numeroFactura;
        }else{
            System.out.println("Número de factura vacío.");
        }
    }    
        
    
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setfechalmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double gettotalfaatura() {
        return totalFactura;
    }

    public void setfotalfactura(double totalFactura) {
       if (totalFactura >= 0) {
            this.totalFactura = totalFactura;
       } else {
                System.out.println ("fotal inválido. ") ;
       }
    }
    
   public Pedido getPedido () {
       return pedido;
   }
   
    public void setPedido (Pedido pedido) {
        this.pedido = pedido;
   } 
   
}
