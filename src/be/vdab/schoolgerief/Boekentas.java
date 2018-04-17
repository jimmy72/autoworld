/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import java.io.Serializable;

/**
 *
 * @author Jimmy Godin
 */
public class Boekentas implements Laadbaar, Serializable {
    
    private final String kleur; //final omdat kleur normaal niet meer wijzigt, daarom ook geen setter toegelaten
    private Volume laadvolume; //niet final omdat interface Laadbaar een public setter voorziet
    
    public Boekentas(String kleur, Volume laadvolume) throws IllegalArgumentException, VolumeException{
        if(kleur != null && !kleur.trim().isEmpty() && laadvolume != null){
            this.kleur = kleur;
            this.setLaadvolume(laadvolume);
        }else{
            throw new IllegalArgumentException("Kleur en laadvolume moeten ingevuld worden!");
        }
    }

    public String getKleur() {
        return kleur;
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }
    
    @Override
    public final void setLaadvolume(Volume laadvolume) {
        //Het laadvolume van een boekentas staat vast en mag niet meer gewijzigd worden achteraf
        //daarom enkel toewijzing bij creatie van een instantie van Boekentas want dan is laadvolume nog null.
        if(this.laadvolume == null){
            this.laadvolume = laadvolume;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Boekentas)){
            return false;
        }
        Boekentas b = (Boekentas) obj;
        return this.getKleur().equals(b.getKleur()) && this.getLaadvolume().equals(b.getLaadvolume());
    }

    @Override
    public int hashCode() {
        return this.getKleur().hashCode() + this.getLaadvolume().hashCode();
    }
    
    @Override
    public String toString() {
        return String.format("BOEKENTAS >> Kleur: %s ; %s", this.getKleur(), this.getLaadvolume());
    }

}
