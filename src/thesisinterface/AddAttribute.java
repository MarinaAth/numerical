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
        if (args.length != 5) {
            System.out.println("\nUsage: AddAttribute <file.arff> <filter|java> <class_type>\n");
            System.exit(1);
        }

        // load dataset
        Instances data1 = new Instances(new BufferedReader(new FileReader(args[0])));
        Instances data2 = new Instances(new BufferedReader(new FileReader(args[1])));
        Instances newData1 = null;
        Instances newData2 = null;

        Attribute classAttr = null;

        if (data1.numAttributes() != data2.numAttributes()) {
            paddingDatasets(data1, data2);
        }
        switch (args[2]) {
            case "filter":
                Add filter;
                // 1. nominal attribute
                filter = new Add();
                filter.setAttributeIndex("last");
                filter.setNominalLabels(args[3] + ", " + args[4]);
                filter.setAttributeName("Organism");
                filter.setInputFormat(data1);
                newData1 = Filter.useFilter(data1, filter);
                newData2 = Filter.useFilter(data2, filter);

                for (int i = newData1.numInstances() - 1; i >= 0; i--) {
                    newData1.instance(i).setValue(newData1.numAttributes() - 1, args[3]);
                }
                for (int j = newData2.numInstances() - 1; j >= 0; j--) {
                    newData2.instance(j).setValue(newData2.numAttributes() - 1, args[4]);
                }

                newData1.setClassIndex(newData1.numAttributes() - 1);
                newData2.setClassIndex(newData2.numAttributes() - 1);
// 2. numeric attribute
//        filter = new Add();
//        filter.setAttributeIndex("last");
//        filter.setAttributeName("NewNumeric");
//        filter.setInputFormat(newData1);
//        newData1 = Filter.useFilter(newData1, filter);
                break;

            case "java":
                newData1 = new Instances(data1);
                newData2 = new Instances(data2);
                // create a nominal attribute and make it the class
                List<String> nominalValues = new ArrayList<>();
                nominalValues.add(args[3]);
                nominalValues.add(args[4]);
                //nominalValues.add(args[3]);
                classAttr = new Attribute("Organism", nominalValues);
                newData1.insertAttributeAt(classAttr, newData1.numAttributes());
                newData2.insertAttributeAt(classAttr, newData2.numAttributes());
                for (int i = 0; i < newData1.numAttributes(); i++) {
                    newData1.instance(i).setValue(classAttr, args[3]);
                }
                for (int j = 0; j < newData2.numAttributes(); j++) {

                    newData2.instance(j).setValue(classAttr, args[4]);

                }
                newData1.setClassIndex(newData1.numAttributes() - 1);
                newData2.setClassIndex(newData2.numAttributes() - 1);

//        2. numeric
//        newData1.insertAttributeAt(new Attribute("NewNumeric"), newData1.numAttributes());
                break;
            default:
                System.out.println("\nUsage: AddAttribute <file.arff> <filter|java>\n");
                System.exit(2);
        }

        try {
            ArffSaver saver1 = new ArffSaver();
            ArffSaver saver2 = new ArffSaver();
            saver1.setInstances(newData1);
            saver2.setInstances(newData2);
            saver1.setFile(new File(args[0]));
            saver2.setFile(new File(args[1]));
            saver1.writeBatch();
            saver2.writeBatch();
        } catch (IOException e) {
        }

    }

    public static void paddingDatasets(Instances dataset1, Instances dataset2) {
        if (dataset1.numAttributes() < dataset2.numAttributes()) {
            int diff = dataset2.numAttributes() - dataset1.numAttributes();
            int counter = dataset1.numAttributes()+1;
            for (int i = 0; i < diff; i++) {
                dataset1.insertAttributeAt(new Attribute("attribute" + counter), dataset1.numAttributes());
                for (int instCounter = 0; instCounter < dataset1.numInstances(); instCounter++) {
                    dataset1.instance(instCounter).setValue(counter, 0.0);
                    counter++;
                }
            }
        } else {
            int diff = dataset1.numAttributes() - dataset2.numAttributes();
            int counter = dataset2.numAttributes() + 1;
            for (int i = 0; i < diff; i++) {
                dataset2.insertAttributeAt(new Attribute("attribute" + counter), dataset2.numAttributes());
                for (int instCounter = 0; instCounter < dataset1.numInstances(); instCounter++) {
                    dataset1.instance(instCounter).setValue(counter, 0.0);
                    counter++;
                }
            }
        }
    }
}
