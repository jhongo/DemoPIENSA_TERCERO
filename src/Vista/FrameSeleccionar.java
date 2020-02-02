/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar hidalgo
 */
public class FrameSeleccionar extends javax.swing.JFrame {

public static String alumno_update;
DefaultTableModel mode1 = new DefaultTableModel();

    /**
     * Creates new form FrameSeleccionar
     */
    public FrameSeleccionar() {
        initComponents();
       
       
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setTitle("Seleccionar Alumnos");
                try {
                   
            Connection cn=Conexion.conectar();
            PreparedStatement ps=cn.prepareStatement("select IdEstudiantes,nombres,apellidos,ci,edad,curso from registroestudiantes"); 
            ResultSet rs =ps.executeQuery();
            tbalumnos = new JTable(mode1);
            jScrollPane1.setViewportView(tbalumnos);
            mode1.addColumn("ID");
            mode1.addColumn("NOMBRE");
            mode1.addColumn("APELLIDOS");
            mode1.addColumn("CI");
            mode1.addColumn("EDAD");
            mode1.addColumn("CURSO");
        while (rs.next()) {
            Object[] fila=new Object[6];
            for (int i = 1; i < 6; i++) {
                fila[i]=rs.getObject(i+1);
            }
            mode1.addRow(fila);
        }
        cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error"+e);
        }
        tbalumnos.addMouseListener(new MouseAdapter(){
       @Override
       public void mouseClicked(MouseEvent e){
       int fila_point=tbalumnos.rowAtPoint(e.getPoint());
       int columna=2;
       if (fila_point>-1){
           alumno_update=(String)mode1.getValueAt(fila_point, columna);
           FrameEvaluacion informacion=new FrameEvaluacion();
           informacion.setVisible(true);
       }
       }
    });
    }/*
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
            sql = "select IdEstudiantes ID, nombres NOMBRE, apellidos APELLIDOS,ci CI , edad EDAD,curso CURSO"
                    + " from registroestudiantes where IdEstudiantes = '" + txtbuscar.getText() + "'";
        }
        String dato[] = new String[6];

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
            tbalumnos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
}*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbalumnos = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setText("Seleccione el Estudiante Para Evaluar");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_hand-o-up_1608921.png"))); // NOI18N

        tbalumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbalumnos);

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Buscar:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnVolver)
                .addGap(0, 794, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("NOMBRE");
            model.addColumn("APELLIDOS");
            model.addColumn("CI");
            model.addColumn("EDAD");
            model.addColumn("CURSO");

            String dato[] = new String[6];
            Connection cn = Conexion.conectar();

            PreparedStatement ps = cn.prepareStatement("select IdEstudiantes ID, nombres NOMBRES, apellidos APELLIDOS,ci CI , edad EDAD,curso CURSO"
                    + " from registroestudiantes where nombres LIKE '%" + txtbuscar.getText() + "%'");
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
            tbalumnos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void btnVolverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseReleased

    }//GEN-LAST:event_btnVolverMouseReleased

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSeleccionar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbalumnos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
