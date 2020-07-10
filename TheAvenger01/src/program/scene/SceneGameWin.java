package program.scene;

import program.GameObject;

public class SceneGameWin extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundGameWin.class);
    }
    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
