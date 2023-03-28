/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.dao;

import com.puleproject.bean.Users;
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
public class UserModel extends DAOImplementation {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public boolean loginValidation(String email, String password, boolean isChecked) {

        if (isChecked == false) {
            return clientLogin(email, password);
        } else {
            return adminLogin(email, password);
        }
    }

    public boolean clientLogin(String email, String password) {
        boolean result = false;

        try {

            con = ConnectionDB.getInstance();
            String loginEmail = email;
            String loginPassword = password;
            String dbEmail = "";
            String dbPassword = "";

            ps = con.prepareStatement("SELECT * FROM client WHERE Email = ? AND Password = ?");
            ps.setString(1, loginEmail);
            ps.setString(2, loginPassword);
            rs = ps.executeQuery();

            while (rs.next()) {
                dbEmail = rs.getString("Email");
                dbPassword = rs.getString("Password");
                if (loginEmail.equals(dbEmail) && loginPassword.equals(dbPassword)) {
                    result = true;
                    System.out.println("LOGIN SUCCESSFUL");
                    return result;
                }
            }

        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException sqlex) {
                System.out.println("Error! " + sqlex.getMessage());
            }
        }
        return result;
    }

    public boolean adminLogin(String email, String password) {
        boolean result = false;

        try {

            con = ConnectionDB.getInstance();
            String loginEmail = email;
            String loginPassword = password;
            String dbEmail = "";
            String dbPassword = "";

            ps = con.prepareStatement("SELECT * FROM admin WHERE Email = ? AND Password = ?");
            ps.setString(1, loginEmail);
            ps.setString(2, loginPassword);
            rs = ps.executeQuery();

            while (rs.next()) {
                dbEmail = rs.getString("Email");
                dbPassword = rs.getString("Password");
                if (loginEmail.equals(dbEmail) && loginPassword.equals(dbPassword)) {
                    result = true;
                    System.out.println("LOGIN SUCCESSFUL");
                    return result;
                }
            }

        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException sqlex) {
                System.out.println("Error! " + sqlex.getMessage());
            }
        }
        return result;
    }

    @Override
    public List<Users> getAllTenants() {
        List<Users> allTenants = new ArrayList<>();
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                ps = con.prepareStatement("SELECT * FROM client");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Users tenant = new Users();
                    tenant.setUserID(rs.getInt("ClientID"));
                    tenant.setName(rs.getString("Name"));
                    tenant.setSurname(rs.getString("Surname"));
                    tenant.setUnitNumber(rs.getString("Unit_Number"));
                    tenant.setPhone(rs.getString("Phone"));
                    tenant.setEmail(rs.getString("Email"));
                    tenant.setPassword(rs.getString("Password"));
                    allTenants.add(tenant);
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return allTenants;
    }

    @Override
    public Users getOneTenant(String email) {
        Users tenant = null;
        con = ConnectionDB.getInstance();

        try {
            if (con != null) {
                ps = con.prepareStatement("SELECT * FROM client WHERE Email = ?");
                ps.setString(1, email);
                rs = ps.executeQuery();
                tenant = new Users();
                while (rs.next()) {
                    tenant.setUserID(rs.getInt("ClientID"));
                    tenant.setName(rs.getString("Name"));
                    tenant.setSurname(rs.getString("Surname"));
                    tenant.setUnitNumber(rs.getString("Unit_Number"));
                    tenant.setPhone(rs.getString("Phone"));
                    tenant.setEmail(rs.getString("Email"));
                    tenant.setPassword(rs.getString("Password"));
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }
        return tenant;
    }

    @Override
    public boolean updateTenant(String name, String surname, String unitNumber, String phone, String password, String email) {
        boolean returnValue = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {

                ps = con.prepareStatement("UPDATE client "
                        + "SET "
                        + "Name = ?,"
                        + "Surname = ?,"
                        + "Unit_Number = ?,"
                        + "Phone = ?,"
                        + "Email = ?,"
                        + "Password = ?"
                        + "WHERE Email = ?");
                ps.setString(1, name);
                ps.setString(2, surname);
                ps.setString(3, unitNumber);
                ps.setString(4, phone);
                ps.setString(5, email);
                ps.setString(6, password);
                ps.setString(7, email);
                returnValue = ps.executeUpdate() > 0;
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException sqlex) {
                    System.out.println("Error! Closing: " + sqlex.getMessage());
                }
            }
        }

        return returnValue;
    }

    @Override
    public boolean deleteTenant(String email) {
        boolean resultValue = false, resultValue1 = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                Statement s = con.createStatement();

                s.execute("SET FOREIGN_KEY_CHECKS=0");
                ps = con.prepareStatement("DELETE FROM malekedb.client WHERE Email = ?");
                ps.setString(1, email);
                resultValue = ps.executeUpdate() > 0;
                
                ps = con.prepareStatement("DELETE FROM malekedb.payment WHERE Email = ?");
                ps.setString(1, email);
                resultValue1 = ps.executeUpdate() > 0;
                s.execute("SET FOREIGN_KEY_CHECKS=1");

            }
        } catch (SQLException ex) {
            System.out.println("Error Tenant not deleted: " + ex.getMessage());
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

}
