/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author marin
 */
public class SparseVector extends TreeMap<Integer, Double>{
   
   private final int n;             // length
   

    // initialize the all 0s vector of length n
    public SparseVector(int n) {
        this.n  = n;
        
    }

    public void createSparseVector(){
        
    }
   
    
   // return the number of nonzero entries
    public int nonZero() {
        return size();
    }

    // return the size of the vector
   @Override
    public int size() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        this.keySet().forEach((i) -> {
            s.append("(").append(i).append(", ").append(get(i)).append(") ");
        });
        return s.toString();
    }
    // return alpha * this
//    public SparseVector scale(double alpha) {
//        SparseVector result = new SparseVector(n);
//        this.keySet().forEach((i) -> {
//            result.put(i, alpha * this.get(i));
//        });
//        return result;
    

    // return this + that
//    public SparseVector plus(SparseVector that) {
//        if (this.n != that.n) throw new IllegalArgumentException("Vector lengths disagree");
//        SparseVector result = new SparseVector(n);
//        this.keySet().forEach((i) -> {
//            result.put(i, this.get(i));
//        });
//        that.keySet().forEach((i) -> {
//            result.put(i, that.get(i) + result.get(i));
//        });
//        return result;
//    }

    // return a string representation
    
}
