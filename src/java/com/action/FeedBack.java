/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.datamodel.Feedback;
import com.utilities.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author RJVIRUS
 */
public class FeedBack 
{
    private String name;
    private String email;
    private String comments;

    public String execute()
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        FeedBack fb=new FeedBack();
        fb.setName(name);
        fb.setEmail(email);
        fb.setComments(comments);
        
        s.save(fb);
        s.beginTransaction().commit();
        
        return "success";
        
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
}
