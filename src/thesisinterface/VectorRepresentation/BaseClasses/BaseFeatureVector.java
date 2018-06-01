/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.BaseClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import thesisinterface.VectorRepresentation.IFeatureVector;

/**
 *
 * @author marin
 */
public class BaseFeatureVector extends TreeMap<String, List<Double>> implements IFeatureVector {

    @Override
    public List<String> getDimensionNames() {
        return new ArrayList<>(this.keySet());
    }

    @Override
    public int getNumberOfDimensions() {
        return this.keySet().size();
    }

    @Override
    public List<Double> getDimensionValue(String dimensionName) {
        return get(dimensionName);
    }
    
}
