package program.player;

import program.GameObject;
import program.Vector2D;
import program.enemy.Enemy;
import program.enemy.Enemy2;
import program.physic.BoxCollider;
import program.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpecialBullet extends GameObject {
//    BufferedImage image;
//    Vector2D position;
    public int damage;
    public SpecialBullet(){
        GameObject.midLayer.add(this);
//        image = SpriteUtils.loadImage("assest/image/Special_Bullet/Special_Bullet.png");
        renderer  = new AnimationRenderer("assest/image/Special_Bullet");
//        position = new Vector2D();
        velocity.set(0,-5);
        hitBox = new BoxCollider(this,50,50);
        damage = 5;
    }
    public void run() {
        super.run();
        this.deactiveIfNeed();
        this.intersectsEnemy();
    }

    public void intersectsEnemy() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.hitBox);
        Enemy2 enemy2 = GameObject.findIntersects(Enemy2.class, this.hitBox);
        if (enemy != null) {
//            this.deactive();
            this.deactive();
            enemy.takeSpecialDamage(this.damage);

        }
        if (enemy2 != null) {
//            this.deactive();
            this.deactive();
            enemy2.takeSpecialDamage(this.damage);
        }
    }

    public void deactiveIfNeed(){
        if(position.y<-30){
//            System.out.println("Special bullet deactive");
            this.deactive();
        }
    }

//    public void render(Graphics g){
//        g.drawImage(image,(int) position.x,(int)position.y,null);
//    }

//    public void run(){
//        position.add(0,-5);
//    }
}
