package puzzletetris;

import javax.swing.JFrame;

public class WindowGame 
{
    JFrame window = new JFrame();
    SceneManager sm = new SceneManager(window);
    
    public WindowGame()
    {
        window.setDefaultCloseOperation(3);
        window.setBounds(100, 100, 500, 500);
        window.setVisible(true);
        new MiThread().start();
    }
    
    class MiThread extends Thread 
    {
        public void run() 
        {
            try
            {
                while(1 > 0)
                {
                    window.getGraphics().drawImage(sm.getBuffer(), 0, 0, window.getWidth(), window.getHeight(), window);
                    Thread.sleep(50);
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
