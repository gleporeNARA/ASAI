import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

public class buttonPanel extends JPanel
{
	JButton browse, cancel, run, createReport;				// Declare the button variables
	
	public buttonPanel()
	{
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		// Creates the Browse button
		browse = new JButton("Browse...");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 10;
		gbc.weighty = 0.1;
	    gbc.weightx = 0.1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 0, 0); // top, left, bottom, right
		add(browse, gbc);
		
		// Creates the Cancel Button
		cancel = new JButton("Cancel");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 200;
		//gbc.gridheight = 1;
		gbc.weighty = 0;
	    gbc.weightx = 0;
	    gbc.anchor = GridBagConstraints.NORTHWEST;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.insets = new Insets(5, 0, 0, 0); // top, left, bottom, right
		//gbc.anchor = GridBagConstraints.NORTHWEST;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		add(cancel, gbc);
		
		// Creates the Run Button
		run = new JButton("Run");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 100;
		gbc.gridheight = 1;
		gbc.weighty = 0;
	    gbc.weightx = 0;
	    gbc.anchor = GridBagConstraints.NORTHWEST;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.insets = new Insets(0, 5, 1, 0); // top, left, bottom, right
		//gbc.anchor = GridBagConstraints.NORTHWEST;
		add(run, gbc);
		
		// Creates the Create Report Button
		createReport = new JButton("Create Report");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 160;
		//gbc.gridheight = 1;
		gbc.weighty = 1;
	    gbc.weightx = 1;
	    gbc.anchor = GridBagConstraints.NORTHWEST;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.insets = new Insets(0, 0, 1, 0); // top, left, bottom, right
		//gbc.anchor = GridBagConstraints.NORTHWEST;
		add(createReport, gbc);	

	}
}
