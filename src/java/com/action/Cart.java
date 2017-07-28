
package com.action;

import com.datamodel.Product;
import com.datamodel.Wishlist;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class Cart extends ActionSupport implements SessionAware,ServletRequestAware
{
    private Map<Product, Integer> items;
    private int productid;
    private SessionMap session;
    private String targetUrl;
    HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    private String backurl = request.getHeader("referer");
    public String execute() throws Exception 
    {
        CartMain cart = (CartMain) session.get("mycart1");
        if (cart == null) 
        {
            cart = new CartMain();
        }
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        
        Product p = (Product)s.get(Product.class,productid);
        if (p.getProductid()== 0) 
        {
            return ERROR;
        }
        cart.addProduct(p);
        
        session.put("mycart1", cart);
        
        return SUCCESS;
        
    }
    
    public String stockCheck()
    {
        CartMain cart = (CartMain)session.get("mycart1");
        items=cart.getProducts();
        Set<Product> keys = items.keySet();
        
        for (Product product : keys)
        {
            int quantity = items.get(product);
            int stock= product.getStock();
            
            if(quantity>stock)
            {
                String name=product.getName();
                request.setAttribute("na","Quantity ordered not in Stock : "+name);
                return "error";
            }
        }
        return "success";
    }
    public String addfromwish() throws Exception
    {
        CartMain cart = (CartMain) session.get("mycart1");
        if (cart == null) 
        {
            cart = new CartMain();
        }
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        
        Product p = (Product)s.get(Product.class,productid);
        if (p.getProductid()== 0) 
        {
            return ERROR;
        }
        
        cart.addProduct(p);
        session.put("mycart1", cart);
        return "success";
    }
    public String deletecart() throws Exception 
    {
        
        CartMain cart = (CartMain) session.get("mycart1");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Product p = (Product)s.get(Product.class,productid);
        cart.deleteProduct(p);
        if(cart.getProducts().isEmpty())
        {
            session.remove("mycart1");
        }
        return "success";
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
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

  public void setServletRequest(HttpServletRequest hsr) {
        request=hsr;
    }
     public Map<Product, Integer> getItems() {
        return items;
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }
     
     
}
