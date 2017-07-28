
package com.datamodel;



public class Subcategory 
{
    
    private int subcategoryid;
    private String name;
    private Category category;
    private byte[] photo;

    public Subcategory() {
    }

    public Subcategory(int subcategoryid, String name, Category category, byte[] photo) {
        this.subcategoryid = subcategoryid;
        this.name = name;
        this.category = category;
        this.photo = photo;
    }

    public int getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(int subcategoryid) {
        this.subcategoryid = subcategoryid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    
}
