/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

/**
 *
 * @author Matteo
 */
public abstract class Utente {
    private int id;
    private String username;
    private String password;
    private Saldo saldoDisponibile;
    
    public Utente(){
        id=0;
        username="";
        password="";
        saldoDisponibile=new Saldo();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the saldoDisponibile
     */
    public Saldo getSaldoDisponibile() {
        return saldoDisponibile;
    }

    /**
     * @param saldoDisponibile the saldoDisponibile to set
     */
    public void setSaldoDisponibile(Saldo saldoDisponibile) {
        this.saldoDisponibile = saldoDisponibile;
    }
    
    public double getValoreSaldo(){
        return saldoDisponibile.getValore();
    }
    
    public void setValoreSaldo(double valore){
        saldoDisponibile.setValore(valore);
    }
}
