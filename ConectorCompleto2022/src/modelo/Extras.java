package modelo;
//Se puede llamar Extras o Utilidades

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extras {
    
    //Método que retorna la fecha actual
    public static String fechaHoy(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat fechaF = new SimpleDateFormat("yyyy/MM/dd");
        fechaHoy = fechaF.format(fecha.getTime());
        return fechaHoy;
    }
    
}
