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
import java.util.Map;

/**
 *
 * @author simon
 */
public class Control implements ControlIF {

    private DataMapperIF dm;
    private AuthentificationIF au;
    
    private String rank = null;
    private User user = null;
    private String id = null;

    
    

    public void setUser(User user) {
        this.user = user;
    }
    
    

    public Control() {
        dm = new DataMapper();
        au = new Authentification(); 
    }
    
    public Control(DataMapperIF stubDm, AuthentificationIF stubAu) {
        dm = stubDm;
        au = stubAu;
    }
    
    public void logout() {
        user = null;
        id = null;
        //dm.resetLists();
    }

    public boolean login(String username, String password) {
        user = au.validate(username, password);
        
        return user != null;
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
        return user.getRank();
    }

    public User getUser() {
        return user;
    }

    public int getUserID() {
        return user.getId();
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

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }
}
