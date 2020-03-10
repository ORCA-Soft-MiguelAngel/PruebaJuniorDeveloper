/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.repository;

import com.miguel.app.RestArticleProvider.model.Tags;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Miguel
 */
public interface TagsRepository extends JpaRepository<Tags, Integer> {
    
    
   Optional<Tags> findByTagname(String tagname);
}
