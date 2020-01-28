package Controlador;

import Modelo.ConsultaAlumnos;
import Modelo.registroAlumnos;
import Vista.FrameRegistroAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CtrAlumnos{ 
    
//    ConsultaAlumnos ca = new ConsultaAlumnos();
//    registroAlumnos ra = new registroAlumnos();
//    FrameRegistroAlumno fa = new FrameRegistroAlumno(); 
//    DefaultTableModel modelo = new DefaultTableModel(); 
//    
//    public CtrAlumnos(FrameRegistroAlumno rac){
//    
//        this.fa=rac; 
//        this.fa.btnBuscarAlumnos.addActionListener(this);
//    }
//    
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource()==fa.btnBuscarAlumnos) {
//             listar(fa.tablaAlumnos);
//        }
//    } 
//    
//    public void listar(JTable tabla){
//    modelo=(DefaultTableModel)tabla.getModel();
//    List<registroAlumnos>lista=ca.listar();
//    Object[] object = new Object[11];
//    
//        for (int i = 0; i < lista.size(); i++) {
//          object[0]=lista.get(i).getIdEstudiantes();
//          object[1]=lista.get(i).getNombres();
//          object[2]=lista.get(i).getApellidos();
//          object[3]=lista.get(i).getCi();
//          object[4]=lista.get(i).getEdad();
//          object[5]=lista.get(i).getCurso();
//          object[6]=lista.get(i).getTiempo();
//          object[7]=lista.get(i).getPlaneacion();
//          object[8]=lista.get(i).getCoordinacion();
//          object[9]=lista.get(i).getFuerza_muscular();
//          object[10]=lista.get(i).getSensibilidad();
//         // object[11]=lista.get(i).getIdEstudiantes(); 
//         modelo.addRow(object);
//        }
//         fa.tablaAlumnos.setModel(modelo);
//    }
    
//    
//    
//    private registroAlumnos modRa;
//    private ConsultaAlumnos mod2Ra;
//    private FrameRegistroAlumno frmRa; 
//    private Connection con; 
//    DefaultTableModel modelo; 
//    
//    public CtrAlumnos(){}
//
//    public CtrAlumnos(registroAlumnos modRa, ConsultaAlumnos mod2Ra, FrameRegistroAlumno frmRa) {
//
//        this.modRa = modRa;
//        this.mod2Ra = mod2Ra;
//        this.frmRa = frmRa;
//        this.frmRa.btnGuardar.addActionListener(this);
//        this.frmRa.btnEliminar.addActionListener(this);
//        this.frmRa.btnLimpiar.addActionListener(this);
//        this.frmRa.btnModificar.addActionListener(this);
//        this.frmRa.btnBuscarAlumnos.addActionListener(this);
//
//    }
//
//    
//
//    public void IniciarRA() {
//        frmRa.setTitle("Registro de Docentes");
//        frmRa.setLocationRelativeTo(null);
//        frmRa.txtId.setVisible(false);
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //EJECUTA EL BOTON GUARDAR EL REGISTRO
//        if (e.getSource() == frmRa.btnGuardar) {
//            modRa.setNombres(frmRa.txtNombreAlumno.getText());
//            modRa.setApellidos(frmRa.txtApellidosAlumno.getText());
//            modRa.setCi(frmRa.txtCiAlumno.getText());
//            modRa.setEdad(frmRa.txtEdadAlumno.getText());
//            modRa.setCurso(frmRa.txtCursoAlumno.getText());
//            if (mod2Ra.registrar(modRa)) {
//                JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
//                mostrarDatos(frmRa.tablaAlumnos);
//                
//            } else {
//                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
//                limpiar();
//            }
//
//        }
//        //EJECUTA EL BOTON MODIFICAR EN EL REGISTRO
//        if (e.getSource() == frmRa.btnModificar) {
//            modRa.setIdEstudiantes(Integer.parseInt(frmRa.txtId.getText()));
//            modRa.setNombres(frmRa.txtNombreAlumno.getText());
//            modRa.setApellidos(frmRa.txtApellidosAlumno.getText());
//            modRa.setCi(frmRa.txtCiAlumno.getText());
//            modRa.setEdad(frmRa.txtEdadAlumno.getText());
//            modRa.setCurso(frmRa.txtCursoAlumno.getText());
//            if (mod2Ra.modificar(modRa)) {
//                JOptionPane.showMessageDialog(null, "MODIFICADO CON EXITO");
//                limpiar();
//            } else {
//                JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
//                limpiar();
//            }
//
//        }
//
//        //EJECUTA E BOTON ELIMINAR EN EL REGISTRO 
//        if (e.getSource() == frmRa.btnEliminar) {
//            modRa.setIdEstudiantes(Integer.parseInt(frmRa.txtId.getText()));
//            if (mod2Ra.eliminar(modRa)) {
//                JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO");
//                limpiar();
//            } else {
//                JOptionPane.showMessageDialog(null, "ERROR AL EIMINADO");
//                limpiar();
//            }
//
//        }
//
//        //EJECUTA LA BUSQUEDA EN EL REGISTRO
//        if (e.getSource() == frmRa.btnBuscarAlumnos) {
//            modRa.setNombres(frmRa.txtBuscarAlumno.getText());
//            if (mod2Ra.buscar(modRa)) {
//
//                frmRa.txtId.setText(String.valueOf(modRa.getIdEstudiantes()));
//                frmRa.txtNombreAlumno.setText(modRa.getNombres());
//                frmRa.txtApellidosAlumno.setText(modRa.getApellidos());
//                frmRa.txtCiAlumno.setText(modRa.getCi());
//                frmRa.txtEdadAlumno.setText(modRa.getEdad());
//                frmRa.txtCursoAlumno.setText(modRa.getCurso());
//
//            } else {
//                JOptionPane.showMessageDialog(null, "NOSE HA ENCONTRADO NINGUN RESULTADO");
//            } 
//            
//
//        }
//
//        if (e.getSource() == frmRa.btnLimpiar) { 
//            mostrarDatos(frmRa.tablaAlumnos);
//            limpiar();
//        }
//
//    }
//
//    //LIMPIAR CAMPOS DE SISTEMA DE REGISTRO
//    public void limpiar() {
//        frmRa.txtNombreAlumno.setText("");
//        frmRa.txtApellidosAlumno.setText("");
//        frmRa.txtCiAlumno.setText("");
//        frmRa.txtEdadAlumno.setText("");
//        frmRa.txtCursoAlumno.setText("");
//        frmRa.txtBuscarAlumno.setText("");
//
//    }
//
//    //MOSTRAR DATOS EN LA TABLA 
//    public void mostrarDatos(JTable tabla) {
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("ID");
//        model.addColumn("Nombres");
//        model.addColumn("Apellidos");
//        model.addColumn("CI");
//        model.addColumn("Edad");
//        model.addColumn("Curso");
//        model.addColumn("Tiempo");
//        model.addColumn("Planeacion");
//        model.addColumn("Coordinacion");
//        model.addColumn("Fuerza");
//        model.addColumn("Sensibilidad");
//
//            
//        String sql = "select IdEstudiantes ID, nombres Nombres, apellidos Apellidos, ci CI, edad Edad, curso Curso, tiempo Tiempo, planeacion Planeacion, ccordinacion Coordinacion, fuerza_muscular Fuerza, sensibilidad Sensibilidad from registroestudiantes";
//         
//        
//        String datos[] = new String[11];
//        
//        
//        try { 
//            //Connection con = Conexion.get
//            PreparedStatement ps= con.prepareStatement(sql);
//            ResultSet rs =ps.executeQuery();
//            
//            while(rs.next()){
//            datos[0]=rs.getString(1);
//            datos[1]=rs.getString(2);
//            datos[2]=rs.getString(3);
//            datos[3]=rs.getString(4);
//            datos[4]=rs.getString(5);
//            datos[5]=rs.getString(6);
//            datos[6]=rs.getString(7);
//            datos[7]=rs.getString(8);
//            datos[8]=rs.getString(9);
//            datos[9]=rs.getString(10);
//            datos[10]=rs.getString(11);
//            model.addRow(datos);
//            }
//            frmRa.tablaAlumnos.setModel(model);
//           
//        } catch (SQLException e) { 
//            System.out.println(e);
//        }
//        
//    } 
    

}
