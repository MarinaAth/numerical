/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marin
 */
public class PairedNumeric extends SingleValueRepresentation {

    public PairedNumeric(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", -1.0);
        numValues.put("C", -1.0);
        numValues.put("A", 1.0);
        numValues.put("T", 1.0);
    }
    
   
    
}
