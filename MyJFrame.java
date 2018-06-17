/*
Adding action event to menuitems.
*/
/**
 * thank you professor for the base classes
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class MyJFrame extends JFrame
{
    JMenuBar menubar;
    JMenu f, submenu;
    JMenuItem mi;
    JCheckBoxMenuItem cb;
    JToggleButton rb;
    BasicFile t;
    JTextArea jta,jta2;
    JScrollPane jsp,jsp2;
    MyJFrame frame;
    String z = "empty";

    public MyJFrame(String title)
    {
            super(title);

            // The menubar is invisible
            menubar = new JMenuBar();
            setJMenuBar(menubar);
           //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            buildMenu();
    }

    @SuppressWarnings("empty-statement")
    void buildMenu()
    {
        for (int i = 0; i < Constants.MENU.length; i++)
            {	//Build and add each menu choice onto the menubar
                
                f = new JMenu(Constants.MENU[i]);
                switch(i)
                {
                    case 0:
                        for (int j = 0; j < Constants.ITEMS.length; j++)
                            if (Constants.ITEMS[j].equals("-"))
                                    f.addSeparator();
                            else
                            {
                                f.add(mi = new JMenuItem(Constants.ITEMS[j]));
                                 
                                mi.addActionListener(new ActionListener()
                                        {
                                           public void actionPerformed(ActionEvent e)
	   			{
	   			  if (e.getActionCommand().equalsIgnoreCase("New"))
                                  {
                                      frame = new MyJFrame("New File");
                                      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                                      int height = screenSize.height * 2 / 6;
                                        int width = screenSize.width * 2 / 6;
                                         jta = new JTextArea(null,height,width);
                                        JScrollPane jsp = new JScrollPane (jta);
                                        frame.add(jsp);
                                      // set the jframe height and width
                                      frame.setSize(new Dimension(width, height));
                                      frame.setVisible(true);
                                  }
                                  if (e.getActionCommand().equalsIgnoreCase("Open"))
                                  {
                                         try {
                                             t = new BasicFile();
                                         } catch (FileNotFoundException ex) {
                                             Logger.getLogger(MyJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                         }
                                        JOptionPane.showMessageDialog(null,"Name: "
                                               +t.getName() + " \nSize: "
                                               +t.getFileSize()
                                               +" \nLocation: "+ t.getPath());
                                       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                                      int height = screenSize.height * 2 / 5;
                                        int width = screenSize.width * 2 / 5;
                                       String y = null;
                                       y = t.getContent();
                                      MyJFrame open = new MyJFrame(t.getName());
                                       jta2 = new JTextArea(y);
                                       jsp2 = new JScrollPane (jta2);
                                      open.add(jsp2); 
                                      open.setSize(new Dimension(width, height));
                                      open.setVisible(true);
                                     
                                  }
                                  if(e.getActionCommand().equalsIgnoreCase("Save"))
                                  {
                                      BufferedWriter out = null;
                                         try {
                                             out = new BufferedWriter(new FileWriter(t.getPath()+".sac"));
                                         } catch (IOException ex) {
                                             Logger.getLogger(MyJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                         }
                                         try {
                                             out.write(jta.getText());
                                         } catch (IOException ex) {
                                             Logger.getLogger(MyJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                         }
                                  }
                                  if(e.getActionCommand().equalsIgnoreCase("Close"))
                                  {
                                    System.exit(0);
                                  }
                                

	   			}
                                
                                        });
                             }
                    break;
                    case 1:
                           for (int j = 0; j < Constants.TOOL.length; j++)
                            if (Constants.TOOL[j].equals("Edit"))
                            {
                                    submenu = new JMenu("Edit");
                            }
                            else
                            {
                                f.add(mi = new JMenuItem(Constants.TOOL[j]));
                                mi.addActionListener(new ActionListener()
                                   {
                                    public void actionPerformed(ActionEvent e)
	   			{
                                    if(e.getActionCommand().equalsIgnoreCase("Copy"))
                                    {
                                      //z = jta.getSelectedText();
                                      JOptionPane.showMessageDialog(null, "This "
                                              + "option isn't working properly\n"
                                              + " try Ctrl + C instead!");
                                    }    
                                    if(e.getActionCommand().equalsIgnoreCase("Paste"))
                                    {
                                      //jta.insert(z, jta.getCaretPosition());
                                      JOptionPane.showMessageDialog(null, "This "
                                              + "option isn't working properly\n"
                                              + " try Ctrl + V instead!");
                                    }
                                }});
                                
                             }
                           for (int j = 0; j < Constants.EDIT.length; j++)
                            if (Constants.EDIT[j].equals("-"))
                                    f.addSeparator();
                            else
                            {
                                submenu.add(mi = new JMenuItem(Constants.EDIT[j]));

                                   mi.addActionListener(new ActionListener()
                                   {
                                     public void actionPerformed(ActionEvent e)
	   			{
                                    if(e.getActionCommand().equalsIgnoreCase("Copy"))
                                    {
                                      //z = jta.getSelectedText();
                                      JOptionPane.showMessageDialog(null, "This "
                                              + "option isn't working properly\n"
                                              + " try Ctrl + C instead!");
                                    }    
                                    if(e.getActionCommand().equalsIgnoreCase("Paste"))
                                    {
                                      //jta.insert(z, jta.getCaretPosition());
                                      JOptionPane.showMessageDialog(null, "This "
                                              + "option isn't working properly\n"
                                              + " try Ctrl + V instead!");
                                    }
                                }});
                             }
                           f.add(submenu);
                    break;
                        
                }
                menubar.add(f);
            }
    }
}