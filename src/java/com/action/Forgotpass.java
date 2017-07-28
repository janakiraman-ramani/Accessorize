/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.datamodel.Customer;
import com.utilities.HibernateUtil;
import com.utilities.SendEmail;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Forgotpass 
{
    private String email;

    public String execute()
    {
        
       Session s=HibernateUtil.getSessionFactory().openSession();
       
       Customer customer=(Customer)s.createCriteria(Customer.class).add(Restrictions.eq("customer.email", email))
                                    .uniqueResult();
       int userid=customer.getUserid();
       String password=customer.getPassword();
       String newStr = "Your User ID - "+userid+ "\nYour Password :"+password ;
       SendEmail.sendIdPass(email, newStr);
       return "success";
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
