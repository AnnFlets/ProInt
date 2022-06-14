package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.Extras;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmInsertarLibro;

public class ControladorInsertarLibro implements ActionListener, WindowListener {

    FrmInsertarLibro fil = new FrmInsertarLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();

    public ControladorInsertarLibro(FrmInsertarLibro fil, LibroVO lvo, LibroDAO ldao, AutorVO avo, AutorDAO adao) {
        this.fil = fil;
        this.lvo = lvo;
        this.ldao = ldao;
        this.avo = avo;
        this.adao = adao;
        this.fil.btnCancelarIL.addActionListener(this);
        this.fil.btnRegistrarL.addActionListener(this);
        this.fil.addWindowListener(this);
    }

    private void limpiarCampos() {
        this.fil.txtTituloIL.setText("");
        this.fil.txtPaginasIL.setText("");
    }

    private void llenarComboBox() {
        ArrayList<AutorVO> autores = adao.consultarAutor();
        this.fil.cmbAutorIL.removeAllItems();
        for (int i = 0; i < autores.size(); i++) {
            this.fil.cmbAutorIL.addItem(autores.get(i).getNombreAutor());
        }
        if(autores.size() == 0){
            this.fil.jopInsertarLibro.showMessageDialog(fil, "No hay autores disponibles. Debe insertar un autor primero");
            this.fil.dispose();
        }
    }
    
    private int buscarCodigoAutor(String nombre) {
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

    private void registrarLibro() {
        try {
            this.lvo.setTituloLibro(this.fil.txtTituloIL.getText());
            String nombre = String.valueOf(this.fil.cmbAutorIL.getSelectedItem());
            int codigoAutor = buscarCodigoAutor(nombre);
            this.lvo.setCodigoAutorFk(codigoAutor);
            this.lvo.setCategoriaLibro(String.valueOf(this.fil.cmbCategoriaIL.getSelectedItem()));
            this.lvo.setPaginasLibro(Integer.parseInt(this.fil.txtPaginasIL.getText()));
            this.lvo.setFechaIngLibro(Extras.fechaHoy());
            if (ldao.insertarLibro(lvo) == true) {
                this.fil.jopInsertarLibro.showMessageDialog(fil, "Datos insertados con éxito");
                limpiarCampos();
            } else {
                this.fil.jopInsertarLibro.showMessageDialog(fil, "Error, datos no registrados");
            }
        } catch (Exception e) {
            this.fil.jopInsertarLibro.showMessageDialog(fil, "Debe ingresar un número entero en el número de páginas del libro");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fil.btnRegistrarL) {
            if (!this.fil.txtPaginasIL.getText().equals("") && !this.fil.txtTituloIL.getText().equals("")) {
                registrarLibro();
            } else {
                if (this.fil.txtTituloIL.getText().equals("")) {
                    this.fil.jopInsertarLibro.showMessageDialog(fil, "Debe ingresar el título del libro");
                } else if (this.fil.txtPaginasIL.getText().equals("")) {
                    this.fil.jopInsertarLibro.showMessageDialog(fil, "Debe ingresar el número de páginas del libro");
                }
            }
        }
        if (ae.getSource() == fil.btnCancelarIL) {
            limpiarCampos();
            fil.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        limpiarCampos();
        this.fil.lblFechaInsL.setText(Extras.fechaActual());
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
        this.fil.lblFechaInsL.setText(Extras.fechaActual());
        llenarComboBox();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }
}