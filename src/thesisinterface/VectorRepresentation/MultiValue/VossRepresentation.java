/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.util.ArrayList;
import java.util.List;
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
        
       numValues.put("G", getMultipleValueList(0.0));
       numValues.put("G", getMultipleValueList(1.0));
       numValues.put("G", getMultipleValueList(0.0));
       numValues.put("G", getMultipleValueList(0.0));
       numValues.put("A", getMultipleValueList(1.0));
       numValues.put("A", getMultipleValueList(0.0));
       numValues.put("A", getMultipleValueList(0.0));
       numValues.put("A", getMultipleValueList(0.0));
       numValues.put("C", getMultipleValueList(0.0));
       numValues.put("C", getMultipleValueList(0.0));
       numValues.put("C", getMultipleValueList(1.0));
       numValues.put("C", getMultipleValueList(0.0));
       numValues.put("T", getMultipleValueList(0.0));
       numValues.put("T", getMultipleValueList(0.0));
       numValues.put("T", getMultipleValueList(0.0));
       numValues.put("T", getMultipleValueList(1.0));
       
       calculateVectorDimensions();
    }
    
    @Override
        public void calculateVectorDimensions(){
        
        
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name
            int sDimensionName = (iSymbolCnt + 1);
            // Assign the corresponding value from the numValues key to the feature
            put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
        }            
    }
    
}
