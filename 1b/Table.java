/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-16.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Abstract arithmetic table.
 */
public abstract class Table {

    /**
     * Holds the table data.
     */
    protected float[][] data;

    /**
     * The start number.
     */
    protected int start;

    /**
     * The size of the table.
     */
    protected int size;

    /**
     * Constructs the table object.
     * @param start the start number
     * @param size the size of the table
     */
    protected Table(int start, int size) {
        this.start = start;
        this.size = size;
        this.data = new float[size][size];
    }

    /**
     * Abstract method to return the type of the table.
     * @return a string represents the type of the table.
     */
    abstract String tableType();

    /**
     * Prints out the table to the console.
     */
    public void display() {
        // Print the table type
        System.out.printf("%5s", tableType());

        // Print the column titles from start to end
        for (int col = 0; col < size; col++) {
            System.out.printf("%5d", start + col);
        }
        System.out.print("\n     ");

        // Print a line to separate the titles from the values
        for (int col = 0; col < size; col++) {
            System.out.print("-----");
        }
        System.out.println();

        // Print the table data
        for (int row = 0; row < size; row++) {
            // For each row, print the row title at the beginning
            System.out.printf("%3d |", start + row);

            // Print all column values for the current row
            for (int col = 0; col < size; col++) {
                System.out.printf("%5.0f", data[row][col]);
            }
            System.out.println();
        }
    }
}
