package modelo;

public class TipoUsuarioVO {
    //Variables de acuerdo a la tabla 'tipo_usuario'
    private int idTipoUsuario;
    private String nombreTipoUsuario;
    private String descripcionTipoUsuario;
    
    //Constructor vacio
    public TipoUsuarioVO(){
    }
    
    //Getter & Setter
    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public String getDescripcionTipoUsuario() {
        return descripcionTipoUsuario;
    }

    public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }
}