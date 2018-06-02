/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.Cumulative;

import java.util.ArrayList;
import thesisinterface.VectorRepresentation.BaseClasses.Sequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class Zcurve extends CumulativeValueRepresentation {

    public Zcurve(ISymbolSequence sequence) {
        super(sequence);
    }

    
    
    @Override
    public void assignValues() {
        
    }
    
   
   


//
//   public void toNumeric(){
//        
//        switch(convSeq[0]){
//            case 'T':
//                indSeq1.add(0, 1);
//                indSeq2.add(0, -1);
//                indSeq3.add(0, 1);
//                break;
//            case 'G':
//                indSeq1.add(0, 1);
//                indSeq2.add(0, -1);
//                indSeq3.add(0, -1);
//                break;
//            case 'C':
//            case 'A':
//                indSeq1.add(0, -1);
//                indSeq2.add(0, 1);
//                indSeq3.add(0, 1);
//                break;
//        }
//        
//        for (int i = 1; i<this.convSeq.length; i++) {
//            OUTER:
//            switch (convSeq[i]) {
//                case 'A':
//                    indSeq1.add((indSeq1.get(i-1))-1); 
//                    indSeq2.add((indSeq2.get(i-1))+1);
//                    indSeq3.add((indSeq3.get(i-1))+1);
//                    break;
//                case 'T':
//                    indSeq1.add((indSeq1.get(i-1))+1);
//                    indSeq2.add((indSeq2.get(i-1))-1);
//                    indSeq3.add((indSeq3.get(i-1))+1);
//                    break;
//                case 'G':
//                    indSeq1.add((indSeq1.get(i-1))+1);
//                    indSeq2.add((indSeq2.get(i-1))-1);
//                    indSeq3.add((indSeq3.get(i-1))-1);
//                    break;
//                case 'C':
//                    indSeq1.add((indSeq1.get(i-1))-1);
//                    indSeq2.add((indSeq2.get(i-1))+1);
//                    indSeq3.add((indSeq3.get(i-1))-1);
//                    break;
//                default:
//                    System.out.println("You have an issue here");
//                    break;
//            }
//        }
//    
//       System.out.println("Indicator sequence 1:" + indSeq1.toString() + "\n"
//               + "Indicator sequence 2: " + indSeq2.toString() + "\n"
//                       + "Indicator sequence 3: " + indSeq3.toString());
//    }
//    

}
