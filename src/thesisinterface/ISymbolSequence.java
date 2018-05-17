/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.Map;

/**
 * This interface represents an input sequence of symbols.
 * @author marin
 */
public interface ISymbolSequence {
    
    /**
     * Returns an additional information object, containing meta-data
     * related to the sequence.
     * @return The addition information Object.
     */
    Object getExtendedInfo();
 
    /**
     * Returns the symbol at the specific index position if the sequence.
     * @param index 
     */
    public String getSymbolAt(int index); 
    
    /**
     * Returns a string representation of the sequence.
     * @return The string representation.
     */
    String asString();
     
    /**
     * Returns the size of the sequence.
     * @return The size calculated.
     */
    public int size();
}
