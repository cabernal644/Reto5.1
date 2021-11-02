
package cristhian_3.Reto31;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioGamas {
   @Autowired
    private InterfaceGamas crud6;
    public List<Gamas> getAll(){
        return (List<Gamas>) crud6.findAll();
    }
    public Optional<Gamas> getGamas(int id){
        return crud6.findById(id);
    }

    public Gamas save(Gamas Gamas){
        return crud6.save(Gamas);
    }
    public void delete(Gamas Gamas){
       crud6.delete(Gamas);
    }
}  

