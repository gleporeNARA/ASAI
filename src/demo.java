import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class demo extends JFrame
{
	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 700;
	private JButton button1, button2, button3, button4;
	private JPanel container;
	private JPanel panel;
	private JPanel panel2;
	private JTable table;
	
	
	public demo()
	{
		setTitle("File Lister Demo");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//setLayout(new GridLayout(4,2));
		buildButtons();
		//buildDirectoryOptions();
		add(panel);
		setVisible(true);
/*		add(panel2);
		panel2.setVisible(true);*/
		
	}
	
	private void buildButtons()
	{
		/*JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel panel2 = new JPanel(new BorderLayout());

		//panel1.set[Preferred/Maximum/Minimum]Size()
		
		//container.add(panel);				// NullPointerException
		container.add(panel2);*/
		
		button1 = new JButton("Browse");
		button2 = new JButton("Cancel");
		button3 = new JButton("Run");
		button4 = new JButton("Create Report");
		
		panel = new JPanel(new FlowLayout());
		//setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		add(button1);
		button1.addActionListener(new ActionListener() {
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
            	  //System.out.println(selectedFile);
                
              /*
               *  if (result == JFileChooser.APPROVE_OPTION)
			        {
			            String filename = fileChooser.getSelectedFile().getPath();
			            JOptionPane.showMessageDialog(null, "You selected " + filename);
			        }
			        else if (result == JFileChooser.CANCEL_OPTION)
			        {   
			            //JOptionPane.showMessageDialog(null, "You selected nothing.");
			        }
			        else if (result == JFileChooser.ERROR_OPTION)
			        {
			            JOptionPane.showMessageDialog(null, "An error occurred.");  
			               */
              }
            }
          });
		add(button2);
		JLabel label = new JLabel("[No directory selected]");
	    //label.setHorizontalAlignment(JLabel.CENTER);
	    label.setForeground(Color.red);
	    
	    JCheckBox calculate = new JCheckBox("Calculate SHA256?");
	    JCheckBox checkSubDir = new JCheckBox("Check Subdirectories?");
	
	    //TitledBorder titled = new TitledBorder("Directory Options");
	    
	    
	    //panel.add(label);
	    //GridBagConstraints gbc = new GridBagConstraints();
	    panel.add(label);
	    panel.add(calculate);
	    panel.add(checkSubDir);
	    
	    
	    Border border = BorderFactory.createTitledBorder("Directory Options");
	    panel.setBorder(border);
	    
	    //JPanel panel = new JPanel(new GridLayout(0, 1));
	    
	    
		add(button3);
		add(button4);
		
		String[] columnNames = {"File Name", "Size (bytes)", "Date Modified", 
				"File Extension", "Full Path", "SHA-256 HASH"};
		
		Object[][] data = {
				{ "Topic_list.txt", "27,500", "03/24/2017", ".txt", "C:\\Users\\kphan\\Downloads", null},
        };
		
		//JPanel panel2 = new JPanel(new BorderLayout());
		table = new JTable(data, columnNames);
    	table.setPreferredScrollableViewportSize(new Dimension(1000, 20));
    	table.setFillsViewportHeight(true);
    	
    	JScrollPane scrollPane = new JScrollPane(table);
    	panel.add(scrollPane);
    	
    	/*JPanel container = new JPanel();
    	container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

    	JPanel panel1 = new JPanel();
    	JPanel panel2 = new JPanel();

    	//panel1.set[Preferred/Maximum/Minimum]Size()

    	container.add(panel1);
    	container.add(panel2);
		*/
		
		
	}
	
/*	private void buildDirectoryOptions()
	{
		testButton = new JButton("test");
		panel2 = new JPanel();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setBorder(BorderFactory.createTitledBorder("Toppings"));
		panel2.add(testButton);
	}*/
	
	public static void main(String args[])
	{
		new demo();
		//JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File("E:\\"));
        //fileChooser.setSelectedFile(new File("README.html"));

        //int result = fileChooser.showOpenDialog(null);
	}
}

