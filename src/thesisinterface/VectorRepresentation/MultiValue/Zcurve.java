/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.io.IOException;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class Zcurve extends MultipleValueRepresentation {

    double aCount = 0.0;
    double cCount = 0.0;
    double gCount = 0.0;
    double tCount = 0.0;
    double nCount = 0.0;
    
    public Zcurve(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", getMultipleValueList(calculateX(aCount,tCount,cCount,gCount)));
        numValues.get("G").addAll(getMultipleValueList(calculateY(aCount,tCount,cCount,gCount)));
        numValues.get("G").addAll(getMultipleValueList(calculateZ(aCount,tCount,cCount,gCount)));
        numValues.put("A", getMultipleValueList(calculateX(aCount,tCount,cCount,gCount)));
        numValues.get("A").addAll(getMultipleValueList(calculateY(aCount,tCount,cCount,gCount)));
        numValues.get("A").addAll(getMultipleValueList( calculateZ(aCount,tCount,cCount,gCount)));
        numValues.put("C", getMultipleValueList(calculateX(aCount,tCount,cCount,gCount)));
        numValues.get("C").addAll(getMultipleValueList(calculateY(aCount,tCount,cCount,gCount)));
        numValues.get("C").addAll(getMultipleValueList( calculateZ(aCount,tCount,cCount,gCount)));
        numValues.put("T", getMultipleValueList(calculateX(aCount,tCount,cCount,gCount)));
        numValues.get("T").addAll(getMultipleValueList(calculateY(aCount,tCount,cCount,gCount)));
        numValues.get("T").addAll(getMultipleValueList( calculateZ(aCount,tCount,cCount,gCount)));
        numValues.put("N", getMultipleValueList(0.0));
        numValues.get("N").addAll(getMultipleValueList(0.0));
        numValues.get("N").addAll(getMultipleValueList(nCount));
    }

    @Override
    public void calculateVectorDimensions() {

        
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name
            
           int sDimensionName = (iSymbolCnt + 1);
           
           String key = sequence.getSymbolAt(iSymbolCnt); 
            
            //Counter depending on the nucleotide currently on the sequence
            switch(key){
                case "A": aCount += 1.0;
                break;
                
                case "G": gCount += 1.0;
                break;
                
                case "C": cCount += 1.0;
                break;
                
                case "T": tCount += 1.0;
                break;
                
                case "N": nCount += 1.0;
                break;
                
                default : System.out.println("Look in assigning values in Zcurve");
                break;
            }
            
          // Assign the corresponding values here because of use of functions
          assignValues();
          
          // Create dimensions
          put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
          
            
        } 
    }
    
    //Methods for calculating dimensions based on Kwan and Arniker (2009) 
    public double calculateX(double a, double t, double c, double g){
         double x = (a+g) - (c+t);
         return x;
    }
  
   public double calculateY(double a, double t, double c, double g){
         double y = (a+c) - (g+t);
         return y;
    } 
   
   public double calculateZ(double a, double t, double c, double g){
         double z = (a+t) - (c+g);
         return z;
    }
   
   //skip assignValues() here, use it instead in calculateVectorDimensions()
   public static MultipleValueRepresentation ZcurveRepresentation(String inputSequence) throws IOException {
        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        Zcurve zCurve = new Zcurve(inputSeq);
        zCurve.calculateVectorDimensions();

        return zCurve;
   }
   
//   public static void main(String[] args) throws IOException {
//        String seq = "ATAATNAGCTTTGNTAC";
//        
//        MultipleValueRepresentation example = ZcurveRepresentation(seq);
//        
//        System.out.println(example);
//    }
}
