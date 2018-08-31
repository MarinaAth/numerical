/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.OneDimensional;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 * This class is a representation, taking into account the atomic number.
 * @author marin
 */
public class AtomicNumberRepresentation extends SingleValueRepresentation {

    public AtomicNumberRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }
    
    @Override
    public void assignValues() {
       numValues.put("G", getSingleValueList(78.0));
       numValues.put("A", getSingleValueList(70.0));
       numValues.put("C", getSingleValueList(58.0));
       numValues.put("T", getSingleValueList(60.0));
    }
}