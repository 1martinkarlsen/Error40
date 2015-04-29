/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Model.AdminDashboardLine;
import Model.Campaign;
import Model.DataMapper;
import Model.SellerDashboardLine;
import Model.PartnerDashboardLine;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rasmus
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        DataMapper dm = new DataMapper();
        
        AdminDashboardLine value;
        SellerDashboardLine value2;
        PartnerDashboardLine value3;
        /*
         dm.getAllUsers();
         System.out.println("\nAll users");
         for (User u : dm.getUsers()) {
         System.out.println(u.getId() + ", " + u.getRank() + ", " + u.getUserName() + ", " + u.getPassword() + ", " + u.getFirstName() + ", " + u.getLastName() + ", " + u.getPhoneNr() + ", " + u.getEmail() + ", " + u.getShopName() + ", " + u.getAddress());

         }
        
         System.out.println("\nAll budgets");
         dm.getAllBudgets();
         for (Budget b : dm.getBudgets()) {
         System.out.println(b.getId() + ", " + b.getName());

         }
         System.out.println("\nAll POEs");
         dm.getAllPOEs();
         for (POE p : dm.getPoes()) {
         System.out.println(p.getId() + ", " + p.getName() + ", " + p.getPoe_url() + ", " + p.getCampaignID());

         }

         System.out.println("\nAll Campaigns");
         dm.fillAllCampaigns();
         for (Campaign c : dm.getCampaigns()) {
         System.out.println(c.getId() + ", " + c.getName() + ", " + c.getBudget() + ", " + c.getCamp_url() + ", " + c.getStepNumber() + ", " + c.getApprove_project() + ", " + c.getApprove_POE() + ", " + c.getPartnerID() + ", " + c.getSellerID() + ", " + c.getPoeID());

         }
        
         System.out.println("\nBudget for Bente (3):" + dm.getBudgetForSeller(3));
         System.out.println("\nBudgets used for Bente (3):" + dm.getAllExecutedBudgetsForSeller(3));
         System.out.println("\nPending campaigns for Bente (3):" + dm.getPendingCampaginsForSeller(3));
         System.out.println("\nPending campaign sum for Bente (3):" + dm.getPendingSumCampaginsForSeller(3));
         System.out.println("\nCompleted campaigns for Bente (3):" + dm.getCompletedCampaginsForSeller(3));
         System.out.println("\nCompleted campaign sum for Bente (3):" + dm.getCompletedSumCampaginsForSeller(3));

         System.out.println(dm.fillAllCampaigns());
         */

//        System.out.println("admin dashboard view sellers:");
//        System.out.println("-----------------------------");
//        
//       
//        dm.fillAllAdminDashboardLines();
//        
//        for (Map.Entry<String, AdminDashboardLine> entry : dm.getAdminDashboardLines().entrySet()) {
//            value = entry.getValue();
//            
//            System.out.println(value.getName() + "(" + value.getSellerId() + "), " + value.getAmountCampaigns() + ", " + value.getSellerBudget()
//                    + ", " + value.getBudget_used() + ", " + value.getPendingCampaigns()
//                    + ", " + value.getPendingCampaignsCost() + ", " + value.getCompletedCampaigns()
//                    + ", " + value.getCompletedCampaignsCost());
//        }

        System.out.println("seller dashboard view partners:");
        System.out.println("-------------------------------");

        dm.fillAllSellerDashboardLines();

        for (Map.Entry<String, SellerDashboardLine> entry : dm.getSellerDashboardLines().entrySet()) {
            value2 = entry.getValue();
            System.out.println(value2.getId() + ": (" + value2.getPartnerId() + ")" + value2.getName() + ", " + value2.getAmountCampaigns()
                    + ", " + value2.getBudget_used() + ", " + value2.getPendingCampaigns()
                    + ", " + value2.getPendingCampaignsCost() + ", " + value2.getCompletedCampaigns()
                    + ", " + value2.getCompletedCampaignsCost());
        }

//        System.out.println("partner dashboard view campaigns:");
//        System.out.println("---------------------------------");
//
//        dm.fillAllPartnerDashboardLines();
//        //dm.fillPartnerDashboardLines(9);
//        for (Map.Entry<String, PartnerDashboardLine> entry : dm.getPartnerDashboardLines().entrySet()) {
//            value3 = entry.getValue();
//            if (value3 != null) {
//                System.out.println(value3.getId() + ": " + value3.getName() + ", " + value3.getSellerName() + ", "
//                        + value3.getBudget() + ", " + value3.getCurrentState());
//                //System.out.println();
//            }
//        }

//        SellerDashboardLine sdl = dm.getSingleSellerDashboardLine(3, 9);
//        if (sdl != null) {
//            System.out.println(sdl.getId() + ": (" + sdl.getPartnerID() + ")" + sdl.getName() + ", " + sdl.getAmountCampaigns()
//                    + ", " + sdl.getBudget_used() + ", " + sdl.getPendingCampaigns()
//                    + ", " + sdl.getPendingCampaignsCost() + ", " + sdl.getCompletedCampaigns()
//                    + ", " + sdl.getCompletedCampaignsCost());
//        }
//
//         System.out.println(a.getName() + ", " + a.getAmountCampaigns() + ", " + a.getSellerBudget()
//         + ", " + a.getBudget_used() + ", " + a.getPendingCampaigns()
//         + ", " + a.getPendingCampaignsCost() + ", " + a.getCompletedCampaigns()
//         + ", " + a.getCompletedCampaignsCost());
//        PartnerDashboardLine a = dm.getSinglePartnerDashboardLine(3);
//
//        System.out.println(a.getName() + ", " + a.getSellerName() + ", " + a.getBudget() + ", " + a.getCurrentState());
    }

}
