package ee.kaido.game;

import ee.kaido.game.main.Game;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new Game();
    }

}
