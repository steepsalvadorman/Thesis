package puzzletetris;

import java.util.ArrayList;

public class GameMechanics 
{
    private GameBlock[][] bloques;
    
    public GameMechanics(GameBlock[][] bloques)
    {
        this.bloques = bloques;
    }
    
    public void fallBlock()
    {
        for(int l = 0; l < bloques.length; l++)
        {
            for(int m = bloques[l].length - 2; m >= 0; m--)
            {
               if(bloques[l][m + 1].getColor() == 0 && bloques[l][m].getColor() != 0)
               {
                    int n = m + 1;
                    while(n < bloques[l].length && bloques[l][n].getColor() == 0) n++;
                    int n1 = bloques[l][n - 1].getColor();
                    int lm = bloques[l][m].getColor();
                    bloques[l][n - 1].setColor(lm);
                    bloques[l][m].setColor(n1);
               }
            }
        }
    }
    
    public void changeBlock(int x, int y, int directionX, int directionY)
    {
        if(bloques[x + directionX][y + directionY].getColor() !=0 && bloques[x + directionX][y + directionY].isFlashing() == false)
        {          
            int xy = bloques[x][y].getColor();
            int xy2 = bloques[x + directionX][y + directionY].getColor();
            bloques[x][y].setColor(xy2);
            bloques[x + directionX][y + directionY].setColor(xy);
        }
    }
    
    public int getColor(int x, int y){
        try
        {
            return bloques[x][y].getColor();
        }
        catch(Exception ex)
        {
            return -1;
        }
    }
    
    public boolean getFlashing(int x, int y)
    {
        try
        {
            return bloques[x][y].isFlashing();
        }catch(Exception ex)
        {
            return true;
        }
    }
    
    public int reorderCombinations(int totalpanels)
    {
        int counter = 0;
        for(int l = 0; l < bloques.length; l++)
        {
            for(int m = 0; m < bloques[l].length; m++)
            {
                int x = l;
                int y = m;
                int chain = 1;
                int blocking = 0;
                while
                (
                    (
                        (getColor(x, y+1) == getColor(l, m))||
                        (getColor(x-1, y) == getColor(l, m) && blocking != 1)||
                        (getColor(x+1, y) == getColor(l, m) && blocking != 2)
                    ) && chain < 4 && getColor(l, m) > 0
                )
                {
                    if(getColor(x - 1, y) == getColor(l, m) && blocking != 1)
                    {
                        blocking = 2;
                        chain++;
                        if(chain <= 4) x -= 1;
                    }else
                    {
                        if(getColor(x + 1, y) == getColor(l, m) && blocking != 2)
                        {
                            blocking = 1;
                            chain++;
                            if(chain<=4) x += 1;
                        }else
                        {
                            if(getColor(x, y + 1) == getColor(l, m))
                            {
                               blocking = 0;
                               chain++;
                               y = (chain <= 4)? y + 1 : y;
                            }                         
                        }
                    }
                    if(chain >= 4)
                    {
                        bloques[l][m].setColor(bloques[l][m].getColor() + 1);
                        if(bloques[l][m].getColor() > totalpanels)
                        {
                            bloques[l][m].setColor(1);                        
                        }
                        counter++;
                    }
               }
            }
       }
       return counter;
    }
     
    public int checkCombinations()
    {
        ArrayList<ArrayList<GameBlock>> totalchains = new ArrayList<>();
        for(int l = 0; l < bloques.length; l++)
        {
            for(int m = 0; m < bloques[l].length; m++)
            {
                int x = l;
                int y = m;
                int chain = 1;
                int blocking = 0;
                ArrayList<GameBlock> chainnew = new ArrayList<>();
                String chains = "(" + x + "," + y + ")";
                
                if(getColor(l, m) > 0 && getFlashing(l, m) == false)
                {
                    chainnew.add(bloques[x][y]);
                    while
                    (
                        (
                            (getColor(x, y + 1) == getColor(l, m) && !getFlashing(x, y + 1))||
                            (getColor(x - 1, y) == getColor(l, m) && !getFlashing(x - 1, y) && blocking != 1)||
                            (getColor(x + 1, y) == getColor(l,m) && !getFlashing(x + 1, y) && blocking != 2)
                        ) && chain < 4
                    )
                    {
                        if(getColor(x - 1, y) == getColor(l, m) && blocking != 1)
                        {
                            blocking = 2;
                            x -=1 ;
                            chains += "(" + x + "," + y + ")";
                            chainnew.add(bloques[x][y]);
                        }else
                        {
                            if(getColor(x + 1, y) == getColor(l, m) && blocking != 2)
                            {
                                blocking = 1;
                                x += 1;
                                chains += "(" + x + "," + y + ")";
                                chainnew.add(bloques[x][y]);
                            }else
                            {
                                if(getColor(x, y + 1) == getColor(l, m))
                                {
                                   blocking = 0;
                                   y += 1;
                                   chains += "(" + x + "," + y + ")";
                                   chainnew.add(bloques[x][y]);
                                }
                            }
                        }
                        chain++;
                    }
                }
                if(chain >= 4)
                {
                    for(int c = 0; c < chainnew.size(); c++)
                    {
                        chainnew.get(c).setFlashing(true);
                    }
                    totalchains.add(chainnew);
                }
           }
        }
        return totalchains.size();
    }
    
}
