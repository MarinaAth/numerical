/*
 * To change this license fastaHeader, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.Timestamp;
import java.util.*;
import java.util.function.IntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import thesisinterface.VectorRepresentation.BaseClasses.BaseFeatureVector;
import static thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation.atomicNumberRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.ElectronIonRepresentation.electronIonRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.IntegerRepresentation.integerRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.PairedNumeric.pairedNumericRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.RealNumberRepresentation.realNumberRepresentation;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;

/**
 *
 * @author marina Process: 1)create instances of each class of representation
 * 2)run through the data file once to create the representation and find the
 * number of attributes that will be declared in the arff file 3)create the arff
 * file by declaring the number of attributes found before, running through the
 * representation file and constructing a file that WEKA can read
 */
public class ThesisInterface {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    private static final Pattern fastaHeader = Pattern.compile("^>.*");

    public static File outputSparseFile;

    public static void main(String[] args) throws IOException {

//        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison5c\\Amniotic.fas");
//
//        File directory = new File ("D:\\Marina\\Documents\\MSc DataSets\\Fasta Files");
//       
        //open folder of fasta datasets 
        try (Stream<Path> paths = Files.walk(Paths.get("D:/Marina/Documents/MSc DataSets/Fasta Files"))) {

            //create a list of the directories of all subfolders and files contained
            List<String> pathList = paths.map(p -> {
                if (Files.isDirectory(p)) {
                    return "/" + p.toString();
                }
                return p.toString();
            })
                    .peek(System.out::println) // write all results in console for debug
                    .collect(Collectors.toList());

            //run the list of directories
            for (int i = 0; i < pathList.size(); i++) {

                //ignore all items of list that are not fasta files
                if (!pathList.get(i).endsWith(".fas")) {
                } else {
                    File toReadFile = new File(pathList.get(i));
                    System.out.println(pathList.get(i));
                    //create file for specific type of representation a
                    outputSparseFile = new File(pathList.get(i).replace("Fasta Files", "/IntegerNumber"));
                    System.out.println(outputSparseFile.toString());

                    //create sparse representation
                    makeSparse(toReadFile.getPath());
                    if (true) {
                    }
                }
            }

        }
    }

    // Nikiforos method
    //to create the sparse ARFF representation file
    public static void makeSparse(String fasPath) {
        IOHandler io = new IOHandler();
        int maxDim = -1;
        try {
            // read fas
            ArrayList<String> contents = io.readFAS(fasPath);

            // find max vector dimension
            for (String line : contents) {
                if (line.length() > maxDim) {
                    maxDim = line.length();
                }
            }
            // create the sparse vector
            ArrayList<BaseFeatureVector> data = new ArrayList<>();
            // for each base sequence
            for (String line : contents) {
                // get atomic repr
                BaseFeatureVector representation = integerRepresentation(line);
                // pad with zeros
                representation.sparsify(maxDim);
                // add to list
                data.add(representation);
            }
            // convert to weka instances
            Instances instances = toWekaInstances(data);
            // write arff file
            io.writeARFF(outputSparseFile + ".arff", instances);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // convert data to WEKA instances
    public static Instances toWekaInstances(ArrayList<BaseFeatureVector> data) {
        ArrayList<Attribute> attributeList = new ArrayList();
        int maxDim = data.get(0).size();
        for (int i = 0; i < maxDim; ++i) {
            Attribute att = new Attribute("attribute" + (i + 1), false);
            attributeList.add(att);
        }
        Instances instances = new Instances("data", attributeList, data.size());

        for (int v = 0; v < data.size(); ++v) {
            BaseFeatureVector vec = data.get(v);
            Instance instance = new SparseInstance(attributeList.size());
            for (int i = 0; i < attributeList.size(); ++i) {
                List<Double> dlist = vec.get(i);
                double val = dlist.get(0);
                instance.setValue(attributeList.get(i), val);
            }
            instances.add(instance);
        }
        return instances;
    }

}
