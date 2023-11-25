package ma.mehdi.gestionticket;

import ma.mehdi.gestionticket.dtos.TicketDTO;
import ma.mehdi.gestionticket.entities.Article;
import ma.mehdi.gestionticket.entities.Raison;
import ma.mehdi.gestionticket.entities.Ticket;
import ma.mehdi.gestionticket.repositories.ArticleRepository;
import ma.mehdi.gestionticket.repositories.RaisonRepository;
import ma.mehdi.gestionticket.services.TicketService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GestionTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionTicketApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TicketService ticketService, RaisonRepository raisonRepository,ArticleRepository articleRepository){
        return args -> {
            Raison raison1 = new Raison(null,"101","shutdown");
            Raison raison2 = new Raison(null,"102","tuning");
            Raison raison3 = new Raison(null,"103","some raison");
            raisonRepository.save(raison1);
            raisonRepository.save(raison2);
            raisonRepository.save(raison3);

            List<Raison> raisonList = new ArrayList<>();
            raisonList.add(raison1);
            raisonList.add(raison2);

            /* ***************************************************      */

            TicketDTO ticket=new TicketDTO();
            ticket.setObjet("problem");
            ticket.setDescription("solve it now");
            ticket.setNom("jmani");
            ticket.setPrenom("laarbi");
            ticket.setEmail("jmani@gmail.com");
            ticket.setNomSociete("hub");
            ticket.setNumero(0600000000L);
            ticket.setRaison(raisonList);
            ticketService.saveTicket(ticket);
            /* ***************************************************      */
            TicketDTO ticket2=new TicketDTO();
            ticket2.setObjet("problem");
            ticket2.setDescription("solve it now");
            ticket2.setNom("LA");
            ticket2.setPrenom("knight");
            ticket2.setEmail("la_night@gmail.com");
            ticket2.setNomSociete("w");
            ticket2.setNumero(0601000000L);
            ticketService.saveTicket(ticket2);


            Article article0= new Article(null,"facts","this is the worst article ever seen","news","C:\\Users\\hp\\Desktop\\spring_boog.png");
            Article article1= new Article(null,"arsenal","the shittier team ever","news","C:\\Users\\hp\\Desktop\\spring_boog.PNG");
            Article article2= new Article(null,"shakira","tamina mina eh eh waka waka eh eh","music",null);
            Article article3= new Article(null,"LA_Knight","who s game it is with every body bsaying ","wwe","https://blog.oxiane.com/2021/02/05/spring-boot-2-4/");

            articleRepository.save(article0);
            articleRepository.save(article1);
            articleRepository.save(article2);
            articleRepository.save(article3);
            System.out.println("aaaaaa");

            System.out.println("zzzzzzzz"+articleRepository.findAll());

        };
    };


}
