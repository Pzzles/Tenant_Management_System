/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.dao;

import com.puleproject.bean.Unit;
import com.puleprojects.util.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PULE
 */
public class UnitModel extends DAOImplementation {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public boolean addToUnit(Unit unit) {
        boolean result = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {
//                Statement s = con.createStatement();

                //               s.execute("SET FOREIGN_KEY_CHECKS=0");
                ps = con.prepareStatement("INSERT INTO malekedb.unit("
                        + "ID,"
                        + "Unit_Number,"
                        + "Email,"
                        + "Occupant_Name,"
                        + "Occupation_Status)"
                        + "VALUES(?,?,?,?,?)");

                ps.setInt(1, unit.getId());
                ps.setString(2, unit.getUnitNumber());
                ps.setString(3, unit.getEmail());
                ps.setString(4, unit.getOccupantName());
                ps.setString(5, unit.getStatus());

                result = ps.executeUpdate() > 0;
//                s.execute("SET FOREIGN_KEY_CHECKS=1");

            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }
        if (result != false) {
            return true;
        }

        return result;
    }

    @Override
    public Unit getOneUnit(String email) {
        Unit unit = null;
        con = ConnectionDB.getInstance();

        try {
            if (con != null) {
                ps = con.prepareStatement("SELECT * FROM unit WHERE Email = ?");
                ps.setString(1, email);
                rs = ps.executeQuery();
                unit = new Unit();
                while (rs.next()) {
                    unit.setId(rs.getInt("ID"));
                    unit.setUnitNumber(rs.getString("Unit_Number"));
                    unit.setEmail(rs.getString("Email"));
                    unit.setOccupantName(rs.getString("Occupant_Name"));
                    unit.setStatus(rs.getString("Occupation_Status"));

                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }
        return unit;
    }

    @Override
    public Unit getOneUnitById(int id) {
        return super.getOneUnitById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Unit> getAllUnits() {
        List<Unit> allUnits = new ArrayList<>();
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                ps = con.prepareStatement("SELECT * FROM unit");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Unit unit = new Unit();
                    unit.setId(rs.getInt("ID"));
                    unit.setUnitNumber(rs.getString("Unit_Number"));
                    unit.setEmail(rs.getString("Email"));
                    unit.setOccupantName(rs.getString("Occupant_Name"));
                    unit.setStatus(rs.getString("Occupation_Status"));
                    allUnits.add(unit);
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return allUnits;
    }

    @Override
    public boolean updateUnit(String unitNumber, String email, String occupantName, String status) {
        boolean returnValue = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {

                ps = con.prepareStatement("UPDATE unit "
                        + "SET "
                        + "Unit_Number = ?,"
                        + "Email = ?,"
                        + "Occupant_Name = ?,"
                        + "Occupation_Status = ?"
                        + "WHERE Email = ?");
                ps.setString(1, unitNumber);
                ps.setString(2, email);
                ps.setString(3, occupantName);
                ps.setString(4, status);

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

}
