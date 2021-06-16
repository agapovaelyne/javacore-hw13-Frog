package frogGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class FrogGame {
    protected Frog frog = new Frog();
    protected int fieldSize = 11;
    protected List<FrogCommand> commands = new ArrayList<>();
    protected int curCommand = -1;

    protected static String jumpRightCommandText = "+N";
    protected static String jumpLeftCommandText = "-N";
    protected static String undoCommandText = "Undo";
    protected static String redoCommandText = "Redo";
    protected static String repeatCommandText = "!!";
    protected static String exitCommandText = "0";

    public FrogGame() {
    }

    public FrogGame(int fieldSize) {
        this.fieldSize = fieldSize;
        frog.setMaxPosition(fieldSize - 1);
    }

    protected static String getCommandsList() {
        return String.format("Для перемещения лягушки выберите одну из команд:\n1. %s - прыгнyть на N шагов направо\n2. %s - прыгнуть на N шагов налево\n3. %s - отменить последнюю команду\n4. %s - повторить отменённую команду\n5. %s - повторить последнюю команду\n6. %s - выход",
                jumpRightCommandText, jumpLeftCommandText, undoCommandText, redoCommandText, repeatCommandText, exitCommandText);
    }

    protected String getField() {
        StringBuilder field = new StringBuilder();
        field.append("Текущее положение лягушки на поле:\n");
        for (int i = 0; i < fieldSize; i++) {
            if (i != frog.getPosition()) {
                field.append("◦ ");
            } else {
                field.append(Frog.getFrogColouredSmallPicture() + " ");
            }
        }
        field.append("\n");
        return field.toString();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        printOut(Frog.getBigPicture());
        printOut(String.format("\n_____________Программа \"Лягушка\" %s___________\n", Frog.getFrogBlackAndWhiteSmallPicture()));
        printOut(getField());
        printOut(getCommandsList());

        while (true) {
            printOut("\nВведите команду для лягушки: ");
            String command = scanner.nextLine().replace(" ", "");

            if (command.equals(exitCommandText)) {
                break;
            }

            if (command.equals(undoCommandText)) {
                if (curCommand < 0) {
                    printOut("Нечего отменять! " + Frog.getFrogBlackAndWhiteSmallPicture());
                } else {
                    commands.get(curCommand).undoCommand();
                    curCommand--;
                }
            } else if (command.equals(redoCommandText)) {
                if (curCommand == commands.size() - 1) {
                    printOut("Нечего отменять! " + Frog.getFrogBlackAndWhiteSmallPicture());
                } else {
                    curCommand++;
                    commands.get(curCommand).doCommand();
                }
            } else {
                if (curCommand != commands.size() - 1) {
                    while (curCommand != commands.size() - 1) {
                        commands.remove(commands.size() - 1);
                    }
                }

                FrogCommand cmd = null;
                if (command.equals(repeatCommandText)) {
                    cmd = commands.get(curCommand);
                } else {
                    if (!(command.charAt(0) == jumpRightCommandText.charAt(0) || command.charAt(0) == jumpLeftCommandText.charAt(0))) {
                        printOut(String.format("Некорректный формат команды! %s\n", Frog.getFrogBlackAndWhiteSmallPicture()));
                        continue;
                    }
                    try {
                        int n = Integer.parseInt(command);
                        if (n == 0) {
                            printOut("Прыжок не сделан! ");
                            continue;
                        }
                        cmd = n > 0 ? FrogCommands.jumpRightCommand(frog, n) : FrogCommands.jumpLeftCommand(frog, Math.abs(n));
                    } catch (NumberFormatException e) {
                        printOut(String.format("Некорректный формат команды! %s\n", Frog.getFrogBlackAndWhiteSmallPicture()));
                        continue;
                    }
                }

                if (cmd.doCommand()) {
                    curCommand++;
                    commands.add(cmd);
                } else {
                    printOut(String.format("Прыжок не возможен - не хватает размеров поля! %s\n", Frog.getFrogBlackAndWhiteSmallPicture()));
                }
            }
            printOut(getField());
            printOut("\n");
        }
        printOut("\nСпасибо за игру\nДо скорых встреч! " + Frog.getFrogBlackAndWhiteSmallPicture());
        scanner.close();
    }

    protected abstract void printOut(String output);
}
