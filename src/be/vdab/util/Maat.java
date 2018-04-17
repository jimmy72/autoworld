/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author Jimmy Godin
 */
public enum Maat {
    CENTIMETER(1), DECIMETER(1_000), METER(1_000_000);
    
    private final int factor;
    
    //constructor van een Enum is altijd impliciet private
    private Maat(int factor){
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }
    
}
