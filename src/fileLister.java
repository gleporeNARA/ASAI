import org.apache.commons.io.FileUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.util.Collection;
//import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import javax.swing.JProgressBar;

//import java.security.MessageDigest;
import javax.swing.table.DefaultTableModel;

public class fileLister extends JFrame {

    private JLabel label = new JLabel("[No directory selected]");
    private Border border = BorderFactory.createTitledBorder("Directory Options");
    //private JCheckBox calculate = new JCheckBox("Calculate SHA256?");
    private JCheckBox checkSubDir = new JCheckBox("Check Subdirectories");
    private JCheckBox rowHeaders = new JCheckBox("Extract Row Headers");
    private JButton browse = new JButton("Browse...");
    private JButton cancel = new JButton("Cancel");
    private JButton run = new JButton("Run");
    private JButton createReport = new JButton("Create Report");

    private JTable table = new JTable();	
    private JTextArea area =new JTextArea("Process xxx amount of directories...\n\n"
    					 + "Processing file number 1 out of 1,000 files...\n\n"
    					 + "Currently processing file MotionLamp.csv..."); 
    //private JTable table2 = new JTable();
    //private JTextArea textArea;			// Text Area for the tables
    
    private JPanel mainPanel = new JPanel(new BorderLayout(10,10));	// Main Panel - Made up of many other panels
    private JPanel centerPanel = new JPanel(new GridLayout(2,1));   // Center Panel - Consists of two tables
    private JPanel topPanel = new JPanel(new GridLayout(1,2));		// Top Panel - button and directory panels
    private JPanel buttonPanel = new JPanel(new GridLayout(2,2));
    private JPanel dirPanel = new JPanel();
    private JPanel progressPanel = new JPanel(new GridLayout(1, 2));
    
    
 /* static final int MY_MINIMUM = 0;		// Set the minimum value of progress bar to zero
    static final int MY_MAXIMUM = 100;		// Set the maximum value of progress bar to one hundred
*/    
    // data for the file lister
/*    private JLabel fileName;
    private JTextField path;
    private JLabel date;
    private JLabel size;*/
    
    public fileLister() {

        super("File Lister 1.0");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        //setResizable(false);

        setLayout(new BorderLayout(10, 10));

        // results output window
        String[] columns = {"File Name", "File Path", "File Extension", "Number of Sheets",  
        					"Sheet Names", "Rows", "Columns", "File Size", "Date Created"}; 
        					//, "SHA-256 HASH"};
        
        // data from the files
/*        Object[][] data = new Object[][]{
        	{null, null, null, null, null, null, null, null, null}//, null}
        };*/
        
        // testing for defaultTableModel
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        
        // for loop to add each of the columns in the indices
        for(int i = 0; i< columns.length; i++)
        {
            model.addColumn(columns[i]);
        }
       // model.addColumn("Col2");

        // Create the first row
        model.insertRow(0, new Object[] { "Inserts a Row" });
        
        // Insert a row at position p
        int p = 1;
        model.insertRow(p, new Object[] { "Position Insert" });
        
        
        // Displaying the tables into the center
        //table = new JTable(data, columns);
        //table = new JTable();
        centerPanel.add(new JScrollPane(table));
        
        // processing output window
/*        String[] columns2 = {"Process 20 directory", "Processing file number 1 out of 1,000 files", "Currently processing file file.csv"};
        Object[][] data2 = new Object[][]{
        	{null, null, null}
        };*/
        
        // test for processing a csv file
        String csvFile = "C:/Users/kphan/Documents/MotionLamp.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] columnTest = line.split(cvsSplitBy);

                System.out.println("[ " + columnTest[3] + " , " + columnTest[4] + "]");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //table2 = new JTable(data2, columns2); 
        centerPanel.add(new JScrollPane(area));
        
        //panel1.add(centerPanel);

        // buttons panel
        buttonPanel.add(browse);
        
        // Once a user selects a directory, then it displays 
        // the directory selected onto the directory options
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
/*              JFileChooser fileChooser = new JFileChooser();
              int returnValue = fileChooser.showOpenDialog(null);*/
            	 JFileChooser fileChooser = new JFileChooser();
            	 fileChooser.setCurrentDirectory(new java.io.File("."));
            	 fileChooser.setDialogTitle("Directory Selection");
            	 fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            	 fileChooser.setAcceptAllFileFilterUsed(false);
              //if (returnValue == JFileChooser.APPROVE_OPTION)
              if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
              {
            	/* This will get the current directory.
            	 * 
            	 * File selectedFile = fileChooser.getCurrentDirectory();
            	   System.out.println(selectedFile.getName());
            	*/
            	  
            	  // This will get the full path name
            	  // selectedFile.getName() along with getSelectedFile() will get the file name
            	  
            	  //String selectedFile = fileChooser.getSelectedFile().getPath();
            	  File selectedFile = fileChooser.getCurrentDirectory();
            	  label.setText(selectedFile.getName()); 
            	 
            	  //JOptionPane.showMessageDialog(null, "You selected " + selectedFile.getName());
            	  /*File file = Chooser.getSelectedFile();
            	  textField.setText(file.getAbsolutePath())*/
              }
            }
          });
        
        // Test - Print out the metadata when a file is selected
/*        File f = new File("Topic_List.txt");
        
        // File Name
        System.out.println("File Name: " +  f.getName());
        
        // Size (bytes)
        System.out.println("Size (bytes): " + f.length() + " bytes");
        
        // Data Modified
        System.out.println("Date Modified: " + new Date(f.lastModified()).toString());
        
        // File extension
        String fileExtension=" ";
        String fileName=f.getName();
        if(fileName.contains(".") && fileName.lastIndexOf(".")!= 0)
        {
        	fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
        }
        System.out.println("File Extension: " + fileExtension);
        
        // Full Path 
        String absolutePath = f.getAbsolutePath();
        System.out.println("Full Path: " + absolutePath);
        
        // SHA-256 HASH
        System.out.println("SHA-256 HASH: ");*/

        buttonPanel.add(cancel);
        buttonPanel.add(run);
        buttonPanel.add(createReport);
        
        // dirPanel - label and the check boxes
        dirPanel.add(label);
        //dirPanel.add(calculate);
        dirPanel.add(checkSubDir);
        dirPanel.add(rowHeaders);
        
        // Once the user checks the checked box, then it will
        // display the extensions csv, xls, xlsx, and ods
        
        checkSubDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                File root = new File("c:\\Users\\kphan");
                //String fileName = "a.txt";
                String[] extensions = { "csv", " xls", "xlsx", "ods" };
               try{
                boolean recursive = true;

                Collection files = FileUtils.listFiles(root, extensions, recursive);

                for (Iterator iterator = files.iterator(); iterator.hasNext();) {
                  File file = (File) iterator.next();

                  System.out.println("Found File: " + file.getName());
                }
               } catch (Exception e) {
            	   e.printStackTrace();
               }
            }
        });
        dirPanel.setBorder(border);
        
        // top panel consists of the button panel 
        // and the directory panel
        topPanel.add(buttonPanel);
        topPanel.add(dirPanel);
        label.setForeground(Color.red);
        
        // progress bar
        //JProgressBar current = new JProgressBar(0, 2000);
        JProgressBar current = new JProgressBar(JProgressBar.HORIZONTAL);
        run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	        //JProgressBar current = new JProgressBar(JProgressBar.HORIZONTAL);
	        current.setIndeterminate(true);
            }
        });
        //int num = 0;

        JPanel pane = new JPanel();
        //current.setValue(0);
        //current.setStringPainted(true);
        pane.add(current);
        
        // loads the percentages for progress bar
/*        public void iterate(){ 
  		 while (num < 2000) {
            current.setValue(num);
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            num += 95;
          }
    }*/
        
        progressPanel.add(current);
        
        /*checkSubDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	while (num < 2000) {
            		JProgressBar current = new JProgressBar(0, 2000);
                    int num = 0;
                    
                    JPanel pane = new JPanel();
                    current.setValue(0);
                    current.setStringPainted(true);
                    pane.add(current);
            	      current.setValue(num);
            	      try {
            	        Thread.sleep(1000);
            	      } catch (InterruptedException e) {
            	      }
            	      num += 95;
            	    }
            	while (num < 2000) {
            		JProgressBar current = new JProgressBar(0, 2000);
                    int num = 0;  
            	
            }*/
        //});

        mainPanel.add(topPanel, BorderLayout.NORTH);			
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(progressPanel, BorderLayout.SOUTH);
        
        // adding empty spaces from the outer linings
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	fileLister app = new fileLister();
                app.setVisible(true);
            }
        });
    }
}
