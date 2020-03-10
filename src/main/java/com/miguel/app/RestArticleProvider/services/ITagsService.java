/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.services;

import com.miguel.app.RestArticleProvider.model.Tags;
import java.util.Optional;

/**
 *
 * @author Miguel
 */
public interface ITagsService {
    
    void createOrUpdate(Tags tag);
    
    void delete(Tags tag);
    
    Optional<Tags> findByKeywordName(String Keyword);
    
        
}
