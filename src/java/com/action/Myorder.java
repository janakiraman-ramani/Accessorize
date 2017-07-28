
package com.action;

import com.datamodel.Orderform;
import com.datamodel.Orderitem;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Myorder extends ActionSupport implements SessionAware
{
    
    private SessionMap session;
    private List <Orderform> myorder=null;
    
    public String execute()
    {
    Integer uid=(Integer)session.get("id");
    Session s=HibernateUtil.getSessionFactory().openSession();
    myorder = (List<Orderform>)s.createCriteria(Orderform.class).createAlias("customer","c")
                                .add(Restrictions.eq("customer.userid", uid))
                                .addOrder(Order.desc("orderdate")).list();
    

    
    return "success";
    }
    
    public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }

    public List<Orderform> getMyorder() {
        return myorder;
    }

    public void setMyorder(List<Orderform> myorder) {
        this.myorder = myorder;
    }
    
}
