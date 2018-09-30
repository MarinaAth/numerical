/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import static thesisinterface.VectorRepresentation.MultiDimensional.Tetrahedron.tetrahedronRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation.atomicNumberRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.ElectronIonRepresentation.electronIonRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.IntegerRepresentation.integerNumberRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.PairedNumeric.pairedNumericRepresentation;
import static thesisinterface.VectorRepresentation.OneDimensional.RealNumberRepresentation.realNumberRepresentation;
import static thesisinterface.VectorRepresentation.MultiDimensional.TNcurve.TNCurveRepresentation;

/**
 *
 * @author marina
 */
public class ThesisInterface {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    private static final Pattern header = Pattern.compile("^>.*");

    public static void main(String[] args) throws IOException {

        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison1\\HumanExonsSurrogates.fas");

        File outputAtomicReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Atomic Number Representation\\Comparison1\\HumanExonsSurrogates.txt");
//        File outputElectronReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Electron Ion Representation\\Comparison1\\HumanExonsSurrogates.txt");
//        File outputPairedReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Paired Numeric Representation\\Comparison1\\HumanExonsSurrogates.txt");
//        File outputIntegerReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Integer Number Representation\\Comparison1\\HumanExonsSurrogates.txt");
//        File outputRealReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Real Number Representation\\Comparison1\\HumanExonsSurrogates.txt");
//        File outputTetrahedronReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Tetrahedron Representation\\Comparison1\\HumanExonsSurrogates.txt");
//        File outputTNCurveReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\TNCurve Representation\\Comparison1\\HumanExonsSurrogates.txt");

        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputFile1 = new FileWriter(outputAtomicReprFile)) {
//                FileWriter outputFile2 = new FileWriter(outputElectronReprFile);
//                FileWriter outputFile3 = new FileWriter(outputPairedReprFile);
//                FileWriter outputFile4 = new FileWriter(outputIntegerReprFile);
//                FileWriter outputFile5 = new FileWriter(outputRealReprFile);
//                FileWriter outputFile6 = new FileWriter(outputTetrahedronReprFile);
//                FileWriter outputFile7 = new FileWriter(outputTNCurveReprFile)) 

            while (readDataFile.hasNextLine()) {

                String input = readDataFile.nextLine();

                if (input.matches(header.pattern())) {

                    outputFile1.write(input + "\n");
//                    outputFile2.write(input + "\n");
//                    outputFile3.write(input + "\n");
//                    outputFile4.write(input + "\n");
//                    outputFile5.write(input + "\n");
//                    outputFile6.write(input + "\n");
//                    outputFile7.write(input + "\n");

                } else {

                    atomicNumberRepresentation(outputFile1, input);
//                    electronIonRepresentation(outputFile2, input);
//                    pairedNumericRepresentation(outputFile3, input);
//                    integerNumberRepresentation(outputFile4, input);
//                    realNumberRepresentation(outputFile5, input);
//                    tetrahedronRepresentation(outputFile6, input);
//                    TNCurveRepresentation(outputFile7, input);
                }
            }
        }

        System.out.println("Closing representation file");

        createArffFile pleaseWorkProperly = new createArffFile();
        pleaseWorkProperly.findLongerSequence(toReadFile);

        pleaseWorkProperly.convertToArffFile(toReadFile, outputAtomicReprFile);
    }

    public static class createArffFile {

        
        //find the longer sequence in the dataset and use it to
        public int findLongerSequence(File inputFile) throws FileNotFoundException {

            int max = 0;
            try (Scanner scanner = new Scanner(new FileReader(inputFile))) {
                while (scanner.hasNextLine()) {
                    String input = scanner.nextLine();
                    if (input.matches(header.pattern())) {
                        System.out.println("Reached here");
                        Pattern startPoint = Pattern.compile("\\d+");
                        System.out.println(startPoint.toString());
                        int start = Integer.parseInt(startPoint.toString());
                        Pattern endPoint = Pattern.compile("\\p{Punct}\\d+");

                        int end = Integer.parseInt(endPoint.toString());

                        int temp = (end - start);
                        if (temp > max) {
                            max = temp;
                        }
                    }
                }
            }
            return max;
        }

        //create sparse vector using the specific representation
        public void convertToArffFile(File inputFile, File representationTextFile) throws IOException {
            //get timestamp for creation of file
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            Date date = new Date(ts.getTime());

            //get the name of the file to be used later
            String fileName = representationTextFile.getName();

            System.out.println("Enter name of file");
            Scanner sc = new Scanner(System.in);

            //start the creation of an arff file
            try (FileWriter outputArffFile = new FileWriter(sc.toString())) {

                int attributesNumber = findLongerSequence(inputFile);
//            SparseVector sp = new SparseVector(attributesNumber);
                outputArffFile.write("/%1. Title " + fileName
                        + "\n/%2. Sources:\n"
                        + "/%Creator: Marina Athanasouli\n"
                        + "/%Date:" + date
                        + "\n/@RELATION " + fileName);

                //number of attributes = length of longer sequence
                for (int i = 0; i < attributesNumber; i++) {
                    outputArffFile.write("/@ATTRIBUTE " + i);
                }
                outputArffFile.write("/@DATA\n");

                Scanner representationToConvert = new Scanner(new FileReader(representationTextFile));
                while (representationToConvert.hasNextLine()) {
                    if (representationToConvert.nextLine().equals(header)) {
                        representationToConvert.next();
                    } else {
                        outputArffFile.write(representationToConvert.toString());
                    }

                }
            }
            System.out.println("Closing Arff File.");
        }

    }

    public static boolean checkRepresentationResult() {

        return true;
    }

}
