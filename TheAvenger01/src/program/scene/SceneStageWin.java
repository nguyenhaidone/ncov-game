package program.scene;

import program.GameObject;

public class SceneStageWin extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundStageWin.class);
    }
    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
