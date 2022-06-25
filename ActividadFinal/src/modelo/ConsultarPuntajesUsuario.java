package modelo;

import java.util.ArrayList;

public interface ConsultarPuntajesUsuario {
    public boolean insertarP(PuntajesUsuarioVO puvo);
    public ArrayList<PuntajesUsuarioVO> consultarP();
    public boolean actualizarPrincipiante(PuntajesUsuarioVO puvo);
    public boolean actualizarIntermedio(PuntajesUsuarioVO puvo);
    public boolean actualizarAvanzado(PuntajesUsuarioVO puvo);
    public boolean eliminarP(PuntajesUsuarioVO puvo);
}
