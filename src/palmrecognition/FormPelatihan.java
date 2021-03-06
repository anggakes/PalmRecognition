/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palmrecognition;

import palmrecognition.person.Person;
import palmrecognition.imageprocessing.ImageProcessor;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import palmrecognition.imageprocessing.DigitImage;

/**
 *
 * @author anggakes
 */
public class FormPelatihan extends javax.swing.JFrame {
    
    
    private List<Person> person = new ArrayList<Person>();
    private File trainingTemplateFile;
    private File imageTest;
    
    // for prevent error null pointer when list Change
    Boolean changeableListName;
    Boolean changeableListImage;
    
    /**
     * Creates new form FormPelatihan
     */
    public FormPelatihan() {
        
        initComponents();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        trainBtn = new javax.swing.JButton();
        trainingAddImageBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNama = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listImage = new javax.swing.JList<>();
        trainingPersonNameLbl = new javax.swing.JLabel();
        trainingPalmImageLbl = new javax.swing.JLabel();
        imageDisplay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        testAddTrainingTemplateBtn = new javax.swing.JButton();
        testTemplateLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        testImageLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        testAddImageBtn = new javax.swing.JButton();
        testImagePanel = new javax.swing.JPanel();
        testImageProcessingLbl = new javax.swing.JLabel();
        labelImageOriginal = new javax.swing.JLabel();
        labelImageGrayscale = new javax.swing.JLabel();
        labelImageNormalization = new javax.swing.JLabel();
        labelImageEdgeDetector = new javax.swing.JLabel();
        labelImageBinerization = new javax.swing.JLabel();
        testBtn = new javax.swing.JButton();
        labelTemplate = new javax.swing.JLabel();
        labelImageTest = new javax.swing.JLabel();
        testpalmOwnerLbl = new javax.swing.JLabel();
        labelPalmOwner = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        trainBtn.setText("Train");
        trainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainBtnActionPerformed(evt);
            }
        });

        trainingAddImageBtn.setText("Add Image");
        trainingAddImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainingAddImageBtnActionPerformed(evt);
            }
        });

        listNama.setName(""); // NOI18N
        listNama.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listNamaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listNama);

        listImage.setPreferredSize(new java.awt.Dimension(210, 210));
        listImage.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listImageValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listImage);

        trainingPersonNameLbl.setText("Person Name :");

        trainingPalmImageLbl.setText("Palm Image :");

        imageDisplay.setText("-");
        imageDisplay.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(trainingAddImageBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trainBtn)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(trainingPalmImageLbl)
                        .addGap(0, 711, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(trainingPersonNameLbl)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addGap(39, 39, 39)
                                .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trainingAddImageBtn)
                    .addComponent(trainBtn))
                .addGap(1, 1, 1)
                .addComponent(trainingPersonNameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(trainingPalmImageLbl)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Training Image", jPanel1);

        testAddTrainingTemplateBtn.setText("Choose Training Template");
        testAddTrainingTemplateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testAddTrainingTemplateBtnActionPerformed(evt);
            }
        });

        testTemplateLbl.setText("Template : ");

        jLabel4.setForeground(new java.awt.Color(255, 102, 51));

        testImageLbl.setText("Image : ");

        jLabel6.setForeground(new java.awt.Color(51, 204, 0));

        testAddImageBtn.setText("Choose Image");
        testAddImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testAddImageBtnActionPerformed(evt);
            }
        });

        testImagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        testImagePanel.setPreferredSize(new java.awt.Dimension(400, 400));

        testImageProcessingLbl.setText("Image Processing :");

        labelImageOriginal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImageOriginal.setText("Original");
        labelImageOriginal.setToolTipText("");

        labelImageGrayscale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImageGrayscale.setText("Greyscale");
        labelImageGrayscale.setToolTipText("");

        labelImageNormalization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImageNormalization.setText("Normalization");
        labelImageNormalization.setToolTipText("");

        labelImageEdgeDetector.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImageEdgeDetector.setText("Edge Detector");
        labelImageEdgeDetector.setToolTipText("");

        labelImageBinerization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImageBinerization.setText("Binerization");
        labelImageBinerization.setToolTipText("");

        javax.swing.GroupLayout testImagePanelLayout = new javax.swing.GroupLayout(testImagePanel);
        testImagePanel.setLayout(testImagePanelLayout);
        testImagePanelLayout.setHorizontalGroup(
            testImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testImagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testImageProcessingLbl)
                    .addGroup(testImagePanelLayout.createSequentialGroup()
                        .addComponent(labelImageOriginal)
                        .addGap(18, 18, 18)
                        .addComponent(labelImageGrayscale)
                        .addGap(18, 18, 18)
                        .addComponent(labelImageNormalization)
                        .addGap(18, 18, 18)
                        .addComponent(labelImageEdgeDetector)
                        .addGap(18, 18, 18)
                        .addComponent(labelImageBinerization)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        testImagePanelLayout.setVerticalGroup(
            testImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testImagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testImageProcessingLbl)
                .addGap(33, 33, 33)
                .addGroup(testImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelImageOriginal)
                    .addComponent(labelImageGrayscale)
                    .addComponent(labelImageNormalization)
                    .addComponent(labelImageEdgeDetector)
                    .addComponent(labelImageBinerization))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        testBtn.setText("Test Image");
        testBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testBtnActionPerformed(evt);
            }
        });

        labelTemplate.setText("-");

        labelImageTest.setText("-");

        testpalmOwnerLbl.setText("Palm Owner :  ");

        labelPalmOwner.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelPalmOwner.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(testImageLbl)
                    .addComponent(testTemplateLbl))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelImageTest, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addGap(137, 137, 137))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelTemplate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(320, 320, 320)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testAddTrainingTemplateBtn)
                    .addComponent(testAddImageBtn))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(testpalmOwnerLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPalmOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(testBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(testAddTrainingTemplateBtn)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(testTemplateLbl)
                        .addComponent(jLabel4)
                        .addComponent(labelTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testImageLbl)
                    .addComponent(jLabel6)
                    .addComponent(testAddImageBtn)
                    .addComponent(labelImageTest))
                .addGap(18, 18, 18)
                .addComponent(testImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testpalmOwnerLbl)
                    .addComponent(labelPalmOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Test Image", jPanel2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trainingAddImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainingAddImageBtnActionPerformed
        // TODO add your handling code here:
        
        String nama;
        
        nama = JOptionPane.showInputDialog(this, "Nama Pemilik Telapak Tangan");
        
        if(nama != null ){
            
            //System.out.print(nama);
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(true);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image File (*.jpg)", "jpg"));
            chooser.setAcceptAllFileFilterUsed(true);

            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                // for prevent error null pointer when the list Change
                changeableListName = false;

                File[] selectedImages = chooser.getSelectedFiles();
                Person p = new Person(nama, selectedImages);
                this.person.add(p);
                updateNameList();

                // for prevent error null pointer when list Change
                changeableListName = true;
            }
        }
       
    }//GEN-LAST:event_trainingAddImageBtnActionPerformed

    private void listNamaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listNamaValueChanged
        // TODO add your handling code here:
        boolean adjust = evt.getValueIsAdjusting();
        if (!adjust && changeableListName) {
        // for prevent error null pointer when list Change            
          changeableListName = false;  
          int index = listNama.getSelectedIndex();
          updateImageList(index);
        // for prevent error null pointer when list Change
          changeableListName = true;
        }
    }//GEN-LAST:event_listNamaValueChanged

    private void listImageValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listImageValueChanged
        // TODO add your handling code here:
        boolean adjust = evt.getValueIsAdjusting();
        if (!adjust && changeableListName) {
            
          int indexNama  = listNama.getSelectedIndex();
          int indexImage = listImage.getSelectedIndex();
          updateImageDisplay(indexNama, indexImage);
        }
    }//GEN-LAST:event_listImageValueChanged
    /* 
        Action for processing training image
    */
    private void trainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainBtnActionPerformed
        // TODO add your handling code here:
        try{
            String fileName;
        
            fileName = JOptionPane.showInputDialog(this, "Nama file hasil training");
            if(fileName!= null){
                PalmRecognitionHandler.trainData(person, fileName);
                JOptionPane.showMessageDialog(this, "training data Sukses !", "Data berhasil disimpan..",JOptionPane.PLAIN_MESSAGE);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_trainBtnActionPerformed

    private void testAddTrainingTemplateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testAddTrainingTemplateBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Neural Network Template (*.netak)", "netak"));
            chooser.setAcceptAllFileFilterUsed(true);
            
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                
                trainingTemplateFile = chooser.getSelectedFile();
                 
                //set label text
                labelTemplate.setText(trainingTemplateFile.getName());
            }
    }//GEN-LAST:event_testAddTrainingTemplateBtnActionPerformed

    private void testAddImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testAddImageBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image File (*.jpg)", "jpg"));
            chooser.setAcceptAllFileFilterUsed(true);
            
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                
                imageTest = chooser.getSelectedFile();
                 
                //set label text
                labelImageTest.setText(imageTest.getName());
                displayProcessingImage(imageTest);
            }
    }//GEN-LAST:event_testAddImageBtnActionPerformed

    private void testBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testBtnActionPerformed
        // TODO add your handling code here:
       if(imageTest != null && trainingTemplateFile != null){
            try{
                
                String personName = PalmRecognitionHandler.testData(imageTest, trainingTemplateFile);
                labelPalmOwner.setText(personName);
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }  
       }
    }//GEN-LAST:event_testBtnActionPerformed
    
    // updating jlist nama from person list
    private void updateNameList(){
        
        DefaultListModel model = new DefaultListModel();
        
        for(int i = 0;i < person.size(); i++){
            model.addElement(person.get(i).getNama());
        }
        
        listNama.setModel(model);
        
    }
    
    // updating jlist image from person list images by its index
    private void updateImageList(int index){
        
        DefaultListModel model = new DefaultListModel();
        File[] images = person.get(index).getImages();
        for (File image : images) {
            
            model.addElement(image.getName());
        }
        listImage.setModel(model);
    }
    
    private void updateImageDisplay(int indexNama, int indexImage){
        try{
            ImageIcon imageIcon;
            
            File image = person.get(indexNama).getImages()[indexImage];
            BufferedImage img = ImageIO.read(image);
            img = ImageProcessor.resizeImage(img, imageDisplay.getWidth(), imageDisplay.getHeight());
            imageIcon = new ImageIcon(img);
            imageDisplay.setIcon(imageIcon);
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void displayProcessingImage(File image){
        try{
            
            BufferedImage original = ImageIO.read(image);
            //default size for view :
            int defaultHeight   = 150;
            int defaultWidth    = 150;
            
            //resize
            original = ImageProcessor.resizeImage(original, defaultHeight, defaultWidth);
            setLabelIcon(original, labelImageOriginal);
            
            /* greyscale  */
            BufferedImage greyscale = ImageProcessor.toGrayscale(original);
            setLabelIcon(greyscale, labelImageGrayscale);
            
            /* Normalization */
            BufferedImage normalization = ImageProcessor.normalizationImage(original);
            setLabelIcon(normalization, labelImageNormalization);
            
            /* edge detector */
            BufferedImage edging = ImageProcessor.edgeDetector(normalization);
            setLabelIcon(edging, labelImageEdgeDetector);
            
            /* binarization */
            int[] data = ((DataBufferInt) edging.getRaster().getDataBuffer()).getData();
            DigitImage di = new DigitImage(0,data);
            BufferedImage biner = new BufferedImage(defaultHeight,defaultWidth, BufferedImage.TYPE_INT_RGB);
            // convert image to int, because image pixel is not double here
            int[] result = new int[di.getData().length];
            for(int i = 0; i < di.getData().length; i++) {
                result[i] = (int) data[i] ; //convert to unsigned
            }
            biner.getRaster().setDataElements(0, 0, defaultHeight, defaultWidth, result);
            setLabelIcon(biner, labelImageBinerization);

            
        }catch(IOException e){
            
            System.out.println(e.getMessage());
        }
    }
    
    private void setLabelIcon(BufferedImage image, JLabel label){
        ImageIcon imageIcon;
            
        imageIcon = new ImageIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setIcon(imageIcon);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageDisplay;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelImageBinerization;
    private javax.swing.JLabel labelImageEdgeDetector;
    private javax.swing.JLabel labelImageGrayscale;
    private javax.swing.JLabel labelImageNormalization;
    private javax.swing.JLabel labelImageOriginal;
    private javax.swing.JLabel labelImageTest;
    private javax.swing.JLabel labelPalmOwner;
    private javax.swing.JLabel labelTemplate;
    private javax.swing.JList<String> listImage;
    private javax.swing.JList<String> listNama;
    private javax.swing.JButton testAddImageBtn;
    private javax.swing.JButton testAddTrainingTemplateBtn;
    private javax.swing.JButton testBtn;
    private javax.swing.JLabel testImageLbl;
    private javax.swing.JPanel testImagePanel;
    private javax.swing.JLabel testImageProcessingLbl;
    private javax.swing.JLabel testTemplateLbl;
    private javax.swing.JLabel testpalmOwnerLbl;
    private javax.swing.JButton trainBtn;
    private javax.swing.JButton trainingAddImageBtn;
    private javax.swing.JLabel trainingPalmImageLbl;
    private javax.swing.JLabel trainingPersonNameLbl;
    // End of variables declaration//GEN-END:variables
   
    
}
