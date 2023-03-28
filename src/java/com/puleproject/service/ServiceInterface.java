/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.service;

import com.puleproject.bean.Maintenance;
import com.puleproject.bean.Message;
import com.puleproject.bean.Payment;
import com.puleproject.bean.Unit;
import com.puleproject.bean.Users;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author PULE
 */
public interface ServiceInterface {

    public boolean addClient(Users user);

    public void addAdmin(Users user);

    public boolean loginValidation(String email, String password, boolean isChecked);

    public List<Users> getAllTenants();

    public Users getOneTenant(String email);

    public boolean addPayment(Payment payment);

    public List<Payment> getAllPayments();

    public Payment getOnePayment(String email);

    public boolean updatePayment(String status, double amntPaid, double amntOutstanding, Timestamp date, Timestamp dateLast, String email);

    public boolean updateTenant(String name, String surname, String roomNumber, String phone, String password, String email);

    public boolean deleteTenant(String email);

    public List<Unit> getAllUnits();

    public Unit getOneUnitById(int id);

    public Unit getOneUnit(String email);

    public boolean addToUnit(Unit unit);

    public boolean updateUnit(String unitNumber, String email, String occupantName, String status);

    public boolean requestMaintenance(Maintenance maintenance);

    public List<Maintenance> getAllMaintenance();

    public List<Maintenance> sortMaintenanceByPriority(String priority);

    public Maintenance getOneMaintenance(String email);

    public boolean deleteMaintenance(int reportNumber);

    public boolean addMessage(Message message);
    
    public Message getOneMessage(String email);

    public List<Message> getAllMessages();
    
        public boolean deleteAllMaintenance();
}
