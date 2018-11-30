import java.awt.image.BufferedImage;
import tklibs.SpriteUtils;

public class Background {
    BufferedImage image;
    int x;
    int y;
    
    public Background() {
        this.image = SpriteUtils.loadImage("assets\\images\\background\\0.png");
        this.x = 0;
        this.y = 600-this.image.getHeight();
    }
    public void run(){
        if (this.y < 0){
            this.y+=10;
        }
    }
}
