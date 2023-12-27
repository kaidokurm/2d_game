package ee.kaido.game.window;

import ee.kaido.game.inputs.KeyboardInputs;
import ee.kaido.game.inputs.MouseInputs;
import ee.kaido.game.main.Game;

import javax.swing.*;
import java.awt.*;

import static ee.kaido.game.main.Game.GAME_HEIGHT;
import static ee.kaido.game.main.Game.GAME_WIDTH;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Sise : " + GAME_WIDTH + "," + GAME_HEIGHT);
    }


    public void updateGame() {

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        game.render(graphics);
    }

    public Game getGame() {
        return game;
    }
}
