package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.Extras;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmModificarLibro;

public class ControladorModificarLibro implements ActionListener, WindowListener, MouseListener{
    
    FrmModificarLibro fmdl = new FrmModificarLibro();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    
    public ControladorModificarLibro(FrmModificarLibro fmdl, AutorVO avo, AutorDAO adao, LibroVO lvo, LibroDAO ldao){
        this.fmdl = fmdl;
        this.avo = avo;
        this.adao = adao;
        this.lvo = lvo;
        this.ldao = ldao;
        this.fmdl.btnCancelarMDL.addActionListener(this);
        this.fmdl.btnModificarL.addActionListener(this);
        this.fmdl.addWindowListener(this);
        this.fmdl.tblModificarL.addMouseListener(this);
    }
    
    private void llenarComboBoxAutores() {
        ArrayList<AutorVO> autores = adao.consultarAutor();
        this.fmdl.cmbAutorMDL.removeAllItems();
        for (int i = 0; i < autores.size(); i++) {
            this.fmdl.cmbAutorMDL.addItem(autores.get(i).getNombreAutor());
        }
        if(autores.size() == 0){
            this.fmdl.jopModificarL.showMessageDialog(fmdl, "No hay autores disponibles");
            this.fmdl.dispose();
        }
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
        fmdl.tblModificarL.setModel(mL);
        fmdl.tblModificarL.getTableHeader().setReorderingAllowed(false);
    }
    
    private void llenarCampos() {
        int numero = 0;
        while (numero < 4) {
            switch (numero) {
                case 0:
                    this.fmdl.txtCodigoMDL.setText(String.valueOf(this.fmdl.tblModificarL.getValueAt(this.fmdl.tblModificarL.getSelectedRow(), numero)));
                    break;
                case 1:
                    this.fmdl.txtTituloMDL.setText(String.valueOf(this.fmdl.tblModificarL.getValueAt(this.fmdl.tblModificarL.getSelectedRow(), numero)));
                    break;
                case 2:
                    this.fmdl.cmbCategoriaMDL.setSelectedItem(String.valueOf(this.fmdl.tblModificarL.getValueAt(this.fmdl.tblModificarL.getSelectedRow(), numero)));
                    break;
                case 3:
                    this.fmdl.txtPaginasMDL.setText(String.valueOf(this.fmdl.tblModificarL.getValueAt(this.fmdl.tblModificarL.getSelectedRow(), numero)));
                    break;
            }
            numero++;
        }
    }
    
    /*private int buscarCodigoAutor(String nombre) {
        String nombreAutor = nombre;
        int codigoA = 0;
        ArrayList<AutorVO> autores = adao.consultarAutor();
        for (int i = 0; i < autores.size(); i++) {
            if (nombreAutor.equals(autores.get(i).getNombreAutor())) {
                codigoA = autores.get(i).getCodigoAutor();
            }
        }
        return codigoA;
    }

    private void modificarLibro() {
        try {
            this.lvo.setCodigoLibro(Integer.parseInt(this.fmdl.txtCodigoMDL.getText()));
            this.lvo.setTituloLibro(this.fmdl.txtTituloMDL.getText());
            String nombre = String.valueOf(this.fmdl.cmbAutorMDL.getSelectedItem());
            int codigoAutor = buscarCodigoAutor(nombre);
            this.lvo.setCodigoAutorFk(codigoAutor);
            this.lvo.setCategoriaLibro(String.valueOf(this.fmdl.cmbCategoriaMDL.getSelectedItem()));
            this.lvo.setPaginasLibro(Integer.parseInt(this.fmdl.txtPaginasMDL.getText()));
            this.lvo.setFechaActLibro(Extras.fechaHoy());
            if (ldao.modificarLibro(lvo) == true) {
                this.fmdl.jopModificarL.showMessageDialog(fmdl, "Datos modificados con éxito");
                limpiarCampos();
            } else {
                this.fmdl.jopModificarL.showMessageDialog(fmdl, "Error, datos no modificados");
            }
        } catch (Exception e) {
            this.fmdl.jopModificarL.showMessageDialog(fmdl, "Debe ingresar un número entero en el número de páginas del libro");
        }
    }*/
    
    private void limpiarCampos(){
        this.fmdl.txtCodigoMDL.setText("");
        this.fmdl.txtTituloMDL.setText("");
        this.fmdl.txtPaginasMDL.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.fmdl.btnModificarL){
            
        }
        if(ae.getSource() == this.fmdl.btnCancelarMDL){
            limpiarCampos();
            this.fmdl.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.fmdl.lblFechaActL.setText(Extras.fechaActual());
        mostrarInformacionLibro();
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
        this.fmdl.lblFechaActL.setText(Extras.fechaActual());
        llenarComboBoxAutores();
        mostrarInformacionLibro();
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