package com.datamodel;
// Generated Apr 2, 2017 5:14:33 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;
import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.NGramFilterFactory;
import org.apache.solr.analysis.SnowballPorterFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.apache.solr.analysis.StopFilterFactory;
import org.hibernate.search.annotations.Analyzer;

@Indexed
public class Product  implements java.io.Serializable 
{
     @DocumentId
     @AnalyzerDef(name = "customanalyzer",tokenizer =@TokenizerDef(factory = StandardTokenizerFactory.class),
    filters = {
    @TokenFilterDef(factory = LowerCaseFilterFactory.class),
    @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
	@Parameter(name = "language", value = "English")
    })
    })
     private int productid;
     @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
     private String name;
     @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
     private String brand;
     private Subcategory1 subcategory1;
     private int price;
     private int stock;
     @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
     private String description;
     private Colour colour;
     private byte[] photo;
     private Set orderitems = new HashSet(0);
     private Set wishlists = new HashSet(0);
     private Set commentses = new HashSet(0);
     private Set productPhotos = new HashSet(0);

    @Override
    public String toString() {
        return "Product{" + "productid=" + productid + ", name=" + name + ", brand=" + brand + ", description=" + description + '}';
    }
     
   
   
    
     
     public Product() {
    }

	
    public Product(int productid, String title, String name, String brand, Subcategory1 subcategory1, Colour colour, int price, int stock, String description) {
        this.productid = productid;
        this.name = name;
        this.brand = brand;
        this.subcategory1 = subcategory1;
        this.price = price;
        this.colour=colour;
        this.stock = stock;
        this.description = description;
        
    }
    public Product(int productid, String name, String brand, Subcategory1 subcategory1, int price, int stock,Colour colour, String description, byte[] photo, Set orderitems, Set wishlists, Set commentses, Set productPhotos) {
       this.productid = productid;
       this.name = name;
       this.brand = brand;
       this.subcategory1 = subcategory1;
       this.price = price;
       this.stock = stock;
       this.colour=colour;
       this.description = description;
       this.photo = photo;
       this.orderitems = orderitems;
       this.wishlists = wishlists;
       this.commentses = commentses;
       this.productPhotos=productPhotos;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Subcategory1 getSubcategory1() {
        return subcategory1;
    }

    public void setSubcategory1(Subcategory1 subcategory1) {
        this.subcategory1 = subcategory1;
    }
    
    
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public byte[] getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public Set getOrderitems() {
        return this.orderitems;
    }
    
    public void setOrderitems(Set orderitems) {
        this.orderitems = orderitems;
    }
    public Set getWishlists() {
        return this.wishlists;
    }
    
    public void setWishlists(Set wishlists) {
        this.wishlists = wishlists;
    }
    public Set getCommentses() {
        return this.commentses;
    }
    
    public void setCommentses(Set commentses) {
        this.commentses = commentses;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

     @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;

        return this.productid == other.productid;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.productid;
        return hash;
    }


    public Set getProductPhotos() {
        return productPhotos;
    }

    public void setProductPhotos(Set productPhotos) {
        this.productPhotos = productPhotos;
    }
   
    


}


