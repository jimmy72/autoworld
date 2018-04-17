/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Vrachtwagen;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Jimmy Godin
 */

public class AutoWorldMain {

    /**
     * @param args the command line arguments
     */
    private static Pickup pickup1;
    private static Vrachtwagen vrachtwagen1;
    private static Boekentas boekentas1;
    private static Boekentas boekentas2;
    private static BigInteger totaalVolume = BigInteger.ZERO;
    private static BigInteger eenVolume = BigInteger.ZERO;
    private static Volume eenStandaardVolume;
    
    static{
        try{
            eenStandaardVolume = new Volume(150,100,180,Maat.CENTIMETER);
        }catch(VolumeException ve){
            System.out.println(ve.getMessage());
        }
    }
    
    public AutoWorldMain(){
        
    }
    
    public static void main(String[] args) {
        
        // Nieuwe TreeSet van Voertuigen aanmaken
        //Set<Voertuig> voertuigen = new TreeSet<>();
        Set<Voertuig> voertuigen = new TreeSet<>(Voertuig.getMerkComparator());
        
        // Voertuigen toevoegen aan de set
        try{
            voertuigen.add(new Personenwagen("Toyota", 14500, 4));
            //voertuigen.add(null);
        }catch(NullPointerException npe){
            System.out.println(npe.getMessage());
        }
        
        try{
           voertuigen.add(new Personenwagen("Volvo", 24780, 5)); 
        }catch(NullPointerException npe){
            System.out.println(npe.getMessage());
        }
                
        try{
            Volume kopieVolume = new Volume(eenStandaardVolume);
            //Volume kopieVolume = null;
            pickup1 = new Pickup("Volkswagen", 21300, 2, kopieVolume);
            voertuigen.add(pickup1);
        }
        catch(VolumeException | NullPointerException e){
            System.out.println(e.getMessage());
        }

        try{
            voertuigen.add(new Pickup("Renault", 18400, 2, new Volume(15,10,18,Maat.DECIMETER)));
        }
        catch(VolumeException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        
        try{
            vrachtwagen1 = new Vrachtwagen("SCANIA",80000, new Volume(3,3,8,Maat.METER), 15000, 4);
            voertuigen.add(vrachtwagen1);
        }
        catch(VolumeException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        
        try{
            voertuigen.add(new Vrachtwagen("DAF",65000, new Volume(2,2,3,Maat.METER), 10000, 3));
        }
        catch(VolumeException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        
        // Weergave van toegevoegde voertuigen op het scherm
        System.out.println("AUTOWORLD");
        System.out.println("*********\n");
        System.out.println("Afdruk van een TreeSet van te bewaren voertuigen:");
        voertuigen.forEach((voertuig) -> {
            System.out.println(voertuig);
        });
        
        // Wegschrijven van voertuigen naar bestand wagenpark.dat
        try ( FileOutputStream fos = new FileOutputStream("C:/JPF/wagenpark.dat");
              ObjectOutputStream oos = new ObjectOutputStream(fos); ) { 
            
              oos.writeObject(voertuigen); 
        }
        catch (IOException e) {
            System.out.println("Map of directory niet gevonden!");
        }
        
        // Bestand wagenpark.dat terug inlezen in nieuwe Treeset
        Set<Voertuig> ingelezenVoertuigen = new TreeSet<>();
        
        try ( FileInputStream fis = new FileInputStream("C:/JPF/wagenpark.dat");
              ObjectInputStream ois = new ObjectInputStream(fis); ) { 
            
              ingelezenVoertuigen = (Set<Voertuig>) ois.readObject(); 
        }
        catch (ClassNotFoundException | IOException e) {
            System.out.println("Probleem met het lezen van bestand!");
        }
        
        // Afdruk op scherm van terug ingelezen voertuigen
        System.out.println("\nLijst van terug ingelezen voertuigen uit het bestand C:/JPF/wagenpark.dat:");
        ingelezenVoertuigen.forEach((voertuig) -> {
            System.out.println(voertuig);
        });
    
        // Aanmaak en afdruk van enkele boekentassen
        System.out.println("\nEnkele boekentassen:");
        try{
            boekentas1 = new Boekentas("Bruin", new Volume(3,2,1,Maat.DECIMETER));
            System.out.println(boekentas1);
        }catch(VolumeException ve){
            System.out.println(ve.getMessage());
        }
        
        try{
            boekentas2 = new Boekentas("Beige", new Volume(25,25,7,Maat.CENTIMETER));
            System.out.println(boekentas2);
        }catch(VolumeException ve){
            System.out.println(ve.getMessage());
        }
        
        // Aanmaken van ArrayList van laadbare objecten
        List<Laadbaar> laadbareObjecten = new ArrayList<>();
        
        //Toevoegen van enkele voertuigen en boekentassen
        laadbareObjecten.add(pickup1);
        laadbareObjecten.add(vrachtwagen1);
        laadbareObjecten.add(boekentas1);
        laadbareObjecten.add(boekentas2);
        
        //Afdruk van laadbare objecten op scherm
        System.out.println("\nAfrduk van enkele voertuig- en boekentasobjecten (laadbare objecten) in een ArrayList:");
                
        for(Laadbaar laadbaarObject : laadbareObjecten) {
          
            try{
                System.out.println(laadbaarObject);
                eenVolume = BigInteger.valueOf(laadbaarObject.getLaadvolume().getVolume());
                totaalVolume = totaalVolume.add(eenVolume);
            }catch(NullPointerException npe){
                System.out.println(npe.getMessage());
            }            
        
        }
        
        System.out.println(String.format("\nHet totale laadvolume van deze laadbare objecten bedraagt %,d cm³.", totaalVolume));
        
    }
    
}
