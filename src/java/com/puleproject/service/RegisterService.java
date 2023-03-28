/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.service;

import com.puleproject.bean.Users;
import com.puleproject.dao.DAO;
import com.puleproject.dao.RegisterModel;

/**
 *
 * @author PULE
 */
public class RegisterService extends Service{

    private DAO registerDAO;

    public RegisterService() {
        this.registerDAO = new RegisterModel();
    }
    
    
    @Override
    public void addAdmin(Users user) {
        registerDAO.addAdmin(user);
    }

    @Override
    public boolean addClient(Users user) {
       return registerDAO.addClient(user);
    }
    
}
