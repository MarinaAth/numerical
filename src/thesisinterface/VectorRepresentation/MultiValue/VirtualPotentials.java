/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import thesisinterface.VectorRepresentation.ISymbolSequence;
import java.util.Map;
import java.util.TreeMap;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import java.text.DecimalFormat;
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

    
    public VirtualPotentials(ISymbolSequence sequence) {
        super(sequence);
    }

    DecimalFormat df = new DecimalFormat("$#.###");
    
    double aCount = 0.0;
    double cCount = 0.0;
    double gCount = 0.0;
    double tCount = 0.0;
    double nCount = 0.0;
    
    //initialization of the list of values
    @Override
    public void assignValues() {
        numValues.put("G", getMultipleValueList(aCount));
        numValues.get("G").addAll(getMultipleValueList(cCount));
        numValues.get("G").addAll(getMultipleValueList(gCount));
        numValues.get("G").addAll(getMultipleValueList(tCount));
        numValues.put("A", getMultipleValueList(aCount));
        numValues.get("A").addAll(getMultipleValueList(cCount));
        numValues.get("A").addAll(getMultipleValueList(gCount));
        numValues.get("A").addAll(getMultipleValueList(tCount));
        numValues.put("C", getMultipleValueList(aCount));
        numValues.get("C").addAll(getMultipleValueList(cCount));
        numValues.get("C").addAll(getMultipleValueList(gCount));
        numValues.get("C").addAll(getMultipleValueList(tCount));
        numValues.put("T", getMultipleValueList(aCount));
        numValues.get("T").addAll(getMultipleValueList(cCount));
        numValues.get("T").addAll(getMultipleValueList(gCount));
        numValues.get("T").addAll(getMultipleValueList(tCount));
        numValues.put("N", getMultipleValueList(nCount));
        numValues.get("N").addAll(getMultipleValueList(nCount));
        numValues.get("N").addAll(getMultipleValueList(nCount));
        numValues.get("N").addAll(getMultipleValueList(nCount));
    }

    @Override
    public void calculateVectorDimensions() {

        //For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {

            //Determine dimension name
            int sDimensionName = iSymbolCnt;

            //Assign the corresponding value from the numValues key to the feature
            if (iSymbolCnt <= 5) {

                List<Double> paddList = new ArrayList<>();
                paddList.add(0.0);
                paddList.add(0.0);
                paddList.add(0.0);
                paddList.add(0.0);
                put(sDimensionName, paddList);
            } else {
                //for a window of 6 nucleotides
                for (int i = iSymbolCnt; i >= iSymbolCnt - 5; i--) {

                    //distance from nucleotide of interest
                    
                    int distance = iSymbolCnt - i;
                    double potential = 1 / (double) distance;
                    
                    double frac = (double)Math.round(potential * 1000d) / 1000d;
                    
                    String key = sequence.getSymbolAt(i);

                    switch (key) {
                        case "A": aCount = aCount + frac;
                            break;

                        case "G": gCount = gCount + frac;
                            break;

                        case "C": cCount = cCount + frac;
                            break;

                        case "T": tCount = tCount + frac;
                            break;

                        case "N":
                            nCount = 0.0;
                            break;

                        default:
                            System.out.println("Look in assigning values");
                            break;
                    }
                   assignValues();
                }
                    
                    put(sDimensionName, numValues.get(sequence.getSymbolAt(iSymbolCnt)));
                    aCount= 0.0;
                    cCount=0.0;
                    gCount=0.0;
                    tCount=0.0;
                    

            }

           
        }
    }

    public static MultipleValueRepresentation virtualPotentialsRepresentation(String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        VirtualPotentials virtPotentRepr = new VirtualPotentials(inputSeq);

        virtPotentRepr.calculateVectorDimensions();

        return virtPotentRepr;
    }

//   public static void main(String[] args) throws IOException {
//        String seq = "CCCCACAACCTCNANCATCNNCTGCCC"; //TCTTTCATCCTTTTATTTNAN
//
//        System.out.println(virtualPotentialsRepresentation(seq));
//    }

}
