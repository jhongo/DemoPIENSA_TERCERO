package Vista;

import Controlador.CtrAlumnos;
import Modelo.Conexion;
import Modelo.ConsultaAlumnos;
import Modelo.registroAlumnos;
import Modelo.registroDocentes;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class FrameRegistroAlumno extends javax.swing.JFrame {

    CtrAlumnos validar = new CtrAlumnos();

    public FrameRegistroAlumno() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Alumno");
        mostrarDatos("");
        this.setLocationRelativeTo(null);
        validar.validarletras(txtNombreAlumno);
        validar.validarletras(txtApellidosAlumno);
        txtId.setVisible(false);
        
        /*cargar datos en el combo*/
         try {
            Connection cn=Conexion.conectar();
            PreparedStatement ps=cn.prepareStatement("select * from curso"); 
            ResultSet rs =ps.executeQuery();
            while(rs.next()){cmbcurso.addItem(rs.getString("nombre_curso"));}
        } catch (Exception e) {
        }
        

    }

//    private void formWindowOpened(java.awt.event.WindowEvent evt) {
//    cmbCursos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione","1ro Basica"," 2do Basica", "3ro Basica", "4to Basica", "5to Basica", "6to Basica", "7mo Basica"}));
//}
    /*Codigo para validar la cedula*/
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            JOptionPane.showMessageDialog(null, "La Cédula ingresada es Incorrecta");
        } 
        return cedulaCorrecta;
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
        txtId = new javax.swing.JTextField();
        cmbcurso = new javax.swing.JComboBox();
        btnVolver1 = new javax.swing.JButton();
        btnVolver2 = new javax.swing.JButton();

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

        txtNombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreAlumnoKeyTyped(evt);
            }
        });

        txtApellidosAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosAlumnoActionPerformed(evt);
            }
        });
        txtApellidosAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosAlumnoKeyTyped(evt);
            }
        });

        txtCiAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiAlumnoActionPerformed(evt);
            }
        });
        txtCiAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiAlumnoKeyTyped(evt);
            }
        });

        txtEdadAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadAlumnoActionPerformed(evt);
            }
        });
        txtEdadAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadAlumnoKeyTyped(evt);
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
        tbAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAlumnos);

        btnEiminarEstudiantes.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnEiminarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_f-cross_256_282471.png"))); // NOI18N
        btnEiminarEstudiantes.setText("Eiminar");
        btnEiminarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEiminarEstudiantesActionPerformed(evt);
            }
        });

        btnMdificarEstudiantes.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnMdificarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_agt_reload_15581.png"))); // NOI18N
        btnMdificarEstudiantes.setText("Modificar");
        btnMdificarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMdificarEstudiantesActionPerformed(evt);
            }
        });

        btnGuardarEstudiantes.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnGuardarEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_floppy_285657.png"))); // NOI18N
        btnGuardarEstudiantes.setText("Guardar");
        btnGuardarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstudiantesActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_edit-clear_23227.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAlumnoActionPerformed(evt);
            }
        });
        txtBuscarAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnoKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel7.setText("Buscar");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_498_student__notes__note_education_4212916.png"))); // NOI18N

        cmbcurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---------" }));

        btnVolver1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_f-left_256_282467.png"))); // NOI18N
        btnVolver1.setText("Volver");

        btnVolver2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnVolver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_f-left_256_282467.png"))); // NOI18N
        btnVolver2.setText("Volver");
        btnVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnMdificarEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardarEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEiminarEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtEdadAlumno)
                            .addComponent(txtCiAlumno)
                            .addComponent(txtApellidosAlumno)
                            .addComponent(txtNombreAlumno)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnVolver1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarAlumno)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarEstudiantes)
                            .addComponent(btnEiminarEstudiantes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMdificarEstudiantes)
                            .addComponent(btnLimpiar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnVolver1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar() {
        txtNombreAlumno.setText(null);
        txtApellidosAlumno.setText(null);
        txtCiAlumno.setText(null);
        txtEdadAlumno.setText(null); 
        

    }

    public void mostrarDatos(String valor) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMBRES");
        model.addColumn("APELLIDOS");
        model.addColumn("CI");
        model.addColumn("EDAD");
        model.addColumn("CURSO");

        String sql = "";
        if (valor.equals("")) {

            sql = "select * from registroestudiantes";
        } else {
            sql = "select IdEstudiantes ID, nombres NOMBRES, apellidos APELLIDOS,ci CI , edad EDAD,curso CURSO"
                    + " from registroestudiantes where IdEstudiantes = '" + txtBuscarAlumno.getText() + "'";
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

      
        Connection con = Conexion.conectar();
//        txtCursoEstudiantes.setText(cmbCursos.getSelectedItem().toString());

        try {
            PreparedStatement ps = con.prepareStatement("insert into registroestudiantes values (?,?,?,?,?,?)");
            ps.setString(1, "0");
            ps.setString(2, txtNombreAlumno.getText());
            ps.setString(3, txtApellidosAlumno.getText());
            ps.setString(4, txtCiAlumno.getText());
            ps.setString(5, txtEdadAlumno.getText());
            ps.setString(6, cmbcurso.getSelectedItem().toString());
            if (validadorDeCedula(txtCiAlumno.getText())==false) {
           
            }else{
            ps.executeUpdate();
            limpiar();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            mostrarDatos("");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }//GEN-LAST:event_btnGuardarEstudiantesActionPerformed

    private void btnEiminarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEiminarEstudiantesActionPerformed

        int fila = tbAlumnos.getSelectedRow();
        String cod = "";
        cod = tbAlumnos.getValueAt(fila, 0).toString();
        Connection con = Conexion.conectar();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM registroestudiantes WHERE IdEstudiantes='" + txtId.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            limpiar();
            mostrarDatos("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

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

    private void txtNombreAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAlumnoKeyTyped
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 64
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {

            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras");
        }
    }//GEN-LAST:event_txtNombreAlumnoKeyTyped

    private void txtApellidosAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosAlumnoKeyTyped
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 64
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {

            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras");
        }
    }//GEN-LAST:event_txtApellidosAlumnoKeyTyped

    private void txtEdadAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadAlumnoKeyTyped
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {

            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
        int tam = txtEdadAlumno.getText().length();
        if (tam >= 2) {
            evt.consume();

        }
    }//GEN-LAST:event_txtEdadAlumnoKeyTyped

    private void btnMdificarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMdificarEstudiantesActionPerformed

        Connection con = Conexion.conectar();
        try {
//            String ID = txtBuscarAlumno.getText();
            PreparedStatement ps = con.prepareStatement("update registroestudiantes set nombres=?, apellidos=?, ci=?, edad=?, curso=? where IdEstudiantes='"+txtId.getText()+"'");
            ps.setString(1, txtNombreAlumno.getText().trim());
            ps.setString(2, txtApellidosAlumno.getText().trim());
            ps.setString(3, txtCiAlumno.getText().trim());
            ps.setString(4, txtEdadAlumno.getText().trim());
            ps.setString(5, cmbcurso.getSelectedItem().toString().trim());
            ps.executeUpdate(); 
            mostrarDatos("");
            JOptionPane.showMessageDialog(null,"Registro Actualizado"); 
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

    }//GEN-LAST:event_btnMdificarEstudiantesActionPerformed

    private void tbAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAlumnosMouseClicked
        int seleccion = tbAlumnos.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tbAlumnos.getValueAt(seleccion, 0).toString()));
        txtNombreAlumno.setText(String.valueOf(tbAlumnos.getValueAt(seleccion, 1).toString()));
        txtApellidosAlumno.setText(String.valueOf(tbAlumnos.getValueAt(seleccion, 2).toString()));
        txtCiAlumno.setText(String.valueOf(tbAlumnos.getValueAt(seleccion, 3).toString()));
        txtEdadAlumno.setText(String.valueOf(tbAlumnos.getValueAt(seleccion, 4).toString()));
        cmbcurso.setSelectedItem(String.valueOf(tbAlumnos.getValueAt(seleccion, 5).toString()));

    }//GEN-LAST:event_tbAlumnosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtCiAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiAlumnoKeyTyped
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {

            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }

        int tam = txtCiAlumno.getText().length();
        if (tam >= 10) {
            evt.consume();

        }
    }//GEN-LAST:event_txtCiAlumnoKeyTyped

    private void txtBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAlumnoActionPerformed

    private void btnVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver2ActionPerformed
         FrameMenu menu = new FrameMenu();
         menu.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnVolver2ActionPerformed

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
    private javax.swing.JButton btnVolver1;
    private javax.swing.JButton btnVolver2;
    private javax.swing.JComboBox cmbcurso;
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
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreAlumno;
    // End of variables declaration//GEN-END:variables
}
