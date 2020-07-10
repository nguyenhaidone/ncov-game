package program;


import program.Background.Background;
import program.player.Player;
import program.scene.SceneManager;
import program.scene.SceneWelcome;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    public GamePanel()
    {
//        background = new Background();
//        player = new Player();
//        GameObject.recycle(Background.class);
//        GameObject.recycle(Player.class);
//        GameObject.recycle(Enemy.class);
        SceneManager.signNewScene(new SceneWelcome());

    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0,Setting.GAME_WIDTH,Setting.GAME_HEIGHT);
        GameObject.renderAll(g);
//        for(int i = 0;i<GameObject.objects.size();i++){
//            GameObject object = GameObject.objects.get(i);
//            if(object.active) {
//                object.render(g);
//            }
//        }
//        background.render(g);
//        player.render(g);
//        enemy.render(g);
    }

    public void runAll() {
        for (int i =0;i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.run();
            }
        }
//        player.run();
//        enemy.run();
        System.out.println(GameObject.count);
    }
    public void gameLoop(){
        long lastTime = 0;
        while (true) {
            long currrentTime = System.currentTimeMillis();
            if(currrentTime-lastTime>1000/60){
//                System.out.println(currrentTime-lastTime);
                this.repaint();
                this.runAll();
                lastTime  = currrentTime;
            }
        }
    }
}
