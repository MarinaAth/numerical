/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import thesisinterface.VectorRepresentation.ISymbolSequence;
import java.util.Map;
/**
 *
 * @author marin
 */
public class VirtualPotentials extends MultipleValueRepresentation{

    
    public VirtualPotentials(ISymbolSequence sequence) {
        super(sequence);
    }

    
    @Override
    public void assignValues() {
        numValues.put("C", getMultipleValueList(0.0));
        numValues.put("T", getMultipleValueList(0.0));
        numValues.put("A", getMultipleValueList(0.0));
        numValues.put("G", getMultipleValueList(0.0));
    }

    @Override
    public void calculateVectorDimensions() {
        
        double distance;
        double virtPotent;
        Map<String,List<Double>> virtualPotentials = new HashMap<>();
        List<Double> distances = new LinkedList<>();
        //For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {

            //Determine dimension name
            int sDimensionName = iSymbolCnt;

            //Assign the corresponding value from the numValues key to the feature
            if (iSymbolCnt < 25) {
                put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
            } else {
                //for a window of 25 nucleotides
                for(int i=iSymbolCnt-1; i>iSymbolCnt-26; i--){
                    //distance from nucleotide of interest
                    distance = i;
                    if()
                    //calculate virtual Potential
                    virtPotent = 1/distance;
                    //add it to a list
                    virtualPotentials.add(virtPotent);
                }
                //corresponding dimension with list of virtual potentials
                put(sDimensionName, virtualPotentials);
                //clear the list to start over
                virtualPotentials.clear();
            }

        }
    }
    
}
