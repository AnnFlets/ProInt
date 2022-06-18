package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoUsuarioDAO implements ConsultarTipoUsuario{
    
    @Override
    public ArrayList<TipoUsuarioVO> consultarTipo() {
        Conector c = new Conector();
        ArrayList<TipoUsuarioVO> infoTU = new ArrayList<>();
        try{
            c.conectar();
            String query = "SELECT "
                    + "t.id_tipo_usuario, "
                    + "t.nombre_tipo_usuario, "
                    + "t.descripcion_tipo_usuario "
                    + "FROM bdjuego.tipo_usuario t";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                TipoUsuarioVO tuvo = new TipoUsuarioVO();
                tuvo.setIdTipoUsuario(rs.getInt(1));
                tuvo.setNombreTipoUsuario(rs.getString(2));
                tuvo.setDescripcionTipoUsuario(rs.getString(3));
                infoTU.add(tuvo);
            }
            c.desconectar();
        }catch(Exception e){
            System.err.println("Error[M-Consultar-TU]: " + e.getMessage());
            c.desconectar();
        }
        return infoTU;
    }
}