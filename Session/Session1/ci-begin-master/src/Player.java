import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    int x;
    int y;
    public Player(){
        this.image = SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png");
        this.x = 200;
        this.y = 300;
    }
    public void run(){
        if (GameWindow.isUpPress){
            y=y-10;
        }
        if (GameWindow.isDownPress){
            y=y+10;
        }
        if ( GameWindow.isLeftPress){
            x--;
        }
        if (GameWindow.isRightPress){
            x++;
        }
    }
}


