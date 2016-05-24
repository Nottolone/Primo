/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matteo
 */
public class ProdottiFactory {
    private static ProdottiFactory singleton;
    String connectionString;
    
    public static ProdottiFactory getInstance(){
        if(singleton==null){
            singleton=new ProdottiFactory();
        }
        return singleton;
    }
    
    private ProdottiFactory(){
        
    }
    
    public ArrayList<Prodotto> getListaProdotti(){
        ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
        try{
            Connection conn=DriverManager.getConnection(connectionString, "Matteo", "0");
            Statement stmt=conn.createStatement();
            String query="select * from prodotti";
            ResultSet set=stmt.executeQuery(query);
            
            while(set.next()){
                Prodotto current = new Prodotto();
                current.setId(set.getInt("id"));
                current.setNomeProdotto(set.getString("nome"));
                current.setUrlImmagine(set.getString("url_immagine"));
                current.setDescrizione(set.getString("descrizione"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setQuantita(set.getInt("quantita"));
                current.setIdVenditore(set.getInt("venditore_id"));
                listaProdotti.add(current);
            } 
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaProdotti;
    }
    
    public Prodotto getProdotto(int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Matteo", "0");
            String query = "select * from prodotti where id = "+id;
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);
            
            if(res.next()){
                Prodotto current = new Prodotto();
                current.setId(res.getInt("id"));
                current.setNomeProdotto(res.getString("nome"));
                current.setUrlImmagine(res.getString("url_immagine"));
                current.setDescrizione(res.getString("descrizione"));
                current.setPrezzo(res.getDouble("prezzo"));
                current.setQuantita(res.getInt("quantita"));
                current.setIdVenditore(res.getInt("venditore_id"));
                
                st.close();
                conn.close();
                
                return current;
            }
            
            st.close();
            conn.close();
        } catch(SQLException e) {
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
    
    public void inserisciProdotto(Prodotto p){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Matteo", "0");
            String query="insert into prodotti "
                         + "(id, nome, url_immagine, descrizione, prezzo, quantita, venditore_id) "
                         + "values (?,?,?,?,?,?,?)";
            PreparedStatement stmt=conn.prepareStatement(query);
            
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getNomeProdotto());
            stmt.setString(3, p.getUrlImmagine());
            stmt.setString(4, p.getDescrizione());
            stmt.setDouble(5, p.getPrezzo());
            stmt.setInt(6, p.getQuantita());
            stmt.setInt(7, p.getIdVenditore());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void rimuoviProdotto(int idProdotto){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Matteo", "0");
            String query="delete from prodotti "
                         + "where id = ?";
            PreparedStatement stmt=conn.prepareStatement(query);
            
            stmt.setInt(1, idProdotto);
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void modificaProdotto(Prodotto p, int idProdotto){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Matteo", "0");
            String query="update prodotti set "
                         + "nome = ?, url_immagine = ?, descrizione = ?, prezzo = ?, quantita = ? "
                         + "where id = ?";
            PreparedStatement stmt=conn.prepareStatement(query);
            
            stmt.setString(1, p.getNomeProdotto());
            stmt.setString(2, p.getUrlImmagine());
            stmt.setString(3, p.getDescrizione());
            stmt.setDouble(4, p.getPrezzo());
            stmt.setInt(5, p.getQuantita());
            stmt.setInt(6, idProdotto);
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public boolean acquistaProdotto(Prodotto p, Cliente c){
        boolean stato=true;
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Matteo", "0");

            PreparedStatement updateProdotti=null;
            PreparedStatement updateSaldoCliente=null;
            PreparedStatement updateSaldoVenditore=null;

            String deleteProdotto="delete from prodotti where id = ?";
            String editSaldoCliente="update utenti set "
                                    + "saldo = ? "
                                    + "where id = ?";
            String editSaldoVenditore="update utenti set "
                                      + "saldo = ? "
                                      + "where id = ?";

            try{
                conn.setAutoCommit(false);
                updateProdotti=conn.prepareStatement(deleteProdotto);
                updateSaldoCliente=conn.prepareStatement(editSaldoCliente);
                updateSaldoVenditore=conn.prepareStatement(editSaldoVenditore);

                updateProdotti.setInt(1, p.getId());

                updateSaldoCliente.setDouble(1, c.getValoreSaldo()-p.getPrezzo());
                updateSaldoCliente.setInt(2, c.getId());

                updateSaldoVenditore.setDouble(1, UtentiFactory.getInstance().getUtente(p.getIdVenditore()).getValoreSaldo()+p.getPrezzo());
                updateSaldoVenditore.setInt(2, p.getIdVenditore());

                int c1=updateProdotti.executeUpdate();
                int c2=updateSaldoCliente.executeUpdate();
                int c3=updateSaldoVenditore.executeUpdate();

                if(c1!=1 || c2!=1 || c3!=1){
                    conn.rollback();
                    stato=false;
                }

                conn.commit();
            } catch(SQLException e) {
                Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
                try{
                    conn.rollback();
                    stato=false;
                } catch(SQLException e2) {
                    Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
                    stato=false;
                }
            } finally {
                if(updateProdotti!=null)
                    updateProdotti.close();
                
                if(updateSaldoCliente!=null)
                    updateSaldoCliente.close();
                
                if(updateSaldoVenditore!=null)
                    updateSaldoVenditore.close();

                conn.setAutoCommit(true);
                conn.close();
            }
        } catch(SQLException e){
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE, null, e);
            stato=false;
        }
        return stato; //restituisce false in caso di errori, true altrimenti
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
}
