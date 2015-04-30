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
    
    public Map<Integer, AdminDashboardLine> getAdminDashboardLines();
    public Map<Integer, SellerDashboardLine> getSellerDashboardLines();
    public Map<Integer, PartnerDashboardLine> getPartnerDashboardLines();
    
    public int getUserRank();
    public int getUserID();
    public User getUser();
    public Map<Integer, Campaign> getCampaign();
    public Map<Integer, POE> getPOEs();
    public Map<Integer, Budget> getBudget();
    public Map<Integer, User> getUsers();
}
