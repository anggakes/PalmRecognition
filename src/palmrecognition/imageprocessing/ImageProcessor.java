/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palmrecognition.imageprocessing;


import palmrecognition.imageprocessing.CannyEdgeDetector;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anggakes
 */
public class ImageProcessor {
    
    public static final int DEFAULT_WIDTH = 28;
    public static final int DEFAULT_HEIGHT = 28;
    
    
    public ImageProcessor(){
        
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    
    public BufferedImage process(BufferedImage image){
        
        Mat mat  = ImageProcessor.convertToMat(image);
        Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
        Mat mat2 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
        
        /* convert to grayscale */
        Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);
        
        /* Normalization Image */
        Imgproc.equalizeHist(mat1, mat2);
        
        // convert back to BufferedImage because CannyEdgeDetector need it..
        image = ImageProcessor.convertToBufferedImage(mat2);
        
        /* analisis garis tepi (canny edge detector) */
        BufferedImage edgingImage = ImageProcessor.edgeDetector(image);
       
        
        return edgingImage;
    }
    
    public static BufferedImage toGrayscale(BufferedImage image){
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        Mat mat = convertToMat(image);
        Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
        
        /* convert to grayscale */
        Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);
        
        return convertToBufferedImage(mat1);
    }
    
    public static BufferedImage normalizationImage(BufferedImage image){
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        Mat mat  = ImageProcessor.convertToMat(image);
        Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
        Mat mat2 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
        
        /* convert to grayscale */
        Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);
        
        /* Normalization Image */
        Imgproc.equalizeHist(mat1, mat2);
        
        // convert back to BufferedImage because CannyEdgeDetector need it..
        image = ImageProcessor.convertToBufferedImage(mat2);
        
        return image;
        
    }
    
    public static BufferedImage edgeDetector(BufferedImage image){
        
        CannyEdgeDetector detector = new CannyEdgeDetector();
        //adjust its parameters as desired
//        detector.setLowThreshold(0.1f);
//        detector.setHighThreshold(0.2f);

        //apply it to an image
        detector.setSourceImage(image);
        detector.process();
        BufferedImage edgingImage = detector.getEdgesImage();
        
        return edgingImage;
    }
    
     public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height){
        
         int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
	BufferedImage resizedImage = new BufferedImage(width, height, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, width, height, null);
	g.dispose();
		
	return resizedImage;
    }
    
    public static BufferedImage convertToBufferedImage(Mat mat){
        
        byte[] data = new byte[mat.rows() * mat.cols() * (int)(mat.elemSize())];
        mat.get(0, 0, data);
        BufferedImage image = new BufferedImage(mat.cols(),mat.rows(), BufferedImage.TYPE_BYTE_GRAY);
        image.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);
        
        return image;
    }
    
    public static Mat convertToMat(BufferedImage image){
        
        byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
        
        mat.put(0, 0, data);
        return mat;
    }
    
    
    
}
