/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.datamodel.Product;
import com.datamodel.Customer;
import com.datamodel.Wishlist;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author RJVIRUS
 */
public class WishList extends ActionSupport implements SessionAware,ServletRequestAware
{
    private int productid;
    private int wishlistid;
    private SessionMap<String,Object> sessionMap;
    List<Wishlist> wishlist=null;
    private String targetUrl;
    HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    private String backurl = request.getHeader("referer");
    
    public String execute()
    {
        int userid=(Integer)sessionMap.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        
        wishlist=(List<Wishlist>)s.createCriteria(Wishlist.class)
                .add(Restrictions.eq("customer.userid", userid)).list();
        
        return "success";
    }
    
    public String addWishlist()
    {
        Integer userid=(Integer)sessionMap.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class, userid);
        Product product=(Product)s.get(Product.class,productid);
        Wishlist wish= new Wishlist();
        
        wish.setProduct(product);
        wish.setCustomer(customer);
        
        s.save(wish);
        s.beginTransaction().commit();
        
        targetUrl="http://localhost:8084/Online_Book_Store/productdetail?bookid="+productid;
        
        return "success";
    }
    
    public String removeWishlist()
    {
        Integer userid=(Integer)sessionMap.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Wishlist wish=(Wishlist)s.get(Wishlist.class, wishlistid);
        s.delete(wish);
        s.beginTransaction().commit();
        
        wishlist=(List<Wishlist>)s.createCriteria(Wishlist.class).add(Restrictions.eq("customer.userid", userid)).list();
        
        return "success";
    }

    public void setServletRequest(HttpServletRequest hsr) 
    {
        request=hsr;
    }

    public void setSession(Map<String, Object> map)
    {
        sessionMap=(SessionMap)map;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public List<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }

    public int getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(int wishlistid) {
        this.wishlistid = wishlistid;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }
    
    
}
