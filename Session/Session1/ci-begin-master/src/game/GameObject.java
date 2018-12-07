package game;

import game.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    //xác định giới hạn truy cập (public,private,protected,default)
    public Renderer renderer;
    public Vector2D position;
    public GameObject(){
//        this.image
        this.position = new Vector2D(0,0);
    }

    public void run(){

    }
    public void render(Graphics g){
        if (this.renderer != null){
            this.renderer.render(g,this);
        }
    }
}
