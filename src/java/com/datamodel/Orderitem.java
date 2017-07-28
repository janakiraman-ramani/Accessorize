package com.datamodel;

public class Orderitem  implements java.io.Serializable {


     private int orderitemid;
     private Product product;
     private Orderform orderform;
     private int quantity;

    public Orderitem() {
    }

    public Orderitem(int orderitemid, Product product, Orderform orderform, int quantity) {
       this.orderitemid = orderitemid;
       this.product = product;
       this.orderform = orderform;
       this.quantity = quantity;
    }
   
    public int getOrderitemid() {
        return this.orderitemid;
    }
    
    public void setOrderitemid(int orderitemid) {
        this.orderitemid = orderitemid;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Orderform getOrderform() {
        return this.orderform;
    }
    
    public void setOrderform(Orderform orderform) {
        this.orderform = orderform;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}


