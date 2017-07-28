
package com.datamodel;

public class ProductPhoto 
{
    private int productPhotoid;
    private byte[] photo;
    private Product product;

    public ProductPhoto() {
    }

    public ProductPhoto(int productPhotoid, byte[] photo, Product product) {
        this.productPhotoid = productPhotoid;
        this.photo = photo;
        this.product = product;
    }

    public int getProductPhotoid() {
        return productPhotoid;
    }

    public void setProductPhotoid(int productPhotoid) {
        this.productPhotoid = productPhotoid;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
