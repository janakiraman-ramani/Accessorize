/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamodel;

import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author RJVIRUS
 */
public class Category 
{
  
     
    private int categoryid;
    private String name;
    private byte[] photo;
    
    private Set subcategories=new HashSet(0);
    
    public Category()
    {
        
    }
    
    public Category(int categoryid, String name, byte[] photo)
    {
        this.categoryid=categoryid;
        this.name=name;
        this.photo=photo;
    }
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Set getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set subcategories) {
        this.subcategories = subcategories;
    }

    
    
}
