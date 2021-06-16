package frogGame;

public class FrogCommands {

    protected static FrogCommand jumpRightCommand(Frog frog, int steps) {
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

    protected static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doCommand() {
                return frog.jump(steps*(-1));
            }

            @Override
            public boolean undoCommand() {
                return frog.jump(steps);
            }
        };
    }
}
