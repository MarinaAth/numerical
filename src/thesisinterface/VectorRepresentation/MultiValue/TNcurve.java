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
public class TNcurve extends MultipleValueRepresentation{

    List<Double> xValues = new ArrayList<>();
    List<Double> yValues = new ArrayList<>();
    double meanX;
    double meanY;
    public TNcurve(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        
        numValues.put("AAA", getMultipleValueList(1.0));
        numValues.put("AAA", getMultipleValueList(1.0));
        numValues.put("AGA", getMultipleValueList(-1.0));
        numValues.put("AGA", getMultipleValueList(1.0));
        numValues.put("ACA", getMultipleValueList(-1.0));
        numValues.put("ACA", getMultipleValueList(-1.0));
        numValues.put("ATA", getMultipleValueList(1.0));
        numValues.put("ATA", getMultipleValueList(-1.0));
        numValues.put("GAG", getMultipleValueList(2.0));
        numValues.put("GAG", getMultipleValueList(2.0));
        numValues.put("GGG", getMultipleValueList(-2.0));
        numValues.put("GGG", getMultipleValueList(2.0));
        numValues.put("GCG", getMultipleValueList(-2.0));
        numValues.put("GCG", getMultipleValueList(-2.0));
        numValues.put("GTG", getMultipleValueList(2.0));
        numValues.put("GTG", getMultipleValueList(-2.0));
        numValues.put("CAC", getMultipleValueList(3.0));
        numValues.put("CAC", getMultipleValueList(3.0));
        numValues.put("CGC", getMultipleValueList(-3.0));
        numValues.put("CGC", getMultipleValueList(3.0));
        numValues.put("CCC", getMultipleValueList(-3.0));
        numValues.put("CCC", getMultipleValueList(-3.0));
        numValues.put("CTC", getMultipleValueList(3.0));
        numValues.put("CTC", getMultipleValueList(-3.0));
        numValues.put("TAT", getMultipleValueList(4.0));
        numValues.put("TAT", getMultipleValueList(4.0));
        numValues.put("TGT", getMultipleValueList(-4.0));
        numValues.put("TGT", getMultipleValueList(4.0));
        numValues.put("TCT", getMultipleValueList(-4.0));
        numValues.put("TCT", getMultipleValueList(-4.0));
        numValues.put("TTT", getMultipleValueList(4.0));
        numValues.put("TTT", getMultipleValueList(-4.0));
        numValues.put("AAG", getMultipleValueList(1.0));
        numValues.put("AAG", getMultipleValueList(2.0));
        numValues.put("AGG", getMultipleValueList(-1.0));
        numValues.put("AGG", getMultipleValueList(2.0));
        numValues.put("ACG", getMultipleValueList(-1.0));
        numValues.put("ACG", getMultipleValueList(-2.0));
        numValues.put("ATG", getMultipleValueList(1.0));
        numValues.put("ATG", getMultipleValueList(-2.0));
        numValues.put("GAA", getMultipleValueList(2.0));
        numValues.put("GAA", getMultipleValueList(1.0));
        numValues.put("GGA", getMultipleValueList(-2.0));
        numValues.put("GGA", getMultipleValueList(1.0));
        numValues.put("GCA", getMultipleValueList(-2.0));
        numValues.put("GCA", getMultipleValueList(-1.0));
        numValues.put("GTA", getMultipleValueList(2.0));
        numValues.put("GTA", getMultipleValueList(-1.0));
        numValues.put("CAT", getMultipleValueList(3.0));
        numValues.put("CAT", getMultipleValueList(4.0));
        numValues.put("CGT", getMultipleValueList(-3.0));
        numValues.put("CGT", getMultipleValueList(4.0));
        numValues.put("CCT", getMultipleValueList(-3.0));
        numValues.put("CCT", getMultipleValueList(-4.0));
        numValues.put("CTT", getMultipleValueList(3.0));
        numValues.put("CTT", getMultipleValueList(-4.0));
        numValues.put("TAC", getMultipleValueList(4.0));
        numValues.put("TAC", getMultipleValueList(3.0));
        numValues.put("TGC", getMultipleValueList(-4.0));
        numValues.put("TGC", getMultipleValueList(3.0));
        numValues.put("TCC", getMultipleValueList(-4.0));
        numValues.put("TCC", getMultipleValueList(-3.0));
        numValues.put("TTC", getMultipleValueList(4.0));
        numValues.put("TTC", getMultipleValueList(-3.0));
        numValues.put("GAC", getMultipleValueList(2.0));
        numValues.put("GAC", getMultipleValueList(3.0));
        numValues.put("GGC", getMultipleValueList(-2.0));
        numValues.put("GGC", getMultipleValueList(3.0));
        numValues.put("GCC", getMultipleValueList(-2.0));
        numValues.put("GCC", getMultipleValueList(-3.0));
        numValues.put("GTC", getMultipleValueList(2.0));
        numValues.put("GTC", getMultipleValueList(-3.0));
        numValues.put("CAG", getMultipleValueList(3.0));
        numValues.put("CAG", getMultipleValueList(2.0));
        numValues.put("CGG", getMultipleValueList(-3.0));
        numValues.put("CGG", getMultipleValueList(2.0));
        numValues.put("CCG", getMultipleValueList(-3.0));
        numValues.put("CCG", getMultipleValueList(-2.0));
        numValues.put("CTG", getMultipleValueList(3.0));
        numValues.put("CTG", getMultipleValueList(-2.0));
        numValues.put("AAT", getMultipleValueList(1.0));
        numValues.put("AAT", getMultipleValueList(4.0));
        numValues.put("AGT", getMultipleValueList(-1.0));
        numValues.put("AGT", getMultipleValueList(4.0));
        numValues.put("ACT", getMultipleValueList(-1.0));
        numValues.put("ACT", getMultipleValueList(-4.0));
        numValues.put("ATT", getMultipleValueList(1.0));
        numValues.put("ATT", getMultipleValueList(-4.0));
        numValues.put("TAA", getMultipleValueList(4.0));
        numValues.put("TAA", getMultipleValueList(1.0));
        numValues.put("TGA", getMultipleValueList(-4.0));
        numValues.put("TGA", getMultipleValueList(1.0));
        numValues.put("TCA", getMultipleValueList(-4.0));
        numValues.put("TCA", getMultipleValueList(-1.0));
        numValues.put("TTA", getMultipleValueList(4.0));
        numValues.put("TTA", getMultipleValueList(-1.0));
        numValues.put("AAC", getMultipleValueList(1.0));
        numValues.put("AAC", getMultipleValueList(3.0));
        numValues.put("AGC", getMultipleValueList(-1.0));
        numValues.put("AGC", getMultipleValueList(3.0));
        numValues.put("ACC", getMultipleValueList(-1.0));
        numValues.put("ACC", getMultipleValueList(-3.0));
        numValues.put("ATC", getMultipleValueList(1.0));
        numValues.put("ATC", getMultipleValueList(-3.0));
        numValues.put("CAA", getMultipleValueList(3.0));
        numValues.put("CAA", getMultipleValueList(1.0));
        numValues.put("CGA", getMultipleValueList(-3.0));
        numValues.put("CGA", getMultipleValueList(1.0));
        numValues.put("CCA", getMultipleValueList(-3.0));
        numValues.put("CCA", getMultipleValueList(-1.0));
        numValues.put("CTA", getMultipleValueList(3.0));
        numValues.put("CTA", getMultipleValueList(-1.0));
        numValues.put("GAT", getMultipleValueList(2.0));
        numValues.put("GAT", getMultipleValueList(4.0));
        numValues.put("GGT", getMultipleValueList(-2.0));
        numValues.put("GGT", getMultipleValueList(4.0));
        numValues.put("GCT", getMultipleValueList(-2.0));
        numValues.put("GCT", getMultipleValueList(-4.0));
        numValues.put("GTT", getMultipleValueList(2.0));
        numValues.put("GTT", getMultipleValueList(-4.0));
        numValues.put("TAG", getMultipleValueList(4.0));
        numValues.put("TAG", getMultipleValueList(2.0));
        numValues.put("TGG", getMultipleValueList(-4.0));
        numValues.put("TGG", getMultipleValueList(2.0));
        numValues.put("TCG", getMultipleValueList(-4.0));
        numValues.put("TCG", getMultipleValueList(-2.0));
        numValues.put("TTG", getMultipleValueList(4.0));
        numValues.put("TTG", getMultipleValueList(-2.0));
    }

    @Override
    public void calculateVectorDimensions() {
        
        
        int count = 1;
        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name - trinucleotides
            int sDimensionName = (iSymbolCnt+1)+(iSymbolCnt +2)+(iSymbolCnt + 3)+(count);
            //To match the keys in the numValues map
            String key = (sequence.getSymbolAt(iSymbolCnt)+sequence.getSymbolAt(iSymbolCnt+1)+sequence.getSymbolAt(iSymbolCnt+2));
            // Assign the corresponding value from the numValues key to the feature
            put(sDimensionName, numValues.get(key));
            xValues.add(numValues.get(key).get(0));
            yValues.add(numValues.get(key).get(1));
            count++;
        }
    
        int initialValue0fx = 0;
        int initialValue0fy = 0;
        
        for(int i=0; i<xValues.size(); i++){
            for (int j=0; j<yValues.size(); j++){
               initialValue0fx+=xValues.get(i);
               initialValue0fy+=yValues.get(j);
            }
        }

        meanX=initialValue0fx/xValues.size();
        meanY=initialValue0fy/yValues.size();
        xValues.add(meanX);
        yValues.add(meanY);
        
    }
 
    
    public static void TNCurveRepresentation(FileWriter outputFile, String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        TNcurve TNCurveRepr = new TNcurve(inputSeq);

        TNCurveRepr.assignValues();
        TNCurveRepr.calculateVectorDimensions();
       
        outputFile.write(TNCurveRepr.xValues.toString());
        outputFile.write(TNCurveRepr.yValues.toString());
        
        
    }
    
    
}
