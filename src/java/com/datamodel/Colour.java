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
public class Colour 
{
    private int colourid;
    
    private String name;
    
    private Set products = new HashSet(0);

    public Colour() {
    }


    public Colour(int colourid, String name) {
        this.colourid = colourid;
        this.name = name;
    }
    
    public Colour(int colourid, String name, Set products) {
        this.colourid = colourid;
        this.name = name;
        this.products=products;
    }

    public int getColourid() {
        return colourid;
    }

    public void setColourid(int colourid) {
        this.colourid = colourid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getProducts() {
        return products;
    }

    public void setProducts(Set products) {
        this.products = products;
    }
    
    
    
}
