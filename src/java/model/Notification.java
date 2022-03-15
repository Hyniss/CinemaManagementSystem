/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Notification {
    private int notificationId;
    private String notificationImg;
    private String notificationTitle;
    private String notificationDescription;
    private Date notificationDate;

    public Notification() {
    }

    public Notification(int notificationId, String notificationImg, String notificationTitle, String notificationDescription, Date notificationDate) {
        this.notificationId = notificationId;
        this.notificationImg = notificationImg;
        this.notificationTitle = notificationTitle;
        this.notificationDescription = notificationDescription;
        this.notificationDate = notificationDate;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationImg() {
        return notificationImg;
    }

    public void setNotificationImg(String notificationImg) {
        this.notificationImg = notificationImg;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }


    @Override
    public String toString() {
        return "Notification{" + "notificationId=" + notificationId + ", notificationImg=" + notificationImg + ", notificationTitle=" + notificationTitle + ", notificationDescription=" + notificationDescription + ", notificationDate=" + notificationDate + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            Notification another = (Notification) obj;
            if (this.notificationId==another.notificationId &&
                this.notificationImg.equals(another.notificationImg) &&
                this.notificationTitle.equals(another.notificationTitle) &&
                this.notificationDescription.equals(another.notificationDescription) &&
                this.notificationDate.compareTo(another.notificationDate)==0){
                    return true;
            }
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
}
