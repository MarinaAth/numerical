/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import weka.core.*;
import java.io.*;
import java.util.*;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;

/**
 *
 * @author marin
 */
public class AddAttribute {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("\nUsage: AddAttribute <file.arff> <filter|java> <class_type>\n");
            System.exit(1);
        }

        // load dataset
        BufferedWriter sw = new BufferedWriter(new FileWriter(args[0]));

        DataSource data = new DataSource((args[0]));
        Instances newData = null;
        Attribute classAttr = null;

        switch (args[1]) {
            case "filter":
                Add filter;
                newData = data.getDataSet();
                // 1. nominal attribute
                filter = new Add();
                filter.setAttributeIndex("last");
                filter.setNominalLabels(args[2]);
                filter.setAttributeName("Organism");
                filter.setInputFormat(newData);
                newData = Filter.useFilter(newData, filter);
                sw.write(newData.toString());
                // 2. numeric attribute
//        filter = new Add();
//        filter.setAttributeIndex("last");
//        filter.setAttributeName("NewNumeric");
//        filter.setInputFormat(newData);
//        newData = Filter.useFilter(newData, filter);
                break;
            case "java":
                newData = data.getDataSet();
                // create a nominal attribute and make it the class
                List<String> nominalValues = new ArrayList<>();
                nominalValues.add(args[2]);
                classAttr = new Attribute("Organism", nominalValues);
                newData.insertAttributeAt(classAttr, newData.numAttributes());

//        2. numeric
//        newData.insertAttributeAt(new Attribute("NewNumeric"), newData.numAttributes());
                break;
            default:
                System.out.println("\nUsage: AddAttribute <file.arff> <filter|java>\n");
                System.exit(2);
        }

        newData.setClassIndex(newData.numAttributes() - 1);
        System.out.println(newData.classIndex());

        for (int i = 0; i < newData.numInstances(); i++) {
            newData.instance(i).setValue(newData.numAttributes() - 1, args[2]);

        }
        System.out.println(newData.classAttribute().toString());

        sw.write(newData.toString());

    }

}
