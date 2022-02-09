/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Bảo Châu Bống
 */
public class Account {

    private String username;
    private String password;
    private String avatar;
    private String fullName;
    private Date dob;
    private String email;
    private String phone;
    private int roleId;

    public Account() {
    }

    public Account(String username, String password, String avatar, String fullName, Date dob, String email, String phone, int roleId) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", avatar=" + avatar + ", fullName=" + fullName + ", dob=" + dob + ", email=" + email + ", phone=" + phone + ", roleId=" + roleId + '}';
    }

}
