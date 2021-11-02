package cristhian_3.Reto31;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioReservaciones {
  
 @Autowired
    private InterfaceReservaciones crud8;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud8.findAll();
    }
    public Optional<Reservaciones> getReservaciones(int id){
        return crud8.findById(id);
    }

    public Reservaciones save(Reservaciones reservation){
        return crud8.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crud8.delete(reservation);
    }   

    public List<Reservaciones> ReservacionStatusRepositorio (String status){
         return crud8.findAllByStatus(status);
     }
     
     public List<Reservaciones> ReservacionTiempoRepositorio (Date a, Date b){
         return crud8.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud8.countTotalReservationsByCliente();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
         }
         return res;
     }

    // se recomenda verificar esta parte ya que si se quita deja de funcionar unos servicios 
    Optional<Reservaciones> getReservation(int reservationId) {
      throw new UnsupportedOperationException("Not supported yet."); } //To change body of generated methods, choose Tools | Templates.
    
}
