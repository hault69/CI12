package game.enemy;

import game.FrameCounter;
import game.GameObject;
import game.GameObjectPhysics;
import game.Settings;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.player.PlayerBullet;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import game.renderer.Animation;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObjectPhysics {
    FrameCounter fireCounter;
    int hp;

    public Enemy() {
        super();
        this.position.set(0, -30);
        this.velocity.set(3, -1);
        this.createRenderer();
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
        this.fireCounter = new FrameCounter(30);
        this.hp = 3;
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
		this.renderer = new Animation(images);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.fire();
    }

    private void fire() {
        if(this.fireCounter.run()) {
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position);
            this.fireCounter.reset();
        }
    }

    private void move() {
        if(this.position.x > Settings.BACKGROUND_WIDTH - 14
                && this.velocity.x > 0) {
            this.velocity.set(-3, this.velocity.y);
        }
        if(this.position.x < 14 && this.velocity.x < 0) {
            this.velocity.set(3, this.velocity.y);
        }

        if(this.position.y > Settings.SCREEN_HEIGHT - 14
                && this.velocity.y > 0) {
            this.velocity.set(this.velocity.x, -1);
        }
        if(this.position.y < 14 && this.velocity.y < 0) {
            this.velocity.set(this.velocity.x, 1);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
    }

    @Override
    public void reset() {
        super.reset(); // active = true
        this.hp = 3;
    }
}
