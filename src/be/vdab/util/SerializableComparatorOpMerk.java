/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import be.vdab.voertuigen.Voertuig;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Jimmy
 */
public class SerializableComparatorOpMerk implements Comparator<Voertuig>, Serializable {

    @Override
    public int compare(Voertuig v1, Voertuig v2) {
        if(v1.equals(v2)){
            return 0;
        }else if(v1.getMerk().equals(v2.getMerk())){
            return -1;
        }else{
            return v1.getMerk().compareTo(v2.getMerk());
        }
    }
    
}
