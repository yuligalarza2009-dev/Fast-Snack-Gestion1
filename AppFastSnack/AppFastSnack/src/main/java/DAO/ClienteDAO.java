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
import modelos.Cliente;

public class ClienteDAO {

    public int guardarCliente(Cliente cliente) {

        int idCliente = -1;
        String sqlPersona = "INSERT INTO Persona (nombre, telefono) VALUES (?, ?)";
        String sqlCliente = "INSERT INTO Cliente (id_persona, direccion) VALUES (?, ?)";

        try (Connection conexion = ConexionBD.conectar()) {
            if (conexion == null) {
                return -1;
            }

            conexion.setAutoCommit(false);

            try (PreparedStatement psPersona
                    = conexion.prepareStatement(sqlPersona,
                            java.sql.Statement.RETURN_GENERATED_KEYS)) {
                psPersona.setString(1, cliente.getNombre());
                psPersona.setString(2, cliente.getTelefono());
                psPersona.executeUpdate();
                ResultSet rs = psPersona.getGeneratedKeys();

                if (rs.next()) {
                    int idPersona = rs.getInt(1);
                    try (PreparedStatement psCliente
                            = conexion.prepareStatement(sqlCliente,
                                    java.sql.Statement.RETURN_GENERATED_KEYS)) {
                        psCliente.setInt(1, idPersona);
                        psCliente.setString(2, cliente.getDireccion());
                        psCliente.executeUpdate();

                        ResultSet rsCliente = psCliente.getGeneratedKeys();
                        if (rsCliente.next()) {
                            idCliente = rsCliente.getInt(1);
                        }
                    }
                }
            }
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: "
                    + e.getMessage());
        }
        return idCliente;
    }

    public ResultSet mostrarClientes() {
        String sql = """
            SELECT c.id_cliente,
                   p.nombre,
                   p.telefono,
                   c.direccion
            FROM Cliente c
            INNER JOIN Persona p
            ON c.id_persona = p.id_persona
            """;
        try {
            Connection conexion = ConexionBD.conectar();
            if (conexion == null) {
                return null;
            }

            PreparedStatement ps = conexion.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {

            System.out.println("Error al mostrar clientes: "
                    + e.getMessage());
            return null;
        }
    }

    public ResultSet buscarCliente(String nombre) {
        String sql = """
            SELECT c.id_cliente,
                   p.nombre,
                   p.telefono,
                   c.direccion
            FROM Cliente c
            INNER JOIN Persona p
            ON c.id_persona = p.id_persona
            WHERE p.nombre LIKE ?
            """;

        try {
            Connection conexion = ConexionBD.conectar();
            if (conexion == null) {
                return null;
            }

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            return ps.executeQuery();

        } catch (SQLException e) {

            System.out.println("Error al buscar cliente: "
                    + e.getMessage());
            return null;
        }
    }
}
