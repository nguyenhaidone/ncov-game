package program.enemy;

import program.GameObject;
import program.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion(){
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assest/image/Explosion/Sprite-0002.png"));
        images.add(SpriteUtils.loadImage("assest/image/Explosion/Sprite-0003.png"));
        images.add(SpriteUtils.loadImage("assest/image/Explosion/Sprite-0004.png"));
        images.add(SpriteUtils.loadImage("assest/image/Explosion/Sprite-0005.png"));
        this.renderer= new Animation(images,6,true);
    }
}
