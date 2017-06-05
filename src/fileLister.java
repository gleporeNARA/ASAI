import org.apache.commons.io.FileUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;

public class fileLister extends JFrame {

    private JLabel label = new JLabel("[No directory selected]");
    private Border border = BorderFactory.createTitledBorder("Directory Options");
    private JCheckBox checkSubDir = new JCheckBox("Check Subdirectories");
    private JCheckBox rowHeaders = new JCheckBox("Extract Row Headers");
	
    private JButton browse = new JButton("Browse...");
    private JButton cancel = new JButton("Cancel");
    private JButton run = new JButton("Run");
    private JButton createReport = new JButton("Create Report");

    private JTable table = new JTable();	
    private JTextArea area =new JTextArea(); 
    
    private JPanel mainPanel = new JPanel(new BorderLayout(10,10));	// Main Panel - Made up of many other panels
    private JPanel centerPanel = new JPanel(new GridLayout(2,1));   // Center Panel - Consists of two tables
    private JPanel topPanel = new JPanel(new GridLayout(1,2));		// Top Panel - button and directory panels
    private JPanel buttonPanel = new JPanel(new GridLayout(2,2));
    private JPanel dirPanel = new JPanel();
    private JPanel progressPanel = new JPanel(new GridLayout(1, 2));
    
    // test for directory selected
    File selectedFile;
    
    // testing global variable display file name
    String displayFileName;
    
    public fileLister() {

        super("File Lister 1.0");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));

        setLayout(new BorderLayout(10, 10));

        // results output window
        String[] columns = {"Paths", "File Name", "Extension", "Number of Sheets",  
        					"Sheet Titles", "Number of Rows", "Number of Columns", "Date Created",
        					"Size", "Most Used Terms", "Text and Numbers", "Special Characters"}; 
        
        // testing for defaultTableModel
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        
        // for loop to add each of the columns in the indices
        for(int i = 0; i< columns.length; i++)
        {
        	model.addColumn(columns[i]);
        }
        
        centerPanel.add(new JScrollPane(table));  
        centerPanel.add(new JScrollPane(area));
 
        // buttons panel
        buttonPanel.add(browse);
        
        // Once a user selects a directory, then it displays 
        // the directory selected onto the directory options
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	 JFileChooser fileChooser = new JFileChooser();
            	 fileChooser.setCurrentDirectory(new java.io.File("."));
            	 fileChooser.setDialogTitle("Directory Selection");
            	 fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            	 fileChooser.setAcceptAllFileFilterUsed(false);
              if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
              {
            	  
            	  selectedFile = fileChooser.getCurrentDirectory();
            	  label.setText(selectedFile.getName()); 
              }
            }
          });

        buttonPanel.add(cancel);
        buttonPanel.add(run);
        buttonPanel.add(createReport);
        
        // dirPanel - label and the check boxes
        dirPanel.add(label);
        dirPanel.add(checkSubDir);
        dirPanel.add(rowHeaders);
        
        // Once the user checks the checked box, then it will
        // display the extensions csv, xls, xlsx, and ods
        
        checkSubDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                File directories = new File(selectedFile.toString());
                String[] extensions = { "csv", " xls", "xlsx", "ods" };
               try{
                boolean recursive = true;

                Collection<File> files = FileUtils.listFiles(directories, extensions, recursive);

                for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
                  File file = (File) iterator.next();
                  displayFileName = file.getName();
                  //System.out.println("Found File: " + file.getName());
                  //area.append(displayFileName + "\n");
                  
                  //model.insertRow(0, new Object[] { displayFileName });
                }
                
                // Test for inserting into the model table
                
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
        JProgressBar current = new JProgressBar(JProgressBar.HORIZONTAL);
        
        // sets up action listener for the run button
        run.addActionListener(new ActionListener() {
        	
        	/*
        		Reusing the same code from check sub directories for testing as of now
        	*/
            public void actionPerformed(ActionEvent ae) {
	            // indeterminable progress bar
		        current.setIndeterminate(true);
            	
                File directories = new File(selectedFile.toString());
                //String[] extensions = { "csv", " xls", "xlsx", "ods" };
                
                // A test for only .csv files
                String[] extensions = { "csv" };
               try{
                boolean recursive = true;

                Collection<File> files = FileUtils.listFiles(directories, extensions, recursive);

                for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
                  File file = (File) iterator.next();
                  displayFileName = file.getName();
                  //System.out.println("Found File: " + file.getName());
                  area.append("Currently processing file " + displayFileName + " ...\n\n");
                  
                  // Paths - Getting the sub directories
                  
/*                  String[] names = selectedFile.list();

                  for(String name : names)
                  {
                      if (selectedFile.isDirectory())
                      {
                          System.out.println(name);
                      }
                  }*/
                  
                  
                  // Test for getting the file extension
                  String fileExtension=" ";
                  if(displayFileName.contains(".") && displayFileName.lastIndexOf(".")!= 0)
                  {
                  	fileExtension = displayFileName.substring(displayFileName.lastIndexOf(".")+1);
                  }            
                  
                  // Test for reading the number of rows
                  BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                  String input;
                  int count = 0;
                  while((input = bufferedReader.readLine()) != null)
                  {
                      count++;
                  }
                  
                  // Object for formatting the date
                  SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-dd");
                  
                  // Most used term
      			StringBuilder str = new StringBuilder();
    			
    			BufferedReader in = new BufferedReader(new FileReader(file));
    			String inputLine;
    	
    			while ((inputLine = in.readLine()) != null)
    			{
    				// Appends the whole string together and adds 
    				// a comma, needed for splitting for csv files
    				str.append(inputLine + ",");
    			}
    			
    			String completeString = str.toString();
    			   
    			in.close();
    			    
    			Map<String, Integer> map = new HashMap<String,Integer>();				// Map to store the keys and values	
    			ValueComparator bvc =  new ValueComparator(map);						// Compares the values against each other
    			TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);	// TreeMap sorts the keys in alphabetic order
    			
    			// Splits certain characters except for a period 
    			String[] words = completeString.split("[^.\\w]");
    			for (int i = 0; i < words.length; i++) {
    				// Replaces all of the numeric characters in order 
    				// for words to only appear on the list
    				String key = words[i].replaceAll("[^A-Za-z]", "");	
    				if (key.length() > 0) {
    					if (!map.containsKey(key)) {
    						map.put(key, 1);
    				        }
    				    else {
    				    	int value = map.get(key);
    				        map.put(key, ++value);
    				    }
    				}
    			}

    			sorted_map.putAll(map);
    			List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(sorted_map.entrySet());
    			String list = null;
    			for (Map.Entry<String, Integer> entry : entryList.subList(0, 10)) {
    			    list = entry.getKey();
    			    
    			    // Prints out the top ten terms
    			    // System.out.println(list);
    			}
                  /*
                   *  Minor bugs:
                   *  - paths currently does not have an array of sub directories
                   *  - date created column gets the last modified date
                   *  - IndexOutOfBoundsException for the ArrayList entryList for the top 10 terms,
                   *    however, it displays the top ten terms in the table
                   */
                  model.insertRow(0, new Object[] { selectedFile, displayFileName, fileExtension, " ", " ", count, " ", 
                		  date.format(file.lastModified()), file.length(), entryList.subList(0, 10) });
                }
                
               } catch (Exception e) {
            	   e.printStackTrace();
               }
            }
        });
        
        JPanel pane = new JPanel();
        pane.add(current);  
        
        progressPanel.add(current);

        mainPanel.add(topPanel, BorderLayout.NORTH);			
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(progressPanel, BorderLayout.SOUTH);
        
        // adding empty spaces from the outer linings
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
        add(mainPanel);
    }
   
    // ValueComparator class in order to compare each term in the top 10 most used terms
    class ValueComparator implements Comparator<String> {

        Map<String, Integer> base;
        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        // Compares the values of the values within the TreeMap
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } 
        }
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
