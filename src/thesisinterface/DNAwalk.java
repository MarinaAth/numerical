/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marin
 */
public class DNAwalk {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private ArrayList <Integer> indicatorSequence = new ArrayList<>();
    
//    private HashMap<Character,Double> pairedNumValues = new HashMap<>();
    
    public DNAwalk(Sequence sequence) {
        this.sequence = sequence;
        this.convSeq = sequence.getSeq().toCharArray();
    }

//    @Override
//    public int getExtendedInfo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void getBase(int index) {
//        
//        System.out.println(convSeq[index]);
//    }
//
//    @Override
//    public String asString() {
//       return sequence.toString();
//    }
//
//    @Override
//    public HashMap assignValues() {
//       
//    }
//
   public void toNumeric(){
        if (convSeq[0]=='C'||convSeq[0]=='T'){
           indicatorSequence.add(0, 1);
        } else {
            indicatorSequence.add(0, -1);
        }
        for (int i = 1; i<this.convSeq.length; i++) {
            OUTER:
            switch (convSeq[i]) {
                case 'C' :
                case 'T':
                    indicatorSequence.add((indicatorSequence.get(i-1))+1);
                    break OUTER;
                case 'G':
                case 'A':
                    indicatorSequence.add((indicatorSequence.get(i-1))-1);
                    break OUTER;
                default:
                    System.out.println("You have an issue here");
                    break OUTER;
            }
        }
    
       System.out.println("Indicator sequence :" + indicatorSequence.toString() + "OHMAGAWD FINALLY");
    }
    
}
