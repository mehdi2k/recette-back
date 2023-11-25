package ma.mehdi.gestionticket.dtos;

import lombok.Data;
import ma.mehdi.gestionticket.entities.Raison;
import ma.mehdi.gestionticket.enums.State;

import java.util.Date;
import java.util.List;


@Data
public class TicketDTO {
    private Long id;
    private String objet;
    private String description;
    private State state;
    private String nom;
    private String prenom;
    private String email;
    private Long numero;
    private String nomSociete;
    private List<Raison> raison;

}