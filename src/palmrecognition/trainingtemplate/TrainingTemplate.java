/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palmrecognition.trainingtemplate;

import palmrecognition.person.Person;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import palmrecognition.neural.NeuralNetwork;

/**
 *
 * @author anggakes
 */
public class TrainingTemplate implements Serializable{
    
    private NeuralNetwork neuralNetwork;
    private List<Person> persons;

    public NeuralNetwork getNeuralNetwork() {
        return neuralNetwork;
    }

    public List<Person> getPersons() {
        return persons;
    }
    
    public void setTemplate(List<Person> persons, NeuralNetwork neuralNetwork, String fileName){
        this.persons  = persons;
        this.neuralNetwork = neuralNetwork;
        writeFile(fileName);
    }
    
    public TrainingTemplate getTemplate(File templateObj){
        
        TrainingTemplate tt = new TrainingTemplate();
       
        if (templateObj.exists())
        {
            System.out.println("Trying to read the existing Weights");           
            try{
                InputStream file = new FileInputStream(templateObj.getAbsolutePath());//fileName);
                InputStream buffer = new BufferedInputStream(file);               
                
                ObjectInputStream oi = new ObjectInputStream(buffer);
                tt = (TrainingTemplate) oi.readObject();
                 
            }
            catch (ClassNotFoundException ex)
            {
                System.out.println("Something went wrong --- ClassNotFoundError: \n" + ex.getMessage());
            }
            catch(IOException ex)
            {
                System.out.println("Something went wrong --- IOException: \n" + ex.getMessage());
            }
        }
        return tt;
    }
    
    public void writeFile(String fileName){
        
        String folder = "template_training";
        String path = folder+File.separator+fileName+".netak";
        
        System.out.println("Writing trained neural network to file " + path);

        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(this);
        }

        catch(IOException e) {
            System.out.println("Could not write to file: " + path);
            e.printStackTrace();
        }

        finally {
            try {
                if(objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
            }

            catch(IOException e) {
                System.out.println("Could not write to file: " + path);
                e.printStackTrace();
            }
        }
    }
    
    
    
}
