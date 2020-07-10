package program.menu;

import program.GameObject;
import program.Setting;

import java.awt.*;

public class BackgroundMenu extends GameObject {
    public BackgroundMenu(){
        GameObject.topLayer.add(this);
        this.position.set(Setting.GAME_WIDTH,0);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)this.position.x,(int)this.position.y,1000-Setting.GAME_WIDTH,750);
        g.setColor(Color.WHITE);
        g.drawString("This is menu",Setting.GAME_WIDTH+30, 30);
    }
}
