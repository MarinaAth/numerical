/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import java.util.ArrayList;
import java.util.List;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class VossRepresentation extends MultipleValueRepresentation {

    
    protected List<Double> valuesG = new ArrayList<>();
    protected List<Double> valuesA = new ArrayList<>();
    protected List<Double> valuesT = new ArrayList<>();
    protected List<Double> valuesC = new ArrayList<>();
    
    public VossRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
       
       valuesA.add(0, 1.0);
       valuesA.add(1, 0.0);
       valuesA.add(2, 0.0);
       valuesA.add(3, 0.0);
       valuesG.add(0, 0.0);
       valuesG.add(1, 1.0);
       valuesG.add(2, 0.0);
       valuesG.add(3, 0.0);
       valuesC.add(0, 0.0);
       valuesC.add(1, 0.0);
       valuesC.add(2, 1.0);
       valuesC.add(3, 0.0);
       valuesT.add(0, 0.0);
       valuesT.add(1, 0.0);
       valuesT.add(2, 0.0);
       valuesT.add(3, 1.0);
        
       numValues.put("G", valuesG);
       numValues.put("A", valuesA);
       numValues.put("C", valuesC);
       numValues.put("T", valuesT);  
       
    }
    
    
}
