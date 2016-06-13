/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;

public class UtentiClienti {
  
    protected int id;
    protected String nome;
    protected String cognome;
    
    protected String username_c;
    protected String password_c;
    
    protected ArrayList<Oggetti> oggettiAcquistati = new ArrayList<Oggetti>(); 
    
    
    /* Costruttore */
    public UtentiClienti()
    {
        id = 0;
        nome = "";
        cognome = "";
        username_c="";
        password_c="";
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the username_c
     */
    public String getUsername_c() {
        return username_c;
    }

    /**
     * @param username_c the username_c to set
     */
    public void setUsername_c(String username_c) {
        this.username_c = username_c;
    }

    /**
     * @return the password_c
     */
    public String getPassword_c() {
        return password_c;
    }

    /**
     * @param password_c the password_c to set
     */
    public void setPassword_c(String password_c) {
        this.password_c = password_c;
    }

    /**
     * @return the oggettiAcquistati
     */
    public ArrayList<Oggetti> getOggettiAcquistati() {
        return oggettiAcquistati;
    }

    /**
     * @param oggettiAcquistati the oggettiAcquistati to set
     */
    public void setOggettiAcquistati(ArrayList<Oggetti> oggettiAcquistati) {
        this.oggettiAcquistati = oggettiAcquistati;
    }
    
   
    
}

