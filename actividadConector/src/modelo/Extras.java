package modelo;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Extras {
    
    //Métodos que retornan la fecha actual en distinto formato
    public static String fechaHoy(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat fechaF = new SimpleDateFormat("yyyy/MM/dd");
        fechaHoy = fechaF.format(fecha.getTime());
        return fechaHoy;
    }
    
    public static String fechaActual(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat fechaF = new SimpleDateFormat("dd/MM/yyyy");
        fechaHoy = fechaF.format(fecha.getTime());
        return fechaHoy;
    }
}