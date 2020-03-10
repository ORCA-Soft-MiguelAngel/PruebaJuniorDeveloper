package com.miguel.app.RestArticleProvider;

import com.miguel.app.RestArticleProvider.model.Article;
import com.miguel.app.RestArticleProvider.model.Tags;
import com.miguel.app.RestArticleProvider.model.User;
import com.miguel.app.RestArticleProvider.repository.ArticlesRepository;
import com.miguel.app.RestArticleProvider.repository.AuthorizationsRepository;
import com.miguel.app.RestArticleProvider.repository.TagsRepository;
import com.miguel.app.RestArticleProvider.repository.UsersRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestArticleProviderApplication implements CommandLineRunner {

    @Autowired
    ArticlesRepository repoArticle;

    @Autowired
    TagsRepository repoTag;

    @Autowired
    AuthorizationsRepository repoAuth;

    @Autowired
    UsersRepository repoUser;

    public static void main(String[] args) {
        SpringApplication.run(RestArticleProviderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        List<Article> lista = repoArticle.findByTagsList_Tagname("java");
//
//        for (Article article : lista) {
//            System.out.println("");
//            System.out.println("=======================================================");
//            System.out.println("El id de este articulo es: " + article.getIdarticle());
//            System.out.println("El titulo es: " + article.getTitle());
//            System.out.println("La fecha de publicacion es: " + article.getPublishdate());
//            System.out.println("El autor de esto fue: " + article.getIduserauthor());
//            System.out.println("Los tags que tiene este articulo son: ");
//            for (Tags tag : article.getTagsList()) {
//                System.out.print(tag.getTagname()+" ");
//            }
//            System.out.println("");
//            System.out.println("=======================================================");
//            System.out.println("");
        }

    }


