package puzzletetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class SceneManager 
{
    GameModeSinglePlayer single;
    MenuPause pause = new MenuPause();
    MenuStart start = new MenuStart();
    MenuGameOver gameover = new MenuGameOver(null);
    WindowConfiguration configuration = new WindowConfiguration();
    AudioFiles audio = new AudioFiles();
    final int startscene = 0;
    final int pausescene = 1;
    final int gameoverscene = 2;
    final int singlescene = 3;
    int scene = startscene;
    JFrame window;
     
    public SceneManager(JFrame window)
    {
        this.window = window;
        window.addKeyListener(menuStartKey());
//        single = new GameModeSinglePlayer();
    }
    
    public BufferedImage getBuffer()
    {
        BufferedImage ret = null;
        if(scene == singlescene && single.isGameOver)
        {
            scene = gameoverscene;
            configuration.options.saveHiScore(single.getGameBoard().getScore());
            window.removeKeyListener(window.getKeyListeners().length > 0 ? window.getKeyListeners()[0] : singlekey());              
            window.addKeyListener(menuGameOverKey());
        }
        switch(scene)
        {
            case startscene: ret = start.retBufferGame(); break;
            case pausescene: ret = pause.retBufferGame(); break;
            case gameoverscene: ret = gameover.retBufferGame(single.retBufferStatic()); break;
            default: ret = single.retBufferGame();break;
        }
        return ret;
    }
    
    public KeyListener menuPauseKey()
    {
        return  new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) 
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_1: 
                        scene = singlescene;
                        window.removeKeyListener(this);
                        window.addKeyListener(singlekey());
                        audio.resumeMidi();
                    break;
                    case KeyEvent.VK_2:
                        configuration.options.saveHiScore(single.getGameBoard().getScore());                        
                        scene = startscene;
                        window.removeKeyListener(this);
                        window.addKeyListener(menuStartKey());
                    break;
                    case KeyEvent.VK_3:
                        configuration.options.saveHiScore(single.getGameBoard().getScore());
                        System.exit(0);
                    break;                     
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        };
    }
     
    public KeyListener menuGameOverKey()
    {
        return  new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) 
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_1: 
                        single = new GameModeSinglePlayer();
                        scene = singlescene;
                        window.removeKeyListener(this);
                        window.addKeyListener(singlekey());
                    break;
                    case KeyEvent.VK_2:
                        scene = startscene;
                        window.removeKeyListener(this);
                        window.addKeyListener(menuStartKey());
                    break;
                    case KeyEvent.VK_3:
                        System.exit(0);
                    break;                     
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        };
    }
    
    public KeyListener menuStartKey()
    {
        return  new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) 
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_1: 
                        single = new GameModeSinglePlayer();
                        scene = singlescene;
                        window.removeKeyListener(this);
                        window.addKeyListener(singlekey());
                        audio.stopMidi();
                        if(configuration.options.confAtributes.Music)
                        {
                            audio.playMidi("music//SinglePlayer.mid", true, 0);
                        }
                    break;
                    case KeyEvent.VK_2:
                        configuration.setVisible(window.getX(), window.getY(), true);
                    break;
                    case KeyEvent.VK_3:
                        System.exit(0);
                    break;                    
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        };
    }
     
    public KeyListener singlekey()
    {
        return  new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) 
            {
                if(e.getKeyCode() == KeyEvent.VK_9)
                {
                    single.isGameOver = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    audio.stopMidi();
                    scene = pausescene;
                    window.removeKeyListener(this);
                    window.addKeyListener(menuPauseKey());
                }
                if(single.getCursor().getMode() == 1)
                {
                    if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    {
                        if(single.getCursor().getPosY() < single.getGameBoard().getHeight() - 1)
                        {
                            single.getCursor().setPosY(single.getCursor().getPosY() + 1);
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_UP)
                    {
                        if(single.getCursor().getPosY() > 0)
                        {
                            single.getCursor().setPosY(single.getCursor().getPosY() - 1);
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    {
                        if(single.getCursor().getPosX() > 0)
                        {
                            single.getCursor().setPosX(single.getCursor().getPosX() - 1);
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    {
                        if(single.getCursor().getPosX() < single.getGameBoard().getWidth() - 1)
                        {
                            single.getCursor().setPosX(single.getCursor().getPosX() + 1);
                        }
                    }
                }
                if(single.getCursor().getMode() == 2)
                {
                    try
                    {  
                        if(e.getKeyCode() == KeyEvent.VK_DOWN)
                        {
                            single.getGameBoard().changeBlock(single.getCursor().getPosX(), single.getCursor().getPosY(), 0, 1);
                        }
                        if(e.getKeyCode() == KeyEvent.VK_UP)
                        {
                            single.getGameBoard().changeBlock(single.getCursor().getPosX(), single.getCursor().getPosY(), 0, -1);
                        }
                        if(e.getKeyCode() == KeyEvent.VK_LEFT)
                        {
                            single.getGameBoard().changeBlock(single.getCursor().getPosX(), single.getCursor().getPosY(), -1, 0);
                        }
                        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                        {
                            single.getGameBoard().changeBlock(single.getCursor().getPosX(), single.getCursor().getPosY(), 1, 0);
                        }
                        single.getCursor().setMode(1);
                    }catch(Exception ex)
                    {
                    }
                }
//                if(e.getKeyCode()==KeyEvent.VK_SPACE){
//                    single.getGameBoard().getGameblocks()[single.getCursor().getPosX()][single.getCursor().getPosY()].setColor(0);
//                }
                if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    if(single.getCursor().getMode() == 1)
                    {
                        single.getCursor().setMode(2);
                    }else
                    {
                        if(single.getCursor().getMode() == 2)
                        {
                            single.getCursor().setMode(1);
                        }                        
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        };
    }
}