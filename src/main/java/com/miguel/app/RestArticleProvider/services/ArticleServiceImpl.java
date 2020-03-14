/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.services;

import com.miguel.app.RestArticleProvider.model.Article;
import com.miguel.app.RestArticleProvider.repository.ArticlesRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    ArticlesRepository repo;

    @Override
    public void createOrUpdate(Article article) {
        repo.save(article);
    }

    @Override
    public void delete(Article article) {
        repo.delete(article);
    }

    @Override
    public List<Article> listAllArticlesByGivenAuthor(String author) {
        return repo.findByIduserauthor_FullnameContaining(author);
    }

    @Override
    public List<Article> listAllArticlesByAGivenPeriod(Date minimumPeriod, Date maximunPeriod) {
        return repo.findByPublishdateBetween(minimumPeriod, maximunPeriod);
    }

    @Override
    public List<Article> listAllArticlesByKeywords(String Keyword) {
        return repo.findByTagsList_Tagname(Keyword);
    }

    //MEHTODS BELOW HERE SHOULD BE ERASED CAUSE IS ONLY FOR TESTING
    @Override
    public List<Article> listAll() {
        return repo.findAll();
    }

    @Override
    public Article ListById(int idArticle) {

        if (repo.findById(idArticle).isPresent()) {
            return repo.findById(idArticle).get();
        }
        return null;
    }

    @Override
    public Optional<Article> listById(int idArticle) {
        return repo.findById(idArticle);
    }

    @Override
    public boolean findIfArticleExistsById(int idArticle) {

        return repo.findById(idArticle).isPresent();
    }

}
