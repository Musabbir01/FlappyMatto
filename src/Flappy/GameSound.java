package Flappy;

/**
 * Created by admin on 12/27/2017.
 */
import sun.audio.*;
import java.io.*;

public class GameSound {

    public static void Music(){
        AudioPlayer audioPlayer= AudioPlayer.player;
        AudioStream audioStream;
        AudioData audioData;
        ContinuousAudioDataStream loop=null;
        try {
            audioStream=new AudioStream(new FileInputStream("C://Users//admin//IdeaProjects//FlappyMatto//Resource//GameSound.wav"));
            audioData=audioStream.getData();
            loop=new ContinuousAudioDataStream(audioData);
        }catch (Exception e){
            e.printStackTrace();
        }
        audioPlayer.start(loop);

    }
}
