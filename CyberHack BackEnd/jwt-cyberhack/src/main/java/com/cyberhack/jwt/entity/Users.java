package com.cyberhack.jwt.entity;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_first_name")
    private String userFirstName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "curr_pos")
    private String currentPosition;

    @Column(name = "years_of_exp")
    private String yearsOfExperience;

    @Column(name = "level_of_education")
    private String eduLvl;

    @Column(name = "ngo_needs")
    private String ngoNeeds;

    @Column(name = "vol_interests")
    private String volInterests;

    @Column(name = "wkly_hrs")
    private String wklyHrs;

    @Column(name = "has_Crim_Check")
    private String crimCheck;

    @Column(name = "work_refs")
    private String workRefs;

    @Column(name = "linkedin")
    private String linkedIn;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "av_now")
    private String avNow;

    // Getters and Setters for userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getters and Setters for userFirstName
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    // Getters and Setters for userLastName
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    // Getters and Setters for userEmail
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // Getters and Setters for userPassword
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    // Getters and Setters for userPhone
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    // Getters and Setters for currentPosition
    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    // Getters and Setters for yearsOfExperience
    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters and Setters for eduLvl
    public String getEduLvl() {
        return eduLvl;
    }

    public void setEduLvl(String eduLvl) {
        this.eduLvl = eduLvl;
    }

    // Getters and Setters for ngoNeedsHelp
    public String getNgoNeeds() {
        return ngoNeeds;
    }

    public void setNgoNeeds(String ngoNeeds) {
        this.ngoNeeds= ngoNeeds;
    }

    // Getters and Setters for volInterests
    public String getVolInterests() {
        return volInterests;
    }

    public void setVolInterests(String volInterests) {
        this.volInterests = volInterests;
    }

    // Getters and Setters for wklyHrs
    public String getWklyHrs() {
        return wklyHrs;
    }

    public void setWklyHrs(String wklyHrs) {
        this.wklyHrs = wklyHrs;
    }

    // Getters and Setters for crimCheck
    public String getCrimCheck() {
        return crimCheck;
    }

    public void setCrimCheck(String crimCheck) {
        this.crimCheck = crimCheck;
    }

    // Getters and Setters for workRefs
    public String getWorkRefs() {
        return workRefs;
    }

    public void setWorkRefs(String workRefs) {
        this.workRefs = workRefs;
    }

    // Getters and Setters for linkedIn
    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    // Getters and Setters for userRole
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAvNow() {
        return avNow;
    }

    public void setAvNow(String avNow) {
        this.avNow = avNow;
    }

}
