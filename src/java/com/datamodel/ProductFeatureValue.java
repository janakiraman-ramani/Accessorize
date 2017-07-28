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
public class ProductFeatureValue 
{
    private int productFeatureValueid;
    private Product product;
    private FeatureValue featurevalue;

    public ProductFeatureValue() {
    }

    public ProductFeatureValue(int productFeatureValueid, Product product, FeatureValue featurevalue) {
        this.productFeatureValueid = productFeatureValueid;
        this.product = product;
        this.featurevalue = featurevalue;
    }

    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public FeatureValue getFeaturevalue() {
        return featurevalue;
    }

    public void setFeaturevalue(FeatureValue featurevalue) {
        this.featurevalue = featurevalue;
    }
    
    
}
