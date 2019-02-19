/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;


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
       numValues.get("G").addAll(getMultipleValueList(-(Math.sqrt(6.0)/3)));
       numValues.get("G").addAll(getMultipleValueList(-(1.0/3.0)));
       numValues.put("A", getMultipleValueList(0.0));
       numValues.get("A").addAll(getMultipleValueList(0.0));
       numValues.get("A").addAll(getMultipleValueList(1.0));
       numValues.put("C", getMultipleValueList(-(Math.sqrt(2.0)/3)));
       numValues.get("C").addAll(getMultipleValueList(Math.sqrt(6.0)/3));
       numValues.get("C").addAll(getMultipleValueList(-(1.0/3.0)));
       numValues.put("T", getMultipleValueList(2*(Math.sqrt(2.0)/3)));
       numValues.get("T").addAll(getMultipleValueList(0.0));
       numValues.get("T").addAll(getMultipleValueList(-(1.0/3.0)));
       
    }
    
    @Override
    public void calculateVectorDimensions()
    {
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name
            int sDimensionName = iSymbolCnt + 1;
            // Assign the corresponding value from the numValues key to the feature
            put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
        }
    }
        
    public static MultipleValueRepresentation tetrahedronRepresentation(String inputSequence) throws IOException {
        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        Tetrahedron tetrahedroRepr = new Tetrahedron(inputSeq);
        tetrahedroRepr.assignValues();
        tetrahedroRepr.calculateVectorDimensions();

        return tetrahedroRepr;
    }
//
//    public static void main(String[] args) {
//        System.out.println("The representation for the string AGTC is...");
//        Tetrahedron t = new Tetrahedron(new BaseSymbolSequence("AGTC"));
//        t.assignValues();
//        t.calculateVectorDimensions();
//
//        System.out.println(t);
//    }
}
