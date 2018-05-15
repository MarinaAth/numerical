/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author marin
 */
public class Voss {
    
    
    private Sequence sequence;
    private char[] convSeq;
    private ArrayList <Integer> indSeqA = new ArrayList<>();
    private ArrayList <Integer> indSeqT = new ArrayList<>();
    private ArrayList <Integer> indSeqG = new ArrayList<>();
    private ArrayList <Integer> indSeqC = new ArrayList<>();
   
//    private HashMap<Character,Double> pairedNumValues = new HashMap<>();
    
    public Voss(Sequence sequence) {
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
       
        for (int i = 0; i<this.convSeq.length; i++) {
            OUTER:
            switch (convSeq[i]) {
                case 'A':
                    indSeqA.add(1); 
                    indSeqT.add(0);
                    indSeqG.add(0);
                    indSeqC.add(0);
                    break OUTER;
                case 'T':
                    indSeqA.add(0);
                    indSeqT.add(1);
                    indSeqG.add(0);
                    indSeqC.add(0);
                    break OUTER;
                case 'G':
                    indSeqA.add(0);
                    indSeqT.add(0);
                    indSeqG.add(1);
                    indSeqC.add(0);
                    break OUTER;
                case 'C':
                    indSeqA.add(0);
                    indSeqT.add(0);
                    indSeqG.add(0);
                    indSeqC.add(1);
                    break OUTER;
                default:
                    System.out.println("You have an issue here");
                    break OUTER;
            }
        }
    
       System.out.println("Indicator sequence A:" + indSeqA.toString() + "\n"
               + "Indicator sequence T: " + indSeqT.toString() + "\n"
                       + "Indicator sequence G: " + indSeqG.toString() + "\n"
                               + "Indicator sequence C: " + indSeqC.toString());
    }
   
   public int[][] vectorArray(){
       
       int[][] array = new int[4][convSeq.length];
       int seqSize = convSeq.length;
       
       for (int i=0; i<seqSize; i++){
           array[0][i]=indSeqA.get(i);
           array[1][i]=indSeqT.get(i);
           array[2][i]=indSeqG.get(i);
           array[3][i]=indSeqC.get(i);
       }
       
       
       return array;
   }
    
}
