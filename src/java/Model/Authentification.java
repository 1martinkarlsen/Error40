/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthentificationIF;
import Model.users.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Authentification class used for authorize users to the system
 */
public class Authentification implements AuthentificationIF {

    
    
    
    private Statement statement;
    private DbConnector db;
    private Connection con;
    private ResultSet rs;

   
    
    // if the username exists and the password and the password also exists return that User
    @Override
    public User validate(String username, String password) {
        
        String sql = "SELECT * FROM dell_users WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            con = new DbConnector().getConnection();
            
            statement = con.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                return new User(rs.getInt("id"), rs.getInt("rank"), rs.getString("userName"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
        try {
            con.close();
        } catch (Exception e) {
        }
        
        
        return null;
    }

    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
