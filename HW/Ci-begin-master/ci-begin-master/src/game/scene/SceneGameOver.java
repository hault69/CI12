package game.scene;

import game.GameObject;

public class SceneGameOver extends Scene {
    @Override
    void init() {
        BackgroundGameOver backGround = GameObject.recycle(BackgroundGameOver.class);
    }

    @Override
    void clear() {
        GameObject.clearAll();
    }
}
