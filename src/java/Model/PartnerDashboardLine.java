package Model;
/**
 * DTO class - a PartnerDashboardLine represents what one line of information of the dashboard of a 
 *              partner contains. Since a partner wants an overview of his/her campaigns, one line 
 *              contains campaign information.
*/
public class PartnerDashboardLine {
    private String id;
    private String campaignId;
    private String name;
    private String sellerName;
    private String budget;
    private String currentState;

    public PartnerDashboardLine(String name, String sellerName, String budget, String currentState) {
        this.name = name;
        this.sellerName = sellerName;
        this.budget = budget;
        this.currentState = currentState;
    }
    
    public PartnerDashboardLine(String name, String campaignId, String sellerName, String budget, String currentState) {
        this.name = name;
        this.campaignId = campaignId;
        this.sellerName = sellerName;
        this.budget = budget;
        this.currentState = currentState;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
    
    
}
