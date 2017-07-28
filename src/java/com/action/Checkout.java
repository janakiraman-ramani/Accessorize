package com.action;

import java.util.Date;
import com.datamodel.Customer;
import com.datamodel.Orderitem;
import com.datamodel.Orderform;
import com.datamodel.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Checkout extends ActionSupport implements SessionAware,ServletRequestAware
{
     private Map<Product, Integer> items;
     private SessionMap session;
     HttpServletRequest request;
     private String payment_id;
     private String id;
     private String transaction_id;
     private String paymethod;
     
     public String checkpaymethod()
     {
         if(paymethod.equals("Cash on Delivery"))
         {
             return "cod";
         }
         
             return "instamojo";
             
     }
    public String cod()
    {
        Orderform form=new Orderform();
        Integer uid=(Integer)session.get("id");
        CartMain cart = (CartMain)session.get("mycart1");
        items=cart.getProducts();
        int gross=Math.round(cart.getTotalPrice());
        Calendar calendar = Calendar.getInstance();
        Timestamp current = new Timestamp(calendar.getTime().getTime());
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class,uid);
        Transaction transaction= s.beginTransaction();
        form.setCustomer(customer);
        form.setTotal(gross);
        form.setOrderdate(current);
        form.setStatus("Order Received");
        form.setPaymethod("Cash on Delivery");
        Integer newformid = (Integer)s.save(form);
        Orderform newform=(Orderform)s.get(Orderform.class, newformid);
        Set<Product> keys = items.keySet();
        for (Product product : keys)
        {
            int quantity = items.get(product);
            int stock= product.getStock();
            int productid=product.getProductid();
            int newstock = stock-quantity;
            Product p=(Product)s.get(Product.class, productid);
            Orderitem item=new Orderitem();
            p.setStock(newstock);
            s.update(p);
            item.setProduct(product);
            item.setOrderform(newform);
            item.setQuantity(quantity);
            s.save(item);
            s.flush();
            transaction.commit();
            }
        s.close();
        session.remove("mycart1");
        return "success";
    }
    
    public String execute() throws Exception 
    {
        Orderform form=new Orderform();
        Integer uid=(Integer)session.get("id");
        
        CartMain cart = (CartMain)session.get("mycart1");
        
        items=cart.getProducts();
        
        int gross=Math.round(cart.getTotalPrice());
        Calendar calendar = Calendar.getInstance();
        Timestamp current = new Timestamp(calendar.getTime().getTime());
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class,uid);
        Transaction transaction= s.beginTransaction();
        form.setCustomer(customer);
        form.setTotal(gross);
        form.setOrderdate(current);
        form.setStatus("Order Received");
        form.setPaymethod("Online Payment");
        form.setPayment_id(payment_id);
        form.setPayment_request_id(id);
        form.setTransaction_id(transaction_id);
        Integer newformid = (Integer)s.save(form);
        Orderform newform=(Orderform)s.get(Orderform.class, newformid);
        Set<Product> keys = items.keySet();
        for (Product product : keys)
        {
            int quantity = items.get(product);
            int stock= product.getStock();
            int productid=product.getProductid();
            int newstock = stock-quantity;
            Product p=(Product)s.get(Product.class, productid);
            Orderitem item=new Orderitem();
            p.setStock(newstock);
            s.update(p);
            item.setProduct(product);
            item.setOrderform(newform);
            item.setQuantity(quantity);
            s.save(item);
            s.flush();
            transaction.commit();
            }
        s.close();
        session.remove("mycart1");
        return "success";
    }

    
    public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }

  public void setServletRequest(HttpServletRequest hsr) {
        request=hsr;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }


  
  
}
