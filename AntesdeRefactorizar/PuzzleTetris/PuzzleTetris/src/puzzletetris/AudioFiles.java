package puzzletetris;

import javax.sound.midi.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class AudioFiles 
{
    Sequencer seq;
    public AudioFiles(){}

    public void playMidi(String archivo, boolean infinito, int n)
    {
        try
        {
            File f = new File(archivo);
            Sequence S = MidiSystem.getSequence(f);
            seq = MidiSystem.getSequencer();
            seq.open();
            seq.setSequence(S);
            seq.start();
            if(infinito == true) seq.setLoopCount(Clip.LOOP_CONTINUOUSLY);
            else seq.setLoopCount(n);
        }
        catch(MidiUnavailableException ecc){System.out.println("error midi");}
        catch(InvalidMidiDataException ecc2){System.out.println("error mididata");}
        catch(IOException ecc3){System.out.println("error sonido");}	
    }

    public void stopMidi()
    {
        if(seq != null)
            seq.stop();
    }

    public void resumeMidi()
    {
        if(seq != null)
            seq.start();
    }
    
    public void swapMidi(String archivo, boolean infinito, int n)
    {
        seq.stop();
        playMidi(archivo,infinito,n);
    }

    public void ThreadMidi(String archivo, boolean infinito, int n)
    {
        new SoundThreadMidi(archivo,infinito,n).start();
    }
    
    class SoundThreadMidi extends Thread
    {
        String archivo;
        boolean infinito;
        int n = 0;
        public SoundThreadMidi(String archivo, boolean infinito, int n)
        {
            this.archivo = archivo;
            this.infinito = infinito;
            this.n = n;
        }
        public void run()
        {
            playMidi(archivo, infinito, n);
        }
    }

    public void playWav(String archivo, boolean infinito, int n)
    {
        try 
        {
            File f = new File(archivo);
            Clip sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(f));
            sonido.start();
            if(infinito == true) 
                sonido.loop(Clip.LOOP_CONTINUOUSLY);
            else 
                sonido.loop(n);
         }catch (Exception e)
         {
            System.out.println("" + e);
         }	
    }

    public void ThreadWav(String archivo, boolean infinito, int n)
    {
        new SoundThreadWav(archivo, infinito, n).start();
    }
    
    class SoundThreadWav extends Thread
    {
        String archivo;
        boolean infinito;
        int n = 0;    
        public SoundThreadWav(String archivo, boolean infinito, int n)
        {
            this.archivo = archivo;
            this.infinito = infinito;
            this.n = n;
        }
        public void run()
        {
            playWav(archivo, infinito, n);
        }
    }
}
