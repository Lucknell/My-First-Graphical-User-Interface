
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
/**
 * thank you professor for the base classes
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucknell
 */
public class MyWhiteboard extends JFrame {
    protected int lastX,lastY;
    
    public MyWhiteboard()
    {
        super("Draw to your hearts content");
        lastX = 0;
        lastY = 0;
        Container c = getContentPane();
        c.setBackground(Color.white);
        addMouseListener(new PositionRecorder());
        addMouseMotionListener(new LineDrawer());
        setBounds(10,20,450,400);
        setVisible(true);
    }
    protected void record(int x,int y)
    {
        lastX = x;
        lastY = y;
    }
    private class PositionRecorder extends MouseAdapter
    {
        public void mouseEntered(MouseEvent e)
        {
            record(e.getX(),e.getY());
        }
        public void mousePressed(MouseEvent e)
        {
            record(e.getX(),e.getY());
        }   
    }
    private class LineDrawer extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {

            int x = e.getX();
            int y = e.getY();
            Graphics g = getGraphics();
            //g.drawLine(x, y, lastX, lastY);
			g.setColor(Color.magenta);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("wHAT JUST HAPPENED?", 225, 200);
                        record(e.getX(), e.getY());
			int x0[] = {200, 50, 200, 250};
			int y0[] = {80, 200, 120, 170};
			Polygon p = new Polygon(x0, y0, x0.length);
			g.setColor(Color.green);
			g.fillPolygon(p);
                        g.drawRect(e.getX(), e.getY(), lastX, lastY);
			int x1[] = {202, 52, 202, 252};
			int y1[] = {82, 202, 122, 172};
			Polygon p1 = new Polygon(x1, y1, x1.length);
			g.setColor(Color.black);
			g.drawPolygon(p1);
			g.setColor(Color.red);
			g.fillRect(50, 200, 175, 100);
                        g.drawLine(x, y, lastX, lastY);
            
        }
    }
}
