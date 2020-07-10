package program.scene;

import program.GameObject;
import program.GameWindow;
import program.Setting;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.net.PortUnreachableException;
import java.util.Set;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver(){
        GameObject.botLayer.add(this);
//        BufferedImage image = SpriteUtils.loadImage("assest/image/Background info/lose.jpg");
        this.renderer = new AnimationRenderer("assest/image/BackgroundLose");
        this.position.set(Setting.GAME_WIDTH/2,Setting.GAME_HEIGHT/2);
    }
    @Override
    public void run() {
        super.run();
        if(GameWindow.isEnterPress){
            SceneManager.signNewScene(new ScenceStage1());
        }
    }
}
