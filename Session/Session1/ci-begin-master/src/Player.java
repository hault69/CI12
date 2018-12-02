import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    Vector2D position;
    int x;
    int y;
    public Player(){
        this.image = SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png");

       this.position = new Vector2D(Setting.PLAYER_LOCATION_X,Setting.PLAYER_LOCATION_Y);
    }
    public void run(){
        if (GameWindow.isUpPress){
            this.position.addThis(0,-10);
        }
        if (GameWindow.isDownPress){
            this.position.addThis(0,10);
        }
        if ( GameWindow.isLeftPress){
            this.position.addThis(-10,0);
        }
        if (GameWindow.isRightPress){
            this.position.addThis(10,0);
        }
        this.limitPlayerPosition();
    }
    private void limitPlayerPosition(){
        //limit x [0, background.image.getwith()]
        float x = (float)Mathx.clamp(this.position.x,0,Setting.BACKGROUND_WIDTH-Setting.PLAYER_WIDTH);
        //limit y [0, screen.height]
        float y = (float)Mathx.clamp(this.position.y,0,Setting.SCREEN_HEIGHT-Setting.PLAYER_HEIGHT);
        this.position.set(x,y);
    }
}


