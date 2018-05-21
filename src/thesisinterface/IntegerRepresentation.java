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
import sun.net.www.http.KeepAliveCache;

/**
 *
 * @author marin
 */
public class IntegerRepresentation extends KeyBasedRepresentation {

    public IntegerRepresentation(ISymbolSequence sequence) {
        super(sequence);
    }

    @Override
    public void assignValues() {
        numValues.put("G", 3.0);
        numValues.put("A", 2.0);
        numValues.put("C", 1.0);
        numValues.put("T", 0.0);
    }
  
    
    
}
