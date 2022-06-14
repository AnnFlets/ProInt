package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LibroDAO implements ConsultasLibro{

    @Override
    public boolean insertarLibro(LibroVO lvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "INSERT INTO libro (titulo_libro, "
                    + "categoria_libro, numero_paginas_libro, codigo_autor_fk, fecha_ingreso_libro) "
                    + "VALUES ('" + lvo.getTituloLibro() + "', '" + lvo.getCategoriaLibro() + "', "
                    + lvo.getPaginasLibro() + ", " + lvo.getCodigoAutorFk() + ", '" + lvo.getFechaIngLibro() + "')";
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[MInsLibro]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<LibroVO> consultarLibro() {
        Conector c = new Conector();
        ArrayList<LibroVO> infoL = new ArrayList<>();
        try{
            c.conectar();
            String query = "SELECT "
                    + "l.codigo_libro, "
                    + "l.titulo_libro, "
                    + "l.codigo_autor_fk, "
                    + "l.categoria_libro, "
                    + "l.numero_paginas_libro "
                    + "FROM bdbiblioteca.libro l";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                LibroVO lvo = new LibroVO();
                lvo.setCodigoLibro(rs.getInt(1));
                lvo.setTituloLibro(rs.getString(2));
                lvo.setCodigoAutorFk(rs.getInt(3));
                lvo.setCategoriaLibro(rs.getString(4));
                lvo.setPaginasLibro(rs.getInt(5));
                infoL.add(lvo);
            }
            c.desconectar();
        }catch(Exception e){
            System.err.println("Error[MMostrarLibro]: " + e.getMessage());
            c.desconectar();
        }
        return infoL;
    }

    @Override
    public boolean modificarLibro(LibroVO lvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "UPDATE bdbiblioteca.libro l " +
            "SET l.titulo_libro = '" + lvo.getTituloLibro() + "', l.codigo_autor_fk = " + lvo.getCodigoAutorFk() + ", l.categoria_libro = '" + lvo.getCategoriaLibro() + "', l.numero_paginas_libro = " + lvo.getPaginasLibro() + ", a.fecha_actualizacion_autor = '" + lvo.getFechaActLibro() + "' " +
            "WHERE l.codigo_libro = " + lvo.getCodigoLibro();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[MActuaLibro]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminarLibro(LibroVO lvo) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "DELETE FROM bdbiblioteca.libro WHERE codigo_libro = " + lvo.getCodigoLibro();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[MElimLibro]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;   
    }
}