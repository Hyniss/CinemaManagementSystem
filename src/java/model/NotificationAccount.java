/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class NotificationAccount {
    private int notificationId;
    private String username;
    private boolean readed;

    public NotificationAccount() {
    }

    public NotificationAccount(int notificationId, String username, boolean readed) {
        this.notificationId = notificationId;
        this.username = username;
        this.readed = readed;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    @Override
    public String toString() {
        return "NotificationAccount{" + "notificationId=" + notificationId + ", username=" + username + ", readed=" + readed + '}';
    }
    
    
}
