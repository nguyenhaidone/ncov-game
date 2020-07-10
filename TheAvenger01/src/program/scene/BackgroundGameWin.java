package program.scene;

import program.GameObject;
import program.GameWindow;
import program.Setting;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundGameWin extends GameObject {
    public BackgroundGameWin(){
        GameObject.botLayer.add(this);
//        BufferedImage image = SpriteUtils.loadImage("assest/image/Background info/lose.jpg");
        this.renderer = new AnimationRenderer("assest/image/Background end");
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
