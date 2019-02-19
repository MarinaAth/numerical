/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class PNcurve extends MultipleValueRepresentation{

    Map< String, Integer> keyCount = new HashMap<>();
    Map<String, List<Double>> coordinatesMap = new HashMap<>();
    List<Double> distanceBasedList = new LinkedList<>();
    List<String> existingKeys = new LinkedList();
    
    public PNcurve(ISymbolSequence sequence) {
        super(sequence);
    }
    
    @Override
    public void assignValues() {
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
        
        int count = 0;
        for (int iSymbolCnt=0; iSymbolCnt<sequence.size();iSymbolCnt++){
           //Dimension name for dinucleotide as integer
           String concat = Integer.toString(iSymbolCnt) + Integer.toString(iSymbolCnt+1);
           int sDimensionName = Integer.parseInt(concat);
           
           String key = (sequence.getSymbolAt(iSymbolCnt)+sequence.getSymbolAt(iSymbolCnt+1));
           //count for key=dinucleotide so far
           if(!existingKeys.contains(key)){
               existingKeys.add(key);
               keyCount.put(key, count);
           }else {
               count = keyCount.get(key);
               keyCount.put(key, count);
           }
           //create a Map with coordinates from which we'll get the dimension values
           coordinatesMap.put(key, numValues.get(key));
           coordinatesMap.put(key, getMultipleValueList(count));
           coordinatesMap.put(key, getMultipleValueList(iSymbolCnt+1));
           
           //create Map for euclidean distance, M/M, L/L 
           for(int i=iSymbolCnt;i<iSymbolCnt;i--){
               String concatCompare =Integer.toString(i-1) + Integer.toString(i);
               double euclDist = (euclideanDistance(coordinatesMap.get(concatCompare), coordinatesMap.get(concat)));
               distanceBasedList.add(euclDist);
               distanceBasedList.add(MMatrix(euclDist, i));
               
           }
           //not right - need to fix for LMatrix and for List that keeps adding/possibly Map and retrieve for Key??
           put(sDimensionName, distanceBasedList);
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
    
    public double MMatrix(double euclideanDistance, int peaks){
        return (euclideanDistance/peaks);
    }
    
//    public double LMatrix(){
//        //sum for AT-GG = euclidean Distance of AT-TG + euclidean distance of TG-GG
//        
//        
//        return (euclideanDistance/sum);
//    }
}
