package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.Extras;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;

public class ControladorActualizar implements ActionListener, MouseListener, WindowListener {

    FrmActualizar vAc = new FrmActualizar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorActualizar(FrmActualizar vAc, PaisVO pvo, PaisDAO pdao) {
        this.vAc = vAc;
        this.pvo = pvo;
        this.pdao = pdao;
        vAc.btnActualizar.addActionListener(this);
        vAc.btnCancelar.addActionListener(this);
        vAc.tblActualizar.addMouseListener(this);
        vAc.addWindowListener(this);
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
        vAc.tblActualizar.setModel(m);
    }

    private void borrarInfo() {
        vAc.txtIDA.setText("");
        vAc.txtNombrePaisA.setText("");
        vAc.txtCapitalA.setText("");
        vAc.txtPoblacionA.setText("");
    }

    private void actualizarRegistro() {
        this.pvo.setIdPais(Integer.parseInt(this.vAc.txtIDA.getText()));
        this.pvo.setNombrePais(this.vAc.txtNombrePaisA.getText());
        this.pvo.setCapitalPais(this.vAc.txtCapitalA.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vAc.txtPoblacionA.getText()));
        this.pvo.setFechaActPais(Extras.fechaHoy());
        if (pdao.actualizar(pvo) == true) {
            vAc.jopMensaje.showMessageDialog(vAc, "Datos actualizados correctamente");
            borrarInfo();
        } else {
            vAc.jopMensaje.showMessageDialog(vAc, "Error, datos no actualizados");
        }
    }

    private void llenarCampos() {
        int numero = 0;
        while (numero < 4) {
            switch (numero) {
                case 0:
                    this.vAc.txtIDA.setText(String.valueOf(this.vAc.tblActualizar.getValueAt(this.vAc.tblActualizar.getSelectedRow(), numero)));
                    break;
                case 1:
                    this.vAc.txtNombrePaisA.setText(String.valueOf(this.vAc.tblActualizar.getValueAt(this.vAc.tblActualizar.getSelectedRow(), numero)));
                    break;
                case 2:
                    this.vAc.txtCapitalA.setText(String.valueOf(this.vAc.tblActualizar.getValueAt(this.vAc.tblActualizar.getSelectedRow(), numero)));
                    break;
                case 3:
                    this.vAc.txtPoblacionA.setText(String.valueOf(this.vAc.tblActualizar.getValueAt(this.vAc.tblActualizar.getSelectedRow(), numero)));
                    break;
                default:
                    System.out.println("Holi");
            }
            numero++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vAc.btnCancelar) {
            borrarInfo();
            vAc.dispose();
        }
        if (ae.getSource() == vAc.btnActualizar) {
            if (!this.vAc.txtIDA.getText().equals("")) {
                actualizarRegistro();
            } else {
                vAc.jopMensaje.showMessageDialog(vAc, "No ha seleccionado un registro a modificar");
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
        this.vAc.setSize(595, 700);
        this.mostrar();
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
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }
}
