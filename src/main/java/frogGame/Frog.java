package frogGame;

public class Frog {
    protected static final int MIN_POSITION = 0;
    protected static int MAX_POSITION = 10;

    protected int position;

    protected static String frogColouredSmallPicture = "\uD83D\uDC38";
    protected static String frogBlackAndWhiteSmallPicture = "\uD80C\uDD8F";
    protected static String frogBigPicture = "__________________________1¶¶1__111___________ \n" +
            "_________________________¶¶11¶¶1¶¶¶¶1_________ \n" +
            "________________________1¶¶¶¶1¶¶1¶¶1¶¶________ \n" +
            "_________________________¶¶¶¶1¶1¶_¶11¶¶¶______ \n" +
            "________________________1¶¶¶¶1¶¶¶1¶1¶¶1¶¶_____ \n" +
            "____________________1¶¶¶¶111111¶¶¶¶1111¶¶¶____ \n" +
            "_________________1¶¶¶1111111111111111111¶¶¶___ \n" +
            "_______________1¶¶¶¶111111111111111111111¶¶___ \n" +
            "_______________1¶¶¶_¶¶¶¶111111111111¶¶¶111¶1__ \n" +
            "__________________¶1_11¶¶¶111¶11¶¶¶¶¶11111¶¶__ \n" +
            "___________________¶____11¶¶¶¶¶¶111_111111¶¶1_ \n" +
            "_1__¶______________¶¶____________111111111¶¶¶_ \n" +
            "1¶_¶¶___________11¶¶¶¶¶¶1111111¶¶1111111111¶¶¶ \n" +
            "¶¶¶¶¶¶1_________¶¶11_1¶¶¶¶¶¶¶¶¶¶¶¶11111111111¶¶¶1_ \n" +
            "¶¶¶¶¶¶_______¶¶¶¶¶__1_____________111111¶111111¶¶_ \n" +
            "¶¶_11¶______¶1¶¶¶__111_11¶1¶¶¶¶1__111¶¶¶¶1111111¶_ \n" +
            "1¶11¶¶_____¶¶1¶¶__1____11¶¶¶11¶¶¶1___¶¶¶_1¶11111¶1 \n" +
            "_¶11¶¶______¶¶1__1_______1¶¶¶1111¶¶¶1¶1¶11¶¶1111¶¶ \n" +
            "_¶11¶1______¶1__111______1¶¶1¶¶¶¶1¶¶¶¶11¶¶¶¶11111¶ \n" +
            "_¶11¶_______¶1__1111111111______11¶¶1¶11¶¶1¶11111¶ \n" +
            "_¶¶_¶_______¶¶__1111111111111111___¶1_111_¶¶1111¶¶ \n" +
            "_¶¶_¶________¶¶__111111111111111111¶¶11111¶¶1111¶¶ \n" +
            "__¶_¶¶________¶¶1_1111111111111111_1¶11111¶11111¶¶ \n" +
            "__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1_11111111111111¶¶1¶1111¶¶_111¶¶¶ \n" +
            "___¶¶¶¶¶¶¶¶11¶¶¶¶¶¶¶¶11___111111¶¶¶¶¶1111¶¶111¶¶¶_ \n" +
            "___________________1¶¶¶¶¶¶¶111111111¶¶11¶¶1¶¶¶¶¶1_ \n" +
            "_____________________11¶¶¶¶¶¶¶¶¶¶1¶¶_1¶¶¶¶¶11_ \n" +
            "________________________________1¶111¶________";


    protected Frog() {
        position = 5;
    }

    protected int getPosition() {
        return position;
    }

    protected static void setMaxPosition(int maxPosition) {
        MAX_POSITION = maxPosition;
    }

    protected boolean jump(int steps) {
        int newPosition = position + steps;
        if (newPosition < MIN_POSITION || newPosition > MAX_POSITION) {
            return false;
        }
        position = newPosition;
        return true;
    }

    protected static String getBigPicture() {
        return frogBigPicture;
    }

    protected static String getFrogColouredSmallPicture() {
        return frogColouredSmallPicture;
    }

    protected static String getFrogBlackAndWhiteSmallPicture() {
        return frogBlackAndWhiteSmallPicture;
    }
}