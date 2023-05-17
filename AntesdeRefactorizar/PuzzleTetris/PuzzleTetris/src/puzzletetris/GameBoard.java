package puzzletetris;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class GameBoard 
{
    private GameBlock[][] gameblocks;
    private ArrayList<GameBlockFalling> falls = new ArrayList<>();
    private ArrayList<GameBlockFalling> nexts = new ArrayList<>();
    private BufferedImage panels[];
    private BufferedImage background;
    private int totalpanels = 5;
    private int width = 6;
    private int height = 15;
    private GameCursor playercursor;
    private GameMechanics gm;
    private int score = 0;
    private int combo = 0;
    private boolean isGameOver = false;
    private int countGenerateBF = 0;
    private int timeGenerateBF = 40;
    private int[] positionBF = new int[]{0, 2, 4};
    private boolean wait = false;
    
    public int getTotalPanels(){ return totalpanels; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
    public int getScore(){ return score; }
    public int getCombo(){ return combo; }
    public boolean IsGameOver() { return isGameOver; }
    public void setGameOver(){ isGameOver = true; }
    public void setTimeGenerateBF(int timeGenerateBF){ this.timeGenerateBF = timeGenerateBF; }
    
    public GameBlock[][] getGameblocks(){ return this.gameblocks; }
    
    public void changeBlock(int x, int y, int directionX, int directionY)
    {
        gm.changeBlock(x, y, directionX, directionY);
    }
    
    public GameBoard(int width, int height, GameCursor playercursor)
    {
        this.playercursor = playercursor;
        this.width = width;
        this.height = height;
        background = new BufferedImage(150, 450, BufferedImage.TYPE_INT_RGB);
        background.getGraphics().drawRect(0, 0, background.getWidth(), background.getHeight());    
        try
        {
            background = ImageIO.read(new File("images//backgroundboard.png"));
        }catch(Exception ex)
        {
        }   
        //LOAD COLOR PANELS
        panels = new BufferedImage[totalpanels + 1];
        for(int l = 0; l <= totalpanels; l++)
        {
            try
            {
                panels[l] = ImageIO.read(new File("images//panel" + (l) + ".PNG"));
            }catch(Exception ex)
            {
                panels[l] = new BufferedImage(150, 450, BufferedImage.TYPE_INT_RGB);ex.printStackTrace();
            }
        }        
        //LOAD BLOCKS
        gameblocks = new GameBlock[width][height];
        for(int l = 0; l < gameblocks.length; l++)
        {
            for(int m = 0; m< gameblocks[l].length; m++)
            {
                gameblocks[l][m] = new GameBlock();
                gameblocks[l][m].setPos(l, m);
                if(m > gameblocks[l].length - 4)
                //if(m>-1)
                gameblocks[l][m].setColor((int) (Math.random() * totalpanels + 1));
            }
        }
        nexts = new ArrayList<GameBlockFalling>();
        for(int l = 0; l < 3; l++)
        {
            nexts.add(new GameBlockFalling((int)(Math.random() * totalpanels + 1), (int)(Math.random() * totalpanels + 1)));
            nexts.get(l).blockL.setPosX(positionBF[(int) (Math.random() * positionBF.length)]);
            nexts.get(l).blockR.setPosX(nexts.get(l).blockL.getPosX() + 1);
        }       
        gm = new GameMechanics(getGameblocks());
        gm.reorderCombinations(totalpanels);
        gm.reorderCombinations(totalpanels);
        gm.reorderCombinations(totalpanels);
    }
    
    public BufferedImage progressGame()
    {
        if(!isGameOver)
        {
            if(wait == false)
            {
                int chains = gm.checkCombinations();
                combo = (chains > 0) ? combo + chains : 0;
                score += chains * 100;
                blockFallings();
            }
            gm.fallBlock();
            if(wait == false)
            {
                generateBlockFallings();
            }
        }
        isGameOver = isGameOver ? true : checkGameOver();
        return BoardBuffer();
    }
    
    public boolean checkGameOver()
    {
        boolean ret = false;
        for(int c = 0; c < gameblocks.length; c++)
        {
            ret = (gameblocks[c][0].getColor() != 0) ? true : ret;
        }
        return ret;
    }
    
    public void generateBlockFallings()
    {
        if(nexts.isEmpty())
        {
            nexts = new ArrayList<>();
            for(int l = 0; l < 3; l++)
            {
                nexts.add(new GameBlockFalling((int) (Math.random() * totalpanels + 1), (int) (Math.random() * totalpanels + 1)));
                nexts.get(l).blockL.setPosX(positionBF[(int) (Math.random() * positionBF.length)]);
                nexts.get(l).blockR.setPosX(nexts.get(l).blockL.getPosX() + 1);
            }
        }
        countGenerateBF ++;
        if(countGenerateBF >= timeGenerateBF)
        {
            falls.add(nexts.get(0));
            nexts.remove(0);
            GameBlockFalling newbf = new GameBlockFalling((int) (Math.random() * totalpanels + 1), (int) (Math.random() * totalpanels + 1));
            newbf.blockL.setPosX(positionBF[(int) (Math.random() * positionBF.length)]);
            newbf.blockR.setPosX(newbf.blockL.getPosX() + 1); 
            nexts.add(newbf);
            countGenerateBF = 0;
        }
    }
    
    public void blockFallings()
    {
        for(int c = 0; c < falls.size(); c++)
        {
            falls.get(c).countFallBF ++;
            if(falls.get(c).countFallBF >= falls.get(c).timeFallBF)
            {
                int lx = falls.get(c).blockL.getPosX();
                int ly = falls.get(c).blockL.getPosY();
                int rx = falls.get(c).blockR.getPosX();
                int ry = falls.get(c).blockR.getPosY();
                if(lx < width && ly < height &&
                   gameblocks[lx][ly + 1].getColor() == 0 &&
                   gameblocks[rx][ry + 1].getColor() == 0)
                {
                    falls.get(c).blockL.setPos(lx, ly + 1);
                    falls.get(c).blockR.setPos(rx, ry + 1);
                    falls.get(c).countFallBF = 0;
                }else
                {
                    gameblocks[lx][ly].setColor(falls.get(c).blockL.getColor());
                    gameblocks[rx][ry].setColor(falls.get(c).blockR.getColor());
                    falls.remove(c);
                }
            }    
        }
    }
    
    public BufferedImage BoardBuffer()
    {
        wait = false;
        BufferedImage nuevo = new BufferedImage(150, 450, BufferedImage.TYPE_INT_RGB);
        nuevo.getGraphics().drawImage(background, 0, 0, nuevo.getWidth(), nuevo.getHeight(), null);
        int widthframe = nuevo.getWidth() / gameblocks.length;
        int heightframe = nuevo.getHeight() / gameblocks[0].length;
        for(int l = 0; l < gameblocks.length; l++)
        {
            for(int m = 0; m < gameblocks[l].length; m++)
            {
                if(!gameblocks[l][m].isFlashing())
                {
                    nuevo.getGraphics().drawImage(panels[gameblocks[l][m].getColor()], l * widthframe, m * heightframe, widthframe, heightframe, null);
                }else
                {
                    wait = true;
                    if(gameblocks[l][m].getDestroyCount()%2 == 0)
                    {
                       nuevo.getGraphics().drawImage(panels[gameblocks[l][m].getColor()], l * widthframe, m * heightframe, widthframe, heightframe, null);
                    }
                    gameblocks[l][m].setTimeToDestroy();
                }
            }
        }      
        for(int l = 0; l < falls.size(); l++)
        {
            GameBlock blockL = falls.get(l).blockL;
            GameBlock blockR = falls.get(l).blockR;
            nuevo.getGraphics().drawImage(panels[blockL.getColor()], blockL.getPosX() * widthframe, blockL.getPosY() * heightframe, widthframe, heightframe, null);
            nuevo.getGraphics().drawImage(panels[blockR.getColor()], blockR.getPosX() * widthframe, blockR.getPosY() * heightframe, widthframe, heightframe, null);
        }
        nuevo.getGraphics().drawImage(playercursor.getBuffer(), playercursor.getPosX() * widthframe, playercursor.getPosY() * heightframe, widthframe, heightframe, null);
        return nuevo;
    }   
}