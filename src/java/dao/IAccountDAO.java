/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
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


    public void insertAccount(String user, String pass, String fullname, String dob, String email, String phone);

    public void updatePassword(String newpass, String oldpass, String user);

    public Account checkEmail(String user, String email);

  
}
