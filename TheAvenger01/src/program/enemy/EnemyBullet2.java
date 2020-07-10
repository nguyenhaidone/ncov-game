package program.enemy;

import program.GameObject;
import program.Setting;
import program.physic.BoxCollider;
import program.player.Player;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRenderer;

public class EnemyBullet2 extends GameObject {
    public int damage;

    public EnemyBullet2(){
        GameObject.midLayer.add(this);
//        image = SpriteUtils.loadImage("assest/image/EnemyBulluet/Ultron_bullet.png");
        renderer = new AnimationRenderer("assest/image/Thanos bullet");
        velocity.set(0, Setting.ENEMY_BULLET_SPEED);
        hitBox = new BoxCollider(this,20,20);
        damage = 2;
    }
    public void run() {
        super.run();
        this.deactiveIfNeed();
        this.intersectsPlayer();
    }

    public void intersectsPlayer(){
        Player player = GameObject.findIntersects(Player.class,this.hitBox);
        if(player !=null){
//            this.deactiveIfNeed();
            this.deactive();
            player.takeDamage(this.damage);
        }
    }

    public void deactiveIfNeed(){
        if(position.y>800){
            this.deactive();
        }
    }
}
