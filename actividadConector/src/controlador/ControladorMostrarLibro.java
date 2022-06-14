package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmMostrarLibro;

public class ControladorMostrarLibro implements ActionListener, WindowListener {

    FrmMostrarLibro fml = new FrmMostrarLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();

    public ControladorMostrarLibro(FrmMostrarLibro fml, LibroVO lvo, LibroDAO ldao) {
        this.fml = fml;
        this.lvo = lvo;
        this.ldao = ldao;
        this.fml.btnCancelarML.addActionListener(this);
        this.fml.addWindowListener(this);
    }

    private void mostrarInformacionLibro() {
        DefaultTableModel mL = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        mL.setColumnCount(0);
        mL.addColumn("Código del Libro");
        mL.addColumn("Título del Libro");
        mL.addColumn("Categoría del Libro");
        mL.addColumn("No. páginas del Libro");
        mL.addColumn("Código del Autor");
        for (LibroVO lvo : ldao.consultarLibro()) {
            mL.addRow(new Object[]{lvo.getCodigoLibro(), lvo.getTituloLibro(), lvo.getCategoriaLibro(), lvo.getPaginasLibro(), lvo.getCodigoAutorFk()});
        }
        fml.tblMostrarL.setModel(mL);
        fml.tblMostrarL.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.fml.btnCancelarML) {
            this.fml.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        mostrarInformacionLibro();
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
        mostrarInformacionLibro();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }

}
