package game;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameCanvas extends JPanel{
    Background background;
    Player player;
    static ArrayList<PlayerBullet> playerBullets;

    
    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        this.playerBullets = new ArrayList<>();

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT);
        this.background.render(g);
        this.player.render(g);
        for (int i =0; i< this.playerBullets.size();i++){
            PlayerBullet bullet = this.playerBullets.get(i);
            bullet.render(g);
        }
    }
    public void runAll(){

        this.player.run();
        this.background.run();
        for (int i = 0; i < this.playerBullets.size();i++){
            PlayerBullet bullet = this.playerBullets.get(i);
            bullet.run();
        }
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
