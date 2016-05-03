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
@WebServlet(name = "PaginaCliente", urlPatterns = {"/cliente.html"})
public class PaginaCliente extends HttpServlet {

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
            if(session.getAttribute("utente") instanceof Venditore){
                request.setAttribute("errore", "Accesso negato");
            }
        } else {
            request.setAttribute("errore", "Accesso negato");
        }
        
        if(session.getAttribute("utente") instanceof Cliente){
            if(request.getParameter("idProdotto")!=null){
                Prodotto prodottoSelezionato=ProdottiFactory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdotto")));
                if(prodottoSelezionato==null)
                    request.setAttribute("errore", "Prodotto non esistente");
                else
                    request.setAttribute("prodotto", prodottoSelezionato);
            } else {
                if(request.getParameter("Buy")!=null){
                    Prodotto prodottoSelezionato=ProdottiFactory.getInstance().getProdotto(Integer.parseInt(request.getParameter("idProdottoDaAcquistare")));
                    if(((Utente)session.getAttribute("utente")).getValoreSaldo()>=prodottoSelezionato.getPrezzo()){
                        request.setAttribute("confermaAcquisto", "Acquisto effettuato");
                    }else{
                        request.setAttribute("errore", "Saldo insufficiente");
                    }
                }
                request.setAttribute("listaProdotti", ProdottiFactory.getInstance().getListaProdotti());
            }
        }
        
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
