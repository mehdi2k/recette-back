package ma.mehdi.gestionticket.repositories;

import ma.mehdi.gestionticket.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findByCategorie(String categorie);
}
