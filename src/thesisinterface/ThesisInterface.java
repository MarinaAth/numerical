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

/**
 *
 * @author marin
 */
public class ThesisInterface {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Pattern fastaHeader = Pattern.compile("^>.*");

        File toReadFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison14\\InsectUCNEsSurrogates.fas");
        File toWriteFile = new File("D:\\Marina\\Documents\\MSc DataSets\\Comparison14\\AtomicNumReprInsectUCNEsSurr.txt");

        try (Scanner readDataFile = new Scanner(new FileReader(toReadFile));
                FileWriter outputReprFile = new FileWriter(toWriteFile)) {

            while (readDataFile.hasNextLine()) {

                String input = readDataFile.nextLine();

                if (input.matches(fastaHeader.pattern())) {

                    outputReprFile.write(input + "\n");

                } else {

                    AtomicNumberRepresentation.atomicNumberRepresentation(outputReprFile, input);

                }
            }
        }

        System.out.println("Now closing");
    }

    public static boolean checkRepresentationResult() {

        return true;
    }

}
