package program.item;

import program.GameObject;
import program.GamePanel;
import program.physic.BoxCollider;
import program.player.Player;

public class Item extends GameObject {
    BoxCollider boxCollider;

    public Item(){
        GameObject.midLayer.add(this);
        this.boxCollider = new BoxCollider(this,12,12);
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersects(Player.class,this.boxCollider);
        if(player != null){
            this.powerUp(player);
            this.deactive();
        }
    }
    public void powerUp(Player player){

    }
}
