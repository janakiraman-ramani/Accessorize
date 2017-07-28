package com.action;


import com.datamodel.Product;
import com.datamodel.Orderform;
import com.datamodel.ProductPhoto;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import org.apache.struts2.interceptor.ServletRequestAware;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Admin_view extends ActionSupport implements ServletRequestAware
{
    private int orderformid;
    private String status;
    private int productid;
    private List<Product> all;
    private List<Orderform> orders;
    HttpServletRequest request;
    
   
    public String execute() throws Exception 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        all=(List<Product>)s.createCriteria(Product.class).list();
        return "success";
    }

    public String getProPic() throws Exception
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("image/jpg");
        ProductPhoto p=(ProductPhoto)s.createCriteria(ProductPhoto.class).add(Restrictions.eq("product.productid", productid)).uniqueResult();
        
        response.getOutputStream().write(p.getPhoto());
        response.getOutputStream().close();
        return SUCCESS;
    }
    
    public String getAllorders()
    {
    Session s=HibernateUtil.getSessionFactory().openSession();
    orders =(List<Orderform>)s.createCriteria(Orderform.class).addOrder(Order.desc("orderdate")).list();
    return "success";
    }
    
    public String updateStatus()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Orderform orderform=(Orderform)s.get(Orderform.class,orderformid);
        orderform.setStatus(status);
        s.save(orderform);
        s.beginTransaction().commit();
        
        orders =(List<Orderform>)s.createCriteria(Orderform.class).addOrder(Order.desc("orderdate")).list();
        
        return "success";
    }
    public void setAll(List<Product> all) {
        this.all = all;
    }
    
    public List<Product> getAll() {
        return all;
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

    public List<Orderform> getOrders() {
        return orders;
    }

    public void setOrders(List<Orderform> orders) {
        this.orders = orders;
    }

    public int getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(int orderformid) {
        this.orderformid = orderformid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
