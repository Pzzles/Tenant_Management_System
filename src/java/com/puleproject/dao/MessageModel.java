/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.dao;

import com.puleproject.bean.Message;
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
public class MessageModel extends DAOImplementation{
    
      private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public boolean addMessage(Message message) {
 boolean result = false;
        con = ConnectionDB.getInstance();
        try {
            if (con != null) {
                Statement s = con.createStatement();

                s.execute("SET FOREIGN_KEY_CHECKS=0");
                ps = con.prepareStatement("INSERT INTO malekedb.messages("
                        + "Id,"
                        + "Full_Name,"
                        + "Email,"
                        + "Message)"
                        + "VALUES(?,?,?,?)");

                ps.setInt(1, message.getId());
                ps.setString(2, message.getFullName());
                ps.setString(3, message.getEmail());
                ps.setString(4, message.getMsg());
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
    public List<Message> getAllMessages() {
        con = ConnectionDB.getInstance();
        List<Message> allMessages = new ArrayList<>();

        try {
            if (con != null) {

                ps = con.prepareStatement("SELECT * FROM malekedb.messages");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Message message = new Message();
                    message.setId(rs.getInt("Id"));
                    message.setFullName(rs.getString("Full_Name"));
                    message.setEmail(rs.getString("Email"));
                    message.setMsg(rs.getString("Message"));
                   
                    allMessages.add(message);
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return allMessages;
    }
    
        @Override
    public Message getOneMessage(String email) {
        con = ConnectionDB.getInstance();
        Message message = new Message();

        try {
            if (con != null) {

                ps = con.prepareStatement("SELECT * FROM malekedb.messages WHERE email = ?");
               ps.setString(1, email);
                rs = ps.executeQuery();

                while (rs.next()) {
                    message.setId(rs.getInt("Id"));
                    message.setFullName(rs.getString("Full_Name"));
                    message.setEmail(rs.getString("Email"));
                    message.setMsg(rs.getString("Message"));
                   
                }
            }
        } catch (SQLException sqlex) {
            System.out.println("Error! " + sqlex.getMessage());
        }

        return message;
    }
    
    
}
