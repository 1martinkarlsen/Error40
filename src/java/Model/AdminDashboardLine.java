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
    private int sellerId;
    private String name;        // seller name
    private int amountCampaigns;
    private int sellerBudget;
    private int budget_used;
    private int pendingCampaigns;    // amount of non-completed campaigns
    private int pendingCampaignsCost;
    private int completedCampaigns;  // amount of completed campaigns
    private int completedCampaignsCost;

    public AdminDashboardLine(String name, int amountCampaigns, int sellerBudget, 
            int budget_used, int pendingCampaigns, int pendingCampaignsCost, 
            int completedCampaigns, int completedCampaignsCost) {
        this.name = name;
        this.amountCampaigns = amountCampaigns;
        this.sellerBudget = sellerBudget;
        this.budget_used = budget_used;
        this.pendingCampaigns = pendingCampaigns;
        this.pendingCampaignsCost = pendingCampaignsCost;
        this.completedCampaigns = completedCampaigns;
        this.completedCampaignsCost = completedCampaignsCost;
    }

    public int getSellerId() {
        return sellerId;
    }
    
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
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

    public int getCompletedCampaigns() {
        return completedCampaigns;
    }

    public void setCompletedCampaigns(int completedCampaigns) {
        this.completedCampaigns = completedCampaigns;
    }

    public int getSellerBudget() {
        return sellerBudget;
    }

    public void setSellerBudget(int sellerBudget) {
        this.sellerBudget = sellerBudget;
    }

    public int getPendingCampaignsCost() {
        return pendingCampaignsCost;
    }

    public void setPendingCampaignsCost(int pendingCampaignsCost) {
        this.pendingCampaignsCost = pendingCampaignsCost;
    }

    public int getCompletedCampaignsCost() {
        return completedCampaignsCost;
    }

    public void setCompletedCampaignsCost(int completedCampaignsCost) {
        this.completedCampaignsCost = completedCampaignsCost;
    }
}
