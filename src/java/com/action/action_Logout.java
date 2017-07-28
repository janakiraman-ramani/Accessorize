/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author admin
 */
public class action_Logout extends ActionSupport implements SessionAware
{
    
    private SessionMap<String,Object> sessionMap;
    
    public String logOut() throws Exception
    {
        sessionMap.remove("adminid");
        sessionMap.remove("name");
        return "success";
    }
    public String logOut1() throws Exception
    {
        sessionMap.remove("id");
        sessionMap.remove("name");
        sessionMap.remove("mycart1");
        sessionMap.remove("verified");
        return "success";
    }

    public void setSession(Map<String, Object> map) 
    {
        sessionMap=(SessionMap)map;
    }
    
    
}
