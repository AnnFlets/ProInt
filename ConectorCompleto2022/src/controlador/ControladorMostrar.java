package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmMostrar;

public class ControladorMostrar implements ActionListener, WindowListener {

    FrmMostrar vMo = new FrmMostrar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorMostrar(FrmMostrar vMo, PaisVO pvo, PaisDAO pdao) {
        this.vMo = vMo;
        this.pvo = pvo;
        this.pdao = pdao;
        vMo.btnCancelar.addActionListener(this);
        vMo.addWindowListener(this);
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
        //Agregar encabezado
        m.addColumn("Id del País");
        m.addColumn("Nombre del País");
        m.addColumn("Capital del País");
        m.addColumn("Población del País");

        for (PaisVO pvo : pdao.consultar()) {
            m.addRow(new Object[]{pvo.getIdPais(), pvo.getNombrePais(), pvo.getCapitalPais(), pvo.getPoblacionPais()});
        }

        vMo.tblMostrar.setModel(m);
        /*Diseño, establecer el tamaño de las columnas
        TableColumn cCero = vMo.tblMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);
        TableColumn cUno = vMo.tblMostrar.getColumnModel().getColumn(1);
        cUno.setMaxWidth(110);
        cUno.setMinWidth(110);
         */
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vMo.btnCancelar) {
            vMo.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.vMo.setSize(495,515);
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {

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
