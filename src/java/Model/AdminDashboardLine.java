/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * DTO class - a AdminDashboardLine represents what one line of information of the dashboard of a 
 *              admin contains. Since an admin wants an overview of his/her sellers, one line 
 *              contains seller information.
 */
public class AdminDashboardLine {
    private String sellerId;
    private String name;        // seller name
    private String amountCampaigns;
    private String sellerBudget;
    private String budget_used;
    private String pendingCampaigns;    // amount of non-completed campaigns
    private String pendingCampaignsCost;
    private String completedCampaigns;  // amount of completed campaigns
    private String completedCampaignsCost;

    public AdminDashboardLine(String name, String amountCampaigns, String sellerBudget, 
            String budget_used, String pendingCampaigns, String pendingCampaignsCost, 
            String completedCampaigns, String completedCampaignsCost) {
        this.name = name;
        this.amountCampaigns = amountCampaigns;
        this.sellerBudget = sellerBudget;
        this.budget_used = budget_used;
        this.pendingCampaigns = pendingCampaigns;
        this.pendingCampaignsCost = pendingCampaignsCost;
        this.completedCampaigns = completedCampaigns;
        this.completedCampaignsCost = completedCampaignsCost;
    }

    public String getSellerId() {
        return sellerId;
    }
    
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
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

    public String getCompletedCampaigns() {
        return completedCampaigns;
    }

    public void setCompletedCampaigns(String completedCampaigns) {
        this.completedCampaigns = completedCampaigns;
    }

    public String getSellerBudget() {
        return sellerBudget;
    }

    public void setSellerBudget(String sellerBudget) {
        this.sellerBudget = sellerBudget;
    }

    public String getPendingCampaignsCost() {
        return pendingCampaignsCost;
    }

    public void setPendingCampaignsCost(String pendingCampaignsCost) {
        this.pendingCampaignsCost = pendingCampaignsCost;
    }

    public String getCompletedCampaignsCost() {
        return completedCampaignsCost;
    }

    public void setCompletedCampaignsCost(String completedCampaignsCost) {
        this.completedCampaignsCost = completedCampaignsCost;
    }
}
