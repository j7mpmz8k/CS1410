public class LifeSimulator {
    private boolean[][] grid;
    private boolean[][] newGrid;
    private int sizeX;
    private int sizeY;

    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        grid = new boolean[sizeY][sizeX];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public boolean getCell(int x, int y) {
        return grid[y][x];//checks if cell in grid is alive/dead
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        int patternSizeX = pattern.getSizeX();
        int patternSizeY = pattern.getSizeY();

        //loops through each cell in pattern
        for (int row = 0; row < patternSizeY; row++) {
            for (int col = 0; col < patternSizeX; col++) {
                //pattern is location on grid is top left of pattern array
                int patternY = startY + row;
                int patternX = startX + col;
                if (isOutOfBounds(patternY, patternX)) {
                    continue;
                }
                //adds only alive cells in pattern to grid
                grid[startY+row][startX+col] = pattern.getCell(col, row);
            }
        }
    }

    public void update() {
        int neighbors;
        
        //wipes newGrid for next buffer swap
        newGrid = new boolean[this.sizeY][this.sizeX];
        
        //checks conditions for each cell if will be alive/dead in new grid
        for (int row = 0; row < this.sizeY; row++) {
            for (int col = 0; col < this.sizeX; col++) {
                neighbors = getNeighbors(row, col);

                boolean alive = grid[row][col];
                boolean underPopulationCase = alive && neighbors < 2;
                boolean overPopulationCase = alive && neighbors > 3;
                boolean revivedCase = !alive && neighbors == 3;
                boolean continuesCase = alive && (neighbors == 2 || neighbors == 3);
                
                if (underPopulationCase || overPopulationCase) {
                    newGrid[row][col] = false;//dead cells in new grid
                } else if (revivedCase || continuesCase) {
                    newGrid[row][col] = true;//alive cells in new grid
                }
            }
        }
        grid = newGrid;//swaps new grid with current
    }

    private int getNeighbors(int row, int col) {
        int neighbors = 0;
        
        //checks all cells from top left to bottom right other than its own cell
        for (int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++) {
            for (int neighborCol = col - 1; neighborCol <= col + 1; neighborCol++) {
                
                if (neighborRow == row && neighborCol == col) {
                    continue;//skips if checking itself
                } else if (isOutOfBounds(neighborRow, neighborCol)) {
                    continue;//skips if outside of simulation
                } else if (grid[neighborRow][neighborCol]) {
                    neighbors++;//increments if neighbor is alive
                }
            }
        }
        
        return neighbors;    
    }
    private boolean isOutOfBounds(int row, int col) {
        return (row < 0 || row >= this.sizeY || col < 0 || col >= this.sizeX);
    }
}
