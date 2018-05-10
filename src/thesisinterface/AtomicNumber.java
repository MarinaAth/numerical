/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author marin
 */
public class AtomicNumber implements IInput {
    
    
    private Sequence sequence;
    private LinkedList <Double> numericSequence;
    private  final HashMap<Character,Double> atomicNumValues = new HashMap<>();
    private char[] convSeq;
   
    
    
    public AtomicNumber(Sequence sequence) {
        this.sequence=sequence;
        this.convSeq = sequence.getSeq().toCharArray();
    }

   
    @Override
    public int getExtendedInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getBase(int index) {
        
        System.out.println(convSeq[index]);
    }

    @Override
    public String asString() {
       return sequence.toString();
    }

    @Override
    public HashMap assignValues() {
       atomicNumValues.put('G', 78.0);
       atomicNumValues.put('A', 70.0);
       atomicNumValues.put('C', 58.0);
       atomicNumValues.put('T', 60.0);
       return atomicNumValues;
    }


    public LinkedList toNumeric(){
    
        for(int i=0; i<this.convSeq.length; i++){
            if (atomicNumValues.containsKey(this.convSeq[i])){
                numericSequence.add(atomicNumValues.get(this.convSeq[i]));
                } else {
                System.out.println("Your issue is here");}
        }
    return numericSequence;
    }
    
    public void checkIt(){
    
        for(int i=0; i<this.convSeq.length; i++){
            if (atomicNumValues.containsKey(this.convSeq[i])){ //το βρισκει false !!!!!
                System.out.println(atomicNumValues.get(this.convSeq[i]));
                } else {
                System.out.println("Your issue is here");}
        }
    
    }
}