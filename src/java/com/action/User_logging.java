
package com.action;

import com.captcha.botdetect.web.servlet.Captcha;
import com.datamodel.Customer;
import com.datamodel.Wishlist;
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
import org.hibernate.criterion.Restrictions;

public class User_logging extends ActionSupport implements SessionAware,ServletRequestAware
{
    private int id;
    private String password;
    HttpServletRequest request;
    private String captchaCode;
    private SessionMap<String,Object> sessionMap;
    
    public String userLogin() throws Exception 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer admin=(Customer)s.get(Customer.class,id);
            if(admin!=null)
            {
                if(admin.getPassword().equals(password))
                {
                String name=admin.getName();
                String verified=admin.getVerified();
                sessionMap.put("id", id);
                sessionMap.put("name",name);
                sessionMap.put("verified",verified);
                return "success";
                }
                else
                {
                request.setAttribute("msg", "Password Doesn't Match");
                return "error";
                }
            }
            else
            {
	    request.setAttribute("msg", "User Doesn't Exist");
            return "error";
	    } 
         }
   
    
    
    public void setSession(Map<String, Object> map) 
    {
        sessionMap=(SessionMap)map;
    }

    public void setServletRequest(HttpServletRequest hsr) 
    
    {
        request=hsr;
    }
    public HttpServletRequest getServletRequest() {

        return this.request;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void validate() {
    Captcha captcha = Captcha.load(ServletActionContext.getRequest(), "exampleCaptcha");
    boolean isHuman = captcha.validate(captchaCode);
    if (!isHuman) {
      addFieldError("captchaCode", "Captcha Wrong");
    }
    
}

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }
}

