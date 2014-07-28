/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gizmoideas.roll_ando.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author ipena
 */
public class UserRoller implements Serializable{
    
    private String name;
    private String password;    
    private String mail;
    private int type;
    private Date birthDay;
    private String askSecure;
    private String answerSecure;

    public UserRoller(String name, String password, String mail, int type, Date birthDay, String askSecure, String answerSecure) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.type = type;
        this.birthDay = birthDay;
        this.askSecure = askSecure;
        this.answerSecure = answerSecure;
    }   

    public UserRoller() {
        birthDay=Calendar.getInstance(TimeZone.getDefault()).getTime();
    }    
    
    public boolean validatePassword(String passwd){
       return password.equals(passwd);
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAskSecure() {
        return askSecure;
    }

    public void setAskSecure(String askSecure) {
        this.askSecure = askSecure;
    }

    public String getAnswerSecure() {
        return answerSecure;
    }

    public void setAnswerSecure(String answerSecure) {
        this.answerSecure = answerSecure;
    }
    
    
    
    
    
}
