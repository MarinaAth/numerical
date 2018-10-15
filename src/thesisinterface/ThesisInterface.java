/*
 * To change this license fastaHeader, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import thesisinterface.VectorRepresentation.BaseClasses.BaseFeatureVector;
import thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation.atomicNumberRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.ElectronIonRepresentation.electronIonRepresentation;

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

    public static void main(String[] args) throws IOException {

        //BaseFeatureVector electronRepr = new BaseFeatureVector();
        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison1\\HumanExonsSurrogates.fas");

        File outputElectronReprFile = new File(
                "D:\\Marina\\Documents\\MSc DataSets\\Electron Ion Representation\\Comparison1\\HumanExonsSurrogates.txt");
        File outputSparseElectronFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Electron Ion Representation\\Comparison1\\HumanExonsSurrogates_Sparce.txt");

        int max = 0;
        int numOfAttributes;

        //create a representation file
        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputFile1 = new FileWriter(outputElectronReprFile)) {

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

        //create the sparse representation file
        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputSparseFile1 = new FileWriter(outputSparseElectronFile)) {

            //establish counter to be used for checking
            int counter = 3101;
            while (readDataFile.hasNextLine()) {

                String input = readDataFile.nextLine();
                BaseFeatureVector electronRepr;
                
                if (input.matches(fastaHeader.pattern())) {
                    outputSparseFile1.write(input + System.lineSeparator());
                } else {
                    electronRepr = electronIonRepresentation(input);
                    int initialDimensions = electronRepr.getNumberOfDimensions();
                    outputSparseFile1.write(electronRepr.toString());
                    
                    if (initialDimensions < max) {
                        int diff = max - initialDimensions;
                        mergeVectors(electronRepr, diff);
                        
                        int finalnumber = initialDimensions + electronRepr.getNumberOfDimensions();
                        if (finalnumber < max) {
                            System.out.println("Warning, you have less dimensions than needed on line " + (((counter - 3101) / 2) + 3101));
                        } else if(finalnumber > max){
                            System.out.println("Warning, more dimensions than needed on line " + (((counter - 3101) / 2) + 3101));
                        }
                        outputSparseFile1.write(", " + electronRepr.toString() + System.lineSeparator());
                    }
                }
                counter++;
            }
        }
        createArffFile pleaseWorkProperly = new createArffFile();
        pleaseWorkProperly.convertToArffFile(outputSparseElectronFile, max);
    }

    // class for creation of ARFF file - readable by WEKA
    public static class createArffFile {

        private Scanner representationToConvert;

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
    }

    public static void mergeVectors(BaseFeatureVector representation, int difference){
        List<Double> addedDimensions = new LinkedList<>();
        addedDimensions.add(0.0);
        BaseFeatureVector sparseVector = new BaseFeatureVector();
        
        for (int iSymbolCnt = representation.getNumberOfDimensions()+1; iSymbolCnt<=difference; iSymbolCnt++){
            sparseVector.put(iSymbolCnt, addedDimensions);
        }
        
        representation.putAll(sparseVector);
    }
}
