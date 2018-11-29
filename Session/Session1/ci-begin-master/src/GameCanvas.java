import java.awt.*;
import javax.swing.*;

public class GameCanvas extends JPanel{
    Background background;
    Player player;

    
    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,800,600);
        g.drawImage(this.background.image, this.background.x, this.background.y, null);
        g.drawImage(this.player.image,this.player.x,this.player.y, null);
    }
    public void runAll(){

        this.player.run();
        this.background.run();
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
