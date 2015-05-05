package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * Database Connecter class - used for maintaining a Connection to the database
 *                          - without singleton now
 * 
 */
public class Db
{
    
    // We use different Database Accounts because we 
        
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
//    private static String id = "cphrh108";			//Insert Your ORACLE id and password
//    private static String pw = "cphrh108";
    private static String id = "cphmk299";			//Insert Your ORACLE id and password
    private static String pw = "cphmk299";
//    private static String id = "cphss268";			//Insert Your ORACLE id and password
//    private static String pw = "cphss268";
    
    private Connection con;

    //--  No more Singleton ---- 
    private static Db instance;
    public Db()
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, id, pw);   // The connection will be released upon program 
		  					      // termination by the garbage collector	
            
            
            
            
            
            
            
        } catch (Exception e)
        {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
            
            System.out.println(e.getMessage());
        }
    }
    
    //    public static Db getInstance()
    //    {
    //        if (instance == null)
    //            instance = new Db();
    //        return instance;
    //    }
    //------------------
    
    public Connection getConnection()
    {
      return con;
    }
    
}
