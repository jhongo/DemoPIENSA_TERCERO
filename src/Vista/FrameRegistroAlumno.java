package Vista;

import Modelo.Conexion;
import Modelo.ConsultaAlumnos;
import Modelo.registroAlumnos;
import Modelo.registroDocentes;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameRegistroAlumno extends javax.swing.JFrame {

    public FrameRegistroAlumno() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        txtApellidosAlumno = new javax.swing.JTextField();
        txtCiAlumno = new javax.swing.JTextField();
        txtEdadAlumno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlumnos = new javax.swing.JTable();
        btnEiminarEstudiantes = new javax.swing.JButton();
        btnMdificarEstudiantes = new javax.swing.JButton();
        btnGuardarEstudiantes = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtBuscarAlumno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setText("CI:");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel4.setText("Edad:");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel5.setText("Curso:");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setText("REGISTRO DE ESTUDIANTES");

        txtApellidosAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosAlumnoActionPerformed(evt);
            }
        });

        txtCiAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiAlumnoActionPerformed(evt);
            }
        });

        txtEdadAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadAlumnoActionPerformed(evt);
            }
        });

        tbAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbAlumnos);

        btnEiminarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_f-cross_256_282471.png"))); // NOI18N
        btnEiminarEstudiantes.setText("Eiminar");
        btnEiminarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEiminarEstudiantesActionPerformed(evt);
            }
        });

        btnMdificarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_agt_reload_15581.png"))); // NOI18N
        btnMdificarEstudiantes.setText("Modificar");

        btnGuardarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_floppy_285657.png"))); // NOI18N
        btnGuardarEstudiantes.setText("Guardar");
        btnGuardarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstudiantesActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_edit-clear_23227.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");

        txtBuscarAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnoKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel7.setText("Buscar");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_498_student__notes__note_education_4212916.png"))); // NOI18N

        cmbCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONAR-- ", "1ro Basica", "2do Basica ", "3ro Basica ", "4to Basica ", "5to Basica ", "6to Basica", "7mo Basica" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnMdificarEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnGuardarEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEiminarEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(36, 36, 36))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCiAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEdadAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarAlumno)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtCiAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtEdadAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarEstudiantes)
                            .addComponent(btnEiminarEstudiantes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMdificarEstudiantes)
                            .addComponent(btnLimpiar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar(){
    txtNombreAlumno.setText(null);
    txtApellidosAlumno.setText(null); 
    txtCiAlumno.setText(null); 
    txtEdadAlumno.setText(null);  
    }
    public void mostrarDatos(String valor) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("APELLIDOS");
        model.addColumn("CI");
        model.addColumn("EDAD");
        model.addColumn("CURSO");

        String sql = "";
        if (valor.equals("")) {

            sql = "select * from registroestudiantes";
        } else {
            sql = "select IdEstudiantes ID, nombres NOMBRES, apellidos APELLIDOS,ci CI , edad EDAD,curso CURSO"
                    + " from registroestudiantes where IdEstudiante = '" + txtBuscarAlumno.getText() + "'";
        }
        String dato[] = new String[7];

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
                dato[5] = rs.getString(6);

                model.addRow(dato);
            }
            tbAlumnos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }

    }
    private void txtApellidosAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosAlumnoActionPerformed

    private void txtCiAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiAlumnoActionPerformed

    private void txtEdadAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadAlumnoActionPerformed

    private void btnGuardarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstudiantesActionPerformed

        PreparedStatement ps = null;
        Connection con = Conexion.conectar();

        String sql = "Insert into registroestudiantes (nombres,apellidos,ci,edad,curso) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, txtNombreAlumno.getText());
            ps.setString(2, txtApellidosAlumno.getText());
            ps.setString(3, txtCiAlumno.getText());
            ps.setString(4, txtEdadAlumno.getText());
            ps.setString(5, cmbCursos.getSelectedItem().toString());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            mostrarDatos(""); 
            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

//      ConsultaAlumnos modSql = new ConsultaAlumnos();
//        registroAlumnos mod = new registroAlumnos();
//        
//        mod.setNombres(txtNombreAlumno.getText());
//        mod.setApellidos(txtApellidosAlumno.getText()); 
//        mod.setCi(txtCiAlumno.getText());
//        mod.setEdad(txtEdadAlumno.getText());
//        mod.setCurso(txtCursoAlumno.getText());
//        
//        if (modSql.registrar(mod)) {
//            JOptionPane.showMessageDialog(null, "Guardado");
//           
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al guardar");
//
//        }

    }//GEN-LAST:event_btnGuardarEstudiantesActionPerformed

    private void btnEiminarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEiminarEstudiantesActionPerformed

    }//GEN-LAST:event_btnEiminarEstudiantesActionPerformed

    private void txtBuscarAlumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoKeyPressed

 
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("NOMBRE");
            model.addColumn("APELLIDOS");
            model.addColumn("CI");
            model.addColumn("EDAD");
            model.addColumn("CURSO");
            
            String dato[] = new String[7];
            Connection cn = Conexion.conectar();
            
            PreparedStatement ps = cn.prepareStatement("select IdEstudiantes ID, nombres NOMBRES, apellidos APELLIDOS,ci CI , edad EDAD,curso CURSO"
                    + " from registroestudiantes where nombres LIKE '%" + txtBuscarAlumno.getText() + "%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
                dato[5] = rs.getString(6);

                model.addRow(dato);
            }
            tbAlumnos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }//GEN-LAST:event_txtBuscarAlumnoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameRegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRegistroAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRegistroAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEiminarEstudiantes;
    private javax.swing.JButton btnGuardarEstudiantes;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMdificarEstudiantes;
    private javax.swing.JComboBox<String> cmbCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbAlumnos;
    private javax.swing.JTextField txtApellidosAlumno;
    public javax.swing.JTextField txtBuscarAlumno;
    private javax.swing.JTextField txtCiAlumno;
    private javax.swing.JTextField txtEdadAlumno;
    private javax.swing.JTextField txtNombreAlumno;
    // End of variables declaration//GEN-END:variables
}
