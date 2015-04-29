package Model;

import Interfaces.DataMapperInterface;
import Model.users.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rasmus
 */
public class DataMapper implements DataMapperInterface {

    Map<String, User> users = new HashMap(); // Liste over alle users.
    Map<String, Campaign> campaigns = new HashMap(); // Liste over alle kampagner.
    Map<String, Budget> budgets = new HashMap(); // Liste over alle budgetter.
    Map<String, POE> poes = new HashMap(); // Liste over alle filer.
    Map<String, AdminDashboardLine> adminDashboardLines = new HashMap(); // Liste over den information der skal vises på Admin dashboard.
    Map<String, SellerDashboardLine> sellerDashboardLines = new HashMap(); // Liste over den information der skal vises på Seller dashboard.
    Map<String, PartnerDashboardLine> partnerDashboardLines = new HashMap(); // Liste over den information der skal vises på Partner dashboard.

    private Statement statement;
    private Db db;
    private Connection con;
    private ResultSet rs;

    @Override
    public Map<String, AdminDashboardLine> getAdminDashboardLines() {
        return adminDashboardLines;
    }

    @Override
    public Map<String, SellerDashboardLine> getSellerDashboardLines() {
        return sellerDashboardLines;
    }

    @Override
    public Map<String, PartnerDashboardLine> getPartnerDashboardLines() {
        return partnerDashboardLines;
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }

    @Override
    public Map<String, Campaign> getCampaigns() {
        return campaigns;
    }

    @Override
    public Map<String, Budget> getBudgets() {
        return budgets;
    }

    @Override
    public Map<String, POE> getPoes() {
        return poes;
    }

    @Override
    public void resetLists() {
        users = new HashMap();
        campaigns = new HashMap();
        poes = new HashMap();
        budgets = new HashMap();
        adminDashboardLines = new HashMap();
        sellerDashboardLines = new HashMap();
        partnerDashboardLines = new HashMap();

    }
    
    @Override
    public boolean fillAllUsers() {
        String sql = "SELECT * FROM dell_users";
        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                users.put(rs.getString("id"), new User(rs.getString("id"), rs.getString("rank"), rs.getString("userName"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            con.close();
        } catch (Exception e) {
        }
        return true;
    }
        
    @Override
    public boolean fillAllBudgets() {
        String sql = "SELECT * FROM dell_budget";
        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {

                budgets.put(rs.getString("id"), new Budget(rs.getInt("id"), rs.getInt("value")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            con.close();
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public boolean fillAllCampaigns() {
        String sql = "SELECT * FROM dell_campaigns";
        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {

                String sDate = rs.getDate("start_date").toString();
                System.out.println(sDate);
                String[] aSDate = sDate.split("-");

                String start_day = aSDate[2];
                String start_month = aSDate[1];
                String start_year = aSDate[0];

                System.out.println("Day: " + start_day);
                System.out.println("Month: " + start_month);
                System.out.println("Year: " + start_year);

                String eDate = rs.getDate("end_date").toString();
                String[] eSDate = eDate.split("-");

                String end_day = eSDate[2];
                String end_month = eSDate[1];
                String end_year = eSDate[0];

                campaigns.put(rs.getString("id"), new Campaign(rs.getInt("id"), rs.getString("name"), rs.getInt("stepNumber"), rs.getString("description"), 
                    start_day, start_month, start_year, 
                    end_day, end_month, end_year, 
                    rs.getString("target"), rs.getString("objectives"), 
                    rs.getInt("approve_seller_project"), rs.getInt("approve_partner_project"), rs.getInt("approve_seller_POE"), 
                    rs.getInt("partnerID"), rs.getInt("sellerID"), rs.getInt("budgetID")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            con.close();
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public boolean fillAllPOEs() {
        String sql = "SELECT * FROM dell_files";
        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {

                poes.put(rs.getString("id"), new POE(rs.getInt("id"), rs.getString("name"), rs.getString("poe_url"), rs.getInt("campaignID")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            con.close();
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public AdminDashboardLine getSingleAdminDashboardLine(int sellerID) {
        AdminDashboardLine adl = null;

        // Henter budgettet for den specifikke seller. 
        String sql4 = "create view query1 AS "
                + "select u.FIRSTNAME AS name, b.VALUE "
                + "from dell_users u , dell_budget b, dell_seller s "
                + "where s.BUDGETID = b.ID and s.USERID = u.ID and u.ID = " + sellerID;

        // Tæller alle pending campaigns og summer pending campaigns in $.
        String sql5 = "create view query2 AS "
                + "select u.FIRSTNAME AS name, SUM(CASE WHEN c.APPROVE_SELLER_POE = 0 THEN 1 ELSE 0 END) AS \"PendingCampaigns\", "
                + "SUM(CASE WHEN c.APPROVE_SELLER_POE = 0 THEN b.VALUE ELSE 0 END) AS \"Pending$\" "
                + "from dell_users u, dell_campaigns c, dell_budget b "
                + "where c.SELLERID = " + sellerID + " and u.id = c.SELLERID and c.BUDGETID = b.ID  "
                + "group by u.FIRSTNAME ";

        // Tæller alle completed campaigns og summer completed campaigns in $.
        String sql6 = "create view query3 AS "
                + "select u.FIRSTNAME AS name, SUM(CASE WHEN c.APPROVE_SELLER_POE = 1 THEN 1 ELSE 0 END) AS \"CompletedCampaigns\", "
                + "SUM(CASE WHEN c.APPROVE_SELLER_POE = 0 THEN 0 ELSE b.VALUE END) AS \"Completed$\" "
                + "from dell_users u, dell_campaigns c, dell_budget b "
                + "where c.SELLERID = " + sellerID + " and u.id = c.SELLERId and c.BUDGETID = b.ID "
                + "group by u.FIRSTNAME ";

        // lægger alle sql results sammen i et view.
        String sql7 = "create view query4 AS "
                + "select query1.name, query2.\"PendingCampaigns\" + query3.\"CompletedCampaigns\" AS \"Campaign Amount\", "
                + "query1.VALUE AS \"Seller Budget\", "
                + "query2.\"Pending$\" + query3.\"Completed$\" AS \"Budget used\", "
                + "query2.\"PendingCampaigns\" AS \"# of Pending Campaigns\", "
                + "query2.\"Pending$\" AS \"Cost of Pending Campaigns\", "
                + "query3.\"CompletedCampaigns\" AS \"# of Completed Campaigns\", "
                + "query3.\"Completed$\" AS \"Cost of Completed Campaigns\" "
                + " from query1,query2,query3 ";

        // Henter info fra sammenlagte views.
        String sql8 = "select * from query4";

        // delete the views since we will create them every time want a line
        String sql1 = "drop view query1";
        String sql2 = "drop view query2";
        String sql3 = "drop view query3";
        String sql3a = "drop view query4";

        try {
            //con = Db.getInstance().getConnection();
            
            //create a single sql query out of many 
            statement = con.createStatement();
            con.setAutoCommit(false);
            statement.addBatch(sql4);
            statement.addBatch(sql5);
            statement.addBatch(sql6);
            statement.addBatch(sql7);

            statement.executeBatch();
            con.commit();
            con.setAutoCommit(true);
            rs = statement.executeQuery(sql8);

            if (rs.next()) {
                adl = new AdminDashboardLine(
                        rs.getString("Name"), rs.getString("Campaign Amount"),
                        rs.getString("Seller Budget"), rs.getString("Budget used"),
                        rs.getString("# of Pending Campaigns"), rs.getString("Cost of Pending Campaigns"),
                        rs.getString("# of Completed Campaigns"), rs.getString("Cost of Completed Campaigns")
                );
            }

            con.setAutoCommit(false);
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);
            statement.addBatch(sql3a);
            statement.executeBatch();
            con.commit();
            con.setAutoCommit(true);

            /*
             while (rs.next()) {
             adminDashboardLines.add(new AdminDashboardLine(
             rs.getString("Name"), rs.getString("Campaign Amount"),
             rs.getString("Seller Budget"), rs.getString("Budget used"),
             rs.getString("# of Pending Campaigns"), rs.getString("Cost of Pending Campaigns"),
             rs.getString("# of Completed Campaigns"), rs.getString("Cost of Completed Campaigns")
             ));
             }
             */
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            //return false;
        }

//        try {
//            con.close();
//        } catch (Exception e) {
//        }
        //return true;
        return adl;
    }

    @Override
    public boolean fillAllAdminDashboardLines() {
        // get all the seller id's
        String sql = "select id from dell_users where rank = 2";

        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            List<Integer> ids = new ArrayList();

            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }

            // for each seller ID create a dashboard line
            for (Integer i : ids) {
                AdminDashboardLine a = getSingleAdminDashboardLine(i);
                a.setSellerId("" + i);
                adminDashboardLines.put(i.toString(), a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public SellerDashboardLine getSingleSellerDashboardLine(int sellerID, int partnerID) {
        SellerDashboardLine sdl = null;

        // Henter partner navn samt addresse.
        // Henter budget for den specifikke partner
        String sql4 = "create view query1 AS "
                + "select distinct u.FIRSTNAME, (p.SHOPNAME || ' - ' || p.ADDRESS) AS shop " 
                + "from dell_partner p, dell_users u, dell_campaigns c "
                + "where p.USERID = u.id and p.USERID = c.PARTNERID and c.PARTNERID = " + partnerID 
                + "and c.SELLERID = " + sellerID;

        // Henter antal af pending campaigns og summer pending campaigns $.
        String sql5 = "create view query2 AS "
                + "select u.FIRSTNAME AS name, SUM(CASE WHEN c.APPROVE_SELLER_POE = 0 THEN 1 ELSE 0 END) AS \"PendingCampaigns\", "
                + "SUM(CASE WHEN c.APPROVE_SELLER_POE = 0 THEN b.VALUE ELSE 0 END) AS \"PD\" "
                + "from dell_partner p, dell_users u, dell_campaigns c, dell_budget b "
                + "where c.BUDGETID = b.ID and p.USERID = c.PARTNERID and c.PARTNERID = u.ID and u.ID = "
                + partnerID + " and c.SELLERID = " + sellerID + " "
                + "group by u.FIRSTNAME ";

        // Henter antal af compledted campaigns og summer completed campaigns $.
        String sql6 = "create view query3 AS "
                + "select u.FIRSTNAME AS name, SUM(CASE WHEN c.APPROVE_SELLER_POE = 1 THEN 1 ELSE 0 END) AS \"ComC\", "
                + "SUM(CASE WHEN c.APPROVE_SELLER_POE = 0 THEN 0 ELSE b.VALUE END) AS \"CD\" "
                + "from dell_partner p, dell_users u, dell_campaigns c, dell_budget b "
                + "where c.BUDGETID = b.ID and p.USERID = c.PARTNERID and c.PARTNERID = u.ID and u.ID = "
                + partnerID + " and c.SELLERID = " + sellerID + " "
                + "group by u.FIRSTNAME ";

        // Sammensætter de tidligere SQL strings.
        String sql7 = "create view query4 AS "
                + "select (query1.firstName || ' - ' || query1.shop) as NAME, "
                + "query2.\"PendingCampaigns\" + query3.\"ComC\" AS \"Campaign Amount\", "
                + "query2.\"PD\" + query3.\"CD\" AS \"Budget used\", "
                + "query2.\"PendingCampaigns\" AS \"# of Pending Campaigns\", "
                + "query2.\"PD\" AS \"Cost of Pending Campaigns\", "
                + "query3.\"ComC\" AS \"# of Completed Campaigns\", "
                + "query3.\"CD\" AS \"Cost of Completed Campaigns\" "
                + " from query1,query2,query3 ";

        String sql8 = "select * from query4";

        // delete the views since we will create them every time want a line
        String sql1 = "drop view query1";
        String sql2 = "drop view query2";
        String sql3 = "drop view query3";
        String sql3a = "drop view query4";

        try {
            
            //create a single sql query out of many 
            statement = con.createStatement();

            con.setAutoCommit(false);
            statement.addBatch(sql4);
            statement.addBatch(sql5);
            statement.addBatch(sql6);
            statement.addBatch(sql7);

            statement.executeBatch();
            con.commit();
            con.setAutoCommit(true);
            rs = statement.executeQuery(sql8);
            if (rs.next()) {
                sdl = new SellerDashboardLine(
                        rs.getString("Name"), rs.getString("Campaign Amount"),
                        rs.getString("Budget used"),
                        rs.getString("# of Pending Campaigns"), rs.getString("Cost of Pending Campaigns"),
                        rs.getString("# of Completed Campaigns"), rs.getString("Cost of Completed Campaigns")
                );
            }
            /*
             sdl = new SellerDashboardLine(
             rs.getString("Name"), rs.getString("Campaign Amount"),
             rs.getString("Seller Budget"), rs.getString("Budget used"),
             rs.getString("# of Pending Campaigns"), rs.getString("Cost of Pending Campaigns"),
             rs.getString("# of Completed Campaigns"), rs.getString("Cost of Completed Campaigns")
             );
             */

            // DROP VIEWS
            con.setAutoCommit(false);
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);
            statement.addBatch(sql3a);
            statement.executeBatch();
            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            //return false;
        }

        //return true;
        return sdl;
    }

    @Override
    public boolean fillSellerDashboardLines(int sellerID) {
        // get all the partner id's associated with the current seller
        String sql = "select distinct u.id from dell_users u , dell_campaigns c "
                + "where u.rank = 1 and c.partnerID = u.id and c.sellerID = " + sellerID + " order by u.id";

        try {
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            List<Integer> ids = new ArrayList();

            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }

            // for each partner ID create a dashboard line
            for (Integer i : ids) {
                SellerDashboardLine a = getSingleSellerDashboardLine(sellerID, i);
                a.setId("" + sellerID);
                a.setPartnerID("" + i);
                sellerDashboardLines.put(i.toString(), a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean fillAllSellerDashboardLines() {
        // get all the partner id's associated with the current seller
        String sql = "select id from dell_users where rank = 2";

        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            List<Integer> ids = new ArrayList();

            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }
            
            // for each partner ID create a dashboard line
            for (Integer i : ids) {
                fillSellerDashboardLines(i);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean fillPartnerDashboardLines(int partnerID) {
        
        // Henter campaign navn samt den tilknyttede sellers navn.
        String sql4 = "select c.ID AS \"cID\", c.NAME AS name, u.FIRSTNAME AS \"sellername\", "
                + "b.\"VALUE\" as \"Budget\", c.stepNumber as \"stepnumber\" "
                + "from dell_campaigns c, dell_users u, dell_budget b "
                + "where c.BUDGETID = b.ID and u.ID = c.SELLERID and c.PARTNERID = " + partnerID + " "
                + "order by u.FIRSTNAME, b.\"VALUE\" ";

        
        try {
            
            String currentState = null;

            //create a single sql query out of many 
            statement = con.createStatement();

            rs = statement.executeQuery(sql4);

            while (rs.next()) {
                if (rs.getInt("stepnumber") < 3) {
                    currentState = "Processing";
                } else {
                    currentState = "Completed";
                }

                PartnerDashboardLine pdl = new PartnerDashboardLine(
                        rs.getString("name"), rs.getString("cID"), rs.getString("sellername"),
                        rs.getString("budget"), currentState);
                pdl.setId("" + partnerID);
                partnerDashboardLines.put(rs.getString("cID"), pdl);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            //return null;
            return false;
        }

        return true;
        //return pdl;
    }
    
    @Override
    public boolean fillAllPartnerDashboardLines() {
        // get all the partner id's associated with the current seller
        String sql = "select u.id from dell_users u where u.rank = 1";

        try {
            con = new Db().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            List<Integer> ids = new ArrayList();

            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }

            // for each partner ID create a dashboard line
            for (Integer i : ids) {
                fillPartnerDashboardLines(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        try {
            con.close();
        } catch (Exception e) {
        }

        return true;
    }
    
//    public Campaign getSingleCampaign(String id) {
//        
//        String sql = "SELECT * FROM dell_campaigns "
//                + "WHERE id = " + id;
//        
//        try {
//            con = new Db().getConnection();
//            
//            statement = con.createStatement();
//            rs = statement.executeQuery(sql);
//            if(rs.next()) {
//                return new Campaign(rs.getInt("id"), rs.getString("name"), rs.getInt("stepNumber"), rs.getString("description"), String start_day, String start_month, String start_year, String end_day, String end_month, String end_year, String target, String objective, int approve_seller_project, int approve_partner_project, int approve_seller_POE, int partnerID, int sellerID, int budgetID)
//           return null;
//            }
//        } catch (Exception e) {
//        }
//        
//        try {
//            con.close();
//        } catch (Exception e) {
//        }
//    return null;
//    }

    @Override
    public boolean getAllBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAllPOEs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
