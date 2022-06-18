package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class UsuarioDAO implements ConsultarUsuario{
    
    //Variable global para el reporte
    public JasperViewer jv;

    @Override
    public boolean insertar(UsuarioVO u) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "INSERT INTO usuario (nombre_usuario, "
                    + "apellido_usuario, edad_usuario, usuario_usuario, "
                    + "contrasena_usuario, fecha_ingreso_usuario, id_tipo_usuario_fk) "
                    + "VALUES ('" + u.getNombreUsuario() + "', '" + u.getApellidoUsuario() + "', "
                    + u.getEdadUsuario() + ", '" + u.getUsuarioUsuario() + "', '" + u.getContrasenaUsuario() + "', '"
                    + u.getFechaIngresoUsuario() + "', " + u.getIdTipoUsuarioFk() + ")";
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-InsertarU]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<UsuarioVO> consultar() {
        Conector c = new Conector();
        ArrayList<UsuarioVO> infoU = new ArrayList<>();
        try{
            c.conectar();
            String query = "SELECT "
                    + "u.id_usuario, "
                    + "u.nombre_usuario, "
                    + "u.apellido_usuario, "
                    + "u.edad_usuario, "
                    + "u.usuario_usuario, "
                    + "u.contrasena_usuario, "
                    + "u.fecha_ingreso_usuario, "
                    + "u.fecha_actualizacion_usuario, "
                    + "u.id_tipo_usuario_fk "
                    + "FROM usuario u";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                UsuarioVO uvo = new UsuarioVO();
                uvo.setIdUsuario(rs.getInt(1));
                uvo.setNombreUsuario(rs.getString(2));
                uvo.setApellidoUsuario(rs.getString(3));
                uvo.setEdadUsuario(rs.getInt(4));
                uvo.setUsuarioUsuario(rs.getString(5));
                uvo.setContrasenaUsuario(rs.getString(6));
                uvo.setFechaIngresoUsuario(rs.getString(7));
                uvo.setFechaActualizacionUsuario(rs.getString(8));
                uvo.setIdTipoUsuarioFk(rs.getInt(9));
                infoU.add(uvo);
            }
            c.desconectar();
        }catch(Exception e){
            System.err.println("Error[M-ConsultarU]: " + e.getMessage());
            c.desconectar();
        }
        return infoU;
    }

    @Override
    public boolean actualizar(UsuarioVO u) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "UPDATE bdjuego.usuario u " +
            "SET u.nombre_usuario = '" + u.getNombreUsuario() + "', u.apellido_usuario = '" + u.getApellidoUsuario() + "', u.edad_usuario = " + u.getEdadUsuario() + ", u.usuario_usuario = '" + u.getUsuarioUsuario() + "', " +
            "u.contrasena_usuario = '" + u.getContrasenaUsuario() + "', u.fecha_actualizacion_usuario = '" + u.getFechaActualizacionUsuario() + "', u.id_tipo_usuario_fk = " + u.getIdTipoUsuarioFk() + " WHERE u.id_usuario = " + u.getIdUsuario();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-ActualizarU]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminar(UsuarioVO u) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query = "DELETE FROM bdjuego.usuario WHERE id_usuario = " + u.getIdUsuario();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.err.println("Error[M-EliminarU]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public void reporte() {
        Conector c = new Conector();
        try{
            c.conectar();
            //Definir una variable que encuentra el reporte
            JasperReport reporte;
            //Ruta del reporte
            //String ruta = "src\\reportes\\ReportePaises.jasper";
            String ruta = "/reportes/ReporteUsuarios.jasper";
            //Asignacion de ruta
            //reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource(ruta));
            //JasperPrint jp = JasperFillManager.fillReport(ruta, null, c.connection);
            JasperPrint jp = JasperFillManager.fillReport(reporte, null, c.connection);
            JasperViewer jv = new JasperViewer(jp, false);
            this.jv = jv;
        }catch(Exception e){
            System.err.println("Error[M-Reporte]: " + e.getMessage());
            c.desconectar();
        }
    }
}