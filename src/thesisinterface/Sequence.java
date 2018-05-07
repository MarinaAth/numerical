/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

/**
 *
 * @author marin
 */
public class Sequence {
    
    private String seq;
    private int index;
    private char base;
    
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

    /**
     *
     * @return
     */
    

     
    
}
