/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation;
import thesisinterface.VectorRepresentation.OneDimensional.ElectronIonRepresentation;
import thesisinterface.VectorRepresentation.OneDimensional.IntegerRepresentation;
import thesisinterface.VectorRepresentation.OneDimensional.PairedNumeric;
import thesisinterface.VectorRepresentation.OneDimensional.RealNumberRepresentation;

/**
 *
 * @author marina
 */
public class ThesisInterface {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Pattern fastaHeader = Pattern.compile("^>.*");

        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison14\\InsectUCNEsSurrogates.fas");
        
        File outputAtomicReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison14\\AtomicNumReprInsectUCNEsSurr.txt");
        File outputElectronReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Electron Ion Representation\\Comparison14\\AtomicNumReprInsectUCNEsSurr.txt");
        File outputPairedReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Paired Numeric Representation\\Comparison14\\AtomicNumReprInsectUCNEsSurr.txt");
        File outputIntegerReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Integer Number Representation\\Comparison14\\AtomicNumReprInsectUCNEsSurr.txt");
        File outputRealReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Real Number Representation\\Comparison14\\AtomicNumReprInsectUCNEsSurr.txt");

        
        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputFile1 = new FileWriter(outputAtomicReprFile);
                FileWriter outputFile2 = new FileWriter(outputElectronReprFile);
                FileWriter outputFile3 = new FileWriter(outputPairedReprFile);
                FileWriter outputFile4 = new FileWriter(outputIntegerReprFile);
                FileWriter outputFile5 = new FileWriter(outputRealReprFile)) {

            while (readDataFile.hasNextLine()) {

                String input = readDataFile.nextLine();

                if (input.matches(fastaHeader.pattern())) {

                    outputFile1.write(input + "\n");
                    outputFile2.write(input + "\n");
                    outputFile3.write(input + "\n");
                    outputFile4.write(input + "\n");
                    outputFile5.write(input + "\n");

                } else {

                    AtomicNumberRepresentation.atomicNumberRepresentation(outputFile1, input);
                    ElectronIonRepresentation.electronIonRepresentation(outputFile2, input);
                    PairedNumeric.pairedNumericRepresentation(outputFile3, input);
                    IntegerRepresentation.integerNumberRepresentation(outputFile4, input);
                    RealNumberRepresentation.realNumberRepresentation(outputFile5, input);
                }
            }
        }

        System.out.println("Closing");
    }

    public static boolean checkRepresentationResult() {

        return true;
    }

}
