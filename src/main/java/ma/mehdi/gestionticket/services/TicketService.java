package ma.mehdi.gestionticket.services;


import ma.mehdi.gestionticket.dtos.TicketDetailDTO;
import ma.mehdi.gestionticket.dtos.TicketDTO;
import ma.mehdi.gestionticket.exceptions.ticketNotFoundException;

import java.util.List;

public interface TicketService {

    TicketDTO saveTicket(TicketDTO ticketDTO);

    List<TicketDetailDTO> ticketList();

    void deleteTicket(Long ticketId);

    TicketDTO updateTicket(TicketDTO ticketDTO);

    TicketDetailDTO getTicket (Long ticketId) throws ticketNotFoundException;

    List<TicketDetailDTO> SearchTicket (String nom,String objet) ;














}
