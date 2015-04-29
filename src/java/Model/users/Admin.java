/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.users;

/**
 *
 * DTO class
 */
public class Admin {
    private String id;
    private String userID;
    private String budgetID;

    public Admin(String id, String userID, String budgetID) {
        this.id = id;
        this.userID = userID;
        this.budgetID = budgetID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBudgetID() {
        return budgetID;
    }

    public void setBudgetID(String budgetID) {
        this.budgetID = budgetID;
    }
    
}
