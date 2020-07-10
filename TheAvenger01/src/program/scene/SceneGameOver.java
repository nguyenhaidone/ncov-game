package program.scene;

import program.GameObject;

public class SceneGameOver extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundGameOver.class);
    }
    @Override
    public void clear() {
        GameObject.clearAll();
    }

}
