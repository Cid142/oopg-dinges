package OOPG_Tank_game_Rein;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class MusicPlayer {



    public MusicPlayer() {
        try {
            File file = new File("battle.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}










