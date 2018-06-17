/* Demo
	This class adds buttons and images to the GUI. We make use of the GridBagLayout,
	GridBagConstraints, Insets, and Image classes from awt to lay out each item
	From the swing package, JButton and ImageIcon
*/
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Container;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
/**
 * thank you professor for the base classes
 */

public class MyJButton extends JButton
{
    	MyJFrame f;
        JButton button;    
	MyJButton(MyJFrame f)
	{
		this.f = f;
	}

	public void addButtons()
	{
	    JButton b;
           
		Container c = f.getContentPane();

		// Places components in a grid of rows & columns
		GridBagLayout gbag = new GridBagLayout();
		c.setLayout(gbag); // Layout each component

		// Specify the constraints for each component
		GridBagConstraints constraints = new GridBagConstraints();



		for (int i = 0; i < Constants.BUTTON.length; i++)
	    {
			b = new JButton(Constants.BUTTON[i]);
			switch(i)
			{
				case 0:
					// Specify the (x,y) coordinate for this component
					constraints.gridx = 0;
					constraints.gridy = 0; // (x,y) = (0,0)
 					constraints.insets = new Insets(0,100,0,0);
 				break;

				case 1:
						constraints.gridx = 1;
						constraints.gridy = 0;
						constraints.weighty = 1.0;
    					constraints.weightx = 1.0;

				break;

				case 2:
						b = new JButton(new ImageIcon(Constants.BUTTON[i]));// Add image
						constraints.gridx = 0;
						constraints.gridy = 1;
					constraints.insets = new Insets(10,20,50,100);
				break;
				case 3:
						constraints.gridx = 1;
						constraints.gridy = 1;
				break;

				default: break;
			}
			gbag.setConstraints(b, constraints);
		    c.add(b);
		    b.addActionListener(new Actions());
		 }
 	}
}