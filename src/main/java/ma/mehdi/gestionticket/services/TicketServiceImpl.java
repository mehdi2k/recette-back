package ma.mehdi.gestionticket.services;

import lombok.AllArgsConstructor;
import ma.mehdi.gestionticket.dtos.TicketDetailDTO;
import ma.mehdi.gestionticket.dtos.TicketDTO;
import ma.mehdi.gestionticket.entities.Ticket;
import ma.mehdi.gestionticket.enums.State;
import ma.mehdi.gestionticket.exceptions.ticketNotFoundException;
import ma.mehdi.gestionticket.mappers.TicketMapper;
import ma.mehdi.gestionticket.repositories.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class TicketServiceImpl implements TicketService{
    TicketRepository ticketRepository;
    TicketMapper dtoMap;

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        Ticket ticket=dtoMap.fromTicketDTO(ticketDTO);
        ticket.setTicketDate(new Date());
        ticket.setState(State.NonResolu);
        Ticket savedTicket = ticketRepository.save(ticket);

        return dtoMap.fromTicket(savedTicket);
    }

    @Override
    public List<TicketDetailDTO> ticketList() {
        List<Ticket> ticketList=ticketRepository.findAll();
        List<TicketDetailDTO> DetailDTOS = ticketList.stream()
                .map(ticket -> dtoMap.detailDTOMap(ticket))
                .collect(Collectors.toList());

        return DetailDTOS;
    }

    @Override
    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        Ticket ticket=dtoMap.fromTicketDTO(ticketDTO);
        Ticket savedTicket = ticketRepository.save(ticket);

        return dtoMap.fromTicket(savedTicket);
    }

    @Override
    public TicketDetailDTO getTicket(Long ticketId) throws ticketNotFoundException {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(()->new ticketNotFoundException("ticket not found"));

        return dtoMap.detailDTOMap(ticket);
    }

//search by name and or object
    @Override
    public List<TicketDetailDTO> SearchTicket(String nom, String objet) {

        List<Ticket> ticketList = ticketRepository.findTicketsByNomAndOrObjet(nom,objet);

        List<TicketDetailDTO> ticketDetailDTOList = ticketList.stream()
                .map(ticket -> dtoMap.detailDTOMap(ticket))
                .collect(Collectors.toList());
        return ticketDetailDTOList;
    }




}
