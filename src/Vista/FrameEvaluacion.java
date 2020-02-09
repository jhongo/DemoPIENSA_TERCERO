package Vista;

import Arduino.Arduino;
import Modelo.Conexion;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import panamahitek.PanamaHitek_Arduino;

public class FrameEvaluacion extends javax.swing.JFrame {
DefaultTableModel mode1 = new DefaultTableModel();
    String alumno_update = "";
    int ID;
    String tiempo;

    private PanamaHitek_Arduino ino = new PanamaHitek_Arduino(); //Variable perteneciente al arduino 

    private SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable() == true) {
                    lblTiempo.setText(ino.printMessage());

                }

            } catch (Exception e) {
            }

        }

    };

    Arduino arduino = new Arduino(); // Llamar a la clase arduino 

    public FrameEvaluacion() {
        initComponents();
        JPseleccionar.setVisible(false);
        txtid.setVisible(false);
        this.setLocationRelativeTo(null);
       
        /*
        ******************
        */
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
            for (int i = 0; i < 6; i++) {
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
              if (fila_point>-1){           
        txtid.setText(String.valueOf(tbalumnos.getValueAt(fila_point, 0).toString()));
        txtnombre.setText(String.valueOf(tbalumnos.getValueAt(fila_point, 1).toString()));
        txtapellidos.setText(String.valueOf(tbalumnos.getValueAt(fila_point, 2).toString()));
        txtci.setText(String.valueOf(tbalumnos.getValueAt(fila_point,3).toString()));
        txtedad.setText(String.valueOf(tbalumnos.getValueAt(fila_point, 4).toString()));
        txtcurso.setText(String.valueOf(tbalumnos.getValueAt(fila_point, 5).toString()));
        
       }
              JPseleccionar.setVisible(false);
              JPevaluacion.setVisible(true);
       }
    });
        
        /*
        ******************
        */
        
        
        
         

        //****************Conexion de la interfaz con arduino
        try {
            //ino.arduinoRXTX("COM16", 9600, listener);
            //  ino.ArduinoTX("COM16", 0, 9600);
            ino.arduinoRXTX("COM16",9600, listener);
            //    ino.ArduinoRX("COM16", 0, 9600, listener);

            //
        } catch (Exception e) {
        }

        /**
         * ******************************
         */
        txtid.setVisible(true);
        /*Maximizae la ventana*/
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Evaluación");
        this.setLocationRelativeTo(null);

        
        jpTiempo.setEnabled(false);
//        t = new Timer(10, acciones);
        /*Cargar datos seleccionados*/
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from registroestudiantes where nombres='" + alumno_update + "' ");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ID = rs.getInt("IdEstudiantes");
                txtid.setText(rs.getString("IdEstudiantes"));
                txtnombre.setText(rs.getString("nombres"));
                txtapellidos.setText(rs.getString("apellidos"));
                txtci.setText(rs.getString("ci"));
                txtedad.setText(rs.getString("edad"));
                txtcurso.setText(rs.getString("curso"));
                rs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Descargar datos" + e);
        }
    }

    //metodo desconocido
    public void limpiar() {
        txtTiempoEvaluacion.setText("");
        txtapellidos.setText("");
        txtci.setText("");
        txtcurso.setText("");
        txtedad.setText("");
        txtid.setText("");
        txtnombre.setText("");
    }

    //MOSTRAR RESULTADOS DEL MONITOR SERIAL EN UN JFRAME
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Jpestudiantes = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JLabel();
        txtci = new javax.swing.JLabel();
        txtcurso = new javax.swing.JLabel();
        txtedad = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        JPevaluacion = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbsensibilidad = new javax.swing.JComboBox<String>();
        cmbfuerzamuscular = new javax.swing.JComboBox<String>();
        cmbcoordinacion = new javax.swing.JComboBox<String>();
        cmbplaneacion = new javax.swing.JComboBox<String>();
        txtTiempoEvaluacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnevaluar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        JPseleccionar = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbalumnos = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jpTiempo = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        btnJuego = new javax.swing.JButton();
        btnJuegoDetener = new javax.swing.JButton();
        jpTiempo1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        txtSeg = new javax.swing.JTextField();
        txtMils = new javax.swing.JTextField();
        btnGraficaEstadistica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Jpestudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel16.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel16.setText("Edad:");

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setText("Curso:");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel1.setText("Datos del Estudiante");

        jLabel17.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel17.setText("Ci:");

        txtnombre.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtnombre.setText("--------------");
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnombre.setMaximumSize(new java.awt.Dimension(75, 20));
        txtnombre.setMinimumSize(new java.awt.Dimension(75, 20));

        txtapellidos.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtapellidos.setText("--------------");
        txtapellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtapellidos.setMaximumSize(new java.awt.Dimension(75, 20));
        txtapellidos.setMinimumSize(new java.awt.Dimension(75, 20));

        txtci.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtci.setText("--------------");
        txtci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtci.setMaximumSize(new java.awt.Dimension(75, 20));
        txtci.setMinimumSize(new java.awt.Dimension(75, 20));

        txtcurso.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtcurso.setText("--------------");
        txtcurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcurso.setMaximumSize(new java.awt.Dimension(75, 20));
        txtcurso.setMinimumSize(new java.awt.Dimension(75, 20));

        txtedad.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        txtedad.setText("--------------");
        txtedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtedad.setMaximumSize(new java.awt.Dimension(75, 20));
        txtedad.setMinimumSize(new java.awt.Dimension(75, 20));

        jLabel27.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel27.setText("ID:");

        javax.swing.GroupLayout JpestudiantesLayout = new javax.swing.GroupLayout(Jpestudiantes);
        Jpestudiantes.setLayout(JpestudiantesLayout);
        JpestudiantesLayout.setHorizontalGroup(
            JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpestudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(JpestudiantesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpestudiantesLayout.createSequentialGroup()
                        .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jLabel27))
                        .addGap(52, 52, 52)
                        .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpestudiantesLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(54, 54, 54)))
                .addContainerGap())
        );
        JpestudiantesLayout.setVerticalGroup(
            JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpestudiantesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpestudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPevaluacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("TIEMPO DE EVALUACION:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("PLANEACION:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("COORDINACION:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("FUERZA MUSCULAR:");

        jLabel13.setText("SENSIBILIDAD NORMAL:");

        cmbsensibilidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECCIONES--", "BAJA", "MEDIA", "ALTA" }));

        cmbfuerzamuscular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECCIONES--", "BAJA", "MEDIA", "ALTA" }));

        cmbcoordinacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECCIONES--", "BAJA", "MEDIA", "ALTA" }));

        cmbplaneacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECCIONE--", "BAJA", "MEDIA", "ALTA" }));

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel5.setText("Diagnóstico de la Evaluación");

        javax.swing.GroupLayout JPevaluacionLayout = new javax.swing.GroupLayout(JPevaluacion);
        JPevaluacion.setLayout(JPevaluacionLayout);
        JPevaluacionLayout.setHorizontalGroup(
            JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPevaluacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPevaluacionLayout.createSequentialGroup()
                        .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbplaneacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbfuerzamuscular, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbsensibilidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbcoordinacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTiempoEvaluacion))
                        .addGap(40, 40, 40))
                    .addGroup(JPevaluacionLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        JPevaluacionLayout.setVerticalGroup(
            JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPevaluacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiempoEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbplaneacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbcoordinacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbfuerzamuscular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPevaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbsensibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_130-man-student-2_3099383.png"))); // NOI18N

        btnevaluar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnevaluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_document-03_1622833.png"))); // NOI18N
        btnevaluar.setText("<html>Seleccionar Estudiante a Evaluar</html>");
        btnevaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnevaluarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_floppy_285657.png"))); // NOI18N
        jButton2.setText("<html>Guardar Evaluacion</html> ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_132-woman-student-2_3099385.png"))); // NOI18N

        JPseleccionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        JPseleccionar.setPreferredSize(new java.awt.Dimension(428, 190));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_hand-o-up_1608921.png"))); // NOI18N

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
        tbalumnos.setPreferredSize(new java.awt.Dimension(448, 190));
        tbalumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbalumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbalumnos);

        jLabel26.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel26.setText("Seleccione el Estudiante Para Evaluar");

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

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Buscar:");

        javax.swing.GroupLayout JPseleccionarLayout = new javax.swing.GroupLayout(JPseleccionar);
        JPseleccionar.setLayout(JPseleccionarLayout);
        JPseleccionarLayout.setHorizontalGroup(
            JPseleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPseleccionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPseleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPseleccionarLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPseleccionarLayout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addGroup(JPseleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPseleccionarLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );
        JPseleccionarLayout.setVerticalGroup(
            JPseleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPseleccionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPseleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPseleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Jpestudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(JPseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPevaluacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnevaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addGap(98, 98, 98)
                .addComponent(jLabel23)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JPseleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(Jpestudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPevaluacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnevaluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setText("  EVALUACIÓN");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/iconfinder_498_student__notes__note_education_4212916.png"))); // NOI18N

        jpTiempo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("TIEMPO");

        lblTiempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/play.png"))); // NOI18N
        btnJuego.setText("INICIAR");
        btnJuego.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJuegoMouseClicked(evt);
            }
        });
        btnJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuegoActionPerformed(evt);
            }
        });

        btnJuegoDetener.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/play.png"))); // NOI18N
        btnJuegoDetener.setText("Detener");
        btnJuegoDetener.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnJuegoDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuegoDetenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTiempoLayout = new javax.swing.GroupLayout(jpTiempo);
        jpTiempo.setLayout(jpTiempoLayout);
        jpTiempoLayout.setHorizontalGroup(
            jpTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTiempoLayout.createSequentialGroup()
                .addGroup(jpTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTiempoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTiempoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTiempoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnJuegoDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jpTiempoLayout.setVerticalGroup(
            jpTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTiempoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJuegoDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpTiempo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setText("Ingresar tiempo");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Minutos:");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Segundos:");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Milisegundos:");

        btnGraficaEstadistica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/graph.png"))); // NOI18N
        btnGraficaEstadistica.setText("Graficar");
        btnGraficaEstadistica.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGraficaEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficaEstadisticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTiempo1Layout = new javax.swing.GroupLayout(jpTiempo1);
        jpTiempo1.setLayout(jpTiempo1Layout);
        jpTiempo1Layout.setHorizontalGroup(
            jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTiempo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpTiempo1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSeg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMils, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTiempo1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGraficaEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpTiempo1Layout.setVerticalGroup(
            jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTiempo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpTiempo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGraficaEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jpTiempo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpTiempo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnevaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnevaluarActionPerformed
/*         FrameSeleccionar c = new FrameSeleccionar();
        c.setVisible(true);*/
        JPseleccionar.setVisible(true);
        
        JPevaluacion.setVisible(false);
        
    }//GEN-LAST:event_btnevaluarActionPerformed

    private void btnGraficaEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficaEstadisticaActionPerformed

        int minutos, segundos, milisegundos;
        minutos = Integer.parseInt(txtMin.getText());
        segundos = Integer.parseInt(txtSeg.getText());
        milisegundos = Integer.parseInt(txtMils.getText());

        if (minutos < 1 && segundos < 30 && milisegundos <= 90) {
            try {
                DefaultCategoryDataset ds = new DefaultCategoryDataset();
                ds.addValue(20, "Alto", "Coordinacion");
                ds.addValue(20, "Alto", "Planeacion");
                ds.addValue(20, "Alto", "Fuerza");
                ds.addValue(20, "Alto", "Sensibiidad");

                JFreeChart jf = ChartFactory.createBarChart("Diagnostico", "Puntuación", "Parametro", ds, PlotOrientation.VERTICAL, true, true, true);

                ChartFrame f = new ChartFrame("Edades", jf);
                f.setSize(500, 300);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            } catch (Exception e) {
                System.out.println("ERROR" + e);
            }

        } else {
            try {
                DefaultCategoryDataset ds = new DefaultCategoryDataset();
                ds.addValue(15, "Baja", "Coordinacion");
                ds.addValue(20, "Media", "Planeacion");
                ds.addValue(15, "Baja", "Fuerza");
                ds.addValue(23, "Alta", "Sensibiidad");

                JFreeChart jf = ChartFactory.createBarChart("Diagnostico", "Parametro", "Puntuación", ds, PlotOrientation.VERTICAL, true, true, true);

                ChartFrame f = new ChartFrame("Edades", jf);
                f.setSize(500, 300);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            } catch (Exception e) {
                System.out.println("ERROR" + e);
            }
        }

        if (minutos == 2 && segundos == 30 && milisegundos == 30) {
            try {
                DefaultCategoryDataset ds = new DefaultCategoryDataset();
                ds.addValue(25, "Nico", "Coordinacion");
                ds.addValue(25, "pepe", "Planeacion");
                ds.addValue(25, "sergio", "Fuerza");
                ds.addValue(25, "MARTIN", "Sensibiidad");

                JFreeChart jf = ChartFactory.createBarChart("alumnos", "Nombres", "Edades", ds, PlotOrientation.VERTICAL, true, true, true);

                ChartFrame f = new ChartFrame("Edades", jf);
                f.setSize(500, 300);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            } catch (Exception e) {
                System.out.println("ERROR" + e);
            }

        }

    }//GEN-LAST:event_btnGraficaEstadisticaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Connection con = Conexion.conectar();
        //        txtCursoEstudiantes.setText(cmbCursos.getSelectedItem().toString());

        try {
            PreparedStatement ps = con.prepareStatement("insert into datosevaluacion (idevaluacion, tiempo, planeacion, coordinacion, fuerza_muscular, sensibilidad, idestudiante)  values (?,?,?,?,?,?,?)");
            ps.setString(1, "0");
            ps.setString(2, txtTiempoEvaluacion.getText());
            ps.setString(3, cmbplaneacion.getSelectedItem().toString());
            ps.setString(4, cmbcoordinacion.getSelectedItem().toString());
            ps.setString(5, cmbfuerzamuscular.getSelectedItem().toString());
            ps.setString(6, cmbsensibilidad.getSelectedItem().toString());
            ps.setString(7, txtid.getText());

            ps.executeUpdate();
            limpiar();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuegoActionPerformed
       try {
            ino.sendData("1");
         
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnJuegoActionPerformed

    private void btnJuegoDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuegoDetenerActionPerformed
        try {
            ino.sendData("0");
        } catch (Exception ex) {
            Logger.getLogger(FrameEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnJuegoDetenerActionPerformed

    private void btnJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJuegoMouseClicked
       
    }//GEN-LAST:event_btnJuegoMouseClicked

    private void tbalumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbalumnosMouseClicked
   /*JOptionPane.showMessageDialog(this, "hola mundo");
        int seleccion = tbalumnos.rowAtPoint(evt.getPoint());
        txtid.setText(String.valueOf(tbalumnos.getValueAt(seleccion, 0).toString()));
        txtnombre.setText(String.valueOf(tbalumnos.getValueAt(seleccion, 1).toString()));
        txtapellidos.setText(String.valueOf(tbalumnos.getValueAt(seleccion, 2).toString()));
        txtci.setText(String.valueOf(tbalumnos.getValueAt(seleccion, 3).toString()));
        txtedad.setText(String.valueOf(tbalumnos.getValueAt(seleccion, 4).toString()));
        txtcurso.setText(String.valueOf(tbalumnos.getValueAt(seleccion, 5).toString()));
     /************************************************************************************************/
     /* JPseleccionar.setVisible(false);*/
    }//GEN-LAST:event_tbalumnosMouseClicked

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
        FrameMenu menu = new FrameMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameEvaluacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPevaluacion;
    private javax.swing.JPanel JPseleccionar;
    private javax.swing.JPanel Jpestudiantes;
    private javax.swing.JButton btnGraficaEstadistica;
    private javax.swing.JButton btnJuego;
    private javax.swing.JButton btnJuegoDetener;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnevaluar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbcoordinacion;
    private javax.swing.JComboBox<String> cmbfuerzamuscular;
    private javax.swing.JComboBox<String> cmbplaneacion;
    private javax.swing.JComboBox<String> cmbsensibilidad;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpTiempo;
    private javax.swing.JPanel jpTiempo1;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JTable tbalumnos;
    private javax.swing.JTextField txtMils;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtSeg;
    private javax.swing.JTextField txtTiempoEvaluacion;
    private javax.swing.JLabel txtapellidos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JLabel txtci;
    private javax.swing.JLabel txtcurso;
    private javax.swing.JLabel txtedad;
    private javax.swing.JLabel txtid;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
