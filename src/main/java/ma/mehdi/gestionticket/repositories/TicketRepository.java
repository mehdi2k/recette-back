package ma.mehdi.gestionticket.repositories;

import ma.mehdi.gestionticket.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {


    List<Ticket> findTicketsByNomAndObjet(String nom,String objet);
    List<Ticket> findByNom(String nom);
    List<Ticket> findByObjet(String objet);

    @Query("SELECT t FROM Ticket t WHERE (:nom IS NULL OR lower(t.nom) = :nom) AND (:objet IS NULL OR t.objet = :objet)")
    List<Ticket> findTicketsByNomAndOrObjet(@Param("nom") String nom, @Param("objet") String objet);

    @Query("SELECT t FROM Ticket t WHERE (:nom IS NULL OR t.nom = :nom) AND (:objet IS NULL OR t.objet = :objet) AND (:email IS NULL OR t.email = :email)")
    List<Ticket> findTicketsByNomAndObjetAndEmail(@Param("nom") String nom, @Param("objet") String objet, @Param("email") String email);





}
