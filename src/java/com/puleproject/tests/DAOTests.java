/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.tests;

import com.puleproject.bean.Payment;
import com.puleproject.bean.Users;
import com.puleproject.dao.DAO;
import com.puleproject.dao.PaymentModel;
import com.puleproject.dao.RegisterModel;
import com.puleproject.dao.UserModel;
import com.puleprojects.util.Encryption;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PULE
 */
public class DAOTests {

    public static void main(String[] args) {

       // new DAOTests().registerDAO();
        //new DAOTests().loginDAO();
       // new DAOTests().getall();
       
//       String email = "at@atat";
//       new DAOTests().getOne(email);
//new DAOTests().allPayments();
//new DAOTests().updatePayment("at@atat");
//new DAOTests().updateTenant("great@com");
String email = "grrrrr@com";
new DAOTests().deleteTenant(email);
    }

    public void loginDAO() {
        DAO udao = new UserModel();
        Scanner sc = new Scanner(System.in);
        String passss = sc.next();
        String pass = Encryption.GenerateHash(passss);
        udao.loginValidation("grrrrr@at", pass, true);
    }
    public void registerDAO() {
        DAO rdao = new RegisterModel();

     Users user = new Users("Teddy", "Clubberlang", "3271094334347", "grrrrr@com", "sexyen101");
    
     String encyptedPassword = Encryption.GenerateHash(user.getPassword()); 
user.setPassword(encyptedPassword);
       //rdao.addClient(user);
       rdao.addAdmin(user);
    }

    
    public void getall(){
        DAO atdao = new UserModel();
        
        List<Users> allTenants = atdao.getAllTenants();
        
        for(Users tenant : allTenants){
            System.out.println(tenant);
        }
    }
    
    public void getOne(String email){
        DAO tdao = new UserModel();
        
        Users tenant = tdao.getOneTenant(email);
        System.out.println(tenant);
    }
    
        public void allPayments(){
        DAO payService =  new PaymentModel();
        List<Payment> lop = payService.getAllPayments();
        for(Payment single: lop){
            System.out.println(single);
        }
    }
        
        public void updatePayment(String email){
            DAO paymentDAO = new PaymentModel();
            java.sql.Timestamp dateTime = new java.sql.Timestamp(new java.util.Date().getTime());
            
                    paymentDAO.updatePayment("Failed", 3500, 120, dateTime, dateTime, email);
                    
        }
        
        public void updateTenant(String email){
            DAO tenantDAO = new UserModel();
            
            tenantDAO.updateTenant("Pule", "Tshetlha", "259", "0123987465", "0987", "great@com");
        }
        
        public void deleteTenant(String email){
            DAO tenDAO = new UserModel();
            
            tenDAO.deleteTenant(email);
        }
}
