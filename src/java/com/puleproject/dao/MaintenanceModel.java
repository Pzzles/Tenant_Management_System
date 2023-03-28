/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.dao;

import com.puleproject.bean.Maintenance;
import com.puleprojects.util.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PULE
 */
public class MaintenanceModel extends DAOImplementation {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

        @Override
    public boolean deleteAllMaintenance() {
   boolean resultValue = false, resultValue1 = false;
         con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                Statement s = con.createStatement();

                s.execute("SET FOREIGN_KEY_CHECKS=0");
                ps = con.prepareStatement("DELETE FROM malekedb.maintenance WHERE Id > 0");
                
                resultValue = ps.executeUpdate() > 0;
                
                s.execute("SET FOREIGN_KEY_CHECKS=1");

            }
        } catch (SQLException ex) {
            System.out.println("Error Maintenance not deleted: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error! Closing: " + ex.getMessage());
                }
            }
        }
        return resultValue;
    }
    
    @Override
    public boolean deleteMaintenance(int reportNumber) {
   boolean resultValue = false, resultValue1 = false;
         con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                Statement s = con.createStatement();

                s.execute("SET FOREIGN_KEY_CHECKS=0");
                ps = con.prepareStatement("DELETE FROM malekedb.maintenance WHERE Id = ?");
                ps.setInt(1, reportNumber);
                resultValue = ps.executeUpdate() > 0;
                
                s.execute("SET FOREIGN_KEY_CHECKS=1");

            }
        } catch (SQLException ex) {
            System.out.println("Error Maintenance not deleted: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error! Closing: " + ex.getMessage());
                }
            }
        }
        return resultValue;
    }

    @Override
    public Maintenance getOneMaintenance(String email) {
        con = ConnectionDB.getInstance();
        Maintenance maintenance = new Maintenance();
        try {
            if (con != null) {

                ps = con.prepareStatement("SELECT * FROM malekedb.maintenance WHERE Email = ?");
                rs = ps.executeQuery();

                while (rs.next()) {

                    maintenance.setId(rs.getInt("Id"));
                    maintenance.setUnitNumber(rs.getString("Unit_Number"));
                    maintenance.setEmail(rs.getString("Email"));
                    maintenance.setTypeOfRequest(rs.getString("Type_Of_Request"));
                    maintenance.setDetailOfRequest(rs.getString("Details_Of_Request"));
                    maintenance.setDescription(rs.getString("Description_Of_Issue"));
                    maintenance.setPic1(rs.getString("Picture_1"));
                    maintenance.setPic2(rs.getString("Picture_2"));
                    maintenance.setPic3(rs.getString("Picture_3"));
                    maintenance.setPriority(rs.getString("Priority"));
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return maintenance;
    }

    @Override
    public List<Maintenance> sortMaintenanceByPriority(String priority) {
        con = ConnectionDB.getInstance();
        List<Maintenance> allMaintenances = new ArrayList<>();

        try {
            if (con != null) {

                ps = con.prepareStatement("SELECT * FROM malekedb.maintenance WHERE Priority = ?");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Maintenance maintenance = new Maintenance();
                    maintenance.setId(rs.getInt("Id"));
                    maintenance.setUnitNumber(rs.getString("Unit_Number"));
                    maintenance.setEmail(rs.getString("Email"));
                    maintenance.setTypeOfRequest(rs.getString("Type_Of_Request"));
                    maintenance.setDetailOfRequest(rs.getString("Details_Of_Request"));
                    maintenance.setDescription(rs.getString("Description_Of_Issue"));
                    maintenance.setPic1(rs.getString("Picture_1"));
                    maintenance.setPic2(rs.getString("Picture_2"));
                    maintenance.setPic3(rs.getString("Picture_3"));
                    maintenance.setPriority(rs.getString("Priority"));
                    allMaintenances.add(maintenance);
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return allMaintenances;
    }

    @Override
    public List<Maintenance> getAllMaintenance() {
        con = ConnectionDB.getInstance();
        List<Maintenance> allMaintenances = new ArrayList<>();

        try {
            if (con != null) {

                ps = con.prepareStatement("SELECT * FROM malekedb.maintenance");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Maintenance maintenance = new Maintenance();
                    maintenance.setId(rs.getInt("Id"));
                    maintenance.setUnitNumber(rs.getString("Unit_Number"));
                    maintenance.setEmail(rs.getString("Email"));
                    maintenance.setTypeOfRequest(rs.getString("Type_Of_Request"));
                    maintenance.setDetailOfRequest(rs.getString("Details_Of_Request"));
                    maintenance.setDescription(rs.getString("Description_Of_Issue"));
                    maintenance.setPic1(rs.getString("Picture_1"));
                    maintenance.setPic2(rs.getString("Picture_2"));
                    maintenance.setPic3(rs.getString("Picture_3"));
                    maintenance.setPriority(rs.getString("Priority"));
                    allMaintenances.add(maintenance);
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return allMaintenances;
    }

    @Override
    public boolean requestMaintenance(Maintenance maintenance) {
        boolean result = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                Statement s = con.createStatement();

                s.execute("SET FOREIGN_KEY_CHECKS=0");
                ps = con.prepareStatement("INSERT INTO malekedb.maintenance("
                        + "Unit_Number,"
                        + "Email,"
                        + "Type_Of_Request,"
                        + "Details_Of_Request,"
                        + "Description_Of_Issue,"
                        + "Picture_1,"
                        + "Picture_2,"
                        + "Picture_3,"
                        + "Priority)"
                        + "VALUES(?,?,?,?,?,?,?,?,?)");

                ps.setInt(1, maintenance.getId());
                ps.setString(2, maintenance.getEmail());
                ps.setString(3, maintenance.getTypeOfRequest());
                ps.setString(4, maintenance.getDetailOfRequest());
                ps.setString(5, maintenance.getDescription());
                ps.setString(6, maintenance.getPic1());
                ps.setString(7, maintenance.getPic2());
                ps.setString(8, maintenance.getPic3());
                ps.setString(9, maintenance.getPriority());

                result = ps.executeUpdate() > 0;
                s.execute("SET FOREIGN_KEY_CHECKS=1");

            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }
        if (result != false) {
            return true;
        }

        return result;
    }

}
