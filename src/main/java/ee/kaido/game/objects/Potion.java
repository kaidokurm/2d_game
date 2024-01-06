package ee.kaido.game.objects;

import static ee.kaido.game.main.Game.SCALE;

public class Potion extends GameObject {
    private float hoverOffset;
    private int maxHoverOffset, hoverDir = 1;

    public Potion(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;
        initHitbox(7, 14);
        xDrawOffset = (int) (3 * SCALE);
        yDrawOffset = (int) (2 * SCALE);
        maxHoverOffset = (int) (10 * SCALE);
    }

    public void update() {
        updateAnimationTick();
        updateHover();
    }

    private void updateHover() {
        hoverOffset += (0.075f * SCALE * hoverDir);

        if (hoverOffset >= maxHoverOffset)
            hoverDir = -1;
        else if (hoverOffset < 0)
            hoverDir = 1;
        hitbox.y = y + hoverOffset;
    }
}
