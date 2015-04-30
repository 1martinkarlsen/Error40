/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.ControlIF;
import Model.AdminDashboardLine;
import Model.Authentification;
import Interfaces.AuthentificationIF;
import Model.Budget;
import Model.Campaign;
import Model.DataMapper;
import Interfaces.DataMapperIF;
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

    private DataMapperIF dm;
    private AuthentificationIF au;
    
    private String rank = null;
    private User u = null;
    private String id = null;

    public Control() {
        dm = new DataMapper();
        au = new Authentification(); 
    }
    
    public Control(DataMapperIF stubDm, AuthentificationIF stubAu) {
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

    public Map<Integer, AdminDashboardLine> getAdminDashboardLines() {
        return dm.getAllAdminDashboardLines();
              
    }

    public Map<Integer, SellerDashboardLine> getSellerDashboardLines() {
        return dm.getAllSellerDashboardLines();

    }

    public Map<Integer, PartnerDashboardLine> getPartnerDashboardLines() {
       return dm.getAllPartnerDashboardLines();
    }

    public int getUserRank() {
        return u.getRank();
    }

    public User getUser() {
        return u;
    }

    public int getUserID() {
        return u.getId();
    }
    
    public Map<Integer, Campaign> getCampaign() {
        return dm.getAllCampaigns();
    }
    
    public Map<Integer, POE> getPOEs() {
        return dm.getAllPOEs();
    }
    
    public Map<Integer, Budget> getBudget() {
        return dm.getAllBudgets();
    }
    
    public Map<Integer, User> getUsers() {
        return dm.getAllUsers();
    }
}
