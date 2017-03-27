/*import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class countExt extends JPanel
{
	JTable table2;
	
	public countExt() 
    {
		//setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		String[] columnNames = {"Extension", "Count"};
        
    	GridBagConstraints gbc2 = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gbc2.gridx = 1;
      	gbc2.gridy = 1;
      	gbc2.ipadx = 0;
      	gbc2.ipady = 100;
      	gbc2.weighty = 1;
      	gbc2.weightx = 1;
      	gbc2.anchor = GridBagConstraints.SOUTH;
      	gbc2.insets = new Insets(0, 5, 0, 5); // top, left, bottom, right
      	gbc2.fill = GridBagConstraints.HORIZONTAL;
       
        //actual data for the table in a 2d array
        
        Object[][] data = {
				{null, null}
		};
 
    	table2 = new JTable(data, columnNames);
    	table2.setPreferredScrollableViewportSize(new Dimension(1000, 20));
    	table2.setFillsViewportHeight(true);
    	
    	JScrollPane scrollPane2 = new JScrollPane(table2);
    	add(scrollPane2, gbc2);
    }
	
	
}
*/