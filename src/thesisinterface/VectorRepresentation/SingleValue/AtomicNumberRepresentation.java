/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.SingleValue;
import java.io.IOException;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
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
       numValues.put("N", getSingleValueList(0.0));
    }
    
    public static SingleValueRepresentation atomicNumberRepresentation(String inputSequence) throws IOException {

    	BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        AtomicNumberRepresentation atomicNumRepr = new AtomicNumberRepresentation(inputSeq);

        atomicNumRepr.assignValues();

        atomicNumRepr.calculateVectorDimensions();

        return atomicNumRepr;
    }

    @Override
    public double missinValueAssign() {
        return 0.0;
    }
    
    
}