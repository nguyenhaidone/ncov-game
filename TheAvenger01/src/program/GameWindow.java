package program;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isSpecialFirePress;
    public static boolean isAnyKeyPress;
    public static boolean isEnterPress;


    public GameWindow() {
        this.setTitle("TheAvenger: EndGame ");
        this.setSize(Setting.GAME_WIDTH,Setting.GAME_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        //key
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                isAnyKeyPress = true;
                if(e.getKeyCode()==KeyEvent.VK_W){
                    isUpPress = true;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    isEnterPress = true;
                }

                // Hàm viết Special Bullet
                if(e.getKeyCode()== KeyEvent.VK_X){
                    isSpecialFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                isAnyKeyPress = false;
                if(e.getKeyCode()==KeyEvent.VK_W){
                    isUpPress = false;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = false;
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    isFirePress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    isEnterPress = false;
                }

                // Hàm viết Special Bullet
                if(e.getKeyCode()==KeyEvent.VK_X){
                    isSpecialFirePress = false;
                }
            }
        });
    }
}
