/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Account;
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
public class AccountDAOTest {

    public AccountDAOTest() {
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

//    @Test
//    public void testGetAllAccount() {
//        System.out.println("getAllAccount");
//        AccountDAO instance = new AccountDAO();
//        ArrayList<Account> expResult = null;
//        ArrayList<Account> result = instance.getAllAccount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    @Test
//    public void testGetAccountByRoleId() {
//        System.out.println("getAccountByRoleId");
//        int roleId = 0;
//        AccountDAO instance = new AccountDAO();
//        ArrayList<Account> expResult = null;
//        ArrayList<Account> result = instance.getAccountByRoleId(roleId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    getAccountByUsername
    @Test
    public void testGetAccountByNormalUsername() {
        System.out.println("getAccountByUsername");
        String username = "admin";
        AccountDAO instance = new AccountDAO();
        Account expResult = new Account("admin", "admin", "profile-pic.jpg", "Nguyễn Admin", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 1);
        Account result = instance.getAccountByUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAccountByAbNormalUsername() {
        System.out.println("getAccountByUsername");
        String username = "adminnnn";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.getAccountByUsername(username);
        assertEquals(expResult, result);
    }

//    @Test
//    public void testGetUserAccountBySubUsername() {
//        System.out.println("getUserAccountBySubUsername");
//        String accountsubUsername = "";
//        int pageIndex = 0;
//        AccountDAO instance = new AccountDAO();
//        ArrayList<Account> expResult = null;
//        ArrayList<Account> result = instance.getUserAccountBySubUsername(accountsubUsername, pageIndex);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    //getTotalAccountByUsername
    @Test
    public void testGetTotalAccountByNormalUsername() {
        System.out.println("getTotalAccountByUsername");
        String username = "a";
        AccountDAO instance = new AccountDAO();
        int expResult = 5;
        int result = instance.getTotalAccountByUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalAccountByAbnormalUsername() {
        System.out.println("getTotalAccountByUsername");
        String username = "aaaaa";
        AccountDAO instance = new AccountDAO();
        int expResult = 0;
        int result = instance.getTotalAccountByUsername(username);
        assertEquals(expResult, result);
    }

//insert account
    @Test
    public void testInsertNormalAccount() {
        System.out.println("insertAccount1");
        Account a = new Account("adminadmin", "admin", "profile-pic.jpg", "Nguyễn Admin", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 1);
        AccountDAO instance = new AccountDAO();
        boolean expResult = true;
        boolean result = instance.insertAccount1(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertAbnormalAccount() {
        System.out.println("insertAccount1");
        Account a = new Account("adminadmin", "admin", "profile-pic.jpg", "Nguyễn Admin", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 10);
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.insertAccount1(a);
        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void testInsertNullAccount() {
        System.out.println("insertAccount1");
        Account a = null;
        AccountDAO instance = new AccountDAO();
        boolean result = instance.insertAccount1(a);
    }

    @Test
    public void testInsertAccountWithValidBoundaryUsername() {
        System.out.println("insertAccount1");
        Account a = new Account("adminadminadminadminadminadmin", "admin", "profile-pic.jpg", "Nguyễn Admin", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 3);
        AccountDAO instance = new AccountDAO();
        boolean expResult = true;
        boolean result = instance.insertAccount1(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertAccountWithInvalidBoundaryUsername() {
        System.out.println("insertAccount1");
        Account a = new Account("adminadminadminadminadminadminadmin", "admin", "profile-pic.jpg", "Nguyễn Admin", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 3);
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.insertAccount1(a);
        assertEquals(expResult, result);
    }

    //edit account
    @Test
    public void testEditNormalAccount() {
        System.out.println("editAccount");
        Account a = new Account("adminadminadminadminadminadmin", "adminnnn", "profile-pic.jpg", "Nguyễn Admin", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 3);
        AccountDAO instance = new AccountDAO();
        boolean expResult = true;
        boolean result = instance.editAccount(a);
        assertEquals(expResult, result);

    }

    @Test(expected = Exception.class)
    public void testEditNullAccount() {
        System.out.println("editAccount");
        Account a = null;
        AccountDAO instance = new AccountDAO();
        boolean result = instance.editAccount(a);

    }

    @Test
    public void testEditAbNormalAccount() {
        System.out.println("editAccount");
        Account a = new Account("adminadminadminadminadminadmin", "adminnnn", "profile-pic.jpg", "Nguyễn Admin", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 10);
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.editAccount(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testEditAccountWithValidBoundaryFullName() {
        System.out.println("editAccount");
        Account a = new Account("adminadminadminadminadminadmin", "adminnnn", "profile-pic.jpg", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 3);
        AccountDAO instance = new AccountDAO();
        boolean expResult = true;
        boolean result = instance.editAccount(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testEditAccountWithInvalidBoundaryFullName() {
        System.out.println("editAccount");
        Account a = new Account("adminadminadminadminadminadmin", "adminnnn", "profile-pic.jpg", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", java.sql.Date.valueOf("1991-07-20"), "admin123@gmail.com", "999999999", 3);
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.editAccount(a);
        assertEquals(expResult, result);
    }

    //delete account    
    @Test
    public void testDeleteNormalAccount() {
        System.out.println("deleteAccount");
        String username = "adminadminadminadminadminadmin";
        AccountDAO instance = new AccountDAO();
        boolean expResult = true;
        boolean result = instance.deleteAccount(username);
        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void testDeleteAccountWithNullUsername() {
        System.out.println("deleteAccount");
        String username = null;
        AccountDAO instance = new AccountDAO();
        boolean result = instance.deleteAccount(username);
    }

    @Test
    public void testDeleteAccountWithAbnormalUsername() {
        System.out.println("deleteAccount");
        String username = "hihi";
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.deleteAccount(username);
        assertEquals(expResult, result);
    }

// get toal account by role    
    @Test
    public void testGetTotalAccountByNormalRole() {
        System.out.println("getTotalAccountByRole");
        int roleId = 1;
        AccountDAO instance = new AccountDAO();
        int expResult = 1;
        int result = instance.getTotalAccountByRole(roleId);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalAccountAbNormalByRole() {
        System.out.println("getTotalAccountByRole");
        int roleId = 0;
        AccountDAO instance = new AccountDAO();
        int expResult = 0;
        int result = instance.getTotalAccountByRole(roleId);
        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void testGetTotalAccountByAbnormalRole2() {
        System.out.println("getTotalAccountByRole");
        int roleId = Integer.parseInt("aa");
        AccountDAO instance = new AccountDAO();
        int result = instance.getTotalAccountByRole(roleId);
    }

//    @Test
//    public void testPagingAccount() {
//        System.out.println("pagingAccount");
//        int pageIndex = 0;
//        int roleId = 0;
//        AccountDAO instance = new AccountDAO();
//        List<Account> expResult = null;
//        List<Account> result = instance.pagingAccount(pageIndex, roleId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
// getAccountByUsernameAndPassword
    
    @Test
    public void testGetAccountByNormalUsernameAndPassword() {
        System.out.println("getAccountByUsernameAndPassword");
        String user = "tranvietdanhthai";
        String pass = "123456";
        AccountDAO instance = new AccountDAO();
        Account expResult = new Account("tranvietdanhthai", "123456", "tranvietdanhthai.jpg", "Tran Viet Danh Thai Dep Trai", java.sql.Date.valueOf("2001-09-02"), "tranvietdanhthai@gmail.com", "0941815064", 3);
        Account result = instance.getAccountByUsernameAndPassword(user, pass);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAccountByAbNormalUsernameAndNormalPassword() {
        System.out.println("getAccountByUsernameAndPassword");
        String user = "tranviet";
        String pass = "123456";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.getAccountByUsernameAndPassword(user, pass);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAccountByNormalUsernameAndAbNormalPassword() {
        System.out.println("getAccountByUsernameAndPassword");
        String user = "tranvietdanhthai";
        String pass = "123456789";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.getAccountByUsernameAndPassword(user, pass);
        assertEquals(expResult, result);
    }
    
    //FAIL
    @Test(expected = Exception.class)
    public void testGetAccountByNullUsernameAndNotnullPassword() {
        System.out.println("getAccountByUsernameAndPassword");
        String user = null;
        String pass = "123456";
        AccountDAO instance = new AccountDAO();
        Account result = instance.getAccountByUsernameAndPassword(user, pass);
    }
    
    //FAIL
    @Test(expected = Exception.class)
    public void testGetAccountByNotnullUsernameAndNullPassword() {
        System.out.println("getAccountByUsernameAndPassword");
        String user = "tranvietdanhthai";
        String pass = null;
        AccountDAO instance = new AccountDAO();
        Account result = instance.getAccountByUsernameAndPassword(user, pass);
    }
    
//        //FAIL
//    @Test
//    public void testGetAccountByNullUsernameAndNotnullPassword() {
//        System.out.println("getAccountByUsernameAndPassword");
//        String user = null;
//        String pass = "123456";
//        Account expResult = null;
//        AccountDAO instance = new AccountDAO();
//        Account result = instance.getAccountByUsernameAndPassword(user, pass);
//        assertEquals(expResult, result);
//    }
//    
//    //FAIL
//    @Test
//    public void testGetAccountByNotnullUsernameAndNullPassword() {
//        System.out.println("getAccountByUsernameAndPassword");
//        String user = "tranvietdanhthai";
//        String pass = null;
//        Account expResult = null;
//        AccountDAO instance = new AccountDAO();
//        Account result = instance.getAccountByUsernameAndPassword(user, pass);
//        assertEquals(expResult, result);
//    }
    
    //updatePassword
    
    @Test
    public void testUpdateNormalPassword() {
        System.out.println("updatePassword");
        String newpass = "123456";
        String oldpass = "123456";
        String user = "mkt";
        AccountDAO instance = new AccountDAO();
        instance.updatePassword(newpass, oldpass, user);
    }
    
    //FAIL
    @Test(expected = Exception.class)
    public void testUpdateAbnormalPassword() {
        System.out.println("updatePassword");
        String newpass = null;
        String oldpass = "123456";
        String user = "mkt";
        AccountDAO instance = new AccountDAO();
        instance.updatePassword(newpass, oldpass, user);
    }

//    @Test
//    public void testCheckEmail() {
//        System.out.println("checkEmail");
//        String user = "";
//        String email = "";
//        AccountDAO instance = new AccountDAO();
//        Account expResult = null;
//        Account result = instance.checkEmail(user, email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
