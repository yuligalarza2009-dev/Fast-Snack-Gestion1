/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Pedido;

/**
 *
 * @author Usuario
 */
public class PedidoDAO {

    public int guardarPedido(Pedido pedido) {

        String sql = "INSERT INTO Pedido (id_cliente, estado, fecha, total) "
                + "VALUES (?, ?, ?, ?)";

        int idGenerado = -1;

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // ✔ AHORA ES ID, NO NOMBRE
            ps.setInt(1, pedido.getCliente().getIdCliente());
            ps.setString(2, pedido.getEstado().toString());
            ps.setTimestamp(3, new java.sql.Timestamp(
                    pedido.getFecha().getTime()
            ));
            ps.setDouble(4, pedido.getTotal());
            ps.executeUpdate();

            //OBTENER ID DEL PEDIDO
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar pedido: " + e.getMessage());
        }
        return idGenerado;
    }

    //  LISTAR PEDIDOS 
    public ResultSet mostrarPedidos() {
        ResultSet rs = null;
        try {
            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(
                    "SELECT * FROM Pedido"
            );
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean actualizarEstado(int idPedido, String nuevoEstado) {
        String sql = "UPDATE Pedido SET estado = ? WHERE id_pedido = ?";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            if (conexion == null) {
                return false;
            }
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPedido);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {

            System.out.println("Error al actualizar pedido: "
                    + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPedido(int idPedido) {
        String sql = "DELETE FROM Pedido WHERE id_pedido = ?";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            if (conexion == null) {
                return false;
            }
            ps.setInt(1, idPedido);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar pedido: "
                    + e.getMessage());
            return false;
        }
    }
}
