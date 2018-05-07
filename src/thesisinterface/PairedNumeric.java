/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.List;
import java.util.Map;

/**
 *
 * @author marin
 */
public class PairedNumeric implements IInput {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private List <String> numericSequence;

    public PairedNumeric(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public char[] convertSequence(String sequence) {
        return convSeq=sequence.toCharArray();
    }

       
    public String transformNumeric(){
        
       for(int i=0; i<convSeq.length;i++){
           if (convSeq[i]=='A' || convSeq[i]=='T'){
            numericSequence.add("1,");
           }
           
           if (convSeq[i]=='G' || convSeq[i]=='G'){
            numericSequence.add("-1,");
           }
           else{
               System.out.println("Unidentified nucleotide");
           }
       }
       
       return numericSequence.toString();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
