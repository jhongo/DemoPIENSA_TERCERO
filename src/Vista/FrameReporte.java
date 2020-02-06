package Vista;

import Modelo.Conexion;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/*PDF*/
//lineas de encabezado de pdf
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class FrameReporte extends javax.swing.JFrame {

    public FrameReporte() {
        initComponents();
        /*Maximizae la ventana
        setExtendedState(MAXIMIZED_BOTH);*/
        setTitle("Generar Reporte");
        setLocationRelativeTo(null);
        
        /*Cargar curso en el Combo*/
        try {
            Connection cn=Conexion.conectar();
            PreparedStatement ps=cn.prepareStatement("select * from curso"); 
            ResultSet rs =ps.executeQuery();
            while(rs.next()){cmbcurso.addItem(rs.getString("nombre_curso"));}
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        cmbcurso = new javax.swing.JComboBox();
        btnpdf = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setText("<html>Seleccione el Curso Para Crear el Reporte</html>");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_hand-o-up_1608921.png"))); // NOI18N

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

        cmbcurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------" }));
        cmbcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcursoActionPerformed(evt);
            }
        });

        btnpdf.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_60_page_layout_report_presentation_4307967.png"))); // NOI18N
        btnpdf.setText("Generar Pdf");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setText("Curso:");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnVolver)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(cmbcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnpdf))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(btnpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseReleased

    }//GEN-LAST:event_btnVolverMouseReleased

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        FrameEvaluacion eva = new FrameEvaluacion();
        eva.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcursoActionPerformed
        try {
            
            Connection cn = Conexion.conectar();
            PreparedStatement ps=cn.prepareStatement("select * from registroestudiantes where curso='"+cmbcurso.getSelectedItem()+"'");
            ResultSet rs=ps.executeQuery();
            rs.next();

            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbcursoActionPerformed

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/Desktop/Reporte_PDF.pdf"));
            Image header=Image.getInstance("src/Vista.icons/987420.png");
            header.scaleToFit(250,300);
            header.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Formato para una imagen de una tabla\n\n");
            parrafo.setFont(FontFactory.getFont("Tehoma",20,Font.BOLD,BaseColor.MAGENTA));
            parrafo.add("Cuentas Registrardas\n\n");
            
            documento.open();
            
            documento.add(header);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("NOMBRE");
            tabla.addCell("APELLIDOS");
            tabla.addCell("CEDULA");
            tabla.addCell("EDAD");
            tabla.addCell("EVALUACION");
          
            try {
                Connection cn = Conexion.conectar();
                
                PreparedStatement pst =cn.prepareStatement("select nombres, apellidos, ci, edad, evaluacion  from registroestudiantes where curso = '"+cmbcurso.getSelectedItem()+"' ");
                ResultSet rs=pst.executeQuery();
                if (rs.next()) {
                    do{
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    }while(rs.next());
                    documento.add(tabla);
                }
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Docuemnto PDF Generado Correctamente");
        } catch (DocumentException | HeadlessException | FileNotFoundException  e) {
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
                    
            
        }
    }//GEN-LAST:event_btnpdfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnpdf;
    private javax.swing.JComboBox cmbcurso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
