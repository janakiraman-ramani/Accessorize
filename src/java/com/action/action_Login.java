
package com.action;
import com.utilities.HibernateUtil;
import com.datamodel.Admin;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

public class action_Login extends ActionSupport implements SessionAware,ServletRequestAware
{
    private int id;
    private String password;
    HttpServletRequest request;
    private SessionMap<String,Object> sessionMap;

    public String adminLogin() throws Exception 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        
        Admin admin=(Admin)s.get(Admin.class,id);
        
        if(admin!=null)
        {
            if(admin.getPassword().equals(password))
            {
                String name=admin.getName();
                sessionMap.put("adminid", id);
                sessionMap.put("adminname",name);
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
    
}
