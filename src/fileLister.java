/*
    Create a basic GUI that allows the user to select a directory to process,
    with option for recursion into lower directories. The GUI will have, at least,
    the following buttons and options:

    Browse...
    Run
    Cancel
    Create report
    An output window for displaying process information
    A progress bar showing progress through files and directories
    A display area for selected directory
*/
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame; 
import javax.swing.JButton;   

public class fileLister
{  
    public static void main(String[] args) 
    {  
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
        
        JButton browse = new JButton("Browse..."); 
        browse.setBounds(0,0,screenSize.width/4,40);                    // x axis, y axis, width, height 
        
        JButton cancel = new JButton("Cancel"); 
        cancel.setBounds(screenSize.width/4,0,screenSize.width/4,40);    
        
        JButton run = new JButton("Run"); 
        run.setBounds(0,40,screenSize.width/4,40);                    
         
        JButton createReport = new JButton("Create Report"); 
        createReport.setBounds(screenSize.width/4,40,screenSize.width/4,40);                    
        
        // Adds the following buttons         
        frame.add(browse);
        frame.add(cancel);
        frame.add(run);
        frame.add(createReport);                                                   
        
        frame.setSize(650, 650);                       // 650 width and 650 height              
        frame.setLayout(null);                         // This contains no layout managers                                         
        frame.setVisible(true);                        // Allow to display a visible frame                         
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set default screen to fullscreen
        frame.setUndecorated(true);
        
        // Create an output window for displaying process information
        
        
        
        // Create a progress bar showing progress through files and directories
        
        
        
        // Create a display area for selected directory
    }  
    
    /*
     public static void createButtons()
     {
       
     }
     */
     
     /*
     public static void addButtons()
     {
     
     }
     */
     
     /* Allows the user to select a directory to process,
        with option for recursion into lower directories

     public static void selectFile()
     {
         selectFile();
     }
     */
}  
