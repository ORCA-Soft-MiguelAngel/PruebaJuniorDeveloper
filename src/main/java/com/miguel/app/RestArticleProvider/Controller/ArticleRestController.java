/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.Controller;

import com.miguel.app.RestArticleProvider.model.Article;
import com.miguel.app.RestArticleProvider.model.Tags;
import com.miguel.app.RestArticleProvider.services.IArticleService;
import com.miguel.app.RestArticleProvider.services.ITagsService;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel
 */
@RestController
@RequestMapping("/articles")
public class ArticleRestController {

    @Autowired
    IArticleService serviceArticle;

    @Autowired
    ITagsService serviceTags;

    //CREATE OR UPDATE AN ARTICLE
    @PostMapping("/")
    public Article saveOrUpdate(@RequestBody Article article) {

        List<Tags> listaFinal = new ArrayList<>();

        //Reading the Tags in the DB, if they exists, just add to the final list, otherwise save and add
        for (Tags tags : article.getTagsList()) {

            if (serviceTags.findByKeywordName(tags.getTagname()).isPresent()) {
                listaFinal.add(serviceTags.findByKeywordName(tags.getTagname()).get());
            } else {
                serviceTags.createOrUpdate(tags);
                listaFinal.add(tags);
            }
        }

        article.setTagsList(listaFinal);

        //read of the user, if exists 
        serviceArticle.createOrUpdate(article);

        return article;
    }

    //ERASE A ARTICLE
    @DeleteMapping("/{id}")
    public Article delete(@PathVariable("id") int idArticle) {
        Article article = serviceArticle.ListById(idArticle);
        serviceArticle.delete(article);
        return article;
    }

    @GetMapping("/author={Author}")
    public List<Article> listByAuthor(@PathVariable("Author") String author) {
        return serviceArticle.listAllArticlesByGivenAuthor(author);
    }

    @GetMapping(value = "/minperiod={minYear}:{minMonth}:{minDay}/maxperiod={maxYear}:{maxMonth}:{maxDay}")
    public List<Article> listByPeriod(@PathVariable("minYear") int minY,
            @PathVariable("minMonth") int minM,
            @PathVariable("minDay") int minD,
            @PathVariable("maxYear") int maxY,
            @PathVariable("maxMonth") int maxM,
            @PathVariable("maxDay") int maxD) {

        LocalDate lc1 = LocalDate.of(minY, minM, minD);
        LocalDate lc2 = LocalDate.of(maxY, maxM, maxD);

        return serviceArticle.listAll();
    }

    @GetMapping("/keyword={Keyword}")
    public List<Article> listByKeyword(@PathVariable("Keyword") String keyword) {
        return serviceArticle.listAllArticlesByKeywords(keyword);
    }

    // Alternative Methods
    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
