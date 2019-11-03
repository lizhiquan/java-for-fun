/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-24.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Represents a shape.
 */
public class Shape {

    /**
     * Holds the grid data.
     */
    protected char[][] data;

    /**
     * The width of the grid.
     */
    protected int width;

    /**
     * The height of the grid.
     */
    protected int height;

    /**
     * The type of the shape.
     */
    protected String t;

    /**
     * Constructs the Shape object.
     * @param width the width of the grid
     * @param height the height of the grid
     * @param t the type of the shape ("t", "d", "r")
     */
    protected Shape(final int width, final int height, final String t) {
        this.data = new char[height][width];
        this.width = width;
        this.height = height;
        this.t = t;
    }

    /**
     * Prints out the shape to the console.
     */
    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }
}
