package actividadfinal;

import controlador.ControladorAdministrador;
import controlador.ControladorJugador;
import controlador.ControladorLogin;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmJugador;
import vista.FrmLogin;

public class ActividadFinal {

    public static void main(String[] args) {
        
        //Vistas
        FrmLogin vLogin = new FrmLogin();
        FrmAdministrador vAdmin = new FrmAdministrador();
        FrmJugador vJugar = new FrmJugador();
        
        //Modelos
        UsuarioVO uvo = new UsuarioVO();
        UsuarioDAO udao = new UsuarioDAO();
        TipoUsuarioVO tuvo = new TipoUsuarioVO();
        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        
        //Controladores
        ControladorLogin cLogin = new ControladorLogin(vLogin, vAdmin, vJugar, uvo, udao);
        ControladorAdministrador cAdmin = new ControladorAdministrador(vLogin, vAdmin, uvo, udao, tuvo, tudao);
        ControladorJugador cJugar = new ControladorJugador(vLogin, vJugar, uvo, udao, tuvo, tudao);
        
        //Configuracion pantalla del login
        vLogin.setVisible(true);
        vLogin.setResizable(false);
        vLogin.setLocationRelativeTo(null);
        vLogin.setSize(930, 660);
    }
}