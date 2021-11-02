
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
public class RepositorioCarros {
  @Autowired
    private InterfaceCarros crud;

    public List<Carros> getAll(){
        return (List<Carros>) crud.findAll();
    }

    public Optional<Carros> getCarros(int id){
        return crud.findById(id);
    }

    public Carros save(Carros car){
        return crud.save(car);
    }
    public void delete(Carros car){
        crud.delete(car);
    }  
    
}
