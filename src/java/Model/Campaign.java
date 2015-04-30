/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;



/**
 *
 * DTO class for a campaign. Not currently in use
 */
public class Campaign {
    
    private int Id;
    private String name;
    private int stepNumber; // process state number 1, 2 or 3
    private String description; // campaign details
    private int start_day;
    private int start_month;
    private int start_year;
    private int end_day;
    private int end_month;
    private int end_year;
    private String target;
    private String objective;

    private int approve_seller_project;
    private int approve_partner_project;
    private int approve_seller_POE;

    private int partnerID;
    private int sellerID;
    private int budgetID;

    public Campaign(int Id, String name, int stepNumber, String description, int start_day, int start_month, int start_year, int end_day, int end_month, int end_year, String target, String objective, int approve_seller_project, int approve_partner_project, int approve_seller_POE, int partnerID, int sellerID, int budgetID) {
        this.Id = Id;
        this.name = name;
        this.stepNumber = stepNumber;
        this.description = description;
        this.start_day = start_day;
        this.start_month = start_month;
        this.start_year = start_year;
        this.end_day = end_day;
        this.end_month = end_month;
        this.end_year = end_year;
        this.target = target;
        this.objective = objective;
        this.approve_seller_project = approve_seller_project;
        this.approve_partner_project = approve_partner_project;
        this.approve_seller_POE = approve_seller_POE;
        this.partnerID = partnerID;
        this.sellerID = sellerID;
        this.budgetID = budgetID;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStart_day() {
        return start_day;
    }

    public void setStart_day(int start_day) {
        this.start_day = start_day;
    }

    public int getStart_month() {
        return start_month;
    }

    public void setStart_month(int start_month) {
        this.start_month = start_month;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public int getEnd_day() {
        return end_day;
    }

    public void setEnd_day(int end_day) {
        this.end_day = end_day;
    }

    public int getEnd_month() {
        return end_month;
    }

    public void setEnd_month(int end_month) {
        this.end_month = end_month;
    }

    public int getEnd_year() {
        return end_year;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getApprove_seller_project() {
        return approve_seller_project;
    }

    public void setApprove_seller_project(int approve_seller_project) {
        this.approve_seller_project = approve_seller_project;
    }

    public int getApprove_partner_project() {
        return approve_partner_project;
    }

    public void setApprove_partner_project(int approve_partner_project) {
        this.approve_partner_project = approve_partner_project;
    }

    public int getApprove_seller_POE() {
        return approve_seller_POE;
    }

    public void setApprove_seller_POE(int approve_seller_POE) {
        this.approve_seller_POE = approve_seller_POE;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getBudgetID() {
        return budgetID;
    }

    public void setBudgetID(int budgetID) {
        this.budgetID = budgetID;
    }

  
}
