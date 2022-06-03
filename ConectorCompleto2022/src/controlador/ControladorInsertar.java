package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmInsertar;
import modelo.Extras;

public class ControladorInsertar implements ActionListener, WindowListener{

    
    FrmInsertar vIn = new FrmInsertar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    

    public ControladorInsertar(FrmInsertar vIn, PaisVO pvo, PaisDAO pdao) {
        this.vIn = vIn;
        this.pvo = pvo;
        this.pdao = pdao;
        vIn.btnRegistrarPais.addActionListener(this);
        vIn.btnCancelarRegistro.addActionListener(this);
        vIn.addWindowListener(this);
    }
    private void registrarPais(){
        this.pvo.setNombrePais(vIn.txtNombrePais.getText());
        this.pvo.setCapitalPais(vIn.txtCapital.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vIn.txtPoblacionPais.getText()));
        this.pvo.setFechaIngPais(Extras.fechaHoy());
        //pdao.insertar(pvo);
        if (pdao.insertar(pvo) == true) {
            vIn.jopMensaje.showMessageDialog(vIn, "Datos insertados correctamente");
            this.vIn.txtNombrePais.setText("");
            this.vIn.txtCapital.setText("");
            this.vIn.txtPoblacionPais.setText("");
        }else{            
            vIn.jopMensaje.showMessageDialog(vIn, "Error, datos no registrados");
        }
    }
    
    private void borrarInfo(){
        vIn.txtNombrePais.setText("");
        vIn.txtCapital.setText("");
        vIn.txtPoblacionPais.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vIn.btnRegistrarPais) {
            if (!this.vIn.txtNombrePais.getText().equals("")&&
                !this.vIn.txtCapital.getText().equals("")&&
                !this.vIn.txtPoblacionPais.getText().equals("")) {
                this.registrarPais();
            }else{
                this.vIn.jopMensaje.showMessageDialog(vIn, "Debe llenar todos los campos");
            }
        }if (e.getSource() == vIn.btnCancelarRegistro) {
            borrarInfo();
            vIn.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.vIn.setSize(495, 370);
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
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
    
}
