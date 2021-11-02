
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
public class ServiciosCarros {
    @Autowired
    private RepositorioCarros metodosCrud;

    public List<Carros> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Carros> getCarros(int carId) {
        return metodosCrud.getCarros(carId);
    }

    public Carros save(Carros car){
        if(car.getIdCar()==null){
            return metodosCrud.save(car);
        }else{
            Optional<Carros> e=metodosCrud.getCarros(car.getIdCar());
            if(e.isEmpty()){
                return metodosCrud.save(car);
            }else{
                return car;
            }
        }
    }
    public Carros update(Carros car){
        if(car.getIdCar()!=null){
            Optional<Carros> e=metodosCrud.getCarros(car.getIdCar());
            if(!e.isEmpty()){
                if(car.getName()!=null){
                    e.get().setName(car.getName());
                }
                if(car.getBrand()!=null){
                    e.get().setBrand(car.getBrand());
                }
                if(car.getYear()!=null){
                    e.get().setYear(car.getYear());
                }
                if(car.getDescription()!=null){
                    e.get().setDescription(car.getDescription());
                }
                // RESERVADO Para gama 
                 if(car.getGama()!=null){
                    e.get().setGama(car.getGama());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return car;
            }
        }else{
            return car;
        }
    }


    public boolean deleteCarros(int carId) {
        Boolean aBoolean = getCarros(carId).map(car -> {
            metodosCrud.delete(car);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
