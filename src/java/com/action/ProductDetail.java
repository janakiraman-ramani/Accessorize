/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.datamodel.Comments;
import com.datamodel.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author RJVIRUS
 */
public class ProductDetail extends ActionSupport implements ServletRequestAware
{
    private int productid;
    HttpServletRequest request;
    private Product productdetail;
    List<Comments> comments=null;
    private float avg;
    
    public String getProductDetail()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        productdetail = (Product)s.get(Product.class,productid);
        
        comments=(List <Comments>)s.createCriteria(Comments.class).createAlias("product","p")
                                .add(Restrictions.eq("product.productid", productid))
                                .addOrder(Order.desc("commenttime")).list();
        
        int n=0;
        float totalrating=0;
        
        for(Comments c : comments)
        {
           totalrating=totalrating+c.getRating();
           n++ ;
        }
        
        avg=totalrating/n;
        
        return "success";
    }

 public void setServletRequest(HttpServletRequest hsr) 
    {
        request=hsr;
    }


    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public Product getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(Product productdetail) {
        this.productdetail = productdetail;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

}
