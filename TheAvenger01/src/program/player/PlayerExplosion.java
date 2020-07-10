package program.player;

import program.GameObject;
import program.player.Player;
import program.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerExplosion extends GameObject {
    public PlayerExplosion(){
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assest/image/Explosion/PLAYER01.png"));
        images.add(SpriteUtils.loadImage("assest/image/Explosion/PLAYER02.png"));
        images.add(SpriteUtils.loadImage("assest/image/Explosion/PLAYER03.png"));
        images.add(SpriteUtils.loadImage("assest/image/Explosion/PLAYER04.png"));
        images.add(SpriteUtils.loadImage("assest/image/Explosion/PLAYER05.png"));
        this.renderer= new Animation(images,6,true);
    }
}
