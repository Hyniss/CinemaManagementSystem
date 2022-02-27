/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author tenhik
 */
public interface IAccountDAO {

    public ArrayList<Account> getAllAccount();

    public Account getAccountByUsername(String username);

    public boolean editAccount(Account a);

    public Account getAccountByUsernameAndPassword(String user, String pass);

    public ArrayList<Account> getAccountByRoleId(int roleId);
    
    public boolean deleteAccount(String username);
    
    public int getTotalAccountByRole(int roleId);
    
    public List<Account> pagingAccount(int pageIndex, int roleId);
    
    public boolean insertAccount1(Account a);

    public void insertAccount(String user, String pass, String fullname, String dob, String email, String phone, int roleId);

    public void updatePassword(String newpass, String oldpass, String user);

    public Account checkEmail(String user, String email);

  
}
