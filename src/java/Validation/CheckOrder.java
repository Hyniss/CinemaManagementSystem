/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.ArrayList;
import model.Cart;

/**
 *
 * @author TIEN HUY
 */
public class CheckOrder {
     public boolean CheckId( ArrayList<Cart> orderList,int id){
        for(Cart x : orderList){
            if(x.getCartId() == id){
                return true;
            }
        }
        
        return false;
    }
}
