package vista;

import javax.swing.table.DefaultTableModel;

public class FrmMostrarLibro extends javax.swing.JFrame {

    /**
     * Creates new form FrmMostrarLibro
     */
    public FrmMostrarLibro() {
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

        lblTituloMA = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel dtmL = new DefaultTableModel();
        tblMostrarL = new javax.swing.JTable();
        btnCancelarML = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar libros");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloMA.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        lblTituloMA.setText("LIBROS REGISTRADOS");
        getContentPane().add(lblTituloMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tblMostrarL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblMostrarL);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 730, 380));

        btnCancelarML.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnCancelarML.setText("CANCELAR");
        getContentPane().add(btnCancelarML, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 130, 60));

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
            java.util.logging.Logger.getLogger(FrmMostrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMostrarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelarML;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloMA;
    public javax.swing.JTable tblMostrarL;
    // End of variables declaration//GEN-END:variables
}
