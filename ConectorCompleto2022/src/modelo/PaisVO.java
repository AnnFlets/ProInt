package modelo;

import java.util.Date;

public class PaisVO {
    //Definición de las variables de acuerdo a los campos de la tabla Pais
    private int idPais;
    private String nombrePais;
    private String capitalPais;
    private long poblacionPais;
    private String fechaIngPais;
    private String fechaActPais;

    //Constructor vacío
    public PaisVO() {
    }

    //Métodos Get y Set
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCapitalPais() {
        return capitalPais;
    }

    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }

    public long getPoblacionPais() {
        return poblacionPais;
    }

    public void setPoblacionPais(long poblacionPais) {
        this.poblacionPais = poblacionPais;
    }

    public String getFechaIngPais() {
        return fechaIngPais;
    }

    public void setFechaIngPais(String fechaIngPais) {
        this.fechaIngPais = fechaIngPais;
    }

    public String getFechaActPais() {
        return fechaActPais;
    }

    public void setFechaActPais(String fechaActPais) {
        this.fechaActPais = fechaActPais;
    }
    
}
