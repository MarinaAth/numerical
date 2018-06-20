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
public class Tetrahedron extends MultipleValueRepresentation {

    protected List<Double> valuesG = new ArrayList<>();
    protected List<Double> valuesA = new ArrayList<>();
    protected List<Double> valuesT = new ArrayList<>();
    protected List<Double> valuesC = new ArrayList<>();
    
    public Tetrahedron(ISymbolSequence sequence) {
        super(sequence);
    }
    
    @Override
    public void assignValues() {
       
               
       valuesG.add(0, -(Math.sqrt(2.0)/3));
       valuesG.add(1, -(Math.sqrt(6.0)/3));
       valuesG.add(2, -(1.0/3.0));
       valuesA.add(0, 0.0);
       valuesA.add(1, 0.0);
       valuesA.add(2, 1.0);
       valuesC.add(0, -(Math.sqrt(2.0)/3));
       valuesC.add(1, (Math.sqrt(6.0)/3));
       valuesC.add(2, -(1.0/3.0));
       valuesT.add(0, 2*(Math.sqrt(2.0)/3));
       valuesT.add(1, 0.0);
       valuesT.add(2, -(1.0/3.0));
        
       numValues.put("G", valuesG);
       numValues.put("A", valuesA);
       numValues.put("C", valuesC);
       numValues.put("T", valuesT);
    }
}
