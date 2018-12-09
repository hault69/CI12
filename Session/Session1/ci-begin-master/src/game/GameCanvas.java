package game;

import game.player.Player;
import game.player.PlayerBullet;
import game.renderer.TextRenderer;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameCanvas extends JPanel{

    
    public GameCanvas() {
//        this.background = new Background();
        GameObject.addGameObject(new Background());
//        this.player = new Player();
        GameObject.addGameObject(new Player());
        GameObject.addGameObject(new Enemy());
//        this.playerBullets = new ArrayList<>();


    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT);
        GameObject.renderAll(g);
    }


    public void runAll(){
        GameObject.runAll();

    }

    public void renderAll(){
        this.repaint(); // tương đương hàm paint()
    }

    public void gameLoop(){
        long lastTimeRun = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeRun >1000/60){
                runAll(); //logic game
                renderAll(); //hiển thị game
                lastTimeRun = currentTime;
            }
        }
    }
}
