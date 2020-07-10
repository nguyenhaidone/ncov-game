package program;

import program.enemy.Enemy;
import program.enemy.Enemy2;
import program.physic.BoxCollider;
import program.player.Player;
import program.player.PlayerBullet;
import program.player.SpecialBullet;
import program.renderer.Renderer;


import java.awt.*;
import java.awt.image.BandCombineOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //
    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static ArrayList<GameObject> topLayer = new ArrayList<>();
    public static ArrayList<GameObject> midLayer = new ArrayList<>();
    public static ArrayList<GameObject> botLayer = new ArrayList<>();

    public static <E extends GameObject> E recycle(Class<E> cls){
        E object = findDeactive(cls);
        if(object != null) {
            object.reset();
            return object;
        }
        try {
            object = cls.getConstructor().newInstance();
            return object;
        }catch (Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E findDeactive(Class<E> cls){
        for (int i = 0; i <objects.size() ; i++) {
            GameObject object = objects.get(i);
            if(!object.active && object.getClass().isAssignableFrom(cls)){
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class<E> cls,BoxCollider hitBox){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active && object.getClass().isAssignableFrom(cls) && object.hitBox != null && object.hitBox.intersects(hitBox)){
                return (E) object;
            }
        }
        return null;
    }

    public static void renderAll(Graphics g){
        for (int i = 0; i < botLayer.size(); i++) {
            GameObject object = botLayer.get(i);
            if(object.active){
                object.render(g);
            }
        }for (int i = 0; i < midLayer.size(); i++) {
            GameObject object = midLayer.get(i);
            if(object.active){
                object.render(g);
            }
        }for (int i = 0; i < topLayer.size(); i++) {
            GameObject object = topLayer.get(i);
            if(object.active){
                object.render(g);
            }
        }

    }

    public static void clearAll(){
        objects.clear();
        topLayer.clear();
        midLayer.clear();
        botLayer.clear();
    }
    static int count = 0;
    //
//    public BufferedImage image;
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;
    public BoxCollider hitBox;
    public Vector2D anchor;

    public static Player findPlayer(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active && object instanceof Player){
                return (Player)object;
            }
        }
        return null;
    }
    public static PlayerBullet findPlayerBullet(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active && object instanceof PlayerBullet){
                return (PlayerBullet) object;
            }
        }
        return null;
    }
    public static SpecialBullet findSpecialBullet(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active && object instanceof SpecialBullet){
                return (SpecialBullet) object;
            }
        }
        return null;
    }
    public static Enemy findEnemy(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active && object instanceof Enemy){
                return (Enemy) object;
            }
        }
        return null;
    }
    public static Enemy2 findEnemy2(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active && object instanceof Enemy2){
                return (Enemy2) object;
            }
        }
        return null;
    }
    public GameObject(){
        objects.add(this);
        count++;
        position = new Vector2D();
        velocity = new Vector2D();
        active = true;
        anchor = new Vector2D(0.5,0.5);
    }

    public void render(Graphics g){
        if(renderer != null){
            renderer.render(g,this);
        }
//        if(image != null){
//            g.drawImage(image,(int)position.x,(int)position.y,null);
//        }
    }

    public void run(){
        position.add(velocity);
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }
}
