public class PatternGlider extends Pattern {

    boolean[][] glider = {
            {true, false, true},
            {false, true, true},
            {false, true, false}
        };
                                                      
    @Override
    public int getSizeX() {
        return glider[0].length;//assumes rectangular 2D array, does not check for ragged array
    }

    @Override
    public int getSizeY() {
        return glider.length;
    }

    @Override
    public boolean getCell(int x, int y) {
        return glider[y][x];
    }
}
