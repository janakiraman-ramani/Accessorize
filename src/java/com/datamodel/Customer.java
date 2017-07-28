package com.datamodel;
import java.util.HashSet;
import java.util.Set;

public class Customer  implements java.io.Serializable {


     private int userid;
     private String name;
     private String address;
     private String city;
     private String phone;
     private String password;
     private String email;
     private Integer otp;
     private String verified;
     private Set commentses = new HashSet(0);
     private Set wishlists = new HashSet(0);
     private Set orderforms = new HashSet(0);

    public Customer() {
    }

	
    public Customer(int userid, String name, String address, String city, String phone, String password, String email, Integer otp, String verified) {
        this.userid = userid;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.otp=otp;
        this.verified=verified;
    }
    public Customer(int userid, String name, String address, String city, String phone, String password, String email, Integer otp, String verified, Set commentses, Set wishlists, Set orderforms) {
       this.userid = userid;
       this.name = name;
       this.address = address;
       this.city = city;
       this.phone = phone;
       this.password = password;
       this.email = email;
       this.otp=otp;
       this.verified=verified;
       this.commentses = commentses;
       this.wishlists = wishlists;
       this.orderforms = orderforms;
    }
   
    public int getUserid() {
        return this.userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }
    
    public Set getCommentses() {
        return this.commentses;
    }
    
    public void setCommentses(Set commentses) {
        this.commentses = commentses;
    }
    public Set getWishlists() {
        return this.wishlists;
    }
    
    public void setWishlists(Set wishlists) {
        this.wishlists = wishlists;
    }
    public Set getOrderforms() {
        return this.orderforms;
    }
    
    public void setOrderforms(Set orderforms) {
        this.orderforms = orderforms;
    }

    




}


