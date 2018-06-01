/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface.VectorRepresentation.BaseClasses;

import java.util.HashMap;

/**
 *
 * @author marin
 */
public class Sequence extends BaseSymbolSequence {
    
    public Sequence(){
        super("");
        System.out.println("Default constructor called");
    }

    public Sequence(String seq) {
        super(seq);
    }


    
}
