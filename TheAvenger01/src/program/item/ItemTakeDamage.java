package program.item;

import program.player.Player;
import program.renderer.AnimationRenderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class ItemTakeDamage extends Item {
    Clip takeDamageMusic;
    public ItemTakeDamage(){
        this.renderer = new AnimationRenderer("assest/image/itemtakedamage");
        this.velocity.set(0,3);
        this.takeDamageMusic = AudioUtils.loadSound("assest/Audio/y2mate.com - logan_paul_ahh_sound_effect_4eAvjPeZ9Uo (online-audio-converter.com).wav");
    }
    @Override
    public void powerUp(Player player) {
        AudioUtils.replay(this.takeDamageMusic);
        player.playerHP--;
    }
}
