package Vista;

import Controlador.PersonasController;
import Modelo.Datos_Cargados;
import Modelo.Docente;
import Modelo.MiRenderer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Hitler
 */
public class DocentesView extends javax.swing.JPanel {
    
    ArrayList<Docente> docentes;
    DefaultTableModel modelo;
    PersonasController pc = new PersonasController();
    Datos_Cargados DC = new Datos_Cargados();
    
    public DocentesView() {
        initComponents();
        modelo = (DefaultTableModel) DocentesTable.getModel();
        CargarAlumnos();
    }
    
    private void CargarAlumnos() {
        pc.CargarAlumnos();
        docentes = DC.getDocentes_guardadas();
        if (docentes != null) {
            DataTable();
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros para mostrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void DataTable() {
        modelo.setRowCount(0);
        for (Docente docente : docentes) {
            Object[] fila = {
                docente.getNumero_plaza(),
                docente.getNombre() + " " + docente.getApellido_p() + " " + docente.getApellido_m(),
                docente.getInstitucion(),
                docente.getCorreo()
            };
            modelo.addRow(fila);
        }
        DocentesTable.setModel(modelo);
        setCellRender(DocentesTable);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        DocentesTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Plaza = new javax.swing.JTextField();
        cargando = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 108, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Docentes");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel1.setOpaque(true);

        DocentesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Plaza", "Nombre", "Institucion", "Correo"
            }
        ));
        jScrollPane1.setViewportView(DocentesTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("N° Plaza:");

        Plaza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Plaza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PlazaKeyReleased(evt);
            }
        });

        cargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cargando.gif"))); // NOI18N

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
                            .addComponent(jLabel2)
                            .addComponent(Plaza, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cargando)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                        .addComponent(Plaza, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cargando))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PlazaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlazaKeyReleased
        System.out.println("entrando");
        if (!Plaza.getText().isEmpty()) {
            cargando.setVisible(true);
            if (contieneSoloNumeros(Plaza.getText().trim())) {
                FiltroTabla(Plaza.getText(), 2);
            } else {
                FiltroTabla(Plaza.getText(), 1);
            }
        } else {
            DataTable();
        }
    }//GEN-LAST:event_PlazaKeyReleased
    
    public boolean contieneSoloNumeros(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public boolean contieneNumero(int numeroOriginal, int numeroObjetivo) {
        String numOriginalStr = String.valueOf(numeroOriginal);
        String numObjetivoStr = String.valueOf(numeroObjetivo);
        
        return numOriginalStr.contains(numObjetivoStr);
    }
    
    private void FiltroTabla(String busqueda, int opcion) {
        boolean Status = false;
        
        modelo.setRowCount(0);
        
        switch (opcion) {
            case 1:
                for (Docente docente : docentes) {
                    if (docente.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                        Object[] fila = {
                            docente.getNumero_plaza(),
                            docente.getNombre() + " " + docente.getApellido_p() + " " + docente.getApellido_m(),
                            docente.getInstitucion(),
                            docente.getCorreo()
                        };
                        modelo.addRow(fila);
                        Status = true;
                        System.out.println("Existe");
                    }
                }
                break;
            case 2:
                for (Docente docente : docentes) {
                    if (contieneNumero(docente.getNumero_plaza(), Integer.parseInt(busqueda.trim()))) {
                        Object[] fila = {
                            docente.getNumero_plaza(),
                            docente.getNombre() + " " + docente.getApellido_p() + " " + docente.getApellido_m(),
                            docente.getInstitucion(),
                            docente.getCorreo()
                        };
                        modelo.addRow(fila);
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
        DocentesTable.setModel(modelo);
        setCellRender(DocentesTable);
        cargando.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DocentesTable;
    private javax.swing.JTextField Plaza;
    private javax.swing.JLabel cargando;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
