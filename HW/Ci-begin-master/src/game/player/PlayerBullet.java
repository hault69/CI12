package game.player;

import game.GameObject;
import game.GameObjectPhysics;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObjectPhysics {

    public PlayerBullet() {
        super();
        this.createRenderer();
        this.velocity.set(0, -3);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new Animation(images);

    }

    @Override
    public void run() {
        super.run();
        if (this.position.y < -30) this.destroy();

        this.checkIntersect();
    }

    private void checkIntersect() {
        Enemy enemy = GameObject.findIntersected(Enemy.class, this.boxCollider);
        if (enemy != null) {
            this.destroy();
            enemy.destroy();
        }
    }
}
