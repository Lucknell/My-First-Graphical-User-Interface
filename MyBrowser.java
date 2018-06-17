import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.IOException;
/**
 * thank you professor for the base classes
 */
public class MyBrowser
{
	MyJFrame frame;
	JTextField enter;
	JEditorPane contents;
	
	public MyBrowser()
	{
		frame = new MyJFrame("My Browser");
		Container c = frame.getContentPane();
		
		enter = new JTextField("http://");
		
		enter.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										getThePage(e.getActionCommand());
									}
								});
		c.add(enter, BorderLayout.NORTH);
		
		contents = new JEditorPane();
		
		contents.setEditable(false);
		
		contents.addHyperlinkListener(new HyperlinkListener()
										{
											public void hyperlinkUpdate(HyperlinkEvent e)
											{
												if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
												{
													getThePage(e.getURL().toString());
												}
											}
										});
										
	  c.add( new JScrollPane( contents ), BorderLayout.CENTER );
	
		//JScrollPane sp = new JScrollPane();
		
		//sp.add(contents);
		//c.add(sp,BorderLayout.CENTER);
		
		frame.setSize(500,500);
		frame.setVisible(true);
		//c.setVisible(true);
		//contents.setVisible(true);
	}
	
	public void getThePage(String loc)
	{
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		try
		{
			contents.setPage(loc);
			enter.setText(loc);
		}
		catch(IOException io)
		{
			JOptionPane.showMessageDialog(null, "Error Cannot Access Specfied URL", "Bad URL", JOptionPane.ERROR_MESSAGE); 
		}
		frame.setCursor(Cursor.getDefaultCursor());
	}
}