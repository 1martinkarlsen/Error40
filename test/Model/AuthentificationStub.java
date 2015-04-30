/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthentificationIF;
import Model.users.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class AuthentificationStub implements AuthentificationIF {

    List<User> users = new ArrayList();

    public AuthentificationStub() {
        // generate test database entry
        User dummy = new User(5, 2, "dummyName", "dummyPw", "dummyFirstName", "dummyLastName");
        users.add(dummy);
    }
    
    
    
    @Override
    public List<User> getUsers() {
                
        return users;
        
    }

    @Override
    public User validate(String username, String password) {
        for(User u : users) {
            if(username.equals(u.getUserName())) {
                if(password.equals(u.getPassword())) {
                    return u;
                }
            }
        }
        return null;
    }
}
