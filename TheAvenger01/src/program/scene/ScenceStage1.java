package program.scene;

import program.Background.Background;
import program.Background.Background2;
import program.GameObject;
import program.Setting;
import program.enemy.Enemy;
import program.item.ItemSummoner;
import program.menu.BackgroundMenu;
import program.player.Player;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class ScenceStage1 extends Scene {
    Clip muisic;
    @Override
    public void init() {
        Setting.PLAYER_NUMBER_BULLET = 3;
        Setting.ENEMY_NUMBER_BULLET=3;
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Enemy.class);
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
