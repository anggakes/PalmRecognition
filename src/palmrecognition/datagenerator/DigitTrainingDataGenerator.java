/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palmrecognition.datagenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import palmrecognition.imageprocessing.DigitImage;
import palmrecognition.neural.generator.TrainingData;
import palmrecognition.neural.generator.TrainingDataGenerator;

/**
 *
 * @author anggakes
 * This class is generating Training data from digit image and setting the Expected Output
 */
public class DigitTrainingDataGenerator implements TrainingDataGenerator {

    Map<Integer, List<DigitImage>> labelToDigitImageListMap;
    int banyakData;
    int panjangData;

    public DigitTrainingDataGenerator(List<DigitImage> digitImages, int banyakData, int panjangData) {
        labelToDigitImageListMap = new HashMap<Integer, List<DigitImage>>();
        this.banyakData = banyakData;
        this.panjangData = panjangData;
        
        for (DigitImage digitImage: digitImages) {

            if (labelToDigitImageListMap.get(digitImage.getLabel()) == null) {
                labelToDigitImageListMap.put(digitImage.getLabel(), new ArrayList<DigitImage>());
            }

            labelToDigitImageListMap.get(digitImage.getLabel()).add(digitImage);
        }
    }

    public TrainingData getTrainingData() {
        
        
        double[][] inputs = new double[banyakData][panjangData];
        double[][] outputs = new double[banyakData][banyakData];

        for(int i = 0; i < banyakData; i++) {
            inputs[i] = getRandomImageForLabel(i).getData();
            outputs[i] = getOutputFor(i);
//            System.out.println(  Arrays.toString(inputs[i]) + " - "+ Arrays.toString(outputs[i]));

        }

        return new TrainingData(inputs, outputs);
    }

    private DigitImage getRandomImageForLabel(int label) {
        Random random = new Random();
        List<DigitImage> images = labelToDigitImageListMap.get(label);
        return images.get(random.nextInt(images.size()));
    }

    private double[] getOutputFor(int label) {
        
        double[] output = new double[banyakData];
        // isi semua output dengan 0 terlebih dahulu
        for(int i = 0; i < banyakData; i++) {
            output[i] = 0;
        }
        
        //set index atau label nya
        output[label] = 1;
        
        return output;
    }
}

