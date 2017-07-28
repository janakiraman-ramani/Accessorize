
package com.action;

import com.datamodel.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;


public class Myprofile extends ActionSupport implements ServletRequestAware,SessionAware
{
    private String name;
    private String address;
    private String city;
    private String phone; 
    private String email; 
    private String password;
    private SessionMap session;
    HttpServletRequest request;
    
    public String execute()
    {
        Integer userid=(Integer)session.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class,userid);
        
        name=customer.getName();
        address=customer.getAddress();
        city=customer.getCity();
        phone=customer.getPhone();
        email=customer.getEmail();
    
    return "success";
}   
    public String myProfile1()
    {
        Integer userid=(Integer)session.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class,userid);
        
        name=customer.getName();
        address=customer.getAddress();
        city=customer.getCity();
        phone=customer.getPhone();
        email=customer.getEmail();
        password=customer.getPassword();
        return "success";
    }
    
    public String updateProfile()
            
    {
        Integer userid=(Integer)session.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class,userid);
        String oldmail=customer.getEmail();
        
            customer.setName(name);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setPassword(password);
            customer.setPhone(phone);
            if(email.equals(oldmail))
            {
            customer.setEmail(email);
            }
            else
            {
                customer.setEmail(email);
                customer.setVerified("no");
                session.put("verified", "no");
            }
            s.saveOrUpdate(customer);
            s.beginTransaction().commit();
        return "success";
    }

    public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }

  public void setServletRequest(HttpServletRequest hsr) {
        request=hsr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
   
}
