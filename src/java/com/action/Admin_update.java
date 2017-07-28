/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.datamodel.Colour;
import com.datamodel.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class Admin_update extends ActionSupport implements ServletRequestAware
{
    private int productid;
    private String name;
    private String description;
    private int subcategory1;
    private int price;
    private int stock;
    HttpServletRequest request;
    
    List<Product> listproduct;
    
    public String updateProduct() throws Exception 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        
        Product p=(Product)s.get(Product.class,productid);
        
        productid=p.getProductid();
        
        name=p.getName();
        
        description=p.getDescription();
        
        price=p.getPrice();
        
        stock=p.getStock();
        
        return "success";
    }
    
    
    
    public String getProduct() throws Exception 
    {
       Session s=HibernateUtil.getSessionFactory().openSession();
       
       listproduct =(List<Product>)s.createCriteria(Product.class).add(Restrictions.eq("subcategory1.subcategory1id",subcategory1)).list(); 
       
       return "success";
    }

    public int getProductid()
    {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public List<Product> getListproduct() {
        return listproduct;
    }

    public void setListproduct(List<Product> listproduct) {
        this.listproduct = listproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubcategory1() {
        return subcategory1;
    }

    public void setSubcategory1(int subcategory1) {
        this.subcategory1 = subcategory1;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setServletRequest(HttpServletRequest hsr) 
    {
        request=hsr;
        }
    
}
