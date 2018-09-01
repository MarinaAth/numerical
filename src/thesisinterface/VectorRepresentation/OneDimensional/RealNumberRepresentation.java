/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.OneDimensional;

import java.io.FileWriter;
import java.io.IOException;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class RealNumberRepresentation extends SingleValueRepresentation {

    public RealNumberRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", getSingleValueList(-0.5));
        numValues.put("A", getSingleValueList(-1.5));
        numValues.put("C", getSingleValueList(0.5));
        numValues.put("T", getSingleValueList(1.5));
    }

    
    public static void realNumberRepresentation(FileWriter outputFile, String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        RealNumberRepresentation realNumRepr = new RealNumberRepresentation(inputSeq);

        realNumRepr.assignValues();

        realNumRepr.calculateVectorDimensions();

        outputFile.write(realNumRepr.toString() + "\n");
        outputFile.write(realNumRepr.getDimensionNames() + "\n");
    }
    
    
}

