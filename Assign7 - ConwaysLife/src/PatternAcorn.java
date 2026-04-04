public class PatternAcorn extends Pattern {
    boolean[][] acorn = {
        {false, true, false, false, false, false, false},
        {false, false, false, true, false, false, false},
        {true, true, false, false, true, true, true} 
    };

    @Override
    public int getSizeX() {
        return acorn[0].length;
    }

    @Override
    public int getSizeY() {
        return acorn.length;
    }

    @Override
    public boolean getCell(int x, int y) {
        return acorn[y][x];
    }
}
