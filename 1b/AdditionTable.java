/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-16.
 */
package ca.bcit.comp2526.assignment1;

/**
 * Addition arithmetic table.
 */
public class AdditionTable extends Table {

    /**
     * Constructs the addition table object.
     * @param start start number
     * @param end end number
     */
    public AdditionTable(int start, int end) {
        super(start, end - start + 1);
        for (int row = 0; row < size; row++)
            for (int col = 0; col < size; col++)
                data[row][col] = (row + start) + (col + start);
    }

    protected String tableType() {
        return "+";
    }
}
