package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.Extras;
import vista.FrmInsertarAutor;

public class ControladorInsertarAutor implements ActionListener, WindowListener{
    
    FrmInsertarAutor fia = new FrmInsertarAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();

    public ControladorInsertarAutor(FrmInsertarAutor fia, AutorVO avo, AutorDAO adao) {
        this.fia = fia;
        this.avo = avo;
        this.adao = adao;
        this.fia.btnCancelarIA.addActionListener(this);
        this.fia.btnRegistrarA.addActionListener(this);
        this.fia.addWindowListener(this);
    }
    
    private void limpiarCampos(){
        this.fia.txtNombreIA.setText("");
        this.fia.txtPaisIA.setText("");
        this.fia.txtEdadIA.setText("");
    }
    
    private void registrarAutor(){
        try{
        this.avo.setNombreAutor(this.fia.txtNombreIA.getText());
        this.avo.setPaisAutor(this.fia.txtPaisIA.getText());
        this.avo.setEdadAutor(Integer.parseInt(this.fia.txtEdadIA.getText()));
        this.avo.setFechaIngAutor(Extras.fechaHoy());
        if(adao.insertarAutor(avo) == true){
            this.fia.jopInsertarAutor.showMessageDialog(fia, "Datos insertados con éxito");
            limpiarCampos();
        }else{
            this.fia.jopInsertarAutor.showMessageDialog(fia, "Error, datos no registrados");
        }
        }catch(Exception e){
            this.fia.jopInsertarAutor.showMessageDialog(fia, "Debe ingresar un número entero en la edad del autor");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fia.btnRegistrarA){
            if(!this.fia.txtNombreIA.getText().equals("")&&!this.fia.txtPaisIA.getText().equals("")&&!this.fia.txtEdadIA.getText().equals("")){
                this.registrarAutor();
            }else{
                if (this.fia.txtNombreIA.getText().equals("")) {
                    this.fia.jopInsertarAutor.showMessageDialog(fia, "Debe ingresar el nombre del autor");
                }
                else if (this.fia.txtPaisIA.getText().equals("")){
                    this.fia.jopInsertarAutor.showMessageDialog(fia, "Debe ingresar el país de origen del autor");
                }else if (this.fia.txtEdadIA.getText().equals("")){
                    this.fia.jopInsertarAutor.showMessageDialog(fia, "Debe ingresar la edad del autor");
                }
            }
        }
        if(ae.getSource() == fia.btnCancelarIA){
            limpiarCampos();
            fia.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        limpiarCampos();
        this.fia.lblFechaInsA.setText(Extras.fechaActual());
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
        this.fia.lblFechaInsA.setText(Extras.fechaActual());
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
}