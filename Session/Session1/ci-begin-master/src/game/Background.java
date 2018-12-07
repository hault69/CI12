package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {
//    BufferedImage image;
//    game.Vector2D position;
    
    public Background() {
        //super dùng để kế thừa các object đã khởi tạo tại thư mục cha
        super();
        BufferedImage image = SpriteUtils.loadImage("assets\\images\\background\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, Setting.SCREEN_HEIGHT- Setting.BACKGROUND_HEIGHT);
        //set lai vi tri anchor cho backgroud
        this.anchor.set(0,0);
//        this.position = new game.Vector2D(0,game.Setting.SCREEN_HEIGHT-game.Setting.BACKGROUND_HEIGHT);
    }

    @Override
    //hàm run ở lớp cha đã có nhưng về nội dung khác nhau nên dùng hàm override để ghi đè.
    public void run(){
        if (this.position.y <0){
            //this.y +=10;
            this.position.addThis(0,10);
       } else {
            //this.y = 0;
            this.position.set(this.position.x,0);
        }

    }

}
