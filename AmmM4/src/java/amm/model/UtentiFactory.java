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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matteo
 */
public class UtentiFactory {
    private static UtentiFactory singleton;
    String connectionString;
    
    public static UtentiFactory getInstance(){
        if(singleton==null){
            singleton=new UtentiFactory();
        }
        return singleton;
    }
    
    private UtentiFactory(){
        
    }
    
    public Utente getUtente(String username, String password){
        try{
            Connection conn=DriverManager.getConnection(connectionString, "Matteo", "0");
            
            String query="select * from utenti where username = ? and password = ?";
            PreparedStatement stmt=conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet set=stmt.executeQuery();
            
            if(set.next()){
                Utente utente;
                if(set.getInt("tipo")==0)
                    utente = new Venditore();
                else
                    utente = new Cliente();
                utente.setId(set.getInt("id"));
                utente.setUsername(set.getString("username"));
                utente.setPassword(set.getString("password"));
                utente.setValoreSaldo(set.getInt("saldo"));
                
                stmt.close();
                conn.close();
                
                return utente;
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
    
    public Utente getUtente(int id){
        try{
            Connection conn=DriverManager.getConnection(connectionString, "Matteo", "0");
            
            String query="select * from utenti where id = ?";
            PreparedStatement stmt=conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            ResultSet set=stmt.executeQuery();
            
            if(set.next()){
                Utente utente;
                if(set.getInt("tipo")==0)
                    utente = new Venditore();
                else
                    utente = new Cliente();
                utente.setId(set.getInt("id"));
                utente.setUsername(set.getString("username"));
                utente.setPassword(set.getString("password"));
                utente.setValoreSaldo(set.getInt("saldo"));
                
                stmt.close();
                conn.close();
                
                return utente;
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            Logger.getLogger(UtentiFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
}
