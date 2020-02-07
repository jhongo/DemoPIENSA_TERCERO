package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class FrameReportesEstudiantes extends javax.swing.JFrame {
    
    
    public FrameReportesEstudiantes() {
        initComponents();
        mostrarDatos("");
        setTitle("Evaluaciones Realizadas");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        txtci = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JLabel();
        txtedad = new javax.swing.JLabel();
        txtcurso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaevaluacion = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        txtBuscarAlumno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaalumnos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_f-left_256_282467.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVolverMouseReleased(evt);
            }
        });
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel4.setText("CI:");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel5.setText("Edad:");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel6.setText("Curso:");

        txtnombre.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtnombre.setText("------------------------");
        txtnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtci.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtci.setText("------------------------");
        txtci.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtapellidos.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtapellidos.setText("------------------------");
        txtapellidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtedad.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtedad.setText("------------------------");
        txtedad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtcurso.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtcurso.setText("------------------------");
        txtcurso.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaevaluacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaevaluacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaevaluacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaevaluacion);

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel7.setText("Id:");

        txtid.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtid.setText("------------------------");
        txtid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel8.setText("Buscar");

        tablaalumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaalumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaalumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaalumnos);

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel9.setText("EVALUACIONES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(39, 39, 39))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txtapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtci, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(txtedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(431, 431, 431))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarAlumno)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtapellidos)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcurso)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseReleased

    }//GEN-LAST:event_btnVolverMouseReleased
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    public void mostrarDatos(String valor) {
        DefaultTableModel mode1 = new DefaultTableModel();
        mode1.addColumn("ID");
        mode1.addColumn("NOMBRES");
        mode1.addColumn("APELLIDOS");
        mode1.addColumn("CI");
        mode1.addColumn("EDAD");
        mode1.addColumn("CURSO");

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

                mode1.addRow(dato);
            }
            tablaalumnos.setModel(mode1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }

    }

    private void tablaevaluacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaevaluacionMouseClicked
        
    }//GEN-LAST:event_tablaevaluacionMouseClicked

    private void txtBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAlumnoActionPerformed

    private void txtBuscarAlumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnoKeyPressed

        try {
            DefaultTableModel model3 = new DefaultTableModel();
            model3.addColumn("ID");
            model3.addColumn("NOMBRE");
            model3.addColumn("APELLIDOS");
            model3.addColumn("CI");
            model3.addColumn("EDAD");
            model3.addColumn("CURSO");

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

                model3.addRow(dato);
            }
            tablaalumnos.setModel(model3);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }//GEN-LAST:event_txtBuscarAlumnoKeyPressed

    private void tablaalumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaalumnosMouseClicked
   int seleccion = tablaalumnos.rowAtPoint(evt.getPoint());
        txtid.setText(String.valueOf(tablaalumnos.getValueAt(seleccion, 0).toString()));
        txtnombre.setText(String.valueOf(tablaalumnos.getValueAt(seleccion, 1).toString()));
        txtapellidos.setText(String.valueOf(tablaalumnos.getValueAt(seleccion, 2).toString()));
        txtci.setText(String.valueOf(tablaalumnos.getValueAt(seleccion, 3).toString()));
        txtedad.setText(String.valueOf(tablaalumnos.getValueAt(seleccion, 4).toString()));
        txtcurso.setText(String.valueOf(tablaalumnos.getValueAt(seleccion, 5).toString()));
     /************************************************************************************************/
     DefaultTableModel mode2 = new DefaultTableModel();
           String a=(String.valueOf(tablaalumnos.getValueAt(seleccion, 0).toString()));
                try {
            Connection cn2=Conexion.conectar();
            PreparedStatement pst=cn2.prepareStatement("select tiempo,planeacion,coordinacion,fuerza_muscular,sensibilidad,fecha from datosevaluacion where idestudiante= '"+a+"' "); 
            ResultSet rs2 =pst.executeQuery();
            tablaevaluacion = new JTable (mode2);
            jScrollPane1.setViewportView(tablaevaluacion);
            mode2.addColumn("TIEMPO");
            mode2.addColumn("PLANEACION");
            mode2.addColumn("COORDINACION");
            mode2.addColumn("FUERZA MUSCULAR");
            mode2.addColumn("SENSIBILIDAD");
            mode2.addColumn("FECHA");
            
        while (rs2.next()) {
            Object[] filae=new Object[6];
            for (int i = 0; i < 6; i++) {
                filae[i]=rs2.getObject(i+1);
            }
            mode2.addRow(filae);
        }
        tablaevaluacion.setModel(mode2);
        cn2.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error"+e);
        }
    }//GEN-LAST:event_tablaalumnosMouseClicked

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
            java.util.logging.Logger.getLogger(FrameReportesEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameReportesEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameReportesEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameReportesEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameReportesEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablaalumnos;
    public javax.swing.JTable tablaevaluacion;
    public javax.swing.JTextField txtBuscarAlumno;
    private javax.swing.JLabel txtapellidos;
    private javax.swing.JLabel txtci;
    private javax.swing.JLabel txtcurso;
    private javax.swing.JLabel txtedad;
    private javax.swing.JLabel txtid;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
