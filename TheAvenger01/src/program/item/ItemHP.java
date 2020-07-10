package program.item;

import program.player.Player;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemHP extends Item {
    public ItemHP(){
        BufferedImage image = SpriteUtils.loadImage("assets02/images/items/power-up-red.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,3);
    }

    @Override
    public void powerUp(Player player) {
        player.playerHP++;
    }
}
