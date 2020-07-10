package program.item;

import program.FrameCounter;
import program.GameObject;
import program.Setting;

import java.util.Random;

public class ItemSummoner extends GameObject {
    FrameCounter summonCounter;
    Random random;

    public ItemSummoner() {
        this.summonCounter = new FrameCounter(120);
        this.random = new Random();
    }
    @Override
    public void run() {
        super.run();
        if(this.summonCounter.count()){
            Item itemBullet = GameObject.recycle(ItemBullet.class);
            int randomX = this.random.nextInt(Setting.GAME_WIDTH);
            itemBullet.position.set(randomX, -30);
            this.summonCounter.reset();
        }

        if(this.summonCounter.count()){
            Item itemHP = GameObject.recycle(ItemHP.class);
            int randomY = this.random.nextInt(Setting.GAME_WIDTH);
            itemHP.position.set(randomY, -30);
            this.summonCounter.reset();
        }

        if(this.summonCounter.count()){
            Item itemTakeDamage = GameObject.recycle(ItemTakeDamage.class);
            int randomZ = this.random.nextInt(Setting.GAME_WIDTH);
            itemTakeDamage.position.set(randomZ,-30);
            this.summonCounter.reset();
        }
    }
}
