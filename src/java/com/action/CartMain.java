
package com.action;

import com.datamodel.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CartMain 
{
    private final Map<Product, Integer> cart=new HashMap<Product, Integer>();
    public CartMain()
    {
        
    }
    public void addProduct(Product p)
    {
        Integer amount = cart.get(p);
        if(amount!=null)
        {
            amount=amount+1;
            cart.put(p,amount);
        } 
        else
        {
            cart.put(p,1);
        }
    }
    public void deleteProduct(Product p)
    {
        cart.remove(p);
    }
    
    public Map<Product, Integer> getProducts() 
    {
        return cart;
    }

    public float getTotalPrice() 
    {
        float total = 0;
        Set<Product> keys = cart.keySet();
        for (Product product : keys) 
        {
            total += product.getPrice() * cart.get(product);
        }
        return total;
    }
}
