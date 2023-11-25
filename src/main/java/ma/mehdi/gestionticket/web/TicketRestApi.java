package ma.mehdi.gestionticket.web;

import lombok.AllArgsConstructor;
import ma.mehdi.gestionticket.dtos.TicketDetailDTO;
import ma.mehdi.gestionticket.dtos.TicketDTO;
import ma.mehdi.gestionticket.exceptions.ticketNotFoundException;
import ma.mehdi.gestionticket.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
public class TicketRestApi {
    TicketService ticketService;

    @GetMapping("/tickets")
    public List<TicketDetailDTO> ticketList(){
        return ticketService.ticketList();
    }

    @PostMapping("/tickets")
    public TicketDTO saveTicket(@RequestBody TicketDTO ticketDTO){
        return ticketService.saveTicket(ticketDTO);
    }

    @PutMapping("/tickets/{ticketId}")
    public TicketDTO saveTicketInfo(@PathVariable Long ticketId,@RequestBody TicketDTO ticketDTO){
        ticketDTO.setId(ticketId);
        return ticketService.updateTicket(ticketDTO);
    }

    @DeleteMapping("/tickets/{ticketId}")
    public void deleteTicket(@PathVariable(name="ticketId") Long ticketId){
        ticketService.deleteTicket(ticketId);
    }


    @GetMapping("/tickets/{ticketId}")
    public TicketDetailDTO getTicket(@PathVariable(name="ticketId") Long ticketId) throws ticketNotFoundException {
        return ticketService.getTicket(ticketId);
    }

    //find ticket by id
    @GetMapping("/tickets/id")
    public TicketDetailDTO getTicketById (@RequestParam(name="ticketId") Long ticketId) throws ticketNotFoundException {
        return ticketService.getTicket(ticketId);
    }

    //find by name and object
    @GetMapping("/tickets/search")
    public List<TicketDetailDTO> SearchTicketByName(@RequestParam(name="nom",required = false)  String nom,
                                                    @RequestParam(name="objet",required = false) String objet){
        return ticketService.SearchTicket(nom,objet);
    }






}
