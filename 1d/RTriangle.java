/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-30.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Represents a right angle rectangle shape.
 */
public class RTriangle extends Shape {
    /**
     * Contructs a RTriangle object.
     * @param width the width of the shape
     * @param height the height of the shape
     * @throws BadWidthException throw if the given width is even
     */
    public RTriangle(final int width, final int height) throws BadWidthException {
        super(width, width);

        // Setup the grid data
        for (int i = 0; i < this.height; i++) {
            final int on = i + 1;
            final int off = (this.width - on);

            int j = 0;
            for (int k = 0; k < off; k++, j++) {
                data[i][j] = ' ';
            }

            for (int k = 0; k < on; k++, j++) {
                data[i][j] = '@';
            }
        }
    }
}
