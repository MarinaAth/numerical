/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.OneDimensional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import thesisinterface.VectorRepresentation.BaseClasses.BaseFeatureVector;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public abstract class SingleValueRepresentation extends BaseFeatureVector {

    protected Map<String, List<Double>> numValues = new HashMap<>();
    protected ISymbolSequence sequence;
    
    public SingleValueRepresentation(ISymbolSequence sequence) {
        this.sequence = sequence;
      }

    public List<Double> getSingleValueList(double element){
        List<Double> dlist = new ArrayList<>();
        dlist.add(element);
        return dlist;
    }
    
    public abstract void assignValues();


    public void calculateVectorDimensions(){
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name
            int sDimensionName = iSymbolCnt ;
            // Assign the corresponding value from the atomicNumValues key to the feature
            put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
        }
        
    }
    
    
   
}
    
