
package cristhian_3.Reto31;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosGamas {
  @Autowired
    private RepositorioGamas metodosCrud;

    public List<Gamas> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Gamas> getGamas(int GamasId) {
        return metodosCrud.getGamas(GamasId);
    }

    public Gamas save(Gamas gama) {
        if (gama.getIdGama()== null) {
            return metodosCrud.save(gama);
        } else {
             Optional<Gamas> e= metodosCrud.getGamas(gama.getIdGama());
            if(e.isEmpty()){
                return metodosCrud.save(gama);
            }else{
                return gama;
            }
        }
    }
public Gamas update(Gamas gama){
        if(gama.getIdGama()!=null){
            Optional<Gamas>g=metodosCrud.getGamas(gama.getIdGama());
            if(!g.isEmpty()){
                if(gama.getDescription()!=null){
                    g.get().setDescription(gama.getDescription());
                }
                if(gama.getName()!=null){
                    g.get().setName(gama.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return gama;
    }
    public boolean deletegama(int gamaId){
        Boolean d=getGamas(gamaId).map(gama -> {
            metodosCrud.delete(gama);
            return true;
        }).orElse(false);
        return d;
}
}