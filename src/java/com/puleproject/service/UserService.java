/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.service;

import com.puleproject.bean.Users;
import com.puleproject.dao.DAO;
import com.puleproject.dao.UserModel;
import java.util.List;

/**
 *
 * @author PULE
 */
public class UserService extends Service{

    private DAO userDAO;

    public UserService() {
        this.userDAO = new UserModel();
    }
    
    
    @Override
    public boolean loginValidation(String email, String password, boolean isChecked) {
       return userDAO.loginValidation(email, password, isChecked);
    }

    @Override
    public List<Users> getAllTenants() {
        return userDAO.getAllTenants();
    }

    @Override
    public Users getOneTenant(String email) {
        return userDAO.getOneTenant(email);
    }

    @Override
    public boolean updateTenant(String name, String surname, String roomNumber, String phone, String password, String email) {
        return userDAO.updateTenant(name, surname, roomNumber, phone, password, email);
    }

    @Override
    public boolean deleteTenant(String email) {
        return userDAO.deleteTenant(email);
    }
    
    
    
    

}
