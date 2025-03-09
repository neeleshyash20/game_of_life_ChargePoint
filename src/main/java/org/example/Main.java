package org.example;


import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        int generations = 5;
        int size = 25;

        int[][] grid = new int[size][size];
        LifeGame lifeGame = new LifeGame();

        /* applying gliders pattern to initialize the grid with the values */
        lifeGame.gliderPattern(grid,size);

        for (int gen = 0; gen < generations; gen++) {

            System.out.println("The Generation for game :" + (gen+1) );
            /* Printing the grid */
            lifeGame.printGrid(grid);

            /* Calculating the generations of Life Game*/
            grid = lifeGame.calculateNextGeneration(grid, size);
        }
    }
}