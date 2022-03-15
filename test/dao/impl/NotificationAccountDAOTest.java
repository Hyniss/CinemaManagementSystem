/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.ArrayList;
import model.NotificationAccount;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class NotificationAccountDAOTest {
    
    public NotificationAccountDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGet5Notification() {
        System.out.println("get5Notification");
        String username = "";
        NotificationAccountDAO instance = new NotificationAccountDAO();
        ArrayList<NotificationAccount> expResult = null;
        ArrayList<NotificationAccount> result = instance.get5Notification(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditReaded() {
        System.out.println("editReaded");
        int notificationId = 0;
        String username = "";
        NotificationAccountDAO instance = new NotificationAccountDAO();
        boolean expResult = false;
        boolean result = instance.editReaded(notificationId, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
