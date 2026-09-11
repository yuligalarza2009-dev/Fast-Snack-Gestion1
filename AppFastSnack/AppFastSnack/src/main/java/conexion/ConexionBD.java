/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL
            = "jdbc:mysql://localhost:3306/FastSnackBD";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {

        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexión exitosa");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver no encontrado: "
                    + e.getMessage());

        } catch (SQLException error) {

            System.out.println("Error de conexión: "
                    + error.getMessage());
        }

        if (conexion == null) {
            System.out.println("CONEXION NULL");
        } else {
            System.out.println("CONEXION OK");
        }

        return conexion;
    }
}
