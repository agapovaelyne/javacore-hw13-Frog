package frogGame;

public class FrogCommands {

    protected static FrogCommand jumpCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.jump(steps);
            }

            @Override
            public boolean undoCommand() {
                return frog.jump(steps * (-1));
            }
        };
    }
}
