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
public class ProdottiFactory {
    private static ProdottiFactory singleton;
    
    public static ProdottiFactory getInstance(){
        if(singleton==null){
            singleton=new ProdottiFactory();
        }
        return singleton;
    }
    
    private ArrayList<Prodotto> listaProdotti=new ArrayList<Prodotto>();
    
    private ProdottiFactory(){
        Prodotto prod_0=new Prodotto();
        prod_0.setNomeProdotto("Grattaschiena");
        prod_0.setUrlImmagine("img/grattaschiena.jpg");
        prod_0.setDescrizione("Un grattaschiena");
        prod_0.setPrezzo(4);
        prod_0.setQuantita(5);
        prod_0.setId(0);
        listaProdotti.add(prod_0);
        
        Prodotto prod_1=new Prodotto();
        prod_1.setNomeProdotto("Carriola");
        prod_1.setUrlImmagine("img/carriola.jpg");
        prod_1.setDescrizione("Una carriola");
        prod_1.setPrezzo(5);
        prod_1.setQuantita(6);
        prod_1.setId(1);
        listaProdotti.add(prod_1);
        
        Prodotto prod_2=new Prodotto();
        prod_2.setNomeProdotto("Frullatore");
        prod_2.setUrlImmagine("img/frullatore.jpg");
        prod_2.setDescrizione("Un frullatore");
        prod_2.setPrezzo(6);
        prod_2.setQuantita(7);
        prod_2.setId(2);
        listaProdotti.add(prod_2);
        
        Prodotto prod_3=new Prodotto();
        prod_3.setNomeProdotto("Sedia");
        prod_3.setUrlImmagine("img/sedia.jpg");
        prod_3.setDescrizione("Una sedia");
        prod_3.setPrezzo(7);
        prod_3.setQuantita(8);
        prod_3.setId(3);
        listaProdotti.add(prod_3);
        
        Prodotto prod_4=new Prodotto();
        prod_4.setNomeProdotto("Foglio A4");
        prod_4.setUrlImmagine("img/foglio.jpg");
        prod_4.setDescrizione("Un foglio A4");
        prod_4.setPrezzo(8);
        prod_4.setQuantita(9);
        prod_4.setId(4);
        listaProdotti.add(prod_4);
    }

    /**
     * @return the listaProdotti
     */
    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }
    
    public Prodotto getProdotto(int id){
        for(Prodotto p: listaProdotti){
            if(p.getId()==id)
                return p;
        }
        
        return null;
    }
}
