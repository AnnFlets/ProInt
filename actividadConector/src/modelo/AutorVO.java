package modelo;

public class AutorVO {
    
    //Definicion de variables
    private int codigoAutor;
    private String nombreAutor;
    private String paisAutor;
    private int edadAutor;
    private String fechaIngAutor;
    private String fechaActAutor;

    //Constructor vacio
    public AutorVO() {
    }

    //Getter and Setter
    public int getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(int codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getPaisAutor() {
        return paisAutor;
    }

    public void setPaisAutor(String paisAutor) {
        this.paisAutor = paisAutor;
    }

    public int getEdadAutor() {
        return edadAutor;
    }

    public void setEdadAutor(int edadAutor) {
        this.edadAutor = edadAutor;
    }

    public String getFechaIngAutor() {
        return fechaIngAutor;
    }

    public void setFechaIngAutor(String fechaIngAutor) {
        this.fechaIngAutor = fechaIngAutor;
    }

    public String getFechaActAutor() {
        return fechaActAutor;
    }

    public void setFechaActAutor(String fechaActAutor) {
        this.fechaActAutor = fechaActAutor;
    }
}
