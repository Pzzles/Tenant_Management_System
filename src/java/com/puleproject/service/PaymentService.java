/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.service;

import com.puleproject.bean.Payment;
import com.puleproject.dao.DAO;
import com.puleproject.dao.PaymentModel;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author PULE
 */
public class PaymentService extends Service {

    private DAO payDAO;

    public PaymentService() {
        this.payDAO = new PaymentModel();
    }

    @Override
    public boolean addPayment(Payment payment) {
        return payDAO.addPayment(payment);
    }
    
    

    @Override
    public List<Payment> getAllPayments() {
        return payDAO.getAllPayments();
    }

    @Override
   public Payment getOnePayment(String email){
       return payDAO.getOnePayment(email);
   }

    @Override
    public boolean updatePayment(String status, double amntPaid, double amntOutstanding, Timestamp date, Timestamp dateLast, String email) {
        return payDAO.updatePayment(status, amntPaid, amntOutstanding, date, dateLast, email);
    }
   
   
}
