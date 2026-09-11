/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.DetallePedido;

/**
 *
 * @author User
 */
public class DetallePedidoDAO {
    
    public void guardarDetalle(int idPedido, int idProducto, int cantidad, double precio) {
        String sql = "INSERT INTO Detalle_Pedido "
                + "(id_pedido, id_producto, cantidad, precio, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";
        double subtotal = cantidad * precio;

        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precio);
            ps.setDouble(5, subtotal);
            ps.executeUpdate();
            System.out.println("Detalle guardado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle: " + e.getMessage());
        }
    }
}
