package Interfaces;


public interface DataPutterIF { 
    // Campaigns
    public boolean createCampaign(String name, String description, String target, String budget, 
            String start_day, String start_month, String start_year,
            String end_day, String end_month, String end_year,
            String objective, String partnerID, String sellerID);
    public boolean updateCampaign(String cID, String name, String description, String target, String budget, 
            String start_day, String start_month, String start_year,
            String end_day, String end_month, String end_year,
            String objective);
    public boolean approveCampaignProject(String cID, String rank);
    public boolean approveCampaignPOE(String cID, String rank);
    public boolean uploadFile(String cID, String partnerID, String name, String type); // Huske at sørge for at den selv generere navnet: QxFYxx
    
    // Users (to be add'ed).
    
}
