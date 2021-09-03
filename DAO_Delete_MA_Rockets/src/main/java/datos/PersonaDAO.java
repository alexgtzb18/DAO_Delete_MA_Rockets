package datos;

import static datos.Conexion.getConnection;
import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonyp
 */
public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM pruebajdbc.persona";
    private static String SQL_DELETE = "DELETE from pruebajdbc.persona WHERE id_persona = ";
    
    // returns list of type Persona( class Persona.java)
    public List<Persona> seleccionar(){
        // initialize conn params
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Persona persona = null;
        
        List<Persona> personas = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                //get DB data for each Persona
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        //close all objects & connections
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(pstmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }
        
        return personas;
    
    }

    public void deletePersona(int id){
        String finalStmt = SQL_DELETE + Integer.toString(id);
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(finalStmt);
            pstmt.executeUpdate(finalStmt);
            System.out.println("Usuario con id " + Integer.toString(id) + " eliminado correctamente!");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        finally{
            try {
                Conexion.close(pstmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }
        
    }
}
