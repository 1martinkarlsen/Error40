/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.ControlIF;
import Model.AdminDashboardLine;
import Model.Budget;
import Model.Campaign;
import Model.POE;
import Model.PartnerDashboardLine;
import Model.SellerDashboardLine;
import Model.users.User;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class ControlTest {

    public ControlTest() {
    }

    @Test
    public void testLogout() {
        User dummy = new User(5, 2, "dummmyName", "dummyPw", "dummyFirstName", "dummyLastName");
        String dummyID = "35";
        System.out.println("logout");
        ControlIF control = new Control();
        control.setUser(dummy);
        control.logout();
        assertEquals(control.getUser(), null);
        assertEquals(control.getID(), null);

    }
//
//    @Test
//    public void testLogin() {
//        System.out.println("login");
//        String username = "";
//        String password = "";
//        Control instance = new Control();
//        boolean expResult = false;
//        boolean result = instance.login(username, password);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAdminDashboardLines() {
//        System.out.println("getAdminDashboardLines");
//        Control instance = new Control();
//        Map<Integer, AdminDashboardLine> expResult = null;
//        Map<Integer, AdminDashboardLine> result = instance.getAdminDashboardLines();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetSellerDashboardLines() {
//        System.out.println("getSellerDashboardLines");
//        Control instance = new Control();
//        Map<Integer, SellerDashboardLine> expResult = null;
//        Map<Integer, SellerDashboardLine> result = instance.getSellerDashboardLines();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetPartnerDashboardLines() {
//        System.out.println("getPartnerDashboardLines");
//        Control instance = new Control();
//        Map<Integer, PartnerDashboardLine> expResult = null;
//        Map<Integer, PartnerDashboardLine> result = instance.getPartnerDashboardLines();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetUserRank() {
//        System.out.println("getUserRank");
//        Control instance = new Control();
//        int expResult = 0;
//        int result = instance.getUserRank();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetUser() {
//        System.out.println("getUser");
//        Control instance = new Control();
//        User expResult = null;
//        User result = instance.getUser();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetUserID() {
//        System.out.println("getUserID");
//        Control instance = new Control();
//        int expResult = 0;
//        int result = instance.getUserID();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetCampaign() {
//        System.out.println("getCampaign");
//        Control instance = new Control();
//        Map<Integer, Campaign> expResult = null;
//        Map<Integer, Campaign> result = instance.getCampaign();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetPOEs() {
//        System.out.println("getPOEs");
//        Control instance = new Control();
//        Map<Integer, POE> expResult = null;
//        Map<Integer, POE> result = instance.getPOEs();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetBudget() {
//        System.out.println("getBudget");
//        Control instance = new Control();
//        Map<Integer, Budget> expResult = null;
//        Map<Integer, Budget> result = instance.getBudget();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetUsers() {
//        System.out.println("getUsers");
//        Control instance = new Control();
//        Map<Integer, User> expResult = null;
//        Map<Integer, User> result = instance.getUsers();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

}
