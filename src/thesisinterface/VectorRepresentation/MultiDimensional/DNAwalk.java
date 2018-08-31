/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import java.util.ArrayList;
import java.util.List;
import thesisinterface.VectorRepresentation.BaseClasses.Sequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class DNAwalk extends MultipleValueRepresentation{

    public DNAwalk(ISymbolSequence sequence) {
        super(sequence);
    }

   
    @Override
    public void createRepresentation() {
        numValues.put("C", getMultipleValueList(1.0));
        numValues.put("T", getMultipleValueList(1.0));
        numValues.put("A", getMultipleValueList(-1.0));
        numValues.put("G", getMultipleValueList(-1.0));

        calculateVectorDimensions();
    }
    
    
    
   @Override
    public void calculateVectorDimensions() {
         //For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            
            //Determine dimension name
            int sDimensionName = iSymbolCnt;
            //Assign the corresponding value from the numValues key to the feature
            
            put(sDimensionName, (numValues.get(sequence.getSymbolAt(iSymbolCnt))));
    }
   
   
}

}
