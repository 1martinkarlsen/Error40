package Model;

import Interfaces.DataPutterIF;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * This class is used for changing information in the database
 */
public class DataPutter implements DataPutterIF {

    String URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
    String username = "cphmk299";
    String password = "cphmk299";
    
    private Statement statement;
    private Db db;
    private Connection con;
    private ResultSet rs;
    
    private Date date;

    public DataPutter() {
       //db = Db.getInstance();
       //con = db.getConnection();
    }
    
    // Creates a budget
    private String createBudget(String value) {
        String sql = "INSERT INTO dell_budget"
                + "(id, value) VALUES (seq_budget.NEXTVAL, '" + value + "')";
        
        String sqlGet = "SELECT seq_budget.CURRVAL AS \"currentValue\" FROM dell_budget";
        
        String bID = null;
        try {            
            // Inserts data
            statement = con.createStatement();
            statement.addBatch(sql);
            statement.executeBatch();
            
            // Recieve ID
            rs = statement.executeQuery(sqlGet);
            rs.next();
            bID = rs.getString("currentValue");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return bID;
    }; 
    
    // updates a budget 
    private boolean updateBudget(String bID, String value) {
        String sql = "UPDATE dell_budget SET value=" + value + ""
                + "WHERE id=" + bID;
        
        try {
            statement = con.createStatement();
            statement.addBatch(sql);
            statement.executeBatch();
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }; 
    
    @Override
    public boolean createCampaign(String name, String description, String target, String budget,
            String start_day, String start_month, String start_year,
            String end_day, String end_month, String end_year, String objective, String partnerID, String sellerID) {


            String startDate = start_day + "-" + start_month + "-" + start_year; // Concatenate to a start date.
            String endDate = end_day + "-" + end_month + "-" + end_year; // Concatenate to an end date.
            
            String bID = createBudget(budget); // Create a budget and get its ID.
        
            String sql = "INSERT INTO dell_campaigns "
                    + "(id, name, stepNumber, description, start_date, end_date, "
                    + "target, objectives, approve_seller_project, approve_partner_project, approve_seller_POE, approve_partner_POE, budgetID, partnerID, sellerID)"
                    + " VALUES (seq_campaigns.NEXTVAL, '" + name + "', '1', '" + description + "', '" + startDate + "', '" + endDate + "' "
                    + ", '" + target + "', '" + objective + "', '0', '0', '0', '0', '" + bID + "', '" + partnerID + "', '" + sellerID + "' "
                    + ")";
            
            String sqlGetID = "SELECT seq_campaigns.CURRVAL AS \"currentCID\" FROM dell_campaigns";
            
            String cID = null;
            try {
                con = new Db().getConnection();
                
                // Insert campaign.
                statement = con.createStatement();
                statement.addBatch(sql);
                statement.executeBatch();
                
                // Select campaign ID.
                rs = statement.executeQuery(sqlGetID);
                rs.next();
                cID = rs.getString("currentCID");
                
                if(bID != null) {
                    uploadFile(cID, partnerID, name, "poe");
                } 
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            
            try {
                con.close();
                return true;
            } catch (Exception e) {
                return false;
            }
            
    } 

    // update the campaign    
    @Override
    public boolean updateCampaign(String cID, String name, String description, String target, String budget,
            String start_day, String start_month, String start_year,
            String end_day, String end_month, String end_year, String objective) {
        
        String bID = null;
        String stepNumber = null;
        String partnerID = null;
        String sellerID = null;
        
        String start_date = start_year + "-" + start_month + "-" + start_day; // Concatenate to a start date.
        String end_date = end_year + "-" + end_month + "-" + end_day; // Concatenate to an end date.
        
        String sqlGetBudgetID = "SELECT budgetID AS \"budgetID\" "
                + "FROM dell_campaigns " 
                + "WHERE ID = " + cID; 
        
        String updateSQL = "UPDATE dell_campaigns SET "
                + "name ='" + name + "', "
                + "description ='" + description + "', "
                + "start_date ='" + start_date + "', "
                + "end_date ='" + end_date + "', "
                + "target ='" + target + "', "
                + "objectives ='" + objective + "' "
                + "WHERE id =" + cID;
        
        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sqlGetBudgetID);
            rs.next();
            bID = rs.getString("budgetID");
            System.out.println("Got budget ID: " + bID);
            
            if(updateBudget(bID, budget)) {
                statement.executeUpdate(updateSQL);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        try {
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    } 

    // approve a campaign
    @Override
    public boolean approveCampaignProject(String cID, String rank) {
        
        String partnerProjectSQL = "UPDATE dell_campaigns SET "
                + "approve_partner_project = '1' "
                + "WHERE id = " + cID;
        String sellerProjectSQL = "UPDATE dell_campaigns SET "
                + "approve_seller_project = '1' "
                + "WHERE id = " + cID;
        
        String SQL = null;
        
        try {
            con = new Db().getConnection();
            
            if(rank == "1") {
                SQL = partnerProjectSQL;
            } else {
                SQL = sellerProjectSQL;
            }
            statement = con.createStatement();
            statement.executeUpdate(SQL);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        try {
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
    
    // approve POE
    @Override
    public boolean approveCampaignPOE(String cID, String rank) {
        String partnerPoeSQL = "UPDATE dell_campaigns SET "
                + "approve_partner_POE = '1' "
                + "WHERE id = " + cID;
        String sellerPoeSQL = "UPDATE dell_campaigns SET "
                + "approve_seller_POE = '1' "
                + "WHERE id = " + cID;
        
        String SQL = null;
        
        try {
            con = new Db().getConnection();
            
            if(rank == "1") {
                SQL = partnerPoeSQL;
            } else {
                SQL = sellerPoeSQL;
            }
            statement = con.createStatement();
            statement.executeUpdate(SQL);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        try {
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
      
    // upload File
    @Override
    public boolean uploadFile(String cID, String partnerID, String name, String type) {
        
        String url = "/Library/Uploads/" + partnerID + "/" + cID + "/" + type + "/"; // Define the URL for the file
        
        String sql = "INSERT INTO dell_files"
                + "(id, name, poe_url, campaignID)"
                + "VALUES (seq_POE.NEXTVAL, '" + name + "', '" + url + "', '" + cID + "')";
        
        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            statement.addBatch(sql);
            statement.executeBatch();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        try {
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}
