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
public class DNAwalk extends CumulativeValueRepresentation{

    public DNAwalk(ISymbolSequence sequence) {
        super(sequence);
    }

    
    
    @Override
    public void assignValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
//   public void toNumeric(){
//        if (convSeq[0]=='C'||convSeq[0]=='T'){
//           indicatorSequence.add(0, 1);
//        } else {
//            indicatorSequence.add(0, -1);
//        }
//        for (int i = 1; i<this.convSeq.length; i++) {
//            OUTER:
//            switch (convSeq[i]) {
//                case 'C' :
//                case 'T':
//                    indicatorSequence.add((indicatorSequence.get(i-1))+1);
//                    break OUTER;
//                case 'G':
//                case 'A':
//                    indicatorSequence.add((indicatorSequence.get(i-1))-1);
//                    break OUTER;
//                default:
//                    System.out.println("You have an issue here");
//                    break OUTER;
//            }
//        }
//    
//       System.out.println("Indicator sequence :" + indicatorSequence.toString());
//    }
//   
//   
//    
   
   
}
