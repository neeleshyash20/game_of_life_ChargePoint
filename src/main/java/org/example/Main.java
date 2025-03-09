package org.example;


import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        int generations = 5;
        int size = 25;

        int[][] grid = new int[size][size];
        LifeGame lifeGame = new LifeGame();

        lifeGame.gliderPattern(grid,size);

        for (int gen = 0; gen < generations; gen++) {
            System.out.println("Generations for simulation: " + (gen + 1));
            lifeGame.printGrid(grid);
            grid = lifeGame.calculateNextGeneration(grid, size);
        }
    }
}