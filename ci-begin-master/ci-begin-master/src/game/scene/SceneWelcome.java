package game.scene;

import game.Background;
import game.GameObject;

public class SceneWelcome extends Scene {
    @Override
    void init() {
        BackgroundWelCome background = GameObject.recycle(BackgroundWelCome.class);
    }

    @Override
    void clear() {
        GameObject.clearAll();

    }
}
