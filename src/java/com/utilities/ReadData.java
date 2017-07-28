package com.utilities;

import com.datamodel.Category;
import com.datamodel.Colour;
import com.datamodel.Subcategory;
import com.datamodel.Subcategory1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ReadData extends ActionSupport 

{

    private List<Category> categorylist;
    private List<Subcategory> subcategorylist;
    private List<Subcategory1> subcategory1list;
    private List<Colour> colourlist;

    private int category1;
    private int subcategory;
    private int subcategory1;

     public String execute() 
     {
        
        Session s=HibernateUtil.getSessionFactory().openSession();
         
        categorylist=(List<Category>)s.createCriteria(Category.class).list();
        colourlist=(List<Colour>)s.createCriteria(Colour.class).list();
        
        if(category1 != 0)
        {
            subcategorylist=(List<Subcategory>)s.createCriteria(Subcategory.class)
                                                .add(Restrictions.eq("category.categoryid", category1)).list();
        } 

        if(category1 != 0 && subcategory != 0)
        {
            subcategory1list=(List<Subcategory1>)s.createCriteria(Subcategory1.class).add(Restrictions.eq("subcategory.subcategoryid", subcategory)).list();
        } 

        return SUCCESS;
    }

    public String getJSON() {
        return execute();
    }

    public List<Category> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<Category> categorylist) {
        this.categorylist = categorylist;
    }

    public List<Subcategory> getSubcategorylist() {
        return subcategorylist;
    }

    public void setSubcategorylist(List<Subcategory> subcategorylist) {
        this.subcategorylist = subcategorylist;
    }

    public List<Subcategory1> getSubcategory1list() {
        return subcategory1list;
    }

    public void setSubcategory1list(List<Subcategory1> subcategory1list) {
        this.subcategory1list = subcategory1list;
    }

    public int getCategory1() {
        return category1;
    }

    public void setCategory1(int category1) {
        this.category1 = category1;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public int getSubcategory1() {
        return subcategory1;
    }

    public void setSubcategory1(int subcategory1) {
        this.subcategory1 = subcategory1;
    }

    public List<Colour> getColourlist() {
        return colourlist;
    }

    public void setColourlist(List<Colour> colourlist) {
        this.colourlist = colourlist;
    }

    

    public String index() {
        return "success";
    }
}