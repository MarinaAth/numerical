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
    public static void main(String[] args) throws IOException {

        Pattern fastaHeader = Pattern.compile("^>.*");

        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison1\\HumanExonsSurrogates.fas");
        
        File outputAtomicReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Atomic Number Representation\\Comparison1\\HumanExonsSurrogates.txt");
        File outputElectronReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Electron Ion Representation\\Comparison1\\HumanExonsSurrogates.txt");
        File outputPairedReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Paired Numeric Representation\\Comparison1\\HumanExonsSurrogates.txt");
        File outputIntegerReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Integer Number Representation\\Comparison1\\HumanExonsSurrogates.txt");
        File outputRealReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Real Number Representation\\Comparison1\\HumanExonsSurrogates.txt");
        File outputTetrahedronReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Tetrahedron Representation\\Comparison1\\HumanExonsSurrogates.txt");
        File outputTNCurveReprFile = new File("D:\\Marina\\Documents\\MSc DataSets\\TNCurve Representation\\Comparison1\\HumanExonsSurrogates.txt");

        
        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputFile1 = new FileWriter(outputAtomicReprFile);
                FileWriter outputFile2 = new FileWriter(outputElectronReprFile);
                FileWriter outputFile3 = new FileWriter(outputPairedReprFile);
                FileWriter outputFile4 = new FileWriter(outputIntegerReprFile);
                FileWriter outputFile5 = new FileWriter(outputRealReprFile);
                FileWriter outputFile6 = new FileWriter(outputTetrahedronReprFile);
                FileWriter outputFile7 = new FileWriter(outputTNCurveReprFile)) {

            while (readDataFile.hasNextLine()) {

                String input = readDataFile.nextLine();

                if (input.matches(fastaHeader.pattern())) {

                    outputFile1.write(input + "\n");
                    outputFile2.write(input + "\n");
                    outputFile3.write(input + "\n");
                    outputFile4.write(input + "\n");
                    outputFile5.write(input + "\n");
                    outputFile6.write(input + "\n");
                    outputFile7.write(input + "\n");

                } else {

                    atomicNumberRepresentation(outputFile1, input);
                    electronIonRepresentation(outputFile2, input);
                    pairedNumericRepresentation(outputFile3, input);
                    integerNumberRepresentation(outputFile4, input);
                    realNumberRepresentation(outputFile5, input);
                    tetrahedronRepresentation(outputFile6, input);
                    TNCurveRepresentation(outputFile7, input);
                }
            }
        }

        System.out.println("Closing");
    }

    public static boolean checkRepresentationResult() {

        return true;
    }

    
}
