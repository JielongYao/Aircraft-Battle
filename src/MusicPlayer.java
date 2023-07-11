import java.io.File;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

public class MusicPlayer{

    public Clip clip;
    public long clipTimePosition;
    public String musiclocation;
    
    public MusicPlayer(String musicLocation){
        musiclocation = musicLocation;
    }
    
    public void play(){
        
        try{
            File musicPath = new File(musiclocation);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            if(musicPath.exists()){
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else{
                System.out.println("can't find path");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void pause(){
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }

    public void resume(){
        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
    }

    public void stop(){
        clip.stop();
    }


}