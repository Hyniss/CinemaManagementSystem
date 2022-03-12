/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.NotificationAccount;

/**
 *
 * @author HP
 */
public interface INotificationAccountDAO {
    
    public ArrayList<NotificationAccount> get5Notification(String username);
    
    public boolean editReaded(int notificationId, String username);
    
}
