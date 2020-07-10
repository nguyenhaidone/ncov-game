package program.Background;

import program.GameObject;
import program.Setting;
import program.enemy.Enemy;
import program.enemy.Enemy2;
import program.player.Player;
import program.player.PlayerBullet;
import program.player.SpecialBullet;
import program.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background2 extends GameObject {
    BufferedImage heartImage;
    BufferedImage  enemyImage;
    BufferedImage  bulletImage;
    BufferedImage  specialImage;

    public Background2() {
//        image = SpriteUtils.loadImage("assest/image/Background/1.png");
//        renderer = new AnimationRenderer("assest/image/Background");
        GameObject.botLayer.add(this);
        renderer = new AnimationRenderer("assest/image/Background02");
        this.heartImage = SpriteUtils.loadImage("assest/image/Player/heart/heart-removebg.png");
        this.enemyImage = SpriteUtils.loadImage("assest/image/Enemy2/logo.png");
        this.bulletImage = SpriteUtils.loadImage("assest/image/Dr_Sange_Bullet/Dr_Sange_Bullet02.png");
        this.specialImage = SpriteUtils.loadImage("assest/image/Special_Bullet/Special_Bullet02.png");
        position.set(0, 0);
        anchor.set(0,0);
//        backgroundX=0;
//        backgroundY=0;
    }

    @Override
    public void run() {
        super.run();

    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        Player player = GameObject.findPlayer();
        if(player != null){
            if(player.playerHP >5){
                g.setColor(Color.GREEN);
            }else if(player.playerHP >2 && player.playerHP<5){
                g.setColor(Color.YELLOW);
            }else g.setColor(Color.RED);
            g.setFont(Setting.MEDIUM_SIZE);
            g.drawString(player.playerHP + " ",50,Setting.GAME_HEIGHT-60);
            g.drawImage(this.heartImage,5,Setting.GAME_HEIGHT-100,null);
        }
        PlayerBullet playerBullet = GameObject.findPlayerBullet();
        if(playerBullet != null){
            g.setFont(Setting.MEDIUM_SIZE);
            g.drawString(Setting.PLAYER_NUMBER_BULLET +" ",150,Setting.GAME_HEIGHT -60);
            g.drawImage(this.bulletImage,100,Setting.GAME_HEIGHT -90,null);
        }
        SpecialBullet specialBullet = GameObject.findSpecialBullet();
        if(specialBullet!=null){
            g.setFont(Setting.MEDIUM_SIZE);
            g.drawString(Setting.PLAYER_NUMBER_SPECIAL_BULLET +" ",250,Setting.GAME_HEIGHT -60);
            g.drawImage(this.specialImage,200,Setting.GAME_HEIGHT -100,null);
        }
        Enemy2 enemy2 = GameObject.findEnemy2();
        if(enemy2 != null){
            System.out.println("df");
            if(enemy2.enemyHP >10){
                g.setColor(Color.GREEN);
            }else if(enemy2.enemyHP >5 && enemy2.enemyHP <10){
                g.setColor(Color.YELLOW);
            }else g.setColor(Color.RED);
            g.setFont(Setting.MEDIUM_SIZE);
            g.drawString(enemy2.enemyHP +" ",50, Setting.GAME_HEIGHT -700);
            g.drawImage(this.enemyImage,5,Setting.GAME_HEIGHT -730,null);
        }

    }
}

