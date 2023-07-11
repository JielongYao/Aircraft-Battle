import java.io.File;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

public class GamePausedMusicPlayer extends MusicPlayer{

    public GamePausedMusicPlayer(String musicLocation){
        super(musicLocation);
    }
    
    public void play(){
        super.play();
    }

    public void pause(){
        super.pause();
    }

    public void resume(){
        super.resume();
    }

    public void stop(){
        super.stop();
    }

}