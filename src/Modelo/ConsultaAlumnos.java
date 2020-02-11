package Modelo;

import Vista.FrameRegistroAlumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaAlumnos extends Conexion { 
    FrameRegistroAlumno fra = new FrameRegistroAlumno();
     
   // REGISTRO DE ESTUDIANTES 
    public boolean registrar(registroAlumnos rga) {
        PreparedStatement ps = null;
        Connection con = Conexion.conectar();

        String sql = "Insert into registroestudiantes (nombres,apellidos,ci,edad,curso) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rga.getNombres());
            ps.setString(2, rga.getApellidos());
            ps.setString(3, rga.getCi());
            ps.setString(4, rga.getEdad());
            ps.setString(5, rga.getCurso());
            ps.execute(); 
            mostrarDatos("");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }
//
//    public boolean modificar(registroAlumnos rga) {
//        PreparedStatement ps = null;
//        Connection con = Conexion.conectar();
//
//        String sql = "Update registroestudiantes SET nombres=?, apellidos=?, ci=?, edad=?, curso=? Where IdEstudiantes=?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, rga.getNombres());
//            ps.setString(2, rga.getApellidos());
//            ps.setString(3, rga.getCi());
//            ps.setString(4, rga.getEdad());
//            ps.setString(5, rga.getCurso());
//            ps.setInt(6, rga.getIdEstudiantes());
//            ps.execute();
//            return true;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error" + ex);
//            return false;
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//
//        }
//    }
//
//    public boolean eliminar(registroAlumnos rga) {
//        PreparedStatement ps = null;
//        Connection con = Conexion.conectar();
//
//        String sql = "DELETE FROM registroestudiantes WHERE IdEstudiantes =?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, rga.getIdEstudiantes());
//            ps.execute();
//            return true;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error" + ex);
//            return false;
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//
//        }
//    }
//
//    public boolean buscar(registroAlumnos rga) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection con = Conexion.conectar();
//
//        String sql = "SELECT IdEstudiantes, nombres,apellidos, ci, edad, curso FROM registroestudiantes WHERE nombres =?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, rga.getNombres());
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                rga.setIdEstudiantes(Integer.parseInt(rs.getString("IdEstudiantes")));
//                rga.setNombres(rs.getString("nombres"));
//                rga.setApellidos(rs.getString("apellidos"));
//                rga.setCi(rs.getString("ci"));
//                rga.setCurso(rs.getString("edad"));
//                rga.setEdad(rs.getString("curso"));
//                return true;
//
//            }
//
//            return false;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error" + ex);
//            return false;
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//
//        }
//    } 
    
    public void mostrarDatos(String valor){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("APELLIDOS");
        model.addColumn("CI");
        model.addColumn("EDAD");
        model.addColumn("CURSO");
        model.addColumn("TIEMPO");
        model.addColumn("PLANEACION");
        model.addColumn("COORDINACION");
        model.addColumn("FUERZA");
        model.addColumn("SENSIBILIDAD"); 
        
          String sql=""; 
        if(valor.equals("")){
        
        sql="select * from registroestudiantes";
        }else{
            sql="select IdEstudiantes ID, nombres NOMBRES, apellidos APELLIDOS,ci CI , edad EDAD,curso CURSO"
                    + ", tiempo TIEMPO,planeacion PLANEACION, coordinacion COORDINACION, fuerza_muscular FUERZA"
                    + "sensibilidad SENSIBILIDAD from registroestudiantes";
            String dato[] = new String[11]; 
        
        try {
            Connection cn =Conexion.conectar(); 
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            dato[0]= rs.getString(1);
            dato[1]= rs.getString(2);
            dato[2]= rs.getString(3);
            dato[3]= rs.getString(4);
            dato[4]= rs.getString(5);
            dato[5]= rs.getString(6);
            dato[6]= rs.getString(7);
            dato[7]= rs.getString(8);
            dato[8]= rs.getString(9);
            dato[9]= rs.getString(10);
            dato[10]= rs.getString(11);
            
            model.addRow(dato);
            }
           fra.tbAlumnos.setModel(model);
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"ERROR"+ e);
        }
            
        
        }
    }
    
   
}
