package pt.up.fe.edu.dozer.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {
    private AudioInputStream soundStream;
    private Clip clip;
    private String filepath;
    private long time;


    public AudioManager(String soundFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        filepath = soundFilePath;
        URL resource = AudioManager.class.getResource(soundFilePath);
        soundStream = AudioSystem.getAudioInputStream(resource);
        DataLine.Info info = new DataLine.Info(Clip.class, soundStream.getFormat());
        clip = (Clip) AudioSystem.getLine(info);
        clip.open(soundStream);
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void restartAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // implementacao mais custosa mas menos bug
        //clip.close();
        URL resource= AudioManager.class.getResource(filepath);
        soundStream= AudioSystem.getAudioInputStream(resource);
        DataLine.Info info = new DataLine.Info(Clip.class,soundStream.getFormat());
        clip=(Clip) AudioSystem.getLine(info);
        clip.open(soundStream);
        //implementacao menos custosa mas se clicar 2 vezes o botao quase ao mesmo tempo o som so da uma vez
        //clip.setFramePosition(0);

    }
    public void loopSound(){
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void mute(){
        clip.setFramePosition(0);
        clip.stop();
    }
    public void close(){
        clip.close();
    }
}
