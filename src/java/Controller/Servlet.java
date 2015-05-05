/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.ControlIF;
import Model.Authentification;

import Model.users.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kasper
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    ControlIF control = new Control();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String origin = request.getParameter("origin");

            switch (origin) {
                case "login":
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    // login - if unsuccesful return to login page
                    

                    if (!control.login(username, password)) {
                        response.sendRedirect("Public/Pages/login.jsp");
                        return;

                    } else {
                        // pass the User object to the web page
                        request.getSession().setAttribute("user", control.getUser());
                    }
                    
                    switch (control.getUserRank()) {
                        case 3: // Logging in as administrator
                            request.getSession().setAttribute("allAdminLines", control.getAdminDashboardLines());
                            response.sendRedirect("index.jsp?show=Admin/dashboard.jsp");
                            return;

                        case 2: // logging in as a seller.
                            request.getSession().setAttribute("allSellerLines", control.getSellerDashboardLines());
                            response.sendRedirect("index.jsp?show=Seller/dashboard.jsp");
                            return;

                        case 1: // Logging in as a partner.
                            request.getSession().setAttribute("allPartnerLines", control.getPartnerDashboardLines());
                            response.sendRedirect("index.jsp?show=Partner/dashboard.jsp");
                            return;

                    }
                   return;
                case "logout":
                    control.logout();
                    response.sendRedirect("Public/Pages/login.jsp");
                    return;

                // Logged in as admin, and clicked on particular seller, showing the partners refered to the seller.
                case "showPartnersFromSeller":
                    request.getSession().setAttribute("allSellerLines", control.getSellerDashboardLines());

                    String id = request.getParameter("id");
                    request.getSession().setAttribute("id", id);
                    response.sendRedirect("index.jsp?show=Seller/dashboard.jsp");
                    return;

                // Logged in as admin or seller and clicked on "Show partners", showing all partners in the system.
                case "showPartnersFromAdmin":
                    request.getSession().setAttribute("allSellerLines", control.getSellerDashboardLines());
                    response.sendRedirect("index.jsp?show=showPartners.jsp");

                    return;

                // 
                case "showDefaultSite":

                    switch (control.getUserRank()) {
                        case 3:
                            request.getSession().setAttribute("allAdminLines", control.getAdminDashboardLines());
                            response.sendRedirect("index.jsp?show=Admin/dashboard.jsp");

                            return;

                        case 2:
                            request.getSession().setAttribute("allSellerLines", control.getSellerDashboardLines());
                            response.sendRedirect("index.jsp?show=Seller/dashboard.jsp");

                            return;

                        case 1:
                            request.getSession().setAttribute("allPartnerLines", control.getPartnerDashboardLines());
                            response.sendRedirect("index.jsp?show=Partner/dashboard.jsp");

                            return;
                    }

                    return;

                // Logged in as admin or seller, clicked on particular partner, showing all campaigns afilliated to the partner.
                case "showCampaignsFromPartner":
                    request.getSession().setAttribute("allPartnerLines", control.getPartnerDashboardLines());

                    id = request.getParameter("id");
                    request.getSession().setAttribute("id", id);
                    response.sendRedirect("index.jsp?show=Partner/dashboard.jsp");
                    return;

                case "showSingleCampaign":
                    request.getSession().setAttribute("allCampaigns", control.getCampaign());
                    request.getSession().setAttribute("allPOEs", control.getPOEs());
                    request.getSession().setAttribute("allBudget", control.getBudget());
                    request.getSession().setAttribute("allUsers", control.getUsers());

                    id = request.getParameter("cID");
                    request.getSession().setAttribute("cID", id);
                    response.sendRedirect("index.jsp?show=campaign.jsp");
                    return;

                case "updateCampaign":
                    int cID = Integer.parseInt(request.getSession().getAttribute("cID").toString());
                    System.out.println("cid: " + cID);
                    String name = request.getParameter("name");
                    String description = request.getParameter("description");
                    String target = request.getParameter("target");
                    int budget = Integer.parseInt(request.getParameter("budget"));
                    System.out.println("budget: " + budget);
                    int start_day = Integer.parseInt(request.getParameter("start_day"));
                    System.out.println("start_day: " + start_day);
                    int start_month = Integer.parseInt(request.getParameter("start_month"));
                    System.out.println("start_month: " + start_month);
                    int start_year = Integer.parseInt(request.getParameter("start_year"));
                    System.out.println("start_year: " + start_year);
                    int end_day = Integer.parseInt(request.getParameter("end_day"));
                    int end_month = Integer.parseInt(request.getParameter("end_month"));
                    int end_year = Integer.parseInt(request.getParameter("end_year"));
                    String objectives = request.getParameter("objectives");

                    control.updateCampaign(cID, name, description, target, budget, start_day, start_month, start_year,
                            end_day, end_month, end_year, objectives);

                    response.sendRedirect("Servlet?origin=showSingleCampaign&cID=" + cID);
                    return;

                case "approveCampaignRequest":
                    int userRank = control.getUserRank();
                    int choice = Integer.parseInt(request.getParameter("choice"));
                    cID = Integer.parseInt(request.getSession().getAttribute("cID").toString());

                    control.approveCampaignRequest(cID, userRank, choice);

                    response.sendRedirect("Servlet?origin=showSingleCampaign&cID=" + cID);
                    return;

                case "approveCampaignPOE":
                    cID = Integer.parseInt(request.getSession().getAttribute("cID").toString());
                    choice = Integer.parseInt(request.getParameter("choice"));

                    control.approveCampaignPOE(cID, choice);

                    response.sendRedirect("Servlet?origin=showSingleCampaign&cID=" + cID);

                    return;
            }
            /*
             // Fill in a list of all users from the dell_users table in the database.
             if (dm.getUsers().isEmpty()) {
             dm.getAllUsers();
             request.getSession().setAttribute("allUsers", dm.getUsers());
             } else {
             dm.resetLists();
             dm.getAllUsers();
             }

             // Fill in a list of all campaigns from the dell_campaigns table in the database.
             if (dm.getCampaigns().isEmpty()) {
             dm.getAllCampaigns();
             request.getSession().setAttribute("allCampaigns", dm.getCampaigns());
             } else {
             dm.resetLists();
             dm.getAllCampaigns();
             }

             // Fill in a list of all POEs from the dell_poe table in the database.
             if (dm.getPoes().isEmpty()) {
             dm.getAllPOEs();
             request.getSession().setAttribute("allPOEs", dm.getPoes());
             } else {
             dm.resetLists();
             dm.getAllPOEs();
             }
             */
            response.sendRedirect("index.jsp");

        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
