package modelo;

import java.util.ArrayList;

public interface ConsultarUsuario {
    public boolean insertar(UsuarioVO u);
    public ArrayList<UsuarioVO> consultar();
    public boolean actualizar(UsuarioVO u);
    public boolean actualizarRango(UsuarioVO u);
    public boolean eliminar(UsuarioVO u);
    public void reporte();
}