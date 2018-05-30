/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marin
 */
public abstract class SingleValueRepresentation extends BaseFeatureVector {
    protected Map<String, Double> numValues = new HashMap<>();
    protected ISymbolSequence sequence;
    
    public SingleValueRepresentation(ISymbolSequence sequence) {
        this.sequence = sequence;
        assignValues();
        calculateVectorDimensions();
    }

    
    public abstract void assignValues();


    public void calculateVectorDimensions(){
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name
            String sDimensionName = "X" + (iSymbolCnt + 1);
            // Assign the corresponding value from the atomicNumValues key to the feature
            put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
        }            
    }
    
}
