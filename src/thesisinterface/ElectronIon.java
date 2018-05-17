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
public class ElectronIon implements ISymbolSequence {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private LinkedList <Double> numericSequence;
    private HashMap<Character,Double> electronValues = new HashMap<>();

    public ElectronIon(Sequence sequence) {
        this.sequence = sequence;
        this.convSeq = sequence.getSeq().toCharArray();
    }

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


    public HashMap assignValues() {
       electronValues.put('G', 0.0806);
       electronValues.put('A', 0.1260);
       electronValues.put('C', 0.1340);
       electronValues.put('T', 0.1335);
       return electronValues;
    }

    public LinkedList toNumeric(){
    for(int i=0; i<this.convSeq.length; i++){
            if (electronValues.containsKey(this.convSeq[i])){
                
                numericSequence.add(electronValues.get(this.convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
    
}

