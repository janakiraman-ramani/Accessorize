
package com.action;

import com.datamodel.Colour;
import com.datamodel.Product;
import com.datamodel.ProductPhoto;
import com.datamodel.Subcategory1;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;

public class action_ProductCRUD extends ActionSupport implements ServletRequestAware
{
    private String name;
    private String brand;
    private int subcategory1;
    private String description;
    private int price;
    private int stock;
    private int colour;
    private File photo;
    private String photoFileName;
    private String photoContentType;
    
    HttpServletRequest request;
    
    public String execute() throws Exception 
    {
        String path=request.getSession().getServletContext().getRealPath("/images");
        File f=new File(path, photoFileName);    
        FileUtils.copyFile(photo, f);
        byte[] bs=new byte[(int)f.length()];
        FileInputStream fis=new FileInputStream(f);
        fis.read(bs);
        fis.close();  
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        Product p=new Product();
        
        Subcategory1 subcat1=(Subcategory1)s.get(Subcategory1.class, subcategory1);
        Colour color=(Colour)s.get(Colour.class, colour);
        p.setName(name);
        p.setBrand(brand);
        p.setSubcategory1(subcat1);
        p.setColour(color);
        p.setPrice(price);
        p.setStock(stock);
        p.setDescription(description);
        
        Integer productid=(Integer) s.save(p);
        
        ProductPhoto picture=new ProductPhoto();
        
        picture.setProduct(p);
        picture.setPhoto(bs);
        s.save(picture);
        
        
        s.beginTransaction().commit();
        request.setAttribute("productid", productid);
        
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSubcategory1() {
        return subcategory1;
    }

    public void setSubcategory1(int subcategory1) {
        this.subcategory1 = subcategory1;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

   
    public void setServletRequest(HttpServletRequest hsr) {
        request=hsr;
    }
   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

}
