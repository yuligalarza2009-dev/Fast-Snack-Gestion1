/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author User
 */
public class Pago {
    
    private int idPago;
    private String metodoPago;
    private double monto; 
    private Pedido pedido;
    
    public Pago () {
}
    
    public Pago (int idPago, String metodoPago, 
            double monto, Pedido pedido) {
        
        this.idPago = idPago;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.pedido = pedido;
    }
    
    public int getIdPago () {
        return idPago;
}
    public void setIdPago (int idPago) {
        this.idPago = idPago;
    }
    
    public String getMetodoPago () {
        return metodoPago;
    }
    
    public void setMetodoPago(String metodoPago) {
        if (!metodoPago.isEmpty()) {
            this.metodoPago = metodoPago;
    } else{
    System.out.println( "El método de pago no puede estar vacío.");
            }
    }
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto > 0) {
            this.monto = monto;
        } else{ 
            System.out.println("Valor inválido.");
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}