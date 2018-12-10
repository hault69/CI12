package game;

import java.awt.image.BufferedImage;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {

    public Enemy() {

        super();
        BufferedImage image = SpriteUtils.loadImage("assets\\images\\enemies\\level0\\pink\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(1,1);

    }

    @Override
    public void run(){
        if (this.position.x<Setting.BACKGROUND_WIDTH){
            this.position.addThis(3,1);
        }else {
            this.position.x = 0;
            this.position.addThis(3,1);
        }

    }

}
