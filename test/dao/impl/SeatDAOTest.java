/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import model.Seat;
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
public class SeatDAOTest {

    public SeatDAOTest() {
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
     * Test of getSeatInfoBySeatId method, of class SeatDAO.
     */
    @Test
    public void GetSeatInfoBySeatId() {
        System.out.println("getSeatInfoBySeatId");
        String seatId = "A1";
        SeatDAO instance = new SeatDAO();
        Seat expResult = new Seat();
        expResult.setSeatId(seatId);
        expResult.setSeatNumber(1);
        expResult.setSeatRow("A    ");
        expResult.setPrice("55000.0");
        Seat result = instance.getSeatInfoBySeatId(seatId);
        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void GetSeatInfoBySeatId2() {
        System.out.println("getSeatInfoBySeatId");
        SeatDAO instance = new SeatDAO();
        Seat result = instance.getSeatInfoBySeatId("111111111");
    }

    @Test(expected = Exception.class)
    public void AddNullSeat() {
        System.out.println("addBanner");
        Seat a = null;
        SeatDAO instance = new SeatDAO();
//        boolean result = instance.addSeat(a);
    }

    @Test
    public void AddTrueSeat() {
        System.out.println("addSeat");
        Seat a = new Seat();
        SeatDAO instance = new SeatDAO();
        a.setSeatId("A10");
        a.setSeatNumber(1);
        a.setSeatRow("A");
        a.setPrice("65000");
        boolean expResult = false;
//        boolean result = instance.addSeat(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void AddInvalidNumberSeat() {
        System.out.println("addSeat");
        Seat a = new Seat();
        SeatDAO instance = new SeatDAO();
        a.setSeatId("A10");
        a.setSeatNumber(Integer.parseInt("aaa"));
        a.setSeatRow("A");
        a.setPrice("65000");
        boolean expResult = false;
//        boolean result = instance.addSeat(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void AddBlankIdSeat() {
        System.out.println("addSeat");
        Seat a = new Seat();
        SeatDAO instance = new SeatDAO();
        a.setSeatId("                   ");
        a.setSeatNumber(1);
        a.setSeatRow("A");
        a.setPrice("65000");
        boolean expResult = false;
//        boolean result = instance.addSeat(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void AddBlankRowSeat() {
        System.out.println("addSeat");
        Seat a = new Seat();
        SeatDAO instance = new SeatDAO();
        a.setSeatId("A10");
        a.setSeatNumber(1);
        a.setSeatRow("                    ");
        a.setPrice("65000");
        boolean expResult = false;
//        boolean result = instance.addSeat(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void AddBlankPriceSeat() {
        System.out.println("addSeat");
        Seat a = new Seat();
        SeatDAO instance = new SeatDAO();
        a.setSeatId("A10");
        a.setSeatNumber(1);
        a.setSeatRow("A");
        a.setPrice("65000");
        boolean expResult = false;
//        boolean result = instance.addSeat(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void EditNullSeat() {
        System.out.println("editBanner");
        Seat a = null;
        SeatDAO instance = new SeatDAO();
//       boolean result = instance.editSeat(a);
    }

    @Test
    public void EditTrueSeat() {
        System.out.println("editSeat");
        Seat a = new Seat();
        SeatDAO instance = new SeatDAO();
        a.setSeatId("A10");
        a.setSeatNumber(1);
        a.setSeatRow("A");
        a.setPrice("65000");
        boolean expResult = false;
//        boolean result = instance.editSeat(a);
//        assertEquals(expResult, result);
    }

    @Test
    public void EditInvalidNumberSeat() {
        System.out.println("editSeat");
        Seat a = new Seat();
        SeatDAO instance = new SeatDAO();
        a.setSeatId("A10");
        a.setSeatNumber(Integer.parseInt("aaa"));
        a.setSeatRow("A");
        a.setPrice("65000");
        boolean expResult = false;
//        boolean result = instance.editSeat(a);
//        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void DeleteDoesNotExistSeat() {
        System.out.println("deleteBanner");
        SeatDAO instance = new SeatDAO();
//        boolean result = instance.deleteSeat("aaaa");
    }

    @Test
    public void DeleteSeat() {
        System.out.println("deleteSeat");
        String id = "A3";
        SeatDAO instance = new SeatDAO();
        boolean expResult = false;
//        boolean result = instance.deleteSeat(id);
//        assertEquals(expResult, result);
    }
}
