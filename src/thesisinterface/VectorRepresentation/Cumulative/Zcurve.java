/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.Cumulative;

import java.util.ArrayList;
import thesisinterface.VectorRepresentation.BaseClasses.Sequence;

/**
 *
 * @author marin
 */
public class Zcurve {
    
    private Sequence sequence;
    private char[] convSeq;
    private ArrayList <Integer> indSeq1 = new ArrayList<>();
    private ArrayList <Integer> indSeq2 = new ArrayList<>();
    private ArrayList <Integer> indSeq3 = new ArrayList<>();
    
    public Zcurve(Sequence sequence) {
        this.sequence = sequence;
        this.convSeq = sequence.getSeq().toCharArray();
    }

//    @Override
//    public int getExtendedInfo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void getBase(int index) {
//        
//        System.out.println(convSeq[index]);
//    }
//
//    @Override
//    public String asString() {
//       return sequence.toString();
//    }
//
//    @Override
//    public HashMap assignValues() {
//       
//    }
//
   public void toNumeric(){
        
        switch(convSeq[0]){
            case 'T':
                indSeq1.add(0, 1);
                indSeq2.add(0, -1);
                indSeq3.add(0, 1);
                break;
            case 'G':
                indSeq1.add(0, 1);
                indSeq2.add(0, -1);
                indSeq3.add(0, -1);
                break;
            case 'C':
            case 'A':
                indSeq1.add(0, -1);
                indSeq2.add(0, 1);
                indSeq3.add(0, 1);
                break;
        }
        
        for (int i = 1; i<this.convSeq.length; i++) {
            OUTER:
            switch (convSeq[i]) {
                case 'A':
                    indSeq1.add((indSeq1.get(i-1))-1); 
                    indSeq2.add((indSeq2.get(i-1))+1);
                    indSeq3.add((indSeq3.get(i-1))+1);
                    break;
                case 'T':
                    indSeq1.add((indSeq1.get(i-1))+1);
                    indSeq2.add((indSeq2.get(i-1))-1);
                    indSeq3.add((indSeq3.get(i-1))+1);
                    break;
                case 'G':
                    indSeq1.add((indSeq1.get(i-1))+1);
                    indSeq2.add((indSeq2.get(i-1))-1);
                    indSeq3.add((indSeq3.get(i-1))-1);
                    break;
                case 'C':
                    indSeq1.add((indSeq1.get(i-1))-1);
                    indSeq2.add((indSeq2.get(i-1))+1);
                    indSeq3.add((indSeq3.get(i-1))-1);
                    break;
                default:
                    System.out.println("You have an issue here");
                    break;
            }
        }
    
       System.out.println("Indicator sequence 1:" + indSeq1.toString() + "\n"
               + "Indicator sequence 2: " + indSeq2.toString() + "\n"
                       + "Indicator sequence 3: " + indSeq3.toString());
    }
    
   public int[][] vectorArray(){
       
       int[][] array = new int[3][convSeq.length];
       int seqSize = convSeq.length;
       
       for (int i=0; i<seqSize; i++){
           array[0][i]=indSeq1.get(i);
           array[1][i]=indSeq2.get(i);
           array[2][i]=indSeq3.get(i);
           
       }
       return array;
   }
    
}
