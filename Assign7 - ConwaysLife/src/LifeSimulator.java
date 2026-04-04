public class LifeSimulator {
    private boolean[][] grid;
    private boolean[][] newGrid;
    private int sizeX;
    private int sizeY;

    public LifeSimulator(int sizeY, int sizeX) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        grid = new boolean[sizeY][sizeX];
        newGrid = new boolean[sizeY][sizeX];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public boolean getCell(int y, int x) {
        return grid[y][x];
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        int patternSizeX = pattern.getSizeX();
        int patternSizeY = pattern.getSizeY();
        for (int row = 0; row < patternSizeY; row++) {
            for (int col = 0; col < patternSizeX; col++) {
                int patternY = startY + row;
                int patternX = startX + col;
                if (patternX >= 0 && patternX <= patternSizeX && patternY >= 0 && patternY <= patternSizeY)
                if (isOutOfBounds(patternY, patternX)) {
                    break;
                }
                grid[startY+row][startX+col] = pattern.getCell(patternSizeX, patternSizeY);
            }
        }
    }

    public void update() {
        int neighbours;
        for (int row = 0; row < this.sizeY; row++) {
            for (int col = 0; col < this.sizeX; col++) {
                neighbours = getNeighbors(row, col);

                boolean alive = grid[row][col];
                boolean underPopulationCase = alive && neighbours < 2;
                boolean overPopulationCase = alive && neighbours > 3;
                boolean revivedCase = !alive && neighbours == 3;
                boolean continuesCase = alive && (neighbours == 2 || neighbours == 3);

                if (underPopulationCase || overPopulationCase) {
                    newGrid[row][col] = false;
                } else if (revivedCase || continuesCase) {
                    newGrid[row][col] = true;
                }
            }
        }
        grid = newGrid;
    }

    private int getNeighbors(int row, int col) {
        int neighbours = 0;
        int[] topLeft = {row - 1, col - 1};
        int[] top = {row - 1, col};
        int[] topRight = {row - 1, col + 1};
        int[] left = {row, col - 1};
        int[] right = {row, col + 1};
        int[] bottomLeft = {row + 1, col - 1};
        int[] bottom = {row + 1, col};
        int[] bottomRight = {row + 1, col + 1};
        int[][] cellsToCheck = {topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight};
        for (int[] cell : cellsToCheck) {
            if (isOutOfBounds(cell[0], cell[1])) {
                continue;
            }
            if (grid[cell[0]][cell[1]]) {
                neighbours++;
            }
        }
        return neighbours;    
    }
    private boolean isOutOfBounds(int row, int col) {
        return (row < 0 || row >= this.sizeY || col < 0 || col >= this.sizeX);
    }
}
