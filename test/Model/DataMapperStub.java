/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.DataMapperInterface;
import Model.users.User;
import java.util.HashMap;

/**
 *
 * @author Rasmus
 */
public class DataMapperStub implements DataMapperInterface {

    @Override
    public boolean fillAllAdminDashboardLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fillAllCampaigns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fillAllPartnerDashboardLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int fillAllSellerDashboardLinesCount = 0;
    @Override
    public boolean fillAllSellerDashboardLines() {
        fillAllSellerDashboardLinesCount++;
        return true;
    }

    @Override
    public boolean fillPartnerDashboardLines(int partnerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fillSellerDashboardLines(int sellerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, AdminDashboardLine> getAdminDashboardLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAllBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAllPOEs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Budget> getBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Campaign> getCampaigns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, PartnerDashboardLine> getPartnerDashboardLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, POE> getPoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getSellerDashboardLinesCount = 0;
    @Override
    public HashMap<String, SellerDashboardLine> getSellerDashboardLines() {
        getSellerDashboardLinesCount++;
        HashMap<String, SellerDashboardLine> lines = new HashMap<>();
        lines.put("1448", new SellerDashboardLine("1448", "200", "500", "107", "389", "93", "111"));
        return lines;
    }

    @Override
    public AdminDashboardLine getSingleAdminDashboardLine(int sellerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SellerDashboardLine getSingleSellerDashboardLine(int sellerID, int partnerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int resetListsCount = 0;
    @Override
    public void resetLists() {
        resetListsCount++;
        
    }

    @Override
    public boolean fillAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fillAllBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fillAllPOEs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
