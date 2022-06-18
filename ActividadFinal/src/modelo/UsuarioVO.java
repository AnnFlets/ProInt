package modelo;

public class UsuarioVO {
    //Variables de acuerdo a la tabla 'usuario'
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private int edadUsuario;
    private String usuarioUsuario;
    private String contrasenaUsuario;
    private String fechaIngresoUsuario;
    private String fechaActualizacionUsuario;
    private int idTipoUsuarioFk;
   
    //Constructor vacio
    public UsuarioVO(){
    }

    //Getter & Setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public void setUsuarioUsuario(String usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getFechaIngresoUsuario() {
        return fechaIngresoUsuario;
    }

    public void setFechaIngresoUsuario(String fechaIngresoUsuario) {
        this.fechaIngresoUsuario = fechaIngresoUsuario;
    }

    public String getFechaActualizacionUsuario() {
        return fechaActualizacionUsuario;
    }

    public void setFechaActualizacionUsuario(String fechaActualizacionUsuario) {
        this.fechaActualizacionUsuario = fechaActualizacionUsuario;
    }

    public int getIdTipoUsuarioFk() {
        return idTipoUsuarioFk;
    }

    public void setIdTipoUsuarioFk(int idTipoUsuarioFk) {
        this.idTipoUsuarioFk = idTipoUsuarioFk;
    }
}