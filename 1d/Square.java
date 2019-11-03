/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-30.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Represents a square shape.
 */
public class Square extends Rectangle {

    /**
     * Contructs a Square object.
     * @param width the width of the shape
     */
    public Square(final int width, final int height) throws BadWidthException {
        super(width, width);
    }
}
