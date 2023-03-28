/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.bean;

import java.util.Objects;

/**
 *
 * @author PULE
 */
public class Users {

    private int userID;
    private String name;
    private String surname;
    private String unitNumber;
    private String phone;
    private String email;
    private String password;
    
    public Users() {
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    
    
    public Users(String name, String surname, String unitNumber, String phone, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.unitNumber = unitNumber;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Users(String name, String surname, String phone, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Users(int userID, String name, String surname, String roomNumber, String phone, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.unitNumber = unitNumber;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.userID;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.surname);
        hash = 89 * hash + Objects.hashCode(this.unitNumber);
        hash = 89 * hash + Objects.hashCode(this.phone);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.unitNumber, other.unitNumber)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{usertID=").append(userID);
        sb.append(", name=").append(name);
        sb.append(", surname=").append(surname);
        sb.append(", roomNumber=").append(unitNumber);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}
