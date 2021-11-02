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
@RequestMapping("/api/Car")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})


public class ControladorCarros {
  @Autowired
    private ServiciosCarros servicio;
    @GetMapping("/all")
    public List<Carros> getCarros(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Carros> getCarros(@PathVariable("id") int carId) {
        return servicio.getCarros(carId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Carros save(@RequestBody Carros car) {
        return servicio.save(car);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Carros update(@RequestBody Carros car) {
        return servicio.update(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int carId) {
        return servicio.deleteCarros(carId);
    }    
}
