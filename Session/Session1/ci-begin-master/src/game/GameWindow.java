package game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public  static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isRightPress;
    public static boolean isLeftPress;
    public static boolean isFirePress;

    public GameWindow(){
        this.setTitle("Touhou");
//        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setResizable(false); //không cho thay đổi size windown
//        this.setVisible(true); //hiển thị ra gamewindown
        this.addKeyListener(new KeyAdapter() {

            //up
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = true;
                }
            //down
                if (e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = true;
                }
            //right
                if (e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = true;
                }
             //left
                if (e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = true;
                }
             //fire
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = false;
                }

            }

        });

    }
}
