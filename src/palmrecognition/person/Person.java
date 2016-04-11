/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palmrecognition.person;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author anggakes
 */
public class Person implements Serializable{
    
    private String nama ;
    private File[] images;

    public Person() {
    }

    public Person(String nama, File[] images) {
        this.nama = nama;
        this.images = images;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public File[] getImages() {
        return images;
    }

    public void setImages(File[] images) {
        this.images = images;
    }
    
   
    
}
