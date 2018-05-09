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
public class ElectronIon implements IInput {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private List <Double> numericSequence;
    private Map<Character,Double> electronValues = new HashMap<>();

    public ElectronIon(Sequence sequence) {
        this.sequence = sequence;
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
    public char[] seqToArray(String sequence) {
        return convSeq=sequence.toCharArray();
    }

    @Override
    public Map assignValues() {
       electronValues.put('G', 0.0806);
       electronValues.put('A', 0.1260);
       electronValues.put('C', 0.1340);
       electronValues.put('T', 0.1335);
       return electronValues;
    }

    public List toNumeric(){
    for(int i=0; i<convSeq.length; i++){
            if (electronValues.containsKey(convSeq[i])){
                
                numericSequence.add(electronValues.get(convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
    
}

