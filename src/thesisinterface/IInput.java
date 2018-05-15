/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.Map;

/**
 *
 * @author marin
 */
public interface IInput {
    
    int getExtendedInfo();
    
    void getBase(int index); 
    
    String asString();
    
    Map assignValues();
    
}
