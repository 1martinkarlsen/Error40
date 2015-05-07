/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.AuthentificationIF;
import Interfaces.ControlIF;
import Interfaces.DataMapperIF;
import Model.AdminDashboardLine;
import Model.AuthentificationStub;
import Model.Budget;
import Model.Campaign;
import Model.DataMapper;
import Model.DataMapperStub;
import Model.POE;
import Model.PartnerDashboardLine;
import Model.SellerDashboardLine;
import Model.users.User;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
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
        DataMapperIF dm = new DataMapperStub();
        AuthentificationIF au = new AuthentificationStub();
        ControlIF control = new Control(dm, au);
        
        System.out.println("logout");
        User dummy = new User(5, 2, "dummmyName", "dummyPw", "dummyFirstName", "dummyLastName");
        String dummyID = "35";
        
        control.setUser(dummy);
        control.logout();
        assertEquals(control.getUser(), null);
        assertEquals(control.getID(), null);

    }

    @Test
    public void testLoginTrue() {
        DataMapperIF dm = new DataMapperStub();
        AuthentificationIF au = new AuthentificationStub();
        ControlIF control = new Control(dm, au);
        
        System.out.println("login");
        String username = "dummyName";
        String password = "dummyPw";
        
        boolean expResult = true;
        boolean result = control.login(username, password);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testLoginFalse() {
        DataMapperIF dm = new DataMapperStub();
        AuthentificationIF au = new AuthentificationStub();
        ControlIF control = new Control(dm, au);
        
        System.out.println("login");
        String username = "dummName";
        String password = "dummyPw";
        
        boolean expResult = false;
        boolean result = control.login(username, password);
        assertEquals(expResult, result);
        
    }


    @Test
    public void testGetAdminDashboardLines() {
        System.out.println("getAdminDashboardLines");
        DataMapperIF dm = new DataMapperStub();
        AuthentificationIF au = new AuthentificationStub();
        ControlIF control = new Control(dm, au);
        
        Map<Integer, AdminDashboardLine> lines = control.getAdminDashboardLines();
        
        assertThat(lines.size(), is(2));
        assertThat(lines.get(1).getBudget_used(), is(500));
        assertTrue(lines.get(1).getName().equals("Ole") );
        assertThat(lines.get(2).getBudget_used(), is(1000));
        assertTrue(lines.get(2).getName().equals("Vera") );
        
        
        
        
    }

    @Test
    public void testGetSellerDashboardLines() {
        System.out.println("getSellerDashboardLines");
        DataMapperIF dm = new DataMapperStub();
        AuthentificationIF au = new AuthentificationStub();
        ControlIF control = new Control(dm, au);
        
        Map<Integer, SellerDashboardLine> lines = control.getSellerDashboardLines();
        
        
        assertThat(lines.size(), is(2));
        assertThat(lines.get(9).getBudget_used(), is(500));
        assertTrue(lines.get(9).getName().equals("Emanuel") );
        assertThat(lines.get(13).getBudget_used(), is(505));
        assertTrue(lines.get(13).getName().equals("SuperSeller") );
        
        
        
    }

    @Test
    public void testGetPartnerDashboardLines() {
        System.out.println("getPartnerDashboardLines");
        DataMapperIF dm = new DataMapperStub();
        AuthentificationIF au = new AuthentificationStub();
        ControlIF control = new Control(dm, au);
        
        Map<Integer, PartnerDashboardLine> lines = control.getPartnerDashboardLines();
                
        assertThat(lines.size(), is(2));
        assertThat(lines.get(9).getBudget(), is(3500));
        assertTrue(lines.get(9).getName().equals("Kampagne 9") );
        assertThat(lines.get(42).getBudget(), is(4400));
        assertTrue(lines.get(42).getCurrentState().equals("Pending") );
    }

    @Test
    public void testGetUserRank() {
        System.out.println("getUserRank");
        DataMapperIF dm = new DataMapperStub();
        AuthentificationIF au = new AuthentificationStub();
        ControlIF control = new Control(dm, au);
        
        User dummy1 = new User(5, 1, "dummmyName", "dummyPw", "dummyFirstName", "dummyLastName");
        User dummy2 = new User(6, 2, "dummmyName", "dummyPw", "dummyFirstName", "dummyLastName");
        User dummy3 = new User(7, 3, "dummmyName", "dummyPw", "dummyFirstName", "dummyLastName");
        
        control.setUser(dummy1);
        assertThat(control.getUserRank(), is(1));
        
        control.setUser(dummy2);
        assertThat(control.getUserRank(), is(2));
        
        control.setUser(dummy3);
        assertThat(control.getUserRank(), is(3));
              
    }

//    @Test
//    public void testGetUser() {
//        System.out.println("getUser");
//        Control instance = new Control();
//        User expResult = null;
//        User result = instance.getUser();
//        assertEquals(expResult, result);
//        
//    }
//
//    @Test
//    public void testGetUserID() {
//        System.out.println("getUserID");
//        Control instance = new Control();
//        int expResult = 0;
//        int result = instance.getUserID();
//        assertEquals(expResult, result);
//        
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
