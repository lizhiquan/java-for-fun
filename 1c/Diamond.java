/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-24.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Represents a diamond shape.
 */
public class Diamond extends Shape {

    /**
     * Contructs a Diamond object.
     * @param width the width of the shape
     * @param height the height of the shape
     * @throws BadWidthException throw if the given width is even
     */
    public Diamond(final int width, final int height) throws BadWidthException {
        super(width, width, "d");

        if (width % 2 == 0) {
            throw new BadWidthException();
        }

        // Setup the grid data
        for (int i = 0; i < this.height; i++) {
            final int temp = i > this.height / 2
                    ? this.height - 1 - i
                    : i;
            final int on = temp * 2 + 1;
            final int off = (this.width - on) / 2;

            int j = 0;
            for (int k = 0; k < off; k++, j++) {
                data[i][j] = ' ';
            }

            for (int k = 0; k < on; k++, j++) {
                data[i][j] = '#';
            }

            for (int k = 0; k < off; k++, j++) {
                data[i][j] = ' ';
            }
        }
    }
}
