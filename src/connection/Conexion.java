package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion conexion;
    private Connection cn;

    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjava?zeroDateTimeBehavior=convertToNull",
                    "root", "pass22");
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException ex) {
            System.out.println("Connection to the DB failed: " + ex);
        }
    }

    public synchronized static Conexion Consultar() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection getCn() {
        return cn;
    }

    public void cerrar() {
        conexion = null;
    }

}
