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
public class FeatureValue 
{
    private int featureValueid;
    private Feature features;
    private String name;
    private Set productFeatureValues = new HashSet(0);
    private Set categoryFeatureValues = new HashSet(0);

    public FeatureValue() {
    }

    public FeatureValue(int featureValueid, Feature features, String name) {
        this.featureValueid = featureValueid;
        this.features = features;
        this.name = name;
    }
    public FeatureValue(int featureValueid, Feature features, String name, Set productFeatureValues, Set categoryFeatureValues) 
    {
        this.featureValueid = featureValueid;
        this.features = features;
        this.name = name;
        this.productFeatureValues=productFeatureValues;
        this.categoryFeatureValues=categoryFeatureValues;
    }
    public int getFeatureValueid() {
        return featureValueid;
    }

    public void setFeatureValueid(int featureValueid) {
        this.featureValueid = featureValueid;
    }

    public Feature getFeatures() {
        return features;
    }

    public void setFeatures(Feature features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getProductFeatureValues() {
        return productFeatureValues;
    }

    public void setProductFeatureValues(Set productFeatureValues) {
        this.productFeatureValues = productFeatureValues;
    }

    public Set getCategoryFeatureValues() {
        return categoryFeatureValues;
    }

    public void setCategoryFeatureValues(Set categoryFeatureValues) {
        this.categoryFeatureValues = categoryFeatureValues;
    }
    
    
}
