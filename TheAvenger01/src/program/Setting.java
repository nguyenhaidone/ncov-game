package program;

import java.awt.*;
import java.net.PortUnreachableException;

public class Setting {
    //Game
    public static int GAME_WIDTH = 510;
    public static int GAME_HEIGHT = 740;

    //Background

    //Player
    public static int PLAYER_SPEED = 3;
    public static int PLAYER_WIDTH = 55;
    public static int PLAYER_HEIGTH = 80;

    //Bullet
    public static int PLAYER_NUMBER_BULLET = 3;
    public static int PLAYER_NUMBER_SPECIAL_BULLET = 3;
    //Player Bullet Speed
    public static int BULLET_SPEED = 30;
    public static int SPECIAL_BULLET_SPEED = 10;

    //Enemy
    public static int ENEMY_START_X = -50;
    public static int ENEMY_START_Y = 50;

    //Enemy Bullet Speed
    public static int ENEMY_BULLET_SPEED_PER_SECOND = 120;
    public static int ENEMY_BULLET_SPEED= 1;
    public static int ENEMY_NUMBER_BULLET = 3;

    //font
    public static Font BIG_SIZE = new Font("Verdana",Font.BOLD,28);
    public static Font MEDIUM_SIZE = new Font("Verdana",Font.BOLD,20);
    public static Font SMALL_SIZE = new Font("Verdana",Font.BOLD,12);

}
