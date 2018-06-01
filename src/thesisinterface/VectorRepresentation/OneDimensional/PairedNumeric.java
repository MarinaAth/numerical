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
public class PairedNumeric extends SingleValueRepresentation {

    public PairedNumeric(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", getSingleValueList(-1.0));
        numValues.put("C", getSingleValueList(-1.0));
        numValues.put("A", getSingleValueList(1.0));
        numValues.put("T", getSingleValueList(1.0));
    }
    
   
    
}
