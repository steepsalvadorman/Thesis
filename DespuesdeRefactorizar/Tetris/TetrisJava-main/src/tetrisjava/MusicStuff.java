package tetrisjava;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicStuff 
{
    void playMusic(String MusicLocation)
    {
        try 
        {
            File musicPath = new File (MusicLocation);
            
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
              
            }
            else 
            {
               System.out.println("Can't find file");
            }
        }
        catch(IOException | LineUnavailableException | UnsupportedAudioFileException ex)
        {
        }
    }
}
