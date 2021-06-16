package frogGame;

public class FrogConsoleGame extends FrogGame {

    public FrogConsoleGame() {
        super();
    }

    public FrogConsoleGame(int fieldSize) {
        super(fieldSize);
    }

    protected void printOut(String output) {
        System.out.print(output);
    }
}
