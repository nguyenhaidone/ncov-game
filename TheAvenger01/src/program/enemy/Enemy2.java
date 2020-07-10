package program.enemy;

import program.GameObject;
import program.Setting;
import program.Vector2D;
import program.physic.BoxCollider;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRenderer;
import program.scene.SceneGameWin;
import program.scene.SceneStageWin;
import program.scene.SceneManager;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.ArrayList;

public class Enemy2 extends GameObject {
    Clip explosionSound;
    Clip bigExplosionSound;
    ArrayList<EnemyBullet2> bullets;
    public int enemyHP;
    public Enemy2(){
        GameObject.midLayer.add(this);
        renderer = new AnimationRenderer("assest/image/Thanos");
        position = new Vector2D(Setting.ENEMY_START_X,Setting.ENEMY_START_Y);
        velocity.set(1,0);
        bullets = new ArrayList<>();
        hitBox = new BoxCollider(this,61,61);
        enemyHP = 100;
        this.explosionSound = AudioUtils.loadSound("assets02/music/sfx/enemy-explosion.wav");
        this.bigExplosionSound = AudioUtils.loadSound("assets02/music/sfx/enemy-explosion-big.wav");
    }

    public void render(Graphics g) {
        super.render(g);
        for(int i = 0;i<bullets.size();i++){
            EnemyBullet2 bullet = bullets.get(i);
            bullet.render(g);
        }
    }
    public void update() {
        if(enemyHP < 50){
            Setting.ENEMY_BULLET_SPEED_PER_SECOND=100;
            Setting.ENEMY_NUMBER_BULLET=10;
            Setting.ENEMY_BULLET_SPEED=3;
        }
    }
    public void run(){
        super.run();
        this.move();
        this.bulletsRun();
        this.fire();
        this.update();
    }
    public void move(){
        if(this.position.x < 0 && velocity.x <0){
            velocity.x = -velocity.x;
        }
        if(this.position.x > Setting.GAME_WIDTH && velocity.x >0){
            velocity.x = -velocity.x;
        }
    }

    int count = 0;
    public void fire() {
        count++;
        //tốc độ bắn đạn
        if(count > Setting.ENEMY_BULLET_SPEED_PER_SECOND){
            double fromX = this.position.x - 10;
            double toX = this.position.x + 10;
            double fromAngle = Math.PI / 3;
            double toAngle = 2*Math.PI/3;
            int numberBullet = Setting.ENEMY_NUMBER_BULLET;
            for (int i =0;i<numberBullet;i++){
                EnemyBullet2 bullet = GameObject.recycle(EnemyBullet2.class);

                double x = fromX +i*(toX-fromX)/(numberBullet-1);
                bullet.position.set(x,this.position.y);

                double angle = fromAngle + i*(toAngle-fromAngle)/(numberBullet-1);
                bullet.velocity.setAngle(angle);

            }
            count =0;
        }
    }

    public void bulletsRun(){
        for(int i = 0;i < bullets.size();i++){
            EnemyBullet2 bullet = bullets.get(i);
            bullet.run();
        }
    }
    public void takeSpecialDamage(int specialDamage){
        enemyHP -= specialDamage;
        if(enemyHP <=0){
            enemyHP = 0;
            this.deactive();
        }
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
        AudioUtils.replay(this.explosionSound);
    }

    public void takeDamage(int damage){
        enemyHP -= damage;
        if(enemyHP <=0){
            enemyHP = 0;
            this.deactive();
        }
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
        AudioUtils.replay(this.explosionSound);
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new SceneGameWin());
        AudioUtils.replay(this.bigExplosionSound);
    }
}


