/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-30.
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
     * Constructs the Shape object.
     * @param width the width of the grid
     * @param height the height of the grid
     */
    protected Shape(final int width, final int height) throws BadWidthException {
        this.data = new char[height][width];
        this.width = width;
        this.height = height;
    }

    /**
     * Getter for height.
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for width.
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the char at the given row and column.
     * @param row row
     * @param col column
     * @return character
     */
    public Character getCharAt(final int row, final int col) {
        return data[row][col];
    }
}
