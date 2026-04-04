public class PatternBlinker extends Pattern {
    boolean[][] blinker = {
            {true},
            {true},
            {true}
        };

    @Override
    public int getSizeX() {
        return blinker[0].length;
    }

    @Override
    public int getSizeY() {
        return blinker.length;
    }

    @Override
    public boolean getCell(int x, int y) {
        return blinker[y][x];
    }
}
