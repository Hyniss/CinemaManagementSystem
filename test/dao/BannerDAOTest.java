/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Banner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Bảo Châu Bống
 */
public class BannerDAOTest {

    public BannerDAOTest() {
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
    public void testGetBanner() {
        System.out.println("getBanner");
        int id = 1;
        BannerDAO instance = new BannerDAO();
        ArrayList<Banner> expResult = new ArrayList<>();
        expResult.add(new Banner(1, "banner1.png", "Phim kinh d? m?i", "Phim kinh d? m?i phá ?? m?i k? l?c c?"));
        expResult.add(new Banner(2, "banner2.png", "Phim hài", "Phim hài"));
        expResult.add(new Banner(3, "banner3.png", "Phim hành động mới", "Kịch tính, hồi hộp"));
        expResult.add(new Banner(4, "banner4.png", "Minh Hằng quay trở lại", "Giữ nguyên các cảnh nóng bỏng, táo bạo nhất trên màn ảnh"));
        expResult.add(new Banner(5, "banner5.png", "Official Trailer", "Phim hài Tết của Thu Trang"));
        expResult.add(new Banner(6, "banner6.png", "Suất chiếu đặc biệt", "Phim có nhiều yếu tố nghệ thuật"));
        Banner result = instance.getBanner(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllBanner() {
        System.out.println("getAllBanner");
        BannerDAO instance = new BannerDAO();
        ArrayList<Banner> expResult = null;
        expResult.add(new Banner(1, "banner1.png", "Phim kinh d? m?i", "Phim kinh d? m?i phá ?? m?i k? l?c c?"));
        expResult.add(new Banner(2, "banner2.png", "Phim hài", "Phim hài"));
        expResult.add(new Banner(3, "banner3.png", "Phim hành động mới", "Kịch tính, hồi hộp"));
        expResult.add(new Banner(4, "banner4.png", "Minh Hằng quay trở lại", "Giữ nguyên các cảnh nóng bỏng, táo bạo nhất trên màn ảnh"));
        expResult.add(new Banner(5, "banner5.png", "Official Trailer", "Phim hài Tết của Thu Trang"));
        expResult.add(new Banner(6, "banner6.png", "Suất chiếu đặc biệt", "Phim có nhiều yếu tố nghệ thuật"));
        ArrayList<Banner> result = instance.getAllBanner();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddBanner() {
        System.out.println("addBanner");
        String Img = "banner3.png";
        String Title = "test unit";
        String desc = "test unit";
        BannerDAO instance = new BannerDAO();
        instance.addBanner(new Banner(Img, Title, desc));
    }

    @Test
    public void testEditBanner1() {
        System.out.println("editBanner");
        String Img = "banner3.png";
        String Title = "test unit";
        String desc = "test unit";
        int id = 1;
        BannerDAO instance = new BannerDAO();
        instance.editBanner(new Banner(Img, Title, desc));
    }
    
    @Test
    public void testEditBanner16() {
        System.out.println("editBanner");
        String Img = "banner3.png";
        String Title = "test unit1234";
        String desc = "test unit";
        int id = 16;
        BannerDAO instance = new BannerDAO();
        instance.editBanner(new Banner(Img, Title, desc));
    }

    @Test
    public void testDeleteBanner7() {
        System.out.println("deleteBanner");
        int id = 7;
        BannerDAO instance = new BannerDAO();
        instance.deleteBanner(id);
    }
    
    @Test
    public void testDeleteBanner17() {
        System.out.println("deleteBanner");
        int id = 17;
        BannerDAO instance = new BannerDAO();
        instance.deleteBanner(id);
    }
}
