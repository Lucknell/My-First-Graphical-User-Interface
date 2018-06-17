import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Container;

public class DisplayText
{
   private static JTextArea text;
   int x;
   String s;
         

   public DisplayText( String title, String info)
   {
		MyJFrame f = new MyJFrame(title);
		Container c = f.getContentPane();

		text = new JTextArea(info);

		JScrollPane sp = new JScrollPane(text);
		c.add( sp );

      	f.setBounds(100,200, 500, 400 );
	   	f.setVisible(true);
                
   }
   
   public String selectText()
   {
       return text.getText();
   }
   public void insertText(int x, String s)
   {
   }
}