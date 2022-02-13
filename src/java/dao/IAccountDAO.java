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

    public Account login(String user, String pass);

    public Account checkAccountExist(String user);

    public Account checkPassword(String user, String pass);

    public void signup(String user, String pass, String fullname, String dob, String email, String phone);

    public void changePassword(String newpass, String oldpass, String user);
}
