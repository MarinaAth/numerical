/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.MultiDimensional;

import thesisinterface.VectorRepresentation.ISymbolSequence;

/**
 *
 * @author marin
 */
public class PNcurve extends MultipleValueRepresentation{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
