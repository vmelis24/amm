/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;

public class SaldoFactory {
    
    private static SaldoFactory singleton;
    public static SaldoFactory getInstance() {
        if (singleton == null) {
            singleton = new SaldoFactory();
        }
        return singleton;
    
}
     private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
        
    public String getConnectionString(){
        return this.connectionString;
    }
    
    private SaldoFactory(){
        Saldo conto_1 = new Saldo();
        conto_1.setSaldo(100);
        
        Saldo conto_2 = new Saldo();
        conto_2.setSaldo(50);
        
    }
    
}
