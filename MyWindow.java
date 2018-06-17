import javax.swing.JPanel;

/**
 * thank you professor for the base classes
 */
class MyWindow
{
    public static void main (String[] arg)
    {
  MyJFrame f = new MyJFrame(Constants.TITLE);

MyJButton b0 = new MyJButton(f);
//JButton b1 = new JButton("2");
//Container c = new Container();
//c.add(b0);
b0.addButtons();
JPanel c = new JPanel();
c.add(b0);
//c.add(b1);
f.add(c);
f.setBounds(150,250, 540, 450 );
   f.setVisible(true);
    }
}