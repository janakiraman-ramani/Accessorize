package com.action;

import com.captcha.botdetect.web.servlet.Captcha;
import com.datamodel.Customer;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

public class User_register extends ActionSupport implements ServletRequestAware,SessionAware
{
    private String username;
    private String email;
    private String password;
    private String repassword;
    private String address;
    private String city;
    private String phone;
    private String captchaCode;
    private SessionMap session;
    HttpServletRequest request;
    
     public String execute() throws Exception
    {
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        Customer user=new Customer();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setCity(city);
        user.setPhone(phone);
        user.setVerified("no");
        Integer cid=(Integer)s.save(user);
        s.beginTransaction().commit();
        
       
        session.put("id", cid);
        request.setAttribute("new_id", cid);
        request.setAttribute("new_name",username);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setServletRequest(HttpServletRequest hsr) 
    {
        request=hsr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void validate() 
    {
    Captcha captcha = Captcha.load(ServletActionContext.getRequest(), "exampleCaptcha");
    boolean isHuman = captcha.validate(captchaCode);
    if (!isHuman) {
      addFieldError("captchaCode", "Captcha Wrong");
    }
    }
public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }
    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
     
}
