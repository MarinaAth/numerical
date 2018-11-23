/*
 * To change this license fastaHeader, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;
import java.io.*; 

import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Pattern;
import thesisinterface.VectorRepresentation.BaseClasses.BaseFeatureVector;
import static thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation.atomicNumberRepresentation;


import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;


/**
 *
 * @author marina 
 * Process: 1)create instances of each class of representation
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

    public static File outputSparseAtomicFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Atomic Number Representation\\Comparison1\\HumanExonsSurrogates.fas");
    
    public static void main(String[] args) throws IOException {
        
        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison1\\HumanExonsSurrogates.fas");

        
        File outputAtomicReprFile = new File(
                "D:\\Marina\\Documents\\MSc DataSets\\Atomic Number Representation\\Comparison3\\HumanExonsSurrogates.fas");
        


        // Nikiforos
        makeSparse(toReadFile.getPath());
        if (true) return;


//        create a representation file
        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputFile1 = new FileWriter(outputAtomicReprFile)) {

            while (readDataFile.hasNextLine()) {

            	
                String input = readDataFile.nextLine();

                if (input.matches(fastaHeader.pattern())) {
                    outputFile1.write(input + "\n");
                } else {
                    BaseFeatureVector atomicNumRepr = atomicNumberRepresentation(input);
                    outputFile1.write(atomicNumRepr.toString() + System.lineSeparator());
                }
            }
        }
}


    // Nikiforos method
    //to create the sparse ARFF representation file
    public static void makeSparse(String fasPath){
        IOHandler io = new IOHandler();
        int maxDim = -1;
        try{
            // read fas
            ArrayList<String> contents = io.readFAS(fasPath);

            
            // find max vector dimension
            for(String line: contents){
                if (line.length() > maxDim) maxDim = line.length();
            }
            // create the sparse vector
            ArrayList<BaseFeatureVector> data = new ArrayList<>();
            // for each base sequence
            for (String line : contents) {
                // get atomic repr
                BaseFeatureVector atomicNumRepr = atomicNumberRepresentation(line);
                // pad with zeros
                atomicNumRepr.sparsify(maxDim);
                // add to list
                data.add(atomicNumRepr);
            }
            // convert to weka instances
            Instances instances = toWekaInstances(data);
            // write arff file
            io.writeARFF(outputSparseAtomicFile + ".arff", instances);
          
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // convert data to WEKA instances
    public static Instances toWekaInstances(ArrayList<BaseFeatureVector> data){
        ArrayList<Attribute> attributeList = new ArrayList();
        int maxDim = data.get(0).size();
        for (int i = 0; i < maxDim; ++i) {
            Attribute att = new Attribute("attribute" + (i + 1), false);
            attributeList.add(att);
        }
        Instances instances = new Instances("data", attributeList, data.size() );

        for (int v=0; v<data.size(); ++v) {
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