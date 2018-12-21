package game.enemy;
import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.player.Player;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics{
    BoxCollider boxCollider;
    public EnemyBullet(){
        super();
        this.createRenderer();
        this.velocity.set(0, 3);
        this.boxCollider = new BoxCollider(this.position,this.anchor,5,5);
    }

    private void createRenderer() {
        ArrayList<BufferedImage>images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/green.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/red.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/white.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y > 600) this.destroy();
        this.checkIntersect();
    }

    private void checkIntersect() {
        Player player = GameObject.findIntersected(Player.class, this.boxCollider);
        if (player != null){
            this.destroy();
            player.destroy();
        }
    }

    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}