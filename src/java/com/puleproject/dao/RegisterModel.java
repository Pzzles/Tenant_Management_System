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

/**
 *
 * @author PULE
 */
public class RegisterModel extends DAOImplementation{
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;


    @Override
    public boolean addClient(Users user) {
        boolean result = false;
        con = ConnectionDB.getInstance();
        try{
            if(con != null){
                ps = con.prepareStatement("INSERT INTO client("
                        + "Name,"
                        + "Surname,"
                        + "Unit_Number,"
                        + "Phone,"
                        + "Email,"
                        + "Password)"
                        + "VALUES(?,?,?,?,?,?)");
                
                ps.setString(1, user.getName());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getUnitNumber());
                ps.setString(4, user.getPhone());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getPassword());
                 result = ps.executeUpdate() > 0;
                
            }
        }catch(SQLException sqlex){
            System.out.println("Error! " + sqlex.getMessage());
        }if(result != false){
            return true;
        }

return result;
    }

    @Override
    public void addAdmin(Users user) {
        try{
            con = ConnectionDB.getInstance();
            if(con != null){
                ps = con.prepareStatement("INSERT INTO admin("
                        + "Name,"
                        + "Surname,"
                        + "Phone,"
                        + "Email,"
                        + "Password)"
                        + "VALUES(?,?,?,?,?)");
                
                ps.setString(1, user.getName());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getPhone());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
            }
        }catch(SQLException sqlex){
            System.out.println("Error! " + sqlex.getMessage());
        }    
    }
    
    
}
