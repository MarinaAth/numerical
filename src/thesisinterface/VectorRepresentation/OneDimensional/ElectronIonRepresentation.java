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
    
    public static void electronIonRepresentation(FileWriter outputFile, String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        ElectronIonRepresentation electronIonRepr = new ElectronIonRepresentation(inputSeq);

        electronIonRepr.assignValues();

        electronIonRepr.calculateVectorDimensions();

        outputFile.write(electronIonRepr.toString() + "\n");
        outputFile.write(electronIonRepr.getDimensionNames() + "\n");
    }
}
