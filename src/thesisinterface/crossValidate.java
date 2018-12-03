/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisinterface;

import java.util.Random;
import static weka.classifiers.AbstractClassifier.makeCopies;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instances;

/**
 *
 * @author marin
 */
public class crossValidate {
    public static double crossValidate(NaiveBayesUpdateable fullModel,
		       Instances trainingSet,
		       Random r) throws Exception {
   // make some copies for fast evaluation of 5-fold xval
   Classifier [] copies = makeCopies(fullModel, 5);
   Evaluation eval = new Evaluation(trainingSet);
   
   // make some splits
   for (int j = 0; j < 5; j++) {
     Instances test = trainingSet.testCV(5, j);
     // unlearn these test instances
     for (int k = 0; k < test.numInstances(); k++) {
test.instance(k).setWeight(-test.instance(k).weight());
((NaiveBayesUpdateable)copies[j]).updateClassifier(test.instance(k));
// reset the weight back to its original value
test.instance(k).setWeight(-test.instance(k).weight());
     }
     eval.evaluateModel(copies[j], test);
   }
   return eval.incorrect();
 }
}
