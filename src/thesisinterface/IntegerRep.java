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
public class IntegerRep implements IInput {
    
    private GenomicSequence sequence;
    private char[] convSeq;
    private List <Double> numericSequence;
    private  final Map<Character,Double> integerValues = new HashMap<>();

    public IntegerRep(GenomicSequence sequence) {
        this.sequence = sequence;
    }

//    @Override
//    public char[] seqToArray(String sequence) {
//        return convSeq=sequence.toCharArray();
//    }

  
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
       integerValues.put('G', 3.0);
       integerValues.put('A', 2.0);
       integerValues.put('C', 1.0);
       integerValues.put('T', 0.0);
       return integerValues;
    }

    public List toNumeric(){
    for(int i=0; i<convSeq.length; i++){
            if (integerValues.containsKey(convSeq[i])){
                
                numericSequence.add(integerValues.get(convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
}
