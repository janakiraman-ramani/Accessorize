
package com.action;

import com.datamodel.Category;
import com.datamodel.Colour;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class LogingEx extends ActionSupport 
{
   
    public LogingEx() 
    {
    }
    public String userlogin()
    {
        return "userlogin";
    }
    public String userregister()
    {
        return "userregister";
    }
    public String adminhome()
    {
        return "adminhome";
    }
    public String admindelete()
    {
        return "admindelete";
    }
    public String adminupdate()
    {
        return "adminupdate";
    }
    public String admininsert()
    {
       
        
        return "admininsert";
    }
    public String adminview()
    {
        return "adminview";
    }
    public String adminlogin()
    {
        return "adminlogin";
    }
    public String showcart()
    {
        return "showcart";
    }
    public String userhome1()
    {
        return "userhome1";
    }
    public String userhome()
    {
        return "userhome";
    }
    public String checkout()
    {
        return "checkout";
    }
    public String verifyuser()
    {
        return "verifyuser";
    }
    public String checkpay()
    {
        return "checkpay";
    }
    public String feedback()
    {
        return "feedback";
    }
    public String forgot()
    {
        
        return "forgot";
    }

}
