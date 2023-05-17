package puzzletetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GameModeSinglePlayer
{
    private GameBoard board;
    boolean isGameOver = false;
    private BufferedImage BackGround = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
    private GameCursor cursor = new GameCursor();
    GameConfiguration options = new GameConfiguration();    
    public GameBoard getGameBoard(){ return board; }    
    public GameCursor getCursor(){ return cursor; }
    
    public GameModeSinglePlayer()
    {
        try
        {
            switch(options.confAtributes.difficult)
            {
                case 1: board = new GameBoard(6,15, cursor);                    
                        board.setTimeGenerateBF(40);
                break;
                case 2: board = new GameBoard(6,12, cursor);
                        board.setTimeGenerateBF(30);
                break;
                case 3: board = new GameBoard(6,10, cursor);
                        board.setTimeGenerateBF(20);
                break;
                default: board = new GameBoard(6,15, cursor);
                         board.setTimeGenerateBF(40);
                break; 
            }            
            BackGround = ImageIO.read(new File("images//background.png"));
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public BufferedImage retBufferGame()
    {
        return retBufferBoard(true);
    }
   
    public BufferedImage retBufferStatic()
    {
        return retBufferBoard(false);
    }
    
    public BufferedImage retBufferBoard(Boolean move)
    {
        BufferedImage screenbuffer = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_RGB);
        Graphics g = screenbuffer.getGraphics();
        g.drawImage(BackGround, 0, 0, screenbuffer.getWidth(), screenbuffer.getHeight(), null);
        g.drawImage(move ? getGameBoard().progressGame() : getGameBoard().BoardBuffer(), 80, 80, screenbuffer.getWidth() - 400, screenbuffer.getHeight() - 100, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospaced", Font.BOLD, 60));
        g.drawString("SCORE", 750, 200); 
        g.drawString("" + board.getScore(), 750, 260);
        g.drawString("RECORD", 750, 600); 
        g.drawString("" + (board.getScore() > options.confAtributes.HiScore ? board.getScore() : options.confAtributes.HiScore), 750, 660);        
        if(board.getCombo() > 1)
        {
            g.drawString("COMBO", 700, 350); 
            g.drawString("" + board.getCombo(), 750, 420);
        }
        isGameOver = board.IsGameOver();
        return screenbuffer;        
    }
}