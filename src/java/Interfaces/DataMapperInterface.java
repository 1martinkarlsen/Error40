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

    boolean fillAllAdminDashboardLines();

    boolean fillAllCampaigns();

    boolean fillAllPartnerDashboardLines();
    //    public Campaign getSingleCampaign(String id) {
    //
    //        String sql = "SELECT * FROM dell_campaigns "
    //                + "WHERE id = " + id;
    //
    //        try {
    //            con = new Db().getConnection();
    //
    //            statement = con.createStatement();
    //            rs = statement.executeQuery(sql);
    //            if(rs.next()) {
    //                return new Campaign(rs.getInt("id"), rs.getString("name"), rs.getInt("stepNumber"), rs.getString("description"), String start_day, String start_month, String start_year, String end_day, String end_month, String end_year, String target, String objective, int approve_seller_project, int approve_partner_project, int approve_seller_POE, int partnerID, int sellerID, int budgetID)
    //           return null;
    //            }
    //        } catch (Exception e) {
    //        }
    //
    //        try {
    //            con.close();
    //        } catch (Exception e) {
    //        }
    //    return null;
    //    }

    boolean fillAllSellerDashboardLines();

    boolean fillPartnerDashboardLines(int partnerID);

    boolean fillSellerDashboardLines(int sellerID);

    Map<String, AdminDashboardLine> getAdminDashboardLines();

    boolean getAllBudgets();

    boolean getAllPOEs();

    boolean getAllUsers();

    Map<String, Budget> getBudgets();

    Map<String, Campaign> getCampaigns();

    Map<String, PartnerDashboardLine> getPartnerDashboardLines();

    Map<String, POE> getPoes();
    
    boolean fillAllUsers();
    
    boolean fillAllBudgets();
    
    boolean fillAllPOEs();

    Map<String, SellerDashboardLine> getSellerDashboardLines();

    AdminDashboardLine getSingleAdminDashboardLine(int sellerID);

    SellerDashboardLine getSingleSellerDashboardLine(int sellerID, int partnerID);

    Map<String, User> getUsers();

    void resetLists();
    
}
