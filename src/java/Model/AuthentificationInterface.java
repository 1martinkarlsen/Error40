/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.users.User;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public interface AuthentificationInterface {

    List<User> getUsers();

    // if the username exists and the password and the password also exists return that User
    User validate(String username, String password);
    
}
