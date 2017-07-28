/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.datamodel.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


public class ViewCart extends ActionSupport implements SessionAware 
{
    
    private Map<Product, Integer> items;
    private float total;
    private SessionMap session;
    @Override
    
    public String execute() throws Exception 
    {
        
        CartMain cart = (CartMain) session.get("mycart1");
        if(cart==null) 
        {
            return ERROR;
        }
        
        items = cart.getProducts();
        total = cart.getTotalPrice();
        return SUCCESS;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public float getTotal() {
        return total;
    }

    public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }

    
}
