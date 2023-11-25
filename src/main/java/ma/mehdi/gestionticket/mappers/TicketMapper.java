package ma.mehdi.gestionticket.mappers;

import ma.mehdi.gestionticket.dtos.TicketDetailDTO;
import ma.mehdi.gestionticket.dtos.TicketDTO;
import ma.mehdi.gestionticket.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class TicketMapper {

    public TicketDTO fromTicket(Ticket ticket){
        TicketDTO ticketDTO=new TicketDTO();
        BeanUtils.copyProperties(ticket,ticketDTO);

        return ticketDTO;
    }
    public Ticket fromTicketDTO(TicketDTO ticketDTO){
        Ticket ticket=new Ticket();
        BeanUtils.copyProperties(ticketDTO,ticket);

        return ticket;
    }

    public TicketDetailDTO detailDTOMap(Ticket ticket){
        TicketDetailDTO detailDTO =new TicketDetailDTO();
        BeanUtils.copyProperties(ticket,detailDTO);

        return detailDTO;
    }
}
