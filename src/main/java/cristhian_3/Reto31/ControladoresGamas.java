
package cristhian_3.Reto31;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladoresGamas {
   @Autowired
    private ServiciosGamas servicio;
    @GetMapping("/all")
    public List<Gamas> getGamas(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gamas> getGamas(@PathVariable("id") int gamaId) {
        return servicio.getGamas(gamaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gamas save(@RequestBody Gamas gama) {
        return servicio.save(gama);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gamas update(@RequestBody Gamas gama) {
        return servicio.update(gama);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gamaId) {
        return servicio.deletegama(gamaId);
    }
      
}
