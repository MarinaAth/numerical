/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import thesisinterface.VectorRepresentation.ISymbolSequence;
import java.util.Map;
import java.util.TreeMap;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;

/**
 *
 * @author marina Virtual Potential of a nucleotide: each nucleotide in the
 * sequence (character) is defined by four values, which correspond to the sum
 * of the distances of each type of nucleotide in 25-nucleotide window from the
 * one we are currently processing. E.g. if d=distance, the 27th nucleotide
 * (Dimension X27) corresponds to 4 values: sum of the 1/d of all the As, sum of
 * the 1/d of all the Ts etc. in a 25 nucleotide window
 */
public class VirtualPotentials extends MultipleValueRepresentation {

    double distance;
    double virtPotent = 1 / distance;
    Map<String, Double> virtualPotentials = new HashMap<>();
    List<Double> distances = new LinkedList<>();

    public VirtualPotentials(ISymbolSequence sequence) {
        super(sequence);
    }

    //initialization of the list of values
    @Override
    public void assignValues() {
        numValues.put("C", getMultipleValueList(virtPotent));
        numValues.put("T", getMultipleValueList(virtPotent));
        numValues.put("A", getMultipleValueList(virtPotent));
        numValues.put("G", getMultipleValueList(virtPotent));
    }

    @Override
    public void calculateVectorDimensions() {

        //For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {

            //Determine dimension name
            int sDimensionName = iSymbolCnt;

            //Assign the corresponding value from the numValues key to the feature
            if (iSymbolCnt < 25) {
                virtPotent = 0;
                put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
            } else {
                //for a window of 25 nucleotides
                for (int i = iSymbolCnt - 1; i > iSymbolCnt - 26; i--) {
                    
                    //distance from nucleotide of interest
                    distance = i;

                    String dimension = sequence.getSymbolAt(i);

                    if (containsKey(iSymbolCnt)) {
                        numValues.get(dimension).add(1 / distance);
                    }
                    put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
                }

            }
        }
    }
    
    public static MultipleValueRepresentation virtualPotentialsRepresentation(String inputSequence) throws IOException {

    	BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        VirtualPotentials virtPotentRepr = new VirtualPotentials(inputSeq);

        virtPotentRepr.assignValues();

        virtPotentRepr.calculateVectorDimensions();
        
        return virtPotentRepr;
    }
}
