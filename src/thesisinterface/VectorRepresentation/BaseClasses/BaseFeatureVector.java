/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.BaseClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import thesisinterface.VectorRepresentation.IFeatureVector;
import thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation;
import thesisinterface.VectorRepresentation.OneDimensional.SingleValueRepresentation;

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
