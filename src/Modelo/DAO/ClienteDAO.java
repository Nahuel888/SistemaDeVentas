package Modelo.DAO;

import Modelo.Conexion.ConexionBD;
import Clases.ClienteVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO {

    static Connection conexion = null;
    static Statement statement = null;
    static ResultSet rst = null;
    
    DefaultTableModel dtm = new DefaultTableModel();

    public void registrarCliente(ClienteVO c) { //Método que registra todos los datos del cliente en la BD.

        ConexionBD conexion = new ConexionBD();
        Statement statement;

        try {

            statement = conexion.getConexion().createStatement();
            String consulta = ("insert into cliente (numerocliente,nombre,apellido,direccion,fecha_nacimiento,telefono,email,dni) values ('" + c.getNumeroCliente() + "','" + c.getNombre() + "','" + c.getApellido() + "','" + c.getDireccion() + "','" + c.getFechaNacimiento() + "','" + c.getTelefono() + "','" + c.getEmail() + "','" + c.getDni() + "')");
            statement.executeUpdate(consulta); //Ejecutamos la consulta.

            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);

            statement.close();       //Cerramos el enlace a la BD porque no se van a realizar mas consultas.

            conexion.desconectar();  //Finalizamos la conexión a la BD.

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudieron regisrar los datos");

        }

    }

    public int sigNumClinte() { //Método que incrementa en 1 el numero de cliente.
        
        ConexionBD conexion = new ConexionBD();
        Statement statement;
        
        int numeroCliente=1;
        
        try {

            statement = conexion.getConexion().createStatement();
            String consulta = ("select numerocliente from cliente order by numerocliente DESC LIMIT 1");
            ResultSet rs=statement.executeQuery(consulta); //Ejecutamos la consulta.
            
            if(rs.next()){
                 numeroCliente = rs.getInt("numerocliente")+1;
            }
            statement.close();       //Cerramos el enlace a la BD porque no se van a realizar mas consultas.
            conexion.desconectar();  //Finalizamos la conexión a la BD.

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudieron regisrar los datos");

        }
        return numeroCliente;
    }

    public ClienteVO buscarCliente(int dni) { // Método que permite buscar a un cliente por el DNI. 

        
        ConexionBD conexion = new ConexionBD();
        Statement s;
        ClienteVO c = new ClienteVO();
        boolean existe = false;
      
        try {
            s = conexion.getConexion().createStatement();
            String consulta = ("select * from cliente where dni ="+dni);
            ResultSet resultado = s.executeQuery(consulta); //ResulSet genera una tabla con los resultados devueltos por la consulta.
            
            
            while (resultado.next()) {
            
                existe = true;
                c.setNumeroCliente(Integer.parseInt(resultado.getString("numerocliente")));
                c.setNombre(resultado.getString("nombre"));
                c.setApellido(resultado.getString("apellido"));
                c.setDireccion(resultado.getString("direccion"));
                c.setFechaNacimiento(resultado.getString("fecha_nacimiento"));
                c.setTelefono(Integer.parseInt(resultado.getString("telefono")));
                c.setEmail(resultado.getString("email"));
                c.setDni(Integer.parseInt(resultado.getString("dni")));
                
            }
            
            s.close();
            conexion.desconectar();
            
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error, no pudo conectar con la BD");
            
        }
    
        
        if (existe == true){
            return c;
        }else{
            return null;
            
        }
        
    }
    
    public void actualizarJTable(){
        
        ConexionBD c = new ConexionBD();
        Statement s;
        
        try{
            
            int cantfilas=dtm.getRowCount();//Devuelve el numero de filas
	    if(cantfilas>0){//si existe un registro
                
                for(int i =0;i<cantfilas;i++){//Recorremos el arreglo
                    dtm.removeRow(0);	
		}
			
            }
            
            s = c.getConexion().createStatement();
            
            String datos[] =new String[8];
            while(rst.next()){
				datos[0]=rst.getString(1);
				datos[1]=rst.getString(2);
				datos[2]=rst.getString(3);
				datos[3]=rst.getString(4);
				datos[4]=rst.getString(5);
                                datos[5]=rst.getString(6);
                                datos[6]=rst.getString(7);
                                datos[7]=rst.getString(8);
				
				dtm.addRow(datos);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error garrafal");
		}  
                
                
                
                
            }
            
            
            
            
            
}
            
        
        
        
        
        
        
    
   
