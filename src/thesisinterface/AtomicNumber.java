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
public class AtomicNumber implements IInput {
    
    
    private GenomicSequence sequence;
    private List <Double> numericSequence;
    private  final Map<Character,Double> atomicNumValues = new HashMap<>();
    private char[] convSeq;
   
    
    
    public AtomicNumber(GenomicSequence sequence) {
        this.sequence=sequence;
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
       atomicNumValues.put('G', 78.0);
       atomicNumValues.put('A', 70.0);
       atomicNumValues.put('C', 58.0);
       atomicNumValues.put('T', 60.0);
       return atomicNumValues;
    }

//    @Override
//    public char[] seqToArray(String sequence) {
//        return convSeq = sequence.toCharArray();
//    }

    public List toNumeric(){
    convSeq = sequence.getSeq().toCharArray();
    for(int i=0; i<convSeq.length; i++){
            if (atomicNumValues.containsKey(convSeq[i])){
                
                numericSequence.add(atomicNumValues.get(convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
    
    
}