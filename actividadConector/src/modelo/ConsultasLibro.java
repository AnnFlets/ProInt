package modelo;

import java.util.ArrayList;

public interface ConsultasLibro {
    public boolean insertarLibro(LibroVO lvo);
    public ArrayList<LibroVO> consultarLibro();
    public boolean modificarLibro(LibroVO lvo);
    public boolean eliminarLibro(LibroVO lvo);
}