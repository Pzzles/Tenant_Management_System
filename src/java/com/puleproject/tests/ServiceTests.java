/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.tests;

import com.puleproject.bean.Payment;
import com.puleproject.bean.Unit;
import com.puleproject.bean.Users;
import com.puleproject.service.PaymentService;
import com.puleproject.service.RegisterService;
import com.puleproject.service.Service;
import com.puleproject.service.UnitService;
import com.puleproject.service.UserService;
import com.puleprojects.util.Encryption;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PULE
 */
public class ServiceTests {

    public static void main(String[] args) {

        //new ServiceTests().loginTest();
        //new ServiceTests().registerTest();
        // new ServiceTests().allTenants();
        // new ServiceTests().allPayments();

        // new ServiceTests().onePayment("at@atata");
//       String email = "at@atat";
//       new ServiceTests().updatePaymentTest(email);
//new ServiceTests().updateTenant();
//String email = "jd@coco";
//new ServiceTests().deleteTenant(email);

new ServiceTests().allUnits();
    }

    public void loginTest() {
        Service loginser = new UserService();
        Scanner sc = new Scanner(System.in);
        String passss = sc.next();
        String pass = Encryption.GenerateHash(passss);
        System.out.println(loginser.loginValidation("grrrrr@com", pass, false));

    }

    public void registerTest() {
        Service registerser = new RegisterService();
        Users user = new Users("Pule", "Tshetlha", "5", "09437542453", "p@g.c", "easy");

        String encyptedPassword = Encryption.GenerateHash(user.getPassword());
        user.setPassword(encyptedPassword);

        // registerser.addAdmin(user);
        registerser.addClient(user);
    }

    public void allTenants() {
        Service tenantService = new UserService();

        for (Users ten : tenantService.getAllTenants()) {
            System.out.println(ten);
        }
    }

    public void allPayments() {
        Service payService = new PaymentService();
        List<Payment> lop = payService.getAllPayments();
        for (Payment single : lop) {
            System.out.println(single);
        }
    }

    public void onePayment(String email) {
        Service pay = new PaymentService();

        System.out.println(pay.getOnePayment(email));
    }

    public void updatePaymentTest(String email) {
        Service payService = new PaymentService();
        java.sql.Timestamp dateTime = new java.sql.Timestamp(new java.util.Date().getTime());

        payService.updatePayment("Not Paid", 3000, 700, dateTime, dateTime, email);
    }

    public void updateTenant() {
        Service serv = new UserService();

        serv.updateTenant("Toner", "Litt1234", "74", "08484488484", "4321", "great@com");
    }

    public void deleteTenant(String email) {
        Service serv = new UserService();

        serv.deleteTenant(email);
    }

    public void allUnits() {
        Service tenantServ = null, unitService = new UnitService();
        
        List<Unit> unitList = unitService.getAllUnits();
        int count = 1;

        for (Unit unit : unitList) {
            String email = unit.getEmail();

            System.out.println(unit.getStatus());
        }
    }
}