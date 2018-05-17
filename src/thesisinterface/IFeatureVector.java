/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.List;

/**
 *
 * @author marin
 */
public interface IFeatureVector {
    List<String> getDimensionNames();
    int getNumberOfDimensions(); 
    Double getDimensionValue(String dimensionName);
}
