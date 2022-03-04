/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.ArrayList;
import model.Recruitment;
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
public class RecruitmentDAOTest {
    
    public RecruitmentDAOTest() {
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
    public void testGetRecruitment() {
        System.out.println("getRecruitment");
        int id = 0;
        RecruitmentDAO instance = new RecruitmentDAO();
        Recruitment expResult = null;
        Recruitment result = instance.getRecruitment(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllRecruitment() {
        System.out.println("getAllRecruitment");
        RecruitmentDAO instance = new RecruitmentDAO();
        ArrayList<Recruitment> expResult = null;
        ArrayList<Recruitment> result = instance.getAllRecruitment();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddRecruitment() {
        System.out.println("addRecruitment");
        Recruitment recruitment = null;
        RecruitmentDAO instance = new RecruitmentDAO();
        instance.addRecruitment(recruitment);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditRecruitment() {
        System.out.println("editRecruitment");
        Recruitment recruitment = null;
        RecruitmentDAO instance = new RecruitmentDAO();
        instance.editRecruitment(recruitment);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteRecruitment() {
        System.out.println("deleteRecruitment");
        int id = 0;
        RecruitmentDAO instance = new RecruitmentDAO();
        instance.deleteRecruitment(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGet() {
        System.out.println("get");
        int id = 0;
        RecruitmentDAO instance = new RecruitmentDAO();
        Recruitment expResult = null;
        Recruitment result = instance.get(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RecruitmentDAO.main(args);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllChucVu() {
        System.out.println("getAllChucVu");
        RecruitmentDAO instance = new RecruitmentDAO();
        ArrayList<Recruitment> expResult = null;
        ArrayList<Recruitment> result = instance.getAllChucVu();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
