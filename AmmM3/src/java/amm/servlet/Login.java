/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.servlet;

import amm.model.*;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Matteo
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("loggedIn")!=null){
            if(session.getAttribute("utente") instanceof Venditore)
                request.getRequestDispatcher("venditore.html").forward(request, response);
            else
                request.getRequestDispatcher("cliente.html").forward(request, response);
        }
        
        if(request.getParameter("Login")!=null){
            String username = request.getParameter("nomeUtente");
            String password = request.getParameter("pswd");
            
            ArrayList<Utente> listaUtenti = UtentiFactory.getInstance().getListaUtenti();
            
            for(Utente u: listaUtenti){
                if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("utente", u);
                    
                    if(u instanceof Venditore)
                        request.getRequestDispatcher("venditore.html").forward(request, response);
                    else
                        request.getRequestDispatcher("cliente.html").forward(request, response);
                }
            }
            request.setAttribute("errore", "Autenticazione fallita");
        }
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
