/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.service;

import com.puleproject.bean.Maintenance;
import com.puleproject.dao.DAO;
import com.puleproject.dao.MaintenanceModel;
import java.util.List;

/**
 *
 * @author PULE
 */
public class MaintenanceService extends Service {

    private DAO maintainDAO;

    public MaintenanceService() {
        this.maintainDAO = new MaintenanceModel();
    }

    @Override
    public boolean deleteMaintenance(int reportNumber) {
        return maintainDAO.deleteMaintenance(reportNumber);
    }

    @Override
    public Maintenance getOneMaintenance(String email) {
        return maintainDAO.getOneMaintenance(email);
    }

    @Override
    public List<Maintenance> sortMaintenanceByPriority(String priority) {
        return maintainDAO.sortMaintenanceByPriority(priority);
    }

    @Override
    public List<Maintenance> getAllMaintenance() {
        return maintainDAO.getAllMaintenance();
    }

    @Override
    public boolean requestMaintenance(Maintenance maintenance) {
        return maintainDAO.requestMaintenance(maintenance);
    }

    @Override
    public boolean deleteAllMaintenance() {
        return maintainDAO.deleteAllMaintenance();

    }

}
