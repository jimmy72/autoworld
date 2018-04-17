/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;

/**
 *
 * @author Jimmy Godin
 */
public class Volume implements Comparable<Volume>, Serializable{
    
    private final int breedte;
    private final int hoogte;
    private final int diepte;
    private final Maat maat;
    
    public Volume(int breedte, int hoogte, int diepte, Maat maat) throws VolumeException{
        //bij final members zijn setters niet toegelaten daarom controle en initialisatie in constructor
        if(breedte >= 0 && hoogte >= 0 && diepte >= 0){
            this.breedte = breedte;
            this.hoogte = hoogte;
            this.diepte = diepte;
            this.maat = maat;
        }else{
            throw new VolumeException("Negatieve volumes zijn niet mogelijk!");
        }
    }
    
    public Volume(Volume v) throws VolumeException{
        this(v.getBreedte(), v.getHoogte(), v.getDiepte(), v.getMaat());
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getDiepte() {
        return diepte;
    }

    public Maat getMaat() {
        return maat;
    }
    
    public long getVolume(){
        /*
         * Alle operatoren zijn van het type int. Het volstaat om één van de operatoren te casten naar 
         * een long. Het resultaat zal automatisch ook een long zijn want een long is hoger in rang dan een int
         */
        return (long) (this.breedte) * this.hoogte * this.diepte * maat.getFactor();
    }

    @Override
    public int hashCode() {
        //omzetting long naar Wrapperclass Long zodat method hashCode kan uitgevoerd worden
        return Long.hashCode(this.getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Volume)){
            return false;
        }
        Volume v = (Volume) obj;
        return this.getVolume() == v.getVolume();
    }

    @Override
    public int compareTo(Volume o) {
        if(this.getVolume() < o.getVolume()){
            return -1;
        }else if(this.getVolume() > o.getVolume()){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Laadvolume: %,d cm�", this.getVolume());
    }
    
}
