/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.Cumulative;

import java.util.ArrayList;
import java.util.List;
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
    public void calculateVectorDimensions() {
         //For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            
            List<Double> value = get(sequence.getSymbolAt(iSymbolCnt-1));
            
            //Determine dimension name
            String sDimensionName = "X" + (iSymbolCnt + 1);
            //Assign the corresponding value from the numValues key to the feature
            
            if(sDimensionName.equalsIgnoreCase("C")||sDimensionName.equalsIgnoreCase("T"))
            put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
    }
   
   
}
    
}
