
package com.action;

import com.datamodel.Product;
import com.datamodel.Subcategory1;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.search.Search;

public class Searchtext extends ActionSupport implements ServletRequestAware,SessionAware
{
    private String searchtext;
    List<Product> searchresult;
    private SessionMap<String,Object> sessionMap;
    HttpServletRequest request;
    
    public String execute()
    {
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        
        try
        {
        
        FullTextSession fullTextSession = Search.getFullTextSession(s);
        fullTextSession.createIndexer().startAndWait();
        Transaction tx = fullTextSession.beginTransaction();
        final QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
        org.apache.lucene.search.Query query = qb.keyword().onFields("name","brand","description").matching(searchtext).createQuery();
         // wrap Lucene query in a org.hibernate.Query
        org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query,Product.class);
        // execute search
        
        searchresult =(List<Product>) hibQuery.list();
        
        tx.commit();
        
        fullTextSession.close();
        }
        catch (Exception e) {
        }
        
        if(searchresult==null || searchresult.isEmpty())
        {
            return "error";
        }
        
        sessionMap.put("searchresult", searchresult);
        return "success";
        
    }

    public String getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }

    public void setSession(Map<String, Object> map)
    {
        sessionMap=(SessionMap)map;
    }

    public List<Product> getSearchresult() {
        return searchresult;
    }

    public void setSearchresult(List<Product> searchresult) {
        this.searchresult = searchresult;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    public void setServletRequest(HttpServletRequest hsr) 
    {
        request=hsr;
    }
    
      
}
