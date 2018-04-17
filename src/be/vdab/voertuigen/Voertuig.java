/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.SerializableComparatorOpMerk;
import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Jimmy Godin
 */
public abstract class Voertuig implements Comparable<Voertuig>, Serializable {
    // Nummerplaat, merk en aankoopprijs zijn zaken die definitief vast staan, daarom allemaal final
    private final Nummerplaat nummerplaat; //kan niet wijzigen
    private final String merk; //kan ook niet wijzigen
    private final int aankoopprijs; //kan ook niet wijzigen
    
    public Voertuig(String merk, int aankoopprijs){
        // initialisatie en controle binnen constructor omdat final members geen setters kunnen hebben
        this.merk = (merk != null && !merk.trim().isEmpty()) ? merk : "onbepaald";
        this.aankoopprijs = (aankoopprijs >= 0) ? aankoopprijs : 0;
        this.nummerplaat = Div.INSTANCE.getNummerplaat();
    }

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return merk;
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Voertuig)){
            return false;
        }
        Voertuig other = (Voertuig) obj;
        return this.getNummerplaat().equals(other.getNummerplaat());
    }
    
    @Override
    public int hashCode() {
        return this.getNummerplaat().hashCode();
    }

    @Override
    public int compareTo(Voertuig o) {
        return this.getNummerplaat().compareTo(o.getNummerplaat());
    }
    
    public static Comparator<Voertuig> getMerkComparator(){
        // EXTERNE KLASSE
        //return new SerializableComparatorOpMerk(); zie klasse SerializableComparatorOpMerk in be.vdab.util

//        return new Comparator<Voertuig>(){
//            @Override
//            public int compare(Voertuig v1, Voertuig v2) {
//                if(v1.equals(v2)){
//                    return 0;
//                }else if(v1.getMerk().equals(v2.getMerk())){
//                    return -1;
//                }else{
//                    return v1.getMerk().compareTo(v2.getMerk());
//                }
//            }
//        };

//LAMBDA EXPRESSION
          return (Voertuig v1, Voertuig v2) -> {
              if(v1.equals(v2)){
                  return 0;
              }else if(v1.getMerk().equals(v2.getMerk())){
                  return -1;
              }else{
                  return v1.getMerk().compareTo(v2.getMerk());
              }
          };
          
          
// LOCALE GENESTE KLASSE
//	class SerializableComparatorOpMerk implements Comparator<Voertuig>, Serializable {
//
//    		@Override
//    		public int compare(Voertuig v1, Voertuig v2) {
//        		if(v1.equals(v2)){
//            		return 0;
//        		}else if(v1.getMerk().equals(v2.getMerk())){
//            		return -1;
//        		}else{
//            		return v1.getMerk().compareTo(v2.getMerk());
//        		}
//    		}
//	}
//
//	Comparator<Voertuig> merkComparator = new SerializableComparatorOpMerk();
//	
//	return merkComparator;

    } 
    
    @Override
    public String toString() {
        return String.format("VOERTUIG >> %s ; Merk: %s ; Aankoopprijs: %,d €", this.getNummerplaat(), this.getMerk(), this.getAankoopprijs());
    }

}
