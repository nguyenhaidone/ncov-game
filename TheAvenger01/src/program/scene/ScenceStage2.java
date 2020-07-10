package program.scene;

import program.Background.Background;
import program.Background.Background2;
import program.GameObject;
import program.Setting;
import program.enemy.Enemy;
import program.enemy.Enemy2;
import program.item.ItemSummoner;
import program.menu.BackgroundMenu;
import program.player.Player;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class ScenceStage2 extends Scene {
    Clip muisic;
    @Override
    public void init() {
        GameObject.recycle(Background2.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Enemy2.class);
        GameObject.recycle(BackgroundMenu.class);
        GameObject.recycle(ItemSummoner.class);
//        this.muisic = AudioUtils.loadSound("assest/Audio/The Avengers - Theme Song.wav");
//        AudioUtils.replay(this.muisic);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
