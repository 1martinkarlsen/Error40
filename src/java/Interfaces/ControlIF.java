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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author simon
 */
public interface ControlIF {
    public void logout();
    public boolean login(String username, String password);
    
    public Map<String, AdminDashboardLine> getAdminDashboardLines();
    public Map<String, SellerDashboardLine> getSellerDashboardLines();
    public Map<String, PartnerDashboardLine> getPartnerDashboardLines();
    
    public String getUserRank();
    public String getUserID();
    public User getUser();
    public Map<String, Campaign> getCampaign();
    public Map<String, POE> getPOEs();
    public Map<String, Budget> getBudget();
    public Map<String, User> getUsers();
}
