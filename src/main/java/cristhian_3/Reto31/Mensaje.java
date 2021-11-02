
package cristhian_3.Reto31;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")// verificar esta en las clases mensages y reservaciones 

class Mensaje implements Serializable {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
   @ManyToOne
    @JoinColumn(name="idCar")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Carros car;

    @ManyToOne
    @JoinColumn(name="clientId") // verificar esta parte 
    @JsonIgnoreProperties({"messages","reservations","client"})
    private Cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Carros getCar() {
        return car;
    }

    public void setCar(Carros car) {
        this.car = car;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

  
    
}
