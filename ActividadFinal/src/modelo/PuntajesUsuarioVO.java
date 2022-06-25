package modelo;

public class PuntajesUsuarioVO {
    //Variables de acuerdo a la tabla 'puntajes_usuario'
    private int idPuntaje;
    private int puntajePrincipiante;
    private int puntajeIntermedio;
    private int puntajeAvanzado;
    private int idUsuarioFk;
    
    //Constructor vacío
    public PuntajesUsuarioVO(){
    }
    
    //Getter & Setter
    public int getIdPuntaje() {
        return idPuntaje;
    }

    public void setIdPuntaje(int idPuntaje) {
        this.idPuntaje = idPuntaje;
    }

    public int getPuntajePrincipiante() {
        return puntajePrincipiante;
    }

    public void setPuntajePrincipiante(int puntajePrincipiante) {
        this.puntajePrincipiante = puntajePrincipiante;
    }

    public int getPuntajeIntermedio() {
        return puntajeIntermedio;
    }

    public void setPuntajeIntermedio(int puntajeIntermedio) {
        this.puntajeIntermedio = puntajeIntermedio;
    }

    public int getPuntajeAvanzado() {
        return puntajeAvanzado;
    }

    public void setPuntajeAvanzado(int puntajeAvanzado) {
        this.puntajeAvanzado = puntajeAvanzado;
    }

    public int getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(int idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }
}