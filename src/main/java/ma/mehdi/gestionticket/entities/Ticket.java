package ma.mehdi.gestionticket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mehdi.gestionticket.enums.State;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date ticketDate;
    private String objet;
    private String description;
    private State state;
    private String nom;
    private String prenom;
    private String email;
    private Long numero;
    private String nomSociete;
    //private Raison raison;
    @OneToMany
    private List<Raison> raison;
}
