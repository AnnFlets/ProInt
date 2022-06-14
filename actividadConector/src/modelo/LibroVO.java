package modelo;

public class LibroVO {
    
    //Declaracion de variables
    private int codigoLibro;
    private String tituloLibro;
    private String categoriaLibro;
    private int paginasLibro;
    private int codigoAutorFk;
    private String fechaIngLibro;
    private String fechaActLibro;

    //Constructor vacio
    public LibroVO() {
    }

    //Getter and Setter
    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getCategoriaLibro() {
        return categoriaLibro;
    }

    public void setCategoriaLibro(String categoriaLibro) {
        this.categoriaLibro = categoriaLibro;
    }

    public int getPaginasLibro() {
        return paginasLibro;
    }

    public void setPaginasLibro(int paginasLibro) {
        this.paginasLibro = paginasLibro;
    }

    public int getCodigoAutorFk() {
        return codigoAutorFk;
    }

    public void setCodigoAutorFk(int codigoAutorFk) {
        this.codigoAutorFk = codigoAutorFk;
    }

    public String getFechaIngLibro() {
        return fechaIngLibro;
    }

    public void setFechaIngLibro(String fechaIngLibro) {
        this.fechaIngLibro = fechaIngLibro;
    }

    public String getFechaActLibro() {
        return fechaActLibro;
    }

    public void setFechaActLibro(String fechaActLibro) {
        this.fechaActLibro = fechaActLibro;
    }
}
