/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-30.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Displays any shape using GUI application.
 */
public class GUIDisplayer implements Displayer {
    @Override
    public void displayShape(Shape shape) {
        DisplayerFrame.shape = shape;
        javafx.application.Application.launch(DisplayerFrame.class);
    }
}
