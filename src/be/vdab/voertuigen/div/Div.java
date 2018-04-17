/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

/**
 *
 * @author Jimmy Godin
 */
public enum Div {
    INSTANCE;
    private int nummer = 1;
    
    public Nummerplaat getNummerplaat(){
        String plaat = String.format("1-AAA-%03d", nummer++);
        if(nummer >= 999){
            nummer = 1;
        }
        return new Nummerplaat(plaat);
    }
}
