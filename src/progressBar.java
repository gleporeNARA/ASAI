/*
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class progressBar extends JPanel {
  JProgressBar current = new JProgressBar(0, 2000);
  int num = 0;
  public progressBar() {
    JPanel pane = new JPanel();
    current.setValue(0);
    current.setStringPainted(true);
    pane.add(current);
    //setContentPane(pane);
  }

  public void iterate() 
  {
    while (num < 2000) {
      current.setValue(num);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      num += 95;
    }
  }
}*/