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
public class Feature 
{
    private int featureid;
    private String name;
    private Set featureValues = new HashSet(0);
    
    public Feature() {
    }

    public Feature(int featureid, String name) {
        this.featureid = featureid;
        this.name = name;
    }

    public Feature(int featureid, String name, Set featureValues) {
        this.featureid = featureid;
        this.name = name;
        this.featureValues=featureValues;
    }

    public int getFeatureid() {
        return featureid;
    }

    public void setFeatureid(int featureid) {
        this.featureid = featureid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getFeatureValues() {
        return featureValues;
    }

    public void setFeatureValues(Set featureValues) {
        this.featureValues = featureValues;
    }
    
    
}
