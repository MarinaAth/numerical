/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marin
 */
public class PairedNumeric implements IInput {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private List <Double> numericSequence;
    private Map<Character,Double> pairedNumValues = new HashMap<>();

    public PairedNumeric(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public char[] seqToArray(String sequence) {
        return convSeq = sequence.toCharArray();
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
    public Map assignValues() {
       pairedNumValues.put('G', -1.0);
       pairedNumValues.put('A', 1.0);
       pairedNumValues.put('C', 1.0);
       pairedNumValues.put('T', -1.0);
       return pairedNumValues;
    }

   public List toNumeric(){
    for(int i=0; i<convSeq.length; i++){
            if (pairedNumValues.containsKey(convSeq[i])){
                
                numericSequence.add(pairedNumValues.get(convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
}
