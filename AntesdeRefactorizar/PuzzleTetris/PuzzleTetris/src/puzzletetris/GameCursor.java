package puzzletetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GameCursor
{
    private int posX=0;
    private int posY=0;
    private int mode=0;
    private BufferedImage BufferNormal;
    private BufferedImage BufferChange;
    
    public int getPosX(){return posX;}
    public int getPosY(){return posY;}
    public int getMode(){return mode;}
    
    public BufferedImage getBuffer()
    {
        BufferedImage normal=new BufferedImage(10,10,BufferedImage.TYPE_INT_ARGB);
        switch(mode)
        {
            case 1:normal = BufferNormal; break;
            case 2:normal = BufferChange; break; 
            case 3:normal = new BufferedImage(10,10,BufferedImage.TYPE_INT_ARGB);break;
        }
        return normal;
    }
    
    public void setPosX(int posX){this.posX=posX;}
    public void setPosY(int posY){this.posY=posY;}
    public void setMode(int mode){this.mode=mode;}
       
    abstract class Special
    {
        public abstract void run();
    }
    
    public GameCursor()
    {
        mode=1;
        try
        {
            BufferNormal=ImageIO.read(new File("images//cursor.PNG"));
            BufferChange=ImageIO.read(new File("images//cursorinv.PNG"));
        } catch(Exception ex)
        {
            
        }
    }
}
