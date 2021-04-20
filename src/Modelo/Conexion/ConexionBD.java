package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nahuel
 */
public class ConexionBD { // Clase que nos permite conectarnos a la BD SistemaFerreteria.
  
    public static final String  driver = "org.postgresql.Driver";
    public static final String ruta = "jdbc:postgresql://localhost:5432/SistemaFerreteria";
    public static final String usuario = "postgres";
    public static final String contraseña = "root";
    
    static Connection conexion = null;
    
    public ConexionBD(){ 
        
        try {
            Class.forName(driver); //Cargamos el driver de posgreSQL
            conexion = DriverManager.getConnection(ruta,usuario,contraseña); //Conexión y Acceso a la BD.
            
            if (conexion != null){
                
                System.out.println("Se realizo correctamente la conexión a la BD");
            }
            
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
        
    }
    

    public Connection getConexion() {//Retornamos la conexión.
        
        return conexion;
        
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    
    public void desconectar(){
        
        //conexion.close();
        conexion = null;
        
    }
    
    
        
     //public static ResultSet ultimoNumeroCliente(ResultSet rs) throws SQLException{
            
       //sta=declaracion(sta);
         //   rs=sta.executeQuery("select numerocliente from cliente order by numerocliente DESC LIMIT 1");
           // return rs;
     //} 
 
        
}
