package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.AutorDAO;
import modelo.AutorVO;
import vista.FrmMostrarAutor;

public class ControladorMostrarAutor implements ActionListener, WindowListener{

    FrmMostrarAutor fma = new FrmMostrarAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    
    public ControladorMostrarAutor(FrmMostrarAutor fma, AutorVO avo, AutorDAO adao){
        this.fma = fma;
        this.avo = avo;
        this.adao = adao;
        this.fma.addWindowListener(this);
        this.fma.btnCancelarMA.addActionListener(this);
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
        fma.tblMostrarA.setModel(mA);
        fma.tblMostrarA.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.fma.btnCancelarMA){
            this.fma.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        mostrarInformacionAutor();
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
        mostrarInformacionAutor();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
}
