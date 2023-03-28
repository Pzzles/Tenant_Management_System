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
public class Unit {
    private int id;
    private String unitNumber;
    private String email;
    private String occupantName;
    private String status;

    public Unit() {
    }

    public Unit(int id, String unitNumber, String email, String occupantName, String status) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.email = email;
        this.occupantName = occupantName;
        this.status = status;
    }

    public Unit(String unitNumber, String email, String occupantName, String status) {
        this.unitNumber = unitNumber;
        this.email = email;
        this.occupantName = occupantName;
        this.status = status;
    }

    public Unit(String unitNumber, String email, String occupantName) {
        this.unitNumber = unitNumber;
        this.email = email;
        this.occupantName = occupantName;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupantName() {
        return occupantName;
    }

    public void setOccupantName(String occupantName) {
        this.occupantName = occupantName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Unit{id=").append(id);
        sb.append(", unitNumber=").append(unitNumber);
        sb.append(", email=").append(email);
        sb.append(", occupantName=").append(occupantName);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    } 
}
