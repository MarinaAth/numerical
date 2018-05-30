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
 * This class is a representation, taking into account the atomic number.
 * @author marin
 */
public class AtomicNumberRepresentation extends SingleValueRepresentation {

    public AtomicNumberRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }
    
    @Override
    public void assignValues() {
       numValues.put("G", 78.0);
       numValues.put("A", 70.0);
       numValues.put("C", 58.0);
       numValues.put("T", 60.0);
    }
}