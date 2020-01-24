package Controlador;

import Modelo.ConsultaDocentes;
import Modelo.hash;
import Modelo.registroDocentes;
import Vista.FrameRegistroDocentes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;

public class CtrDocentes implements ActionListener {

    private registroDocentes mod;
    private ConsultaDocentes mod2;
    private FrameRegistroDocentes frm;

    public CtrDocentes(registroDocentes mod, ConsultaDocentes mod2, FrameRegistroDocentes frm) {

        this.mod = mod;
        this.mod2 = mod2;
        this.frm = frm;
        this.frm.btnRegistrar.addActionListener(this);

    }

    public void Iniciar() {
        frm.setTitle("Registro de Docentes");
        frm.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//    if(e.getSource()==frm.btnRegistrar){
//    mod.setUsuario(frm.txtUsuario.getText());
//    mod.setPassword(frm.txtPassword.getText());
//    mod.setNombre(frm.txtNombre.getText());
//    mod.setCorreo(frm.txtCorreo.getText());

        String pass = new String(frm.txtPassword.getPassword());
        String passC = new String(frm.txtPasswordC.getPassword());

        if (frm.txtUsuario.getText().equals("") || pass.equals("") || passC.equals("") || frm.txtNombre.getText().equals("")
                || frm.txtCorreo.getText().equals("")) { //VERIFICA QUE TODOS LOS CAMPOS DE TEXTOS ESTE LLENOS

            JOptionPane.showMessageDialog(null, "Llenar todos los campos");
        } else {

            if (pass.equals(passC)) { //CONFIRMACION DE CORREO

                if (mod2.existeUsuario(frm.txtUsuario.getText()) == 0) { //VERIFICACION DE USUARIOS EXISTENTES

                    if (mod2.esEmail(frm.txtCorreo.getText())) { //VALIDACION DE CORREO EXISTENTE

                        String nuevoPass = hash.sha1(pass);

                        mod.setUsuario(frm.txtUsuario.getText());
                        mod.setPassword(nuevoPass);
                        mod.setNombre(frm.txtNombre.getText());
                        mod.setCorreo(frm.txtCorreo.getText());

                        if (mod2.registrar(mod)) {
                            JOptionPane.showMessageDialog(null, "Guardado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar");

                        } //REGISTRO DE USUARIOS
                    } else {
                        JOptionPane.showMessageDialog(null, "El correo electronico no es valido");
                    } //FINALIZACION DE VALIDACION DE CORREO
                } else {

                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }  //TERMINO DE VERIFICACION DE USUARIO EXISTENTE
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña no coincide");
            } //TERMINO DE VERIFICACION DE CORREO EXISTENTE
        }
    }

}
