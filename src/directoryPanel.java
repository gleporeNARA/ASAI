/*import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;

public class directoryPanel extends JPanel 
{
	GridBagConstraints gbc = new GridBagConstraints();
	
	public directoryPanel() 
	{
	    //super(true);
	
	    //this.setLayout(new GridLayout(1, 1, 5, 5));
		setLayout(new GridBagLayout());
	
	    JLabel label = new JLabel("[No directory selected]");
	    //label.setHorizontalAlignment(JLabel.CENTER);
	    label.setForeground(Color.red);
	    
	    JCheckBox calculate = new JCheckBox("Calculate SHA256?");
	    JCheckBox checkSubDir = new JCheckBox("Check Subdirectories?");
	
	    TitledBorder titled = new TitledBorder("Directory Options");
	    label.setBorder(titled);
	    gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 20;
		gbc.weighty = 1;
	    gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
	    add(label, gbc);
	    
	    gbc.gridx = 0;
		gbc.gridy = 0;
	    gbc.weighty = 0.2;
	    gbc.weightx = 0.2;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
	    add(calculate, gbc);
	    
	    gbc.gridx = 0;
		gbc.gridy = 0;
	    gbc.weighty = 0.2;
	    gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
	    add(checkSubDir, gbc);
	    
	 }
}*/