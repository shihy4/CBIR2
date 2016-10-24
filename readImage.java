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
    private final static int AVERAGE_ROW = 101;
    private final static int SD_ROW = 102;
    private final static int N = 100;

    
    int imageCount = 1;
    int intensityBins[] = new int[26];
    int intensityMatrix[][] = new int[101][26];
    int colorCodeBins[] = new int[64];
    int colorCodeMatrix[][] = new int[101][64];
    double originalFeatureMatirx[][]  = new double[103][89];
    double normalizedMatrix[][] = new double[101][89];
    double avg_hodler[] = new double[89];
    double sd_holder[] = new double[89];
    

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
        
        getOriginalFeatureMatrix();
        writeToNormalizedMatrix();
        
        
        writeIntensity();
        writeColorCode();
        writeNormalized();

    }
    
    /**************************************************************************
     * getOriginalFeatureMatrix - Generates the original feature matrix 
     * - AVG and SD for each column are added to row 101 and 102 respectively
     *************************************************************************/
    private void getOriginalFeatureMatrix() {
    	// set up the original feature matrix for 100 images
    	for(int i = 1; i < 101; i++) {
    		double size = intensityMatrix[i][0];
    		for(int j = 1; j < INTENSITY_BIN_SIZE; j++) {
    			originalFeatureMatirx[i][j - 1] = 
    					((double)intensityMatrix[i][j]) / size;
    		}
    		int rows = INTENSITY_BIN_SIZE + COLOR_CODE_BIN_SIZE;
    		for(int j = INTENSITY_BIN_SIZE; j < rows; j++) {
    			originalFeatureMatirx[i][j - 1] = 
    					((double)
    					colorCodeMatrix[i][j - INTENSITY_BIN_SIZE])  / size;
    		}
    	}
    	
    	// originalFeatureMatirx.length-2 for excluding the AVG and SD rows
    	int matrixSize = originalFeatureMatirx.length - 2;
    	setOriginalFeatureMatrixAVG(matrixSize);
    	setOriginalFeatureMatrixSD(matrixSize);
    	
//    	// set the average row (101) for the original feature matrix
//    	for (int column = 0; column < 89; column++) {
//    		double sum = 0;
//    		for(int i = 1; i < matrixSize; i++) {
//	    		sum += originalFeatureMatirx[i][column];
//	    	}
//    		originalFeatureMatirx[AVERAGE_ROW][column] = sum / N; 
//    	}
//    	
//    	
//    	// set the SD row (102) for the original feature matrix
//    	for (int column = 0; column < 89; column++) {
//    		double sum_of_square = 0;
//    		double avg = originalFeatureMatirx[AVERAGE_ROW][column];
//    		for(int i = 1; i < matrixSize; i++) {
////    			System.out.println(Math.pow((originalFeatureMatirx[i][column] - avg), 2));
//    			sum_of_square += 
//    					Math.pow((originalFeatureMatirx[i][column] - avg), 2);
//	    	}
//    		originalFeatureMatirx[SD_ROW][column] = 
//    				Math.pow((sum_of_square / (N - 1)), 0.5);
//    	}
    	
    	
    	
    	
// PRINT FEATURES 	
//    	for(int i = 1; i < 101; i++) {
//    		System.out.print("[");
//    		for(int j = 1; j < INTENSITY_BIN_SIZE; j++) {
//    			System.out.print(((double)intensityMatrix[i][j]) / 98304 + ", ");
//    		}
//    		for(int j = 0; j < COLOR_CODE_BIN_SIZE; j++) {
//    			System.out.print(((double)colorCodeMatrix[i][j]) / 98304 + ", ");
//    		}
//    		System.out.println("]");
//    		System.out.print("[");
//    		for(int j = 0; j < 89; j++) {
//    			System.out.print(originalFeatureMatirx[i][j] + ", ");
//    		}
//    		System.out.println("]");
//    	}

    	
//    	// PRINT AVERAGE 0
//    	System.out.println("Average here: ");
//    	for (int column = 0; column < 89; column++) {
//    		if(originalFeatureMatirx[101][column] == 0) {
//    			System.out.println(originalFeatureMatirx[101][column] + " From " + column);
//    		}
//	    }
//    	System.out.println();

    	
//    	// PRINT SD 0
//    	System.out.println("SD here: ");
//    	for (int column = 0; column < 89; column++) {
//    		if(originalFeatureMatirx[102][column] == 0) {
//    			System.out.println(originalFeatureMatirx[102][column] + " From " + column);
//    		}
//	    }
    	
//    	
//    	// print SD 0 columns:
//    	for(int i = 1; i < 101; i++) {
//    		System.out.print(  originalFeatureMatirx[i][28] + ", ");
//    		System.out.print(  originalFeatureMatirx[i][37] + ", ");
//    		System.out.print(  originalFeatureMatirx[i][38] + ", ");
//    		System.out.print(  originalFeatureMatirx[i][39] + ", ");
//    		System.out.print(  originalFeatureMatirx[i][40] + ", ");
//    		System.out.print(  originalFeatureMatirx[i][44] + ", ");
//    		System.out.print(  originalFeatureMatirx[i][60] + ", ");
//    		System.out.println(originalFeatureMatirx[i][76] );
//    	}
    	
    	
// PRINT AVERAGE  and SD valeus
//    	System.out.println("Average here: ");
//    	for (int column = 0; column < 89; column++) {
//    		System.out.print(originalFeatureMatirx[101][column] + ", ");
//    		
//	    }
//    	System.out.println();
//    	// PRINT SD 
//    	System.out.println("SD here: ");
//    	for (int column = 0; column < 89; column++) {
//    		System.out.print(originalFeatureMatirx[102][column] + ", ");
//	    }
//    	
  	
    }
    
    
    /**************************************************************************
     * setOriginalFeatureMatrixAVG - sets the average row
     *************************************************************************/
    private void setOriginalFeatureMatrixAVG(int matrixSize) {    	
    	// set the average row (101) for the original feature matrix
    	for (int column = 0; column < 89; column++) {
    		double sum = 0;
    		for(int i = 1; i < matrixSize; i++) {
	    		sum += originalFeatureMatirx[i][column];
	    	}
    		originalFeatureMatirx[AVERAGE_ROW][column] = sum / N; 
    	}
    }
    
    /**************************************************************************
     * setOriginalFeatureMatrixSD - sets the SD row
     *************************************************************************/
    private void setOriginalFeatureMatrixSD(int matrixSize) {
    	// set the SD row (102) for the original feature matrix
    	for (int column = 0; column < 89; column++) {
    		double sum_of_square = 0;
    		double avg = originalFeatureMatirx[AVERAGE_ROW][column];
    		for(int i = 1; i < matrixSize; i++) {
//    			System.out.println(Math.pow((originalFeatureMatirx[i][column] - avg), 2));
    			sum_of_square += 
    					Math.pow((originalFeatureMatirx[i][column] - avg), 2);
	    	}
    		originalFeatureMatirx[SD_ROW][column] = 
    				Math.pow((sum_of_square / (N - 1)), 0.5);
    	}
    }
    
    
    /**************************************************************************
     * writeToNormalizedMatrix - Writes the normalized feature to the matrix
     *************************************************************************/
    private void writeToNormalizedMatrix() {
    	for(int col = 0; col < 89; col++) {
    		double avg = originalFeatureMatirx[AVERAGE_ROW][col];
    		double sd = originalFeatureMatirx[SD_ROW][col];
    		for(int row = 1; row < 101; row++) {
    			if(sd > 0) {
	    			normalizedMatrix[row][col] = 
	    					(originalFeatureMatirx[row][col] -  avg) / sd;
    			}
    		}
    	}
//    	// PRINT normalized matrix
//    	for(int i = 1; i < 101; i++) {
//    		for(int j = 0; j < 88; j++) {
//    			System.out.print(normalizedMatrix[i][j] + ", ");
//    		}
//    		System.out.println(normalizedMatrix[i][88] + "");
//    	}
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
     * writeNormalized 
     * - This method writes the contents of the normalized matrix to a file 
     *   named normalized.txt
     *************************************************************************/
    private void writeNormalized() {
        try {

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("normalized.txt")); 
    
            out.writeObject(normalizedMatrix);
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
