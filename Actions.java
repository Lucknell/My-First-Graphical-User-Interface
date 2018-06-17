import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 * thank you professor for the base classes
 */

class Actions implements ActionListener
{
	DisplayText dt;

        @Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equalsIgnoreCase("Browser"))
		{
                    MyBrowser myBrowser = new MyBrowser();
		}
		else if (e.getActionCommand().equalsIgnoreCase("Close"))
                {
                    JOptionPane.showMessageDialog(null, "The window is closing");
                    System.exit(0);
                }
                else if (e.getActionCommand().equalsIgnoreCase("Drawing"))
                {
                    MyWhiteboard w = new MyWhiteboard();
                }
                else if (e.getActionCommand().equalsIgnoreCase("phone"))
                {  //not reachable
                   // System.out.println("ring");
                }

	}
}