public class PatternBlock extends Pattern {

    boolean[][] block = {
            {true, true},
            {true, true}
        };

    @Override
    public int getSizeX() {
        return block[0].length;
    }

    @Override
    public int getSizeY() {
        return block.length;
    }

    @Override
    public boolean getCell(int x, int y) {
        return block[y][x];
    }
}
