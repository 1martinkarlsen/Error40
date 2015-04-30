/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.DataMapperIF;
import Model.users.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rasmus
 */
public class DataMapperStub implements DataMapperIF {

    

    public int getSellerDashboardLinesCount = 0;
    @Override
    public HashMap<Integer, SellerDashboardLine> getSellerDashboardLines() {
        getSellerDashboardLinesCount++;
        HashMap<Integer, SellerDashboardLine> lines = new HashMap<>();
        lines.put(1448, new SellerDashboardLine("Emanuel", 200, 500, 107, 389, 93, 111));
        return lines;
    }

    
    @Override
    public Map<Integer, AdminDashboardLine> getAllAdminDashboardLines() {
        HashMap<Integer, AdminDashboardLine> lines = new HashMap<>();
        lines.put(1, new AdminDashboardLine("Ole", 5, 2000, 500, 2, 300, 3,1500));
        lines.put(2, new AdminDashboardLine("Vera", 7, 4000, 1000, 5, 200, 2,2000));
        return lines;
    }

    @Override
    public Map<Integer, Campaign> getAllCampaigns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, PartnerDashboardLine> getAllPartnerDashboardLines() {
        HashMap<Integer, PartnerDashboardLine> lines = new HashMap<>();
        lines.put(9, new PartnerDashboardLine("Kampagne 9", "Vera", 3500, "Processing"));
        lines.put(42, new PartnerDashboardLine("Kampagne 42", "Ole", 4400, "Pending"));
        return lines;
        
    }

   
    @Override
    public Map<Integer, SellerDashboardLine> getAllSellerDashboardLines() {
        HashMap<Integer, SellerDashboardLine> lines = new HashMap<>();
        lines.put(9, new SellerDashboardLine("Emanuel", 200, 500, 107, 389, 93, 111));
        lines.put(13, new SellerDashboardLine("SuperSeller", 400, 505, 103, 5, 69, 11100));
        return lines;
    }

    @Override
    public boolean fillPartnerDashboardLines(int partnerID, Map<Integer, PartnerDashboardLine> partnerDashboardLines) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fillSellerDashboardLines(int sellerID, Map<Integer, SellerDashboardLine> sellerDashboardLines) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, AdminDashboardLine> getAdminDashboardLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, Budget> getBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, Campaign> getCampaigns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, PartnerDashboardLine> getPartnerDashboardLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, POE> getPoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, Budget> getAllBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, POE> getAllPOEs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Map<Integer, User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createCampaign(String name, String description, String target, String budget, String start_day, String start_month, String start_year, String end_day, String end_month, String end_year, String objective, String partnerID, String sellerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCampaign(String cID, String name, String description, String target, String budget, String start_day, String start_month, String start_year, String end_day, String end_month, String end_year, String objective) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean approveCampaignProject(String cID, String rank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean approveCampaignPOE(String cID, String rank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean uploadFile(String cID, String partnerID, String name, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
