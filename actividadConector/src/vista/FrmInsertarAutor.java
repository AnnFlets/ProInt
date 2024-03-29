package vista;

public class FrmInsertarAutor extends javax.swing.JFrame {

    /**
     * Creates new form FrmInsertarAutor
     */
    public FrmInsertarAutor() {
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

        jopInsertarAutor = new javax.swing.JOptionPane();
        lblTituloInsertarA = new javax.swing.JLabel();
        lblNombreA = new javax.swing.JLabel();
        lblPaisA = new javax.swing.JLabel();
        lblEdadA = new javax.swing.JLabel();
        txtNombreIA = new javax.swing.JTextField();
        txtPaisIA = new javax.swing.JTextField();
        txtEdadIA = new javax.swing.JTextField();
        btnRegistrarA = new javax.swing.JButton();
        btnCancelarIA = new javax.swing.JButton();
        lblTextoIns = new javax.swing.JLabel();
        lblFechaInsA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar autores");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloInsertarA.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        lblTituloInsertarA.setText("REGISTRO DE AUTORES");
        getContentPane().add(lblTituloInsertarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblNombreA.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblNombreA.setText("Nombre del autor:");
        getContentPane().add(lblNombreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        lblPaisA.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPaisA.setText("País de origen del autor:");
        getContentPane().add(lblPaisA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        lblEdadA.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblEdadA.setText("Edad del autor:");
        getContentPane().add(lblEdadA, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));
        getContentPane().add(txtNombreIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 260, -1));
        getContentPane().add(txtPaisIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 260, -1));

        txtEdadIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadIAActionPerformed(evt);
            }
        });
        getContentPane().add(txtEdadIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 260, -1));

        btnRegistrarA.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnRegistrarA.setText("REGISTRAR");
        getContentPane().add(btnRegistrarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 130, 60));

        btnCancelarIA.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnCancelarIA.setText("CANCELAR");
        getContentPane().add(btnCancelarIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 130, 60));

        lblTextoIns.setText("* Fecha de Inserción:");
        getContentPane().add(lblTextoIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));
        getContentPane().add(lblFechaInsA, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 140, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEdadIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadIAActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInsertarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInsertarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInsertarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInsertarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInsertarAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelarIA;
    public javax.swing.JButton btnRegistrarA;
    public javax.swing.JOptionPane jopInsertarAutor;
    private javax.swing.JLabel lblEdadA;
    public javax.swing.JLabel lblFechaInsA;
    private javax.swing.JLabel lblNombreA;
    private javax.swing.JLabel lblPaisA;
    private javax.swing.JLabel lblTextoIns;
    private javax.swing.JLabel lblTituloInsertarA;
    public javax.swing.JTextField txtEdadIA;
    public javax.swing.JTextField txtNombreIA;
    public javax.swing.JTextField txtPaisIA;
    // End of variables declaration//GEN-END:variables
}
