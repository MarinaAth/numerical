/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marin
 */
public class BaseFeatureVector extends TreeMap<String, Double> implements IFeatureVector {

    @Override
    public List<String> getDimensionNames() {
        return new ArrayList<>(this.keySet());
    }

    @Override
    public int getNumberOfDimensions() {
        return this.keySet().size();
    }

    @Override
    public Double getDimensionValue(String dimensionName) {
        return get(dimensionName);
    }
    
}
