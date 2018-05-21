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
public class ElectronIonRepresentation extends KeyBasedRepresentation {

    public ElectronIonRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", 0.0806);
        numValues.put("A", 0.1260);
        numValues.put("C", 0.1340);
        numValues.put("T", 0.1335);
    }
    
    
}
