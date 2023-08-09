package Vista;

import Modelo.Alumno;
import Modelo.DateRender;
import Modelo.Datos_Cargados;
import Modelo.Docente;
import Modelo.Ipads;
import Modelo.Macs;
import Modelo.MiRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author Hitler
 */
public class RegistrosView extends javax.swing.JPanel {

    String[] status = {"En uso", "Entregado"};
    //boolean[] statusRegistro = {false, false, false, false, false, false, false, false, false};
    Datos_Cargados DC = new Datos_Cargados();
    ArrayList<Docente> docentes;
    ArrayList<Alumno> alumnos;
    DefaultTableModel modelo;
    TableColumn tc;
    TableCellEditor tce;

    public RegistrosView() {
        initComponents();
        DeleteRow.setEnabled(false);
        Cargando.setVisible(false);
        modelo = (DefaultTableModel) Registro.getModel();
        CargarPersonas();
        CargarMacs();
        CargarIpads();
        CargarDefault();
        Status();
        timePicker1.addActionListener((ActionEvent e) -> {
            if (e.getActionCommand().equals("OK")) {
                modelo.setValueAt(timePicker1.getSelectedTime(), Registro.getSelectedRow(), Registro.getSelectedColumn());
                ValidarHora();
            }
        });
    }

    public void ValidarHora() {
        int fila = Registro.getSelectedRow();
        if (fila != -1) {
            String horaEntradaStr = (String) Registro.getValueAt(fila, 7);
            String horaSalidaStr = (String) Registro.getValueAt(fila, 8);
            if (horaEntradaStr != null && horaSalidaStr != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
                try {
                    LocalTime horaEntrada = LocalTime.parse(horaEntradaStr, formatter);
                    LocalTime horaSalida = LocalTime.parse(horaSalidaStr, formatter);
                    if (horaEntrada.isAfter(horaSalida)) {
                        JOptionPane.showMessageDialog(this, "La hora de salida debe ser posterior a la de entrada", "Aviso", JOptionPane.WARNING_MESSAGE);
                        modelo.setValueAt("", Registro.getSelectedRow(), Registro.getSelectedColumn());
                    }
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(this, "Formato de hora incorrecto " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void CargarDefault() {
        tc = Registro.getColumnModel().getColumn(6);
        tc.setCellEditor(new DateRender());
        Cargadores();
        setCellRender(Registro);
    }

    private void Default(String[] x, int[] column) {
        for (int i = 0; i < column.length; i++) {
            final int currentIndex = i; // Copia final de 'i'
            JComboBox jcbm = new JComboBox(x);
            ((JLabel) jcbm.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

            jcbm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String opcionSeleccionada = (String) jcbm.getSelectedItem();
                    if (opcionSeleccionada != null) {
                        System.out.println("JComboBox en columna " + column[currentIndex] + " seleccionado: " + opcionSeleccionada);
                    }
                }
            });

            tc = Registro.getColumnModel().getColumn(column[i]);
            tce = new DefaultCellEditor(jcbm);
            tc.setCellEditor(tce);
        }
    }

    private void Status() {
        int[] column = {9, 10};
        Default(status, column);
    }

    private void ValidarRegistro() {

    }

    private void Cargadores() {
        int[] column = {4, 5};

        JCheckBox check = new JCheckBox();
        for (int i = 0; i < column.length; i++) {
            tc = Registro.getColumnModel().getColumn(column[i]);
            tce = new DefaultCellEditor(check);
            tc.setCellEditor(tce);
        }
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();
                boolean selected = source.isSelected();
                System.out.println("Estado del checkbox: " + selected);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        timePicker2 = new com.raven.swing.TimePicker();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Registro = new javax.swing.JTable();
        Docentes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Alumnos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Cargando = new javax.swing.JLabel();
        DeleteRow = new javax.swing.JButton();

        timePicker1.setForeground(new java.awt.Color(255, 108, 0));
        timePicker1.setEnabled(false);

        timePicker2.setForeground(new java.awt.Color(255, 108, 0));

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 108, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Registro de prestaciones");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel1.setOpaque(true);

        Registro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Matricula/Plaza", "Mac", "Ipad", "Cargador Mac", "Cargador Ipad", "Fecha", "Hora entrada", "Hora salida", "Status Mac", "Status Ipad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Registro.setCellSelectionEnabled(true);
        Registro.setRowHeight(22);
        Registro.setRowMargin(0);
        Registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistroMouseClicked(evt);
            }
        });
        Registro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                RegistroPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(Registro);
        if (Registro.getColumnModel().getColumnCount() > 0) {
            Registro.getColumnModel().getColumn(0).setPreferredWidth(150);
            Registro.getColumnModel().getColumn(1).setResizable(false);
            Registro.getColumnModel().getColumn(2).setPreferredWidth(30);
            Registro.getColumnModel().getColumn(3).setPreferredWidth(30);
            Registro.getColumnModel().getColumn(4).setPreferredWidth(60);
            Registro.getColumnModel().getColumn(5).setPreferredWidth(60);
            Registro.getColumnModel().getColumn(6).setPreferredWidth(100);
            Registro.getColumnModel().getColumn(7).setPreferredWidth(50);
            Registro.getColumnModel().getColumn(8).setPreferredWidth(50);
            Registro.getColumnModel().getColumn(9).setPreferredWidth(50);
            Registro.getColumnModel().getColumn(10).setPreferredWidth(50);
        }

        Docentes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Docentes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DocentesItemStateChanged(evt);
            }
        });
        Docentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocentesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Docente:");

        Alumnos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Alumnos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AlumnosItemStateChanged(evt);
            }
        });
        Alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlumnosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Alumno:");

        Buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("N° Plaza/Matricula:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Cargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cargando.gif"))); // NOI18N

        DeleteRow.setText("Eliminar fila");
        DeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Docentes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Buscar)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(Cargando))
                            .addComponent(DeleteRow))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Docentes)
                            .addComponent(Alumnos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Buscar)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Cargando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeleteRow)
                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocentesActionPerformed

    }//GEN-LAST:event_DocentesActionPerformed

    private void DocentesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DocentesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedName = (String) Docentes.getSelectedItem();
            if (!selectedName.equals("Selecciona una opcion")) {
                modelo.addRow(new Object[]{""});
                int count = Registro.getRowCount() - 1;
                if (Repetido(selectedName)) {
                    String selectedID = buscarID(docentes, null, selectedName, 1);

                    modelo.setValueAt(selectedName, count, 0);
                    modelo.setValueAt(selectedID, count, 1);
                } else {
                    modelo.removeRow(count);
                }
            }
            Docentes.setSelectedIndex(0);
        }
    }//GEN-LAST:event_DocentesItemStateChanged

    private void AlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlumnosActionPerformed

    private void AlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AlumnosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedName = (String) Alumnos.getSelectedItem();
            if (!selectedName.equals("Selecciona una opcion")) {
                modelo.addRow(new Object[]{""});
                int count = Registro.getRowCount() - 1;
                if (Repetido(selectedName)) {
                    String selectedID = buscarID(null, alumnos, selectedName, 2);

                    modelo.setValueAt(selectedName, count, 0);
                    modelo.setValueAt(selectedID, count, 1);
                } else {
                    modelo.removeRow(count);
                }
            }
            Alumnos.setSelectedIndex(0);
        }
    }//GEN-LAST:event_AlumnosItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!Buscar.getText().isEmpty()) {
            String nombre;
            Cargando.setVisible(true);
            try {
                int number = Integer.parseInt(Buscar.getText());
                nombre = buscarNombre(docentes, null, String.valueOf(number), 1);
                AgregarFila(nombre, String.valueOf(number));
            } catch (Exception e) {
                String matricula = Buscar.getText().toUpperCase();
                nombre = buscarNombre(null, alumnos, matricula, 2);
                AgregarFila(nombre, matricula);
            }
            Cargando.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroMouseClicked
        if (Registro.getSelectedRow() != -1) {
            DeleteRow.setEnabled(true);
            if (Registro.getSelectedColumn() == 7 || Registro.getSelectedColumn() == 8) {
                timePicker1.showPopup(this, 100, 100);
            }
        }
    }//GEN-LAST:event_RegistroMouseClicked

    private void DeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRowActionPerformed
        if (Registro.getSelectedRow() != -1) {
            modelo.removeRow(Registro.getSelectedRow());
            DeleteRow.setEnabled(false);
        }
    }//GEN-LAST:event_DeleteRowActionPerformed

    private void RegistroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_RegistroPropertyChange

    }//GEN-LAST:event_RegistroPropertyChange

    private void AgregarFila(String nombre, String id) {
        if (Repetido(nombre)) {
            if (!nombre.equals("Vacio")) {
                modelo.addRow(new Object[]{""});
                int count = Registro.getRowCount() - 1;
                modelo.setValueAt(nombre, count, 0);
                modelo.setValueAt(id, count, 1);
            } else {
                JOptionPane.showMessageDialog(this, "No hay registro alguno", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void CargarMacs() {
        ArrayList<Macs> macs = DC.getMacs_guardadas();
        String[] lista = new String[macs.size()];
        int i = 0;
        for (Macs mac : macs) {
            lista[i] = mac.getNumero();
            i++;
        }
        int[] x = {2};
        Default(lista, x);
    }

    private void CargarIpads() {
        ArrayList<Ipads> ipads = DC.getIpads_guardadas();
        String[] lista = new String[ipads.size()];
        int i = 0;
        for (Ipads ipad : ipads) {
            lista[i] = ipad.getNumero();
            i++;
        }
        int[] x = {3};
        Default(lista, x);
    }

    private void CargarPersonas() {
        docentes = DC.getDocentes_guardadas();
        alumnos = DC.getAlumnos_guardadas();
        if (docentes != null) {
            Docentes.addItem("Selecciona una opcion");
            docentes.forEach((docente) -> {
                Docentes.addItem(docente.getNombre() + " " + docente.getApellido_p() + " " + docente.getApellido_m());
            });
        } else {
            Docentes.setEnabled(false);
        }
        if (docentes != null) {
            Alumnos.addItem("Selecciona una opcion");
            alumnos.forEach((alumno) -> {
                Alumnos.addItem(alumno.getNombre() + " " + alumno.getApellido_p() + " " + alumno.getApellido_m());
            });
        } else {
            Alumnos.setEnabled(false);
        }
    }

    private boolean Repetido(String name) {
        for (int i = 0; i < Registro.getRowCount(); i++) {
            String nombretable = (Registro.getValueAt(i, 0) != null) ? Registro.getValueAt(i, 0).toString() : "";
            if (nombretable.equals(name)) {
                JOptionPane.showMessageDialog(this, "El nombre seleccionado ya tiene un registro", "Aviso", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private String buscarNombre(ArrayList<Docente> docentes, ArrayList<Alumno> alumnos, String id, int opcion) {
        switch (opcion) {
            case 1:
                for (Docente persona : docentes) {
                    if (persona.getNumero_plaza() == Integer.parseInt(id)) {
                        return persona.getNombre() + " " + persona.getApellido_p() + " " + persona.getApellido_m();
                    }
                }
                break;
            case 2:
                for (Alumno persona : alumnos) {
                    if (persona.getMatricula().equals(id)) {
                        return persona.getNombre() + " " + persona.getApellido_p() + " " + persona.getApellido_m();
                    }
                }
                break;
        }
        return "Vacio";
    }

    private String buscarID(ArrayList<Docente> docentes, ArrayList<Alumno> alumnos, String nombre, int opcion) {
        switch (opcion) {
            case 1:
                for (Docente persona : docentes) {
                    String nombre_completo = persona.getNombre() + " " + persona.getApellido_p() + " " + persona.getApellido_m();
                    if (nombre_completo.toLowerCase().equals(nombre.toLowerCase())) {
                        return persona.getNumero_plaza().toString();
                    }
                }
                break;
            case 2:
                for (Alumno persona : alumnos) {
                    String nombre_completo = persona.getNombre() + " " + persona.getApellido_p() + " " + persona.getApellido_m();
                    if (nombre_completo.toLowerCase().equals(nombre.toLowerCase())) {
                        return persona.getMatricula();
                    }
                }
                break;
        }
        return "Vacio";
    }

    public void setCellRender(JTable table) {

        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new MiRenderer());
        }
        table.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Alumnos;
    private javax.swing.JTextField Buscar;
    private javax.swing.JLabel Cargando;
    private javax.swing.JButton DeleteRow;
    private javax.swing.JComboBox<String> Docentes;
    private javax.swing.JTable Registro;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.TimePicker timePicker1;
    private com.raven.swing.TimePicker timePicker2;
    // End of variables declaration//GEN-END:variables
}
