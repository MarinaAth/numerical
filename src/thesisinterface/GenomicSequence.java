/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

/**
 *
 * @author marin
 */
public class GenomicSequence extends Sequence{

    private Sequence sequence;
    public char[] convSeq;

    public GenomicSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public Sequence getSequence() {
        return sequence;
    }

    @Override
    double[][] indicatorSeq() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
