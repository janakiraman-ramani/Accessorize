/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.datamodel.Product;
import com.datamodel.Subcategory1;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class Admin_delete extends ActionSupport implements ServletRequestAware,SessionAware
{
    
    private int productid;
    private List<Product> listproduct=null;
    private SessionMap<String,Object> sessionMap;
    HttpServletRequest request;

    public String deleteProduct() throws Exception 
    {
       
       Session s=HibernateUtil.getSessionFactory().openSession();
       Product p=(Product)s.get(Product.class,productid);
       Subcategory1 subcategory1 =p.getSubcategory1();
       int cat=subcategory1.getSubcategory1id();
       s.delete(p);
       s.beginTransaction().commit();
       if(sessionMap.get("products")!=null)
        {
        listproduct =(List<Product>)s.createCriteria(Product.class).add(Restrictions.eq("subcategory1.subcategory1id", cat)).list(); 
        sessionMap.remove("products");
        sessionMap.put("products", listproduct);
        }
        else
        {
          listproduct =(List<Product>)s.createCriteria(Product.class).add(Restrictions.eq("subcategory1.subcategory1id", cat)).list();
          sessionMap.put("products", listproduct);
        }
       request.setAttribute("msg", "Product Successfully Deleted ");
       return "success";
       
    }
    
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
public void setServletRequest(HttpServletRequest hsr) 
    {
        request=hsr;
    }

    public void setSession(Map<String, Object> map)
    {
        sessionMap=(SessionMap)map;
    }
}
