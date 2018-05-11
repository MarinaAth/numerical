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
public class DNAwalk implements IInput {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private LinkedList <Double> numericSequence;
    private HashMap<Character,Double> pairedNumValues = new HashMap<>();
    
    private List<Double> indG = new ArrayList<>();
    private List<Double> indA = new ArrayList<>();
    private List<Double> indC = new ArrayList<>();
    private List<Double> indT = new ArrayList<>();


    public DNAwalk(Sequence sequence) {
        this.sequence = sequence;
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
        
       pairedNumValues.put('G', -1.0);
       pairedNumValues.put('A', 1.0);
       pairedNumValues.put('C', 1.0);
       pairedNumValues.put('T', -1.0);
       return pairedNumValues;
    }

   public LinkedList toNumeric(){
    for(int i=0; i<this.convSeq.length; i++){
            if (pairedNumValues.containsKey(this.convSeq[i])){
                
                numericSequence.add(pairedNumValues.get(this.convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
}
