package game.scene;

import game.Background;
import game.GameObject;
import game.enemy.EnemySumoner;
import game.player.Player;

public class SceneStage1 extends Scene {
    @Override
    void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(EnemySumoner.class);
    }

    @Override
    void clear() {
        GameObject.clearAll();

    }
}
