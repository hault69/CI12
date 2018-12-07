package game;

import game.renderer.Animation;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {

    public Player(){
//        this.image = SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png");

        this.position.set(Setting.PLAYER_LOCATION_X,Setting.PLAYER_LOCATION_Y);
        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets\\images\\players\\straight\\0.png"));
        images.add(SpriteUtils.loadImage("assets\\images\\players\\straight\\1.png"));
        images.add(SpriteUtils.loadImage("assets\\images\\players\\straight\\2.png"));
        images.add(SpriteUtils.loadImage("assets\\images\\players\\straight\\3.png"));
        images.add(SpriteUtils.loadImage("assets\\images\\players\\straight\\4.png"));
        images.add(SpriteUtils.loadImage("assets\\images\\players\\straight\\5.png"));
        images.add(SpriteUtils.loadImage("assets\\images\\players\\straight\\6.png"));
        this.renderer = new Animation(images);

    }

    @Override
    public void run(){
        this.move();
        count++;
        if (count>20){
            this.fire();
        }
        this.limitPlayerPosition();
    }
    int count = 0; // se fix
    private void fire() {
        if (GameWindow.isFirePress){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x,this.position.y);
            GameCanvas.playerBullets.add(bullet);
            count = 0;
        }
        //1. Tạo class PlayerBullet
        //2. Tạo biến quản lý cho PlayerBullet
        //3. Bắt sự kiện giữ phím bắn
        //4. Xử lý logic bắn
        //5. Giới hạn bắn
    }

    private void move(){

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
    }
    private void limitPlayerPosition(){
        //limit x [0, background.image.getwith()]
        float x = (float)Mathx.clamp(this.position.x,0,Setting.BACKGROUND_WIDTH-Setting.PLAYER_WIDTH);
        //limit y [0, screen.height]
        float y = (float)Mathx.clamp(this.position.y,0,Setting.SCREEN_HEIGHT-Setting.PLAYER_HEIGHT);
        this.position.set(x,y);
    }
}


