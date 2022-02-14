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
import model.FoodAndDrink;

/**
 *
 * @author tenhik
 */
public class FoodDAO implements IFoodDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<FoodAndDrink> listAllFoodAndDrink() {
        ArrayList<FoodAndDrink> listFoodAndDrink = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.FastFood";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listFoodAndDrink.add(new FoodAndDrink(rs.getInt("foodId"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getFloat("price")
                ));
            }
        } catch (SQLException e) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return listFoodAndDrink;
    }

    public static void main(String[] args) {
        FoodDAO f = new FoodDAO();
        ArrayList<FoodAndDrink> list = f.listAllFoodAndDrink();
        for (FoodAndDrink foodAndDrink : list) {
            System.out.println(foodAndDrink.getName());
        }

    }

}
