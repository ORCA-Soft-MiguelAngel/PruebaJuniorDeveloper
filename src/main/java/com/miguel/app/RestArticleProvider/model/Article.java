/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.app.RestArticleProvider.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarticle")
    private Integer idarticle;
    
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    
    @Lob
    @Size(max = 16777215)
    @Column(name = "details")
    private String details;
    
    @Column(name = "publishdate")
    @Temporal(TemporalType.DATE)
    private Date publishdate;
    
    @JoinTable(name = "articletags", joinColumns = {
        @JoinColumn(name = "idarticle", referencedColumnName = "idarticle")}, inverseJoinColumns = {
        @JoinColumn(name = "idtag", referencedColumnName = "idtag")})
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Tags> tagsList;
    
    @JoinColumn(name = "iduserauthor", referencedColumnName = "iduser")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne()
    private User iduserauthor;

    public Article() {
    }

    public Article(Integer idarticle) {
        this.idarticle = idarticle;
    }

    public Integer getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Integer idarticle) {
        this.idarticle = idarticle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    @XmlTransient
    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    public User getIduserauthor() {
        return iduserauthor;
    }

    public void setIduserauthor(User iduserauthor) {
        this.iduserauthor = iduserauthor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticle != null ? idarticle.hashCode() : 0);
        return hash;
    }



   
    
}
