/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;

public class UtentiVenditori {
    
    
    protected int id;
    protected String nome;
    protected String cognome;
    
    protected String username_v;
    protected String password_v;
    
    protected ArrayList<Oggetti> oggettiInseriti = new ArrayList<Oggetti>(); 
    
    /* Costruttore */
    public UtentiVenditori()
    {
        id = 0;
        nome = "";
        cognome = "";
        username_v="";
        password_v="";
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
     * @return the username_v
     */
    public String getUsername_v() {
        return username_v;
    }

    /**
     * @param username_v the username_v to set
     */
    public void setUsername_v(String username_v) {
        this.username_v = username_v;
    }

    /**
     * @return the password_v
     */
    public String getPassword_v() {
        return password_v;
    }

    /**
     * @param password_v the password_v to set
     */
    public void setPassword_v(String password_v) {
        this.password_v = password_v;
    }
    
    
}


