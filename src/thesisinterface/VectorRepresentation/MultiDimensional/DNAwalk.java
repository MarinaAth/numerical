/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import java.util.LinkedList;
import java.util.List;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class DNAwalk extends MultipleValueRepresentation {

    public DNAwalk(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("C", getMultipleValueList(1.0));
        numValues.put("T", getMultipleValueList(1.0));
        numValues.put("A", getMultipleValueList(-1.0));
        numValues.put("G", getMultipleValueList(-1.0));

    }

    @Override
    public void calculateVectorDimensions() {
        //For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {

            //Determine dimension name
            int sDimensionName = iSymbolCnt;

            //Assign the corresponding value from the numValues key to the feature
            if (iSymbolCnt == 0) {
                put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
            } else {
                put(sDimensionName, sumOfDimensions(numValues.get(sequence.getSymbolAt(iSymbolCnt - 1)), numValues.get(sequence.getSymbolAt(iSymbolCnt))));

            }

        }

    }

    public List<Double> sumOfDimensions(List<Double> a, List<Double> b) {

        List<Double> result = new LinkedList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i) + b.get(i));
        }

        return result;
    }
}
