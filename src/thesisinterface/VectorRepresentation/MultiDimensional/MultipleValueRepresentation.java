/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

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
public abstract class MultipleValueRepresentation extends BaseFeatureVector{
    
    
    protected Map<String, List<Double> > numValues = new HashMap<>();
    protected ISymbolSequence sequence;
    
    public MultipleValueRepresentation(ISymbolSequence sequence) {
        this.sequence = sequence;
        
    }

    public List<Double> getMultipleValueList(double element){
        List<Double> dlist = new LinkedList<>();
        dlist.add(element);
        return dlist;
    }
    
    public abstract void assignValues();

    public abstract void calculateVectorDimensions();
   
    

}
