/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Promotion;

/**
 *
 * @author Bảo Châu Bống
 */
public class PromotionDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public Promotion getPromotion(int id) {
        Promotion promotion = null;
        try {
            query = "SELECT * FROM dbo.Promotion WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                promotion = new Promotion(rs.getInt("ID"), rs.getString("Title"), rs.getString("Content"), rs.getString("imageLink"), rs.getDate("date"));
            }
        } catch (SQLException e) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return promotion;
    }
    
//    public ArrayList<Promotion> getAllPromotion(){
//        ArrayList<Promotion> list = new ArrayList<>();
//        try{
//            query = "SELECT * FROM dbo.Promotion";
//            con = DBContext.getConnection();
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery();
//            
//            while (rs.next()){
//                list.add(new Promotion(0, query, query, query, date))
//            }
//        }
//    }
}
