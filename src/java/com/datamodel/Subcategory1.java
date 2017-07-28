/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamodel;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ManyToMany;
import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.SnowballPorterFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

/**
 *
 * @author RJVIRUS
 */

public class Subcategory1 {
    
     
    private int subcategory1id;
    
    private String name;
    private Subcategory subcategory;
    private byte[] photo;
    
    private Set products=new HashSet(0);
    
    public Subcategory1() {
    }


    public Subcategory1(int subcategory1id, String name, Subcategory subcategory, byte[] photo) {
        this.subcategory1id = subcategory1id;
        this.name = name;
        this.subcategory = subcategory;
        this.photo = photo;
    }
    
    public Subcategory1(int subcategory1id, String name, Subcategory subcategory, byte[] photo,Set products) {
        this.subcategory1id = subcategory1id;
        this.name = name;
        this.subcategory = subcategory;
        this.photo = photo;
        this.products=products;
    }
    public int getSubcategory1id() {
        return subcategory1id;
    }

    public void setSubcategory1id(int subcategory1id) {
        this.subcategory1id = subcategory1id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Set getProducts() {
        return products;
    }

    public void setProducts(Set products) {
        this.products = products;
    }
    
    
    
}
