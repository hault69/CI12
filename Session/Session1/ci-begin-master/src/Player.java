import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    BufferedImage background;
    int x;
    int y;
    public Player(){
        this.image = SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png");
        this.background = SpriteUtils.loadImage("assets\\images\\background\\0.png");
        this.x = 200;
        this.y = 300;
    }
    public void run(){
        if (GameWindow.isUpPress && this.y>=10){
            this.y-=10;
        }
        if (GameWindow.isDownPress && this.y <=(600-this.image.getHeight()-40)){
            this.y+=10;
        }
        if ( GameWindow.isLeftPress && this.x>=5){
            this.x-=10;
        }
        if (GameWindow.isRightPress && this.x<=(this.background.getWidth()-this.image.getWidth())){
            this.x+=10;
        }
    }
}


