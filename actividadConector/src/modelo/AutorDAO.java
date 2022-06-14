package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AutorDAO implements ConsultasAutor{

    @Override
    public boolean insertarAutor(AutorVO avo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "INSERT INTO autor (nombre_autor, "
                    + "pais_autor, edad_autor, fecha_ingreso_autor) "
                    + "VALUES ('" + avo.getNombreAutor() + "', '" + avo.getPaisAutor() + "', "
                    + avo.getEdadAutor() + ", '" + avo.getFechaIngAutor() + "')";
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[MInsAutor]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<AutorVO> consultarAutor() {
        Conector c = new Conector();
        ArrayList<AutorVO> infoA = new ArrayList<>();
        try{
            c.conectar();
            String query = "SELECT "
                    + "a.codigo_autor, "
                    + "a.nombre_autor, "
                    + "a.pais_autor, "
                    + "a.edad_autor "
                    + "FROM bdbiblioteca.autor a";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                AutorVO avo = new AutorVO();
                avo.setCodigoAutor(rs.getInt(1));
                avo.setNombreAutor(rs.getString(2));
                avo.setPaisAutor(rs.getString(3));
                avo.setEdadAutor(rs.getInt(4));
                infoA.add(avo);
            }
            c.desconectar();
        }catch(Exception e){
            System.err.println("Error[MMostrarAutor]: " + e.getMessage());
            c.desconectar();
        }
        return infoA;
    }

    @Override
    public boolean modificarAutor(AutorVO avo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "UPDATE bdbiblioteca.autor a " +
            "SET a.nombre_autor = '" + avo.getNombreAutor() + "', a.pais_autor = '" + avo.getPaisAutor() + "', a.edad_autor = " + avo.getEdadAutor() + ", a.fecha_actualizacion_autor = '" + avo.getFechaActAutor() + "' " +
            "WHERE a.codigo_autor = " + avo.getCodigoAutor();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[MActuaAutor]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminarAutor(AutorVO avo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "DELETE FROM bdbiblioteca.autor WHERE codigo_autor = " + avo.getCodigoAutor();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[MElimAutor]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }   
}