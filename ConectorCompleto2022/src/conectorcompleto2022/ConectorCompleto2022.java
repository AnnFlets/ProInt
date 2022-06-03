package conectorcompleto2022;

//import conexion.Conector;

import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorMostrar;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;


public class ConectorCompleto2022 {

    public static void main(String[] args) {
        //Prueba de conexion
        /*Conector c = new Conector();
        c.conectar();*/
        
        //Vistas
        FrmMenu fm = new FrmMenu();
        FrmInsertar fi = new FrmInsertar();
        FrmMostrar fmo = new FrmMostrar();
        FrmActualizar fa = new FrmActualizar();
        FrmEliminar fe = new FrmEliminar();
        //Modelo
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        //Controladores
        ControladorMenu cm = new ControladorMenu(fm, fi, fmo, fa, fe);
        ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        ControladorMostrar cmo = new ControladorMostrar(fmo, pvo, pdao);
        ControladorActualizar cAc = new ControladorActualizar(fa, pvo, pdao);
        ControladorEliminar cEl = new ControladorEliminar(fe, pvo, pdao);
        //Configuración de pantalla Menú
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
        fm.setResizable(false);
        fm.setSize(400, 540);
    }
    
}
