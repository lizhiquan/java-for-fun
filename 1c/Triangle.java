/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-24.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Represents a triangle shape.
 */
public class Triangle extends Shape {

    /**
     * Contructs a Triangle object.
     * @param width the width of the shape
     * @param height the height of the shape
     * @throws BadWidthException throw if the given width is even
     */
    public Triangle(final int width, final int height) throws BadWidthException {
        super(width, width / 2 + 1, "t");

        if (width % 2 == 0) {
            throw new BadWidthException();
        }

        // Setup the grid data
        for (int i = 0; i < this.height; i++) {
            final int on = i * 2 + 1;
            final int off = (this.width - on) / 2;

            int j = 0;
            for (int k = 0; k < off; k++, j++) {
                data[i][j] = ' ';
            }

            for (int k = 0; k < on; k++, j++) {
                data[i][j] = '@';
            }

            for (int k = 0; k < off; k++, j++) {
                data[i][j] = ' ';
            }
        }
    }
}
