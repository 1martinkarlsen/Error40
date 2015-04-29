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
        //dm.resetLists();
    }

    public boolean login(String username, String password) {
        u = au.validate(username, password);
        
        return u != null;
    }

    public Map<String, AdminDashboardLine> getAdminDashboardLines() {
        return dm.getAllAdminDashboardLines();
              
    }

    public Map<String, SellerDashboardLine> getSellerDashboardLines() {
        return dm.getAllSellerDashboardLines();

    }

    public Map<String, PartnerDashboardLine> getPartnerDashboardLines() {
       return dm.getAllPartnerDashboardLines();
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
        return dm.getAllCampaigns();
    }
    
    public Map<String, POE> getPOEs() {
        return dm.getAllPOEs();
    }
    
    public Map<String, Budget> getBudget() {
        return dm.getAllBudgets();
    }
    
    public Map<String, User> getUsers() {
        return dm.getAllUsers();
    }
}
