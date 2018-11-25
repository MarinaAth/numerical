/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import weka.core.*;
import java.io.*;
import java.util.*;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;

/**
 *
 * @author marin
 */
public class AddAttribute {

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.out.println("\nUsage: AddAttribute <file.arff> <filter|java> <class_type>\n");
            System.exit(1);
        }

        
        // load dataset
        Instances data = new Instances(new BufferedReader(new FileReader(args[0])));
        Instances newData = null;
        Attribute classAttr = null;

        switch (args[1]) {
            case "filter":
                Add filter;
                // 1. nominal attribute
                filter = new Add();
                filter.setAttributeIndex("last");
                filter.setNominalLabels(args[2]);
                filter.setAttributeName("Organism");
                filter.setInputFormat(data);
                newData = Filter.useFilter(data, filter);
                for (int i=0; i<newData.numInstances();i++){
                    newData.instance(i).setValue(newData.numAttributes()-1,args[2]);
                }
                newData.setClassIndex(newData.numAttributes()-1);
// 2. numeric attribute
//        filter = new Add();
//        filter.setAttributeIndex("last");
//        filter.setAttributeName("NewNumeric");
//        filter.setInputFormat(newData);
//        newData = Filter.useFilter(newData, filter);
                break;

            case "java":
                newData = new Instances(data);
                // create a nominal attribute and make it the class
                List<String> nominalValues = new ArrayList<>();
                nominalValues.add(args[2]);
                //nominalValues.add(args[3]);
                classAttr = new Attribute("Organism", nominalValues);
                newData.insertAttributeAt(classAttr, newData.numAttributes());
                for (int i = newData.numInstances() - 1; i >= 0; i--) {
                    newData.instance(i).setValue(classAttr, args[2]);
                }
                newData.setClassIndex(newData.numAttributes() - 1);
                
//        2. numeric
//        newData.insertAttributeAt(new Attribute("NewNumeric"), newData.numAttributes());
                break;
            default:
                System.out.println("\nUsage: AddAttribute <file.arff> <filter|java>\n");
                System.exit(2);
        }

         try {
            ArffSaver saver = new ArffSaver();
            saver.setInstances(newData);
            saver.setFile(new File(args[3]));
            saver.writeBatch();
        } catch(Exception e) {
    }

    }
}
