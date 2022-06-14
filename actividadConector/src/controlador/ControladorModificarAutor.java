package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.Extras;
import vista.FrmModificarAutor;

public class ControladorModificarAutor implements ActionListener, WindowListener, MouseListener {

    FrmModificarAutor fmda = new FrmModificarAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();

    public ControladorModificarAutor(FrmModificarAutor fmda, AutorVO avo, AutorDAO adao) {
        this.fmda = fmda;
        this.avo = avo;
        this.adao = adao;
        this.fmda.btnCancelarMDA.addActionListener(this);
        this.fmda.btnModificarA.addActionListener(this);
        this.fmda.tblModificarA.addMouseListener(this);
        this.fmda.addWindowListener(this);
    }

    private void mostrarInformacionAutor() {
        DefaultTableModel mA = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        mA.setColumnCount(0);
        mA.addColumn("Código del Autor");
        mA.addColumn("Nombre del Autor");
        mA.addColumn("País de origen del Autor");
        mA.addColumn("Edad del Autor");

        for (AutorVO avo : adao.consultarAutor()) {
            mA.addRow(new Object[]{avo.getCodigoAutor(), avo.getNombreAutor(), avo.getPaisAutor(), avo.getEdadAutor()});
        }
        fmda.tblModificarA.setModel(mA);
        fmda.tblModificarA.getTableHeader().setReorderingAllowed(false);
    }

    private void llenarCampos() {
        int numero = 0;
        while (numero < 4) {
            switch (numero) {
                case 0:
                    this.fmda.txtCodigoMDA.setText(String.valueOf(this.fmda.tblModificarA.getValueAt(this.fmda.tblModificarA.getSelectedRow(), numero)));
                    break;
                case 1:
                    this.fmda.txtNombreMDA.setText(String.valueOf(this.fmda.tblModificarA.getValueAt(this.fmda.tblModificarA.getSelectedRow(), numero)));
                    break;
                case 2:
                    this.fmda.txtPaisMDA.setText(String.valueOf(this.fmda.tblModificarA.getValueAt(this.fmda.tblModificarA.getSelectedRow(), numero)));
                    break;
                case 3:
                    this.fmda.txtEdadMDA.setText(String.valueOf(this.fmda.tblModificarA.getValueAt(this.fmda.tblModificarA.getSelectedRow(), numero)));
                    break;
            }
            numero++;
        }
    }

    private void modificarAutor() {
        try {
            this.avo.setCodigoAutor(Integer.parseInt(this.fmda.txtCodigoMDA.getText()));
            this.avo.setNombreAutor(this.fmda.txtNombreMDA.getText());
            this.avo.setPaisAutor(this.fmda.txtPaisMDA.getText());
            this.avo.setEdadAutor(Integer.parseInt(this.fmda.txtEdadMDA.getText()));
            this.avo.setFechaActAutor(Extras.fechaHoy());
            if (adao.modificarAutor(avo) == true) {
                this.fmda.jopModificarA.showMessageDialog(fmda, "Datos modificados con éxito");
                limpiarCampos();
            } else {
                this.fmda.jopModificarA.showMessageDialog(fmda, "Error, datos no modificados");
            }
        }catch(Exception e){
            this.fmda.jopModificarA.showMessageDialog(fmda, "Debe ingresar un número entero en la edad del autor");
        }

    }

    private void limpiarCampos() {
        this.fmda.txtCodigoMDA.setText("");
        this.fmda.txtNombreMDA.setText("");
        this.fmda.txtPaisMDA.setText("");
        this.fmda.txtEdadMDA.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.fmda.btnModificarA) {
            if (!this.fmda.txtCodigoMDA.getText().equals("")) {
                if (!this.fmda.txtNombreMDA.getText().equals("") && !this.fmda.txtPaisMDA.getText().equals("") && !this.fmda.txtEdadMDA.getText().equals("")) {
                    modificarAutor();
                } else if (this.fmda.txtNombreMDA.getText().equals("")) {
                    this.fmda.jopModificarA.showMessageDialog(fmda, "Debe ingresar el nombre del autor");
                } else if (this.fmda.txtPaisMDA.getText().equals("")) {
                    this.fmda.jopModificarA.showMessageDialog(fmda, "Debe ingresar el país de origen del autor");
                } else if (this.fmda.txtEdadMDA.getText().equals("")) {
                    this.fmda.jopModificarA.showMessageDialog(fmda, "Debe ingresar la edad del autor");
                }
            } else {
                this.fmda.jopModificarA.showMessageDialog(fmda, "No se ha seleccionado un registro a modificar");
            }
        }
        if (ae.getSource() == this.fmda.btnCancelarMDA) {
            limpiarCampos();
            this.fmda.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        mostrarInformacionAutor();
        this.fmda.lblFechaActMDA.setText(Extras.fechaActual());
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {
        limpiarCampos();
    }

    @Override
    public void windowIconified(WindowEvent we) {

    }

    @Override
    public void windowDeiconified(WindowEvent we) {

    }

    @Override
    public void windowActivated(WindowEvent we) {
        mostrarInformacionAutor();
        this.fmda.lblFechaActMDA.setText(Extras.fechaActual());
    }

    @Override
    public void windowDeactivated(WindowEvent we) {

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
}