package ee.kaido.game.ui;

import ee.kaido.game.gamestates.Gamestate;
import ee.kaido.game.gamestates.Playing;
import ee.kaido.game.utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static ee.kaido.game.main.Game.*;
import static ee.kaido.game.utilz.Constants.UI.URMButtons.URM_SIZE;

public class GameOverOverlay {
    private Playing playing;
    private BufferedImage img;
    private int imgX, imgY, imgW, imgH;
    private UrmButton menu, play;

    public GameOverOverlay(Playing playing) {
        this.playing = playing;
        createImg();
        createButtons();
    }

    private void createButtons() {
        int menuX = (int) (335 * SCALE);
        int playX = (int) (445 * SCALE);
        int y = (int) (195 * SCALE);
        play = new UrmButton(playX, y, URM_SIZE, URM_SIZE, 0);
        menu = new UrmButton(menuX, y, URM_SIZE, URM_SIZE, 2);

    }

    private void createImg() {
        img = LoadSave.GetSpriteAtlas(LoadSave.DEATH_SCREEN);
        imgW = (int) (img.getWidth() * SCALE);
        imgH = (int) (img.getHeight() * SCALE);
        imgX = GAME_WIDTH / 2 - imgW / 2;
        imgY = (int) (100 * SCALE);
    }

    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        g.drawImage(img, imgX, imgY, imgW, imgH, null);

        menu.draw(g);
        play.draw(g);
//        g.setColor(Color.WHITE);
//        g.drawString("GAME OVER", GAME_WIDTH / 2, 150);
//        g.drawString("Press esc to enter Main Menu!", GAME_WIDTH / 2, 300);
    }

    public void update() {
        menu.update();
        play.update();
    }

    private void gotToMenu() {
        playing.resetAll();
        playing.setGamestate(Gamestate.MENU);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gotToMenu();
        }
    }

    private boolean isIn(UrmButton b, MouseEvent e) {
        return b.getBounds().contains(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        play.setMouseOver(false);
        menu.setMouseOver(false);
        if (isIn(menu, e))
            menu.setMouseOver(true);
        if (isIn(play, e))
            play.setMouseOver(true);
    }

    public void mouseReleased(MouseEvent e) {
        if (isIn(menu, e)) {
            if (menu.isMousePressed()) {
                gotToMenu();
            }
        } else if (isIn(play, e))
            if (play.isMousePressed()) {
                playing.resetAll();
                playing.getGame().getAudioPlayer().setLevelSong(playing.getLevelManager().getLevelIndex());
            }
        menu.resetBools();
        play.resetBools();
    }

    public void mousePressed(MouseEvent e) {
        if (isIn(menu, e))
            menu.setMousePressed(true);
        else if (isIn(play, e))
            play.setMousePressed(true);

    }

}
