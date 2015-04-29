/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Controller.Control;
import Interfaces.ControlIF;
import Model.AdminDashboardLine;
import Model.PartnerDashboardLine;
import Model.SellerDashboardLine;
import java.util.Scanner;

/**
 *
 * @author simon
 */
public class TestControl {

    ControlIF control = new Control();

    public void login() {
        String username = "";
        String password = "";

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Login...");
            System.out.print("username: ");
            username = scan.next();
            System.out.print("password: ");
            password = scan.next();
        } while (!control.login(username, password));

    }

    public void logout() {
        System.out.println("Logging out...");
        control.logout();
    }

//    public void startPage() {
//        System.out.println("\nLogged in as: " + control.getUser().getUserName() + "("
//                + control.getUserRank() + ") ...");
//
//        switch (control.getUserRank()) {
//            case "3":
//                adminDashboard();
//                break;
//            case "2":
//                sellerDashboard();
//                break;
//            case "1":
//                partnerDashboard();
//                break;
//               
//
//        }
//    }
    
//    public void partnerDashboard() {
//        System.out.println("Partner dashboard");
//        System.out.println("-----------------");
//        System.out.println("Campaigns: ");
//        for (PartnerDashboardLine pdl : control.getPartnerDashboardLines()) {
//            if (pdl != null) {
//                System.out.println(pdl.getId() + ": " + pdl.getName() + ", " + pdl.getSellerName() + ", "
//                        + pdl.getBudget() + ", " + pdl.getCurrentState());
//                //System.out.println();
//            }
//        }
//    }
//    
//    public void sellerDashboard() {
//        System.out.println("Seller dashboard");
//        System.out.println("----------------");
//        System.out.println("Partners: ");
//        for (SellerDashboardLine sdl : control.getSellerDashboardLines()) {
//            System.out.println(sdl.getId() + ": (" + sdl.getPartnerId() + ")" + sdl.getName() + ", " + sdl.getAmountCampaigns()
//                    + ", " + sdl.getBudget_used() + ", " + sdl.getPendingCampaigns()
//                    + ", " + sdl.getPendingCampaignsCost() + ", " + sdl.getCompletedCampaigns()
//                    + ", " + sdl.getCompletedCampaignsCost());
//        }
//    }
//    
//
//    public void adminDashboard() {
//        System.out.println("Admin dashboard");
//        System.out.println("---------------");
//        System.out.println("Sellers: ");
//        for (AdminDashboardLine adl : control.getAdminDashboardLines()) {
//            System.out.println(adl.getName() + "(" + adl.getSellerId() + "), " + adl.getAmountCampaigns()
//                    + ", " + adl.getSellerBudget()
//                    + ", " + adl.getBudget_used() + ", " + adl.getPendingCampaigns()
//                    + ", " + adl.getPendingCampaignsCost() + ", " + adl.getCompletedCampaigns()
//                    + ", " + adl.getCompletedCampaignsCost());
//        }
//
//    }

    public static void main(String[] args) {

        TestControl tc = new TestControl();

        tc.login();
        

        System.out.println("Logged in...");
        
        String choice = "";
        boolean quit = false;

        Scanner scan = new Scanner(System.in);

//        do {
//            tc.startPage();
//            System.out.println("Menu...");
//            
//            System.out.println("1): logout ");
//            
//            choice = scan.next();
//            
//            if(choice.equals("1")) {
//                tc.control.logout();
//                tc.login();
//                
//                
//                
//            }
//            if(choice.equals("q")) {
//                quit = true;
//            }
//            
//            
//        } while (!quit);

        

    }
}
