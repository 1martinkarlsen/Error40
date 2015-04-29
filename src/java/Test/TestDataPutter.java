package Test;

import Interfaces.DataMapperInterface;
import Model.DataMapper;

public class TestDataPutter {
    
    public static void main(String[] args) {
        DataMapperInterface dp = new DataMapper();
        
        // Test oprettelse af kampagne samt budget og fil i DB.
        //dp.createCampaign("Mit navn", "Min beskrivelse", "Target: Kvinder", "3000", "05", "04", "13", "07", "08", "14", "Tjene penge", "14", "3");
        
        
        // Test Update af kampagne samt dets budget. 
        //dp.updateCampaign("102", "Mit nye navn", "Min nye beskrivelse", "Mænd", "10000", "17", "10", "15", "02", "02", "16", "Tjene endnu flere penge");
    
        // Test update af kampagne project approve.
        //dp.approveCampaignProject("102", "2");
        
        // Test update af kampagne project approve.
        //dp.approveCampaignPOE("102", "1");
    }
}
