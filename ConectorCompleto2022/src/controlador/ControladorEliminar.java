package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmEliminar;

public class ControladorEliminar implements ActionListener, MouseListener, WindowListener {

    FrmEliminar vEl = new FrmEliminar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorEliminar(FrmEliminar vEl, PaisVO pvo, PaisDAO pdao) {
        this.vEl = vEl;
        this.pvo = pvo;
        this.pdao = pdao;
        vEl.btnCancelarE.addActionListener(this);
        vEl.btnEliminar.addActionListener(this);
        vEl.addWindowListener(this);
        vEl.tblEliminar.addMouseListener(this);
    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel() {
        //Metodo para evitar que las celdas se editen
        //Esta metodo lo acabo de investigar....
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        m.setColumnCount(0);
        m.addColumn("Id del País");
        m.addColumn("Nombre del País");
        m.addColumn("Capital del País");
        m.addColumn("Población del País");
        for (PaisVO pvo : pdao.consultar()) {
            m.addRow(new Object[]{pvo.getIdPais(), pvo.getNombrePais(), pvo.getCapitalPais(), pvo.getPoblacionPais()});
        }
        vEl.tblEliminar.setModel(m);
    }

    private void borrarInfo() {
        vEl.txtIDE.setText("");
        vEl.txtNombrePaisE.setText("");
        vEl.txtCapitalE.setText("");
        vEl.txtPoblacionE.setText("");
    }

    private void llenarCampos() {
        int numero = 0;
        while (numero < 4) {
            switch (numero) {
                case 0:
                    this.vEl.txtIDE.setText(String.valueOf(this.vEl.tblEliminar.getValueAt(this.vEl.tblEliminar.getSelectedRow(), numero)));
                    break;
                case 1:
                    this.vEl.txtNombrePaisE.setText(String.valueOf(this.vEl.tblEliminar.getValueAt(this.vEl.tblEliminar.getSelectedRow(), numero)));
                    break;
                case 2:
                    this.vEl.txtCapitalE.setText(String.valueOf(this.vEl.tblEliminar.getValueAt(this.vEl.tblEliminar.getSelectedRow(), numero)));
                    break;
                case 3:
                    this.vEl.txtPoblacionE.setText(String.valueOf(this.vEl.tblEliminar.getValueAt(this.vEl.tblEliminar.getSelectedRow(), numero)));
                    break;
                default:
                    System.out.println("Holi");
            }
            numero++;
        }
    }

    private void eliminarRegistro() {
        this.pvo.setIdPais(Integer.parseInt(this.vEl.txtIDE.getText()));
        if (pdao.eliminar(pvo) == true) {
            vEl.jopMensaje.showMessageDialog(vEl, "Datos eliminados correctamente");
            borrarInfo();
        } else {
            vEl.jopMensaje.showMessageDialog(vEl, "Error, datos no eliminados");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vEl.btnCancelarE) {
            borrarInfo();
            vEl.dispose();
        }
        if (ae.getSource() == vEl.btnEliminar) {
            if (!this.vEl.txtIDE.getText().equals("")) {
                eliminarRegistro();
            } else {
                vEl.jopMensaje.showMessageDialog(vEl, "No ha seleccionado un registro a eliminar");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getClickCount() == 2) {
            llenarCampos();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.vEl.setSize(650, 600);
        mostrar();
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {
        borrarInfo();
    }

    @Override
    public void windowIconified(WindowEvent we) {

    }

    @Override
    public void windowDeiconified(WindowEvent we) {

    }

    @Override
    public void windowActivated(WindowEvent we) {
        mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }

}
