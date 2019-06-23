/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiValue;

import java.awt.RenderingHints;
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
public class TNcurve extends MultipleValueRepresentation {

    public TNcurve(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {

        numValues.put("AAA", getMultipleValueList(1.0));
        numValues.get("AAA").addAll(getMultipleValueList(1.0));
        numValues.get("AAA").addAll(getMultipleValueList(0.0));
        numValues.put("AGA", getMultipleValueList(-1.0));
        numValues.get("AGA").addAll(getMultipleValueList(1.0));
        numValues.get("AGA").addAll(getMultipleValueList(0.0));
        numValues.put("ACA", getMultipleValueList(-1.0));
        numValues.get("ACA").addAll(getMultipleValueList(-1.0));
        numValues.get("ACA").addAll(getMultipleValueList(0.0));
        numValues.put("ATA", getMultipleValueList(1.0));
        numValues.get("ATA").addAll(getMultipleValueList(-1.0));
        numValues.get("ATA").addAll(getMultipleValueList(0.0));
        numValues.put("GAG", getMultipleValueList(2.0));
        numValues.get("GAG").addAll(getMultipleValueList(2.0));
        numValues.get("GAG").addAll(getMultipleValueList(0.0));
        numValues.put("GGG", getMultipleValueList(-2.0));
        numValues.get("GGG").addAll(getMultipleValueList(2.0));
        numValues.get("GGG").addAll(getMultipleValueList(0.0));
        numValues.put("GCG", getMultipleValueList(-2.0));
        numValues.get("GCG").addAll(getMultipleValueList(-2.0));
        numValues.get("GCG").addAll(getMultipleValueList(0.0));
        numValues.put("GTG", getMultipleValueList(2.0));
        numValues.get("GTG").addAll(getMultipleValueList(-2.0));
        numValues.get("GTG").addAll(getMultipleValueList(0.0));
        numValues.put("CAC", getMultipleValueList(3.0));
        numValues.get("CAC").addAll(getMultipleValueList(3.0));
        numValues.get("CAC").addAll(getMultipleValueList(0.0));
        numValues.put("CGC", getMultipleValueList(-3.0));
        numValues.get("CGC").addAll(getMultipleValueList(3.0));
        numValues.get("CGC").addAll(getMultipleValueList(0.0));
        numValues.put("CCC", getMultipleValueList(-3.0));
        numValues.get("CCC").addAll(getMultipleValueList(-3.0));
        numValues.get("CCC").addAll(getMultipleValueList(0.0));
        numValues.put("CTC", getMultipleValueList(3.0));
        numValues.get("CTC").addAll(getMultipleValueList(-3.0));
        numValues.get("CTC").addAll(getMultipleValueList(0.0));
        numValues.put("TAT", getMultipleValueList(4.0));
        numValues.get("TAT").addAll(getMultipleValueList(4.0));
        numValues.get("TAT").addAll(getMultipleValueList(0.0));
        numValues.put("TGT", getMultipleValueList(-4.0));
        numValues.get("TGT").addAll(getMultipleValueList(4.0));
        numValues.get("TGT").addAll(getMultipleValueList(0.0));
        numValues.put("TCT", getMultipleValueList(-4.0));
        numValues.get("TCT").addAll(getMultipleValueList(-4.0));
        numValues.get("TCT").addAll(getMultipleValueList(0.0));
        numValues.put("TTT", getMultipleValueList(4.0));
        numValues.get("TTT").addAll(getMultipleValueList(-4.0));
        numValues.get("TTT").addAll(getMultipleValueList(0.0));
        numValues.put("AAG", getMultipleValueList(1.0));
        numValues.get("AAG").addAll(getMultipleValueList(2.0));
        numValues.get("AAG").addAll(getMultipleValueList(0.0));
        numValues.put("AGG", getMultipleValueList(-1.0));
        numValues.get("AGG").addAll(getMultipleValueList(2.0));
        numValues.get("AGG").addAll(getMultipleValueList(0.0));
        numValues.put("ACG", getMultipleValueList(-1.0));
        numValues.get("ACG").addAll(getMultipleValueList(-2.0));
        numValues.get("ACG").addAll(getMultipleValueList(0.0));
        numValues.put("ATG", getMultipleValueList(1.0));
        numValues.get("ATG").addAll(getMultipleValueList(-2.0));
        numValues.get("ATG").addAll(getMultipleValueList(0.0));
        numValues.put("GAA", getMultipleValueList(2.0));
        numValues.get("GAA").addAll(getMultipleValueList(1.0));
        numValues.get("GAA").addAll(getMultipleValueList(0.0));
        numValues.put("GGA", getMultipleValueList(-2.0));
        numValues.get("GGA").addAll(getMultipleValueList(1.0));
        numValues.get("GGA").addAll(getMultipleValueList(0.0));
        numValues.put("GCA", getMultipleValueList(-2.0));
        numValues.get("GCA").addAll(getMultipleValueList(-1.0));
        numValues.get("GCA").addAll(getMultipleValueList(0.0));
        numValues.put("GTA", getMultipleValueList(2.0));
        numValues.get("GTA").addAll(getMultipleValueList(-1.0));
        numValues.get("GTA").addAll(getMultipleValueList(0.0));
        numValues.put("CAT", getMultipleValueList(3.0));
        numValues.get("CAT").addAll(getMultipleValueList(4.0));
        numValues.get("CAT").addAll(getMultipleValueList(0.0));
        numValues.put("CGT", getMultipleValueList(-3.0));
        numValues.get("CGT").addAll(getMultipleValueList(4.0));
        numValues.get("CGT").addAll(getMultipleValueList(0.0));
        numValues.put("CCT", getMultipleValueList(-3.0));
        numValues.get("CCT").addAll(getMultipleValueList(-4.0));
        numValues.get("CCT").addAll(getMultipleValueList(0.0));
        numValues.put("CTT", getMultipleValueList(3.0));
        numValues.get("CTT").addAll(getMultipleValueList(-4.0));
        numValues.get("CTT").addAll(getMultipleValueList(0.0));
        numValues.put("TAC", getMultipleValueList(4.0));
        numValues.get("TAC").addAll(getMultipleValueList(3.0));
        numValues.get("TAC").addAll(getMultipleValueList(0.0));
        numValues.put("TGC", getMultipleValueList(-4.0));
        numValues.get("TGC").addAll(getMultipleValueList(3.0));
        numValues.get("TGC").addAll(getMultipleValueList(0.0));
        numValues.put("TCC", getMultipleValueList(-4.0));
        numValues.get("TCC").addAll(getMultipleValueList(-3.0));
        numValues.get("TCC").addAll(getMultipleValueList(0.0));
        numValues.put("TTC", getMultipleValueList(4.0));
        numValues.get("TTC").addAll(getMultipleValueList(-3.0));
        numValues.get("TTC").addAll(getMultipleValueList(0.0));
        numValues.put("GAC", getMultipleValueList(2.0));
        numValues.get("GAC").addAll(getMultipleValueList(3.0));
        numValues.get("GAC").addAll(getMultipleValueList(0.0));
        numValues.put("GGC", getMultipleValueList(-2.0));
        numValues.get("GGC").addAll(getMultipleValueList(3.0));
        numValues.get("GGC").addAll(getMultipleValueList(0.0));
        numValues.put("GCC", getMultipleValueList(-2.0));
        numValues.get("GCC").addAll(getMultipleValueList(-3.0));
        numValues.get("GCC").addAll(getMultipleValueList(0.0));
        numValues.put("GTC", getMultipleValueList(2.0));
        numValues.get("GTC").addAll(getMultipleValueList(-3.0));
        numValues.get("GTC").addAll(getMultipleValueList(0.0));
        numValues.put("CAG", getMultipleValueList(3.0));
        numValues.get("CAG").addAll(getMultipleValueList(2.0));
        numValues.get("CAG").addAll(getMultipleValueList(0.0));
        numValues.put("CGG", getMultipleValueList(-3.0));
        numValues.get("CGG").addAll(getMultipleValueList(2.0));
        numValues.get("CGG").addAll(getMultipleValueList(0.0));
        numValues.put("CCG", getMultipleValueList(-3.0));
        numValues.get("CCG").addAll(getMultipleValueList(-2.0));
        numValues.get("CCG").addAll(getMultipleValueList(0.0));
        numValues.put("CTG", getMultipleValueList(3.0));
        numValues.get("CTG").addAll(getMultipleValueList(-2.0));
        numValues.get("CTG").addAll(getMultipleValueList(0.0));
        numValues.put("AAT", getMultipleValueList(1.0));
        numValues.get("AAT").addAll(getMultipleValueList(4.0));
        numValues.get("AAT").addAll(getMultipleValueList(0.0));
        numValues.put("AGT", getMultipleValueList(-1.0));
        numValues.get("AGT").addAll(getMultipleValueList(4.0));
        numValues.get("AGT").addAll(getMultipleValueList(0.0));
        numValues.put("ACT", getMultipleValueList(-1.0));
        numValues.get("ACT").addAll(getMultipleValueList(-4.0));
        numValues.get("ACT").addAll(getMultipleValueList(0.0));
        numValues.put("ATT", getMultipleValueList(1.0));
        numValues.get("ATT").addAll(getMultipleValueList(-4.0));
        numValues.get("ATT").addAll(getMultipleValueList(0.0));
        numValues.put("TAA", getMultipleValueList(4.0));
        numValues.get("TAA").addAll(getMultipleValueList(1.0));
        numValues.get("TAA").addAll(getMultipleValueList(0.0));
        numValues.put("TGA", getMultipleValueList(-4.0));
        numValues.get("TGA").addAll(getMultipleValueList(1.0));
        numValues.get("TGA").addAll(getMultipleValueList(0.0));
        numValues.put("TCA", getMultipleValueList(-4.0));
        numValues.get("TCA").addAll(getMultipleValueList(-1.0));
        numValues.get("TCA").addAll(getMultipleValueList(0.0));
        numValues.put("TTA", getMultipleValueList(4.0));
        numValues.get("TTA").addAll(getMultipleValueList(-1.0));
        numValues.get("TTA").addAll(getMultipleValueList(0.0));
        numValues.put("AAC", getMultipleValueList(1.0));
        numValues.get("AAC").addAll(getMultipleValueList(3.0));
        numValues.get("AAC").addAll(getMultipleValueList(0.0));
        numValues.put("AGC", getMultipleValueList(-1.0));
        numValues.get("AGC").addAll(getMultipleValueList(3.0));
        numValues.get("AGC").addAll(getMultipleValueList(0.0));
        numValues.put("ACC", getMultipleValueList(-1.0));
        numValues.get("ACC").addAll(getMultipleValueList(-3.0));
        numValues.get("ACC").addAll(getMultipleValueList(0.0));
        numValues.put("ATC", getMultipleValueList(1.0));
        numValues.get("ATC").addAll(getMultipleValueList(-3.0));
        numValues.get("ATC").addAll(getMultipleValueList(0.0));
        numValues.put("CAA", getMultipleValueList(3.0));
        numValues.get("CAA").addAll(getMultipleValueList(1.0));
        numValues.get("CAA").addAll(getMultipleValueList(0.0));
        numValues.put("CGA", getMultipleValueList(-3.0));
        numValues.get("CGA").addAll(getMultipleValueList(1.0));
        numValues.get("CGA").addAll(getMultipleValueList(0.0));
        numValues.put("CCA", getMultipleValueList(-3.0));
        numValues.get("CCA").addAll(getMultipleValueList(-1.0));
        numValues.get("CCA").addAll(getMultipleValueList(0.0));
        numValues.put("CTA", getMultipleValueList(3.0));
        numValues.get("CTA").addAll(getMultipleValueList(-1.0));
        numValues.get("CTA").addAll(getMultipleValueList(0.0));
        numValues.put("GAT", getMultipleValueList(2.0));
        numValues.get("GAT").addAll(getMultipleValueList(4.0));
        numValues.get("GAT").addAll(getMultipleValueList(0.0));
        numValues.put("GGT", getMultipleValueList(-2.0));
        numValues.get("GGT").addAll(getMultipleValueList(4.0));
        numValues.get("GGT").addAll(getMultipleValueList(0.0));
        numValues.put("GCT", getMultipleValueList(-2.0));
        numValues.get("GCT").addAll(getMultipleValueList(-4.0));
        numValues.get("GCT").addAll(getMultipleValueList(0.0));
        numValues.put("GTT", getMultipleValueList(2.0));
        numValues.get("GTT").addAll(getMultipleValueList(-4.0));
        numValues.get("GTT").addAll(getMultipleValueList(0.0));
        numValues.put("TAG", getMultipleValueList(4.0));
        numValues.get("TAG").addAll(getMultipleValueList(2.0));
        numValues.get("TAG").addAll(getMultipleValueList(0.0));
        numValues.put("TGG", getMultipleValueList(-4.0));
        numValues.get("TGG").addAll(getMultipleValueList(2.0));
        numValues.get("TGG").addAll(getMultipleValueList(0.0));
        numValues.put("TCG", getMultipleValueList(-4.0));
        numValues.get("TCG").addAll(getMultipleValueList(-2.0));
        numValues.get("TCG").addAll(getMultipleValueList(0.0));
        numValues.put("TTG", getMultipleValueList(4.0));
        numValues.get("TTG").addAll(getMultipleValueList(-2.0));
        numValues.get("TTG").addAll(getMultipleValueList(0.0));
    }

    @Override
    public void calculateVectorDimensions() {
        double count = 1.0;

        List<Double> paddList = new ArrayList<>();
        paddList.add(0.0);
        paddList.add(0.0);
        paddList.add(0.0);

        // For each symbol in sequence
        for (int iSymbolCnt = 0; iSymbolCnt < sequence.size(); iSymbolCnt++) {
            // Determine dimension name - trinucleotides
            int sDimensionName = iSymbolCnt + 1;

            //Check if there are enough nucleotides left in the sequence for a triplet
            int i = sequence.size()-2;
            if (iSymbolCnt >= i) {
                
                put(sDimensionName, paddList);

            } else {

                String key = (sequence.getSymbolAt(iSymbolCnt) + sequence.getSymbolAt(iSymbolCnt + 1) + sequence.getSymbolAt(iSymbolCnt + 2));

                if (key.contains("N")) {

                    List <Double> nFill = new ArrayList<>();
                    nFill.add(0.0);
                    nFill.add(0.0);
                    nFill.add(count);
                    put(sDimensionName, nFill);
                    
                    
                } else {

                    assignValues();
                    numValues.get(key).set(2, count);

                    // Assign the corresponding value from the numValues key to the feature
                    put(sDimensionName, numValues.get(key));

                }

                count += 1.0;
            }
        }
    }

    public static MultipleValueRepresentation TNCurveRepresentation(String inputSequence) throws IOException {

        BaseSymbolSequence inputSeq = new BaseSymbolSequence(inputSequence);
        //TreeMap
        TNcurve TNCurveRepr = new TNcurve(inputSeq);

        TNCurveRepr.calculateVectorDimensions();

        return TNCurveRepr;

    }

//    public static void main(String[] args) throws IOException {
//        String seq = "ATAATAGCTNNTTGTANCTGTCTTTACGTA";
//
//        System.out.println(TNCurveRepresentation(seq));
//    }

}
