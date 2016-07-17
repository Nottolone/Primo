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
public class Prodotto {
    private int id;
    private String nomeProdotto;
    private String urlImmagine;
    private String descrizione;
    private double prezzo;
    private int quantita;
    private int idVenditore;
    
    public Prodotto(){
        id=0;
        nomeProdotto="";
        urlImmagine="";
        descrizione="";
        prezzo=0;
        quantita=0;
        idVenditore=0;
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
     * @return the nomeProdotto
     */
    public String getNomeProdotto() {
        return nomeProdotto;
    }

    /**
     * @param nomeProdotto the nomeProdotto to set
     */
    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    /**
     * @return the urlImmagine
     */
    public String getUrlImmagine() {
        return urlImmagine;
    }

    /**
     * @param urlImmagine the urlImmagine to set
     */
    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the quantita
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * @param quantita the quantita to set
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * @return the idVenditore
     */
    public int getIdVenditore() {
        return idVenditore;
    }

    /**
     * @param idVenditore the idVenditore to set
     */
    public void setIdVenditore(int idVenditore) {
        this.idVenditore = idVenditore;
    }
}
