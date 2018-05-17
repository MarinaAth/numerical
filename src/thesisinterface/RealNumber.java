/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marin
 */
public class RealNumber implements ISymbolSequence {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private LinkedList <Double> numericSequence;
    private HashMap<Character,Double> realNumValues = new HashMap<>();

    public RealNumber(Sequence sequence) {
        this.sequence = sequence;
        this.convSeq = sequence.getSeq().toCharArray();
    }

//    @Override
//    public char[] seqToArray(String sequence) {
//        return convSeq=sequence.toCharArray();
//    }

    @Override
    public Object getExtendedInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getSymbolAt(int index) {
        
        System.out.println(convSeq[index]);
    }

    @Override
    public String asString() {
       return sequence.toString();
    }

    @Override
    public Map assignValues() {
       realNumValues.put('G', -0.5);
       realNumValues.put('A', -1.5);
       realNumValues.put('C', 0.5);
       realNumValues.put('T', 1.5);
       return realNumValues;
    }

    public List toNumeric(){
    for(int i=0; i<this.convSeq.length; i++){
            if (realNumValues.containsKey(this.convSeq[i])){
                
                numericSequence.add(realNumValues.get(this.convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
}
