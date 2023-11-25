package ma.mehdi.gestionticket.web;


import ma.mehdi.gestionticket.entities.Article;
import ma.mehdi.gestionticket.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class ArticleRestApi {

    @Autowired
    private ArticleRepository articleRepository;



    @PostMapping("/article/save")
    public void addArticle(Article article){
    articleRepository.save(article);
    }

    @GetMapping("/article/all")
    public List<Article> articleList(){
        return articleRepository.findAll();
    }

    @GetMapping("/article/categorie/{categorie}")
    public List<Article> articleListBycategory(@PathVariable String categorie){
        return articleRepository.findByCategorie(categorie);
    }


}
