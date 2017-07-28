/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamodel;

/**
 *
 * @author RJVIRUS
 */
public class CategoryFeatureValue 
{
    private int categoryFeatureValueid;
    private Subcategory subcategory;
    private FeatureValue featureValue;

    public CategoryFeatureValue() {
    }

    public CategoryFeatureValue(int categoryFeatureValueid, Subcategory subcategory, FeatureValue featureValue) {
        this.categoryFeatureValueid = categoryFeatureValueid;
        this.subcategory = subcategory;
        this.featureValue = featureValue;
    }

    public int getCategoryFeatureValueid() {
        return categoryFeatureValueid;
    }

    public void setCategoryFeatureValueid(int categoryFeatureValueid) {
        this.categoryFeatureValueid = categoryFeatureValueid;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public FeatureValue getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(FeatureValue featureValue) {
        this.featureValue = featureValue;
    }
    
    
    
    
    
}
