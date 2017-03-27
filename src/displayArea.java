import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class displayArea extends JPanel
{
	JTable table;
	
	public displayArea() 
    {
		//setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		String[] columnNames = {"File Name", "Size (bytes)", "Date Modified", 
								"File Extension", "Full Path", "SHA-256 HASH"};
        
    	GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
      	gbc.gridy = 0;
      	gbc.ipadx = 0;
      	gbc.ipady = 300;
      	gbc.weighty = 1;
      	gbc.weightx = 1;
      	gbc.anchor = GridBagConstraints.NORTH;
      	gbc.insets = new Insets(0, 5, 0, 5); 		// positions: top, left, bottom, right
      	gbc.fill = GridBagConstraints.HORIZONTAL;
      
        // Testing by inputting data manually
        Object[][] data = {
				{ "Topic_list.txt", "27,500", "03/24/2017", ".txt", "C:\\Users\\kphan\\Downloads", null},
        };
 
    	table = new JTable(data, columnNames);
    	table.setPreferredScrollableViewportSize(new Dimension(1000, 20));
    	table.setFillsViewportHeight(true);
    	
    	JScrollPane scrollPane = new JScrollPane(table);
    	add(scrollPane, gbc);
    }
	
	
}
