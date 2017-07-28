
package com.action;

import com.datamodel.Product;
import com.datamodel.Comments;
import com.datamodel.Orderform;
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Utility extends ActionSupport implements ServletRequestAware,SessionAware
{
    private int productid;
    private String category;
    private int subcategory1;
    private SessionMap<String,Object> sessionMap;
    private List<Product> listproduct=null;
    List<Wishlist> wishlist;
    private Product productdetail;
    List<Comments> comments=null;
    private float avg;
    HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    String backurl = request.getHeader("referer");
    
   
    public String getProduct() throws Exception 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        if(sessionMap.get("products")!=null)
        {
        listproduct =(List<Product>)s.createCriteria(Product.class).add(Restrictions.eq("subcategory1.subcategory1id", subcategory1)).list(); 
        sessionMap.remove("products");
        sessionMap.put("products", listproduct);
        }
        else
        {
          listproduct =(List<Product>)s.createCriteria(Product.class).add(Restrictions.eq("subcategory1.subcategory1id", subcategory1)).list();
          sessionMap.put("products", listproduct);
        }
        return "success";
    }

 
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setServletRequest(HttpServletRequest hsr) 
    {
        request=hsr;
    }

    public void setSession(Map<String, Object> map)
    {
        sessionMap=(SessionMap)map;
    }

    public List<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wishlist> wishlist) {
        this.wishlist = wishlist;
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

    public int getSubcategory1() {
        return subcategory1;
    }

    public void setSubcategory1(int subcategory1) {
        this.subcategory1 = subcategory1;
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

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }
    
}
