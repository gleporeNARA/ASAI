import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class fileLister
{
	private static final int FRAME_WIDTH = 1200;		// Set the default width size to 1200
	private static final int FRAME_HEIGHT = 700;		// Set the default height size to 700
	
	public static void main(String[] args)
	{
		buttonPanel buttons = new buttonPanel();				// Creates the button panel
		//directoryPanel directory = new directoryPanel();		// Creates the directory panel
		displayArea selectFiles = new displayArea();			// Creates the display area 
		//progressBar progress = new progressBar();				// Creates the progress bar
		//countExt showFileExt = new countExt(); 				// Creates the extension and count listers
		JFrame jf = new JFrame();
		jf.getContentPane().add(buttons, BorderLayout.NORTH);	// Adds the button panel
		//jf.add(buttons);
		jf.add(selectFiles);									// Add the display area 
		//jf.add(progress);
		//jf.pack();
		//progress.iterate();
		//jf.getContentPane().add(showFileExt, BorderLayout.SOUTH);
		
		jf.setTitle("File Lister 1.0");
		jf.setIconImage(Toolkit.getDefaultToolkit().getImage(fileLister.class.getResource("dukeIcon.png")));
		jf.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}
}