package game.player;

import game.GameObject;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet(){
        super();
//        this.image = SpriteUtils.loadImage("assets\\images\\player-bullets\\a\\1.png");
        this.createRenderer();
    }
    //tạo animation hiệu ứng
    private void createRenderer(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new Animation(images);

    }
    @Override
    public void run(){
        this.position.addThis(0,-10);
    }
    //set toc do dan bay len o bien y

}
