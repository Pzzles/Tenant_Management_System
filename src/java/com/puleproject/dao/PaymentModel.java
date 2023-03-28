
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.dao;

import com.puleproject.bean.Payment;
import com.puleproject.bean.Users;
import com.puleprojects.util.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PULE
 */
public class PaymentModel extends DAOImplementation {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public boolean addPayment(Payment payment) {
        boolean result = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                Statement s = con.createStatement();

                s.execute("SET FOREIGN_KEY_CHECKS=0");
                ps = con.prepareStatement("INSERT INTO malekedb.payment("
                        + "ClientID,"
                        + "Client_Full_Name,"
                        + "Phone,"
                        + "Email,"
                        + "Payment_Status,"
                        + "Amount_Paid,"
                        + "Amount_Outstanding,"
                        + "Date,"
                        + "Last_Payment_Date)"
                        + "VALUES(?,?,?,?,?,?,?,?,?)");

                ps.setInt(1, payment.getUserID());
                ps.setString(2, payment.getFullName());
                ps.setString(3, payment.getPhone());
                ps.setString(4, payment.getEmail());
                ps.setString(5, payment.getStatus());
                ps.setDouble(6, payment.getAmount_Paid());
                ps.setDouble(7, payment.getAmount_Outstanding());
                ps.setTimestamp(8, payment.getDate());
                ps.setTimestamp(9, payment.getDate());

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

    @Override
    public List<Payment> getAllPayments() {
        con = ConnectionDB.getInstance();
        List<Payment> allPayments = new ArrayList<>();

        try {
            if (con != null) {

                ps = con.prepareStatement("SELECT * FROM payment");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setPayID(rs.getInt("payID"));
                    payment.setUserID(rs.getInt("ClientID"));
                    payment.setFullName(rs.getString("Client_Full_Name"));
                    payment.setPhone(rs.getString("Phone"));
                    payment.setEmail(rs.getString("Email"));
                    payment.setStatus(rs.getString("Payment_Status"));
                    payment.setAmount_Paid(rs.getDouble("Amount_Paid"));
                    payment.setAmount_Outstanding(rs.getDouble("Amount_Outstanding"));
                    payment.setDate(rs.getTimestamp("Date"));
                    allPayments.add(payment);
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return allPayments;
    }

    @Override
    public Payment getOnePayment(String email) {
        Payment payment = new Payment();
        try {

            con = ConnectionDB.getInstance();
            ps = con.prepareStatement("SELECT * FROM payment WHERE Email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (con != null) {
                while (rs.next()) {
                    payment.setPayID(rs.getInt("payID"));
                    payment.setUserID(rs.getInt("ClientID"));
                    payment.setFullName(rs.getString("Client_Full_Name"));
                    payment.setPhone(rs.getString("Phone"));
                    payment.setEmail(rs.getString("Email"));
                    payment.setStatus(rs.getString("Payment_Status"));
                    payment.setAmount_Paid(rs.getDouble("Amount_Paid"));
                    payment.setAmount_Outstanding(rs.getDouble("Amount_Outstanding"));
                    payment.setDate(rs.getTimestamp("Date"));
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());

        }

        return payment;
    }

    @Override
    public boolean updatePayment(String status, double amntPaid, double amntOutstanding, Timestamp date, Timestamp dateLast, String email) {
        boolean returnValue = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {

                ps = con.prepareStatement("UPDATE payment "
                        + "SET "
                        + "Payment_Status = ?,"
                        + "Amount_Paid = ?,"
                        + "Amount_Outstanding = ?,"
                        + "Date = ?,"
                        + "Last_Payment_Date = ?"
                        + "WHERE Email = ?");
                ps.setString(1, status);
                ps.setDouble(2, amntPaid);
                ps.setDouble(3, amntOutstanding);
                ps.setTimestamp(4, date);
                ps.setTimestamp(5, dateLast);
                ps.setString(6, email);
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
