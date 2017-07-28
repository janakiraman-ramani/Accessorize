package com.action;

import com.datamodel.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;

public class Admin_update1 extends ActionSupport implements ServletRequestAware
{
    private int productid;
    private String name;
    private String description;
    private int price;
    private int stock;
    HttpServletRequest request;
    
    public String updateProductfinal() throws Exception 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Product p=(Product)s.get(Product.class,productid);
        
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        p.setDescription(description);
        
        s.update(p);
        s.beginTransaction().commit();
        
        request.setAttribute("msg", "Book Successfully Updated");
        return "success";
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
