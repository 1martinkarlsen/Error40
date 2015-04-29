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
    private String id;
    private String partnerId;       // the partner associated with the current seller
    private String name;
    private String amountCampaigns;
    //private String sellerBudget;
    private String budget_used;
    private String pendingCampaigns;    // campaigns not completed yet
    private String pendingCampaignsCost;
    private String completedCampaigns;
    private String completedCampaignsCost;

    public SellerDashboardLine(String name, String amountCampaigns, String budget_used, String pendingCampaigns, String pendingCampaignsCost, String completedCampaigns, String completedCampaignsCost) {
        this.name = name;
        this.amountCampaigns = amountCampaigns;
        this.budget_used = budget_used;
        this.pendingCampaigns = pendingCampaigns;
        this.pendingCampaignsCost = pendingCampaignsCost;
        this.completedCampaigns = completedCampaigns;
        this.completedCampaignsCost = completedCampaignsCost;
    }

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerID(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmountCampaigns() {
        return amountCampaigns;
    }

    public void setAmountCampaigns(String amountCampaigns) {
        this.amountCampaigns = amountCampaigns;
    }

    public String getBudget_used() {
        return budget_used;
    }

    public void setBudget_used(String budget_used) {
        this.budget_used = budget_used;
    }

    public String getPendingCampaigns() {
        return pendingCampaigns;
    }

    public void setPendingCampaigns(String pendingCampaigns) {
        this.pendingCampaigns = pendingCampaigns;
    }

    public String getPendingCampaignsCost() {
        return pendingCampaignsCost;
    }

    public void setPendingCampaignsCost(String pendingCampaignsCost) {
        this.pendingCampaignsCost = pendingCampaignsCost;
    }

    public String getCompletedCampaigns() {
        return completedCampaigns;
    }

    public void setCompletedCampaigns(String completedCampaigns) {
        this.completedCampaigns = completedCampaigns;
    }

    public String getCompletedCampaignsCost() {
        return completedCampaignsCost;
    }

    public void setCompletedCampaignsCost(String completedCampaignsCost) {
        this.completedCampaignsCost = completedCampaignsCost;
    }
    
    
}
