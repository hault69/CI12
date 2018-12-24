package game.enemy;

import game.FrameCounter;
import game.GameObject;

public class EnemySumoner extends GameObject {
    FrameCounter summonCounter;
    public EnemySumoner(){
        this.summonCounter = new FrameCounter(180);

    }

    @Override
    public void run() {
        super.run();
        if (this.summonCounter.run()){
            Enemy enemy = GameObject.recycle(Enemy.class);
            enemy.position.set(100,-3);
            summonCounter.reset();
        }
    }
}
