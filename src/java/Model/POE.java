/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * DTO-class for representing a Proof Of Execution - not currently in use
 */
public class POE {

    public POE(int id, String name, String poe_url, int campaignID) {
        this.id = id;
        this.name = name;
        this.poe_url = poe_url;
        this.campaignID = campaignID;
    }
    
    
    private int id;
    private String name;
    private String poe_url;
    private int campaignID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoe_url() {
        return poe_url;
    }

    public void setPoe_url(String poe_url) {
        this.poe_url = poe_url;
    }

    public int getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(int campaignID) {
        this.campaignID = campaignID;
    }
    
    
}
