package program.player;

import program.GameObject;
import program.GameWindow;
import program.Setting;
import program.physic.BoxCollider;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRenderer;
import program.scene.SceneGameOver;
import program.scene.SceneGameWin;
import program.scene.SceneManager;
import tklibs.AudioUtils;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    ArrayList<PlayerBullet> bullets;
    ArrayList<SpecialBullet> specialBullets;
    public int playerHP;
    Clip dieMusic;
    Clip takeDamageMusic;
    public Player() {
        GameObject.midLayer.add(this);
        renderer  = new AnimationRenderer("assest/image/PlayerImage");
        position.set(Setting.GAME_WIDTH /2,Setting.GAME_HEIGHT);
        bullets = new ArrayList<>();
        specialBullets = new ArrayList<>();
        hitBox = new BoxCollider(this,42,43);
        playerHP = 10;
        this.dieMusic = AudioUtils.loadSound("assest/Audio/No NO NOOOO! - Free Sound Effect.wav");
        this.takeDamageMusic = AudioUtils.loadSound("assest/Audio/y2mate.com - logan_paul_ahh_sound_effect_4eAvjPeZ9Uo (online-audio-converter.com).wav");
    }
    public void render(Graphics g) {
        super.render(g);
        for (int i =0;i<bullets.size();i++){
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
        for (int i = 0;i<specialBullets.size();i++){
            SpecialBullet specialBullet = specialBullets.get(i);
            specialBullet.render(g);
        }

    }
    public void run () {
        super.run();
        //move
        this.move();
        //limitPosition
        this.limitPosition();
        this.bulletsRun();
        this.fire();
        this.specialFire();
    }
    int countSpecialBullet = 0;
    int countBullet = 0;
    public void specialFire(){
        countSpecialBullet++;
        if(GameWindow.isSpecialFirePress && countSpecialBullet > Setting.SPECIAL_BULLET_SPEED && playerHP < 5){
            double fromX = this.position.x - 10;
            double toX = this.position.x + 10;
            double fromAngle = -Math.PI / 3;
            double toAngle = -2*Math.PI/3;
            int numberBullet =  Setting.PLAYER_NUMBER_SPECIAL_BULLET;/*Setting.ENEMY_NUMBER_BULLET*/;
            for (int i =0;i<numberBullet;i++){
                SpecialBullet specialBullet = GameObject.recycle(SpecialBullet.class);

                double x = fromX +i*(toX-fromX)/(numberBullet-1);
                specialBullet.position.set(x,this.position.y);

                double angle = fromAngle + i*(toAngle-fromAngle)/(numberBullet-1);
                specialBullet.velocity.setAngle(angle);

            }
            countSpecialBullet =0;
        }
    }
    public void fire() {
        //Để lệnh if thì khi bấm space thì nó sẽ bắn đạn
        countBullet++;
        if(GameWindow.isFirePress&&countBullet > Setting.BULLET_SPEED){
            double fromX = this.position.x - 10;
            double toX = this.position.x + 10;
            double fromAngle = -Math.PI / 3;
            double toAngle = -2*Math.PI/3;
            int numberBullet =  Setting.PLAYER_NUMBER_BULLET;/*Setting.ENEMY_NUMBER_BULLET*/;
            for (int i =0;i<numberBullet;i++){
                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);

                double x = fromX +i*(toX-fromX)/(numberBullet-1);
                bullet.position.set(x,this.position.y);

                double angle = fromAngle + i*(toAngle-fromAngle)/(numberBullet-1);
                bullet.velocity.setAngle(angle);

            }
            countBullet =0;
        }
    }

    public void move(){

        double playerSpeed = Setting.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress){
            vy -= playerSpeed;
        }
        if(GameWindow.isDownPress){
            vy += playerSpeed;
        }
        if(GameWindow.isLeftPress){
            vx -= playerSpeed;
        }
        if(GameWindow.isRightPress){
            vx += playerSpeed;
        }

        if(vx != 0 && vy != 0) {
            double v = playerSpeed / Math.sqrt(2);
            vx = Math.signum(vx) * v; // 1 * 5 * sqrt(2)
            vy = Math.signum(vy) * v; // -1 * 5 * sqrt(2)
        }

        velocity.set(vx,vy);
    }

    public void limitPosition(){
        position.setX( Mathx.clamp(position.x, 0, Setting.GAME_WIDTH-Setting.PLAYER_WIDTH));
        position.setY( Mathx.clamp(position.y, 0, Setting.GAME_HEIGHT-Setting.PLAYER_HEIGTH));
    }

    public void bulletsRun(){
        for(int i = 0;i < bullets.size();i++){
            PlayerBullet bullet = bullets.get(i);
            bullet.run();
        }

        for(int i =0;i< specialBullets.size();i++){
            SpecialBullet specialBullet = specialBullets.get(i);
            specialBullet.run();
        }
    }
    public void takeDamage(int damage){
        playerHP -= damage;
        if(playerHP <=0){
            playerHP = 0;
            this.deactive();
        }
        PlayerExplosion explosion = GameObject.recycle(PlayerExplosion.class);
        explosion.position.set(this.position);
        AudioUtils.replay(this.takeDamageMusic);
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new SceneGameOver());
        AudioUtils.replay(this.dieMusic);
    }

}
