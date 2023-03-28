/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.service;

import com.puleproject.bean.Unit;
import com.puleproject.dao.DAO;
import com.puleproject.dao.UnitModel;
import java.util.List;

/**
 *
 * @author PULE
 */
public class UnitService extends Service{

        private DAO unitDAO;

    public UnitService() {
        this.unitDAO = new UnitModel();
    }
    
    @Override
    public boolean addToUnit(Unit unit) {
        return unitDAO.addToUnit(unit);
    }

    @Override
    public Unit getOneUnit(String email) {
        return unitDAO.getOneUnit(email);
    }

    @Override
    public List<Unit> getAllUnits() {
        return unitDAO.getAllUnits();
    }

    @Override
    public boolean updateUnit(String unitNumber, String email, String occupantName, String status) {
        return unitDAO.updateUnit(unitNumber, email, occupantName, status);
    }
    
    
}
