/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "authorization")
public class Authorization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauthorization")
    private Integer idauthorization;
    
    @Size(max = 50)
    @Column(name = "profile")
    private String profile;
    
    @JoinTable(name = "userauthorization", joinColumns = {
        @JoinColumn(name = "idauthorization", referencedColumnName = "idauthorization")}, inverseJoinColumns = {
        @JoinColumn(name = "iduser", referencedColumnName = "iduser")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> userList;

    public Authorization() {
    }

    public Authorization(Integer idauthorization) {
        this.idauthorization = idauthorization;
    }

    public Integer getIdauthorization() {
        return idauthorization;
    }

    public void setIdauthorization(Integer idauthorization) {
        this.idauthorization = idauthorization;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauthorization != null ? idauthorization.hashCode() : 0);
        return hash;
    }



    
    
}
