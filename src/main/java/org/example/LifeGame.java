package org.example;

public class LifeGame {


    /* Glidder pattern method*/
    public void gliderPattern(int[][] grid, int size) {
        int mid = size / 2;
        grid[mid - 1][mid] = 1;
        grid[mid][mid + 1] = 1;
        grid[mid + 1][mid - 1] = 1;
        grid[mid + 1][mid] = 1;
        grid[mid + 1][mid + 1] = 1;
    }

    /* Calculating the next generation based on the rules given for the Life Game*/
    public int[][] calculateNextGeneration(int [][] grid, int size){
        int[][] newGrid = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int liveNeighborsCount = countNeighbors(grid, row, col, size);
                if (grid[row][col] == 1)
                {
                    newGrid[row][col] = (liveNeighborsCount == 2 || liveNeighborsCount == 3) ? 1 : 0;
//                    if (liveNeighbors == 2 || liveNeighbors == 3){
//                        newGrid[row][col] = 1;
//                    }
//                    else {
//                        newGrid[row][col] = 0;
//                    }
                }
                else
                {
                    //newGrid[row][col] = (liveNeighborsCount == 3) ? 1 : 0;
                    if (liveNeighborsCount == 3){
                        newGrid[row][col] = 1;
                    }
                    else {
                        newGrid[row][col] = 0;
                    }
                }
            }
        }
        return newGrid;
    }

    public int countNeighbors (int[][] grid, int row, int col, int size) {
        int count = 0;
        int[] directions = {-1, 0, 1};

        for (int directionRow : directions) {
            for (int directionColumn : directions) {
                if (!(directionRow == 0 && directionColumn == 0)) {
                    int newRow = row + directionRow;
                    int newCol = col + directionColumn;
                    if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                        count += grid[newRow][newCol];
                    }
                }
            }
        }
        return count;
    }

    public void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "■ " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
