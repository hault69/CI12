package game.player;

import game.GameCanvas;
import game.GameObject;
import game.GameWindow;
import game.Setting;
import game.player.PlayerBullet;
import game.renderer.Animation;
import tklibs.Mathx;
import tklibs.SpriteUtils;

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
        this.renderer = new PlayerRenderer("Player",images);

    }

    @Override
    public void run(){
        this.move();
        count++;
        if (count>10){
            this.fire();
        }
        this.limitPlayerPosition();
    }
    int count = 0; // se fix
    private void fire() {
        if (GameWindow.isFirePress){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x,this.position.y);
            GameObject.addGameObject(bullet);
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
        int halfWidth = (int)(Setting.PLAYER_WIDTH * this.anchor.x);
        int haflHeight = (int)(Setting.PLAYER_HEIGHT * this.anchor.y);
        //limit x [0, background.image.getwith()]
        float x = (float)Mathx.clamp(this.position.x,
                                    halfWidth,
                                    Setting.BACKGROUND_WIDTH-halfWidth);
        //limit y [0, screen.height]
        float y = (float)Mathx.clamp(this.position.y,
                                    haflHeight,
                                    Setting.SCREEN_HEIGHT-haflHeight);
        this.position.set(x,y);
    }
}


