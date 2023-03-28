/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.bean;

/**
 *
 * @author PULE
 */
public class Message {
    private int id;
    private String fullName;
    private String email;
    private String msg;

    public Message() {
    }

    public Message(int id, String fullName, String email, String msg) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.msg = msg;
    }

    public Message(String fullName, String email, String msg) {
        this.fullName = fullName;
        this.email = email;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Message{id=").append(id);
        sb.append(", fullName=").append(fullName);
        sb.append(", email=").append(email);
        sb.append(", msg=").append(msg);
        sb.append('}');
        return sb.toString();
    }
    
    
}
