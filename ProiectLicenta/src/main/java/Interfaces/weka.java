/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.control.TextArea;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.filters.unsupervised.attribute.Remove;
import weka.core.converters.*;
import weka.classifiers.bayes.*;
import weka.classifiers.*;


public class weka {
public  static void show(TextArea a)throws Exception{
          ConverterUtils.DataSource source = new ConverterUtils.DataSource("C:\\Users\\gigisan\\Desktop\\MOCK_DATA.arff");
        Instances train = source.getDataSet();
        // setting class attribute if the data format does not provide this information

        if (train.classIndex() == -1) {
            train.setClassIndex(train.numAttributes() - 1);
        }

        ConverterUtils.DataSource sourceTest = new ConverterUtils.DataSource("C:\\Users\\gigisan\\Desktop\\MOCK_DATA2.arff");
        Instances testData = sourceTest.getDataSet();
        // setting class attribute if the data format does not provide this information

        if (testData.classIndex() == -1) {
            testData.setClassIndex(train.numAttributes() - 1);
        }
       Path path = Paths.get("C:\\Users\\gigisan\\Desktop\\MOCK_DATA2.arff");
       long lineCount=Files.lines(path).count();
        // model
        NaiveBayes naiveBayes = new NaiveBayes();
        naiveBayes.buildClassifier(train);
       
//        double label = naiveBayes.classifyInstance(testData.instance(0));
//        testData.instance(0).setClassValue(label);
        for (int i = 0; i < lineCount-6; i++) {
            double label = naiveBayes.classifyInstance(testData.instance(i));
            testData.instance(i).setClassValue(label);
//            System.out.println(i + " " + testData.instance(i).stringValue(1));
        }
        
        Evaluation eval = new Evaluation(testData);
        
        
        
        eval.crossValidateModel(naiveBayes, testData, 10, new Random(1));
        a.appendText("Estimated Accuracy: " + Double.toString(eval.pctCorrect()));
   
        String strSummary=eval.toSummaryString();
         a.appendText(strSummary);
        
        String resPerClass=eval.toClassDetailsString();
         a.appendText(resPerClass);
        
        String cMatrix=eval.toMatrixString();
         a.appendText(cMatrix);

}
  
}
