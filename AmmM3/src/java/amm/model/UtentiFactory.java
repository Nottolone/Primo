/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

import java.util.ArrayList;

/**
 *
 * @author Matteo
 */
public class UtentiFactory {
    private static UtentiFactory singleton;
    
    public static UtentiFactory getInstance(){
        if(singleton==null){
            singleton=new UtentiFactory();
        }
        return singleton;
    }
    
    private ArrayList<Utente> listaUtenti=new ArrayList<Utente>();
    
    private UtentiFactory(){
        Venditore ven_1=new Venditore();
        ven_1.setUsername("Vend");
        ven_1.setPassword("0");
        ven_1.setValoreSaldo(10);
        ven_1.setId(0);
        listaUtenti.add(ven_1);
        
        Cliente cli_1=new Cliente();
        cli_1.setUsername("Cli");
        cli_1.setPassword("1");
        cli_1.setValoreSaldo(6);
        cli_1.setId(1);
        listaUtenti.add(cli_1);
    }

    /**
     * @return the listaUtenti
     */
    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }
}
