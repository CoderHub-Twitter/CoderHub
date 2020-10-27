/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brian John
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request Servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "index.html";
        request.setAttribute("success", "");
        request.setAttribute("error", "");
        if(request.getParameter("register") != null && (request.getParameter("register")).equals("true")){
            User user = new User();
            user.register(request);
            url = "register.jsp";
        }else if(request.getParameter("login") != null && request.getParameter("login").equalsIgnoreCase("true")){
            User user = new User();
            user.logIn(request);
            String rank = (String) request.getSession().getAttribute("rank");
            if(rank == null){
                url = "login.jsp";
            }else if(rank.equalsIgnoreCase("ADMIN")){
                url = "admin.jsp";
            }else if(rank.equalsIgnoreCase("CLIENT")){
                url = "student.jsp";
            }else if(rank.equalsIgnoreCase("CLIENT")){
                url = "experienceddrivers";
            }else{
                url = "login.jsp";
            }
            
            
            
            
        }else if(request.getParameter("logout") != null && request.getParameter("logout").equalsIgnoreCase("true")){
            request.getSession().removeAttribute("rank");
            url = "login.jsp";
        }else if(request.getParameter("approveRegistration") != null && request.getParameter("approveWork").equalsIgnoreCase("true")){
            Administrator admin = new Administrator();
            admin.approveRegistration(Integer.parseInt(request.getParameter("id")));
            if(((String)request.getSession().getAttribute("user")).equalsIgnoreCase("MANAGER")) url = "manager.jsp";
            else url = "admin.jsp";
        }else if(request.getParameter("rejectWork") != null && request.getParameter("rejectWork").equalsIgnoreCase("true")){
            Administrator admin = new Administrator();
            admin.declineRequest(Integer.parseInt(request.getParameter("id")));
            url = "admin.jsp";
        }else if(request.getParameter("requestMaterials") != null && request.getParameter("requestMaterials").equalsIgnoreCase("true")){
            url = "requestMaterials.jsp";
        }else if(request.getParameter("sendRequest") != null && request.getParameter("sendRequest").equalsIgnoreCase("true")){
            Foreman foreman = new Foreman();
            foreman.sendRequest(request);
            url = "foreman.jsp";
        }else if(request.getParameter("approveRequest") != null && request.getParameter("approveRequest").equalsIgnoreCase("true")){
            Manager manager = new Manager();
            manager.approveMaterialRequest(Integer.parseInt(request.getParameter("id")));
            url = "manager.jsp";
        }else if(request.getParameter("rejectRequest") != null && request.getParameter("rejectRequest").equalsIgnoreCase("true")){
            Manager manager = new Manager();
            manager.rejectRequest(Integer.parseInt(request.getParameter("id")));
            if(((String)request.getSession().getAttribute("user")).equalsIgnoreCase("MANAGER")) url = "manager.jsp";
            else url = "storekeeper.jsp";
        }else if(request.getParameter("SMapproveRequest") != null && request.getParameter("SMapproveRequest").equalsIgnoreCase("true")){
            StoreKeeper storekeeper = new StoreKeeper();
            storekeeper.approveRequest(Integer.parseInt(request.getParameter("id")));
            url = "storekeeper.jsp";
        }else if(request.getParameter("assignWork") != null && request.getParameter("assignWork").equalsIgnoreCase("true")){
            Foreman foreman = new Foreman();
            foreman.assignWork(request);
            url = "foreman.jsp";
        }else if(request.getParameter("complete") != null && request.getParameter("complete").equalsIgnoreCase("true")){
            Foreman foreman = new Foreman();
            foreman.workComplete(request);
            url = "foreman.jsp";
        }else if(request.getParameter("approvework") != null && request.getParameter("approvework").equalsIgnoreCase("true")){
            request.setAttribute("page", "approveWork");
            url = "manager.jsp";
        }else if(request.getParameter("approvematerials") != null && request.getParameter("approvematerials").equalsIgnoreCase("true")){
            request.setAttribute("page", "approvematerials");
            url = "manager.jsp";
        }else if(request.getParameter("assign") != null && request.getParameter("assign").equalsIgnoreCase("true")){
            url = "assignWork.jsp";
        }else if(request.getParameter("addMaterial") != null && request.getParameter("addMaterial").equalsIgnoreCase("true")){
            StoreKeeper s = new StoreKeeper();
            s.addMaterial(request);
            url = "addmaterials.jsp";
        }else if(request.getParameter("acceptUser") != null && request.getParameter("acceptUser").equalsIgnoreCase("true")){
            Manager manager = new Manager();
            manager.approveRegistered(Integer.parseInt(request.getParameter("id")), request.getParameter("rank"));
            url = "userRequests.jsp";
        }else if(request.getParameter("rejectUser") != null && request.getParameter("rejectUser").equalsIgnoreCase("true")){
            Manager manager = new Manager();
            manager.rejectRegistered(Integer.parseInt(request.getParameter("id")));
            url = "userRequests.jsp";
        }
        
        System.out.println(url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
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