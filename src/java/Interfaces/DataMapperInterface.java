/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.AdminDashboardLine;
import Model.Budget;
import Model.Campaign;
import Model.POE;
import Model.PartnerDashboardLine;
import Model.SellerDashboardLine;
import Model.users.User;
import java.util.Map;

/**
 *
 * @author Rasmus
 */
public interface DataMapperInterface {

    Map<String, AdminDashboardLine> getAllAdminDashboardLines();

    Map<String, Campaign> getAllCampaigns();

    Map<String, PartnerDashboardLine> getAllPartnerDashboardLines();
    
    Map<String, SellerDashboardLine> getAllSellerDashboardLines();

    boolean fillPartnerDashboardLines(int partnerID, Map<String, PartnerDashboardLine> partnerDashboardLines);

    boolean fillSellerDashboardLines(int sellerID, Map<String, SellerDashboardLine> sellerDashboardLines);

    Map<String, AdminDashboardLine> getAdminDashboardLines();

//    
//    boolean getAllBudgets();
//
//    boolean getAllPOEs();
//
//    boolean getAllUsers();

    Map<String, Budget> getBudgets();

    Map<String, Campaign> getCampaigns();

    Map<String, PartnerDashboardLine> getPartnerDashboardLines();

    Map<String, POE> getPoes();
    
    Map<String, User> getAllUsers();
    
    Map<String, Budget> getAllBudgets();
    
    Map<String, POE> getAllPOEs();

    Map<String, SellerDashboardLine> getSellerDashboardLines();

    AdminDashboardLine getSingleAdminDashboardLine(int sellerID);

    SellerDashboardLine getSingleSellerDashboardLine(int sellerID, int partnerID);

    Map<String, User> getUsers();

    // void resetLists();
    
     // Campaigns
    public boolean createCampaign(String name, String description, String target, String budget, 
            String start_day, String start_month, String start_year,
            String end_day, String end_month, String end_year,
            String objective, String partnerID, String sellerID);
    public boolean updateCampaign(String cID, String name, String description, String target, String budget, 
            String start_day, String start_month, String start_year,
            String end_day, String end_month, String end_year,
            String objective);
    public boolean approveCampaignProject(String cID, String rank);
    public boolean approveCampaignPOE(String cID, String rank);
    public boolean uploadFile(String cID, String partnerID, String name, String type); // Huske at sørge for at den selv generere navnet: QxFYxx
    
    // Users (to be add'ed).
    
}
