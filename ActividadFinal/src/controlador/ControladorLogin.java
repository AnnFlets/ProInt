package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmJugador;
import vista.FrmLogin;

public class ControladorLogin implements ActionListener {

    FrmLogin vLogin = new FrmLogin();
    FrmAdministrador vAdmin = new FrmAdministrador();
    FrmJugador vJugar = new FrmJugador();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    int idUser;

    public ControladorLogin(FrmLogin vLogin, FrmAdministrador vAdmin, FrmJugador vJugar, UsuarioVO uvo, UsuarioDAO udao) {
        this.vLogin = vLogin;
        this.vAdmin = vAdmin;
        this.vJugar = vJugar;
        this.uvo = uvo;
        this.udao = udao;
        this.vLogin.btnIngresar.addActionListener(this);
    }

    private void limpiarCampos() {
        this.vLogin.txtNombreUsuario.setText("");
        this.vLogin.txtContrasena.setText("");
    }

    private int verificacionUsuario() {
        int tipoU = 0;
        String usuario = this.vLogin.txtNombreUsuario.getText();
        String password = this.vLogin.txtContrasena.getText();
        ArrayList<UsuarioVO> usuarios = udao.consultar();
        for (int i = 0; i < usuarios.size(); i++) {
            String user = usuarios.get(i).getUsuarioUsuario();
            String contra = usuarios.get(i).getContrasenaUsuario();
            if (user.equals(usuario)) {
                if (contra.equals(password)) {
                    tipoU = usuarios.get(i).getIdTipoUsuarioFk();
                    idUser = usuarios.get(i).getIdUsuario();
                }
            }
        }
        return tipoU;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.vLogin.btnIngresar) {
            int tipoUser = verificacionUsuario();
            switch (tipoUser) {
                case 1:
                    this.vLogin.lblAdvertencia.setText("");
                    limpiarCampos();
                    this.vLogin.dispose();
                    this.vAdmin.setVisible(true);
                    this.vAdmin.lblIdUser.setText(String.valueOf(idUser));
                    break;
                case 2:
                case 3:
                case 4:
                    this.vLogin.lblAdvertencia.setText("");
                    limpiarCampos();
                    this.vLogin.dispose();
                    this.vJugar.setVisible(true);
                    this.vJugar.lblIdUser.setText(String.valueOf(idUser));
                    break;
                default:
                    this.vLogin.lblAdvertencia.setText("* Usuario o contraseña incorrectos");
                    break;
            }
        }
    }
}