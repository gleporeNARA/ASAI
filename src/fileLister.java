import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTable;
//import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import javax.swing.JProgressBar;

public class fileLister extends JFrame {

	private JLabel label = new JLabel("[No directory selected]");
	private Border border = BorderFactory.createTitledBorder("Directory Options");
	private JCheckBox calculate = new JCheckBox("Calculate SHA256?");
	private JCheckBox checkSubDir = new JCheckBox("Check Subdirectories");
    private JButton browse = new JButton("Browse...");
    private JButton cancel = new JButton("Cancel");
    private JButton run = new JButton("Run");
    private JButton createReport = new JButton("Create Report");

    private JTable table = new JTable();	
    private JTable table2 = new JTable();
    //private JTextArea textArea;			// Text Area for the tables
    
    private JPanel mainPanel = new JPanel(new BorderLayout(10,10));	// Main Panel - Made up of many other panels
    private JPanel centerPanel = new JPanel(new GridLayout(2,1));   // Center Panel - Consists of two tables
    private JPanel topPanel = new JPanel(new GridLayout(1,2));		// Top Panel - button and directory panels
    private JPanel buttonPanel = new JPanel(new GridLayout(2,2));
    private JPanel dirPanel = new JPanel();
    private JPanel progressPanel = new JPanel(new GridLayout(1, 2));	
    
    public fileLister() {

        super("File Lister 1.0");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        //setResizable(false);

        setLayout(new BorderLayout(10, 10));

        // columns for the file
        String[] columns = {"File Name", "Size (bytes)", "Date Modified", 
    			"File Extension", "Full Path", "SHA-256 HASH"};
        
        // data from the files
        Object[][] data = new Object[][]{
        	{"Text Area Here", null, null, null, null, null}
        };
        
        table = new JTable(data, columns);
        centerPanel.add(new JScrollPane(table));
        
        // file extension and number of file extensions
        String[] columns2 = {"Extension", "Count"};
        Object[][] data2 = new Object[][]{
        	{"Text Area 2 Here", null}
        };
        table2 = new JTable(data2, columns2);
        centerPanel.add(new JScrollPane(table2));
        
        //panel1.add(centerPanel);

        // buttons panel
        buttonPanel.add(browse);
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              JFileChooser fileChooser = new JFileChooser();
              int returnValue = fileChooser.showOpenDialog(null);
              if (returnValue == JFileChooser.APPROVE_OPTION) 
              {
            	/* This will get the current directory.
            	 * 
            	 * File selectedFile = fileChooser.getCurrentDirectory();
            	   System.out.println(selectedFile.getName());
            	*/
            	  
            	  // This will get the full path name
            	  // selectedFile.getName() along with getSelectedFile() will get the file name
            	  
            	  //String selectedFile = fileChooser.getSelectedFile().getPath();
            	  File selectedFile = fileChooser.getSelectedFile();
            	  JOptionPane.showMessageDialog(null, "You selected " + selectedFile.getName());
              }
            }
          });
        buttonPanel.add(cancel);
        buttonPanel.add(run);
        buttonPanel.add(createReport);
        
        // dirPanel - label and the check boxes
        dirPanel.add(label);
        dirPanel.add(calculate);
        dirPanel.add(checkSubDir);
        dirPanel.setBorder(border);
        
        // top panel consists of the button panel 
        // and the directory panel
        topPanel.add(buttonPanel);
        topPanel.add(dirPanel);
        label.setForeground(Color.red);
        
        // progress bar
        JProgressBar current = new JProgressBar(0, 2000);
        int num = 0;
        
        JPanel pane = new JPanel();
        current.setValue(0);
        current.setStringPainted(true);
        pane.add(current);
        
        progressPanel.add(current);

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