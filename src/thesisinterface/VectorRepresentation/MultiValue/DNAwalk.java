/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class DNAwalk extends MultipleValueRepresentation {

    public DNAwalk(ISymbolSequence sequence) {
        super(sequence);
    }

    double sum = 0.0;
    
    @Override
    public void assignValues() {
        numValues.put("C", getMultipleValueList(1.0));
        numValues.put("T", getMultipleValueList(1.0));
        numValues.put("A", getMultipleValueList(-1.0));
        numValues.put("G", getMultipleValueList(-1.0));
        numValues.put("N", getMultipleValueList(0.0));
    }

    @Override
    public void calculateVectorDimensions() {
        //For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {

            //Determine dimension name
            int sDimensionName = iSymbolCnt;

            //Assign the corresponding value from the numValues key to the feature
            
            put(sDimensionName, nextStep(sum, numValues.get(sequence.getSymbolAt(iSymbolCnt))));
            
            sum += numValues.get(sequence.getSymbolAt(iSymbolCnt)).get(0);
        }
        
        
    }
    
     public static MultipleValueRepresentation dnaWalk(String inputSequence) throws IOException {

    	BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        DNAwalk baseRepr = new DNAwalk(inputSeq);

        baseRepr.assignValues();

        baseRepr.calculateVectorDimensions();

        return baseRepr;
    }
     
     public List<Double> nextStep (Double sumOfPrevious, List<Double> currentValue){
         
         List<Double> toAdd = new ArrayList<>();
         toAdd.add(sumOfPrevious + currentValue.get(0));
         
         return toAdd;
     }

    
     
}
