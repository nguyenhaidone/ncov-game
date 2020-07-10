package program.item;

import program.Setting;
import program.player.Player;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ItemBullet extends Item {
    public ItemBullet(){
        BufferedImage image = SpriteUtils.loadImage("assets02/images/items/power-up-blue.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,3);
    }

    @Override
    public void powerUp(Player player) {
        Setting.PLAYER_NUMBER_BULLET++;
    }
}
