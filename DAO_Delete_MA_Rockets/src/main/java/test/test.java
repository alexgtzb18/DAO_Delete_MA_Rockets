package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonyp
 */

public class test {
    public static void main(String[] args) {
        //connection String
        String url = "jdbc:mysql://localhost:3306/pruebajdbc?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
        try {
            // web interface 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "root");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM pruebajdbc.persona";
            ResultSet resultado = instruccion.executeQuery(sql); //muestra resultado de query
            
            System.out.println("********** Personas registradas **********");
            //para recorrer los elementos de la consulta
            while(resultado.next()){                
                System.out.println("Id Persona: \t" + resultado.getString("id_persona"));     
                System.out.println("Nombre: \t" + resultado.getString("nombre")); 
                System.out.println("Apellidos: \t" + resultado.getString("apellido")); 
                System.out.println("Email: \t\t" + resultado.getString("email")); 
                System.out.println("Telefono: \t" + resultado.getString("telefono") + "\n\n");                 
            }
            
            resultado.close();
            instruccion.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out); //sirve para
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
