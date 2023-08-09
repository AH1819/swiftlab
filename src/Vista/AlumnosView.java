package Vista;

import Controlador.PersonasController;
import Modelo.Alumno;
import Modelo.Datos_Cargados;
import Modelo.MiRenderer;
import static Vista.Menu.Contenedor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Hitler
 */
public class AlumnosView extends javax.swing.JPanel {

    ArrayList<Alumno> alumnos;
    Alumno alumnoSelected;
    DefaultTableModel modelo;
    PersonasController pc = new PersonasController();
    Datos_Cargados DC = new Datos_Cargados();

    public AlumnosView() {
        initComponents();
        modelo = (DefaultTableModel) AlumnosTable.getModel();
        CargarAlumnos();
    }

    public void CargarAlumnos() {
        System.out.println("Cargando");
        pc.CargarAlumnos();
        alumnos = DC.getAlumnos_guardadas();
        if (alumnos != null) {
            DataTable();
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros para mostrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void DataTable() {
        modelo.setRowCount(0);
        for (Alumno alumno : alumnos) {
            Object[] fila = {
                alumno.getMatricula(),
                alumno.getNombre() + " " + alumno.getApellido_p() + " " + alumno.getApellido_m(),
                alumno.getProcedencia(),
                alumno.getSemestre(),
                alumno.getGrupo()
            };
            modelo.addRow(fila);
        }
        AlumnosTable.setModel(modelo);
        setCellRender(AlumnosTable);
        cargando.setVisible(false);
    }

    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new MiRenderer());
        }
        table.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Matricula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlumnosTable = new javax.swing.JTable();
        cargando = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 108, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Alumnos");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("N° Matricula:");

        Matricula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Matricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MatriculaKeyReleased(evt);
            }
        });

        AlumnosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nombre", "Procedencia", "Semestre", "Grupo"
            }
        ));
        AlumnosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        AlumnosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AlumnosTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(AlumnosTable);

        cargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cargando.gif"))); // NOI18N

        Agregar.setBackground(new java.awt.Color(255, 108, 0));
        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar.png"))); // NOI18N
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(255, 108, 0));
        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar.png"))); // NOI18N
        Actualizar.setText("Modificar");
        Actualizar.setEnabled(false);
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cargando)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(Agregar)
                .addGap(56, 56, 56)
                .addComponent(Actualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cargando))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar)
                    .addComponent(Actualizar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MatriculaKeyReleased
        if (!Matricula.getText().isEmpty()) {
            cargando.setVisible(true);
            if (Matricula.getText().matches(".*\\d.*")) {
                FiltroTabla(Matricula.getText(), 2);
            } else {
                FiltroTabla(Matricula.getText(), 1);
            }
        } else {
            DataTable();
        }
    }//GEN-LAST:event_MatriculaKeyReleased

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        Alumno_new_or_update anp = new Alumno_new_or_update(" Registro", this, null, this);
        Paneles(anp);
    }//GEN-LAST:event_AgregarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        Alumno_new_or_update anp = new Alumno_new_or_update(" Actualizacion", this, alumnoSelected, this);
        Paneles(anp);
    }//GEN-LAST:event_ActualizarActionPerformed

    private void AlumnosTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlumnosTableMousePressed
        if (AlumnosTable.getSelectedRow() != -1) {
            for (Alumno alumno : alumnos) {
                if (alumno.getMatricula().equals(AlumnosTable.getValueAt(AlumnosTable.getSelectedRow(), 0))) {
                    alumnoSelected = alumno;
                    Actualizar.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_AlumnosTableMousePressed

    public void Paneles(Component h) {
        h.setLocation(0, 0);
        Contenedor.removeAll();
        Contenedor.add(h, BorderLayout.CENTER);
        Contenedor.revalidate();
        Contenedor.repaint();
    }

    private void FiltroTabla(String busqueda, int opcion) {
        boolean Status = false;

        modelo.setRowCount(0);

        switch (opcion) {
            case 1:
                for (Alumno alumno : alumnos) {
                    if (alumno.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                        Object[] arr = {
                            alumno.getMatricula(),
                            alumno.getNombre() + " " + alumno.getApellido_p() + " " + alumno.getApellido_m(),
                            alumno.getProcedencia(),
                            alumno.getSemestre(),
                            alumno.getGrupo()
                        };
                        modelo.addRow(arr);
                        Status = true;
                        System.out.println("Existe");
                    }
                }
                break;
            case 2:
                for (Alumno alumno : alumnos) {
                    if (alumno.getMatricula().toLowerCase().contains(busqueda)) {
                        Object[] arr = {
                            alumno.getMatricula(),
                            alumno.getNombre() + " " + alumno.getApellido_p() + " " + alumno.getApellido_m(),
                            alumno.getProcedencia(),
                            alumno.getSemestre(),
                            alumno.getGrupo()
                        };
                        modelo.addRow(arr);
                        Status = true;
                        System.out.println("Existe");
                    }
                }
                break;
        }

        if (!Status) {
            DataTable();
            System.out.println("No Existe");
            return;
        }
        AlumnosTable.setModel(modelo);
        setCellRender(AlumnosTable);
        cargando.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Agregar;
    private javax.swing.JTable AlumnosTable;
    private javax.swing.JTextField Matricula;
    private javax.swing.JLabel cargando;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
