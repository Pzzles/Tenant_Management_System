/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.bean;

import java.sql.Timestamp;

/**
 *
 * @author PULE
 */
public class Payment {

    private int payID;
    private int userID;
    private String fullName;
    private String email;
    private String phone;
    private String status;
    private double Amount_Paid;
    private double Amount_Outstanding;
    private Timestamp date;
   // private Timestamp lastPaymentdate;

    public Payment() {
    }

    public Payment(int payID, String fullName, String phone, String email, String status, double Amount_Paid, double Amount_Outstanding, Timestamp date) {
        this.payID = payID;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.Amount_Paid = Amount_Paid;
        this.Amount_Outstanding = Amount_Outstanding;
        this.date = date;
       // this.lastPaymentdate = lastPaymentdate;
    }

    public Payment(int payID, int userID, String fullName, String email, String phone, String status, double Amount_Paid, double Amount_Outstanding, Timestamp date) {
        this.payID = payID;
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.Amount_Paid = Amount_Paid;
        this.Amount_Outstanding = Amount_Outstanding;
        this.date = date;
    }

    public Payment(String fullName, int userID, String phone, String email, String status, double Amount_Paid, double Amount_Outstanding, Timestamp date) {
     
        this.userID = userID;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.Amount_Paid = Amount_Paid;
        this.Amount_Outstanding = Amount_Outstanding;
        this.date = date;
               // this.lastPaymentdate = lastPaymentdate;

    }

    public Payment(String fullName, String phone,  String email, String status, double Amount_Paid, double Amount_Outstanding, Timestamp date) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.Amount_Paid = Amount_Paid;
        this.Amount_Outstanding = Amount_Outstanding;
        this.date = date;
               // this.lastPaymentdate = lastPaymentdate;

    }

    public int getPayID() {
        return payID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPayID(int payID) {
        this.payID = payID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount_Paid() {
        return Amount_Paid;
    }

    public void setAmount_Paid(double Amount_Paid) {
        this.Amount_Paid = Amount_Paid;
    }

    public double getAmount_Outstanding() {
        return Amount_Outstanding;
    }

    public void setAmount_Outstanding(double Amount_Outstanding) {
        this.Amount_Outstanding = Amount_Outstanding;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

//    public Timestamp getLastPaymentdate() {
//        return lastPaymentdate;
//    }
//
//    public void setLastPaymentdate(Timestamp lastPaymentdate) {
//        this.lastPaymentdate = lastPaymentdate;
//    }
    
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Payment{payID=").append(payID);
        sb.append(", userID=").append(userID);
        sb.append(", fullName=").append(fullName);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", Amount_Paid=").append(Amount_Paid);
        sb.append(", Amount_Outstanding=").append(Amount_Outstanding);
        sb.append(", date=").append(date);
        //sb.append(", lastPaymentdate=").append(lastPaymentdate);
        sb.append('}');
        return sb.toString();
    }

}
