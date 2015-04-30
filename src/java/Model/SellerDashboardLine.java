/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * DTO class - a SellerDashboardLine represents what one line of information of the dashboard of a 
 *              seller contains. Since a seller wants an overview of his/her partners, one line 
 *              contains partner information.
 */
public class SellerDashboardLine {
    private int id;
    private int partnerId;       // the partner associated with the current seller
    private String name;
    private int amountCampaigns;
    //private String sellerBudget;
    private int budget_used;
    private int pendingCampaigns;    // campaigns not completed yet
    private int pendingCampaignsCost;
    private int completedCampaigns;
    private int completedCampaignsCost;

    public SellerDashboardLine(String name, int amountCampaigns, int budget_used, int pendingCampaigns, int pendingCampaignsCost, int completedCampaigns, int completedCampaignsCost) {
        this.name = name;
        this.amountCampaigns = amountCampaigns;
        this.budget_used = budget_used;
        this.pendingCampaigns = pendingCampaigns;
        this.pendingCampaignsCost = pendingCampaignsCost;
        this.completedCampaigns = completedCampaigns;
        this.completedCampaignsCost = completedCampaignsCost;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerID(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountCampaigns() {
        return amountCampaigns;
    }

    public void setAmountCampaigns(int amountCampaigns) {
        this.amountCampaigns = amountCampaigns;
    }

    public int getBudget_used() {
        return budget_used;
    }

    public void setBudget_used(int budget_used) {
        this.budget_used = budget_used;
    }

    public int getPendingCampaigns() {
        return pendingCampaigns;
    }

    public void setPendingCampaigns(int pendingCampaigns) {
        this.pendingCampaigns = pendingCampaigns;
    }

    public int getPendingCampaignsCost() {
        return pendingCampaignsCost;
    }

    public void setPendingCampaignsCost(int pendingCampaignsCost) {
        this.pendingCampaignsCost = pendingCampaignsCost;
    }

    public int getCompletedCampaigns() {
        return completedCampaigns;
    }

    public void setCompletedCampaigns(int completedCampaigns) {
        this.completedCampaigns = completedCampaigns;
    }

    public int getCompletedCampaignsCost() {
        return completedCampaignsCost;
    }

    public void setCompletedCampaignsCost(int completedCampaignsCost) {
        this.completedCampaignsCost = completedCampaignsCost;
    }
    
    
}
