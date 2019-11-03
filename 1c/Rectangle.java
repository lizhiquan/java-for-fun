/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-24.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Represents a rectangle shape.
 */
public class Rectangle extends Shape {

    /**
     * Contructs a Rectangle object.
     * @param width the width of the shape
     * @param height the height of the shape
     */
    public Rectangle(final int width, final int height) {
        super(width, height, "r");

        // Setup the grid data
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                data[i][j] = '*';
            }
        }
    }
}
