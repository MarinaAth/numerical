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
public class IntegerRep implements IInput {
    
    private Sequence sequence;
    private char[] convSeq;
    private LinkedList <Double> numericSequence;
    private  final HashMap<Character,Double> integerValues = new HashMap<>();

    public IntegerRep(Sequence sequence) {
        this.sequence = sequence;
        this.convSeq = sequence.getSeq().toCharArray();
    }

    public Sequence getSequence() {
        return sequence;
    }

    public char[] getConvSeq() {
        return convSeq;
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
       integerValues.put('G', 3.0);
       integerValues.put('A', 2.0);
       integerValues.put('C', 1.0);
       integerValues.put('T', 0.0);
       return integerValues;
    }

    public LinkedList toNumeric(){
    for(int i=0; i<this.convSeq.length; i++){
            if (integerValues.containsKey(convSeq[i])){
                numericSequence.add(integerValues.get(convSeq[i]));
            }
        }
    
    return numericSequence;
    }
    
}
