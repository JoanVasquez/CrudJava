package modelo;

import connection.Conexion;
import dao.DaoInterface;
import dto.DtoPojos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloPersona implements DaoInterface<DtoPojos> 
{

    private static final String query_Insert = "INSERT INTO usuario "
            + "(documento_identidad, antecedente_penales, direccion, telefono, email, nombres, apellidos) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String query_Delete = "DELETE FROM usuario WHERE documento_identidad = ?";
    private static final String query_Update = "UPDATE usuario SET documento_identidad = ?, antecedente_penales = ?, "
            + "direccion = ?, telefono = ?, email = ?, nombres = ?, apellidos = ? WHERE documento_identidad = ?";
    private static final String query_Read = "SELECT * FROM usuario WHERE documento_identidad = ?";
    private static final String query_ReadAll = "SELECT * FROM usuario";
    private static final Conexion conexion = Conexion.Consultar();

    @Override
    public boolean insertar(DtoPojos r, String email) {
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = conexion.getCn().prepareStatement("SELECT * FROM usuario WHERE email = ?");
            ps.setString(1, email);

            res = ps.executeQuery();
            if (res.next()) {
                System.out.println("Usuario ya existene");
            } else {

                ps = conexion.getCn().prepareStatement(query_Insert);
                ps.setString(1, r.getIdentificacion());
                ps.setString(2, r.getAntecedentesPenales());
                ps.setString(3, r.getDireccion());
                ps.setString(4, r.getTelefono());
                ps.setString(5, r.getEmail());
                ps.setString(6, r.getNombre());
                ps.setString(7, r.getApellidos());

                if (ps.executeUpdate() > 0) {
                    return true;
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex);
        } finally {
            conexion.cerrar();
        }
        return false;
    }

    @Override
    public boolean modificar(String id, DtoPojos r) {
        PreparedStatement ps;

        try {

            ps = conexion.getCn().prepareStatement(query_Update);
            ps.setString(1, r.getIdentificacion());
            ps.setString(2, r.getAntecedentesPenales());
            ps.setString(3, r.getDireccion());
            ps.setString(4, r.getTelefono());
            ps.setString(5, r.getEmail());
            ps.setString(6, r.getNombre());
            ps.setString(7, r.getApellidos());
            ps.setString(8, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error al modificar usuario:: " + ex);
        } finally {
            conexion.cerrar();
        }
        return false;
    }

    @Override
    public boolean eliminar(Object k) {
        PreparedStatement ps;

        try {

            ps = conexion.getCn().prepareStatement(query_Delete);
            ps.setString(1, k.toString());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminal usuario");
        } finally {
            conexion.cerrar();
        }
        return false;
    }

    @Override
    public DtoPojos leer(Object k) {
        PreparedStatement ps;
        DtoPojos dp = null;
        ResultSet res;
        try {

            ps = conexion.getCn().prepareStatement(query_Read);
            ps.setString(1, k.toString());

            res = ps.executeQuery();

            while (res.next()) {
                dp = new DtoPojos(res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getString(6), res.getString(7), res.getString(8));

            }
            return dp;
        } catch (SQLException ex) {
            System.out.println("\n \nError al buscar usuario: " + ex);
        } finally {
            conexion.cerrar();
        }

        return dp;
    }

    @Override
    public List<DtoPojos> leerTodos() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<DtoPojos> usuario = new ArrayList();
        try {

            ps = conexion.getCn().prepareStatement(query_ReadAll);
            res = ps.executeQuery();

            while (res.next()) {
                usuario.add(new DtoPojos(res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getString(6), res.getString(7), res.getString(8)));
            }

            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

}
