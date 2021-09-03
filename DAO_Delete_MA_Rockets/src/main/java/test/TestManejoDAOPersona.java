package test;
import datos.PersonaDAO;
import domain.Persona;
import java.util.List;
/**
 *
 * @author tonyp
 */
public class TestManejoDAOPersona {
    public static void main(String[] args) {
        PersonaDAO persDao = new PersonaDAO();
        
        

        
        persDao.deletePersona(7);
        List<Persona> personas = persDao.seleccionar();       
        
        personas.forEach(p -> {
            System.out.println(p);
       });

        
    }
}
