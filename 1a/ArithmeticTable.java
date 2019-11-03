/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-13.
 */
package ca.bcit.comp2526.assignment1;

/**
 * The program that prints out the multiplication or addition table
 * given the users start and end range and type of table.
 *
 * @author Vincent Le
 */
public class ArithmeticTable {

    // **************************************************
    // Fields
    // **************************************************

    /**
     * Holds the table data.
     */
    private float[][] data;

    /**
     * The start range.
     */
    private int start;

    /**
     * The end range.
     */
    private int end;

    /**
     * The type of the table.
     */
    private TableType tableType;

    /**
     * Represents table type.
     */
    private enum TableType {
        /** Add. */
        ADD("+"),
        /** Multiply. */
        MULT("*");

        /**
         * Holds the table label.
         */
        public final String label;

        /**
         * The constructor for the table type.
         */
        private TableType(String label) {
            this.label = label;
        }
    }

    // **************************************************
    // Public methods
    // **************************************************

    /**
     * Checks the command line arguments to see if they're valid.
     * @param args the array of arguments received from command line
     * @return the boolean value indicating whether the arguments are valid or not
     */
    public boolean argumentCheck(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if (args[0].charAt(0) == '+')
            tableType = TableType.ADD;
        else
            tableType = TableType.MULT;
        int sta;
        int sto;

        try {
            sta = Integer.parseInt(args[1]);
            sto = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException ex) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if ((sta < 1 || sta > 100) || ((sto < 1 || sto > 100))) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if (sta >= sto) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +,\"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        start = sta;
        end = sto;
        return true;
    }

    /**
     * Generates the table data from table type, begin, finish values.
     * @param begin start range
     * @param finish end range
     * @param tableType table type
     */
    public void createTable(int begin, int finish, TableType tableType) {
        // Initialize the table data
        int range = finish - begin + 1;
        data = new float[range][range];

        // Calculate the values based on the given table type
        for (int row = 0; row < range; row++)
            for (int col = 0; col < range; col++) {
                switch (tableType) {
                    case ADD:
                        data[row][col] = (row + begin) + (col + begin);
                        break;

                    case MULT:
                        data[row][col] = (row + begin) * (col + begin);
                        break;
                }
            }
    }

    /**
     * Prints out the table to the console.
     */
    public void printTable() {
        // Print the table type
        System.out.printf("%5s", tableType.label);

        // Print the column titles from start to end
        for (int col = 0; col < data.length; col++) {
            System.out.printf("%5d", start + col);
        }
        System.out.print("\n     ");

        // Print a line to separate the titles from the values
        for (int col = 0; col < data.length; col++) {
            System.out.print("-----");
        }
        System.out.println();

        // Print the table data
        for (int row = 0; row < data.length; row++) {
            // For each row, print the row title at the beginning
            System.out.printf("%3d |", start + row);

            // Print all column values for the current row
            for (int col = 0; col < data[row].length; col++) {
                System.out.printf("%5.0f", data[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ArithmeticTable table = new ArithmeticTable();
        if (table.argumentCheck(args)) {
            table.createTable(table.start, table.end, table.tableType);
            table.printTable();
        }
    }
}