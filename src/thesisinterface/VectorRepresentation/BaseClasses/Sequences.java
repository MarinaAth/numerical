package thesisinterface.VectorRepresentation.BaseClasses;
import java.util.ArrayList;
/**
 * @author nikolas
 */
public class Sequences extends ArrayList<Sequence> {
    public Sequences(){
        super();
    }

    public Sequences(int capacity){
        super(capacity);
    }

    public Sequences(ArrayList<String> strArray){
        Sequences seq = new Sequences();
        for(String s : strArray) {
            seq.add(new Sequence(s));
        }
        this.addAll(seq);
    }
}
