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
public class Maintenance {
    private int id;
    private String unitNumber;
    private String email;
    private String typeOfRequest;
    private String detailOfRequest;
    private String description;
    private String pic1;
    private String pic2;
    private String pic3;
    private String priority;

    public Maintenance() {
    }

    public Maintenance(String unitNumber, String email, String typeOfRequest, String detailOfRequest, String description, String pic1, String pic2, String pic3, String priority) {
        this.unitNumber = unitNumber;
        this.email = email;
        this.typeOfRequest = typeOfRequest;
        this.detailOfRequest = detailOfRequest;
        this.description = description;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.priority = priority;
    }

    public Maintenance(int id, String unitNumber, String email, String typeOfRequest, String detailOfRequest, String description, String pic1, String pic2, String pic3, String priority) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.email = email;
        this.typeOfRequest = typeOfRequest;
        this.detailOfRequest = detailOfRequest;
        this.description = description;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.priority = priority;
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

    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public String getDetailOfRequest() {
        return detailOfRequest;
    }

    public void setDetailOfRequest(String detailOfRequest) {
        this.detailOfRequest = detailOfRequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Maintenance{id=").append(id);
        sb.append(", unitNumber=").append(unitNumber);
        sb.append(", email=").append(email);
        sb.append(", typeOfRequest=").append(typeOfRequest);
        sb.append(", detailOfRequest=").append(detailOfRequest);
        sb.append(", description=").append(description);
        sb.append(", pic1=").append(pic1);
        sb.append(", pic2=").append(pic2);
        sb.append(", pic3=").append(pic3);
        sb.append(", priority=").append(priority);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
