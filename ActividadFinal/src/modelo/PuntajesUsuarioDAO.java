package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PuntajesUsuarioDAO implements ConsultarPuntajesUsuario{

    @Override
    public boolean insertarP(PuntajesUsuarioVO puvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "INSERT INTO puntajes_usuario(id_usuario_fk) "
                    + "VALUES (" + puvo.getIdUsuarioFk() + ")";
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-InsertarP]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<PuntajesUsuarioVO> consultarP() {
        Conector c = new Conector();
        ArrayList<PuntajesUsuarioVO> infoP = new ArrayList<>();
        try{
            c.conectar();
            String query = "SELECT "
                    + "p.id_usuario_fk, "
                    + "p.puntaje_principiante, "
                    + "p.puntaje_intermedio, "
                    + "p.puntaje_avanzado "
                    + "FROM puntajes_usuario p";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                PuntajesUsuarioVO puvo = new PuntajesUsuarioVO();
                puvo.setIdUsuarioFk(rs.getInt(1));
                puvo.setPuntajePrincipiante(rs.getInt(2));
                puvo.setPuntajeIntermedio(rs.getInt(3));
                puvo.setPuntajeAvanzado(rs.getInt(4));
                infoP.add(puvo);
            }
            c.desconectar();
        }catch(Exception e){
            System.err.println("Error[M-ConsultarP]: " + e.getMessage());
            c.desconectar();
        }
        return infoP;
    }

    @Override
    public boolean eliminarP(PuntajesUsuarioVO puvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "DELETE FROM puntajes_usuario WHERE id_usuario_fk = " + puvo.getIdUsuarioFk();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-EliminarP]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean actualizarPrincipiante(PuntajesUsuarioVO puvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "UPDATE bdjuego.puntajes_usuario p " +
            "SET p.puntaje_principiante = " + puvo.getPuntajePrincipiante() + " "
                    + "WHERE p.id_usuario_fk = " + puvo.getIdUsuarioFk();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-ActualizarPrincipiante]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean actualizarIntermedio(PuntajesUsuarioVO puvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "UPDATE bdjuego.puntajes_usuario p " +
            "SET p.puntaje_intermedio = " + puvo.getPuntajeIntermedio() + " "
                    + "WHERE p.id_usuario_fk = " + puvo.getIdUsuarioFk();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-ActualizarIntermedio]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean actualizarAvanzado(PuntajesUsuarioVO puvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "UPDATE bdjuego.puntajes_usuario p " +
            "SET p.puntaje_avanzado = " + puvo.getPuntajeAvanzado() + " "
                    + "WHERE p.id_usuario_fk = " + puvo.getIdUsuarioFk();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-ActualizarAvanzado]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }
}