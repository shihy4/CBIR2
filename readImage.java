import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/******************************************************************************
 * <pre>
 * Class:       readImage
 * File:        readImage.java
 * Description: This is a readImage main program to process all 100 images. 
 *              
 * @author      Yun-Ming Shih (Jas)
 * Professor:   Dr. Min Chen
 * Course:      CSS 584 Autumn 2016
 * Project:     Project 1 - Implement a simple content-based image retrieval
 *                          system.
 * Due:         Oct 11 2016
 * Environment: iMac, OS X 10.11.6, NetBeans IDE 8.1, Java 1.8.0, Intel i5
 * @version     1.0
 * @see java.awt.image.BufferedImage;
 * @see java.io.*;
 * @see java.util.logging.Level;
 * @see java.util.logging.Logger;
 * @see javax.imageio.ImageIO;
 </pre>
 *****************************************************************************/
public class readImage {

    private final static int INTENSITY_BIN_SIZE = 26;
    private final static int COLOR_CODE_BIN_SIZE = 64;
    private final static int RED_SIGNIFICANT = 12582912;
    private final static int GREEN_SIGNIFICANT = 49152;
    private final static int BLUE_SIGNIFICANT = 192;

    
    int imageCount = 1;
    int intensityBins[] = new int[26];
    int intensityMatrix[][] = new int[101][26];
    int colorCodeBins[] = new int[64];
    int colorCodeMatrix[][] = new int[101][64];

    /**************************************************************************
     * readImage - Each image is retrieved from the file
     * - The height and width are found for the image and the getIntensity and
     *   getColorCode methods are called
     *************************************************************************/
    public readImage() {
        while (imageCount < 101) {

            BufferedImage img;
            try {
                img = ImageIO.read(getClass().getResource(
                        "images/" + imageCount + ".jpg"));
                int height = img.getHeight();
                int width = img.getWidth();
                
                getIntensity(img, height, width);
                writeToIntensityMatrix(imageCount);
                
                getColorCode(img, height, width);
                writeToColorCodeMatrix(imageCount);
       
                imageCount++;
            } catch (IOException e) {
                System.out.println("Error occurred when reading the file.");
            }
        }

        writeIntensity();
        writeColorCode();

    }

    /**************************************************************************
     * writeToIntensityMatrix - Write prepared bin to intensityMatrix
     * @param imageCount 
     *************************************************************************/
    private void writeToIntensityMatrix(int imageCount) {
        for(int i = 0;  i < INTENSITY_BIN_SIZE; i++) {
            intensityMatrix[imageCount][i] = intensityBins[i];
            intensityBins[i] = 0;
        }
    }
    
    /**************************************************************************
     * writeToColorCodeMatrix - Write prepared bin to colorCodeMatrix
     * @param imageCount 
     *************************************************************************/
    private void writeToColorCodeMatrix(int imageCount) {
        for(int i = 0; i < COLOR_CODE_BIN_SIZE; i++) {
            colorCodeMatrix[imageCount][i] = colorCodeBins[i];
            colorCodeBins[i] = 0;
        }
    }
    
    /**************************************************************************
     * getIntensity - get the intensity values from image and put to bin
     * @param image to process
     * @param height of image
     * @param width of image
     *************************************************************************/
    private void getIntensity(BufferedImage image, int height, int width) {
        
        int intensity, red, green, blue, rgb, binNumber;
        
        intensityBins[0] = height * width;
        
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                rgb = image.getRGB(w, h);
                
                // bit shift technique
                red = (rgb & 0x00ff0000) >> 16;
                green = (rgb & 0x0000ff00) >> 8; 
                blue = rgb & 0x000000ff;

                intensity = (int)(0.299 * (red)
                                + 0.587 * (green)
                                + 0.114 * (blue));
                
                binNumber = (((int)intensity) / 10) + 1;
                if(binNumber > 25) {
                    binNumber = 25;
                }
                intensityBins[binNumber]++;
            }
        }
    }

    /**************************************************************************
     * getColorCode - get the color code values from image and put to bin
     * @param image to process
     * @param height of image
     * @param width of image
     *************************************************************************/
    private void getColorCode(BufferedImage image, int height, int width) {
        int rgb_6bit, rgb;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                rgb = image.getRGB(w, h);
                
                // bit shift technique
                rgb_6bit =  ((rgb & RED_SIGNIFICANT) >> 18) + 
                            ((rgb & GREEN_SIGNIFICANT) >> 12) +
                            ((rgb & BLUE_SIGNIFICANT) >> 6);
               
                colorCodeBins[rgb_6bit]++;
            }
        }
    }

    /**************************************************************************
     * writeColorCode 
     * - This method writes the contents of the colorCode matrix to a file 
     *   named colorCodes.txt
     *************************************************************************/
    private void writeColorCode() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("colorCodes.txt")); 

            out.writeObject(colorCodeMatrix);
        } catch (IOException ex) {
            Logger.getLogger(readImage.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        
    }

    
    /**************************************************************************
     * writeIntensity 
     * - This method writes the contents of the intensity matrix to a file 
     *   named intensity.txt
     *************************************************************************/
    private void writeIntensity() {
        try {

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("intensity.txt")); 
    
            out.writeObject(intensityMatrix);
        } catch (IOException ex) {
            Logger.getLogger(readImage.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        
    }

    /**************************************************************************
     * main
     * @param args the command line arguments
     *************************************************************************/
    public static void main(String[] args) {
        new readImage();
    }

}
