/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.SingleValue;


import java.io.FileWriter;
import java.io.IOException;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class IntegerRepresentation extends SingleValueRepresentation {

    public IntegerRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", getSingleValueList(3.0));
        numValues.put("A", getSingleValueList(2.0));
        numValues.put("C", getSingleValueList(1.0));
        numValues.put("T", getSingleValueList(0.0));
    }
  
    public static SingleValueRepresentation integerRepresentation(String inputSequence) throws IOException {

    	BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        SingleValueRepresentation integerNumRepr = new IntegerRepresentation(inputSeq);

        integerNumRepr.assignValues();

        integerNumRepr.calculateVectorDimensions();

//        outputFile.write(integerNumRepr.toString() + "\n");
        
        return integerNumRepr;
    }

    @Override
    public double missinValueAssign() {
        return 4.0;
    }
}
