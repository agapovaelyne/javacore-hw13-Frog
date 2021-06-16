import frogGame.FrogConsoleGame;
import frogGame.FrogGame;

public class Main {

    public static void main(String[] args) {
        FrogGame game = new FrogConsoleGame(15);
        game.run();
    }
}
