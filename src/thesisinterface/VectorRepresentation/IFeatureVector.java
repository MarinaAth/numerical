/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation;

import java.util.List;

/**
 *This interface represents the output vector of a given input sequence.
 * @author marin
 */
public interface IFeatureVector {
    
    List<String> getDimensionNames();
    
    int getNumberOfDimensions(); 
    
    List<Double> getDimensionValue(String dimensionName);
}
