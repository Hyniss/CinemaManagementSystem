/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thai Tran
 */
public class AccountDAOTest {
    
    AccountDAO accountDAO;
    AccountDAO accountDaoSpy;
    
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
        accountDAO = new AccountDAO();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllAccount() {
        accountDAO.getAllAccount();
    }

    @Test(expected = Exception.class)
    public void testGetAccountByNullUsername() {
        String username = null;
        accountDAO.getAccountByUsername(username);
    }
    
    
    @Test
    public void testGetAccountByValidUsername() {
        String username = "123456";
        accountDAO.getAccountByUsername(username);
    }

    @Test(expected = Exception.class)
    public void testEditWithNullAccount() {
        Account a = null;
        accountDAO.editAccount(a);
    }
    
    @Test(expected = Exception.class)
    public void testEditWithEmptyAccount() {
        Account a = new Account();
        accountDAO.editAccount(a);
    }
    
    @Test()
    public void testEditWithValidAccount() {
        Account a = new Account();
        a.setUsername("123456");
        a.setPassword("123456");
        a.setFullName("Thái Trần");
        a.setAvatar("tranvietdanhthai.jpg");
        a.setEmail("tranvietdanhthai@gmail.com");
        a.setPhone("0941815064");
        a.setDob(java.sql.Date.valueOf("2001-09-02"));
        a.setRoleId(3);
        accountDAO.editAccount(a);
    }
    
}
