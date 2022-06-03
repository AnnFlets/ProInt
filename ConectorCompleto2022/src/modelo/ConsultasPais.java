package modelo;

import java.util.ArrayList;

public interface ConsultasPais {
    public boolean insertar(PaisVO p);
    public ArrayList<PaisVO> consultar();
    public boolean actualizar(PaisVO p);
    public boolean eliminar(PaisVO p);
}
