package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    //Declaracion de variables para la conexion
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "127.0.0.1"; //Servidor
    private String user = "root";
    private String pass = "";
    private String db = "bdjuego"; //Base de datos
    private String cadena; //Demas variables
    
    //Declaracion de objetos para la conexion
    public Connection connection;
    Statement statement;
    
    //Declaracion de metodos para la conexion
    //Va a realizar una conexion con la base de datos
    public void conectar(){
        //Ruta de conexion
        this.cadena = "jdbc:mysql://" + this.host + "/" + this.db;
        try{
            //Permitir que se active el paquete que contiene la clase Driver
            //Crea una nueva instancia y permite ejecutarla para que la conexion se realice
            Class.forName(this.driver).newInstance();
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        }catch(Exception e){
            System.err.println("Error[MCon]: " + e.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            this.connection.close();
        }catch(Exception e){
            System.err.println("Error[MDesc]: " + e.getMessage());
        }
    }
    
    //Metodo para realizar los querys de INSERT, UPDATE, DELETE
    public int consultasMultiples(String query){
        int resultado = 0;
        try{
            this.conectar();
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeUpdate(query);
        }catch(Exception e){
            System.err.println("Error[MConsMult]: " + e.getMessage());
            return 0;
        }
        return resultado;
    }
    
    //Método para realizar consultas SELECT
    public ResultSet consultaDatos(String consulta){
        try{
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.connection.createStatement();
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        }catch(Exception e){
            System.err.println("Error[MConsDatos]: " + e.getMessage());
        }
        return null;
    }
}