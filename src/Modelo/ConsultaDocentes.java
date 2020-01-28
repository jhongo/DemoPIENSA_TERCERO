package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ConsultaDocentes{

    //REGISTRO DE DOCENTES
    public boolean registrar(registroDocentes usr) {
        PreparedStatement ps = null;
        Connection con = Conexion.conectar();

        String sql = "INSERT INTO registrodocentes (usuario,password,nombre,correo) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
//            ps.setInt(5, usr.getId_tipo());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLException.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
           // System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }
    //VALIADACION DE CORREO
    public boolean esEmail(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

    } 
    
       public int existeUsuario(String docente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion.conectar();

        String sql = "SELECT count(Id) FROM registrodocentes WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, docente);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 1;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    } 
       
       
       //INICIO DE SESION 
       public boolean Login(registroDocentes rgd) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion.conectar();

        String sql = "SELECT Id,usuario,password,nombre FROM registrodocentes WHERE usuario =?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rgd.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (rgd.getPassword().equals(rs.getString(3))) {

                    String sqlUpdate = "UPDATE registrodocentes SET last_time=? WHERE Id=?";

                    ps = con.prepareStatement(sqlUpdate);
                    ps.setString(1, rgd.getLast_sesion());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();

                    rgd.setId(rs.getInt(1));
                    rgd.setNombre(rs.getString(4));
                  
                    return true;
                } else {
                    return false;
                }
            }

            return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

}
