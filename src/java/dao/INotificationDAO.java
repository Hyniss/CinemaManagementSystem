/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Notification;

/**
 *
 * @author HP
 */
public interface INotificationDAO {

    public ArrayList<Notification> getAllNotification();

    public Notification getNotificationById(int id);

    public List<Notification> pagingNotification(int pageIndex);

    public int getTotalNotification();

    public boolean insertNotification(Notification a);

    public boolean editNotification(Notification a);

    public boolean deleteNotification(int notificationId);
    
    public ArrayList<Notification> getNotificationByTitle(String notificationTitle, int pageIndex);
    
    public int getTotalNotificationByTitle(String title);

}
