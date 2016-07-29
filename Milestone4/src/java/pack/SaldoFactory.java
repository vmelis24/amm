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
    
    
    private SaldoFactory(){
        Saldo saldo_1 = new Saldo();
        saldo_1.setSaldo(100);
        
        Saldo saldo_2 = new Saldo();
        saldo_2.setSaldo(50);
        
    }
    
}
