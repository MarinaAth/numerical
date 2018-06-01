/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class VossRepresentation extends MultipleValueRepresentation {

    public VossRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        
        
    }
    
    
   
//   public void toNumeric(){
//       
//        for (int i = 0; i<this.convSeq.length; i++) {
//            OUTER:
//            switch (convSeq[i]) {
//                case 'A':
//                    indSeqA.add(1); 
//                    indSeqT.add(0);
//                    indSeqG.add(0);
//                    indSeqC.add(0);
//                    break;
//                case 'T':
//                    indSeqA.add(0);
//                    indSeqT.add(1);
//                    indSeqG.add(0);
//                    indSeqC.add(0);
//                    break;
//                case 'G':
//                    indSeqA.add(0);
//                    indSeqT.add(0);
//                    indSeqG.add(1);
//                    indSeqC.add(0);
//                    break;
//                case 'C':
//                    indSeqA.add(0);
//                    indSeqT.add(0);
//                    indSeqG.add(0);
//                    indSeqC.add(1);
//                    break;
//                default:
//                    System.out.println("You have an issue here");
//                    break;
//            }
//        }
//    
//       System.out.println("Indicator sequence A:" + indSeqA.toString() + "\n"
//               + "Indicator sequence T: " + indSeqT.toString() + "\n"
//                       + "Indicator sequence G: " + indSeqG.toString() + "\n"
//                               + "Indicator sequence C: " + indSeqC.toString());
//    }
//   
//   public int[][] vectorArray(){
//       
//       int[][] array = new int[4][convSeq.length];
//       int seqSize = convSeq.length;
//       
//       for (int i=0; i<seqSize; i++){
//           array[0][i]=indSeqA.get(i);
//           array[1][i]=indSeqT.get(i);
//           array[2][i]=indSeqG.get(i);
//           array[3][i]=indSeqC.get(i);
//       }
//       return array;
//   }
//    
}
