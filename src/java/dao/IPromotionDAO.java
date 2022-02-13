/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Promotion;

/**
 *
 * @author tenhik
 */
public interface IPromotionDAO {

    public Promotion getPromotion(int promotionId);

    public ArrayList<Promotion> getAllPromotion();

    public void addPromotion(Promotion promotion);

    public void editPromotion(Promotion promotion);

    public void deletePromotion(int id);

    public Promotion get(int id);
}
