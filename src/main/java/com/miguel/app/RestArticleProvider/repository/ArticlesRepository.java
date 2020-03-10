/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.repository;

import com.miguel.app.RestArticleProvider.model.Article;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Miguel
 */
public interface ArticlesRepository extends JpaRepository<Article, Integer> {
    
    
    List<Article> findByIduserauthor_FullnameContaining(String fullname);
    
    List<Article> findByPublishdateBetween(Date minDate, Date maxDate);
    
    List<Article> findByTagsList_Tagname(String tagname);
}
