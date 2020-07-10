package program.scene;

import program.GameObject;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class SceneWelcome extends Scene {
    Clip muisic;
    @Override
    public void init() {
        GameObject.recycle(BackgroundWelcome.class);
        this.muisic = AudioUtils.loadSound("assest/Audio/The Avengers - Theme Song.wav");
        AudioUtils.replay(this.muisic);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
