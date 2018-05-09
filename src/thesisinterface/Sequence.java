/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;

/**
 *
 * @author marin
 */
public abstract class Sequence {
    
    protected String seq;
    protected int index;
    protected char base;
    
    public Sequence(){
        System.out.println("Default constructor called");
        this.seq = "";
    }

    public Sequence(String seq) {
        this.seq = seq;
    }

//    char[] convertSequence(String sequence){
//        return sequence.toCharArray();
//    }
    
    public String getSeq() {
        return seq;
    }

    public int getIndex() {
        return index;
    }

    public char getBase() {
        return base;
    }
    
//    public String corrMapValues(HashMap values, Object[] sequence){
//        
//        Object[] transSeq = new Object[sequence.length];
//        
//        for (int i=0; i<sequence.length; i++){
//            for (int j=0; j<transSeq.length; j++){
//            
//            if(values.containsKey(sequence[i])){
//                transSeq[j]=values.get(sequence[i]);
//            }
//           }
//        }
//        
//        return transSeq.toString();
//    }
    
    /**
     *
     * @return
     */
    
  

     
    
}
