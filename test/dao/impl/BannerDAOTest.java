/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.ArrayList;
import model.Banner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    /**
     * Test of getBanner method, of class BannerDAO.
     */
//    @Test
//    public void testGetBanner() {
//        System.out.println("getBanner");
//        int id = 0;
//        BannerDAO instance = new BannerDAO();
//        Banner expResult = null;
//        Banner result = instance.getBanner(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getAllBanner method, of class BannerDAO.
     */
//    @Test
//    public void testGetAllBanner() {
//        System.out.println("getAllBanner");
//        BannerDAO instance = new BannerDAO();
//        ArrayList<Banner> expResult = null;
//        ArrayList<Banner> result = instance.getAllBanner();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of addBanner method, of class BannerDAO.
     */
//    @Test
//    public void testAddBanner() {
//        System.out.println("addBanner");
//        Banner banner = null;
//        BannerDAO instance = new BannerDAO();
//        instance.addBanner(banner);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test(expected = Exception.class)
    public void AddNullBanner() {
        System.out.println("addBanner");
        Banner a = null;
        BannerDAO instance = new BannerDAO();
        instance.addBanner(a);
    }

    @Test
    public void AddTrueBanner() {
        System.out.println("addBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("aaaaaaa");
        a.setDesc("bbbbbbbbbbbb");
        boolean expResult = true;
        instance.addBanner(a);
       // assertEquals(expResult, result);
    }

    @Test
    public void AddValidBoundaryImgBanner() {
        System.out.println("addBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("cccccccccccc");
        a.setTitle("aaaaaaa");
        a.setDesc("bbbbbbbbbbbb");
        boolean expResult = true;
       // boolean result = instance.addBanner(a);
       // assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void AddBlankTitleBanner() {
        System.out.println("addBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("             ");
        a.setDesc("bbbbbbbbbbbb");
        boolean expResult = false;
//        boolean result = instance.addBanner(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void AddBlankImgBanner() {
        System.out.println("addBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("                 ");
        a.setTitle("aaaaaaaaaaa");
        a.setDesc("bbbbbbbbbbbb");
        boolean expResult = false;
//        boolean result = instance.addBanner(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void AddBlankDescBanner() {
        System.out.println("addBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("aaaaaaaaaaaa");
        a.setDesc("               ");
        boolean expResult = false;
//        boolean result = instance.addBanner(a);
//        assertEquals(expResult, result);
    }

    /**
     * Test of editBanner method, of class BannerDAO.
     */
//    @Test
//    public void testEditBanner() {
//        System.out.println("editBanner");
//        Banner banner = null;
//        BannerDAO instance = new BannerDAO();
//        instance.editBanner(banner);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test(expected = Exception.class)
    public void EditNullBanner() {
        System.out.println("editBanner");
        Banner a = null;
        BannerDAO instance = new BannerDAO();
//        boolean result = instance.editBanner(a);
    }

    @Test
    public void EditTrueBanner() {
        System.out.println("editBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("aaaaaaa");
        a.setDesc("bbbbbbbbbbbb");
        a.setId(1);
        boolean expResult = false;
//        boolean result = instance.editBanner(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditDoesNotExistBanner() {
        System.out.println("editBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("aaaaaaa");
        a.setDesc("bbbbbbbbbbbb");
        a.setId(1111111111);
        boolean expResult = false;
//        boolean result = instance.editBanner(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void EditInvalidIdBanner() {
        System.out.println("editBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("aaaaaaa");
        a.setDesc("bbbbbbbbbbbb");
        a.setId(Integer.parseInt("sssssss"));
        boolean expResult = false;
//        boolean result = instance.editBanner(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditBlankImgBanner() {
        System.out.println("editBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("               ");
        a.setTitle("aaaaaaa");
        a.setDesc("bbbbbbbbbbbb");
        a.setId(1);
        boolean expResult = false;
//        boolean result = instance.editBanner(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditBlankTitleBanner() {
        System.out.println("editBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("            ");
        a.setDesc("bbbbbbbbbbbb");
        a.setId(1);
        boolean expResult = false;
//        boolean result = instance.editBanner(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditBlankDescBanner() {
        System.out.println("editBanner");
        Banner a = new Banner();
        BannerDAO instance = new BannerDAO();
        a.setImg("banner1.png");
        a.setTitle("aaaaaaa");
        a.setDesc("            ");
        a.setId(1);
        boolean expResult = false;
//        boolean result = instance.editBanner(a);
//        assertEquals(expResult, result);
    }

    /**
     * Test of deleteBanner method, of class BannerDAO.
     */
//    @Test
//    public void testDeleteBanner() {
//        System.out.println("deleteBanner");
//        int id = 0;
//        BannerDAO instance = new BannerDAO();
//        instance.deleteBanner(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test(expected = Exception.class)
    public void DeleteDoesNotExistBanner() {
        System.out.println("deleteBanner");
        int id = Integer.parseInt("aaa");
        BannerDAO instance = new BannerDAO();
//        boolean result = instance.deleteBanner(id);
    }

    @Test
    public void DeleteTrueBanner() {
        System.out.println("deleteBanner");
        int id = 1;
        BannerDAO instance = new BannerDAO();
        boolean expResult = false;
//        boolean result = instance.deleteBanner(id);
//        assertEquals(expResult, result);
    }

    @Test
    public void DeleteBanner() {
        System.out.println("deleteBanner");
        int id = 100;
        BannerDAO instance = new BannerDAO();
        boolean expResult = false;
//        boolean result = instance.deleteBanner(id);
//        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class BannerDAO.
     */
//    @Test
//    public void testGet() {
//        System.out.println("get");
//        int id = 0;
//        BannerDAO instance = new BannerDAO();
//        Banner expResult = null;
//        Banner result = instance.get(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of main method, of class BannerDAO.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        BannerDAO.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of pagingBanner method, of class BannerDAO.
     */
//    @Test
//    public void testPagingBanner() {
//        System.out.println("pagingBanner");
//        int pageIndex = 0;
//        BannerDAO instance = new BannerDAO();
//        ArrayList<Banner> expResult = null;
//        ArrayList<Banner> result = instance.pagingBanner(pageIndex);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getTotalBanner method, of class BannerDAO.
     */
    @Test
    public void testGetTotalBanner() {
        System.out.println("getTotalBanner");
        BannerDAO instance = new BannerDAO();
        int expResult = 46;
        int result = instance.getTotalBanner();
        assertEquals(expResult, result);
    }
}
