/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import thesisinterface.VectorRepresentation.BaseClasses.BaseFeatureVector;
import thesisinterface.VectorRepresentation.BaseClasses.BaseSymbolSequence;
import thesisinterface.VectorRepresentation.OneDimensional.AtomicNumberRepresentation;
import thesisinterface.VectorRepresentation.OneDimensional.SingleValueRepresentation;

/**
 *
 * @author marin
 */

public class ThesisInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        
        
        String input = null;

        Pattern fastaHeader = Pattern.compile("^\\>.*");

        try (Scanner readDataFile = new Scanner(new FileReader("HumanExonsSurrogates.txt"));
                FileWriter outputReprFile = new FileWriter("AtomicReprHumanExonsSurrogates.txt")) {

            while (readDataFile.hasNextLine()) {
                input = readDataFile.nextLine().toString();
                if (input.equalsIgnoreCase(fastaHeader.toString())) {

                    outputReprFile.write(input);
                    readDataFile.nextLine();
                } else{
                    
                    BaseSymbolSequence inputSeq = new BaseSymbolSequence(input);
                    BaseFeatureVector outputVector = new BaseFeatureVector();
                    AtomicNumberRepresentation atomicNumRepr = new AtomicNumberRepresentation(inputSeq);
                    
                    atomicNumRepr.assignValues();
                    atomicNumRepr.calculateVectorDimensions();
                    
//                    outputReprFile.write();
                }

                System.out.println("Now closing");
                outputReprFile.close();

            }
        }

    }


}

