/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.dao.PersonaDao;
import javax.swing.JOptionPane;
import vistas.Tabla.ModeloTablaPersona;
import vistas.Utilidades.Utilidades;

/**
 *
 * @author DEEPIN
 */
public class FrmPersona extends javax.swing.JDialog {

    private PersonaDao personaDao = new PersonaDao();
    private ModeloTablaPersona mtp = new ModeloTablaPersona();
    
    /**
     * Creates new form FrmPersona
     */
    public FrmPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCombos();
        limpiar();
        setLocationRelativeTo(this);
    }
    
    private void cargarTabla(){
        mtp.setLista(personaDao.listar());
        jTable1.setModel(mtp);
        jTable1.updateUI();
    }

    private void cargarCombos() {
        Utilidades.cargarTipoIndentificacion(cbxidentificacion);
    }
    
    private void limpiar (){
        cargarCombos();
        cargarTabla();
        txtApellidos.setText("");
        txtcedula.setText("");
        txtcorreo.setText("");
        txtdireccion.setText("");
        txtNombres.setText("");
        personaDao.setPersona(null);
    }

    private void guardar() {
        if (txtcedula.getText().isEmpty() || txtApellidos.getText().isEmpty()
                || txtcorreo.getText().isEmpty() || txtdireccion.getText().isEmpty()
                || txtNombres.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Boolean verificar = false;
            if (cbxidentificacion.getSelectedItem().toString().equalsIgnoreCase("PASAPORTE")) {
                verificar = true;
            } else if (!(cbxidentificacion.getSelectedItem().toString().equalsIgnoreCase("PASAPORTE")) &&
                    controlador.utiles.Utilidades.validadorDeCedula(txtcedula.getText())) {
                verificar = true;
            } else {
                verificar = false;
                JOptionPane.showMessageDialog(null, "Cedula no valida", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (verificar) {
                //save
                personaDao.getPersona().setApellido(txtApellidos.getText());
                personaDao.getPersona().setNombre(txtNombres.getText());
                personaDao.getPersona().setCorreo(txtcorreo.getText());
                personaDao.getPersona().setDireccion(txtdireccion.getText());
                personaDao.getPersona().setId_rol(4);
                personaDao.getPersona().setIndetifiacion(txtcedula.getText());
                personaDao.getPersona().setTipoIdentificacion(Utilidades.obtenerTipoIdentificacion(cbxidentificacion));
                try {
                    if(personaDao.guardar()) {
                        limpiar();
                       JOptionPane.showMessageDialog(null, "Se ha registraso", "Exito", JOptionPane.INFORMATION_MESSAGE); 
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error desconocido", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxidentificacion = new javax.swing.JComboBox<>();
        txtcedula = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador Persona");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos"));
        jPanel1.setLayout(null);

        jLabel1.setText("Tipo Identificacion:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 40, 120, 17);

        jLabel2.setText("Identificacion:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(400, 40, 90, 17);

        jLabel3.setText("Apellidos:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 90, 70, 17);

        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 90, 50, 17);

        jLabel5.setText("Correo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 140, 40, 17);

        jLabel6.setText("Direccion:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(400, 140, 70, 17);

        cbxidentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxidentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxidentificacionActionPerformed(evt);
            }
        });
        jPanel1.add(cbxidentificacion);
        cbxidentificacion.setBounds(180, 40, 140, 23);
        jPanel1.add(txtcedula);
        txtcedula.setBounds(500, 40, 150, 23);
        jPanel1.add(txtNombres);
        txtNombres.setBounds(500, 90, 150, 23);
        jPanel1.add(txtdireccion);
        txtdireccion.setBounds(500, 140, 150, 23);
        jPanel1.add(txtcorreo);
        txtcorreo.setBounds(180, 140, 140, 23);
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(180, 90, 140, 23);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(320, 180, 75, 23);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Listado"));
        jPanel2.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 680, 190);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxidentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxidentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxidentificacionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPersona dialog = new FrmPersona(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxidentificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    // End of variables declaration//GEN-END:variables
}