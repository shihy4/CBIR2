import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/******************************************************************************
 * <pre>
 * Class:       CBIRSplash
 * File:        CBIRSplash.java
 * Description: Defines a splashscreen to be loaded when the CBIR software is 
 *              loaded.
 *              
 * @author      Yun-Ming Shih (Jas)
 * Professor:   Dr. Min Chen
 * Course:      CSS 584 Autumn 2016
 * Project:     Project 1 - Implement a simple content-based image retrieval
 *                          system.
 * Due:         Oct 11 2016
 * Environment: iMac, OS X 10.11.6, NetBeans IDE 8.1, Java 1.8.0, Intel i5
 * @version     1.0
 * @see java.awt.BorderLayout;
 * @see java.awt.Color;
 * @see java.awt.Dimension;
 * @see java.awt.Font;
 * @see java.awt.Toolkit;
 * @see javax.swing.BorderFactory;
 * @see javax.swing.ImageIcon;
 * @see javax.swing.JLabel;
 * @see javax.swing.JPanel;
 * @see javax.swing.JWindow;
 </pre>
 *****************************************************************************/
public final class CBIRSplash extends JWindow {
    private static final int RED = 255;
    private static final int GREEN = 255;
    private static final int BLUE = 255;
    private static final int SPLASH_WIDTH = 600;
    private static final int SPLASH_HEIGHT = 300;
    private final Color FONT_COLOR = new Color(102,102,102);
    private static int centerX = 0;
    private static int centerY = 0;
    
    /**************************************************************************
     * CBIRSplash constructor
     * Creates an splash screen.
     *************************************************************************/
    public CBIRSplash()
    {
        showSplash();
    }
    
    /**********************************************************************
     * showSplash - Set out the splash window
     *********************************************************************/
    public void showSplash()
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        centerX = (screen.width-SPLASH_WIDTH)/2;
        centerY = (screen.height-SPLASH_HEIGHT)/2;
        this.setBounds(centerX,centerY,SPLASH_WIDTH,SPLASH_HEIGHT);
        JPanel content = (JPanel)getContentPane();     
        content.setBackground(new Color(RED,GREEN,BLUE));
        final JLabel logo = new JLabel
            (new ImageIcon(getClass().getResource("logo/logo2.png")),
                SwingConstants.CENTER);
        final JLabel copy = new JLabel
                ("Copyright 2016", JLabel.CENTER);
        copy.setFont(new Font("Lucida Grande", 0, 12));
        copy.setForeground(FONT_COLOR);
        Color border = FONT_COLOR;
        
        content.add(logo, BorderLayout.CENTER);
        content.add(copy, BorderLayout.NORTH);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        getContentPane().add(progressBar, BorderLayout.SOUTH);
        content.setBorder(BorderFactory.createLineBorder(border, 2));
        setLocationRelativeTo(null);
    }
}  