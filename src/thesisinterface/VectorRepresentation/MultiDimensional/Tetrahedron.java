/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;
import thesisinterface.VectorRepresentation.OneDimensional.RealNumberRepresentation;

/**
 *
 * @author marin
 */
public class Tetrahedron extends MultipleValueRepresentation {

    public Tetrahedron(ISymbolSequence sequence) {
        super(sequence);
    }
    
    @Override
    public void assignValues() {
       
       numValues.put("G", getMultipleValueList( -(Math.sqrt(2.0)/3)));
       numValues.put("G", getMultipleValueList(-(Math.sqrt(6.0)/3)));
       numValues.put("G", getMultipleValueList(-(1.0/3.0)));
       numValues.put("A", getMultipleValueList(0.0));
       numValues.put("A", getMultipleValueList(0.0));
       numValues.put("A", getMultipleValueList(1.0));
       numValues.put("C", getMultipleValueList(-(Math.sqrt(2.0)/3)));
       numValues.put("C", getMultipleValueList(Math.sqrt(6.0)/3));
       numValues.put("C", getMultipleValueList(-(1.0/3.0)));
       numValues.put("T", getMultipleValueList(2*(Math.sqrt(2.0)/3)));
       numValues.put("T", getMultipleValueList(0.0));
       numValues.put("T", getMultipleValueList(-(1.0/3.0)));
       
       calculateVectorDimensions();
       
    }
    
    @Override
        public void calculateVectorDimensions(){
        
        
            // For each symbol in sequence
            for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
                // Determine dimension name
                int sDimensionName = iSymbolCnt + 1;
                // Assign the corresponding value from the numValues key to the feature
                put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
            }            
    }
        
        public static void tetrahedronRepresentation(FileWriter outputFile, String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        Tetrahedron tetrahedroRepr = new Tetrahedron(inputSeq);

        tetrahedroRepr.calculateVectorDimensions();

        outputFile.write(tetrahedroRepr.toString() + "\n");
        outputFile.write(tetrahedroRepr.getDimensionNames() + "\n");
    }
}
