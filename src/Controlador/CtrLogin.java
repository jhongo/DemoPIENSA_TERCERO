package Controlador;

import Modelo.ConsultaDocentes;
import Modelo.hash;
import Modelo.registroDocentes;
import Vista.FrameEvaluacion;
import Vista.FrameInicio;
import Vista.FrameLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class CtrLogin {
//     private registroDocentes modL;
//    private ConsultaDocentes mod2L;
//    private FrameLogin frmL; 
//    
//    public CtrLogin(registroDocentes modL, ConsultaDocentes mod2L, FrameLogin frmL) {

//        this.modL = modL;
//        this.mod2L = mod2L;
//        this.frmL = frmL;
//        this.frmL.btnIniciar.addActionListener(this);
//
//    } 
//    
//    public void IniciarL(){
//    
//    frmL.setTitle("INICIO DE SESION"); 
//    frmL.setLocationRelativeTo(null);
//    } 
//     
//    @Override
//    public void actionPerformed(ActionEvent e){
//     
//        Date date = new Date(); 
//        DateFormat fechahora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //FORMATO PARA REGISTRAR HORA DE LOGUEO
//        
//        
//        String pass = new String(frmL.txtcontraseña.getPassword()); 
//        
//        //VERIFICAR DATOS CORRECTOS DE LOGIN
//        
//        if(!frmL.txtUsuarioLogin.getText().equals("") && !pass.equals("")){
//            
//            String nuevoPass = hash.sha1(pass);
//            modL.setUsuario(frmL.txtUsuarioLogin.getText()); 
//            modL.setPassword(nuevoPass); 
//            modL.setLast_sesion(fechahora.format(date));
//            if(mod2L.Login(modL))
//            {
//                
//                FrameInicio.frmL = null;
//                //this.dispose();
//                
//                //ACCEDER A NUEVO PANEL
//                FrameEvaluacion  frmHome = new FrameEvaluacion();
//                frmHome.setVisible(true);
//            
//            }else{
//                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
//            }
//            
//        }else{
//        JOptionPane.showMessageDialog(null, "Ingresar datos");
//        }
//    }
}
