/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.services;

import com.miguel.app.RestArticleProvider.model.Tags;
import com.miguel.app.RestArticleProvider.repository.TagsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel
 */
@Service
public class TagsServicesImpl implements ITagsService {
    
    @Autowired
    TagsRepository repo;

    @Override
    public void createOrUpdate(Tags tag) {
        repo.save(tag);
    }

    @Override
    public void delete(Tags tag) {
        repo.delete(tag);
    }

    @Override
    public Optional<Tags> findByKeywordName(String Keyword) {
        return repo.findByTagname(Keyword);
    }
    
}
