import javax.swing.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GameCanvas gameCanvas = new GameCanvas();
        
        gameWindow.add(gameCanvas);
        gameWindow.setVisible(true);
        gameCanvas.gameLoop();
    }
}


