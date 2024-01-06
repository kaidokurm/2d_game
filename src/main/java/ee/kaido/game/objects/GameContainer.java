package ee.kaido.game.objects;

import static ee.kaido.game.main.Game.SCALE;
import static ee.kaido.game.utilz.Constants.ObjectConstants.BOX;

public class GameContainer extends GameObject {
    public GameContainer(int x, int y, int objType) {
        super(x, y, objType);
        createHitbox();
    }

    private void createHitbox() {
        if (objType == BOX) {
            initHitbox(25, 18);
            xDrawOffset = (int) (7 * SCALE);
            yDrawOffset = (int) (12 * SCALE);
        } else {
            initHitbox(23, 25);
            xDrawOffset = (int) (8 * SCALE);
            yDrawOffset = (int) (5 * SCALE);
        }

        hitbox.y += yDrawOffset + (int) (SCALE * 2);
        hitbox.x += xDrawOffset / 2;

    }

    public void update() {
        if (doAnimation)
            updateAnimationTick();
    }
}
