package Modelo;
import java.sql.*; 
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Conexion { 
    
        public static Connection conectar(){
        try {
            Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/escuela","root","");
            
              return cn;
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "   Erro en la conexion "+e);
        }
        
        return (null);
    }
    
    
    
    
//    private final String base = "escuela";
//    private final String user = "root";
//    private final String password = "";
//    private final String url = "jdbc:mysql://localhost:3306/"+base;
//    private Connection con=null; 
    
    
//    public Connection getConexion(){
//        try {
//             Class.forName("com.mysql.jdbc.Driver");
//            con=(Connection) DriverManager.getConnection(url,user,password);
//        } catch (SQLException e) { 
//            
//            System.out.println(e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }    
//        return con;
//    }
  
    
}
