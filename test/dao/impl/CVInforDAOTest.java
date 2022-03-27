/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.ArrayList;
import model.CVInfor;
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
public class CVInforDAOTest {

    public CVInforDAOTest() {
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
     * Test of getCV method, of class CVInforDAO.
     */
//    @Test
//    public void testGetCV() {
//        System.out.println("getCV");
//        int id = 0;
//        CVInforDAO instance = new CVInforDAO();
//        CVInfor expResult = null;
//        CVInfor result = instance.getCV(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getAllCV method, of class CVInforDAO.
     */
//    @Test
//    public void testGetAllCV() {
//        System.out.println("getAllCV");
//        CVInforDAO instance = new CVInforDAO();
//        ArrayList<CVInfor> expResult = null;
//        ArrayList<CVInfor> result = instance.getAllCV();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of main method, of class CVInforDAO.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        CVInforDAO.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addCV method, of class CVInforDAO.
//     */
//    @Test
//    public void testAddCV() {
//        System.out.println("addCV");
//        CVInfor cvinfor = null;
//        CVInforDAO instance = new CVInforDAO();
//        instance.addCV(cvinfor);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test(expected = Exception.class)
    public void AddNullCV() {
        System.out.println("addCV");
        CVInfor a = null;
        CVInforDAO instance = new CVInforDAO();
//        boolean result = instance.addCV(a);
    }

    @Test
    public void AddInvalidCV() {
        System.out.println("addCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setFullname("             ");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        boolean expResult = false;
//        boolean result = instance.addCV(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void AddTrueCV() {
        System.out.println("addCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setFullname("Le Van A");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        boolean expResult = false;
//        boolean result = instance.addCV(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void AddValidBoundaryImgCV() {
        System.out.println("addCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setFullname("Le Van A");
        a.setCV("alkjsdfhalksdjfhsalkd");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        boolean expResult = false;
//        boolean result = instance.addCV(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void AddWrongChucvuCV() {
        System.out.println("addCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setFullname("Le Van A");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(Integer.parseInt("aaaaaaaaaaaa"));
        boolean expResult = false;
//        boolean result = instance.addCV(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void AddWrongDateCV() {
        System.out.println("addCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setFullname("Le Van A");
        a.setCV("cv3.png");
        a.setDate("aaaaaaaaaaa");
        a.setChucvu(2);
        boolean expResult = false;
//        boolean result = instance.addCV(a);
//        assertEquals(expResult, result);
    }

    /**
     * Test of editCV method, of class CVInforDAO.
     */
//    @Test
//    public void testEditCV() {
//        System.out.println("editCV");
//        CVInfor cvinfor = null;
//        CVInforDAO instance = new CVInforDAO();
//        instance.editCV(cvinfor);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test(expected = Exception.class)
    public void EditNullCV() {
        System.out.println("editCV");
        CVInfor a = null;
        CVInforDAO instance = new CVInforDAO();
//        boolean result = instance.editCV(a);
    }

    @Test
    public void EditDoesNotExistCV() {
        System.out.println("editCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setId(1111);
        a.setFullname("Lê Văn A");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        a.setStatus(1);
        boolean expResult = false;
//        boolean result = instance.editFullCV(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditTrueCV() {
        System.out.println("editCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setId(1);
        a.setFullname("Lê Văn A");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        a.setStatus(1);
        boolean expResult = false;
//        boolean result = instance.editCV(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditInvalidFullnameCV() {
        System.out.println("editCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setId(1);
        a.setFullname("                ");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        a.setStatus(1);
        boolean expResult = false;
//        boolean result = instance.editFullCV(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditWrongBoundaryImgCV() {
        System.out.println("editCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setId(1);
        a.setFullname("Lê Văn A");
        a.setCV("aaaaaaaaaaaaaaaaaaaaaaa");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        a.setStatus(1);
        boolean expResult = false;
//        boolean result = instance.editFullCV(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditInvalidDateCV() {
        System.out.println("editCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setId(1);
        a.setFullname("Lê Văn A");
        a.setCV("cv3.png");
        a.setDate("aaaaaaaaaaaaaaaa");
        a.setChucvu(2);
        a.setStatus(1);
        boolean expResult = false;
//        boolean result = instance.editFullCV(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void EditInvalidChucvuCV() {
        System.out.println("editCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setId(1);
        a.setFullname("Lê Văn A");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(Integer.parseInt("aaaaaaaaaaaaa"));
        a.setStatus(1);
        boolean expResult = false;
//        boolean result = instance.editFullCV(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void EditInvalidStatusCV() {
        System.out.println("editCV");
        CVInfor a = new CVInfor();
        CVInforDAO instance = new CVInforDAO();
        a.setId(1);
        a.setFullname("Lê Văn A");
        a.setCV("cv3.png");
        a.setDate("DATE '2021-05-19'");
        a.setChucvu(2);
        a.setStatus(Integer.parseInt("aaaaaaaaaaaaa"));
        boolean expResult = false;
//        boolean result = instance.editFullCV(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void EditFullNullCV() {
        System.out.println("editCV");
        CVInfor a = null;
        CVInforDAO instance = new CVInforDAO();
//        boolean result = instance.editCV(a);
    }

    /**
     * Test of deleteCV method, of class CVInforDAO.
     */
//    @Test
//    public void testDeleteCV() {
//        System.out.println("deleteCV");
//        int id = 0;
//        CVInforDAO instance = new CVInforDAO();
//        instance.deleteCV(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test
    public void DeleteDoesNotExistCV() {
        System.out.println("deleteCV");
        int id = Integer.parseInt("100");
        CVInforDAO instance = new CVInforDAO();
        boolean expResult = false;
//        boolean result = instance.deleteCV(id);
//        assertEquals(expResult, result);
    }

    @Test
    public void DeleteCV() {
        System.out.println("deleteCV");
        int id = Integer.parseInt("2");
        CVInforDAO instance = new CVInforDAO();
        boolean expResult = false;
//        boolean result = instance.deleteCV(id);
//        assertEquals(expResult, result);
    }

    @Test
    public void DeleteCV2() {
        System.out.println("deleteCV");
        int id = Integer.parseInt("1");
        CVInforDAO instance = new CVInforDAO();
        boolean expResult = false;
//        boolean result = instance.deleteCV(id);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void DeleteCV3() {
        System.out.println("deleteCV");
        int id = Integer.parseInt("aa");
        CVInforDAO instance = new CVInforDAO();
//        boolean result = instance.deleteCV(id);
    }

    @Test(expected = Exception.class)
    public void DeleteCV4() {
        System.out.println("deleteCV");
        int id = Integer.parseInt("    ");
        CVInforDAO instance = new CVInforDAO();
//        boolean result = instance.deleteCV(id);
    }
    /**
     * Test of getAllStatus method, of class CVInforDAO.
     */
//    @Test
//    public void testGetAllStatus() {
//        System.out.println("getAllStatus");
//        CVInforDAO instance = new CVInforDAO();
//        ArrayList<CVInfor> expResult = null;
//        ArrayList<CVInfor> result = instance.getAllStatus();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
