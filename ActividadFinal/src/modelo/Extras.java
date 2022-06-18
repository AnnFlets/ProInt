package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extras{
    
    //Retorna la fecha actual en formato anio/mes/dia
    public static String fechaHoy(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat fechaF = new SimpleDateFormat("yyyy/MM/dd");
        fechaHoy = fechaF.format(fecha.getTime());
        return fechaHoy;
    }
    
    //Retorna la fecha actual en formato dia/mes/anio
    public static String fechaActual(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat fechaF = new SimpleDateFormat("dd/MM/yyyy");
        fechaHoy = fechaF.format(fecha.getTime());
        return fechaHoy;
    }
}