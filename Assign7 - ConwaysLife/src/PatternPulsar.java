public class PatternPulsar extends Pattern {
    boolean[][] pulsar = {
        {false, false, false, false, true, false, false, false, false, false, true, false, false, false, false},
        {false, false, false, false, true, false, false, false, false, false, true, false, false, false, false},
        {false, false, false, false, true, true, false, false, false, true, true, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {true, true, true, false, false, true, true, false, true, true, false, false, true, true, true},
        {false, false, true, false, true, false, true, false, true, false, true, false, true, false, false},
        {false, false, false, true, true, false, false, false, false, false, true, true, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, true, true, false, false, false, false, false, true, true, false, false, false},
        {false, false, true, false, true, false, true, false, true, false, true, false, true, false, false},
        {true, true, true, false, false, true, true, false, true, true, false, false, true, true, true},
        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, true, true, false, false, false, true, true, false, false, false, false},
        {false, false, false, false, true, false, false, false, false, false, true, false, false, false, false},
        {false, false, false, false, true, false, false, false, false, false, true, false, false, false, false}
    };

    @Override
    public int getSizeX() {
        return pulsar[0].length;//assumes rectangular 2D array, does not check for ragged array
    }

    @Override
    public int getSizeY() {
        return pulsar.length;
    }

    @Override
    public boolean getCell(int x, int y) {
        return pulsar[y][x];
    }
}
