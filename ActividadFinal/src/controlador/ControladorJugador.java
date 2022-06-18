package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmJugador;
import vista.FrmLogin;

public class ControladorJugador implements ActionListener, WindowListener, MouseListener {

    FrmLogin vLogin = new FrmLogin();
    FrmJugador vJugar = new FrmJugador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    TipoUsuarioVO tuvo = new TipoUsuarioVO();
    TipoUsuarioDAO tudao = new TipoUsuarioDAO();

    public ControladorJugador(FrmLogin vLogin, FrmJugador vJugar, UsuarioVO uvo, UsuarioDAO udao, TipoUsuarioVO tuvo, TipoUsuarioDAO tudao) {
        this.vLogin = vLogin;
        this.vJugar = vJugar;
        this.uvo = uvo;
        this.udao = udao;
        this.tuvo = tuvo;
        this.tudao = tudao;
        this.vJugar.addWindowListener(this);
        this.vJugar.btnLogout.addActionListener(this);
    }

    private String encontrarNombreApellido() {
        String nombre = "";
        String apellido = "";
        for (UsuarioVO uvo : udao.consultar()) {
            if (uvo.getIdUsuario() == Integer.parseInt(this.vJugar.lblIdUser.getText())) {
                nombre = uvo.getNombreUsuario();
                apellido = uvo.getApellidoUsuario();
            }
        }
        String nombreCompleto = nombre + " " + apellido;
        return nombreCompleto;
    }
    
    private int devolverIDTipoUsuario() {
        int idUser = Integer.parseInt(this.vJugar.lblIdUser.getText());
        int tipoUsuario = 0;
        for (UsuarioVO uvo : udao.consultar()) {
            if (uvo.getIdUsuario() == idUser) {
                tipoUsuario = uvo.getIdTipoUsuarioFk();
            }
        }
        return tipoUsuario;
    }
    
    private String encontrarIDTipoUsuario() {
        String tipoUsuarioN = "";
        for (TipoUsuarioVO tuvo : tudao.consultarTipo()) {
            if (tuvo.getIdTipoUsuario() == devolverIDTipoUsuario()) {
                 tipoUsuarioN = tuvo.getNombreTipoUsuario();
            }
        }
        return tipoUsuarioN;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.vJugar.btnLogout) {
            this.vJugar.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        //Configuraciones de la ventana 'Jugador'
        vJugar.setResizable(false);
        vJugar.setLocationRelativeTo(null);
        vJugar.setSize(1045, 750);
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {
        this.vLogin.setVisible(true);
    }

    @Override
    public void windowIconified(WindowEvent we) {

    }

    @Override
    public void windowDeiconified(WindowEvent we) {

    }

    @Override
    public void windowActivated(WindowEvent we) {
        this.vJugar.lblIdUser.setHorizontalAlignment(SwingConstants.CENTER);
        this.vJugar.lblNombreUser.setText(encontrarNombreApellido());
        this.vJugar.lblNombreUser.setHorizontalAlignment(SwingConstants.CENTER);
        this.vJugar.lblRangoUauario.setText(encontrarIDTipoUsuario());
        this.vJugar.lblRangoUauario.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
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
