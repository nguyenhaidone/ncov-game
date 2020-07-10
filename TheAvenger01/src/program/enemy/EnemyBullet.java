package program.enemy;

import program.GameObject;
import program.Setting;
import program.Vector2D;
import program.physic.BoxCollider;
import program.player.Player;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
//    BufferedImage image;
//    Vector2D position;
//    Vector2D velocity;
    public int damage;

    public EnemyBullet(){
        GameObject.midLayer.add(this);
//        image = SpriteUtils.loadImage("assest/image/EnemyBulluet/Ultron_bullet.png");
        renderer = new AnimationRenderer("assest/image/ultron bullet");
        velocity.set(0,Setting.ENEMY_BULLET_SPEED);
        hitBox = new BoxCollider(this,20,20);
        damage = 2;
    }
    public void run() {
        super.run();
        this.deactiveIfNeed();
        this.intersectsPlayer();
    }

    public void intersectsPlayer(){
        Player player = GameObject.findIntersects(Player.class,this.hitBox);
        if(player !=null){
//            this.deactiveIfNeed();
            this.deactive();
            player.takeDamage(this.damage);
        }
    }

    public void deactiveIfNeed(){
        if(position.y>800){
//            System.out.println("Enemy deactive");
            this.deactive();
        }
    }
//
//    public void render(Graphics g) {
//        g.drawImage(image,(int) position.x+40,(int)position.y+40,null);
//    }
//
//    public void run(){
//        position.add(velocity.x,velocity.y);
//    }
}
