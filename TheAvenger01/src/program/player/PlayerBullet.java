package program.player;

import program.GameObject;
import program.GamePanel;
import program.Setting;
import program.Vector2D;
import program.enemy.Enemy;
import program.enemy.Enemy2;
import program.physic.BoxCollider;
import program.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
//    BufferedImage image;
//    Vector2D position;
    public int damage;
    public PlayerBullet(){
        GameObject.midLayer.add(this);
//        image = SpriteUtils.loadImage("assest/image/Dr_Sange_Bullet/Dr_Sange_Bullet02.png");
        renderer = new AnimationRenderer("assest/image/Dr_Sange_Bullet");
//        position = new Vector2D();
        velocity.set(0,-5);
        hitBox= new BoxCollider(this,26,26);
        damage = 1;
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeed();
        this.intersectsEnemy();
    }

    public void intersectsEnemy(){
        Enemy enemy = GameObject.findIntersects(Enemy.class,this.hitBox);
        Enemy2 enemy2 = GameObject.findIntersects(Enemy2.class,this.hitBox);
        if(enemy != null){
            this.deactive();
            enemy.takeDamage(this.damage);

        }
        if (enemy2 != null){
            this.deactive();
            enemy2.takeDamage(this.damage);
        }
    }

    public void deactiveIfNeed(){
        if(position.y<-30){
//            System.out.println("deactive");
            this.deactive();
        }
    }


}
