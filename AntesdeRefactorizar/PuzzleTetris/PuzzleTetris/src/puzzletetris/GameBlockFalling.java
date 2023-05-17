package puzzletetris;

public class GameBlockFalling 
{
    GameBlock blockL = new GameBlock();
    GameBlock blockR = new GameBlock();
    int countFallBF = 0;
    int timeFallBF = 2;
    
    public GameBlockFalling(int colorL, int colorR)
    {
        blockL.setColor(colorL);
        blockR.setColor(colorR);
    }
}
