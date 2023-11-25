package ma.mehdi.gestionticket.repositories;

import ma.mehdi.gestionticket.entities.Raison;
import ma.mehdi.gestionticket.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RaisonRepository extends JpaRepository<Raison,Long> {



}
