/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.repository;

import com.miguel.app.RestArticleProvider.model.Authorization;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Miguel
 */
public interface AuthorizationsRepository extends CrudRepository<Authorization, Integer> {
    
}
