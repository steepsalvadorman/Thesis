package puzzletetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuGameOver 
{
    private BufferedImage BackGround = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

    public MenuGameOver(BufferedImage Background)
    {
        this.BackGround = (Background == null) ? new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB) : Background;
    }

    public BufferedImage retBufferGame(BufferedImage Background)
    {
        BufferedImage screenbuffer = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_RGB);
        screenbuffer.getGraphics().drawImage(Background, 0, 0, screenbuffer.getWidth(), screenbuffer.getHeight(), null);
        Graphics g = screenbuffer.getGraphics();
        g.setColor(Color.black);
        Font fuente = new Font("Monospaced", Font.BOLD, 60);
        g.setFont(fuente);
        g.drawString("GAME OVER", 300, 200);
        g.drawString("1 .- RESTART", 300, 300);
        g.drawString("2 .- MENU", 300, 400);
        g.drawString("3 .- EXIT", 300, 500);
        return screenbuffer;
    }   
}
