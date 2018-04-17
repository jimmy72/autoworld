/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

/**
 *
 * @author Jimmy Godin
 */
public class Personenwagen extends Voertuig {
    
    private final int zitplaatsen; //kan niet veranderd worden dus final en dus ook geen setter
    
    public Personenwagen(String merk, int aankoopprijs){
        this(merk, aankoopprijs, 2); //Bij constructor met 2 parameters, initialisatie zitplaatsen op 2
    }
    public Personenwagen(String merk, int aankoopprijs, int zitplaatsen){
        super(merk, aankoopprijs);
        //geen setter voor final mogelijk dus controle in constructor
        this.zitplaatsen = (zitplaatsen > 0) ? zitplaatsen : 2; //zitplaatsen mag niet negatief zijn
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" ; Zitplaatsen: %d", this.getZitplaatsen()); 
    }
    
// Niet nodig om equals(), hashCode() en compareTo() te overriden want de controle op gelijkheid blijft evenzeer de nummerplaat

}
