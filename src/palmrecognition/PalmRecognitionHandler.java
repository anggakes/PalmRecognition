/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palmrecognition;

import palmrecognition.trainingtemplate.TrainingTemplate;
import palmrecognition.person.Person;
import palmrecognition.imageprocessing.ImageProcessor;
import palmrecognition.imageprocessing.DigitImage;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import palmrecognition.datagenerator.DigitTrainingDataGenerator;
import palmrecognition.neural.Backpropagator;
import palmrecognition.neural.Layer;
import palmrecognition.neural.NeuralNetwork;
import palmrecognition.neural.Neuron;
import palmrecognition.neural.activators.LinearActivationStrategy;
import palmrecognition.neural.activators.SigmoidActivationStrategy;

/**
 *
 * @author anggakes
 * Handling request from FormPelatihan class
 */
public class PalmRecognitionHandler  {
    
    public static void trainData(List<Person> persons, String fileName){
        try{
            List<DigitImage> trainingImages = new ArrayList<DigitImage>();
            int index = 0;
            for(Person person : persons){
                File[] images = person.getImages();
                for(File image : images){
                    //read image from path file
                    BufferedImage img = ImageIO.read(image);
                    ImageProcessor ip  = new ImageProcessor();
                    // resize image
                    img = ip.resizeImage(img,ImageProcessor.DEFAULT_WIDTH,ImageProcessor.DEFAULT_HEIGHT);
                    //process image
                    img = ip.process(img);
                    int[] data = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
                    trainingImages.add(new DigitImage(index,data));
                }
                index++;
            }
            
            // create Neural Network -------------------------------------------------------------------
            NeuralNetwork neuralNetwork = createNeuralNetwork(persons);
            int banyakData = persons.size();
            int panjangData = ImageProcessor.DEFAULT_WIDTH*ImageProcessor.DEFAULT_HEIGHT;
            DigitTrainingDataGenerator trainingDataGenerator = new DigitTrainingDataGenerator(trainingImages, banyakData, panjangData);
            Backpropagator backpropagator = new Backpropagator(neuralNetwork, 0.1, 0.9, 0);
            backpropagator.train(trainingDataGenerator, 0.05);
            
            // save training result to file
            TrainingTemplate tt = new TrainingTemplate();
            tt.setTemplate(persons, neuralNetwork, fileName);
            
//          neuralNetwork.persist();
            
            

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static String testData(File image, File trainingTemplateFile) throws IOException{
        
        //get template training
         TrainingTemplate tt = new TrainingTemplate().getTemplate(trainingTemplateFile);
         
         NeuralNetwork neuralNetwork = tt.getNeuralNetwork();
         List<Person> persons = tt.getPersons();
        
        // Processing test Image 
           BufferedImage img = ImageIO.read(image);
           ImageProcessor ip  = new ImageProcessor();
           img = ip.resizeImage(img,28,28);
           img = ip.process(img);
           int[] data = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
           // insert to digitimage just for convert it to double and binerization;
            DigitImage input = new DigitImage(0,data);

            neuralNetwork.setInputs(input.getData());
            double[] receivedOutput = neuralNetwork.getOutput();

            double max = receivedOutput[0];
            int personIndex = 0;
            for(int j = 0; j < receivedOutput.length; j++) {
                if(receivedOutput[j] > max) {
                    max = receivedOutput[j];
                    personIndex = j;
                }
            }

            System.out.println("Recognized index : " + personIndex + ", Person name = " + persons.get(personIndex).getNama() + ". Corresponding output value was " + max);
            
            return persons.get(personIndex).getNama(); // returning person name
        
    }
    
    private static NeuralNetwork createNeuralNetwork(List<Person> persons){
        
        NeuralNetwork neuralNetwork = new NeuralNetwork("Palm Recognizing Neural Network");

        Neuron inputBias = new Neuron(new LinearActivationStrategy());
        inputBias.setOutput(1);

        Layer inputLayer = new Layer(null, inputBias);

        for(int i = 0; i < ImageProcessor.DEFAULT_WIDTH * ImageProcessor.DEFAULT_HEIGHT; i++) {
            Neuron neuron = new Neuron(new SigmoidActivationStrategy());
            neuron.setOutput(0);
            inputLayer.addNeuron(neuron);
        }

        Neuron hiddenBias = new Neuron(new LinearActivationStrategy());
        hiddenBias.setOutput(1);

        Layer hiddenLayer = new Layer(inputLayer, hiddenBias);

        long numberOfHiddenNeurons = Math.round((2.0 / 3.0) * (ImageProcessor.DEFAULT_WIDTH * ImageProcessor.DEFAULT_HEIGHT) + 10);

        for(int i = 0; i < numberOfHiddenNeurons; i++) {
            Neuron neuron = new Neuron(new SigmoidActivationStrategy());
            neuron.setOutput(0);
            hiddenLayer.addNeuron(neuron);
        }

        Layer outputLayer = new Layer(hiddenLayer);

        //10 output neurons - 1 for each digit
        for(int i = 0; i < persons.size(); i++) {
            Neuron neuron = new Neuron(new SigmoidActivationStrategy());
            neuron.setOutput(0);
            outputLayer.addNeuron(neuron);
        }

        neuralNetwork.addLayer(inputLayer);
        neuralNetwork.addLayer(hiddenLayer);
        neuralNetwork.addLayer(outputLayer);

        return neuralNetwork;
    }
    
    
}
