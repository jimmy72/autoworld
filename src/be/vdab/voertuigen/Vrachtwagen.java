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
public class Vrachtwagen extends Voertuig implements Laadbaar{
    
    private Volume laadvolume;//niet final omdat interface Laadbaar verplicht een public setter voorziet
    private final int maximaalToegelatenMassa;
    private final int aantalAssen;
    
    public Vrachtwagen(String merk, int aankoopprijs) throws VolumeException{
        this(merk, aankoopprijs, new Volume(1, 1, 1, Maat.METER)); //defaultwaarde voor volume instellen    
    }
    
    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume) throws VolumeException{
        this(merk, aankoopprijs, laadvolume, 1000);//defaultwaarde voor maximaalToegelatenMassa instellen
    }
    
    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume, int maximaalToegelatenMassa) throws VolumeException{
        this(merk, aankoopprijs, laadvolume, maximaalToegelatenMassa, 2);//defaultwaarde voor aantalAssen instellen
    }
    
    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen) throws VolumeException{
        super(merk, aankoopprijs);
        this.setLaadvolume(laadvolume);
        // initialisatie en controle binnen constructor omdat final members geen setters kunnen hebben
        this.maximaalToegelatenMassa = (maximaalToegelatenMassa > 0) ? maximaalToegelatenMassa : 1000;
        this.aantalAssen = (aantalAssen > 0) ? aantalAssen : 2;
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }
    
    @Override
    public final void setLaadvolume(Volume laadvolume) {
        //Het laadvolume van een vrachtwagen staat vast en mag niet meer gewijzigd worden achteraf 
        //daarom enkel toewijzing bij creatie van een instantie van Vrachtwagen want dan is laadvolume nog null.
        if(this.laadvolume == null){
            this.laadvolume = laadvolume;
        }
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    @Override
    public String toString() {
        return super.toString() + 
                String.format(" ; %s ; Maximaal toegelaten massa: %,d Kg ; Aantal assen: %d ", 
                this.getLaadvolume(), this.getMaximaalToegelatenMassa(), this.getAantalAssen()); 
    }

    // Niet nodig om equals(), hashCode() en compareTo() te overriden want de controle op gelijkheid blijft evenzeer de nummerplaat
}
