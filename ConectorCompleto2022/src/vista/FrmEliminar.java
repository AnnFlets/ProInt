/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ana
 */
public class FrmEliminar extends javax.swing.JFrame {

    /**
     * Creates new form FrmEliminar
     */
    public FrmEliminar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jopMensaje = new javax.swing.JOptionPane();
        lblID = new javax.swing.JLabel();
        lblCapital = new javax.swing.JLabel();
        lblPoblacion = new javax.swing.JLabel();
        txtIDE = new javax.swing.JTextField();
        txtNombrePaisE = new javax.swing.JTextField();
        txtCapitalE = new javax.swing.JTextField();
        txtPoblacionE = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnCancelarE = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTituloEliminar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel dtm = new DefaultTableModel();
        tblEliminar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(102, 102, 102));
        lblID.setText("ID PAÍS");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        lblCapital.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCapital.setForeground(new java.awt.Color(102, 102, 102));
        lblCapital.setText("CAPITAL");
        getContentPane().add(lblCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        lblPoblacion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPoblacion.setForeground(new java.awt.Color(102, 102, 102));
        lblPoblacion.setText("POBLACIÓN");
        getContentPane().add(lblPoblacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));
        getContentPane().add(txtIDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, -1));

        txtNombrePaisE.setEditable(false);
        txtNombrePaisE.setBackground(new java.awt.Color(102, 102, 102));
        txtNombrePaisE.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtNombrePaisE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 160, -1));

        txtCapitalE.setEditable(false);
        txtCapitalE.setBackground(new java.awt.Color(102, 102, 102));
        txtCapitalE.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtCapitalE, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 160, -1));

        txtPoblacionE.setEditable(false);
        txtPoblacionE.setBackground(new java.awt.Color(102, 102, 102));
        txtPoblacionE.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtPoblacionE, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 160, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 102));
        btnEliminar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(102, 102, 0));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 110, 50));

        btnCancelarE.setBackground(new java.awt.Color(255, 255, 102));
        btnCancelarE.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnCancelarE.setForeground(new java.awt.Color(102, 102, 0));
        btnCancelarE.setText("CANCELAR");
        btnCancelarE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnCancelarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 120, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloEliminar.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTituloEliminar.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloEliminar.setText("ELIMINAR PAÍS");
        jPanel1.add(lblTituloEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInfo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(51, 51, 51));
        lblInfo.setText("Registro a eliminar:");
        jPanel2.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        lblPais.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPais.setForeground(new java.awt.Color(102, 102, 102));
        lblPais.setText("NOMBRE PAÍS");
        jPanel2.add(lblPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 100, -1));

        lblDescripcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(51, 51, 51));
        lblDescripcion.setText("De doble clic en el registro para seleccionarlo");
        jPanel2.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        tblEliminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEliminar);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 610, 240));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 650, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelarE;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JOptionPane jopMensaje;
    private javax.swing.JLabel lblCapital;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPoblacion;
    private javax.swing.JLabel lblTituloEliminar;
    public javax.swing.JTable tblEliminar;
    public javax.swing.JTextField txtCapitalE;
    public javax.swing.JTextField txtIDE;
    public javax.swing.JTextField txtNombrePaisE;
    public javax.swing.JTextField txtPoblacionE;
    // End of variables declaration//GEN-END:variables
}