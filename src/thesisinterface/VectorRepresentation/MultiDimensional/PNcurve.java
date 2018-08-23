/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class PNcurve extends MultipleValueRepresentation{

    Map< String, List<Double>> initialCoord = new HashMap<>();
    public PNcurve(ISymbolSequence sequence) {
        super(sequence);
    }
    
    @Override
    public void createRepresentation() {
        numValues.put("AA", getMultipleValueList(1.0));
        numValues.put("AΤ", getMultipleValueList(2.0));
        numValues.put("AG", getMultipleValueList(3.0));
        numValues.put("AC", getMultipleValueList(4.0));
        numValues.put("TA", getMultipleValueList(5.0));
        numValues.put("TΤ", getMultipleValueList(6.0));
        numValues.put("TG", getMultipleValueList(7.0));
        numValues.put("TC", getMultipleValueList(8.0));
        numValues.put("GA", getMultipleValueList(9.0));
        numValues.put("GΤ", getMultipleValueList(10.0));
        numValues.put("GG", getMultipleValueList(11.0));
        numValues.put("GC", getMultipleValueList(12.0));
        numValues.put("CA", getMultipleValueList(13.0));
        numValues.put("CT", getMultipleValueList(14.0));
        numValues.put("CG", getMultipleValueList(15.0));
        numValues.put("CC", getMultipleValueList(16.0));
        
        
        
        
    }

    @Override
    public void calculateVectorDimensions() {
        
        int count = 1;
        
        for (int iSymbolCnt=0; iSymbolCnt<sequence.size();iSymbolCnt++){
            
           String sDimensionName = (sequence.getSymbolAt(iSymbolCnt+1) + sequence.getSymbolAt(iSymbolCnt+2)) + count;
           
           String key = (sequence.getSymbolAt(iSymbolCnt)+sequence.getSymbolAt(iSymbolCnt+1));
           
           
           
        }
    }
    
    //method for euclidean distance for all the items in two lists
    public double euclideanDistance(List<Double> coord1, List<Double> coord2){
        double tmp = 0;
        //run through list 1 with the coordinates of the first point(dinucleotide)
        for (int i=0; i<coord1.size();i++){
            //run through list 2 with the coordinates of the second point (dinucleotide)
            for (int j=0;j<coord2.size();j++){
               //variable tmp will equal the second power of the difference for eace pair of points from the two lists
               tmp += Math.pow(coord1.get(i) - coord2.get(j), 2);
            }
        }
        // return square root of tmp=euclidean distance 
        return Math.sqrt(tmp);
      
    }
    
}
