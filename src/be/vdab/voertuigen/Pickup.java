/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;

/**
 *
 * @author Jimmy Godin
 */
public class Pickup extends Personenwagen implements Laadbaar {

    private Volume laadvolume;//niet final omdat interface Laadbaar verplicht een public setter voorziet
        
    public Pickup(String merk, int aankoopprijs) throws VolumeException{
        this(merk, aankoopprijs, 2); //Defaultwaarde zitplaatsen = 2
    }
    
    public Pickup(String merk, int aankoopprijs, int zitplaatsen) throws VolumeException{
        this(merk, aankoopprijs, zitplaatsen, new Volume(1, 1, 1, Maat.METER)); //Defaultwaarde volume = 1m³
    }
    
    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume laadvolume)throws VolumeException {
        super(merk, aankoopprijs, zitplaatsen);
        this.setLaadvolume(laadvolume);
    }
    
    @Override
    public final void setLaadvolume(Volume laadvolume) {
        //Het laadvolume van een pickup staat vast en mag niet meer gewijzigd worden achteraf 
        //daarom enkel toewijzing bij creatie van een instantie van Pickup want dan is laadvolume nog null.
        if(this.laadvolume == null){
            this.laadvolume = laadvolume;
        }
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }
    
    @Override
    public String toString() {
        //return super.toString() + String.format(" ; %s", this.getLaadvolume());
        return super.toString() + String.format(" ; %s", this.getLaadvolume()); 
    }
    
    // Niet nodig om equals(), hashCode() en compareTo() te overriden want de controle op gelijkheid blijft evenzeer de nummerplaat
}
