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

    public static void main(String[] args) throws IOException {

        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison 1\\HumanExonsSurrogates.fas");

        File outputAtomicReprFile = new File(
                "D:/Marina\\Documents/MSc DataSets\\Atomic Number Representation\\Comparison 1\\HumanExonsSurrogates.fas");
        File outputSparseAtomicFile = new File("D:\\Marina/Documents/MSc DataSets/Atomic Number Representation/Comparison 1/HumanExonsSurrogates_sparse.fas");


        // Nikiforos
        makeSparse(toReadFile.getPath());
        if (true) return;

        int max = 0;
        int numOfAttributes;

        //create a representation file
        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputFile1 = new FileWriter(outputAtomicReprFile)) {

            while (readDataFile.hasNextLine()) {

            	
                String input = readDataFile.nextLine();

                if (input.matches(fastaHeader.pattern())) {
                    outputFile1.write(input + "\n");
                } else {
                    BaseFeatureVector atomicNumRepr = atomicNumberRepresentation(input);

                    //get the maximum number of dimensions to be used as attributes
                    numOfAttributes = atomicNumRepr.getNumberOfDimensions();
                    if (numOfAttributes > max) {
                        max = numOfAttributes;
                    }
                    outputFile1.write(atomicNumRepr.toString() + System.lineSeparator());
                }
            }
        }
        System.out.println(max);
    }

       /* create the sparse representation file
        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputSparseFile1 = new FileWriter(outputSparseElectronFile)) {

            //establish counter to be used for checking
            int counter = 3101;
            while (readDataFile.hasNextLine()) {

                String input = readDataFile.nextLine();
                BaseFeatureVector atomicNumRepr;
                
                //initial creation of the arff file with the representation
                if (input.matches(fastaHeader.pattern())) {
                    outputSparseFile1.write(input + System.lineSeparator());
                } else {
                    atomicNumRepr = atomicNumberRepresentation(input);
                    
                    //counting the dimensions to find out how many dimensions need to be added
                    int initialDimensions = atomicNumRepr.getNumberOfDimensions();
                    outputSparseFile1.write(atomicNumRepr.toString());
                    
                    
                    int diff = max - initialDimensions;
                    if (initialDimensions < max) {
                        mergeVectors(atomicNumRepr, diff);
                        outputSparseFile1.write(", " + atomicNumRepr.toString() + System.lineSeparator());
                        
                        //check and get message if there is an issue with the final number of dimensions of the representation
                        int finalCountOfDimensions = initialDimensions + atomicNumRepr.getNumberOfDimensions();
                        if (finalCountOfDimensions < max) {
                            System.out.println("Warning, you have less dimensions than needed on line " + (((counter - 3101) / 2) + 3101));
                        } else if(finalCountOfDimensions > max){
                            System.out.println("Warning, more dimensions than needed on line " + (((counter - 3101) / 2) + 3101));
                        }
                    }
                }
                counter++;
            }
        }
        createArffFile pleaseWorkProperly = new createArffFile();
        pleaseWorkProperly.convertToArffFile(outputSparseElectronFile, max);
    }*/



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
            io.writeARFF(fasPath + ".arff", instances);
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

    // class for creation of ARFF file - readable by WEKA
    /*public static class createArffFile {

        private Scanner representationToConvert;

        public void toArff(File infile){
        }
        // create sparse vector using the specific representation
        public void convertToArffFile(File reprOutputFile, int numOfAttributes)
                throws IOException {

            // get timestamp for creation of file
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            Date date = new Date(ts.getTime());

            // get the name of the file to be used later
            String fileName = reprOutputFile.getName();

            // start the creation of an arff file
            try (FileWriter outputArffFile = new FileWriter(reprOutputFile.getCanonicalPath().replace(".txt", "") + ".arff")) {

                //comment section w/info of arff file
                outputArffFile.write("%1. Title " + fileName + System.lineSeparator() + "%2. Sources:" + System.lineSeparator() + "%Creator: Marina Athanasouli" + System.lineSeparator()
                        + "%Date:" + date + System.lineSeparator() + "@relation " + fileName.replace(".txt", "") + System.lineSeparator());

                representationToConvert = new Scanner(reprOutputFile);

                // number of attributes = length of longer sequence
                for (int i = 1; i <= numOfAttributes; i++) {
                    outputArffFile.write("@attribute " + i + " Numeric" + System.lineSeparator());
                }
                outputArffFile.write("@data" + System.lineSeparator());

                //read the representation file
                while (representationToConvert.hasNextLine()) {
                    String writable = representationToConvert.nextLine();

                    //if it matches the fasta header, ignore
                    if (writable.matches(fastaHeader.toString())) {
                    } else {
                        //transfer only the values w/o []
                        outputArffFile.write(writable.replace("[", "").replace("]", ""));
                        outputArffFile.write(System.lineSeparator());
                    }
                }
            }
            System.out.println("Closing Arff File.");
        }
    }*/

    //create an empty vector to merge with the representation in order to create a sparse vector (sort of)
    public static void mergeVectors(BaseFeatureVector representation, int difference){
        List<Double> addedDimensions = new LinkedList<>();
        addedDimensions.add(0.0);
        BaseFeatureVector sparseVector = new BaseFeatureVector();
        
        for (int iSymbolCnt = representation.getNumberOfDimensions()+1; iSymbolCnt<=difference; iSymbolCnt++){
            int sDimensionName = iSymbolCnt;
            sparseVector.put(sDimensionName, addedDimensions);
        }
        
        representation.putAll(sparseVector);
    }
}