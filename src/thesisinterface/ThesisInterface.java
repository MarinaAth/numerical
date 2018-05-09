/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marin
 */

public class ThesisInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, String> test = new HashMap<>();
        
        test.put("Marina", "Anna");
        test.put("George", "Nick");
        test.put("Mary", "John");
        test.put("Ollie", "Binky");
        test.put("Freddie", "Olivia");
        
        String[] testArray = new String[]{"Marina", "Freddie", "George", "Ollie"};
        
        for(int i=0; i<testArray.length; i++){
            if (test.containsKey(testArray[i])){
                
                System.out.println(test.get(testArray[i]));
            }
        }
       
    }
    


// public static Object[] corrMapValues(HashMap values, Object[] sequence){
//        
//        Object[] transSeq = new Object[sequence.length];
//        
//        for (int i=0; i<sequence.length; i++){
//            for (int j=0; j<transSeq.length; j++){
//            
//            if(values.containsKey(sequence[i])){
//                transSeq[j]=values.get(sequence[i]);
//            }
//           }
//        }
//        
//        return transSeq;
//    }
}