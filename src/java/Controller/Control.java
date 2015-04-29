/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.ControlIF;
import Model.AdminDashboardLine;
import Model.Authentification;
import Model.AuthentificationInterface;
import Model.Budget;
import Model.Campaign;
import Model.DataMapper;
import Interfaces.DataMapperInterface;
import Model.DataPutter;
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
public class Control implements ControlIF {

    private DataMapperInterface dm;
    private DataPutter dp = new DataPutter();
    private AuthentificationInterface au;
    
    private String rank = null;
    private User u = null;
    private String id = null;

    public Control() {
        dm = new DataMapper();
        au = new Authentification(); 
    }
    
    public Control(DataMapperInterface stubDm, AuthentificationInterface stubAu) {
        dm = stubDm;
        au = stubAu;
    }
    
    public void logout() {
        u = null;
        id = null;
        dm.resetLists();
    }

    public boolean login(String username, String password) {
        u = au.validate(username, password);
        
        return u != null;
    }

    public Map<String, AdminDashboardLine> getAdminDashboardLines() {
        // Fill in a list of admin dashboard lines.
        if (dm.getAdminDashboardLines().isEmpty()) {
            dm.fillAllAdminDashboardLines();
        } else {
            dm.resetLists();
            dm.fillAllAdminDashboardLines();
        }

        return dm.getAdminDashboardLines();
    }

    public Map<String, SellerDashboardLine> getSellerDashboardLines() {
        dm.resetLists();
        dm.fillAllSellerDashboardLines();
        return dm.getSellerDashboardLines();
    }

    public Map<String, PartnerDashboardLine> getPartnerDashboardLines() {
        // Fill in a list of partner dashboard lines.
        if (dm.getPartnerDashboardLines().isEmpty()) {
            dm.fillAllPartnerDashboardLines();
        } else {
            dm.resetLists();
            dm.fillAllPartnerDashboardLines();
        }

        return dm.getPartnerDashboardLines();
    }

    public String getUserRank() {
        return u.getRank();
    }

    public User getUser() {
        return u;
    }

    public String getUserID() {
        return u.getId();
    }
    
    public Map<String, Campaign> getCampaign() {
        // Fill in a list of partner dashboard lines.
        
        dm.resetLists();
        dm.fillAllCampaigns();

        return dm.getCampaigns();
    }
    
    public Map<String, POE> getPOEs() {
        dm.resetLists();
        dm.fillAllPOEs();
        
        return dm.getPoes();
    }
    
    public Map<String, Budget> getBudget() {
        dm.resetLists();
        dm.fillAllBudgets();
        
        return dm.getBudgets();
    }
    
    public Map<String, User> getUsers() {
        dm.resetLists();
        dm.fillAllUsers();
        
        return dm.getUsers();
    }
}
