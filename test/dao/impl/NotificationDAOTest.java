/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Notification;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class NotificationDAOTest {

    public NotificationDAOTest() {
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

//    @Test
//    public void testGetAllNotification() {
//        System.out.println("getAllNotification");
//        NotificationDAO instance = new NotificationDAO();
//        ArrayList<Notification> expResult = null;
//        ArrayList<Notification> result = instance.getAllNotification();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//GetNotificationById

    @Test
    public void testGetNotificationByNormalId() {
        System.out.println("getNotificationById");
        int id = 1;
        NotificationDAO instance = new NotificationDAO();
        Notification expResult = new Notification();
        expResult.setNotificationId(1);
        expResult.setNotificationImg("832022.png");
        expResult.setNotificationTitle("Rộn ràng tuần lễ 8/3");
        expResult.setNotificationDescription("Nhiều chương trình khuyến mãi, vui chơi giải trí dành tặng cho chị em phụ nữ trong ngày 8.3 đang diễn ra trong tuần này .</br>Tại Trung tâm Amazing Cinema, giảm giá 10% cho tất cả khách hàng sử dũng MGG PHUNU83</br>Số lượng mã có hạn chỉ 100 MGG cho 100 quý khách hàng duy nhất.</br>Ngoài ra còn rất nhiều MGG 30% 50% cho những khác hàng may mắn.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        expResult.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        Notification result = instance.getNotificationById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNotificationByAbnormalId() {
        System.out.println("getNotificationById");
        int id = 0;
        NotificationDAO instance = new NotificationDAO();
        Notification expResult = null;
        Notification result = instance.getNotificationById(0);
        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void testGetNotificationByAbnormalId2() {
        System.out.println("getNotificationById");
        NotificationDAO instance = new NotificationDAO();;
        Notification result = instance.getNotificationById(Integer.parseInt("a"));
    }

//    @Test
//    public void testPagingNotification() {
//        System.out.println("pagingNotification");
//        int pageIndex = 0;
//        NotificationDAO instance = new NotificationDAO();
//        List<Notification> expResult = null;
//        List<Notification> result = instance.pagingNotification(pageIndex);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

// GetTotalNotification

    @Test
    public void testGetTotalNotification() {
        System.out.println("getTotalNotification");
        NotificationDAO instance = new NotificationDAO();
        int expResult = 3;
        int result = instance.getTotalNotification();
        assertEquals(expResult, result);
    }

// InsertNotification

    @Test
    public void testInserNormalNotification() {
        System.out.println("insertNotification");
        Notification a = new Notification();
        a.setNotificationImg("canh_bao_08032022.jpg");
        a.setNotificationTitle("Rộn ràng tuần lễ 8/3");
        a.setNotificationDescription("Nhiều chương trình khuyến mãi, vui chơi giải trí dành tặng cho chị em phụ nữ trong ngày 8.3 đang diễn ra trong tuần này .</br>Tại Trung tâm Amazing Cinema, giảm giá 10% cho tất cả khách hàng sử dũng MGG PHUNU83</br>Số lượng mã có hạn chỉ 100 MGG cho 100 quý khách hàng duy nhất.</br>Ngoài ra còn rất nhiều MGG 30% 50% cho những khác hàng may mắn.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = Boolean.TRUE;
        boolean result = instance.insertNotification(a);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testInserNullNotification() {
        System.out.println("insertNotification");
        Notification a = null;
        NotificationDAO instance = new NotificationDAO();
        boolean result = instance.insertNotification(a);
    }
    
    @Test
    public void testInserAbnormalNotification() {
        System.out.println("insertNotification");
        Notification a = new Notification();
        a.setNotificationImg("canh_bao_08032022.jpg");
        a.setNotificationTitle("Rộn ràng tuần lễ 8/3");
        a.setNotificationDescription("Nhiều chương trình khuyến mãi, vui chơi giải trí dành tặng cho chị em phụ nữ trong ngày 8.3 đang diễn ra trong tuần này .</br>Tại Trung tâm Amazing Cinema, giảm giá 10% cho tất cả khách hàng sử dũng MGG PHUNU83</br>Số lượng mã có hạn chỉ 100 MGG cho 100 quý khách hàng duy nhất.</br>Ngoài ra còn rất nhiều MGG 30% 50% cho những khác hàng may mắn.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("aa"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = Boolean.FALSE;
        boolean result = instance.insertNotification(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertValidBoundaryImgNotification() {
        System.out.println("insertNotification");
        Notification a = new Notification();
        a.setNotificationImg("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        a.setNotificationTitle("Rộn ràng tuần lễ 8/3");
        a.setNotificationDescription("Nhiều chương trình khuyến mãi, vui chơi giải trí dành tặng cho chị em phụ nữ trong ngày 8.3 đang diễn ra trong tuần này .</br>Tại Trung tâm Amazing Cinema, giảm giá 10% cho tất cả khách hàng sử dũng MGG PHUNU83</br>Số lượng mã có hạn chỉ 100 MGG cho 100 quý khách hàng duy nhất.</br>Ngoài ra còn rất nhiều MGG 30% 50% cho những khác hàng may mắn.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = Boolean.TRUE;
        boolean result = instance.insertNotification(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertInvalidBoundaryImgNotification() {
        System.out.println("insertNotification");
        Notification a = new Notification();
        a.setNotificationImg("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        a.setNotificationTitle("Rộn ràng tuần lễ 8/3");
        a.setNotificationDescription("Nhiều chương trình khuyến mãi, vui chơi giải trí dành tặng cho chị em phụ nữ trong ngày 8.3 đang diễn ra trong tuần này .</br>Tại Trung tâm Amazing Cinema, giảm giá 10% cho tất cả khách hàng sử dũng MGG PHUNU83</br>Số lượng mã có hạn chỉ 100 MGG cho 100 quý khách hàng duy nhất.</br>Ngoài ra còn rất nhiều MGG 30% 50% cho những khác hàng may mắn.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = Boolean.FALSE;
        boolean result = instance.insertNotification(a);
        assertEquals(expResult, result);
    }


// EditNotification

    @Test
    public void testEditNotificationWithAbnormalImg() {
        System.out.println("editNotification");
        Notification a = new Notification();
        a.setNotificationId(1);
        a.setNotificationImg("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        a.setNotificationTitle("Rộn ràng tuần lễ 8/3");
        a.setNotificationDescription("Nhiều chương trình khuyến mãi, vui chơi giải trí dành tặng cho chị em phụ nữ trong ngày 8.3 đang diễn ra trong tuần này .</br>Tại Trung tâm Amazing Cinema, giảm giá 10% cho tất cả khách hàng sử dũng MGG PHUNU83</br>Số lượng mã có hạn chỉ 100 MGG cho 100 quý khách hàng duy nhất.</br>Ngoài ra còn rất nhiều MGG 30% 50% cho những khác hàng may mắn.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = false;
        boolean result = instance.editNotification(a);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testEditNullNotification() {
        System.out.println("editNotification");
        Notification a = null;
        NotificationDAO instance = new NotificationDAO();
        boolean result = instance.editNotification(a);
    }

    @Test
    public void testEditNotificationWithValidBoundaryImg() {
        System.out.println("editNotification");
        Notification a = new Notification();
        a.setNotificationId(2);
        a.setNotificationImg("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        a.setNotificationTitle("Thông báo quan trọng");
        a.setNotificationDescription("Hiện tại đang có một tổ chức giả mạo hình ảnh của Amazing Cinema để trục lợi cá nhân .</br>Chúng tôi mong khách hàng cẩn trọng, không để bị lừa.</br>Hiện tại chúng tôi chỉ có duy nhất 1 trang web này.</br>Nếu phát hiện đối tượng mạo danh, mong quý khách liên hệ qua hotline 0941815064.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = true;
        boolean result = instance.editNotification(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testEditNotificationWithInvalidBoundaryImg() {
        System.out.println("editNotification");
        Notification a = new Notification();
        a.setNotificationId(2);
        a.setNotificationImg("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        a.setNotificationTitle("Thông báo quan trọng");
        a.setNotificationDescription("Hiện tại đang có một tổ chức giả mạo hình ảnh của Amazing Cinema để trục lợi cá nhân .</br>Chúng tôi mong khách hàng cẩn trọng, không để bị lừa.</br>Hiện tại chúng tôi chỉ có duy nhất 1 trang web này.</br>Nếu phát hiện đối tượng mạo danh, mong quý khách liên hệ qua hotline 0941815064.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = false;
        boolean result = instance.editNotification(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testEditNomalNotification() {
        System.out.println("editNotification");
        Notification a = new Notification();
        a.setNotificationId(2);
        a.setNotificationImg("canh_bao_08032022.jpg");
        a.setNotificationTitle("Thông báo quan trọng");
        a.setNotificationDescription("Hiện tại đang có một tổ chức giả mạo hình ảnh của Amazing Cinema để trục lợi cá nhân .</br>Chúng tôi mong khách hàng cẩn trọng, không để bị lừa.</br>Hiện tại chúng tôi chỉ có duy nhất 1 trang web này.</br>Nếu phát hiện đối tượng mạo danh, mong quý khách liên hệ qua hotline 0941815064.</br>Thông tin cụ thể liên hệ 0941815064.</br>Trân trọng!");
        a.setNotificationDate(java.sql.Date.valueOf("2022-03-12"));
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = true;
        boolean result = instance.editNotification(a);
        assertEquals(expResult, result);
    }


//DeleteNotification


    @Test
    public void testDeleteNotificationByAbnormalId() {
        System.out.println("deleteNotification");
        int notificationId = 100;
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = false;
        boolean result = instance.deleteNotification(notificationId);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteNotificationByNormalId() {
        System.out.println("deleteNotification");
        int notificationId = 4;
        NotificationDAO instance = new NotificationDAO();
        boolean expResult = true;
        boolean result = instance.deleteNotification(notificationId);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testDeleteNotificationByAbnormalId2() {
        System.out.println("deleteNotification");
        int notificationId = Integer.parseInt("aa");
        NotificationDAO instance = new NotificationDAO();
        boolean result = instance.deleteNotification(notificationId);
    }

//GetTotalNotificationByTitle()
    
    @Test
    public void testGetTotalNotificationByNormalTitle() {
        System.out.println("getTotalNotificationByTitle");
        String title = "n";
        NotificationDAO instance = new NotificationDAO();
        int expResult = 2;
        int result = instance.getTotalNotificationByTitle(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTotalNotificationByAbnormalTitle() {
        System.out.println("getTotalNotificationByTitle");
        String title = "xxxxxxxxxxxx";
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.getTotalNotificationByTitle(title);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalNotificationByEmptyTitle() {
        System.out.println("getTotalNotificationByTitle");
        String title = "";
        NotificationDAO instance = new NotificationDAO();
        int expResult = 0;
        int result = instance.getTotalNotificationByTitle(title);
        assertEquals(expResult, result);
    }

}
