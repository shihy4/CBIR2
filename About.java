import java.awt.Toolkit;

/******************************************************************************
 * <pre>
 * Class:       About
 * File:        About.java
 * Description: This is an About dialog to show details of the application. 
 *              
 * @author      Yun-Ming Shih (Jas)
 * Professor:   Dr. Min Chen
 * Course:      CSS 584 Autumn 2016
 * Project:     Project 1 - Implement a simple content-based image retrieval
 *                          system.
 * Due:         Oct 11 2016
 * Environment: iMac, OS X 10.11.6, NetBeans IDE 8.1, Java 1.8.0, Intel i5
 * @version     1.0
 * @see java.awt.Toolkit
 </pre>
 *****************************************************************************/
public class About extends javax.swing.JDialog {

  
    /**************************************************************************
     * About constructor
     * Creates an about form with logo, text, and button to close the form.
     *************************************************************************/
    public About()
    {
        initComponents();
        
        //Set saveJButton to default
        this.getRootPane().setDefaultButton(okJButton);
        
        //Center frame on screen
        this.setLocationRelativeTo(null);
        
        //Make always on top
        setAlwaysOnTop(true);
        
        this.requestFocus();
        
        //Set modality to prevent switching of focus
        setModal(true);
    }
  
    /**************************************************************************
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *************************************************************************/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane1 = new javax.swing.JPanel();
        logoJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputJTextArea = new javax.swing.JTextArea();
        pane3 = new javax.swing.JPanel();
        spaceTaker1 = new javax.swing.JLabel();
        spaceTaker2 = new javax.swing.JLabel();
        spaceTaker3 = new javax.swing.JLabel();
        copyJLabel = new javax.swing.JLabel();
        okJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About C B I R");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(460, 575));
        setResizable(false);

        pane1.setBackground(new java.awt.Color(255, 255, 255));

        logoJLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoJLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo/logo2.png"))); // NOI18N

        javax.swing.GroupLayout pane1Layout = new javax.swing.GroupLayout(pane1);
        pane1.setLayout(pane1Layout);
        pane1Layout.setHorizontalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1057, Short.MAX_VALUE)
            .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pane1Layout.setVerticalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
            .addGroup(pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(logoJLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        outputJTextArea.setEditable(false);
        outputJTextArea.setColumns(20);
        outputJTextArea.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        outputJTextArea.setLineWrap(true);
        outputJTextArea.setRows(5);
        outputJTextArea.setText("Getting Started with C B I R v 1.0:\t\nC B I R is a simple content-based image retrieval system based on two different color histogram comparison methods. \nWhen the application is loaded, user may browse through the image section and select an available image to query. Use < and > buttons to browse through the gallery. \nEach image in the Gallery section is an interactive button. User may select and view the image by clicking the image icons in the Gallery. Image name will pop-op as tip text if the mouse hovers on top of any image button. \nThe Intensity and Color Code buttons are used to retrieve images that are similar to the selected image based on the intensity and color code algorithms respectively. \nTo set the system back to start-up stage, click the Reset button or select Reset from the Menu on the upper left corner. \nFor more information of the system, go to the About page located under the menu tab. To quit the program, simply close the window or select Exit from the menu tab. \n\n\n< Button: Previous page button. Use this button to go to the previous page. The button is disabled when current page is the first page. \n\n> Button: Next page button. Use this button to go to the next page. The button is disabled when current page is the last page. \n\nPager display:  Pager display tells user which page the photo gallery is currently displaying out of 5 pages. This is located in between the < button and the > button. \n\nIntensity Button: Used to retrieve query images using the intensity method. This feature re-arranges the button orders based on the retrieval results. \n\nColor Code Button: Used to retrieve query images using the color code method. This feature re-arranges the button orders based on the retrieval results. \n\nRF Button: Used to retrieve query images using the intensity + color code method. This feature re-arranges the button orders based on the retrieval results. \n---- Relevance On/Off Radio Button: This feature only supports RF Button. \n--------- Relevance On activates all checkboxes under each image button.\n--------- Relevance Off deactivates all checkboxes under each image button.\n---- Check All Button: Checks all checkboxes. \n---- Uncheck All Button: Unchecks all checkboxes. \n\r\n\nReset Button: Resets the system back to its start-up stage (default stage). The image button orders reset to ascending order and deselects the photo if selected.  \n\t \nReset Menu: This menu item is under the Menu tab on the upper left corner and acts the same as Reset Button. Resets the system back to its start-up stage (default stage). The image button orders reset to ascending order and deselects the photo if selected.  \n\nPrint Menu: This menu item is under the Menu tab on the upper left corner. The print feature allows user to print the current displaying page of the gallery. \n\nPrint Menu: This menu item is under the Menu tab on the upper left corner. The print feature allows user to print the current displaying page of the gallery. \n\nAbout Menu: This menu item is under the Menu tab on the upper left corner. The About menu brings up an About dialog that contains detailed information of the program and usage instruction. \n\nExit Menu: This menu item is under the Menu tab on the upper left corner. The Exit menu terminates the program. User can also terminate the program by closing the window. \n\nGallery: The Gallery panel contains twenty clickable icon buttons during this particular application run. As the application starts, there are one-hundred images loaded into the program and are distributed into five pages ordered by file names in ascending orders. \nOrder of these icon buttons are then re-arranged when either the Intensity button or the Color Code button is clicked. The Reset button sets the button order back to default -- ascending order.\n\nPhoto: The Photo panel displays the selected image. If no image is selected, the Photo panel will display \"No Image Selected\". Both the Reset button and the Reset menu item can de-select the image. \n\nStorage: This program, C B I R, utilizes a master image folder called images as a database for the 100 images to be stored in. Each image is processed pixel-by-pixel, and the results are stored in the intensityMatrix and the colorCodeMatrix, which then get written into text files for future use (intensity.txt and colorCode.txt). \nCBIR query results are also kept in a text file. In short, when the Intensity button or the Color Code button is clicked, the program calculates the Manhattan Distance between the query image and every other available images. The result generates a new button order sorted by similarity for each method, and the rank decreases from left to right, and top to bottom. These generated button orders, which correspond to a particular selected query image are then stored into the maps and are written into files for later use (intensityResults.txt and colorCodeResults.txt).\nNotice, there is also a folder called, logo. The logo folder contains images that are used in this program besides the 100 images in the images folder.  \n\n\n\nCBIR is a class exercise exploring Content-Based Image Retrival Methods for CSS 584 \nAuthors: Yun-Ming Shih (Jas)\nProfessor: Min Chen\nInstitution: University of Washington\nEnvironments: * Intel i5 - OS X 10.11.5 - NetBeans 8.1 - Java 1.8\n");
        outputJTextArea.setWrapStyleWord(true);
        outputJTextArea.setFocusable(false);
        outputJTextArea.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(outputJTextArea);

        pane3.setBackground(new java.awt.Color(255, 255, 255));
        pane3.setLayout(new java.awt.GridLayout(1, 5));

        spaceTaker1.setBackground(new java.awt.Color(255, 255, 255));
        pane3.add(spaceTaker1);
        pane3.add(spaceTaker2);
        pane3.add(spaceTaker3);

        copyJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        copyJLabel.setForeground(new java.awt.Color(102, 102, 102));
        copyJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyJLabel.setText("Copyright 2016");
        copyJLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pane3.add(copyJLabel);

        okJButton.setBackground(new java.awt.Color(72, 62, 77));
        okJButton.setForeground(new java.awt.Color(255, 255, 255));
        okJButton.setMnemonic('o');
        okJButton.setText("OK");
        okJButton.setToolTipText("Return to Shipping Hub");
        okJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJButtonActionPerformed(evt);
            }
        });
        pane3.add(okJButton);
        okJButton.getAccessibleContext().setAccessibleDescription("Return to C B I R main page");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(pane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okJButtonActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel copyJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JButton okJButton;
    private javax.swing.JTextArea outputJTextArea;
    private javax.swing.JPanel pane1;
    private javax.swing.JPanel pane3;
    private javax.swing.JLabel spaceTaker1;
    private javax.swing.JLabel spaceTaker2;
    private javax.swing.JLabel spaceTaker3;
    // End of variables declaration//GEN-END:variables
}
