package actividadconector;

import controlador.ControladorInsertarAutor;
import controlador.ControladorInsertarLibro;
import controlador.ControladorMenu;
import controlador.ControladorModificarAutor;
import controlador.ControladorModificarLibro;
import controlador.ControladorMostrarAutor;
import controlador.ControladorMostrarLibro;
import modelo.AutorDAO;
import modelo.AutorVO;
import modelo.LibroDAO;
import modelo.LibroVO;
import vista.FrmEliminarAutor;
import vista.FrmEliminarLibro;
import vista.FrmInsertarAutor;
import vista.FrmInsertarLibro;
import vista.FrmMenu;
import vista.FrmModificarAutor;
import vista.FrmModificarLibro;
import vista.FrmMostrarAutor;
import vista.FrmMostrarLibro;

public class ActividadConector {

    public static void main(String[] args) {
        
        //Vista
        FrmMenu fme = new FrmMenu();
        FrmInsertarAutor fia = new FrmInsertarAutor();
        FrmInsertarLibro fil = new FrmInsertarLibro();
        FrmMostrarAutor fma = new FrmMostrarAutor();
        FrmMostrarLibro fml = new FrmMostrarLibro();
        FrmModificarAutor fmda = new FrmModificarAutor();
        FrmModificarLibro fmdl = new FrmModificarLibro();
        FrmEliminarAutor fea = new FrmEliminarAutor();
        FrmEliminarLibro fel = new FrmEliminarLibro();
        //Modelo
        AutorVO avo = new AutorVO();
        AutorDAO adao = new AutorDAO();
        LibroVO lvo = new LibroVO();
        LibroDAO ldao = new LibroDAO();
        //Controladores
        ControladorMenu cm = new ControladorMenu(fme, fia, fil, fma, fml, fmda, fmdl, fea, fel);
        ControladorInsertarAutor cia = new ControladorInsertarAutor(fia, avo, adao);
        ControladorInsertarLibro cil = new ControladorInsertarLibro(fil, lvo, ldao, avo, adao);
        ControladorMostrarAutor cma = new ControladorMostrarAutor(fma, avo, adao);
        ControladorMostrarLibro cml = new ControladorMostrarLibro(fml, lvo, ldao);
        ControladorModificarAutor cmda = new ControladorModificarAutor(fmda, avo, adao);
        ControladorModificarLibro cmdl = new ControladorModificarLibro(fmdl, avo, adao, lvo, ldao);
        //Configuracion vista menu
        fme.setVisible(true);
        fme.setLocationRelativeTo(null);
        fme.setResizable(false);
    }
}