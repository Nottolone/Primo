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

/**
 *
 * @author Matteo
 */
@WebServlet(name = "PaginaVenditore", urlPatterns = {"/venditore.html"})
public class PaginaVenditore extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        if(session.getAttribute("loggedIn")!=null){
            if(session.getAttribute("utente") instanceof Cliente){
                request.setAttribute("errore", "Accesso negato");
            }
        } else {
            request.setAttribute("errore", "Accesso negato");
        }
        
        if(request.getParameter("Submit")!=null){
            if(request.getParameter("nomeProdotto").isEmpty() || request.getParameter("urlImmagine").isEmpty() || request.getParameter("descrizione").isEmpty() || request.getParameter("prezzo").isEmpty() || request.getParameter("quantitaProdotto").isEmpty()){
                request.setAttribute("errore", "Dati mancanti");
            } else {
                Prodotto prodottoInserito=new Prodotto();

                prodottoInserito.setNomeProdotto(request.getParameter("nomeProdotto"));
                prodottoInserito.setUrlImmagine(request.getParameter("urlImmagine"));
                prodottoInserito.setDescrizione(request.getParameter("descrizione"));
                prodottoInserito.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
                prodottoInserito.setQuantita(Integer.parseInt(request.getParameter("quantitaProdotto")));

                request.setAttribute("prodotto", prodottoInserito);
            }
            
        }
        
        request.getRequestDispatcher("venditore.jsp").forward(request, response);
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
