
package puzzletetris;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GameConfiguration 
{
    Atributes confAtributes;
    
    class Atributes
    {
        boolean Music = false;
        boolean sfx = false;
        int difficult = 1;
        int HiScore = 0;
    }
    
    public GameConfiguration()
    { 
        loadOptions();
    }
    
    public void createConfFile(Atributes objAtributes)
    {
        Gson gson = new Gson();
        String json = gson.toJson(objAtributes);
        try 
        {
            FileWriter writer = new FileWriter("config.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void DefaultConfiguration()
    {
        confAtributes = new Atributes();
        confAtributes.Music = false;
        confAtributes.sfx = false;
        confAtributes.difficult = 1;
    }
    
    public void createConfFileDefault()
    {
        if(!new File("config.json").exists())
        {
            DefaultConfiguration();
            createConfFile(confAtributes);
        }
    }
    
    public void loadOptions()
    {
        try
        {
            BufferedReader reader=new BufferedReader(new FileReader("config.json"));
            String jsonLine = reader.readLine();
            Gson gson = new Gson();
            confAtributes = (Atributes)gson.fromJson(jsonLine, Atributes.class);
        }catch(Exception ex)
        {
            createConfFileDefault();
        }
    }
    
    public void saveHiScore(int Score)
    {
        if(confAtributes.HiScore < Score)
       {
           confAtributes.HiScore = Score;
           createConfFile(confAtributes);
       }       
    }
}
