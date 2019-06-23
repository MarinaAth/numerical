/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class PNcurve extends MultipleValueRepresentation{

    Map<String, List<Double>> coordinatesMap = new HashMap<>();
    Map <String, Double> existingKeys = new HashMap<>();
    
    public PNcurve(ISymbolSequence sequence) {
        super(sequence);
    }
    
    @Override
    public void assignValues() {
        numValues.put("AA", getMultipleValueList(1.0));
        numValues.get("AA").addAll(getMultipleValueList(0.0));
        numValues.get("AA").addAll(getMultipleValueList(0.0));
        numValues.put("AT", getMultipleValueList(2.0));
        numValues.get("AT").addAll(getMultipleValueList(0.0));
        numValues.get("AT").addAll(getMultipleValueList(0.0));
        numValues.put("AG", getMultipleValueList(3.0));
        numValues.get("AG").addAll(getMultipleValueList(0.0));
        numValues.get("AG").addAll(getMultipleValueList(0.0));
        numValues.put("AC", getMultipleValueList(4.0));
        numValues.get("AC").addAll(getMultipleValueList(0.0));
        numValues.get("AC").addAll(getMultipleValueList(0.0));
        numValues.put("TA", getMultipleValueList(5.0));
        numValues.get("TA").addAll(getMultipleValueList(0.0));
        numValues.get("TA").addAll(getMultipleValueList(0.0));
        numValues.put("TT", getMultipleValueList(6.0));
        numValues.get("TT").addAll(getMultipleValueList(0.0));
        numValues.get("TT").addAll(getMultipleValueList(0.0));
        numValues.put("TG", getMultipleValueList(7.0));
        numValues.get("TG").addAll(getMultipleValueList(0.0));
        numValues.get("TG").addAll(getMultipleValueList(0.0));
        numValues.put("TC", getMultipleValueList(8.0));
        numValues.get("TC").addAll(getMultipleValueList(0.0));
        numValues.get("TC").addAll(getMultipleValueList(0.0));
        numValues.put("GA", getMultipleValueList(9.0));
        numValues.get("GA").addAll(getMultipleValueList(0.0));
        numValues.get("GA").addAll(getMultipleValueList(0.0));
        numValues.put("GT", getMultipleValueList(10.0));
        numValues.get("GT").addAll(getMultipleValueList(0.0));
        numValues.get("GT").addAll(getMultipleValueList(0.0));
        numValues.put("GG", getMultipleValueList(11.0));
        numValues.get("GG").addAll(getMultipleValueList(0.0));
        numValues.get("GG").addAll(getMultipleValueList(0.0));
        numValues.put("GC", getMultipleValueList(12.0));
        numValues.get("GC").addAll(getMultipleValueList(0.0));
        numValues.get("GC").addAll(getMultipleValueList(0.0));
        numValues.put("CA", getMultipleValueList(13.0));
        numValues.get("CA").addAll(getMultipleValueList(0.0));
        numValues.get("CA").addAll(getMultipleValueList(0.0));
        numValues.put("CT", getMultipleValueList(14.0));
        numValues.get("CT").addAll(getMultipleValueList(0.0));
        numValues.get("CT").addAll(getMultipleValueList(0.0));
        numValues.put("CG", getMultipleValueList(15.0));
        numValues.get("CG").addAll(getMultipleValueList(0.0));
        numValues.get("CG").addAll(getMultipleValueList(0.0));
        numValues.put("CC", getMultipleValueList(16.0));
        numValues.get("CC").addAll(getMultipleValueList(0.0));
        numValues.get("CC").addAll(getMultipleValueList(0.0));
        numValues.put("NN", getMultipleValueList(0.0));
        numValues.get("NN").addAll(getMultipleValueList(0.0));
        numValues.get("NN").addAll(getMultipleValueList(0.0));
        numValues.put("AN", getMultipleValueList(0.0));
        numValues.get("AN").addAll(getMultipleValueList(0.0));
        numValues.get("AN").addAll(getMultipleValueList(0.0));
        numValues.put("TN", getMultipleValueList(0.0));
        numValues.get("TN").addAll(getMultipleValueList(0.0));
        numValues.get("TN").addAll(getMultipleValueList(0.0));
        numValues.put("GN", getMultipleValueList(0.0));
        numValues.get("GN").addAll(getMultipleValueList(0.0));
        numValues.get("GN").addAll(getMultipleValueList(0.0));
        numValues.put("CN", getMultipleValueList(0.0));
        numValues.get("CN").addAll(getMultipleValueList(0.0));
        numValues.get("CN").addAll(getMultipleValueList(0.0));
        numValues.put("NA", getMultipleValueList(0.0));
        numValues.get("NA").addAll(getMultipleValueList(0.0));
        numValues.get("NA").addAll(getMultipleValueList(0.0));
        numValues.put("NT", getMultipleValueList(0.0));
        numValues.get("NT").addAll(getMultipleValueList(0.0));
        numValues.get("NT").addAll(getMultipleValueList(0.0));
        numValues.put("NG", getMultipleValueList(0.0));
        numValues.get("NG").addAll(getMultipleValueList(0.0));
        numValues.get("NG").addAll(getMultipleValueList(0.0));
        numValues.put("NC", getMultipleValueList(0.0));
        numValues.get("NC").addAll(getMultipleValueList(0.0));
        numValues.get("NC").addAll(getMultipleValueList(0.0));
    }

    
    @Override
    public void calculateVectorDimensions() {
        
        double count = 1.0;
        
        for (int iSymbolCnt=0; iSymbolCnt<sequence.size() ;iSymbolCnt++){
           //Dimension name for dinucleotide as integer
          
           int sDimensionName = iSymbolCnt+1;
           
           
           
           if(iSymbolCnt==sequence.size()-1){
           
           assignValues();
           
           List <Double> paddList = new ArrayList<>();
           paddList.add(0.0);
           paddList.add(0.0);
           paddList.add(0.0);
           
           put(sDimensionName, paddList);
           
           } else {
               
               String key = sequence.getSymbolAt(iSymbolCnt)+sequence.getSymbolAt(iSymbolCnt+1);
               //count for key dinucleotide so far
           
           if(!existingKeys.containsKey(key)){
               existingKeys.put(key, 1.0);
               
           }else {
              existingKeys.replace(key, existingKeys.get(key)+1);
           }
           
           assignValues();
           numValues.get(key).set(1, existingKeys.get(key));
           
           numValues.get(key).set(2, count);
           
           //create a Map with coordinates from which we'll get the dimension values
           
           put(sDimensionName, numValues.get(key));
           
           count +=1.0;
           }
           
        }
    }
    
    public static MultipleValueRepresentation PNCurveRepresentation(String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        PNcurve PNcurveRepr = new PNcurve(inputSeq);

        PNcurveRepr.calculateVectorDimensions();

        return PNcurveRepr;

    }
    
    public static void main(String[] args) throws IOException {
        String seq = "ATATAGANNNGCTTGTACTAGTCTTTACGTA";
        
        System.out.println(PNCurveRepresentation(seq));
    }
}
