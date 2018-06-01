/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.OneDimensional;

import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class ElectronIonRepresentation extends SingleValueRepresentation {

    public ElectronIonRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", getSingleValueList(0.0806));
        numValues.put("A", getSingleValueList(0.1260));
        numValues.put("C", getSingleValueList(0.1340));
        numValues.put("T", getSingleValueList(0.1335));
    }
    
    
}
