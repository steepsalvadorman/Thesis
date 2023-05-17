
package puzzletetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuStart 
{
    private BufferedImage BackGround=new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);

    public MenuStart(){ }

    public BufferedImage retBufferGame()
    {
        BufferedImage screenbuffer = new BufferedImage(1000,700,BufferedImage.TYPE_INT_RGB);
        screenbuffer.getGraphics().drawImage(BackGround,0,0, screenbuffer.getWidth(), screenbuffer.getHeight(), null);
        Graphics g = screenbuffer.getGraphics();
        g.setColor(Color.WHITE);
        Font fuente=new Font("Monospaced", Font.BOLD, 60);
        g.setFont(fuente);
        g.drawString("PUZZLE TETRIS", 300, 200);
        g.drawString("1 .- START", 300, 300);
        g.drawString("2 .- OPTIONS", 300, 400);
        g.drawString("3 .- EXIT", 300, 500);
        return screenbuffer;
    }
}
