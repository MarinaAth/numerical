/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.BaseClasses;

import java.util.HashMap;
import java.util.LinkedList;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class BaseSymbolSequence implements ISymbolSequence {
    protected String sequence;
    protected LinkedList <Double> numericSequence;
    protected final HashMap<Character,Double> atomicNumValues = new HashMap<>();
    protected char[] convSeq;
   
    
    
    public BaseSymbolSequence(String sequence) {
        this.sequence=sequence;
        this.convSeq = sequence.toCharArray();
    }

   
    @Override
    public Object getExtendedInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSymbolAt(int index) {
        
        return sequence.substring(index, index+1);
    }

    @Override
    public String asString() {
       return sequence.toString();
    }

    @Override
    public int size() {
        return sequence.length();
    }
    
}
