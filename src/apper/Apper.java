
package apper;
import java.applet.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Apper extends Applet implements Runnable 
{
    int xpos =10;
    int ypos = 100;
    int dx = 1;
    int dy = 1;
    int rad = 10;
    
    private Image i;
    private Graphics dg;
  
    
    
    @Override
    public void init()
    {
        setBackground(Color.CYAN);
        setSize(500,300);
    }
    
    @Override
    public void start()
    {
        Thread thrd = new Thread(this);
        thrd.start();

    }
    
    @Override
    public void stop(){}
    
    @Override
    public void destroy(){}
    
    @Override
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while(true)
        {      
               if(xpos+dx == this.getWidth() - rad)
                 dx = -1;//Math.sin(dy);
               if(xpos == rad)
                   dx = 1;
              
               if(ypos == this.getHeight() -rad)
                 dy = -1;//Math.sin(dy);
               if(ypos == rad)
                   dy = 1;
                
               xpos+=dx;
               ypos+= dy;
               
               repaint();
               
            try {
                     Thread.sleep(5);
                }       
            catch (InterruptedException ex) 
                {
                Logger.getLogger(Apper.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
    }
    @Override
    public void update(Graphics g)
    {
        if(i == null)
        {
            i = createImage(this.getSize().width,this.getSize().height);
            dg = i.getGraphics();
        }
        
        dg.setColor(getBackground());
        dg.fillRect(0, 0, this.getSize().width, this.getSize().height);
        dg.setColor(getForeground());
        paint(dg);
        g.drawImage(i, 0, 0, this);
        
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval(xpos-rad,ypos-rad,2*rad,2*rad);
      //  g.setColor(Color.lightGray);
      //  g.fill3DRect(xpos+50, ypos+50, 100,100, true);
    
    }
  
}
