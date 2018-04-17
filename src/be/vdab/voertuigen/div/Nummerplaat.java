/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

import java.io.Serializable;

/**
 *
 * @author  Jimmy Godin
 */
public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private final String plaat;
    
    
    public Nummerplaat(String plaat){
        //controle weggelaten omdat Div de platen op een correcte manier aanmaakt
        this.plaat = plaat;
    }

    public String getPlaat() {
        return plaat;
    }
          
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Nummerplaat)) 
            return false;
        Nummerplaat p = (Nummerplaat) o;
        return this.getPlaat().equals(p.getPlaat());
    }

    @Override
    public int hashCode() {
        return this.getPlaat().hashCode();
    }

    @Override
    public int compareTo(Nummerplaat o) {
        return this.getPlaat().compareTo(o.getPlaat());
    }
    
    @Override
    public String toString() {
        return String.format("Nummerplaat: %s", this.getPlaat());
    }
    
}
