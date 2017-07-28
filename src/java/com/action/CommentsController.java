
package com.action;

import com.datamodel.Comments;
import com.datamodel.Customer;
import com.datamodel.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CommentsController extends ActionSupport implements SessionAware
{
    private int productid;
    private String title;
    private String body;
    private float rating;
    private SessionMap session;
    private String targetUrl;
    private Product productdetail;
    private List<Comments> comments;
    private float avg;
    
    public String setComment()
    {
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        Integer uid=(Integer)session.get("id");
        Customer customer=(Customer)s.get(Customer.class,uid);
        
        Product product=(Product)s.get(Product.class,productid);
        
        Calendar calendar = Calendar.getInstance();
        Timestamp current = new Timestamp(calendar.getTime().getTime());
        Comments comment=new Comments();
        
        productdetail = (Product)s.get(Product.class,productid);
        comments=(List <Comments>)s.createCriteria(Comments.class)
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
        
        comment.setTitle(title);
        comment.setBody(body);
        comment.setCustomer(customer);
        comment.setRating(rating);
        comment.setCommenttime(current);
        comment.setProduct(product);
        s.save(comment);
        s.beginTransaction().commit();
        targetUrl="http://localhost:8084/Accessorize/productdetail?productid="+productid;
        
        
        return "success";
    }
    
    public void validate()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        productdetail = (Product)s.get(Product.class,productid);
        comments=(List <Comments>)s.createCriteria(Comments.class)
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
        
        if (title == null || title.trim().equals(""))
      {
         addFieldError("title","The name is required");
      }
        if (body == null || body.trim().equals(""))
      {
         addFieldError("body","The body is required");
      }
        
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
            public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }
            
             public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
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
