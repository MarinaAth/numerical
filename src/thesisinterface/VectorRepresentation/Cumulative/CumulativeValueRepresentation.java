/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.Cumulative;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import thesisinterface.VectorRepresentation.BaseClasses.BaseFeatureVector;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public abstract class CumulativeValueRepresentation extends BaseFeatureVector{

    protected Map<String, List<Double> > numValues = new HashMap<>();
    protected ISymbolSequence sequence;
    
    public CumulativeValueRepresentation(ISymbolSequence sequence) {
        this.sequence = sequence;
        assignValues();
        calculateVectorDimensions();
    }
    
    
    public abstract void assignValues();


    public void calculateVectorDimensions(){
        
        
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            
            List<Double> value = get(sequence.getSymbolAt(iSymbolCnt-1));
            
            // Determine dimension name
            String sDimensionName = "X" + (iSymbolCnt + 1);
            // Assign the corresponding value from the numValues key to the feature
            put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
        }            
    }
}
