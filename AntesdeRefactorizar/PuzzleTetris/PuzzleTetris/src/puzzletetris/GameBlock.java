package puzzletetris;

public class GameBlock 
{
    private int color=0;
    private boolean active=true;
    private boolean flashing=false;
    private int posX=0;
    private int posY=0;
    private int destroyCount=0;
    private int timeToDestroy=10;
    
    public int getColor(){return color;}
    public boolean isActive(){return active;}
    public boolean isFlashing(){return flashing;}
    public int getPosX(){return posX;}
    public int getPosY(){return posY;}
    public int getDestroyCount(){return destroyCount;}
    
    public void setColor(int color){this.color=color;}
    public void setActive(boolean active){this.active=active;}
    public void setFlashing(boolean flashing){this.flashing=flashing;}
    public void setPosX(int posX){this.posX=posX;}
    public void setPosY(int posY){this.posY=posY;}
    public void setDestroyCount(int destroyCount){this.destroyCount=destroyCount;}
    public void setTimeToDestroy()
    {
        this.destroyCount++;
        if(this.destroyCount>=timeToDestroy)
        {
            setColor(0);
            this.destroyCount=0;
            setFlashing(false);
        }
    }
    public void setPos(int posX,int posY){ this.posX=posX;this.posY=posY; }
    
}
