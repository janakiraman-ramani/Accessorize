package com.datamodel;
// Generated Apr 2, 2017 5:14:33 PM by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Orderform  implements java.io.Serializable {


     private int orderformid;
     private Customer customer;
     private int total;
     private Serializable orderdate;
     private String status;
     private Set orderitems = new HashSet(0);
     private String paymethod;
     private String payment_id;
     private String payment_request_id;
     private String transaction_id;

    public Orderform() {
    }

	
    public Orderform(int orderformid, Customer customer, int total, Serializable orderdate, String status) {
        this.orderformid = orderformid;
        this.customer = customer;
        this.total = total;
        this.orderdate = orderdate;
        this.status = status;
    }
    public Orderform(int orderformid, Customer customer, int total, Serializable orderdate, String status, Set orderitems) {
       this.orderformid = orderformid;
       this.customer = customer;
       this.total = total;
       this.orderdate = orderdate;
       this.status = status;
       this.orderitems = orderitems;
    }
   
    public int getOrderformid() {
        return this.orderformid;
    }
    
    public void setOrderformid(int orderformid) {
        this.orderformid = orderformid;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    public Serializable getOrderdate() {
        return this.orderdate;
    }
    
    public void setOrderdate(Serializable orderdate) {
        this.orderdate = orderdate;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Set getOrderitems() {
        return this.orderitems;
    }
    
    public void setOrderitems(Set orderitems) {
        this.orderitems = orderitems;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_request_id() {
        return payment_request_id;
    }

    public void setPayment_request_id(String payment_request_id) {
        this.payment_request_id = payment_request_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }




}


