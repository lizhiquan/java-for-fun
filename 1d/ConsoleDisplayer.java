/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-30.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Displays any shape using GUI application.
 */
public class ConsoleDisplayer implements Displayer {
    @Override
    public void displayShape(Shape shape) {
        for (int i = 0; i < shape.getHeight(); i++) {
            for (int j = 0; j < shape.getWidth(); j++) {
                System.out.print(shape.getCharAt(i, j));
            }
            System.out.println();
        }
    }
}
