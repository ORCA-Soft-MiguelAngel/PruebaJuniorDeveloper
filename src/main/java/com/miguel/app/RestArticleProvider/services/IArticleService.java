/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.services;

import com.miguel.app.RestArticleProvider.model.Article;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Miguel
 */
public interface IArticleService {
    
    //TESTING METHOD DELETE AFTER
    List<Article> listAll();
    
    Article ListById(int idArticle);
    
    Optional<Article> listById(int idArticle);
            
    void createOrUpdate(Article article);
    
    void delete(Article article);
    
    List<Article> listAllArticlesByGivenAuthor(String author);
    
    List<Article> listAllArticlesByAGivenPeriod(Date minimumPeriod, Date maximunPeriod);
    
    List<Article> listAllArticlesByKeywords(String Keyword);
    
    boolean findIfArticleExistsById(int idArticle);
    
}
