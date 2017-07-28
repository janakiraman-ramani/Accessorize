
package com.action;

import com.datamodel.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import com.utilities.SendEmail;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;


public class SendOTP extends ActionSupport implements SessionAware,ServletRequestAware
{
    private Integer otpfinal;
    private SessionMap session;
    HttpServletRequest request;
    
    
    public String execute()
    {
        Integer uid=(Integer)session.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class,uid);
        String mail=customer.getEmail();
        Integer otp=SendEmail.generateOTP();
        customer.setOtp(otp);
        s.saveOrUpdate(customer);
        s.beginTransaction().commit();
        SendEmail.sendEmail(mail, Integer.toString(otp));
        request.setAttribute("msg", "OTP Successfully sent to "+mail);
        return "success";
    }
    
    public String verifyUser()
    {
        Integer uid=(Integer)session.get("id");
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer customer=(Customer)s.get(Customer.class,uid);
        Integer otpdb=customer.getOtp();
        if(otpfinal.equals(otpdb))
        {
            customer.setVerified("yes");
            session.put("verified", "yes");
            s.saveOrUpdate(customer);
            s.beginTransaction().commit();

        return "success";
        }
        else
        {
            request.setAttribute("msg", "Incorrect OTP Entered");
            return "error";
        }
        
        
    }
    public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }
    public void setServletRequest(HttpServletRequest hsr) 
    
    {
        request=hsr;
    }

    public Integer getOtpfinal() {
        return otpfinal;
    }

    public void setOtpfinal(Integer otpfinal) {
        this.otpfinal = otpfinal;
    }
    
    
}


