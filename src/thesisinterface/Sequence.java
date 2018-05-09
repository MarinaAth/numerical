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
public class Sequence {
    
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


    public String getSeq() {
        return seq;
    }

    public int getIndex() {
        return index;
    }

    public char getBase() {
        return base;
    }
    
//   
    
    /**
     *
     * @return
     */
    
  

     
    
}
